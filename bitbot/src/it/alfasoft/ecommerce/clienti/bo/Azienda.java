package it.alfasoft.ecommerce.clienti.bo;


 public class Azienda extends Cliente {

	private static final long serialVersionUID = 1L;
	String ragioneSociale;
	String pIva;   
	
	
	public Azienda(CategoriaCliente categoria, String telefono, String mail,
			String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password, String ragioneSociale,
			String pIva) {
		super(categoria, telefono, mail, paese, citta, provincia, piano,
				scala, via, nomeVia, cap, numeroCivico, password);
		this.ragioneSociale = ragioneSociale;
		this.pIva = pIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	

	
	

}
