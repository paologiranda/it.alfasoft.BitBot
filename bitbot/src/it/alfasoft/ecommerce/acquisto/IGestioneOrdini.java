package it.alfasoft.ecommerce.acquisto;

import it.alfasoft.ecommerce.acquisto.dto.ProdottoOrdinato;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.integration.dto.Prodotto;

import java.util.ArrayList;


public interface IGestioneOrdini {

	public double acquisto(ArrayList<ProdottoOrdinato> prodottiOrdinati, String codUser) throws ErroreSistema, ClassNotFoundException;
	
	public ArrayList<ProdottoOrdinato> convertiProdotti(ArrayList<Prodotto> prodotti);
			
}
