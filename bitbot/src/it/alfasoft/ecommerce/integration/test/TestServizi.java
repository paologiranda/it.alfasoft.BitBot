package it.alfasoft.ecommerce.integration.test;

import static org.junit.Assert.fail;
import it.alfasoft.ecommerce.integration.MagService;
import it.alfasoft.ecommerce.integration.MagazzinoMock;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

import org.junit.Assert;
import org.junit.Test;

public class TestServizi {
	static MagService magService = new MagazzinoMock();

	@Test
	public void test() throws ProdottoInesistente {
		Assert.assertNotNull(magService.dataDisponiblita("SORV001"));
		Assert.assertNotNull(magService.elencoProdotti());
		Assert.assertTrue(magService.elencoProdotti().size()>0);
		//Assert.assertTrue(magService.quantitaResidua(magService.searchProdotto("SORV001"))>=0);
		try {
			magService.searchProdotto("asdfazdf");
			fail("Il prodotto non e' presente, dunque non dovevo arrivare qui.");
		} catch (ProdottoInesistente e) {
		}
		
	}

}
