package it.alfasoft.ecommerce.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoLogin {

	public DaoLogin() throws ClassNotFoundException {
		super();
	}

	public Utente searchAdmin(String mail, String pwd) throws SQLException,
			ClassNotFoundException, LoginErrato {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connessione = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE", "corso", "corso");
		Statement statement = connessione.createStatement();
		String sqlQuery = "SELECT idAdmin FROM amministratori WHERE mail='"
				+ mail + "' AND password='" + pwd + "'";
		ResultSet rs = statement.executeQuery(sqlQuery);
		if (rs.next()) {
			int id = rs.getInt("idAdmin");
			Utente ut = new Utente("A" + id, Profilo.Admin, mail);
			connessione.close();
			return ut;
		} else {
			throw new LoginErrato();
		}

	}

	public Utente searchCliente(String mail, String pwd) throws SQLException,
			ClassNotFoundException, LoginErrato, ClienteNonattivo {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection connessione = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE", "corso", "corso");
		Statement statement = connessione.createStatement();
		String sqlQuery = "SELECT codcliente,attivoprivati,attivoazienda FROM clienti WHERE mail='"
				+ mail + "' AND password='" + pwd + "'";
		ResultSet rs = statement.executeQuery(sqlQuery);
		if (rs.next()) {

			int codCliente = rs.getInt("codcliente");
			int attivo = rs.getInt("attivo");

			if (attivo == 1) {
				Utente ut = new Utente("C" + codCliente, Profilo.Cliente, mail);
				return ut;
			}
			else {
				connessione.close();
				throw new ClienteNonattivo();
			}
		} else {
			connessione.close();
			throw new LoginErrato();
		}

	}

	public String searchDataForPrivati(String mail) throws SQLException,
			ClassNotFoundException, ClienteNonattivo {
		String nome = null;
		String cognome = null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connessione = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE", "corso", "corso");
		Statement statement = connessione.createStatement();
		String sqlQuery = "SELECT privati.nome,privati.cognome from clienti INNER JOIN privati on clienti.codcliente=privati.codcliente"
				+ " where mail='" + mail + "'";
		System.out.println(sqlQuery);
		ResultSet rs = statement.executeQuery(sqlQuery);

		while (rs.next()) {
			nome = rs.getString("nome");
			cognome = rs.getString("cognome");
		}

		connessione.close();
		String utente = nome + " " + cognome;
		return utente;
	}

	public String searchDataForAdmin(String mail) throws SQLException,
			ClassNotFoundException, ClienteNonattivo {
		String nome = null;
		String cognome = null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connessione = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE", "corso", "corso");
		Statement statement = connessione.createStatement();
		String sqlQuery = "SELECT amministratori.nome,amministratori.cognome from amministratori"
				+ " where mail='" + mail + "'";
		System.out.println(sqlQuery);
		ResultSet rs = statement.executeQuery(sqlQuery);

		while (rs.next()) {
			nome = rs.getString("nome");
			cognome = rs.getString("cognome");
		}

		connessione.close();
		String utente = nome + " " + cognome;
		return utente;
	}

	public String searchDataForAzienda(String mail) throws SQLException,
			ClassNotFoundException, ClienteNonattivo {
		String ragioneSociale = null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connessione = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/XE", "corso", "corso");
		Statement statement = connessione.createStatement();
		String sqlQuery = "SELECT aziende.ragionesociale from aziende INNER JOIN clienti on clienti.codcliente=aziende.codcliente"
				+ " where mail='" + mail + "'";
		System.out.println(sqlQuery);
		ResultSet rs = statement.executeQuery(sqlQuery);

		while (rs.next()) {
			ragioneSociale = rs.getString("ragionesociale");
//			System.out.println(ragioneSociale);
		}

		connessione.close();
		String utente = ragioneSociale;
		return utente;
	}

}
