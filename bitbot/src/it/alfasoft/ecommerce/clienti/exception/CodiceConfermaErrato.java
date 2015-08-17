package it.alfasoft.ecommerce.clienti.exception;

public class CodiceConfermaErrato extends Exception {
	private static final long serialVersionUID = 1L;
	private String codConferma;
	
	public CodiceConfermaErrato(String codConferma) {
		super("Il codice di conferma " + codConferma + " e' errato.");
		this.codConferma = codConferma;
	}
 
	public String getEcodConferma() {
		return codConferma;
	}

	public void setEcodConferma(String codConferma) {
		this.codConferma = codConferma;
	}
	
	
	
}
