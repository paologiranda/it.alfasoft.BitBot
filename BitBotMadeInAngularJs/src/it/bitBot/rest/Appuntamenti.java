//package it.bitBot.rest;
//
//import it.alfasoft.ecommerce.clienti.bo.Azienda;
//import it.alfasoft.ecommerce.clienti.bo.Cliente;
//import it.alfasoft.ecommerce.clienti.bo.Privato;
//import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
//import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.Appuntamento;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.AppuntamentoInesistente;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.NessunAppuntamento;
//import it.alfasoft.ecommerce.login.Utente;
//import it.bitBot.filter.Proxy;
//
//import java.sql.Timestamp;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//
//import com.google.gson.Gson;
//
//@Path("/appuntamenti")
//public class Appuntamenti extends SuperService{
//	
//	private HttpServletRequest request;
//	
//	
//	@Path("/aggiungiapp")
//	@POST
//	@Produces("application/json")
//	public void aggiungiApp(@QueryParam("idCliente") String idCliente,
//			@QueryParam("anno") String anno,
//			@QueryParam("mese") String mese,
//			@QueryParam("giorno") String giorno, @QueryParam("ora") String ora,
//			@QueryParam("descr") String descr) {
//		Utente ut = (Utente) request.getSession(false).getAttribute(
//				Proxy.UTENTE);
//		request.getSession().setAttribute("Utente", ut);
//		int idA= Integer.valueOf(ut.getCodUtente().substring(1));
//		//int idA = Integer.valueOf(id);
//		String desc = descr;
//		
//		int idc = Integer.valueOf(idCliente);
//		int a = Integer.valueOf(anno);
//		int m = Integer.valueOf(mese) - 1;
//		int g = Integer.valueOf(giorno);
//		int o = Integer.valueOf(ora);
//
//		GregorianCalendar data = new GregorianCalendar(a, m, g, o, 30);
//		Appuntamento app = new Appuntamento(data, idc, idA, desc);
//		String ok = "Appuntamento aggiunto con successo";
//
//		it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti boGestioneAppuntamenti = new it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti();
//
//		try {
//			boGestioneAppuntamenti.aggiungiAppuntamento(app);
//			setMessaggio(ok);
//		} catch (ErroreSistema e) {
//			setErrore("Errore di sistema");
//		} catch (ClienteInesistente e) {
//			setErrore("Errore!! Cliente non esistente");
//		}
//		
//	}
//	
//	String result = null;
//
//	@Path("/stampaapp")
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
//	@Path("/eliminaapp")
//	@POST
//	@Produces("application/json")
//	public void eliminaApp(@QueryParam("codCliente") String codCliente,
//			@QueryParam("data") String data) {
//		Utente ut = (Utente) request.getSession(false).getAttribute(
//				Proxy.UTENTE);
//		request.getSession().setAttribute("Utente", ut);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = null;
//
//		int idA = Integer.valueOf(ut.getCodUtente().substring(1));
//		// int idA = Integer.valueOf(id);
//		int codC = Integer.valueOf(codCliente);
//		try {
//			date = format.parse(data);
//
//		} catch (ParseException e1) {
//
//		}
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.setTime(date);
//		Appuntamento appuntamento = new Appuntamento(calendar, codC, idA, null);
//
//		String ok = "eliminazione andata a buon fine";
//
//		it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti boGestioneAppuntamenti = new it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti();
//
//		try {
//			boGestioneAppuntamenti.eliminaAppuntamento(appuntamento);
//			setMessaggio(ok);
//		} catch (AppuntamentoInesistente e) {
//			setErrore("Errore, Non ci sono Appuntamenti");
//		}
//
//	}
//	
//	
//	@Path("/modificaapp")
//	@POST
//	@Produces("application/json")
//	public void eliminaApp( @QueryParam("anno") String anno, @QueryParam("mese") String mese , @QueryParam("giorno") String giorno, @QueryParam("ora") String ora ) {
//		Utente ut = (Utente) request.getSession(false).getAttribute(Proxy.UTENTE);
//		request.getSession().setAttribute("Utente", ut);
//		int idA= Integer.valueOf(ut.getCodUtente().substring(1));
//	
//		int a=Integer.valueOf(anno);
//		int m=Integer.valueOf(mese)-1;
//		int g=Integer.valueOf(giorno);
//		int o=Integer.valueOf(ora);
//		String ok="modifica andata a buon fine";
//		
//		ArrayList<Appuntamento> appuntamenti=null;
//		it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti boGestioneAppuntamenti = new it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAppuntamenti();
//			
//			try {
//				try {
//					appuntamenti = boGestioneAppuntamenti.getAppuntamenti();
//				} catch (NessunAppuntamento e) {
//					setErrore("Non c'e' nessun appuntamento in programma");
//				}
//				GregorianCalendar data = new GregorianCalendar(a,m,g,o, 30);
//				boGestioneAppuntamenti.modificaAppuntamento(appuntamenti.get(idA), data);
//				setMessaggio(ok);
//			} catch (AppuntamentoInesistente e) {
//				setErrore("Errore, Non ci sono Appuntamenti");
//			}
//			
//	
//}
//
//}
