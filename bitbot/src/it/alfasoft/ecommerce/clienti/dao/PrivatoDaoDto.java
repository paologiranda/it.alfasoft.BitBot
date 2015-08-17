package it.alfasoft.ecommerce.clienti.dao;

public class PrivatoDaoDto extends ClienteDaoDto{
	private String codiceFiscale;
	private String nome;
	private String cognome;
	
	
	 
	
	
	public PrivatoDaoDto(String nome, String cognome,String codiceFiscale,
			String telefono, String password,
			String mail, String via, int cap, String scala, int piano,
			String provincia, String paese, String citta) {
		super(telefono, password, mail, via, cap, scala,
				piano, provincia, paese, citta);
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
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
	
	

}
