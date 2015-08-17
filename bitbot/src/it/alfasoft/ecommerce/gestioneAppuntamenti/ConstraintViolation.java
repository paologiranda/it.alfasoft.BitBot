package it.alfasoft.ecommerce.gestioneAppuntamenti;

import java.sql.SQLException;

public class ConstraintViolation extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public ConstraintViolation(String reason, Throwable cause) {
		super(reason+" (" + cause.getMessage() + ")", cause);
	}



}
