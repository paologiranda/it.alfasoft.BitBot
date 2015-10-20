package it.alfasoft.ecommerce.local;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.alfasoft.ecommerce.local.dao.DAOLocalita;
import it.alfasoft.ecommerce.local.dao.IDAOLocalita;
import it.alfasoft.ecommerce.local.dto.Comune;
import it.alfasoft.ecommerce.local.dto.Provincia;
import it.alfasoft.ecommerce.local.dto.Regione;

public class GestioneLocal {

	public IDAOLocalita daolocal;
	
	public List<Regione> getRegioni(){
		List<Regione> regioni = new ArrayList<Regione>();
		try {
			daolocal = new DAOLocalita();
			regioni = daolocal.leggiRegioni();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return regioni;
	}
	
	public List<Provincia> getProvince(int idRegione){
		
		List<Provincia> provincia = new ArrayList<Provincia>();
		
		try {
			daolocal = new DAOLocalita();
			provincia = daolocal.leggiProvince(idRegione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return provincia;
	}
	
	public List<Comune> getComuni(int idregione, int idprovincia){
		
		List<Comune> comuni = new ArrayList<Comune>();
		
		try {
			daolocal = new DAOLocalita();
			comuni = daolocal.leggiComuni(idregione, idprovincia);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comuni;
	}
		
}
