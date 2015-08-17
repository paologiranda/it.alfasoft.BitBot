package it.alfasoft.ecommerce.clienti.bo;

import it.alfasoft.ecommerce.clienti.exception.CfGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaAttivato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.CodiceConfermaErrato;
import it.alfasoft.ecommerce.clienti.exception.DatabaseNonTrovato;
import it.alfasoft.ecommerce.clienti.exception.PivaGiaRegistrata;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;

import java.util.List;


public interface IGestioneClientiService {
	
	/* Spiegazione delle eccezione che si possono verificare
	ClienteInesistente     -> eccezione che dice che non riesco a trovare il Cliente con i parametri passati per quel Cliente
	ClienteNonCancellabile -> eccezione che dice che non posso cancellare un Cliente perche' il suo stato e' attivo (ci sara' una variabile per dire se un cliente e' attivo oppure no)
	ClienteGiaRegistrato   -> eccezione che dice che il cliente esiste gia e non si puo' aggiungere
	*/
	 
	public abstract int aggiungiCliente( String ragioneSociale,String pIva,CategoriaCliente categoria, String telefono,
			String mail,String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password) throws ClienteGiaRegistrato, PivaGiaRegistrata, ErroreSistema, TabellaNonTrovata;
	
	public abstract int aggiungiCliente( String nome,String cognome, String codiceFiscale, CategoriaCliente categoria, String telefono,
			String mail,String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password) throws ClienteGiaRegistrato, CfGiaRegistrato, ErroreSistema, TabellaNonTrovata; 

	//public abstract boolean emailConferma(int i) throws ClienteInesistente;
	
//	public abstract int attivaCliente(int codice) throws ClienteInesistente;

	//public abstract void cancellaInattivo(Cliente c) throws ClienteNonCancellabile, ClienteInesistente;
	
	public abstract int cercaCliente(int codice) throws ClienteInesistente;
	
//	public abstract int cercaCliente(String mail)throws ClienteInesistente;
	
//	public abstract int cercaPrivato(String codiceFiscale) throws ClienteInesistente;
	
//	public abstract int cercaAzienda(String pIva) throws ClienteInesistente;

	public abstract List<Cliente> listaClienti () throws TabellaNonTrovata, ErroreSistema;

	public abstract int controllaAttivazione(String mail, String codConferma)
			throws ClienteInesistente, ClienteGiaAttivato, DatabaseNonTrovato, ErroreSistema, CodiceConfermaErrato;

	public abstract String getCodiceConferma(String mail) throws ErroreSistema, ClienteInesistente;

	
	
	public abstract void modificaDatiPersonali(Cliente c) throws ClienteInesistente, DatabaseNonTrovato;
	
}
