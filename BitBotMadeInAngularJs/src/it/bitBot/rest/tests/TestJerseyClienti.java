package it.bitBot.rest.tests;

import it.alfasoft.ecommerce.clienti.bo.Cliente;
import it.alfasoft.ecommerce.clienti.bo.Privato;
import it.alfasoft.ecommerce.clienti.exception.CfGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaAttivato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.CodiceConfermaErrato;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.bitBot.rest.Registrazione;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TestJerseyClienti {
	String URI = "http://localhost:8081/bitBotWebRest/rest";
	Registrazione r = new Registrazione(); 
	Gson g = new Gson();
	
	@Test
	public void testElencoClienti() {
		WebResource resource = Client.create().resource(URI + "/registrazione/listaClienti");
		String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	
	@Test
	public void testElencoAziende() {
		WebResource resource = Client.create().resource(URI + "/registrazione/listaAziende");

		String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	@Test
	public void testElencoPrivati() {
		WebResource resource = Client.create().resource(URI + "/registrazione/listaPrivati");

		String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	@Test
	public void testTipoVia() {
		WebResource resource = Client.create().resource(URI + "/registrazione/tipovia");

		String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	@Test
	public void TestRindirizza() {
		WebResource resource = Client.create().resource(URI + "/registrazione/rindirizza?scelta=registraAzienda");

		String risp = resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	@Test
	public void TestSceltaCliente() {
		WebResource resource = Client.create().resource(URI + "/registrazione/sceltacliente?scelta=AZIENDA");

		String risp = resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		Assert.assertTrue(!risp.isEmpty());
	}
	
	
	@Test
	public void TestRegistraPrivato() throws CfGiaRegistrato, ErroreSistema, TabellaNonTrovata {
		boolean eccCliPrivRegLanc = false;
		r = new Registrazione();
		g = new Gson();
	
			
			//List<Cliente> clienti= g.fromJson(r.listaClienti(), new TypeToken<ArrayList<Cliente>> () {}.getType());
		r.listaPrivati();
		ArrayList<Cliente> clienti= g.fromJson(r.listaPrivati(), ArrayList.class);
			
		Privato c = (Privato) clienti.get(0);
			
			try {
				r.aggiungiPrivato(c.getNome(), c.getCodiceConferma(), c.getCodiceFiscale(), c.getTelefono(), (c.getVia()).toString() , c.getNomeVia(), c.getNumeroCivico(), c.getScala(), c.getPiano() , c.getCitta(), c.getProvincia(), c.getCap() , c.getPaese() , c.getEmail(), c.getPassword());
			} catch (ClienteGiaRegistrato e) {
				// TODO Auto-generated catch block
				eccCliPrivRegLanc = true;
			}
		
		Assert.assertTrue(eccCliPrivRegLanc);
	}
	
	
	/*
	@Test
	public void TestAggiungiAzienda() throws CfGiaRegistrato, ErroreSistema, TabellaNonTrovata {
		boolean eccezioneLanciata = false;
		r = new Registrazione();
		g = new Gson();
	
			
			List<Cliente> clienti= g.fromJson(r.listaClienti(), ArrayList.class);
			Azienda c = (Azienda) clienti.get(0);
			
			
				try {
					r.aggiungiAzienda(c.getpIva(), c.getRagioneSociale(), c.getTelefono(), (c.getVia()).toString(),c.getNomeVia(), c.getNumeroCivico(), c.getScala(),  c.getPiano() , c.getCitta(), c.getProvincia(), c.getCap() , c.getPaese() , c.getEmail(), c.getPassword());
				} catch (ClienteGiaRegistrato e) {
					
				} catch (PivaGiaRegistrata e) {
					eccezioneLanciata = true;
				}
		Assert.assertTrue(eccezioneLanciata);
	}

	*/
	
	
	
	
	/*
	@Test
	public void TestAttivazione() throws ClienteInesistente, ErroreSistema, CodiceConfermaErrato {
		boolean eccCliPrivRegLanc = false;
		r = new Registrazione();
		g = new Gson();
	
			
			List<Cliente> clienti= g.fromJson(r.listaClienti(), ArrayList.class);
			Privato c = (Privato) clienti.get(0);
			
				
				try {
					r.attivazione(c.getEmail(), c.getCodiceConferma());
				} catch ( ClienteGiaAttivato e) {
					eccCliPrivRegLanc = true;
				}
			
		
		Assert.assertTrue(eccCliPrivRegLanc);
	
	}
	*/
	


	
}
