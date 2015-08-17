package it.alfasoft.ecommerce.acquisto;

import java.sql.SQLException;
import java.util.List;

import it.alfasoft.ecommerce.acquisto.dto.Ordine;
import it.alfasoft.ecommerce.acquisto.dto.StatoOrdine;

public interface IDAOOrdine {

	/** Scrive ordine sul DB Ordine
	 * 
	 * @param ordine
	 * @return
	 */
	public int creaOrdine(Ordine ordine)throws SQLException;
	
	/**
	 * restituisce id ordine creato
	 * @param ordine
	 * @return
	 * @throws SQLException
	 */
	public int getIdOrdineDb(int idCliente) throws SQLException;	
	
	/** Restituisci una lista di Ordini dato un cliente
	 * @param idOrdine
	 * @return
	 * @throws SQLException 
	 */
	public List <Object> leggiOrdine(int idCliente) throws SQLException;
	/**
	 * Aggiorna lo stato dell'Ordine 
	 * @param stato
	 * @param idOrdine
	 * @return
	 * @throws SQLException 
	 */
	public int updateStatoOrdine(StatoOrdine stato, int idOrdine) throws SQLException;
	public int deleteOrdine(int idOrdine) throws SQLException;

	List<Ordine> letturaOrdini() throws SQLException;
	
}
