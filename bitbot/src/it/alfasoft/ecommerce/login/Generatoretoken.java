package it.alfasoft.ecommerce.login;

public class Generatoretoken {
	
	public static String generatoken(String caso){
		String tokengenerato;
		
		tokengenerato = caso.equals("U")?"Uzhckhfk":"Aflnrsklnr";
		
		return tokengenerato;
	}
}
