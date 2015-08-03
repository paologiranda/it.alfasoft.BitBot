//package it.bitBot.rest;
//
//import it.alfasoft.ecommerce.gestioneAppuntamenti.Appuntamento;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.AppuntamentoInesistente;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.NessunAppuntamento;
//import it.alfasoft.ecommerce.login.Utente;
//import it.bitBot.filter.Proxy;
//
//import java.util.ArrayList;
//import java.util.GregorianCalendar;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//
//@Path("/modificaapp")
//public class ModificaApp extends SuperService{
//	private HttpServletRequest request;
//
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
//}
