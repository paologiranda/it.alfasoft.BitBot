package it.alfasoft.ecommerce.acquisto;


import it.alfasoft.ecommerce.acquisto.DAO.DAOOrdine;
import it.alfasoft.ecommerce.acquisto.DAO.DAOProdottiOrdinati;
import it.alfasoft.ecommerce.acquisto.dto.Ordine;
import it.alfasoft.ecommerce.acquisto.dto.ProdottoOrdinato;
import it.alfasoft.ecommerce.acquisto.dto.StatoOrdine;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.integration.dto.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class GestioneOrdini implements IGestioneOrdini{
	
	private IDAOOrdine daoOrdine;
	private IDAOProdottiOrdinati daoProdottiOrdinati;

	
	@Override
	public double acquisto(ArrayList<ProdottoOrdinato> prodottiOrdinati, String codUser) throws ErroreSistema, ClassNotFoundException {
		double importo=0;
		try {
			if (prodottiOrdinati.size() == 0) {
				System.out.println("Nessun prodotto nel carrello.");
				return 0;
			}
			// creazione dell'oggetto Ordine
			int codCliente = Integer.parseInt(codUser.substring(1));
			Ordine ordine = new Ordine(codCliente, Calendar.getInstance(),
					StatoOrdine.temporaneo);

			// salvataggio dell'ordine nel DB
			//setDaoOrdine(daoOrdine);
			daoOrdine = new DAOOrdine();
			daoOrdine.creaOrdine(ordine);
			int idOrdine = daoOrdine.getIdOrdineDb(codCliente);
			// conversione dei prodotti in prodottiOrdinati
			for (ProdottoOrdinato pO : prodottiOrdinati) {
//				setDaoProdottiOrdinati(daoProdottiOrdinati);
				daoProdottiOrdinati = new DAOProdottiOrdinati();
				daoProdottiOrdinati.creaProdottiOrdinati(pO, idOrdine);
				importo += pO.getPrezzo()*pO.getQtaOrdinata();
			}
			return importo;
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
		System.out.println(sqle.getSQLState());	
		throw new ErroreSistema("Non so che cacchio fare",sqle);
		}
	}
	
	@Override
	public ArrayList<ProdottoOrdinato> convertiProdotti(ArrayList<Prodotto> prodotti) {
		ArrayList<ProdottoOrdinato> prodottiOrdinati = new ArrayList<ProdottoOrdinato>();

		for (Prodotto p : prodotti) {
			ProdottoOrdinato foundProduct = searchProduct(prodottiOrdinati, p);
			if (foundProduct != null) {
				foundProduct.setQtaOrdinata(foundProduct.getQtaOrdinata() + 1);
			} else {
				prodottiOrdinati.add(getDefaultProduct(p));
			}
		}
		return prodottiOrdinati;
	}

	private ProdottoOrdinato getDefaultProduct(Prodotto p) {
		ProdottoOrdinato pO = new ProdottoOrdinato(p.getCodice(), 1, 0,
				p.getPrezzo(), 0);
		return pO;
	}

	private ProdottoOrdinato searchProduct(
			ArrayList<ProdottoOrdinato> prodottiOrdinati, Prodotto p) {
		for (ProdottoOrdinato pO : prodottiOrdinati) {
			if (pO.getCodiceProdotto().equals(p.getCodice())) {
				return pO;
			}
		}
		return null;
	}
	
	public void setDaoOrdine(IDAOOrdine daoOrdine){
		this.daoOrdine=daoOrdine;
	}
	public void setDaoProdottiOrdinati(IDAOProdottiOrdinati daoProdottiOrdinati){
		this.daoProdottiOrdinati = daoProdottiOrdinati;
	}

}
