package it.alfasoft.ecommerce.integration.dto;

public class Prodotto{
	private Categoria categoria;
	private SottoCategoria sottoCategoria;
	private Tipo tipo;
	private String codice;
	private String nome;
	private String descrizione;
	private boolean riservatoAzienda;
	private double prezzo;
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = Categoria.valueOf(categoria);
	}
	public SottoCategoria getSottoCategoria() {
		return sottoCategoria;
	}
	public void setSottoCategoria(String sottoCategoria) {
		this.sottoCategoria = SottoCategoria.valueOf(sottoCategoria);
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = Tipo.valueOf(tipo);
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isRiservatoAzienda() {
		return riservatoAzienda;
	}
	public void setRiservatoAzienda(boolean riservatoAzienda) {
		this.riservatoAzienda = riservatoAzienda;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Prodotto() {};
	
	public Prodotto(Categoria categoria, SottoCategoria sottoCategoria,
			Tipo tipo, String codice, String nome, String descrizione,
			boolean riservatoAzienda, double prezzo) {
		super();
		this.categoria = categoria;
		this.sottoCategoria = sottoCategoria;
		this.tipo = tipo;
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.riservatoAzienda = riservatoAzienda;
		this.prezzo = prezzo;
		
	}
	@Override
	public String toString() {
		return "Prodotto [categoria=" + categoria + ", sottoCategoria="
				+ sottoCategoria + ", tipo=" + tipo + ", codice=" + codice
				+ ", nome=" + nome + ", descrizione=" + descrizione
				+ ", riservatoAzienda=" + riservatoAzienda + ", prezzo="
				+ prezzo + "]";
	}
	
}
