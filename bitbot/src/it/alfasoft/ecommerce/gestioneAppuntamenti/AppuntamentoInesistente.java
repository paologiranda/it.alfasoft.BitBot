package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class AppuntamentoInesistente extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppuntamentoInesistente( ){
		super("l'appuntamento non esiste");
		
	}



	
}
