package it.alfasoft.ecommerce.login;

public class LoginErrato extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginErrato(){
		super("Dati inseriti errati");
	}
}
 