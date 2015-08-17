package it.alfasoft.ecommerce.integration.exception;

public class ProdottoInesistente extends Exception {
	private static final long serialVersionUID = 1L;
	private String nomeProdotto;
	public ProdottoInesistente(String nome) {
		super("Il prodotto con codice " + nome + " non e' presente nel magazzino.");
		this.nomeProdotto=nome;
	}
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
}
