//package it.bitBot.rest;
//
//import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.Appuntamento;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
//import it.alfasoft.ecommerce.login.Utente;
//import it.bitBot.filter.Proxy;
//
//import java.util.GregorianCalendar;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//
//@Path("/aggiungiapp")
//public class AggiungiApp extends SuperService {
//	private HttpServletRequest request;
//
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
//}
