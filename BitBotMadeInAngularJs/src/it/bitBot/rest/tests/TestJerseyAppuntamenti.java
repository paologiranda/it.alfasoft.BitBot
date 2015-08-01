package it.bitBot.rest.tests;


import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TestJerseyAppuntamenti {
	String URI = "http://localhost:8081/bitBotWebRest/rest";
	
	@Test
	public void aggiungiapp() {
		String app="idCliente=1&anno=2015&mese=5&giorno=5&ora=11&descr=ciao";
		Client.create().resource(URI+"/appuntamenti/aggiungiapp?"+app);
		WebResource resource = Client.create().resource(URI+"/appuntamenti/stampaapp");
		
		String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertTrue(true);
	}

}
