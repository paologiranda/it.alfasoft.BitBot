package it.bitBot.rest;

import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.login.ClienteNonattivo;
import it.alfasoft.ecommerce.login.LoginErrato;
import it.alfasoft.ecommerce.login.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;


@Path("/login")
public class Login {
	@Context
	private HttpServletRequest request;
	
	@Path("/loggin")
	@GET
	@Produces("application/json")
	public String login(
			@QueryParam("email") String email, @QueryParam("password") String psw) {
		it.alfasoft.ecommerce.login.Login boLogin = new it.alfasoft.ecommerce.login.Login();
		Utente ut = null;
		String 	result = null;
		try {
			ut = boLogin.login(email, psw);
			request.getSession().setAttribute("utente", ut);
			Gson gson = new Gson();
			result = gson.toJson(ut);
		} catch (LoginErrato e) {
			request.getSession().setAttribute("errore", e.toString());
			e.printStackTrace();
		} catch (ErroreSistema e) {
			request.getSession().setAttribute("errore", e.toString());
			e.printStackTrace();
		}catch (ClienteNonattivo e) {
			request.getSession().setAttribute("errore", e.toString());
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	@Path("/logout")
	@GET
	@Produces("text/plain")
	public String logout(){
		 request.getSession().invalidate();
			
			return "Success";
	}
	
	@Path("/loggato")
	@GET
	@Produces("application/json")
	public String loggato(){
		
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		Gson gson = new Gson();
		String result = gson.toJson(utente);
		return result;
	}
}
