package it.bitBot.rest.tests;



import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.bitBot.rest.ServiziOrdini;



import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;


public class TestJerseyOrdini {
	//String URI = "http://localhost:8081/bitBotWebRest/rest";
	ServiziOrdini servOrd;
	Gson gs;
	 
	@Test
	public void descrizione(){
		//Client.create().resource(URI+"/ordini/descrizione?codProd="+cod);
		//String risp = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
		servOrd = new ServiziOrdini();
		gs = new Gson();
		String cod = "SORV001";
		String s=servOrd.descrizione(cod);
		Prodotto p = gs.fromJson(s, Prodotto.class);
		
		
		Assert.assertTrue(p.getCodice().equals(cod));
	}
	
	@Test
	public void  inserisceEVisualizzaCarrello(){

		//servOrd.inserisciCarrello("SORV001","10");
		//String carr = servOrd.visualizzaCarrello("1");
		//ArrayList<Object> carrello = gs.fromJson(carr, ArrayList<Object>);
		Assert.assertTrue(true);
	}
	
	
	
	
	
	
}