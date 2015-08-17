package it.alfasoft.ecommerce.integration.dao;

import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAOMagazzino extends ADao implements IDAOMagazzino {

	private String url = "jdbc:oracle:thin:@//localhost:1521/XE";

	public DAOMagazzino() throws ClassNotFoundException {
		super();
	}

	@Override
	public int createProdotto(Prodotto prodotto) throws ClassNotFoundException,
			SQLException {
		String sql = "insert into magazzino (codice, nome, categoria, sottocategoria, tipo, descrizione, prezzo, riservatoazienda) "
				+ "values ('"
				+ prodotto.getCodice()
				+ "', '"
				+ prodotto.getNome()
				+ "' , '"
				+ prodotto.getCategoria()
				+ "' , '"
				+ prodotto.getSottoCategoria()
				+ "' , '"
				+ prodotto.getTipo()
				+ "' , '"
				+ prodotto.getDescrizione()
				+ "' , "
				+ prodotto.getPrezzo()
				+ ", '"
				+ prodotto.isRiservatoAzienda() + "')";

		int risp = eseguiAggiornamento(sql);
		return risp;
	}

	/**
	 * Vengono modificati gli attributi descrizione, prezzo, nome del prodotto
	 * con chiave uguale al codice. (Vengono sempre modificati gli attributi!!!)
	 */
	@Override
	public int modificaProdotto(String descrizione, double prezzo, String nome,
			String codice) throws ClassNotFoundException, SQLException {
		String sql = "update magazzino set descrizione = '" + descrizione
				+ "', prezzo = " + prezzo + ", nome = '" + nome
				+ "' where codice= '" + codice + "'";
		int risp = eseguiAggiornamento(sql);
		return risp;
	}

	/**
	 * Passato un prodotto, modifica gli attributi del prodotto presente sul db
	 * con lo stesso codice. Vengono modificati solo gli attributi valorizzati.
	 * 
	 * @param prodotto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public int modificaProdotto(Prodotto prodotto)
			throws ClassNotFoundException, SQLException {
		String sql = "update magazzino set ";
		boolean update = false;
		if (prodotto.getDescrizione() != null) {
			sql += "descrizione = '" + prodotto.getDescrizione() + "'";
			update = true;
		}

		if (prodotto.getNome() != null) {
			if (update)
				sql += ",";
			sql += "nome = '" + prodotto.getNome() + "'";
			update = true;
		}
		if (prodotto.getPrezzo() > 0) {
			if (update)
				sql += ",";
			sql += "prezzo = " + prodotto.getPrezzo();
			update = true;
		}
		sql += "' where codice= '" + prodotto.getCodice() + "'";
		int risp = eseguiAggiornamento(sql);
		return risp;
	}

	/**
	 * Il parametro codice rappresenta la chiave primaria della tabella
	 * 'magazzino'
	 * 
	 * @param codice
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public int cancellaProdotto(String codice) throws ClassNotFoundException,
			SQLException {
		String sql = "delete from magazzino  where codice= '" + codice + "'";

		int risp = eseguiAggiornamento(sql);
		return risp;
	}

	@Override
	public long createMovimento(Prodotto prodotto, long quantita, String causale)
			throws ClassNotFoundException, SQLException {

		Date date = new Date();
		long orario = date.getTime();
		try {

			String sql = "insert into movimenti (codiceprodotto, qta, causale, time) "
					+ "values ('"
					+ prodotto.getCodice()
					+ "',"
					+ quantita
					+ ", '" + causale + "'," + orario + ")";

			int r = eseguiAggiornamento(sql);

			if (r > 0)
				return orario;
			else
				throw new Exception("Inserimento non avvenuto");
		} catch (Exception exc) {

		}
		return orario;

	}

	
	@Override
	public int modificaMovimenti(Prodotto prodotto, long qta, String causale,
			long orario) throws ClassNotFoundException, SQLException {

		String sql = "update movimenti set codiceprodotto = '"
				+ prodotto.getCodice() + "', qta = " + qta + ", causale = '"
				+ causale + "' where time= " + orario;

		int risp = eseguiAggiornamento(sql);
		return risp;

	}
	
	@Override
	public int cancellaMovimenti(long orario) throws ClassNotFoundException,
			SQLException {
		String sql = "delete from movimenti  where time= " + orario + "";

		int risp = eseguiAggiornamento(sql);
		return risp;
	}
	
	@Override
	public long restituisciGiacenza(Prodotto prodotto) throws SQLException {

		long result = 0;
		String sql = "select sum(qta) from movimenti where codiceprodotto = '"
				+ prodotto.getCodice() + "'";

		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		PreparedStatement prst = connessione.prepareStatement(sql);
		ResultSet rs = prst.executeQuery(sql);

		if (rs.next())
			result = (long) rs.getLong(1);

		System.out.print("la giacenza e' di " + result + " articoli");
		connessione.close();
		return result;

	}

	@Override
	protected List<Prodotto> rsToLista(ResultSet rs) throws SQLException {
		List<Prodotto> result = new ArrayList<Prodotto>();

		while (rs.next()) {
			Prodotto prod = new Prodotto();
			prod.setCodice(rs.getString("CODICE"));
			prod.setNome(rs.getString("NOME"));
			prod.setCategoria(rs.getString("CATEGORIA"));
			prod.setSottoCategoria(rs.getString("SOTTOCATEGORIA"));
			prod.setDescrizione(rs.getString("DESCRIZIONE"));
			//prod.setQta(rs.getInt("QTA"));
			prod.setPrezzo(rs.getInt("PREZZO"));
			result.add(prod);

		}
		return result;

	}

	@Override
	public Prodotto readProdotto(String codice) throws SQLException , ProdottoInesistente{
		Prodotto prodotto = null;
		String sqlString = "Select * from magazzino where codice ='"+codice+"'";

		prodotto = eseguiQuery(sqlString).get(0);
		if(prodotto!=null){
			return prodotto;
		}
		throw new ProdottoInesistente(codice);
	}

	@Override
	public List<Prodotto> readProdotti() throws SQLException {
		List<Prodotto> prodotti = null;
		String sqlString = "Select * from magazzino";
		
		prodotti = eseguiQuery(sqlString);
		
		return prodotti;
	}

	
//	
//	@Override
//	public Prodotto readProdotto(String codice) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int modificaMovimenti(Prodotto prodotto)
//			throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int cancellaProdotto(Prodotto prodotto)
//			throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public long restituisciGiacenza() throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int modificaMovimenti(Prodotto prodotto, long codmovimento)
//			throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int createmovimento(Prodotto prodotto, long qta, String causale) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
