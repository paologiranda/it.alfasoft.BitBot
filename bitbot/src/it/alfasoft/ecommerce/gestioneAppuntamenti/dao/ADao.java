package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ADao {
protected String url;
public final static String CONSTRAINT_EXP_CODE = "23000";
	
	public ADao(String url) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.OracleDriver");
		this.url=url;
	}
	
	protected int eseguiAggiornamento(String sqlString) throws SQLException, ClassNotFoundException{
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();
		int result = statement.executeUpdate(sqlString);
		
		connessione.close();
		return result;
	}

	
}
