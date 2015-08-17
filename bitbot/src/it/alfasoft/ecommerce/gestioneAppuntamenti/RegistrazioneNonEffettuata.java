package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class RegistrazioneNonEffettuata extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrazioneNonEffettuata(){
		super("E' stato impossibile effettuare la registrazione");
	}
}
