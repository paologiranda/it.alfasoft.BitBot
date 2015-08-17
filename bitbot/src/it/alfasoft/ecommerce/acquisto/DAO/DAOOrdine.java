package it.alfasoft.ecommerce.acquisto.DAO;

import it.alfasoft.ecommerce.acquisto.IDAOOrdine;
import it.alfasoft.ecommerce.acquisto.dto.Ordine;
import it.alfasoft.ecommerce.acquisto.dto.StatoOrdine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class DAOOrdine extends ADao implements IDAOOrdine {

	public DAOOrdine() throws ClassNotFoundException {
		super();
	}

	@Override
	public int creaOrdine(Ordine ordine) throws SQLException {

		
		String dataOrdineString=conversioneDataTime(ordine.getDataOrdine());
		String dataArrivoString=conversioneData(ordine.getDataArrivo());
		//System.out.println(dataOrdineString);
		//String data_in_stringa="TO_DATE('01/01/2000','mm/dd/yyyy')";

		String sqlprova="INSERT INTO ORDINI (DATAORDINE,STATO,CODCLIENTE,DATAARRIVO) values (to_date('"+dataOrdineString+"', 'dd-mm-yyyy HH:mi:ss PM'),'"+ordine.getStato()+"',"+ordine.getIdCliente()+",to_date('"+dataArrivoString+"', 'dd-mm-yyyy '))";
		System.out.println(sqlprova);
		try {
			return eseguiAggiornamento(sqlprova);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int getIdOrdineDb(int idcliente) throws SQLException {
		String url="jdbc:oracle:thin:@//localhost:1521/XE";
		
		int idordine =15;
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();

		String sql="select idordine "
				+ "from ordini "
				+ "where idordine=(select max(idordine) "
				+ "from ordini where codcliente="+idcliente+")";
		ResultSet resultset = statement.executeQuery(sql);	

		//System.out.println(sql);
		while (resultset.next())
			idordine = resultset.getInt("idordine");
		//System.out.println(idordine);
		connessione.close();
		return idordine;


	}
	
	@Override
	public List<Object> leggiOrdine(int idCliente) throws SQLException{
		List<Object> result = new ArrayList<Object>();
		String sql = "select * from ORDINI WHERE CODCLIENTE='"+idCliente+"'";
		result = eseguiQuery(sql);
		return result;
	}

	@Override
	public int updateStatoOrdine(StatoOrdine stato, int idOrdine) throws SQLException{
		String sqlString = "update ORDINI set "
				+ "STATO='" + stato.toString()+ "' "
				+ "where IDORDINE=" + idOrdine;
		try {
			return eseguiAggiornamento(sqlString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOrdine(int idOrdine) throws SQLException{
		try {
			return eseguiAggiornamento("DELETE ORDINI WHERE IDORDINE='"+idOrdine+"'");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	protected List<Object> rsToLista(ResultSet resultset) throws SQLException {
		List<Object> result= new ArrayList<Object>();
		while (resultset.next()) {
			int idCliente= resultset.getInt("codcliente");
			Calendar gc = new GregorianCalendar();
			gc.setTime(resultset.getDate("dataordine"));
			Calendar dataOrdine= gc;
			StatoOrdine stato = StatoOrdine.valueOf(resultset.getString("stato"));
			result.add(new Ordine(idCliente,dataOrdine,stato));
		}
		
		return result;
	}
	
	/**
	 * RESTITUISCE LA LISTA DI TUTTI GLI ORDINI FATTI DAI CLIENTI
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Ordine> letturaOrdini() throws SQLException{
		
		List<Ordine> ordini = new ArrayList<Ordine>();
		
		String url="jdbc:oracle:thin:@//localhost:1521/XE";
		String sqlString ="select * from ORDINI";
		
		Connection connessione = DriverManager.getConnection(url,"corso","corso");
		Statement statement = connessione.createStatement();
		
		ResultSet resultset = statement.executeQuery(sqlString );
		while(resultset.next()){
			int idCliente = resultset.getInt("CODCLIENTE");
			Calendar gc = new GregorianCalendar();
			gc.setTime(resultset.getDate("DATAORDINE"));
			Calendar dataOrdine= gc;
			StatoOrdine stato = StatoOrdine.valueOf(resultset.getString("STATO"));
			
			ordini.add(new Ordine(idCliente, dataOrdine, stato));
		}

		connessione.close();

		return ordini;
	}
	
	
	public String conversioneData(GregorianCalendar data){
		int giorno=((data.get(Calendar.DATE))); //
		int mese=((data.get(Calendar.MONTH)))+1;
		int year=((data.get(Calendar.YEAR)));
		String data_in_stringa=giorno+"-"+mese+"-"+year;
		return data_in_stringa;
	}
	public String conversioneDataTime(GregorianCalendar data){
		String AM_PM_string;
		int am_pm=((data.get(Calendar.AM_PM)));
		int giorno=((data.get(Calendar.DATE))); 
		int mese=((data.get(Calendar.MONTH)))+1; //il mese parte da zero.
		int year=((data.get(Calendar.YEAR)));
		int ora=((data.get(Calendar.HOUR)));
		if (ora==0){
			ora=12;
		}
		int minuti=((data.get(Calendar.MINUTE)));		
		int secondi=((data.get(Calendar.SECOND)));
		if(am_pm==1)
			AM_PM_string="PM";
			else
				AM_PM_string="AM";				
		
		String data_in_stringa=giorno+"-"+mese+"-"+year+" "+ora+":"+minuti+":"+secondi+ " "+AM_PM_string;
		return data_in_stringa;
	}
}