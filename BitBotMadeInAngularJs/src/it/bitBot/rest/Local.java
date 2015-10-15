package it.bitBot.rest;

import it.alfasoft.ecommerce.local.GestioneLocal;
import it.alfasoft.ecommerce.local.dao.DAOLocalita;
import it.alfasoft.ecommerce.local.dao.IDAOLocalita;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;


@Path("/local")
public class Local {
	
	private HttpServletRequest request;
	private GestioneLocal localita;
	
	@GET
	@Path("/regioni")
	@Produces("application/json")
	public String regioni (){
		
		Gson gson = new Gson();
		String regioni = null;
		
		localita = new GestioneLocal();
		regioni = gson.toJson(localita.getRegioni());
		
		return regioni;
	}

	@GET
	@Path("/province")
	public String province(@QueryParam("idregione") String idregione){
		String province;
		Gson gson = new Gson();
		
		localita = new GestioneLocal();
		
		province = gson.toJson(localita.getProvince(Integer.valueOf(idregione)));

		return province;
	}
	
	
	@GET
	@Path("/comuni")
	@Produces("application/json")
	public String comuni(@QueryParam("idregione") String idregione,@QueryParam("idprovincia") String idprovincia){
		
		Gson gson = new Gson();
		String comuni = null;
		
		localita = new GestioneLocal();
		
		comuni = gson.toJson(localita.getComuni(Integer.parseInt(idregione), Integer.parseInt(idprovincia)));
		
		return comuni;
	}
	
	

}
