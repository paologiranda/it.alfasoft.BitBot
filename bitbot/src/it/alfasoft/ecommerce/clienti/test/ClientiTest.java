package it.alfasoft.ecommerce.clienti.test;

import org.junit.Test;
import org.junit.Assert;

import it.alfasoft.ecommerce.clienti.bo.CategoriaCliente;
import it.alfasoft.ecommerce.clienti.bo.CategoriaVia;
import it.alfasoft.ecommerce.clienti.bo.ClientiMock;
import it.alfasoft.ecommerce.clienti.bo.IGestioneClientiService;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;

public class ClientiTest {
	static ClientiMock prova= new ClientiMock();
	@Test
	public void test() throws ClienteInesistente, ClienteGiaRegistrato {
//
		prova.aggiungiCliente( "Roby", "Vaud", "VDDRBB52253", CategoriaCliente.Privato, "011123",
		 "ppp@pp.com", "Italia", "Torino", "TO", 4,null, CategoriaVia.corso, "Trapani", 10100, "9", "provapass");
	prova.aggiungiCliente( "fab", "f","FBBFADB2352", CategoriaCliente.Privato, "542",
		 "ppp@p3p.com", "Italia", "Torino", "TO", 4,null, CategoriaVia.corso, "Trapani", 10100, "9", "provapass");
			
		 
		Assert.assertNotNull(prova.cercaCliente(2));
		Assert.assertTrue(prova.emailConferma(2)); 

		
		
	}
	 
	 

}
