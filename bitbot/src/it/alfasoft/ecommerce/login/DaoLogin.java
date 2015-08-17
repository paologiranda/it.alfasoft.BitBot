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
		String sqlQuery = "SELECT codcliente,attivo FROM clienti WHERE mail='"
				+ mail + "' AND password='" + pwd + "'";
		ResultSet rs = statement.executeQuery(sqlQuery);
		if (rs.next()) {
			int codCliente = rs.getInt("codcliente");
			int attivo = rs.getInt("attivo");

			if (attivo == 1) {
				Utente ut = new Utente("C" + codCliente, Profilo.Cliente, mail);
				return ut;
			} else {
				connessione.close();
				throw new ClienteNonattivo();
			}
		} else {
			connessione.close();
			throw new LoginErrato();
		}

	}

}
