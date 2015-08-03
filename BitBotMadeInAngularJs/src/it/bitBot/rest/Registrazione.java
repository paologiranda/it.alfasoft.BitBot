package it.bitBot.rest;


import it.alfasoft.ecommerce.clienti.bo.Azienda;
import it.alfasoft.ecommerce.clienti.bo.CategoriaCliente;
import it.alfasoft.ecommerce.clienti.bo.CategoriaVia;
import it.alfasoft.ecommerce.clienti.bo.Cliente;
import it.alfasoft.ecommerce.clienti.bo.GestioneClienti;
import it.alfasoft.ecommerce.clienti.bo.IGestioneClientiService;
import it.alfasoft.ecommerce.clienti.bo.Privato;
import it.alfasoft.ecommerce.clienti.dao.DaoClienti;
import it.alfasoft.ecommerce.clienti.dao.IDaoGestioneClienti;
import it.alfasoft.ecommerce.clienti.exception.CfGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaAttivato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.CodiceConfermaErrato;
import it.alfasoft.ecommerce.clienti.exception.DatabaseNonTrovato;
import it.alfasoft.ecommerce.clienti.exception.PivaGiaRegistrata;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

@Path("/registrazione")
public class Registrazione extends SuperService {
	@Context
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	
	
	@Path("/tipovia")
	@GET
	@Produces("application/json")
	public String tipoVia(){
		Gson gson = new Gson();
		String tipoVia= gson.toJson(CategoriaVia.values());
		return tipoVia;
	}

	@Path("/hello")
	@GET
	@Produces("text/plain")
	public String hello() {
		return "hello!";
	}
	
	@Path("/sceltacliente")
	@GET
	@Produces("text/plain")

	public String hello(@QueryParam("scelta") String scelta) {
		if (scelta == null) {
			return "problema nel server";
		}
		if (scelta.equals("AZIENDA"))
			return "registrazioneAzienda";
		return "registrazionePrivato";
	}
	
	@Path("/listaClienti")
	@GET
	@Produces("application/json")
	public String listaClienti() {
		//GestioneClienti gestCli = new GestioneClienti();
		//ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "FactoryBO.xml" });
		//GestioneClienti gestCli = (GestioneClienti) ctx.getBean("daoClienti");
		
		GestioneClienti gestCli = null;
		try {
			gestCli = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new Gson();
		String ris = null;
		List<Cliente> lista = null;
		try {
			lista = gestCli.listaClienti();
			ris = gson.toJson(lista);
		} catch (TabellaNonTrovata | ErroreSistema e) {
			System.out.println("Sono entrato dentro una eccezione!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	}

	
	
	
	@Path("/listaAziende")
	@GET
	@Produces("application/json")
	public String listaAziende() {
//		GestioneClienti gestCli = new GestioneClienti();
		GestioneClienti gestCli = null;
		try {
			gestCli = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new Gson();
		String ris = null;
		List<Cliente> lista = null;
		List<Azienda> listaAzienda = new ArrayList<Azienda>();
		try {
			lista = gestCli.listaClienti();
			int contatore = 0;
			for(int i = 0 ;  i < lista.size() ; i++) {
				if(lista.get(i).getCategoria().toString().equals("Azienda")){
					contatore++;
				}
			
			}
			
			for(int i = 0 ;  i < lista.size() ; i++) {
				if(lista.get(i).getCategoria().toString().equals("Azienda")){
					listaAzienda.add((Azienda)lista.get(i));
				}
			}
			

			ris = gson.toJson(listaAzienda);
		} catch (TabellaNonTrovata | ErroreSistema e) {
			System.out.println("Sono entrato dentro una eccezione!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	}
	
	
	
	@Path("/listaPrivati")
	@GET
	@Produces("application/json")
	public String listaPrivati() {
//		GestioneClienti gestCli = new GestioneClienti();
		GestioneClienti gestCli = null;
		try {
			gestCli = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new Gson();
		String ris = null;
		List<Cliente> lista = null;
		List<Privato> listaPrivato = new ArrayList<Privato> ();
		try {
			lista = gestCli.listaClienti();
			int contatore = 0;
			for(int i = 0 ;  i < lista.size() ; i++) {
				if(lista.get(i).getCategoria().toString().equals("Privato")){
					contatore++;
				}
			
			}
			
			for(int i = 0 ;  i < lista.size() ; i++) {
				if(lista.get(i).getCategoria().toString().equals("Privato")){
					listaPrivato.add((Privato)lista.get(i));
				}
			}
			
			ris = gson.toJson(listaPrivato);
		} catch (TabellaNonTrovata | ErroreSistema e) {
			System.out.println("Sono entrato dentro una eccezione!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	}

	@Path("/registraAzienda")	
	@GET
	@Produces("text/plain")
	@Consumes("application/x-www-form-urlencoded")
	public void aggiungiAzienda(@QueryParam("PIVA") String pIva,
			@QueryParam("RAGIONESOCIALE") String ragioneSociale,
			@QueryParam("TELEFONO") String telefono,
			@QueryParam("TIPOVIA") String categoriaVia,
			@QueryParam("NOMEVIA") String nomeVia,
			@QueryParam("NUMEROCIVICO") String numeroCivico,
			@QueryParam("SCALA") String scala, @QueryParam("PIANO") int piano,
			@QueryParam("CITTA") String citta,
			@QueryParam("PROVINCIA") String provincia,
			@QueryParam("CAP") int cap, @QueryParam("PAESE") String paese,
			@QueryParam("mail") String mail,
			@QueryParam("PASSWORD") String password
	) 
	throws ClienteGiaRegistrato, PivaGiaRegistrata, ErroreSistema, TabellaNonTrovata
	{
//		IGestioneClientiService boClienti = new GestioneClienti();
		IGestioneClientiService boClienti = null;
		try {
			boClienti = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CategoriaCliente categoria = CategoriaCliente.Azienda;
		try {
			boClienti.aggiungiCliente(ragioneSociale, pIva, categoria,
					telefono, mail, paese, citta, provincia,piano, scala, CategoriaVia.valueOf(categoriaVia), nomeVia, cap,
					numeroCivico, password);
		} catch (ClienteGiaRegistrato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PivaGiaRegistrata e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TabellaNonTrovata e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (DatabaseNonTrovato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteInesistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (ErroreSistema e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
//	@Path("/registraAzienda")	
//	@POST
//	@Produces("text/plain")
//	@Consumes("application/x-www-form-urlencoded")
//	public void aggiungiAzienda(@FormParam("PIVA") String pIva,
//			@FormParam("RAGIONESOCIALE") String ragioneSociale,
//			@FormParam("TELEFONO") String telefono,
//			@FormParam("TIPOVIA") String categoriaVia,
//			@FormParam("NOMEVIA") String nomeVia,
//			@FormParam("NUMEROCIVICO") String numeroCivico,
//			@FormParam("SCALA") String scala, @FormParam("PIANO") int piano,
//			@FormParam("CITTA") String citta,
//			@FormParam("PROVINCIA") String provincia,
//			@FormParam("CAP") int cap, @FormParam("PAESE") String paese,
//			@FormParam("mail") String mail,
//			@FormParam("PASSWORD") String password
//	) 
//	throws ClienteGiaRegistrato, PivaGiaRegistrata, ErroreSistema, TabellaNonTrovata
//	{
////		IGestioneClientiService boClienti = new GestioneClienti();
//		IGestioneClientiService boClienti = null;
//		try {
//			boClienti = new GestioneClienti(new DaoClienti(url));
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		CategoriaCliente categoria = CategoriaCliente.Azienda;
//		try {
//			boClienti.aggiungiCliente(ragioneSociale, pIva, categoria,
//					telefono, mail, paese, citta, provincia,piano, scala, CategoriaVia.valueOf(categoriaVia), nomeVia, cap,
//					numeroCivico, password);
//		} catch (ClienteGiaRegistrato e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PivaGiaRegistrata e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TabellaNonTrovata e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} /*catch (DatabaseNonTrovato e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClienteInesistente e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}*/ catch (ErroreSistema e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
	@Path("/registraPrivato")	
	@GET
	@Produces("application/json")
	//@Consumes("application/x-www-form-urlencoded")
	public String aggiungiPrivato(@QueryParam("NOME") String nome,@QueryParam("COGNOME") String cognome,
			@QueryParam("CF") String codiceFiscale,
			@QueryParam("TELEFONO") String telefono,
			@QueryParam("TIPOVIA") String categoriaVia,
			@QueryParam("NOMEVIA") String nomeVia,
			@QueryParam("NUMEROCIVICO") String numeroCivico,
			@QueryParam("SCALA") String scala, @QueryParam("PIANO") int piano,
			@QueryParam("CITTA") String citta,
			@QueryParam("PROVINCIA") String provincia,
			@QueryParam("CAP") int cap, @QueryParam("PAESE") String paese,
			@QueryParam("mail") String mail,
			@QueryParam("PASSWORD") String password)
			throws ClienteGiaRegistrato, CfGiaRegistrato, ErroreSistema, TabellaNonTrovata
	 {
//		IGestioneClientiService boClienti = new GestioneClienti();
		IGestioneClientiService boClienti = null;
		try {
			boClienti = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CategoriaCliente categoria = CategoriaCliente.Privato;
		
		Privato pv = new Privato(categoria, telefono, mail, paese, citta, provincia, piano, 
				scala, CategoriaVia.valueOf(categoriaVia), nomeVia, cap, numeroCivico, password, nome, cognome, codiceFiscale);
		
			try {
				boClienti.aggiungiCliente(nome, cognome, codiceFiscale,
						categoria, telefono, mail, paese, citta, provincia,
						piano, 
						scala, 
						CategoriaVia.valueOf(categoriaVia),
						nomeVia, 
						cap, numeroCivico, password);
		
			} catch (ClienteGiaRegistrato e) {
				// TODO Auto-generated catch block
				request.getSession().setAttribute("errore", e.toString());
				e.printStackTrace();
			} catch (CfGiaRegistrato e) {
				// TODO Auto-generated catch block
				request.getSession().setAttribute("errore", e.toString());
				e.printStackTrace();
			} catch (TabellaNonTrovata e) {
				// TODO Auto-generated catch block
				request.getSession().setAttribute("errore", e.toString());
				e.printStackTrace();
			} /*catch (DatabaseNonTrovato e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClienteInesistente e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/ catch (ErroreSistema e) {
				request.getSession().setAttribute("errore", e.toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.toString());
			}
			Gson gson = new Gson();
			
			String priv= gson.toJson(pv);
			String x = "[" + priv + "]";
			
			//return "registrazione  Privato";	
			return x;
	}	
//	@Path("/registraPrivato")	
//	@POST
//	@Produces("text/plain")
//	@Consumes("application/x-www-form-urlencoded")
//	public String aggiungiPrivato(@FormParam("NOME") String nome,@FormParam("COGNOME") String cognome,
//			@FormParam("CF") String codiceFiscale,
//			@FormParam("TELEFONO") String telefono,
//			@FormParam("TIPOVIA") String categoriaVia,
//			@FormParam("NOMEVIA") String nomeVia,
//			@FormParam("NUMEROCIVICO") String numeroCivico,
//			@FormParam("SCALA") String scala, @FormParam("PIANO") int piano,
//			@FormParam("CITTA") String citta,
//			@FormParam("PROVINCIA") String provincia,
//			@FormParam("CAP") int cap, @FormParam("PAESE") String paese,
//			@FormParam("mail") String mail,
//			@FormParam("PASSWORD") String password)
//			throws ClienteGiaRegistrato, CfGiaRegistrato, ErroreSistema, TabellaNonTrovata
//	 {
////		IGestioneClientiService boClienti = new GestioneClienti();
//		IGestioneClientiService boClienti = null;
//		try {
//			boClienti = new GestioneClienti(new DaoClienti(url));
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		CategoriaCliente categoria = CategoriaCliente.Privato;
//			try {
//				boClienti.aggiungiCliente(nome, cognome, codiceFiscale,
//						categoria, telefono, mail, paese, citta, provincia,
//						piano, 
//						scala, 
//						CategoriaVia.valueOf(categoriaVia),
//						nomeVia, 
//						cap, numeroCivico, password);
//			} catch (ClienteGiaRegistrato e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (CfGiaRegistrato e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (TabellaNonTrovata e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} /*catch (DatabaseNonTrovato e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClienteInesistente e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}*/ catch (ErroreSistema e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println(e.toString());
//			}
//			
//			return "registrazione  Privato";	
//		
//	}
	@Path("/rindirizza")
	@GET
	@Produces("text/plain")
	public String redirect(@QueryParam("scelta") String scelta) {
		if (scelta == null) {
			return "problema nel server";
		}
		if (scelta.equals("registraAzienda")){
			return "registrazioneAzienda";
			}
		return "registrazionePrivato";
	}



	@Path("/attivazione") 
	@GET
	@Produces("text/plain")
	public String attivazione(@QueryParam("mail") String mail,
			@QueryParam("conferma") String conferma) throws ClienteInesistente, ClienteGiaAttivato, ErroreSistema, CodiceConfermaErrato, DatabaseNonTrovato {
		System.out.println(mail + " " + conferma);
		IGestioneClientiService boClienti = null;
		try {
			boClienti = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		int attivazione=0; 
		attivazione = boClienti.controllaAttivazione(mail, conferma);
//		int attivazione=0; 
//		attivazione = new GestioneClienti().controllaAttivazione(mail, conferma);
	
		if (attivazione==1)
			return "Attivazione riuscita!";
		else 
			return this.getErrore();
	
	}

	@GET
	@Path("/mostraCodiceConferma")
	@Produces("text/plain")
	public String mostraCodice(@QueryParam("mail") String mail) throws ErroreSistema, ClienteInesistente{
		
		IGestioneClientiService boClienti = null;
		try {
			boClienti = new GestioneClienti(new DaoClienti(url));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		 String result = boClienti.getCodiceConferma(mail);
		 return result;
	}
	
	@GET
	@Path("/eliminaCliente")
	@Produces("text/plain")
	public String deleteCliente(@QueryParam("mail") String mail) throws SQLException, ClassNotFoundException{
		
		DaoClienti daoClienti = null;
		try{
			daoClienti =  new DaoClienti(url);
			daoClienti.eliminaCliente(mail);
			}catch(ClassNotFoundException e1){
				e1.printStackTrace();
		}
		
		return "Successs";
	}
	
	@GET
	@Path("/recuperaPwd")
	@Produces("text/plain")
	public String recuperaPwd(@QueryParam("email") String email) throws ClassNotFoundException{
		
		String result = null;
		int a = 0;
		DaoClienti daoClienti = null;
		try {
			daoClienti =  new DaoClienti(url);
			a = daoClienti.recuperaPwd(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		result = gson.toJson(a);
		return result;
		
	}
	
	
	
	
	
//	@Path("/attivazione") 
//	@POST
//	@Produces("text/plain")
//	public String attivazione(@FormParam("mail") String mail,
//			@FormParam("conferma") String conferma) throws ClienteInesistente, ClienteGiaAttivato, ErroreSistema, CodiceConfermaErrato, DatabaseNonTrovato {
//		System.out.println(mail + " " + conferma);
//		IGestioneClientiService boClienti = null;
//		try {
//			boClienti = new GestioneClienti(new DaoClienti(url));
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		int attivazione=0; 
//		attivazione = boClienti.controllaAttivazione(mail, conferma);
////		int attivazione=0; 
////		attivazione = new GestioneClienti().controllaAttivazione(mail, conferma);
//	
//		if (attivazione==1)
//			return "Attivazione riuscita!";
//		else 
//			return this.getErrore();
//	}

}
