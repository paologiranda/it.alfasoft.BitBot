package it.alfasoft.ecommerce.local.dto;

public class Provincia {
	private int idprovincia;
	private String nomeprovincia;
	private int idregione;
	private String siglaprovincia;
	
	public Provincia(){}
	
	public Provincia(int idprovincia, String nomeprovincia, int idregione, String siglaprovincia) {
		this.idprovincia = idprovincia;
		this.nomeprovincia = nomeprovincia;
		this.idregione = idregione;
		this.siglaprovincia = siglaprovincia;
	}

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNomeprovincia() {
		return nomeprovincia;
	}

	public void setNomeprovincia(String nomeprovincia) {
		this.nomeprovincia = nomeprovincia;
	}

	public int getIdregione() {
		return idregione;
	}

	public void setIdregione(int idregione) {
		this.idregione = idregione;
	}

	public String getSiglaprovincia() {
		return siglaprovincia;
	}

	public void setSiglaprovincia(String siglaprovincia) {
		this.siglaprovincia = siglaprovincia;
	}
	
}
