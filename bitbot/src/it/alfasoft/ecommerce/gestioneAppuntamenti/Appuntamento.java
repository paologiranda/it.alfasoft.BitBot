package it.alfasoft.ecommerce.gestioneAppuntamenti;

import java.util.GregorianCalendar;

public class Appuntamento implements Comparable<Appuntamento> {
	private GregorianCalendar data;
	private int codiceCliente;
	private int IDadmin;
	private String descrizione;
	
	
	

	public int getCodiceCliente() {
		return codiceCliente;
	}



	public Appuntamento(GregorianCalendar data, int codiceCliente, int IDadmin, String descrizione) {
		this.data = data;
		this.codiceCliente = codiceCliente;
		this.IDadmin = IDadmin;
		this.descrizione = descrizione;
	}

		
	
	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public int getIDAdmin() {
		return IDadmin;
	}

	public void setIDAdmin(int IDadmin) {
		this.IDadmin = IDadmin;
	}

	public GregorianCalendar getData() {
		return data;
	}

	void setData(GregorianCalendar data) {
		this.data = data;
	}

	@Override
	public int compareTo(Appuntamento appuntamento) {
		return this.data.compareTo(appuntamento.getData());
		
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
