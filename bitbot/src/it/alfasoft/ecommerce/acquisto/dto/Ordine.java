package it.alfasoft.ecommerce.acquisto.dto;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Ordine {
	
	private StatoOrdine stato;
	private int idCliente;
	private GregorianCalendar dataOrdine;
	private double importo;
	private GregorianCalendar dataArrivo;
	private int idOrdine;
	

	public Ordine(int idCliente, Calendar dataOrdine, StatoOrdine stato) {
		
		this.idCliente=idCliente;
		this.dataOrdine=new GregorianCalendar();
		this.dataArrivo=new GregorianCalendar();
		dataArrivo.add(Calendar.DAY_OF_MONTH,7);
        //this.dataArrivo=
		this.stato=stato;

	
		
	}
//	public Ordine(ArrayList<Prodotto> prodotti, int codiceCliente) {
//		
//	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}

	public StatoOrdine getStato() {
		return stato;
	}

	public void setStato(StatoOrdine stato) {
		this.stato = stato;
	}

	public GregorianCalendar getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(GregorianCalendar data) {
		this.dataOrdine = data;
	}

	
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	
	public GregorianCalendar getDataArrivo() {
		return dataArrivo;
	}
	
	public void setDataArrivo(GregorianCalendar dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

}
