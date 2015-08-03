package it.bitBot.rest;

import it.alfasoft.ecommerce.integration.dao.DAOMagazzino;
import it.alfasoft.ecommerce.integration.dto.Categoria;
import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.dto.SottoCategoria;
import it.alfasoft.ecommerce.integration.dto.Tipo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/magazzino")
public class Magazzino {
	DAOMagazzino m;
	
	
	
	@GET
	@Path("/inserisceProdotto")
	@Produces("application/json")
	public void inserisceProdotto(
			@QueryParam("categoria") String categoria,
			@QueryParam("sottocategoria") String sottocategoria,
			@QueryParam("tipoprodotto") String tipoprodotto,
			@QueryParam("codprod") String codprod,
			@QueryParam("nome") String nome,
			@QueryParam("descrizione") String descrizione,
			@QueryParam("riservato") String riservato,
			@QueryParam("qta") String qta)
	{
		String risp = "Non creato";
		try {
			m = new DAOMagazzino();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		boolean riservatoAzienda= riservato.equalsIgnoreCase("si")? false:true;

		Prodotto p = new Prodotto(Categoria.valueOf(categoria),
				SottoCategoria.valueOf(sottocategoria), Tipo.valueOf(tipoprodotto), codprod,
				nome, descrizione, riservatoAzienda,Double.valueOf(qta));
		try {
			m.createProdotto(p);
			risp = "Creato!";
		} catch (Exception e) {
			e.printStackTrace();
		}

		//return risp;
	}
}
