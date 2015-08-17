package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class AdminNonTrovato extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNonTrovato() {
		super("L'admin inserito e' inesistente");
	}



}
