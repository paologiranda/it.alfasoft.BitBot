package it.alfasoft.ecommerce.login;

public class Utente {
	private String codUtente;
	private Profilo profilo;
	private String mail;
	private String token;
	private String nome;

	public Utente(String cod, Profilo p, String m) {
		setCodUtente(cod);
		setProfilo(p);
		setMail(m);
	}

	public Utente(String cod, Profilo p, String m,String t,String n) {
		setCodUtente(cod);
		setProfilo(p);
		setMail(m);
		setToken(t);
		setNome(n);
	}

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		return this.nome = nome;
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
