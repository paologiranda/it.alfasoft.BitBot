package it.alfasoft.ecommerce.clienti.dao;

import it.alfasoft.ecommerce.clienti.bo.ClienteNome;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;

import java.sql.SQLException;
import java.util.List;

public interface IDaoGestioneClienti {
//metodi per accedere al DB
	
	/* Spiegazione delle eccezione che si possono verificare
	ClienteInesistente     -> eccezione che dice che non riesco a trovare il Cliente con i parametri passati per quel Cliente
	ClienteNonCancellabile -> eccezione che dice che non posso cancellare un Cliente perche' il suo stato e' attivo (ci sara' una variabile per dire se un cliente e' attivo oppure no)
	ClienteGiaRegistrato   -> eccezione che dice che il cliente esiste gia e non si puo' aggiungere
	*/
	
	public abstract int aggiungiCliente(PrivatoDaoDto p) throws SQLException;
	
	public abstract int aggiungiCliente(AziendaDaoDto p) throws SQLException  ;
 
	//public int emailConferma(int i) throws ClienteInesistente, SQLException;

	public abstract int attivaCliente(int codiceCliente) throws SQLException;

	
//  per le aziende faccio la ricerca per la partitaIva 
	public abstract List<ClienteDaoDto> cercaAzienda(String piva) throws SQLException;
	
//  per i privati faccio la ricerca per il codiceFiscale
	public abstract List<ClienteDaoDto> cercaPrivato(String codiceFiscale)throws SQLException;

	public abstract List<ClienteDaoDto> listaClienti () throws SQLException;

//	public abstract ClienteDaoDto cercaCliente(ClienteDaoDto c) throws SQLException;

	public abstract int eliminaClienteGiaRegistrato(String mail) throws SQLException;

	public abstract int eliminaCliente(String mail) throws SQLException;

	public abstract int controlloAttivazione(String mail, String codconferma) throws SQLException;

	public abstract String ritornacodiceConferma(String mail) throws SQLException,
			ClienteInesistente;

	public abstract int modificaAzienda(AziendaDaoDto a) throws SQLException;

	public abstract int modificaPrivato(PrivatoDaoDto a) throws SQLException;

	public abstract int cercaCliente(String mail) throws SQLException;
	
	public abstract int recuperaPwd(String email) throws SQLException;
	
	public abstract ClienteNome nomeCliente(int codcliente) throws SQLException;
	
}
