package it.alfasoft.ecommerce.integration.dao;


import it.alfasoft.ecommerce.integration.dto.Prodotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class ADao {

	private String url="jdbc:oracle:thin:@//localhost:1521/XE";

	public ADao() throws ClassNotFoundException {
		super();
		Class.forName("oracle.jdbc.OracleDriver");
	//	this.url=url;
	}
	
	

	protected int eseguiAggiornamento(String sqlString) throws SQLException, ClassNotFoundException {

//		System.out.println("sqlString: " + sqlString);
//		System.out.println(url);
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();
		int result = statement.executeUpdate(sqlString);
		connessione.close();
		return result;
	}
	protected List<Prodotto> eseguiQuery(String sqlString) throws SQLException{		
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();
		ResultSet resultset = statement.executeQuery(sqlString);
		List<Prodotto> lista= rsToLista(resultset);
		connessione.close();

		return lista;

	}
	protected abstract List<Prodotto> rsToLista(ResultSet rs) throws SQLException;
}