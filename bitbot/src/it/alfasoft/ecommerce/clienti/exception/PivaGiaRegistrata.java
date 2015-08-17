package it.alfasoft.ecommerce.clienti.exception;

public class PivaGiaRegistrata extends Exception {
	private static final long serialVersionUID = 1L;
	private String piva;
	
	public PivaGiaRegistrata(String piva) {
		super("Il cliente con Partita Iva " + piva  + " e' gia' registrato.");
		this.piva = piva;
	}
} 