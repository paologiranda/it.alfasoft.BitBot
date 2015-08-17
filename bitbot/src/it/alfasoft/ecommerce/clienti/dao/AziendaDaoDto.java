package it.alfasoft.ecommerce.clienti.dao;

public class AziendaDaoDto extends ClienteDaoDto{
	
	private String ragioneSociale;
	private String partitaIva;
	
	
	public AziendaDaoDto(String ragioneSociale, String partitaIva,String telefono, String password,
			String mail, String via, int cap, String scala2, int piano2,
			String provincia, String paese, String citta) {
		super(telefono, password, mail, via, cap, scala2,
				piano2, provincia, paese, citta);
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
	} 

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}


	
}
