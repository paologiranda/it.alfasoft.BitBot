package it.alfasoft.ecommerce.login;

public class Utente {
	private String codUtente;
	private Profilo profilo;
	private String mail;

	public Utente(String cod, Profilo p, String m) {
		setCodUtente(cod);
		setProfilo(p);
		setMail(m);
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
