package it.alfasoft.ecommerce.login;

import java.util.Random;

public class Generatoretoken {
	
	private static final String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
	private static final int length = 8;
	private static Random rnd = new Random();
	
	public static String generatoken(String caso){
		String tokengenerato;
		//tokengenerato = caso.equals("U")?"Uzhckhfk":"Aflnrsklnr";
		tokengenerato = randomString(caso,length);
		return tokengenerato;
	}
	
	private static String randomString(String user, int len ){
	   StringBuilder sb = new StringBuilder( len );
	   sb.append(user);
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	//per testare il la generazione del token
//	public static void main(String[] args) {
//		String r = randomString("A",length);
//		System.out.println(r);
//	}
	
}
