package it.alfasoft.ecommerce.clienti.test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.alfasoft.ecommerce.clienti.bo.GeneraMailConferma;
import it.alfasoft.ecommerce.clienti.bo.GestioneClienti;
import it.alfasoft.ecommerce.clienti.dao.AziendaDaoDto;
import it.alfasoft.ecommerce.clienti.dao.ClienteDaoDto;
import it.alfasoft.ecommerce.clienti.dao.DaoClienti;
import it.alfasoft.ecommerce.clienti.dao.IDaoGestioneClienti;
import it.alfasoft.ecommerce.clienti.dao.PrivatoDaoDto;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.DatabaseNonTrovato;
import it.alfasoft.ecommerce.test.SpringTest;
import oracle.net.ns.NetException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientiDaoTest extends SpringTest<DaoClienti> {
	GestioneClienti gest;
	DaoClienti dao;
	Random rd=new Random();
	String piva="";
	String cf="";
	String emailPrivato="";
	String emailAzienda="";
	
	
	public ClientiDaoTest() {
		super();
		//gest= getBean("clienti");
		dao= getBean("daoClienti");
		// TODO Auto-generated constructor stub
	}
	@Test 
	public void azienda() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente, DatabaseNonTrovato, NetException {
		piva+=rd.nextInt(23000);
		emailAzienda+="abc"+rd.nextInt(10000)+"@gmail.com";
		AziendaDaoDto a=new AziendaDaoDto("Pippo srl", piva, "1234567", "asdfc123",emailAzienda,"corso svizzera 185",
				10100, "b", 3, "TO", "Italia", "Torino");
		Assert.assertTrue(dao.aggiungiCliente(a)>0);
		emailConferma(emailAzienda);
	}
	@Test
	public void privato() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente, DatabaseNonTrovato, NetException {
		cf+="VDGRRT"+rd.nextInt(100)+"I"+rd.nextInt(1000)+"G";
		emailPrivato+="abc"+rd.nextInt(10000)+"@gmail.com";
		PrivatoDaoDto a=new PrivatoDaoDto("Roberto","Vaudagna",cf, "1234567", "asdfc123",emailPrivato,
				"corso svizzera 185", 10100, "b", 3, "TO", "Italia", "Torino");
	
		Assert.assertTrue(dao.aggiungiCliente(a)>0);
		emailConferma(emailPrivato);
	}
	public void emailConferma(String email2) throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente, DatabaseNonTrovato, NetException {
		Assert.assertTrue(dao.attivaCliente(dao.controlloAttivazione(email2, GeneraMailConferma.getCodice()))==1);
	}
	@Test
	public void cercaAzienda() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente, DatabaseNonTrovato, NetException {
		
		azienda();
		List <ClienteDaoDto> clientiTrovati = dao.cercaAzienda(piva);
		Assert.assertNotNull(clientiTrovati);
		Assert.assertTrue(clientiTrovati.size()>0);
	
	}
	@Test
	public void cercaPrivato() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente, DatabaseNonTrovato, NetException {
		privato();
		List <ClienteDaoDto> clientiTrovati = dao.cercaPrivato(cf);
		Assert.assertNotNull(clientiTrovati);
		Assert.assertTrue(clientiTrovati.size()>0);
	
	}
	
	@Test
	public void testaLista() throws ClassNotFoundException, SQLException {
		List <ClienteDaoDto> clientiTrovati = dao.listaClienti();
		Assert.assertNotNull(clientiTrovati);
		Assert.assertTrue(clientiTrovati.size()>0);
	}
	@Test
	public void cercaCliente() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente {
		ClienteDaoDto c=privatofisso();
		int codClienteTrovato = dao.cercaCliente(c.getMail());
		System.out.println("CODICE " + codClienteTrovato);
		Assert.assertTrue(codClienteTrovato!=0);
		Assert.assertTrue(dao.eliminaCliente(c.getMail())==1);
}
	public ClienteDaoDto privatofisso() throws ClassNotFoundException, ClienteGiaRegistrato, SQLException, ClienteInesistente {
		cf+="VDGRRT102I750G";
		PrivatoDaoDto a=new PrivatoDaoDto("Roberto","Vaudagna",cf, "1234567", "asdfc123","def@gmail.com",
				"corso svizzera 185", 10100, "b", 3, "TO", "Italia", "Torino");
		

		dao.aggiungiCliente(a);
		return a;
	}
	
}
