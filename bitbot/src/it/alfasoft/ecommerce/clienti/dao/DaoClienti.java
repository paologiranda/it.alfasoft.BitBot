package it.alfasoft.ecommerce.clienti.dao;

import it.alfasoft.ecommerce.clienti.bo.ClienteNome;
import it.alfasoft.ecommerce.clienti.bo.GeneraMailConferma;
import it.alfasoft.ecommerce.clienti.bo.GeneraToken;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoClienti extends ADaoClienti implements IDaoGestioneClienti {
	
	String passworddb = "corso";
	String userdb = "corso";
	
	public DaoClienti(String url) throws ClassNotFoundException {
		super(url);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int aggiungiCliente(AziendaDaoDto a) throws SQLException {
//		String password = "corso";
//		String user = "corso";
		String sqlString = "insert into clienti (codconferma,telefono,password,mail,via,cap,scala,piano,citta,provincia,paese,attivo) values(";
		sqlString += "'" + a.getCodiceConferma() + "',";
		sqlString += "'" + a.getTelefono() + "',";
		sqlString += "'" + a.getPassword() + "',";
		sqlString += "'" + a.getMail() + "',";
		sqlString += "'" + a.getVia() + "',";
		sqlString += "'" + a.getCap() + "',";
		sqlString += "'" + a.getScala() + "',";
		sqlString += "'" + a.getPiano() + "',";
		sqlString += "'" + a.getCitta() + "',";
		sqlString += "'" + a.getProvincia() + "',";
		sqlString += "'" + a.getPaese() + "',";
		sqlString += "'" + a.isAttivo() + "')";
		int i = 0;
		try {
			i = eseguiAggiornamentoClienti(sqlString, userdb, passworddb);
		} catch (ClassNotFoundException e) {
			throw new SQLException("driver non trovato!!!");
		} 
		if (i == 1) {
			sqlString = "SELECT CODCLIENTE FROM CLIENTI WHERE MAIL='"
					+ a.getMail() + "'";
			System.out.println("String SQL: " + sqlString);
			Connection connessione = DriverManager.getConnection(url, userdb,
					passworddb);
			Statement statement = connessione.createStatement();
			ResultSet rs = statement.executeQuery(sqlString);
			rs.next();
			int codiceCliente = rs.getInt("CODCLIENTE");
			a.setCodiceCliente(codiceCliente);
			emailConferma(codiceCliente);
			System.out.println(a.getCodiceCliente());
			rs.close();
			connessione.close();

			sqlString = "insert into aziende (piva, codcliente, ragionesociale) values(";
			sqlString += a.getPartitaIva() + ",";
			sqlString += a.getCodiceCliente() + ",";
			sqlString += "'" + a.getRagioneSociale() + "')";

			try {
				i = eseguiAggiornamentoClienti(sqlString, userdb, passworddb);
				return i;
			} catch (ClassNotFoundException e) {
				throw new SQLException("driver non trovato!!!");
			} 

		}
		return 0;

	}
	
	@Override
	public int aggiungiCliente(PrivatoDaoDto p) throws 
			SQLException{
//		String password = "corso";
//		String user = "corso";

		String sqlString = "insert into clienti (codconferma,telefono,password,mail,via,cap,scala,piano,citta,provincia,paese,attivo) values(";
		sqlString += "'" + p.getCodiceConferma() + "',";
		sqlString += "'" + p.getTelefono() + "',";
		sqlString += "'" + p.getPassword() + "',";
		sqlString += "'" + p.getMail() + "',";
		sqlString += "'" + p.getVia() + "',";
		sqlString += "'" + p.getCap() + "',";
		sqlString += "'" + p.getScala() + "',";
		sqlString += "'" + p.getPiano() + "',";
		sqlString += "'" + p.getCitta() + "',";
		sqlString += "'" + p.getProvincia() + "',";
		sqlString += "'" + p.getPaese() + "',";
		sqlString += "'" + p.isAttivo() + "')";
		int i = 0;
		try {
			i = eseguiAggiornamentoClienti(sqlString, userdb, passworddb);
		} catch (ClassNotFoundException e) {
			throw new SQLException("driver non trovato!!!");
		} 

		
		if (i == 1) {
			sqlString = "SELECT CODCLIENTE FROM CLIENTI WHERE MAIL='"
					+ p.getMail() + "'";
			System.out.println("String SQL: " + sqlString);
			Connection connessione = DriverManager.getConnection(url, userdb,
					passworddb);
			Statement statement = connessione.createStatement();
			ResultSet rs = statement.executeQuery(sqlString);
			rs.next();
			int codiceCliente = rs.getInt("CODCLIENTE");
			p.setCodiceCliente(codiceCliente);
			emailConferma(codiceCliente);
			System.out.println(p.getCodiceCliente());
			rs.close();
			connessione.close();
			sqlString = "insert into privati (codiceFiscale, nome, cognome,codcliente) values(";
			sqlString += "'" + p.getCodiceFiscale() + "',";
			sqlString += "'" + p.getNome() + "',";
			sqlString += "'" + p.getCognome() + "',";
			sqlString += "'" + p.getCodiceCliente() + "')";
			try {
				i = eseguiAggiornamentoClienti(sqlString, userdb, passworddb);
				return i;
			} catch (ClassNotFoundException e) {
				throw new SQLException("driver non trovato!!!");
			
			}

		}
		return 0;
	}

	private int emailConferma(int i) throws SQLException {
		String codiceConferma = GeneraToken.generaToken();
		GeneraMailConferma.generaMailConferma(codiceConferma);
		String sql = "update clienti set codconferma='" + codiceConferma + "'"
				+ " where codcliente=" + i;
		try {
			return eseguiAggiornamentoClienti(sql, userdb, passworddb);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		return 0;

	}

	@Override
	public String ritornacodiceConferma(String mail) throws SQLException,
			ClienteInesistente {
		Connection connessione = DriverManager.getConnection(url, userdb, passworddb);
		Statement statement = connessione.createStatement();
		String query = "select codconferma from clienti where mail='" + mail
				+ "'";
		System.out.println("String SQL: " + query);
		ResultSet resultset = statement.executeQuery(query);
		if (resultset.next()) {
			String risultato = resultset.getString("codconferma");
			return risultato;
		} else
			throw new ClienteInesistente(mail);

	}

	@Override
	public int attivaCliente(int codiceCliente) throws SQLException {
		Connection connessione = DriverManager.getConnection(url, userdb, passworddb);
		Statement statement = connessione.createStatement();
		String query = "select attivo from clienti where codcliente="
				+ codiceCliente;
		System.out.println(query);
		ResultSet resultset = statement.executeQuery(query);
		resultset.next();
		int attivo = resultset.getInt("attivo");

		resultset.close();
		connessione.close();
		if (attivo == 0) {
			String sqlString = "update clienti set " + "attivo=1"
					+ " where codcliente=" + codiceCliente;
			try {
				return eseguiAggiornamentoClienti(sqlString, "corso", "corso");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} 
		}

		return 0;
	}

	// per le aziende faccio la ricerca per partita iva
	public List<ClienteDaoDto> cercaAzienda(String piva) throws SQLException {
		List<ClienteDaoDto> clientiTrovati = new ArrayList<ClienteDaoDto>();
		Connection conn;
		Statement st = null;
		String sql = null;

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		sql = "SELECT * from aziende where piva=" + piva;
		System.out.println("sql : " + sql);
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		String ragioneSocialeQuery = rs.getString("ragionesociale");
		int codCliente = rs.getInt("codcliente");
		sql = "select * from clienti where codcliente=" + codCliente;
		System.out.println(sql);
		rs = st.executeQuery(sql);
		while (rs.next()) {
			// i dati del cliente
			int codiceClienteQuery = rs.getInt("codCliente");
			String codiceConfermaQuery = rs.getString("codConferma");
			String telefonoQuery = rs.getString("telefono");
			String mailQuery = rs.getString("mail");
			String viaQuery = rs.getString("via");
			int capQuery = rs.getInt("cap");
			String scalaQuery = rs.getString("scala");
			int pianoQuery = rs.getInt("piano");
			String cittaQuery = rs.getString("citta");
			String provinciaQuery = rs.getString("provincia");
			String paeseQuery = rs.getString("paese");
			String passwordQuery = rs.getString("password");

			AziendaDaoDto aziendaTemp = new AziendaDaoDto(ragioneSocialeQuery,
					piva, telefonoQuery, passwordQuery, mailQuery, viaQuery,
					capQuery, scalaQuery, pianoQuery, provinciaQuery,
					paeseQuery, cittaQuery);
			aziendaTemp.setCodiceCliente(codiceClienteQuery);
			aziendaTemp.setCodiceConferma(codiceConfermaQuery);
			clientiTrovati.add(aziendaTemp);
			System.out.println(aziendaTemp.toString());

		}
		st.close();
		conn.close();

		return clientiTrovati;

	}

	// per i privati faccio la ricerca per il codiceFiscale
	public List<ClienteDaoDto> cercaPrivato(String codFiscale)
			throws SQLException {
		List<ClienteDaoDto> clientiTrovati = new ArrayList<ClienteDaoDto>();
		Connection conn;
		Statement st = null;
		String sql = null;

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		sql = "SELECT * from privati where codiceFiscale='" + codFiscale + "'";
		System.out.println("sql : " + sql);
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		String nomeQuery = rs.getString("nome");
		String cognomeQuery = rs.getString("cognome");
		int codCliente = rs.getInt("codcliente");
		sql = "select * from clienti where codcliente=" + codCliente;
		System.out.println(sql);
		rs = st.executeQuery(sql);
		while (rs.next()) {
			// i dati del cliente
			int codiceClienteQuery = rs.getInt("codCliente");
			String codiceConfermaQuery = rs.getString("codConferma");
			String telefonoQuery = rs.getString("telefono");
			String mailQuery = rs.getString("mail");
			String viaQuery = rs.getString("via");
			int capQuery = rs.getInt("cap");
			String scalaQuery = rs.getString("scala");
			int pianoQuery = rs.getInt("piano");
			String cittaQuery = rs.getString("citta");
			String provinciaQuery = rs.getString("provincia");
			String paeseQuery = rs.getString("paese");
			String passwordQuery = rs.getString("password");

			PrivatoDaoDto privatoTemp = new PrivatoDaoDto(nomeQuery,
					cognomeQuery, codFiscale, telefonoQuery, passwordQuery,
					mailQuery, viaQuery, capQuery, scalaQuery, pianoQuery,
					provinciaQuery, paeseQuery, cittaQuery);
			privatoTemp.setCodiceCliente(codiceClienteQuery);
			privatoTemp.setCodiceConferma(codiceConfermaQuery);
			clientiTrovati.add(privatoTemp);
			System.out.println(privatoTemp.toString());

		}
		st.close();
		conn.close();

		return clientiTrovati;

	}

	@Override
	public int cercaCliente(String mail) throws SQLException {
		Connection conn;
		Statement st = null;
		String sql = "";

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		sql = creaStringa(sql, "mail='", mail);
		sql = "SELECT CODCLIENTE from clienti where " + sql;
		System.out.println("sql : " + sql);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			int codcliente = rs.getInt("codcliente");
		return codcliente;
		}
		return 0;

	}

	@Override
	public int controlloAttivazione(String mail, String codConferma)
			throws SQLException {
		Connection conn;
		Statement st = null;
		String sql = "";

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		sql = creaStringa(sql, "mail='", mail);
		sql = creaStringa(sql, "codconferma='", codConferma);
		sql = "SELECT * from clienti where " + sql;
		System.out.println("sql : " + sql);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next())
			return rs.getInt("codcliente");
		else
			return 0;

	}

	private String creaStringa(String select, String string, String campo) {
		if (campo != null && campo != "" && select.length() == 0) {
			select = select + string + campo + "' ";
			return select;
		} else if (campo != null && campo != "" && select.length() > 0) {
			select = select + "and " + string + campo + "' ";
		}
		System.out.println(select);
		return select;

	}

	public List<ClienteDaoDto> listaClienti() throws SQLException {
		List<ClienteDaoDto> clientiTrovati = new ArrayList<ClienteDaoDto>();
		Connection conn;
		Statement st = null;
		String sql = null;
		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		sql = "SELECT * FROM Clienti LEFT JOIN Privati ON Clienti.codCliente=Privati.codCliente LEFT JOIN Aziende ON Clienti.codCliente=Aziende.codCliente";
		System.out.println("sql : " + sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			if (rs.getString("nome") != null) {
				PrivatoDaoDto p = new PrivatoDaoDto(rs.getString("nome"),
						rs.getString("cognome"), rs.getString("codiceFiscale"),
						rs.getString("telefono"), rs.getString("password"),
						rs.getString("mail"), rs.getString("via"),
						rs.getInt("cap"), rs.getString("scala"),
						rs.getInt("piano"), rs.getString("provincia"),
						rs.getString("paese"), rs.getString("citta"));
				p.setCodiceCliente(rs.getInt("codCliente"));
				p.setAttivo(rs.getInt("attivo"));
				p.setCodiceConferma(rs.getString("codconferma"));
				clientiTrovati.add(p);
			} else {
				AziendaDaoDto p = new AziendaDaoDto(
						rs.getString("ragioneSociale"), rs.getString("piva"),
						rs.getString("telefono"), rs.getString("password"),
						rs.getString("mail"), rs.getString("via"),
						rs.getInt("cap"), rs.getString("scala"),
						rs.getInt("piano"), rs.getString("provincia"),
						rs.getString("paese"), rs.getString("citta"));
				p.setCodiceCliente(rs.getInt("codCliente"));
				p.setAttivo(rs.getInt("attivo"));
				p.setCodiceConferma(rs.getString("codconferma"));
				clientiTrovati.add(p);
			}

		}

		return clientiTrovati;

	}

	@Override
	public int modificaAzienda(AziendaDaoDto a) throws SQLException {
		String password = "corso";
		String user = "corso";

		Connection conn;
		Statement st = null;
		String sql = null;
		int ris = 0;

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();

		sql = "UPDATE CLIENTI SET telefono = " + a.getTelefono()
				+ " , password='" + a.getPassword() + "', via= '" + a.getVia()
				+ "' , cap = " + a.getCap() + " , scala = " + a.getScala()
				+ " , piano = " + a.getPiano() + " , citta=" + a.getCitta()
				+ " , provincia = '" + a.getProvincia() + "' , paese ='"
				+ a.getPaese() + "' WHERE mail = '" + a.getMail() + "'";

		try {
			ris = eseguiAggiornamentoClienti(sql, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		sql = "UPDATE AZIENDE SET piva = " + a.getPartitaIva()
				+ " , ragionesociale='" + a.getRagioneSociale() + "'"
				+ "' WHERE codcliente = '" + a.codiceCliente + "'";
		return ris;

	}

	@Override
	public int modificaPrivato(PrivatoDaoDto p) throws SQLException{
		String password = "corso";
		String user = "corso";

		Connection conn;
		Statement st = null;
		String sql = null;
		int ris = 0;

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();

		sql = "UPDATE CLIENTI SET telefono = " + p.getTelefono()
				+ " , password='" + p.getPassword() + "', via= '" + p.getVia()
				+ "' , cap = " + p.getCap() + " , scala = " + p.getScala()
				+ " , piano = " + p.getPiano() + " , citta=" + p.getCitta()
				+ " , provincia = '" + p.getProvincia() + "' , paese ='"
				+ p.getPaese() + "' WHERE mail = '" + p.getMail() + "'";

		try {
			ris = eseguiAggiornamentoClienti(sql, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		sql = "UPDATE PRIVATI SET codicefiscale = '" + p.getCodiceFiscale()
				+ "' , nome='" + p.getNome() + "' , cognome='" + p.getCognome()
				+ "' WHERE codcliente = '" + p.codiceCliente + "'";
		return ris;

	}

	@Override
	public int eliminaCliente(String mail) throws SQLException {
//		String password = "corso";
//		String user = "corso";

		Connection conn;
		Statement st = null;
		String sql = null;
		int ris = 0;

		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();

		sql = "DELETE CLIENTI WHERE mail = '" + mail + "'";

		try {
			ris = eseguiAggiornamentoClienti(sql, userdb, passworddb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ris;

	}

	@Override
	public int eliminaClienteGiaRegistrato(String mail) throws SQLException {
		int i = 0;
		Connection conn;
		Statement st = null;
		String sql = null;

			conn = DriverManager.getConnection(url, userdb, passworddb);
			st = conn.createStatement();
			sql = "select codCliente from clienti where mail='" + mail + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			int codCliente = rs.getInt("codcliente");
			conn.close();
			rs.close();
			st.close();
			conn = DriverManager.getConnection(url, userdb, passworddb);
			st = conn.createStatement();
			sql = "select * from AZIENDE where codcliente='" + codCliente + "'";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				conn.close();
				rs.close();
				st.close();
				return 0;
			}
			sql = "select * from PRIVATI where codcliente='" + codCliente + "'";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				conn.close();
				rs.close();
				st.close();
				return 0;
			}
			conn.close();
			rs.close();
			st.close();
			return 1;

	}
	@Override
	public int recuperaPwd(String email) throws SQLException{
		
//		String password = "corso";
//		String user = "corso";
		String nuovaPassword = "estate2015";
				
		String sqlString  = "UPDATE CLIENTI SET PASSWORD='"+nuovaPassword+"' WHERE mail ='"+email +"'";
		int risp = 0;
		try {
			risp = eseguiAggiornamentoClienti(sqlString, userdb, passworddb);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return risp;
	}
	
	@Override
	public ClienteNome nomeCliente(int codcliente) throws SQLException{
		
		ClienteNome cliente = new ClienteNome();
		Connection conn;
		Statement st = null;
		String sqlString ="select * from("
				+ "select CODCLIENTE, RAGIONESOCIALE AS NOME from AZIENDE "
				+ " union "
				+ "select  CODCLIENTE, COGNOME|| ' ' || NOME AS NOME from PRIVATI "
				+ ") where CODCLIENTE='"+codcliente+"'";
		
		System.out.println(sqlString);
		
		conn = DriverManager.getConnection(url, userdb, passworddb);
		st = conn.createStatement();
		ResultSet rs = st .executeQuery(sqlString);
		
		rs.next();
		cliente.setCodiceCliente(rs.getInt("CODCLIENTE"));
		cliente.setNome(rs.getString("NOME"));

		conn.close();
		rs.close();
		st.close();

		return cliente;
	}
	

}
