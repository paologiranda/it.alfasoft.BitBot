package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import java.sql.Timestamp;




public class DtoAppuntamento {
	private Timestamp data;
	private int codiceCliente;
	private String descrizione;
	private int IDAdmin;
		
	

	public int getCodiceCliente() {
		return codiceCliente;
	}



	public DtoAppuntamento(Timestamp data, int codiceCliente, String descrizione) {
		this.data = data;
		this.codiceCliente = codiceCliente;
		this.descrizione = descrizione;
	}

		
	
	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public int getIDAdmin() {
		return IDAdmin;
	}

	public void setIDAdmin(int IDAdmin) {
		this.IDAdmin = IDAdmin;
	}

	public Timestamp getData() {
		return data;
	}

	void setData(Timestamp data) {
		this.data = data;
	}

	

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
