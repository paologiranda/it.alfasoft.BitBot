package it.alfasoft.ecommerce.gestioneAppuntamenti;

public class DataOccupata extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataOccupata() {
		super("Data gia' occupata");
	}

}
