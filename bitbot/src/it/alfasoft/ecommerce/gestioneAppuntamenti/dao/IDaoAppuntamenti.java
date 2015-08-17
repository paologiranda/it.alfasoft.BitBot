package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;



import it.alfasoft.ecommerce.gestioneAppuntamenti.ConstraintViolation;

import java.sql.SQLException;
import java.util.List;



public interface IDaoAppuntamenti {
	
	 public int createDtoAppuntamento(DtoAppuntamento dtoa) throws ConstraintViolation,SQLException;
	    
     public List<DtoAppuntamento> readDtoAppuntamenti() throws SQLException;
    
     public int updateDtoAppuntamenti(DtoAppuntamento appdaMod, DtoAppuntamento appMod) throws SQLException;
   
     public int deleteDtoAppuntamento(DtoAppuntamento app) throws SQLException;
     
	public String getClienteFkCostraint();
     

}
