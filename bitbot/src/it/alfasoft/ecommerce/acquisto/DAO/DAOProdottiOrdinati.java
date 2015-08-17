package it.alfasoft.ecommerce.acquisto.DAO;

import it.alfasoft.ecommerce.acquisto.IDAOProdottiOrdinati;
import it.alfasoft.ecommerce.acquisto.dto.ProdottoOrdinato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOProdottiOrdinati extends ADao implements IDAOProdottiOrdinati{

	public DAOProdottiOrdinati() throws ClassNotFoundException {
		super();
	}
	@Override
	public int creaProdottiOrdinati(ProdottoOrdinato prodotto, int idOrdine) throws SQLException {
		String sqlString = "insert into prodottiOrdinati (codProdotto,codOrdine,qtaOrdinata,prezzo,sconto,iva)";
		sqlString += "VALUES('"+prodotto.getCodiceProdotto()+"',"+idOrdine+","+prodotto.getQtaOrdinata()+","+prodotto.getPrezzo()+","+prodotto.getSconto()+","+prodotto.getIva()+")";
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			throw new SQLException("driver non trovato!!!");
		}
	}

	@Override
	public List<ProdottoOrdinato> readProdottiOrdinati(int idOrdine)throws SQLException {
		String url="jdbc:oracle:thin:@//localhost:1521/XE";
		ArrayList<ProdottoOrdinato> prodOrdinati = new ArrayList<ProdottoOrdinato>();
		String sqlRead = "select * from prodottiOrdinati where codOrdine ="+idOrdine;
		//ResultSet rs = eseguiQuery(sqlRead);
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();
		ResultSet rs = statement.executeQuery(sqlRead);
			while(rs.next()){
					ProdottoOrdinato p = new ProdottoOrdinato(rs.getString("codOrdine"),rs.getInt("qtaOrdinata"),rs.getInt("sconto"),rs.getDouble("prezzo"),rs.getInt("iva"));
					prodOrdinati.add(p);
			}
		connessione.close();
		return prodOrdinati;
	}

	@Override
	public int deleteProdottiOrdinati(int idOrdine) throws SQLException {
		String SqlDeleteProdotti = "delete prodottiOrdinati where codOrdine="+idOrdine ;
		
			try {
				return eseguiAggiornamento(SqlDeleteProdotti);
			} catch (ClassNotFoundException e) {
				throw new SQLException();
		
			}

	}
	@Override
	protected List<Object> rsToLista(ResultSet resultset) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
