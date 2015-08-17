package it.alfasoft.ecommerce.acquisto;

import it.alfasoft.ecommerce.acquisto.dto.Prenotazione;

import java.sql.SQLException;
import java.util.List;

public interface IDAOPrenotazioni {
	
	public int inseriscePrenotazione(Prenotazione prenotazione) throws SQLException;
	
	public Prenotazione prendiPrenotazione(int idPrenotazione) throws SQLException;
	
	public List<Object> prendiPrenotazioni(int codCliente) throws SQLException;
	
	public int deletePrenotazione(int idprenotazione)throws SQLException;

}
