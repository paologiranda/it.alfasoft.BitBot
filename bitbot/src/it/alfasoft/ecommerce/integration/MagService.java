package it.alfasoft.ecommerce.integration;

import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

import java.util.ArrayList;
import java.util.Date;

public interface MagService {
	/**
	 * Ricerca il prodotto. Se il codice prodotto non e' presente in magazzino, restituisce un'exception di tipo
	 * ProdottoInesistente.
	 * 
	 * @param codice
	 * @return
	 * @throws ProdottoInesistente
	 */
	public abstract Prodotto searchProdotto(String codice) throws ProdottoInesistente;
	
	/**
	 * Restituisce la quantita' residua del prodotto richiesto. Nel caso in cui non trova il prodotto,
	 * restituisce un'exception di tipo ProdottoInesistente.
	 * 
	 * @param prodotto
	 * @return
	 * @throws ProdottoInesistente
	 */
	//public abstract int quantitaResidua(Prodotto prodotto) throws ProdottoInesistente;
	
	/**
	 * Restituisce l'elenco dei prodotti completo.
	 * @return
	 */
	public abstract ArrayList<Prodotto> elencoProdotti();
	
	/**
	 * Restituisce la data in cui sara' disponibile il prodotto.
	 * @param codiceProdotto
	 * @return
	 */
	public abstract Date dataDisponiblita(String codiceProdotto);
}