package it.alfasoft.ecommerce.clienti.exception;

public class ClienteInesistente extends Exception {
	private static final long serialVersionUID = 1L;
	private String mail;
	private int codcliente;
	
	public ClienteInesistente(String mail) {
		super("Il cliente con mail " + mail + " non e' presente nella lista clienti.");
		this.mail=mail;
	}
	
	public ClienteInesistente(int codcliente) {
		super("Il cliente con codice " + codcliente + " non e' presente nella lista clienti.");
		this.codcliente=codcliente;
	} 
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
