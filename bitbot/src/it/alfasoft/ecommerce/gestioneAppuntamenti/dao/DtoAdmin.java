package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

public class DtoAdmin {
	private int ID;
	private String nome;
	private String cognome;
	private String password;
	private String mail;
	


	
	public DtoAdmin(String nome, String cognome, String password,String mail) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.setMail(mail);
	}


	public void setID(int ID){
		this.ID=ID;
	}
	

	public int getID() {
		return ID;
	}


	public String getPassword() {
		return password;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
}
