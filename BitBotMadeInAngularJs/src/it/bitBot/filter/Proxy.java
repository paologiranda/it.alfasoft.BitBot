package it.bitBot.filter;

import it.alfasoft.ecommerce.login.Utente;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter
 */
public class Proxy implements Filter {
	public static final String UTENTE = "utente";

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sessione = req.getSession(false);
		Utente ut = null;
		if (sessione != null) {
			ut = (Utente) req.getSession(false).getAttribute(UTENTE);
		}
		
//		String codiceUt = "C";
//		if (ut != null) {
//			codiceUt = ut.getCodUtente();
//		}
//		if ((sessione == null || ut == null || codiceUt.contains("C"))
//				&& req.getServletPath().contains("appuntamenti")
//				&& !req.getServletPath().contains("appuntamenti/index.jsp")) {
//			System.out
//					.println(req.getContextPath() + "/appuntamenti/index.jsp");
//			resp.sendRedirect(req.getContextPath() + "/appuntamenti/index.jsp");
//		} else {
			chain.doFilter(request, response);
//		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}
