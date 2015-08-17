package it.alfasoft.ecommerce.acquisto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.alfasoft.ecommerce.acquisto.dto.Prenotazione;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;


public class GestionePrenotazioni implements IGestionePrenotazioni {
	
	//String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	private IDAOPrenotazioni daoPrenotazioni;
		
	@Override
	public int inseriscePrenotazione(Prenotazione prenotazione) throws ErroreSistema {
		//IDAOPrenotazioni daoprenotazione;

		try {
			
			//daoprenotazione = new DAOPrenotazioni();
			setDaoPrenotazioni(daoPrenotazioni);
			 return daoPrenotazioni.inseriscePrenotazione(prenotazione);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore in fase di inserimento della prenotazione",e);
		}
	}

	@Override
	public Prenotazione getPrenotazione(int idPrenotazione) throws ErroreSistema   {
		//Prenotazione prenotazione = null;
		//IDAOPrenotazioni daoprenotazione;
		
		try {
			//daoprenotazione = new DAOPrenotazioni();
			setDaoPrenotazioni(daoPrenotazioni);
			return daoPrenotazioni.prendiPrenotazione(idPrenotazione);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore in fase di acquisizione della prenotazione",e);
		}	
	}

	@Override
	public List<Prenotazione> getPrenotazioni(int codCliente) throws ErroreSistema {
		List<Prenotazione> listaPrenotazioni =null;
		List<Object> listaTemporanea =null;
		
		try {
			//daoprenotazione = new DAOPrenotazioni();
			setDaoPrenotazioni(daoPrenotazioni);
			listaTemporanea = daoPrenotazioni.prendiPrenotazioni(codCliente);
			listaPrenotazioni=new ArrayList<Prenotazione>();
			for(Object p : listaTemporanea){
				listaPrenotazioni.add((Prenotazione)p);
			}
		
		} catch (SQLException e) {
			throw new ErroreSistema("Errore in fase di acquisizione delle prenotazioni",e);
		}
		return listaPrenotazioni;
		
	}

	@Override
	public int eliminaPrenotazione(int idPrenotazione) throws ErroreSistema {
		//IDAOPrenotazioni daoprenotazione ;
		
		try {
			//daoprenotazione = new DAOPrenotazioni();
			setDaoPrenotazioni(daoPrenotazioni);
			return daoPrenotazioni.deletePrenotazione(idPrenotazione);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore in fase di acquisizione delle prenotazioni",e);
		}
	}
	
	public void setDaoPrenotazioni( IDAOPrenotazioni daoPrenotazioni){
		this.daoPrenotazioni = daoPrenotazioni;
		
	}
	

}
