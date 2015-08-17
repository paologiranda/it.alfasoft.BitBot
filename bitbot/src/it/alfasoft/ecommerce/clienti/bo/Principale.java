package it.alfasoft.ecommerce.clienti.bo;

import it.alfasoft.ecommerce.clienti.exception.CfGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.DatabaseNonTrovato;
import it.alfasoft.ecommerce.clienti.exception.PivaGiaRegistrata;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principale {
	static Scanner sc = new Scanner(System.in);
	static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "clientiBo.xml" });
	static GestioneClienti gestCli = ctx.getBean("clienti", GestioneClienti.class);



	public static void main(String[] args) throws PivaGiaRegistrata, CfGiaRegistrato, TabellaNonTrovata, DatabaseNonTrovato, ClienteInesistente, ErroreSistema {
		Principale p = new Principale();
		p.addClients();
	} 

	public void addClients() throws PivaGiaRegistrata, CfGiaRegistrato, TabellaNonTrovata, DatabaseNonTrovato, ClienteInesistente, ErroreSistema {
		int scelta = 0;

		System.out.println("Registrazione in corso");
		System.out.println("Scegli la tipologia di utente : ");
		System.out.println("0 -> Esci dal programma");
		System.out.println("1 -> Azienda");
		System.out.println("2 -> Privato");
		scelta = inserisciIntero(1,1);
		
		if (scelta == 1) {
			System.out.println("Scegli la ragione sociale:");
			String ragioneSociale = inserisciValori(1,30);
			System.out.println("Scegli la partita iva:");
			String pIva = inserisciValori(1,11);
			getDatiAzienda(ragioneSociale, pIva,scelta);
			addClients();

		} else if (scelta == 2) {
			System.out.println("Scegli il nome:");
			String nome = inserisciValori(1,20);
			System.out.println("Scegli il cognome:");
			String cognome = inserisciValori(1,20);
			System.out.println("Scegli il codice fiscale:");
			String codiceFiscale = inserisciValori(1,16);
			getDatiCliente(nome, cognome,codiceFiscale ,scelta);
			addClients();
		}
		else if (scelta != 0){
			System.out.println("Scegli un valore tra 1 e 2");
			System.out.println("*************************************");
			addClients();
		}
		
		
		
	}

	private void getDatiAzienda(String ragioneSociale, String pIva, int scelta) throws PivaGiaRegistrata, TabellaNonTrovata, DatabaseNonTrovato, ClienteInesistente, ErroreSistema {
		System.out.println("Scegli il numero di telefono:");
		String telefono = inserisciValori(1,12);
		System.out.println("Scegli la mail:");
		String mail = inserisciValori(1,50);
		String tipoVia = getVia();
		System.out.println("Scegli il nome della via:");
		String nomeVia = inserisciValori(1,25);
		System.out.println("Scegli il numero civico :");
		String numCivico = inserisciValori(1,3);
		System.out.println("Scegli la scala:");
		String scala = inserisciValori(0,2);
		System.out.println("Scegli il piano:");
		int piano = inserisciIntero(0,3);
		System.out.println("Scegli il cap :");
		int cap = inserisciIntero(5,5);
		System.out.println("Scegli la citta':");
		String citta = inserisciValori(1,20);
		System.out.println("Scegli il paese:");
		String paese = inserisciValori(1,20);
		System.out.println("Scegli la provincia:");
		String provincia = inserisciValori(2,2);
		System.out.println("Scegli la password:");
		String password = inserisciValori(1,16);
	
		try {
			int risAggiunta = gestCli.aggiungiCliente(ragioneSociale, pIva,
					CategoriaCliente.Azienda, telefono, mail, paese, citta,
					provincia, piano, scala, CategoriaVia.valueOf(tipoVia),
					nomeVia, cap, numCivico, password);
		} catch (ClienteGiaRegistrato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
	}

	private void getDatiCliente(String nome, String cognome, String codiceFiscale, int scelta) throws CfGiaRegistrato, TabellaNonTrovata, DatabaseNonTrovato, ClienteInesistente, ErroreSistema {
		System.out.println("Scegli il numero di telefono:");
		String telefono = inserisciValori(1,12);
		System.out.println("Scegli la mail:");
		String mail = inserisciValori(1,50);
		String tipoVia = getVia();
		System.out.println("Scegli il nome della via:");
		String nomeVia = inserisciValori(1,25);
		System.out.println("Scegli il numero civico :");
		String numCivico = inserisciValori(1,3);
		System.out.println("Scegli la scala:");
		String scala = inserisciValori(0,2);
		System.out.println("Scegli il piano:");
		int piano = inserisciIntero(0,3);
		System.out.println("Scegli il cap :");
		int cap = inserisciIntero(5,5);
		System.out.println("Scegli la citta':");
		String citta = inserisciValori(1,20);
		System.out.println("Scegli il paese:");
		String paese = inserisciValori(1,20);
		System.out.println("Scegli la provincia:");
		String provincia = inserisciValori(2,2);
		System.out.println("Scegli la password:");
		String password = inserisciValori(1,16);


	

			
			try {
				int risAggiunta = gestCli.aggiungiCliente(nome, cognome,
						codiceFiscale, CategoriaCliente.Privato, telefono,
						mail, paese, citta, provincia, piano, scala,
						CategoriaVia.valueOf(tipoVia), nomeVia, cap, numCivico,
						password);
			} catch (ClienteGiaRegistrato e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private String getVia() {
		System.out.println("Scegli il tipo della via: ");
		for(CategoriaVia cv : CategoriaVia.values()) {
		     System.out.println(cv.toString());
		}
		
	//	System.out.println("Scegli il tipo della via: (Scelta tra : via, corso , piazza, strada, viale, largo ,vicolo)");
		String tipoVia = sc.nextLine();
		try{
			CategoriaVia.valueOf(tipoVia);
		}catch(Exception e){
			System.out.println("Tipo via non previsto");
			return getVia();
		}
		
		return tipoVia;
	}
	
	private String inserisciValori(int minimaLunghezza, int lunghezzaCampoConsentito) 
	{	
		try{
			String risultato =sc.nextLine();
			if(risultato.length()>lunghezzaCampoConsentito||risultato.length()<minimaLunghezza)
				throw new IllegalArgumentException();
			else if ((risultato.isEmpty() || risultato.trim().isEmpty()) && minimaLunghezza!=0)
				throw new IllegalArgumentException();
				else
					return risultato;
			
		} catch (IllegalArgumentException e ) {
			System.out.println("Devi inserire qualcosa con  meno di " + lunghezzaCampoConsentito + " caratteri" );
			return inserisciValori(minimaLunghezza,lunghezzaCampoConsentito);

		}
	}
	
		
	private int inserisciIntero(int minimaLunghezza, int lunghezzaCampoConsentito)
	{	
	
		try{
			String risultato=sc.nextLine();
			if(risultato.length()>lunghezzaCampoConsentito || risultato.length()<minimaLunghezza)
				throw new IllegalArgumentException();
			else if ((risultato.isEmpty() || risultato.trim().isEmpty())&&minimaLunghezza!=0)
				throw new IllegalArgumentException();
				else{
				if(minimaLunghezza==0)
					return 0;
				else {
				int r=Integer.parseInt(risultato);
				return r;}
			}
			
		} catch (IllegalArgumentException e ) {
			System.out.println("Devi inserire qualcosa con  meno di " + lunghezzaCampoConsentito + " caratteri" );
			return inserisciIntero(minimaLunghezza, lunghezzaCampoConsentito);

		}
		
		
				
	}
	
	
}
