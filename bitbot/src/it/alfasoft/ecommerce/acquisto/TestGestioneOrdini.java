package it.alfasoft.ecommerce.acquisto;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.alfasoft.ecommerce.acquisto.dto.ProdottoOrdinato;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.test.SpringTest;


public class TestGestioneOrdini extends SpringTest<GestioneOrdini> {
	@Test
	public void testAcquisto() throws ErroreSistema, ClassNotFoundException{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "boOrdini.xml" });
//		GestioneOrdini gs = (GestioneOrdini) ctx.getBean("boGestioneOrdini");
	    GestioneOrdini gs= getBean("boGestioneOrdini");
		ArrayList<ProdottoOrdinato> prodotti = new ArrayList<ProdottoOrdinato>();
		ProdottoOrdinato p1 = new ProdottoOrdinato("luza",4, 0, 10, 0);
		ProdottoOrdinato p2 = new ProdottoOrdinato("luis",1, 0, 10, 0);
		ProdottoOrdinato p3 = new ProdottoOrdinato("michele",5, 0, 10, 0);
		prodotti.add(p1);
		prodotti.add(p2);
		prodotti.add(p3);
		
		double resultAcquisto = gs.acquisto(prodotti, "C1");
		
		if(resultAcquisto!=100){
			System.out.println("righe modificate: "+resultAcquisto);
			Assert.assertTrue(false);
		}
	} 
//	@Test
//	public void testConvertiProdotti(){
//		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
//		Prodotto p1 = new Prodotto(Categoria.Informatica,SottoCategoria.Sicurezza,Tipo.Prodotto,"ISIC001","SchedaMadre","",false,100);
//		Prodotto p2 = new Prodotto(Categoria.Elettronica,SottoCategoria.Sicurezza,Tipo.Prodotto,"ESIC001","Telecamera","",false,230);
//		Prodotto p3 = new Prodotto(Categoria.Informatica,SottoCategoria.Sicurezza,Tipo.Prodotto,"ISIC001","SchedaMadre","",false,100);
//		prodotti.add(p1);
//		prodotti.add(p2);
//		prodotti.add(p3);
//		GestioneOrdini gs = new GestioneOrdini();
//		ArrayList<ProdottoOrdinato> prodottiOrdinati = new ArrayList<ProdottoOrdinato>();
//		prodottiOrdinati = gs.convertiProdotti(prodotti);
//		if(prodottiOrdinati.size()!=2){
//			System.out.println(prodottiOrdinati.size());
//			Assert.assertTrue(false);
//		}
//		for(ProdottoOrdinato pO : prodottiOrdinati){
//			System.out.println(pO.getCodiceProdotto()+" "+pO.getQtaOrdinata()+" "+pO.getPrezzo());
//		}
//	}
	
}
