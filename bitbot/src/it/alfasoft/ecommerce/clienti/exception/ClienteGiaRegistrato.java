package it.alfasoft.ecommerce.clienti.exception;

public class ClienteGiaRegistrato extends Exception {
	private static final long serialVersionUID = 1L;
	private String mail;
	
	public ClienteGiaRegistrato(String mail, String codice) {
		super("Il cliente con mail " + mail + " e codice= " + codice + " e' gia' registrato.");
		this.mail = mail;
	}
 
	public String getEmail() {
		return mail;
	}

	public void setEmail(String mail) {
		this.mail = mail;
	}
	
	
	
}
