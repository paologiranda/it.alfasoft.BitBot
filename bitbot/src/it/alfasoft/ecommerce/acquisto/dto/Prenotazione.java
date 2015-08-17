package it.alfasoft.ecommerce.acquisto.dto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prenotazione {
	
	private int codPrenotazione;
	private String codProdotto;
	private int codcliente;
	private int qta;
	private GregorianCalendar dataPrenotazione ;
	private GregorianCalendar dataArrivo ;
	
	public Prenotazione(String codProdotto,int codcliente, int qta){
		setCodPrenotazione(0);
		this.codProdotto = codProdotto ;
		this.codcliente = codcliente;
		this.qta = qta;	
		this.dataPrenotazione = new GregorianCalendar();
		this.dataArrivo = new GregorianCalendar();
		this.dataArrivo.add(Calendar.DAY_OF_WEEK, 15);
	}
	public String getCodProdotto() {
		return codProdotto;
	}
	public void setCodProdotto(String codProdotto) {
		this.codProdotto = codProdotto;
	}
	public int getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public GregorianCalendar getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(GregorianCalendar dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public GregorianCalendar getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(GregorianCalendar dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public int getCodPrenotazione() {
		return codPrenotazione;
	}

	public void setCodPrenotazione(int codPrenotazione) {
		this.codPrenotazione = codPrenotazione;
	}
	
	public String toString(){
		String str;
		str = "codPrenotazione "+ codPrenotazione+ ", codProdotto "+ codProdotto+ ", codcliente "+codcliente +", qta "+qta;
		return str;
	}
	
}
