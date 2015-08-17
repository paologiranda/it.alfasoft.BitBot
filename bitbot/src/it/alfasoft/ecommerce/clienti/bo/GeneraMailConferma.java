package it.alfasoft.ecommerce.clienti.bo;

public class GeneraMailConferma {
	static String codiceConfermaMail;
	public static void generaMailConferma(String codiceConferma){
		codiceConfermaMail=codiceConferma;
		System.out.println("il tuo codice di conferma e'"
				+ ": "+codiceConfermaMail);
	}
	public static boolean ritornaCodiceConfermaMail(Cliente c){
		if (c.codiceConferma==codiceConfermaMail)
		return true; 
		else
		return false;
	}
	public static String getCodice(){
		return codiceConfermaMail;
	}

}
