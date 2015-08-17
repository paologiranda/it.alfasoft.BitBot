package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class LoginAdminFallito extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginAdminFallito() {
		super("Nome, cognome o password errati");
	}


}
