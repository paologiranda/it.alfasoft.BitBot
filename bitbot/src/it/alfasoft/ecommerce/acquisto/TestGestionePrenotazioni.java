package it.alfasoft.ecommerce.acquisto;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import it.alfasoft.ecommerce.acquisto.dto.Prenotazione;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.test.SpringTest;


public class TestGestionePrenotazioni  extends SpringTest<GestionePrenotazioni> {
	GestionePrenotazioni gp= getBean("boGestionePrenotazioni");
	int idCliente = 1;
	
	@Test
	public void testInseriscePrenotazione() throws ErroreSistema {
		
		Prenotazione prenotazione = new Prenotazione("AUTO002",2,50);
		Assert.assertTrue(gp.inseriscePrenotazione(prenotazione)==1);
		List<Prenotazione> listaprenotazioni = gp.getPrenotazioni(2);
		Assert.assertNotNull(listaprenotazioni);
		if(listaprenotazioni!=null){
			int idPrenotazione = listaprenotazioni.get(listaprenotazioni.size()-1).getCodPrenotazione();
			Assert.assertNotNull(gp.getPrenotazione(idPrenotazione));
		}
	}
	
	@Test
	public void testEliminaPrenotazione() throws ErroreSistema{
		Prenotazione prenotazione = new Prenotazione("AUTO002",2,50);
		gp.inseriscePrenotazione(prenotazione);
		List<Prenotazione> listaprenotazioni = gp.getPrenotazioni(2);
		int idPrenotazione=-1;
		if(listaprenotazioni!=null){
			idPrenotazione = listaprenotazioni.get(listaprenotazioni.size()-1).getCodPrenotazione();
		}
		if(idPrenotazione>0){
			Assert.assertTrue(gp.eliminaPrenotazione(idPrenotazione)==1);
		}
		else
			Assert.assertNull(listaprenotazioni);
	}
	
}
