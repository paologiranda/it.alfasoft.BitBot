package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import it.alfasoft.ecommerce.gestioneAppuntamenti.ConstraintViolation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DaoAppuntamenti extends ADao implements IDaoAppuntamenti {

	public DaoAppuntamenti(String url) throws ClassNotFoundException{
		super(url);
	}
	@Override
	public int createDtoAppuntamento(DtoAppuntamento dtoa) throws ConstraintViolation,SQLException {
		String sqlString="INSERT INTO APPUNTAMENTI (DATA,IDADMIN,DESCRIZIONE,CODICECLIENTE) VALUES(";
		sqlString+="timestamp'"+dtoa.getData()+"',";
		sqlString+=dtoa.getIDAdmin()+",";
		sqlString+="'"+dtoa.getDescrizione()+"',";
		sqlString+=dtoa.getCodiceCliente()+")";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			throw new SQLException("driver non trovato!!!");
		} catch (SQLException e) {
			if(e.getSQLState().equals(ADao.CONSTRAINT_EXP_CODE))
				throw new ConstraintViolation("e' stata violata una costraint",e);
			else
				throw e;
		}		
		} 
	

	@Override
	public List<DtoAppuntamento> readDtoAppuntamenti() throws SQLException {
		List<DtoAppuntamento> appuntamenti=new ArrayList<DtoAppuntamento>();
		Connection connessione= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","corso","corso");
		Statement s=connessione.createStatement();
		ResultSet rs =s.executeQuery("SELECT * FROM APPUNTAMENTI ORDER BY data");
		while(rs.next()){
			Timestamp data= rs.getTimestamp("DATA");
			int IDAdmin= rs.getInt("IDADMIN");
			String descrizione= rs.getString("DESCRIZIONE");
			int codiceCliente= rs.getInt("CODICECLIENTE"); 
			DtoAppuntamento a=new DtoAppuntamento(data,codiceCliente,descrizione);
			a.setIDAdmin(IDAdmin);
			appuntamenti.add(a);
		}
		connessione.close();
		return appuntamenti;
	}

	@Override
	public int updateDtoAppuntamenti(DtoAppuntamento appdaMod,DtoAppuntamento appMod) throws SQLException {
		String sqlString="update appuntamenti set ";
		sqlString+="data= timestamp '"+appMod.getData()+"',";
		sqlString+="descrizione='"+appMod.getDescrizione()+"'";
		sqlString+="where idadmin='"+appdaMod.getIDAdmin()+"' and data=timestamp'"+appdaMod.getData()+"'";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			throw new SQLException("errore");
		}
	}

	@Override
	public int deleteDtoAppuntamento(DtoAppuntamento app) throws SQLException {
		String sqlString="DELETE APPUNTAMENTI WHERE DATA=";
		sqlString+="timestamp'"+app.getData()+"' AND IDADMIN=";
		sqlString+="'"+app.getIDAdmin()+"'";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			throw new SQLException("errore");
		}
	}

	@Override
	public String getClienteFkCostraint() {
		return "APPUNTAMENTI_FK";
	}





}
