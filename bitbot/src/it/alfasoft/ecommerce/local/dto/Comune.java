package it.alfasoft.ecommerce.local.dto;

public class Comune {
	private int id;
	private String nomecomune;
	private int idprovincia;
	private int idregione;
	private String catasto;
	
	public Comune(){};
	
	public Comune(int id, String nomecomune, int idprovincia, int idregione, String catasto) {
		this.id = id;
		this.nomecomune = nomecomune;
		this.idprovincia = idprovincia;
		this.idregione = idregione;
		this.catasto = catasto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomecomune() {
		return nomecomune;
	}

	public void setNomecomune(String nomecomune) {
		this.nomecomune = nomecomune;
	}

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public int getIdregione() {
		return idregione;
	}

	public void setIdregione(int idregione) {
		this.idregione = idregione;
	}

	public String getCatasto() {
		return catasto;
	}

	public void setCatasto(String catasto) {
		this.catasto = catasto;
	}
	
}
