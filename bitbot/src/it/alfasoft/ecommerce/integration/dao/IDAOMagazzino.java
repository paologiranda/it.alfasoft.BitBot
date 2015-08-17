package it.alfasoft.ecommerce.integration.dao;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;



import java.util.List;

import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

public interface IDAOMagazzino {

	public Prodotto  readProdotto(String codice) throws SQLException , ProdottoInesistente;
	
	public List<Prodotto> readProdotti() throws SQLException ; 
	
	public long restituisciGiacenza(Prodotto prodotto) throws SQLException;

	public int createProdotto(Prodotto prodotto) throws ClassNotFoundException,
			SQLException;

	public int modificaProdotto(String descrizione, double prezzo, String nome,
			String codice) throws ClassNotFoundException, SQLException;

	public int modificaProdotto(Prodotto prodotto) throws ClassNotFoundException,
			SQLException;

	public int cancellaProdotto(String codice) throws ClassNotFoundException,
			SQLException;

	public long createMovimento(Prodotto prodotto, long quantita, String causale)
			throws ClassNotFoundException, SQLException;

	public int modificaMovimenti(Prodotto prodotto, long qta, String causale,
			long orario) throws ClassNotFoundException, SQLException;

	public int cancellaMovimenti(long orario) throws ClassNotFoundException,
			SQLException;
	
}
