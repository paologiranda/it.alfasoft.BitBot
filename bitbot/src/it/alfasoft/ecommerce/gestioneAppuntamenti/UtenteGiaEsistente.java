package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class UtenteGiaEsistente extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtenteGiaEsistente(){
		super("Nome utente gia inserito");
	}
}
