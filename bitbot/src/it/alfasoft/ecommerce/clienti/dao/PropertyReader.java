package it.alfasoft.ecommerce.clienti.dao;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {




	public static void main(String[] args) {
		try {
			Properties props = new Properties();


			FileInputStream fis = new FileInputStream("C:/Users/Vincenzo/workspace2/bitbot/jdbc.properties");

			props.load(fis); 

			String drivers = props.getProperty("jdbc.drivers");
			String connectionURL = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			System.out.println("jdbc.driver: " + drivers);
			System.out.println("jdbc.username: " + username);
			System.out.println("jdbc.password: " + password);
			System.out.println("jdbc.url: " + connectionURL);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}



