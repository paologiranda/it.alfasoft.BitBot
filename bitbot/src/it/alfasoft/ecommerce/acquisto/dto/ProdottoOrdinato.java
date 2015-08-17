package it.alfasoft.ecommerce.acquisto.dto;

public class ProdottoOrdinato {
	
	private String codiceProdotto;
	private int qtaOrdinata;
	private int sconto;
	private double prezzo;
	private int iva;
	private int codiceOrdine;
	

	public ProdottoOrdinato(String codiceProdotto, int qtaOrdinata, int sconto, double prezzo, int iva){
		this.setCodiceProdotto(codiceProdotto);
		this.setQtaOrdinata(qtaOrdinata);
		this.setSconto(sconto);
		this.setPrezzo(prezzo);
		this.setIva(iva);
	}


	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public int getQtaOrdinata() {
		return qtaOrdinata;
	}

	public void setQtaOrdinata(int qtaOrdinata) {
		this.qtaOrdinata = qtaOrdinata;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}
	
	
	
}
