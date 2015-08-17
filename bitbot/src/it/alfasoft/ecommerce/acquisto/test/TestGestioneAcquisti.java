package it.alfasoft.ecommerce.acquisto.test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.alfasoft.ecommerce.acquisto.IDAOOrdine;
import it.alfasoft.ecommerce.acquisto.IDAOPrenotazioni;
import it.alfasoft.ecommerce.acquisto.IDAOProdottiOrdinati;
import it.alfasoft.ecommerce.acquisto.DAO.ADao;
import it.alfasoft.ecommerce.acquisto.DAO.DAOOrdine;
import it.alfasoft.ecommerce.acquisto.DAO.DAOPrenotazioni;
import it.alfasoft.ecommerce.acquisto.DAO.DAOProdottiOrdinati;
import it.alfasoft.ecommerce.acquisto.dto.Ordine;
import it.alfasoft.ecommerce.acquisto.dto.Prenotazione;
import it.alfasoft.ecommerce.acquisto.dto.ProdottoOrdinato;
import it.alfasoft.ecommerce.acquisto.dto.StatoOrdine;
import it.alfasoft.ecommerce.test.SpringTest;

import org.junit.Assert;
import org.junit.Test;
public class TestGestioneAcquisti extends SpringTest{
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	ProdottoOrdinato prodotto= new ProdottoOrdinato("2", 25, 66, 0,0);
	final static int idCliente= 799;
	final static int idOrdinato=8;
	private static final int ArrayList = 0;
	private DAOProdottiOrdinati daoTest;
	private IDAOOrdine ordine_test;
	private DAOPrenotazioni pippo,pren;
	
	@Test
	public void testCreazioneOrdine() throws ClassNotFoundException, SQLException{ //Test creazione prodotti Ordinati
//		IDAOProdottiOrdinati DAOTest = new DAOProdottiOrdinati();
		daoTest=(DAOProdottiOrdinati) getBean("daoProdottiOrdinati");
		Assert.assertTrue((daoTest.creaProdottiOrdinati(prodotto, idOrdinato))>0);
		daoTest.deleteProdottiOrdinati(idOrdinato); 
	}
	@Test
	public void testletturaProdotti() throws ClassNotFoundException, SQLException{
		//IDAOProdottiOrdinati DAOTest = new DAOProdottiOrdinati();
		daoTest=(DAOProdottiOrdinati) getBean("daoProdottiOrdinati");
		daoTest.creaProdottiOrdinati(prodotto, idOrdinato);
		Assert.assertNotNull(daoTest.readProdottiOrdinati(idOrdinato));   //Leggi prodotti ordinati di un determinato ordine
		daoTest.deleteProdottiOrdinati(idOrdinato); 
	}
	
	@Test
	public void testDAOOrdini() throws ClassNotFoundException{
		//IDAOOrdine ordine_test=new DAOOrdine();
		ordine_test=(IDAOOrdine) getBean("daoOrdine");
		Calendar data=new GregorianCalendar();
		StatoOrdine stato=null;
		Ordine ordine=new Ordine(idCliente, data.getInstance(), stato.temporaneo);
		try {
			Assert.assertTrue(ordine_test.creaOrdine(ordine)>0);   //Test Creazione Ordini
			Assert.assertNotNull(ordine_test.getIdOrdineDb(ordine.getIdCliente()));
			Assert.assertNotNull(ordine_test.leggiOrdine(idCliente));
			Assert.assertTrue(ordine_test.updateStatoOrdine(StatoOrdine.confermato,ordine_test.getIdOrdineDb(idCliente))>0);
			Assert.assertFalse(ordine_test.updateStatoOrdine(StatoOrdine.confermato,ordine_test.getIdOrdineDb(idCliente))<=0);
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}
	
	 @Test
	 public void testInseriscePrenotazione() throws SQLException, ClassNotFoundException{
		 Prenotazione p = new Prenotazione("AUTO001",2,1);
//		 DAOPrenotazioni pippo = new DAOPrenotazioni();
		 pippo=(DAOPrenotazioni) getBean("daoPrenotazioni");
		 
		 Assert.assertTrue(pippo.inseriscePrenotazione(p)==1);
	  }
	 @Test
	 public void testPrendiPrenotazioni() throws ClassNotFoundException, SQLException {
//		 AOPrenotazioni pren = new DAOPrenotazioni();
		 pren = (DAOPrenotazioni) getBean("daoPrenotazioni");
		 List<Object>risp = pren.prendiPrenotazioni(2);
		 Assert.assertTrue(risp!=null);
	 }
	 
	 @Test
	 public void testPrendiPrenotazione() throws ClassNotFoundException, SQLException{
//		 IDAOPrenotazioni pren = new DAOPrenotazioni();
		 pren = (DAOPrenotazioni) getBean("daoPrenotazioni");
		 List<Object>risp = pren.prendiPrenotazioni(2);
		 Prenotazione pre = (Prenotazione) risp.get(0);
		 Prenotazione preno = pren.prendiPrenotazione(pre.getCodPrenotazione());
		 Assert.assertTrue(preno!=null);
	 }
	 
	 @Test
	 public void testCancellaPrenotazione() throws ClassNotFoundException, SQLException{
//		 IDAOPrenotazioni pren = new DAOPrenotazioni();
		 pren = (DAOPrenotazioni) getBean("daoPrenotazioni");
		 Prenotazione p = new Prenotazione("AUTO001",2,1);
		 pren.inseriscePrenotazione(p);
		 List<Object>risp = pren.prendiPrenotazioni(2);
		 Prenotazione pre = (Prenotazione) risp.get(0);
		 int numeroprenotazione = pre.getCodPrenotazione();
		 Assert.assertTrue(pren.deletePrenotazione(numeroprenotazione)==1);
	 }

}
