package it.alfasoft.ecommerce.clienti.bo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public  class GeneraToken {
	static SecureRandom secureRandom = new SecureRandom();
	static String codiceConferma;
	public static String generaToken(){
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(secureRandom.generateSeed(128));
			codiceConferma = Long.toHexString(secureRandom.nextLong());
			return codiceConferma; 
		} catch (NoSuchAlgorithmException e) {
			System.out.println("algoritmo di codifica non trovato");
			return null;
		}
		
	}

}
