package it.bitBot.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

@Path("/errori")
public class Errore {

	@Context
	private HttpServletRequest request;
	
	@GET
	@Path("/errore")
	@Produces("application/json")
	public String errore() {
		
		String errore = null;
		
		errore = (String) request.getSession().getAttribute("errore");
//		request.getSession().removeAttribute("errore");
		Gson gson = new Gson();
		String result = gson.toJson(errore);
		System.out.println(result);
		
		return "[" + result + "]";
	}
}
