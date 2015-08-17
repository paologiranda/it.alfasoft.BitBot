package it.alfasoft.ecommerce.gestioneAppuntamenti.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class TestAppuntamenti {

	private String url = "jdbc:oracle:thin:@//localhost:1521/XE";

	@Test
	public void create() throws SQLException, ClassNotFoundException {
		IDaoAppuntamenti prova = new DaoAppuntamenti(url);
		DateFormat df = new SimpleDateFormat("MMM dd yyyy kk:mm",
				Locale.ENGLISH);
		try {
			Date data = new Date(df.parse("MAR 12 2015 20:15").getTime());
			System.out.println(data);
			Timestamp dt = new Timestamp(data.getTime());
			int IDAdmin = 1;
			DtoAppuntamento a = new DtoAppuntamento(dt, 1, "cc");
			a.setIDAdmin(IDAdmin);
			Assert.assertTrue(prova.createDtoAppuntamento(a) == 1);
			prova.deleteDtoAppuntamento(a);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void upadate() throws SQLException, ClassNotFoundException {
		IDaoAppuntamenti prova = new DaoAppuntamenti(url);
		int IDAdmin = 1;
		DateFormat df = new SimpleDateFormat("MMM dd yyyy kk:mm",
				Locale.ENGLISH);
		try {
			Date data = new Date(df.parse("MAR 12 2015 20:15").getTime());
			Timestamp dt = new Timestamp(data.getTime());
			DtoAppuntamento o = new DtoAppuntamento(dt, 1, "cc");
			o.setIDAdmin(IDAdmin);
			
			Date datan = new Date(df.parse("MAR 12 2015 21:15").getTime());
			Timestamp dtn = new Timestamp(datan.getTime());
			DtoAppuntamento n = new DtoAppuntamento(dtn, 1, "cc");
			n.setIDAdmin(IDAdmin);
			prova.createDtoAppuntamento(o);
			Assert.assertTrue(prova.updateDtoAppuntamenti(o,n) == 1);
			prova.deleteDtoAppuntamento(o);
			prova.deleteDtoAppuntamento(n);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	

	@Test
	public void read() throws SQLException, ClassNotFoundException {
		IDaoAppuntamenti prova = new DaoAppuntamenti(url);
		DateFormat df = new SimpleDateFormat("MMM dd yyyy kk:mm",
				Locale.ENGLISH);
		try {
			Date data = new Date(df.parse("MAR 12 2015 20:15").getTime());
			Timestamp dt = new Timestamp(data.getTime());
			int IDAdmin = 1;
			DtoAppuntamento c = new DtoAppuntamento(dt, 1, "cc");
			c.setIDAdmin(IDAdmin);
			prova.createDtoAppuntamento(c);
			List<DtoAppuntamento> a = prova.readDtoAppuntamenti();
			Assert.assertNotNull(a);
			Assert.assertTrue(a.size() > 0);
			prova.deleteDtoAppuntamento(c);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void delete() throws SQLException, ClassNotFoundException {
		IDaoAppuntamenti prova = new DaoAppuntamenti(url);
		DateFormat df = new SimpleDateFormat("MMM dd yyyy kk:mm",
				Locale.ENGLISH);
		try {
			Date data = new Date(df.parse("MAR 12 2015 20:15").getTime());
			// data=df.parse("03/27/15 9:0 AM");
			System.out.println(data);
			Timestamp dt = new Timestamp(data.getTime());

			int IDAdmin = 1;
			DtoAppuntamento c = new DtoAppuntamento(dt, 1, "cc");
			c.setIDAdmin(IDAdmin);
			// System.out.println("Admin"+c.getIDAdmin());
			prova.createDtoAppuntamento(c);
			List<DtoAppuntamento> a = prova.readDtoAppuntamenti();
			for (DtoAppuntamento app : a) {
				Assert.assertTrue(prova.deleteDtoAppuntamento(app) == 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
