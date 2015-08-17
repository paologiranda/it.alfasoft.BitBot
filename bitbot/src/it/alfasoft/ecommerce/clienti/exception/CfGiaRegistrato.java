package it.alfasoft.ecommerce.clienti.exception;

public class CfGiaRegistrato extends Exception {
	private static final long serialVersionUID = 1L;
	private String cf;
	
	public CfGiaRegistrato(String cf) {
		super("Il cliente con Codice Fiscale " + cf  + " e' gia' registrato.");
		this.cf = cf;
	}
} 