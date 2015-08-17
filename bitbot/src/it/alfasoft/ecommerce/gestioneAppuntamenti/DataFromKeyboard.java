package it.alfasoft.ecommerce.gestioneAppuntamenti;

import java.util.Scanner;

public class DataFromKeyboard {
static	Scanner tastiera = new Scanner(System.in);

	public static int insertInt() {
		while(!tastiera.hasNextInt())
			{
				tastiera.next();
			}
			int number = tastiera.nextInt();
			return number;
	}

	public static String insertString() {
		String stringa = tastiera.nextLine();
		return stringa;
	}

	public static long insertLong() {
		while(!tastiera.hasNextLong())
			{
				tastiera.next();
			}
		long lungo = tastiera.nextLong();
			return lungo;
	}

	public static double insertDouble() {
		while(!tastiera.hasNextDouble())
			{
				tastiera.next();
			}
		double virgola = tastiera.nextDouble();
			return virgola;
	}

}
