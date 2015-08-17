package it.alfasoft.ecommerce.integration.test;

import it.alfasoft.ecommerce.integration.dao.DAOMagazzino;
import it.alfasoft.ecommerce.integration.dto.Categoria;
import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.dto.SottoCategoria;
import it.alfasoft.ecommerce.integration.dto.Tipo;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DAOMagazzinoTest {
	DAOMagazzino m;

	public DAOMagazzinoTest() throws ClassNotFoundException {
		super();
		this.m = new DAOMagazzino();
	}

	@Test
	public void creaProdotto() throws ClassNotFoundException, SQLException {
		Prodotto p = new Prodotto(Categoria.Elettronica,
				SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV003",
				"kit Videosorveglianza base", "Descrizione agg", false, 50);
		try {
			m.createProdotto(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
		Assert.assertTrue(m.createProdotto(p) > 0);

	}

	@Test
	public void prendi() throws SQLException{
		List<Prodotto> p = null;
		p = m.readProdotti();
		for(Prodotto i:p){
			System.out.println(i.toString());
		}		
		Assert.assertTrue(!p.isEmpty());
	}
		
	@Test
	public void modificaProdotto() throws ClassNotFoundException, SQLException {
		Prodotto p = new Prodotto(Categoria.Elettronica,
				SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV003",
				"kit Videosorveglianza base", "Descrizione agg", false, 50);
		try {
			m.createProdotto(p);
		} catch (Exception e) {
			e.printStackTrace();
		};
		int result = m.modificaProdotto("GTALLARM", 2200, "Kit Antintrusione", "SORV003");
		Assert.assertTrue(result > 0);
	}

	@Test
	public void cancellaProdotto() throws ClassNotFoundException, SQLException {
		Prodotto p = new Prodotto(Categoria.Elettronica,
				SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV003",
				"kit Videosorveglianza base", "Descrizione agg", false, 50);
		try {
			m.createProdotto(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

		int result = m.cancellaProdotto("SORV003");
		Assert.assertTrue(result > 0);
	}

	@Test
	public void createMovimento() throws ClassNotFoundException, SQLException {

		Prodotto p = new Prodotto(Categoria.Informatica,
				SottoCategoria.Hardware, Tipo.Prodotto, "SORV010",
				"pc computer", "DELL", false, 40);

		long result = m.createMovimento(p, 40, "acquisto");

		Assert.assertTrue(result > 0);

	}

	@Test
	public void modificaMovimento() throws ClassNotFoundException, SQLException {
		Prodotto p = new Prodotto(Categoria.Informatica,
				SottoCategoria.Hardware, Tipo.Prodotto, "SORV010",
				"pc computer", "DELL", false, 40);
		long time = m.createMovimento(p, 40, "acquisto");
		int result = m.modificaMovimenti(p, -34, "vendita", time);
		Assert.assertTrue(result > 0);
	}

	@Test
	public void cancellaMovimento() throws ClassNotFoundException, SQLException {
		Prodotto p = new Prodotto(Categoria.Informatica,
				SottoCategoria.Hardware, Tipo.Prodotto, "SORV010",
				"pc computer", "DELL", false, 40);

		long time = m.createMovimento(p, 40, "acquisto");
		int result = m.cancellaMovimenti(time);
		Assert.assertTrue(result > 0);
	}

	@Test
	public void calcolaGiacenza() throws SQLException, Exception {
		Prodotto p = new Prodotto(Categoria.Informatica,
				SottoCategoria.Hardware, Tipo.Prodotto, "SORV010",
				"pc computer", "DELL", false, 400);
		m.createMovimento(p, 50, "acquisto");

		long result = m.restituisciGiacenza(p);
		Assert.assertTrue(result > 0);
	}
}
