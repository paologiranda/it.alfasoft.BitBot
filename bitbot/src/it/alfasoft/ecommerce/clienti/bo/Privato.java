package it.alfasoft.ecommerce.clienti.bo;

public class Privato extends Cliente {

	private static final long serialVersionUID = 1L;
	String nome;
	String cognome;
	String codiceFiscale;

 
	public Privato(CategoriaCliente categoria, String telefono, String mail,
			String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password, String nome, String cognome,
			String codiceFiscale) {
		super(categoria, telefono, mail, paese, citta, provincia, piano,
				scala, via, nomeVia, cap, numeroCivico, password);
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	
	
}
