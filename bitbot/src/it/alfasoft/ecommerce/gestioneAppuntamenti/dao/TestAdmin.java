package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



public class TestAdmin {
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	
	@Test
	public void create() throws SQLException, ClassNotFoundException {
		IDaoAdmin dao= new DaoAdmin(url);
		DtoAdmin dtoa = new DtoAdmin("luca", "salzone", "luca","luca@gmail.com");
		Assert.assertTrue(dao.createDtoAdmin(dtoa)==1);
	}
	@Test
	public void read() throws SQLException, ClassNotFoundException {
		IDaoAdmin dao= new DaoAdmin(url);
		create();
		List<DtoAdmin> result = dao.readDtoAdmin();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size()>0);
	}
	
	@Test
	public void update() throws SQLException, ClassNotFoundException {
		IDaoAdmin dao= new DaoAdmin(url);
		create();
		List<DtoAdmin> adm = dao.readDtoAdmin();
		DtoAdmin a = new DtoAdmin("lca", "salze", "luca","cucca@gmail.com");
		int result = dao.updateDtoAdmin(adm.get(0),a);
		Assert.assertTrue(result == 1);
	}	
	@Test
	public void delete() throws SQLException, ClassNotFoundException {
		IDaoAdmin dao= new DaoAdmin(url);
		create();
		List<DtoAdmin> adm = dao.readDtoAdmin();
		
		for (DtoAdmin ad : adm) {
			Assert.assertTrue(dao.deleteDtoAdmin(ad)==1);
		}
	}
}
