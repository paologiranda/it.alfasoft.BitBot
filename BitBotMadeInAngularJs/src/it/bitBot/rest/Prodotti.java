package it.bitBot.rest;

import it.alfasoft.ecommerce.integration.MagazzinoMock;
import it.alfasoft.ecommerce.integration.dao.DAOMagazzino;
import it.alfasoft.ecommerce.integration.dao.IDAOMagazzino;
import it.alfasoft.ecommerce.integration.dto.*;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

@Path("/prodotti")
public class Prodotti {
	@Context
	private HttpServletRequest request;
	private MagazzinoMock mg = new MagazzinoMock();
	private IDAOMagazzino dm =null;
	@Path("/hello")
	@GET
	@Produces("text/plain")
	public String hello(@QueryParam("nome") String nome) {
		return "hello!" + nome;
	}

	
	@GET
	@Path("/contatore")
	@Produces("text/plain")
	public String contatore() {
//		Object prova = request.getSession().getAttribute("sessioncontatore");
//		Enumeration<String> attributi = request.getSession()
//				.getAttributeNames();
		int contatore=1;
		if(request.getSession().getAttribute("sessioncontatore")!=null){
			contatore=(Integer) request.getSession().getAttribute("sessioncontatore") + 1;
		}
		request.getSession().setAttribute("sessioncontatore", contatore);
		return ((Integer) contatore).toString();
	}

	@GET
	@Path("/elenco")
	@Produces("application/json")
	public String elenco() {
		Gson gson = new Gson();
		String result = gson.toJson(mg.elencoProdotti());
		//ArrayList<Prodotto> lista = gson.fromJson(result, ArrayList.class);
		//System.out.println("prodotti:" + lista);
		return result;
	}
	
	@GET
	@Path("/elenco2")
	@Produces("application/json")
	public String elenco2() throws ClassNotFoundException {
		Gson gson = new Gson();
		//String result = gson.toJson(mg.elencoProdotti());
		
		dm = new DAOMagazzino();
		String result=null;
		try {
			result = gson.toJson(dm.readProdotti());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArrayList<Prodotto> lista = gson.fromJson(result, ArrayList.class);
		//System.out.println("prodotti:" + lista);
		return result;
	}
	
	@GET
	@Path("/prodottoScelto")
	@Produces("application/json")
	public String prodottoScelto(@QueryParam("codice") String codice) throws ClassNotFoundException, ProdottoInesistente {
		Gson gson = new Gson();
		//String result = gson.toJson(mg.elencoProdotti());
		dm = new DAOMagazzino();
		
		String result=null;
		try {
			result = gson.toJson(dm.readProdotto(codice));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArrayList<Prodotto> lista = gson.fromJson(result, ArrayList.class);
		//System.out.println("prodotti:" + lista);
		return result;
	}
	
	
	@GET
	@Path("/categoria")
	@Produces("application/json")
	public String categoria() {
		
		String result="[";
		for(Categoria c :Categoria.values()){
			if(!result.equals("[")){
				result = result + ",";
			}
			result = result+"{\"categoria\":\""+c+"\"}";
		}
		result=result+"]";
		return result;
	}
	
	@GET
	@Path("/prodotticategoria")
	@Produces("application/json")
	public String prodottiCategoria(@QueryParam("categoria") String categoria) throws ClassNotFoundException {
		Gson gson = new Gson();
		
		List<Prodotto> prodottiCategoria = new ArrayList<Prodotto>();
		dm = new DAOMagazzino();
		//System.out.println(mg.elencoProdotti().size());
		//for(Prodotto prodotto : mg.elencoProdotti()){
		try {
			for(Prodotto prodotto : dm.readProdotti()){
				if(prodotto.getCategoria().toString().equalsIgnoreCase(categoria)){
					prodottiCategoria.add(prodotto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = gson.toJson(prodottiCategoria);
		return result;
	}
	
	
	@GET
	@Path("/sottocategoria")
	@Produces("application/json")
	public String sottoCategoria(@QueryParam("categoria") String categoria,@QueryParam("sottocategoria") String sottocategoria) {
		Gson gson = new Gson();
		
		List<Prodotto> prodottiSottoCategoria = new ArrayList<Prodotto>();
		//for(Prodotto prodotto : mg.elencoProdotti()){
		try {
			for(Prodotto prodotto : dm.readProdotti()){
				if(prodotto.getCategoria().toString().equalsIgnoreCase(categoria) && prodotto.getSottoCategoria().toString().equalsIgnoreCase(sottocategoria)){
					prodottiSottoCategoria.add(prodotto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = gson.toJson(prodottiSottoCategoria);
		return result;
	}
	
	

@GET
@Path("/sottocategory")
@Produces("application/json")
 public String sottoCategory(@QueryParam("categoria") String categoria) {
    	
   	String result= null;

    	if (categoria.equalsIgnoreCase("elettronica")){
    		 result="[";
  		for(SottoCategoriaEln e :SottoCategoriaEln.values()){
    			if(!result.equals("[")){
    				result = result + ",";
    			}
    			result = result+"{\"sottocategoria\":\""+e+"\"}";
    		}
    		result=result+"]";
    	}
    	else if (categoria.equalsIgnoreCase("informatica")) {
       		 result="[";
       		for(SottoCategoriaInfo i :SottoCategoriaInfo.values()){
    			if(!result.equals("[")){
    				result = result + ",";
    			}
    			result = result+"{\"sottocategoria\":\""+i+"\"}";
    		}

       		result=result+"]";
    	}
    	
		return result;

}


@GET
@Path("/prodottisottocategoria")
@Produces("application/json")
public String prodottiCategoria(@QueryParam("categoria") String categoria,@QueryParam("sottocategoria") String sottocategoria) throws ClassNotFoundException {
	Gson gson = new Gson();
	
	List<Prodotto> prodottiSottoCategoria = new ArrayList<Prodotto>();
	List<Prodotto> temp = null;
	dm = new DAOMagazzino();
	try {
		temp = dm.readProdotti();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		for(Prodotto prodotto : temp){
			if((prodotto.getCategoria().toString().equalsIgnoreCase(categoria)) && (prodotto.getSottoCategoria().toString().equalsIgnoreCase(sottocategoria))){
				prodottiSottoCategoria.add(prodotto);
			}
		}
	String result = gson.toJson(prodottiSottoCategoria);
	return result;
}

}
