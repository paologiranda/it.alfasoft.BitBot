package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoAdmin extends ADao implements IDaoAdmin {

	public DaoAdmin(String url) throws ClassNotFoundException {
		super(url);

	}

	@Override
	public int createDtoAdmin(DtoAdmin dtoa) throws SQLException {
		
		String sqlString = "insert into amministratori (NOME,COGNOME,PASSWORD,MAIL) values(";
		sqlString += "'" + dtoa.getNome() + "',";
		sqlString += "'" + dtoa.getCognome() + "',";
		sqlString += "'" + dtoa.getPassword() + "',";
		sqlString += "'" + dtoa.getMail() + "')";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			throw new SQLException("driver non trovato!!!");
		}
	}

	@Override
	public List<DtoAdmin> readDtoAdmin() throws SQLException {
		List<DtoAdmin> result = new ArrayList<DtoAdmin>();
		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		Statement statement = connessione.createStatement();
		ResultSet resultset = statement
				.executeQuery("select * from amministratori");
		while (resultset.next()) {
			DtoAdmin amm = new DtoAdmin(resultset.getString("nome"),
					resultset.getString("cognome"),
					resultset.getString("password"),
					resultset.getString("mail"));
			amm.setID(resultset.getInt("idadmin"));
			result.add(amm);
		}
		connessione.close();
		return result;
	}

	@Override
	public int updateDtoAdmin(DtoAdmin admindaMod, DtoAdmin adminMod)
			throws SQLException {
		String sqlString = "update amministratori set " + "nome='"
				+ adminMod.getNome() + "',cognome='" + adminMod.getCognome()
				+ "',password='" + adminMod.getPassword() + "',mail='"+adminMod.getMail()+"' where idadmin='"
				+ admindaMod.getID()+"'";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDtoAdmin(DtoAdmin admind) throws SQLException {
		try {
			return eseguiAggiornamento("delete amministratori where idadmin="
					+ admind.getID());
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver del database non presente");
		}
	}

	@Override
	public int searchAdmin(DtoAdmin admind) throws SQLException {
		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		Statement statement = connessione.createStatement();
		ResultSet resultset = statement
				.executeQuery("SELECT idadmin FROM amministratori WHERE mail='"+admind.getMail()+"'");
		resultset.next();
			if(resultset.getRow()>0)
					return resultset.getInt("idadmin");
			return 0;


	}
}
