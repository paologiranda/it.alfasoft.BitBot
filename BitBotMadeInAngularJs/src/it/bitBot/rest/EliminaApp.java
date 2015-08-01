//package it.bitBot.rest;
//
//import it.alfasoft.ecommerce.gestioneAppuntamenti.Appuntamento;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.AppuntamentoInesistente;
//import it.alfasoft.ecommerce.login.Utente;
//import it.bitBot.filter.Proxy;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//
//@Path("/eliminaapp")
//public class EliminaApp extends SuperService {
//	private HttpServletRequest request;
//
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
//}
