package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class NessunAppuntamento extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  NessunAppuntamento(){
		super("nessun appuntamento presente nella lista");
	}
}
