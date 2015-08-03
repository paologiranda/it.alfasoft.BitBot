package it.bitBot.rest;

public class Appuntamento {
	private String data;
	private String nome;
	private String descrizione;
	private int idCliente;
	String getData() {
		return data;
	}
	void setData(String data) {
		this.data = data;
	}
	String getNome() {
		return nome;
	}
	void setNome(String nome) {
		this.nome = nome;
	}
	String getDescrizione() {
		return descrizione;
	}
	void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	int getIdCliente() {
		return idCliente;
	}
	void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
