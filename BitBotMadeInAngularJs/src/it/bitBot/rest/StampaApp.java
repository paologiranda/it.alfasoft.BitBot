//package it.bitBot.rest;
//
//import it.alfasoft.ecommerce.clienti.bo.Azienda;
//import it.alfasoft.ecommerce.clienti.bo.Cliente;
//import it.alfasoft.ecommerce.clienti.bo.Privato;
//import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.Appuntamento;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.NessunAppuntamento;
//import it.alfasoft.ecommerce.login.Utente;
//import it.bitBot.filter.Proxy;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//
//import com.google.gson.Gson;
//
//@Path("/stampaapp")
//public class StampaApp extends SuperService {
//	@Context
//	HttpServletRequest request;
//
//	String result = null;
//
//	@GET
//	@Produces("application/json")
//	public String stampaApp() {
//
//		it.alfasoft.ecommerce.clienti.bo.GestioneClienti boGestioneClienti = new it.alfasoft.ecommerce.clienti.bo.GestioneClienti();
//
//		List<Cliente> clienti = null;
//
//		try {
//			clienti = boGestioneClienti.listaClienti();
//		} catch (TabellaNonTrovata e1) {
//			setErrore("Errore!!! Contattare l'amministratore");
//		} catch (ErroreSistema e1) {
//			setErrore("Errore!!! Errore di Sistema!!");
//		}
//
//		it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti boGestioneAppuntamenti = new it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti();
//		ArrayList<Appuntamento> appuntamenti;
//		ArrayList<it.bitBot.rest.Appuntamento> listaApp = new ArrayList<it.bitBot.rest.Appuntamento>();
//		Utente ut = (Utente) request.getSession(false).getAttribute(
//				Proxy.UTENTE);
//		// result.addAttribute("User", ut.getMail());
//		int id = Integer.parseInt(ut.getCodUtente().substring(1));
//		try {
//			appuntamenti = boGestioneAppuntamenti.getAppuntamenti();
//
//			it.bitBot.rest.Appuntamento appuntamentoNuovo = new it.bitBot.rest.Appuntamento();
//			for (Appuntamento p : appuntamenti) {
//				GregorianCalendar data = p.getData();
//				long timestamp = data.getTimeInMillis();
//				Timestamp datat = new Timestamp(timestamp);
//				if (p.getIDAdmin() == id) {
//					for (Cliente c : clienti) {
//						if (c.getCodiceCliente() == p.getCodiceCliente()) {
//							if (c.getCategoria().name()
//									.equalsIgnoreCase("Azienda")) {
//								Azienda azienda = (Azienda) c;
//								appuntamentoNuovo.setNome(azienda
//										.getRagioneSociale());
//
//							} else {
//								Privato privato = (Privato) c;
//								appuntamentoNuovo.setNome(privato.getNome());
//
//							}
//						}
//					}
//					appuntamentoNuovo.setData(datat.toString());
//					appuntamentoNuovo.setIdCliente(p.getCodiceCliente());
//					appuntamentoNuovo.setDescrizione(p.getDescrizione());
//
//					listaApp.add(appuntamentoNuovo);
//
//				}
//
//			}
//		} catch (NessunAppuntamento e) {
//			setErrore("Non c'e' nessun appuntamento in programma");
//		}
//		Gson gson = new Gson();
//		result = gson.toJson(listaApp);
//		return result;
//	}
//
//}
