package it.bitBot.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public abstract class SuperService {
	@Context
	private HttpServletRequest request;
	
	protected void setMessaggio(String messaggio){
		request.setAttribute("messaggio", messaggio);
	}
	protected void setErrore(String errore){
		request.setAttribute("errore",errore);
	}
	
	protected String getMessaggio(){
		return (String) request.getAttribute("messaggio");
	}
	protected String getErrore(){
		return (String) request.getAttribute("errore");
	}

}
