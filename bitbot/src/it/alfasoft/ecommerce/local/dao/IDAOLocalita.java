package it.alfasoft.ecommerce.local.dao;

import java.sql.SQLException;
import java.util.List;

import it.alfasoft.ecommerce.local.dto.Comune;
import it.alfasoft.ecommerce.local.dto.Provincia;
import it.alfasoft.ecommerce.local.dto.Regione;

public interface IDAOLocalita {
	
	public List<Regione> leggiRegioni() throws SQLException;
	
	public List<Provincia> leggiProvince(int idRegione) throws SQLException;
	
	public List<Comune> leggiComuni(int idregione, int idprovincia) throws SQLException;
	
}
