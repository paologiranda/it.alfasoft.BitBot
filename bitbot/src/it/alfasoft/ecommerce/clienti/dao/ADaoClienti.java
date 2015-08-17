	package it.alfasoft.ecommerce.clienti.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public abstract class ADaoClienti {
		protected String url;
		
		public ADaoClienti(String url) throws ClassNotFoundException{
			Class.forName("oracle.jdbc.OracleDriver");
			this.url=url;
			System.out.println(this.url);
		}
		 
		protected int eseguiAggiornamentoClienti(String sqlString ,String user, String password) throws SQLException, ClassNotFoundException{
			//String user ;
			//String password;
			
			System.out.println("String SQL: "+sqlString);
			Connection connessione = DriverManager.getConnection(url,user,password);
			Statement statement = connessione.createStatement();
			int result = statement.executeUpdate(sqlString);
			
			connessione.close();
			return result;
		}

	}
