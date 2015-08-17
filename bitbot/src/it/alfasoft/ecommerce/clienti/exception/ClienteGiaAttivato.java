package it.alfasoft.ecommerce.clienti.exception;

public class ClienteGiaAttivato extends Exception {
	private static final long serialVersionUID = 1L;
	private String mail;
	
	public ClienteGiaAttivato(String mail) {
		super("Il cliente con mail " + mail + " e' gia' attivato.");
		this.mail = mail;
	}
 
	public String getEmail() {
		return mail;
	}

	public void setEmail(String mail) {
		this.mail = mail;
	}
	
	
	
}
