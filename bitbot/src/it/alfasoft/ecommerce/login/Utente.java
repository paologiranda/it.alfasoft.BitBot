package it.alfasoft.ecommerce.login;

public class Utente {
	private String codUtente;
	private Profilo profilo;
	private String mail;
	private String token;

	public Utente(String cod, Profilo p, String m) {
		setCodUtente(cod);
		setProfilo(p);
		setMail(m);
	}

	public Utente(String cod, Profilo p, String m,String t) {
		setCodUtente(cod);
		setProfilo(p);
		setMail(m);
		setToken(t);
	}

	public void setToken(String t) {
		this.token = t;
	}
	public String getToken(){
		return this.token;
	}

	public String getCodUtente() {
		return codUtente;
	}

	public void setCodUtente(String codUtente) {
		this.codUtente = codUtente;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
