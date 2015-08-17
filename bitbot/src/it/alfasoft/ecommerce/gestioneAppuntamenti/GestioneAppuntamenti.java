package it.alfasoft.ecommerce.gestioneAppuntamenti;

import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.gestioneAppuntamenti.dao.DtoAppuntamento;
import it.alfasoft.ecommerce.gestioneAppuntamenti.dao.IDaoAppuntamenti;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GestioneAppuntamenti implements IGestioneAppuntamenti {
	private String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	
	private IDaoAppuntamenti db;
	
	public GestioneAppuntamenti(IDaoAppuntamenti db){
		this.db=db;
	}
	
	private Appuntamento converti(DtoAppuntamento app) {
		long timestamp = app.getData().getTime();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(timestamp);
		Appuntamento appuntamentoConvertito = new Appuntamento(cal,
				app.getCodiceCliente(), app.getIDAdmin(), app.getDescrizione());
		return appuntamentoConvertito;
	}

	private DtoAppuntamento converti(Appuntamento app) {
		long timestamp = app.getData().getTimeInMillis();
		Timestamp data = new Timestamp(timestamp);
		DtoAppuntamento appuntamentoConvertito = new DtoAppuntamento(data,
				app.getCodiceCliente(), app.getDescrizione());
		appuntamentoConvertito.setIDAdmin(app.getIDAdmin());
		return appuntamentoConvertito;
	}

	public void aggiungiAppuntamento(Appuntamento a) throws ErroreSistema, ClienteInesistente {
		
		try {
			
			DtoAppuntamento appuntamento = converti(a);
			db.createDtoAppuntamento(appuntamento);
		} catch (ConstraintViolation e){
			if(e.getMessage().contains(db.getClienteFkCostraint())){
				throw new ClienteInesistente(a.getCodiceCliente());
			}
		} catch (SQLException e) {
			throw new ErroreSistema("Errore in fase di inserimento appuntamenti",e);
		}
	}

	public void dataIsAvaiable(GregorianCalendar data, int IDadmin) throws DataOccupata {
		try {
			ArrayList<Appuntamento> elencoAppuntamenti=new ArrayList<Appuntamento>();

			elencoAppuntamenti = getAppuntamenti();
			for (Appuntamento p : elencoAppuntamenti) {
				if (p.getData().getTime().equals(data.getTime()) && p.getIDAdmin() == IDadmin)
					throw new DataOccupata();
			}
		} catch (NessunAppuntamento e) {
		}
	}

	public void eliminaAppuntamento(Appuntamento appuntamento) throws AppuntamentoInesistente {
		try {
			int result = db.deleteDtoAppuntamento(converti(appuntamento));
			if(result<=0){
				throw new AppuntamentoInesistente();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificaAppuntamento(Appuntamento appuntamento,
			GregorianCalendar data) throws AppuntamentoInesistente {
		try {
		
		Appuntamento modificato = new Appuntamento(appuntamento.getData(),appuntamento.getCodiceCliente(),appuntamento.getIDAdmin(), appuntamento.getDescrizione());
		modificato.setData(data);
		int result = db.updateDtoAppuntamenti(converti(appuntamento), converti(modificato));
		if(result<=0){
			throw new AppuntamentoInesistente();
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Appuntamento> getAppuntamenti() throws NessunAppuntamento {
		Appuntamento app;
		try {
			ArrayList<Appuntamento> elencoAppuntamenti=new ArrayList<Appuntamento>();

			
			for (DtoAppuntamento element : db.readDtoAppuntamenti()) {
				app = converti(element);
				elencoAppuntamenti.add(app);
			}
			if (elencoAppuntamenti.isEmpty()) {
				throw new NessunAppuntamento();
			} else
				return elencoAppuntamenti;
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		throw new NessunAppuntamento();

	}
	
	public void stampaAppuntamenti() throws NessunAppuntamento{
			ArrayList<Appuntamento> appuntamenti= getAppuntamenti();
			for(Appuntamento p:appuntamenti){
				GregorianCalendar data = p.getData();
				long timestamp = data.getTimeInMillis();
				Timestamp datat = new Timestamp(timestamp);
				System.out.println("Data: "+datat+" Codice Cliente: "+p.getCodiceCliente()+" Descrizione: "+p.getDescrizione());
			}
	
	}

}
