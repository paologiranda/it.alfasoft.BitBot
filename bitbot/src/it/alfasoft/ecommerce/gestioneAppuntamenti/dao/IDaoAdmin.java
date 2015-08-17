package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;


import java.sql.SQLException;
import java.util.List;

public interface IDaoAdmin {

	public int createDtoAdmin(DtoAdmin dtoa) throws SQLException;
	    
    public List<DtoAdmin> readDtoAdmin() throws SQLException;
   
    public int updateDtoAdmin(DtoAdmin admindaMod, DtoAdmin adminMod) throws SQLException;
  
    public int deleteDtoAdmin(DtoAdmin adm) throws SQLException;

	public int searchAdmin(DtoAdmin adm) throws SQLException;

    	
}
