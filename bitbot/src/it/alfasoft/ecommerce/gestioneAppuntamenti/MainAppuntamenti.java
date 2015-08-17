package it.alfasoft.ecommerce.gestioneAppuntamenti;

import it.alfasoft.ecommerce.clienti.bo.Cliente;
import it.alfasoft.ecommerce.clienti.bo.GestioneClienti;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.login.ClienteNonattivo;
import it.alfasoft.ecommerce.login.Login;
import it.alfasoft.ecommerce.login.LoginErrato;
import it.alfasoft.ecommerce.login.Utente;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainAppuntamenti {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "factoryBO.xml" });
	private static GestioneAppuntamenti appuntamenti= ctx.getBean("boGestioneAppuntamenti", GestioneAppuntamenti.class);
	private static GestioneClienti clienti = ctx.getBean("clienti", GestioneClienti.class);
	

	public static void main(String[] args) {
		Admin adm;
		try {
			adm = effettuaLogin();
		
		System.out.println("*********** LOGIN EFFETTUATO, BENTORNATO "+adm.getNome()+" ***********");
		System.out.println("*********** SCEGLI QUALE OPERAZIONE EFFETTUARE ***********");
		menu(adm.getID());
		
		} catch (LoginAdminFallito e) {
			System.out.println("Hai scelto di non effettuare il login, impossibile accedere alle funzionalita' di amministrazione");
		} catch (ClassNotFoundException e) {
			System.out.println("Errore tecnico contattare l'assistenza riportando il messaggio sottostante al numero verde 899.99.99.99");
			e.printStackTrace();
		}
	}

	private static void menu(int ID) {
		
		System.out.println("1. Aggiungi appuntamento\n2. Modifica un appuntamento gia esistente\n3. Annulla un appuntamento\n0.Logout");
		int scelta = DataFromKeyboard.insertInt();
		if(scelta!=0) {
			switch(scelta) {
			case 1: aggiungiAppuntamento(ID); 
					break;
			case 2: modificaAppuntamento(ID); 
					break;
			case 3: eliminaAppuntamento(ID); break;
			default: System.out.println("Non usare la tastiera se sei ubriaco, scelta sbagliatissima");
			}
			menu(ID);
		} else System.out.println("Logout effettuato con successo ");
	}

	private static void modificaAppuntamento(int ID) {
		System.out.println("Appuntamenti presenti:");
		try {
			stampa(ID);
			ArrayList<Appuntamento> listaAppuntamenti = getMyApp(ID);
			System.out.println("Inserisci l'indice dell'appuntamento che vuoi modificare:");
			int indapp=DataFromKeyboard.insertInt();
			while(indapp<0||indapp>listaAppuntamenti.size()){
				System.out.println("Inserisci l'indice dell'appuntamento che vuoi eliminare(compreso tra 0 e "+(listaAppuntamenti.size()-1)+"): ");
				indapp=DataFromKeyboard.insertInt();
			}
			System.out.println("Inserisci la nuova data dell'appuntamento: ");
			GregorianCalendar data=inserisciData(ID);
			appuntamenti.modificaAppuntamento(listaAppuntamenti.get(indapp), data);
		} catch (NessunAppuntamento e) {
			System.out.println("Non c'e' nessun appuntamento in programma ");

		} catch (AppuntamentoInesistente e) {
			System.out.println("L'appuntamento inserito non � stato trovato ");

		}		
	}
	private static void eliminaAppuntamento(int ID) {
		System.out.println("Appuntamenti presenti:");
		try {
			stampa(ID);
			ArrayList<Appuntamento> listaAppuntamenti = getMyApp(ID);
			System.out.println("Inserisci l'indice dell'appuntamento che vuoi eliminare:");
			int indapp=DataFromKeyboard.insertInt();
			while(indapp<0||indapp>listaAppuntamenti.size()){
				System.out.println("Inserisci l'indice dell'appuntamento che vuoi eliminare(compreso tra 0 e "+(listaAppuntamenti.size()-1)+"): ");
				indapp=DataFromKeyboard.insertInt();
			}
			appuntamenti.eliminaAppuntamento(listaAppuntamenti.get(indapp));
		} catch (NessunAppuntamento e) {
			System.out.println("Non c'e' nessun appuntamento in programma ");

		} catch (AppuntamentoInesistente e) {
			System.out.println("L'appuntamento inserito non e' stato trovato ");

		}		
	}
	private static ArrayList<Appuntamento> getMyApp(int ID) throws NessunAppuntamento {
		ArrayList<Appuntamento> listaAppuntamenti = appuntamenti.getAppuntamenti(); 
		ArrayList<Appuntamento> mieiAppuntamenti=new ArrayList<Appuntamento>();
		for(Appuntamento p:listaAppuntamenti){
			if(p.getIDAdmin()==ID) {
				mieiAppuntamenti.add(p); 
			}  
		}
		return mieiAppuntamenti;
	}

	private static void stampa(int ID) throws NessunAppuntamento {
		ArrayList<Appuntamento> listaAppuntamenti = appuntamenti.getAppuntamenti(); 
		int i=0;
		for(Appuntamento p:listaAppuntamenti){
			GregorianCalendar data = p.getData();
			long timestamp = data.getTimeInMillis();
			Timestamp datat = new Timestamp(timestamp);
			if(p.getIDAdmin()==ID) {
			System.out.println(i+". Data: "+datat+" Codice Cliente: "+p.getCodiceCliente()+" Descrizione: "+p.getDescrizione());
			i++;
			} 
		}
	}

	@SuppressWarnings("resource")
	private static void aggiungiAppuntamento(int ID) {
		try {
			System.out.println("Appuntamenti presenti:");
			stampa(ID);
		} catch (NessunAppuntamento e) {
			System.out.println("Non c'e' nessun appuntamento in programma ");
		}
		GregorianCalendar data=inserisciData(ID);
	    System.out.println("Elenco clienti");
	    //visualizzaElencoClienti();
	   /* System.out.println("Si desidera aggiungere un nuovo cliente? [S/N]");
	    String scelta = DataFromKeyboard.insertString();
		while(!scelta.equalsIgnoreCase("s") && !scelta.equalsIgnoreCase("n"))
			 scelta = DataFromKeyboard.insertString();
		if(scelta.equalsIgnoreCase("s")){}
			try {
				clienti.aggiungiCliente("AlfaSoft srl", "1", CategoriaCliente.Azienda, "1", "email", "paese", "citta", "provincia", 1, "scala", CategoriaVia.vicolo, "nomeVia", 1, "1", "password");
			} catch (ClienteGiaRegistrato e) {
				System.out.println("Cliente gia' registrato");
			}
		else
		{*/
			System.out.println("Inserire ID cliente");
			//Controllo ID cliente
			int IDcliente = DataFromKeyboard.insertInt();
			System.out.println("Inserire descrizione dell'appuntamento: ");
			Scanner sc =new Scanner(System.in);
			String descrizione = sc.nextLine();
			long timestamp = data.getTimeInMillis();
			Timestamp datat = new Timestamp(timestamp);
			
			System.out.println("Data: "+datat+" ID Cliente: "+IDcliente+" Descizione: "+descrizione);
			System.out.println("Si desidera confermare? [S/N]");
			String scelta1 = DataFromKeyboard.insertString();
			while(!scelta1.equalsIgnoreCase("s") && !scelta1.equalsIgnoreCase("n"))
				 scelta1 = DataFromKeyboard.insertString();
			if(scelta1.equalsIgnoreCase("s")){
				try {
					Appuntamento app=new Appuntamento(data,IDcliente,ID,descrizione);
					appuntamenti.aggiungiAppuntamento(app);
				} catch (ClienteInesistente e) {
					System.out.println("Inserire un ID cliente presente");
					//Controllo ID cliente
					IDcliente = DataFromKeyboard.insertInt();
				} catch (ErroreSistema e){
					
				}
				
			}
			else {
				aggiungiAppuntamento(ID);
			}
			
		//}
		
	}

	@SuppressWarnings("unused")
	private static void visualizzaElencoClienti() throws TabellaNonTrovata, ErroreSistema {
		List<Cliente> lista = clienti.listaClienti();
		for(Cliente c:lista){
			System.out.println("Codice cliente: "+c.getCodiceCliente());
		}
				
		
		
	}

	private static Admin effettuaLogin() throws LoginAdminFallito, ClassNotFoundException {
		Login lg = new Login();
		System.out.println("Inserisci il tuo nome: ");
			String nome = DataFromKeyboard.insertString();
			System.out.println("Inserisci il tuo cognome: ");
			String cognome = DataFromKeyboard.insertString();
			System.out.println("Inserisci la tua password: ");
			String password = DataFromKeyboard.insertString();
			System.out.println("Inserisci la tua mail: ");
			String mail = DataFromKeyboard.insertString();
			Admin adm = new Admin(nome,cognome,password,mail);
			try {
				Utente ut;
				try {
					ut = lg.login(adm.getEmail(), adm.getPassword());
				
				String log = ut.getCodUtente();
				if(log.contains("A")) {
					adm.setID(Integer.valueOf(log.substring(1)));
				return adm;
				}
				else throw new LoginErrato();
			} catch (LoginErrato  e) {
				System.out.println("I dati inseriti sono sbagliati, riprovare? [S/N] ");
				String scelta = DataFromKeyboard.insertString();
				while(!scelta.equalsIgnoreCase("s") && !scelta.equalsIgnoreCase("n"))
					 scelta = DataFromKeyboard.insertString();
				if(scelta.equalsIgnoreCase("s"))
				return effettuaLogin();
				else
					throw new LoginAdminFallito();
			} catch (ErroreSistema e) {
					System.out.println("errore: "+e.getMessage());
			}
			} catch (ClienteNonattivo e) {
			}
			return effettuaLogin();
	}
	
	private static GregorianCalendar inserisciData(int ID){
		System.out.println("Inserire anno: ");
		int anno=DataFromKeyboard.insertInt();
		while(anno<=2014 || anno >2100) {
			System.out.println("Inserire anno compreso tra 2015 e 2099: ");
			anno=DataFromKeyboard.insertInt();
		}
		System.out.println("Inserire mese: ");
		int mese=DataFromKeyboard.insertInt();
		while(mese<1 || mese>12){
		System.out.println("Inserire mese: ");
		mese=DataFromKeyboard.insertInt();
		}
		mese--;
		System.out.println("Inserire giorno: ");
		int giorno=DataFromKeyboard.insertInt();

			if(mese == 10 || mese == 3 || mese == 5 || mese == 8){
				while(giorno<1 || giorno>30){
				System.out.println("Inserire un giorno compreso tra 1 e 30: ");
				giorno=DataFromKeyboard.insertInt();
				}
			} else if(mese==1 && anno%4==0) {
				while(giorno<1 || giorno>29){
				System.out.println("Inserire un giorno compreso tra 1 e 29: ");
				giorno=DataFromKeyboard.insertInt();
				}
			} else if(mese==1) {
				while(giorno<1 || giorno>28){
					System.out.println("Inserire un giorno compreso tra 1 e 28: ");
					giorno=DataFromKeyboard.insertInt();
					}
			}
			else 
				while(giorno<1 || giorno>31){
					System.out.println("Inserire un giorno compreso tra 1 e 31: ");
					giorno=DataFromKeyboard.insertInt();
					}
			System.out.println("Inserire l'ora: ");
			int ora=DataFromKeyboard.insertInt();
			while(ora<0||ora>23){
				System.out.println("Inserire un orario compreso tra 0 e 23: ");
				giorno=DataFromKeyboard.insertInt();
			}
			GregorianCalendar data = new GregorianCalendar(anno,mese,giorno,ora, 30);
			try {
				appuntamenti.dataIsAvaiable(data, ID);
			} catch (DataOccupata e) {
				System.out.println("Data occupata. Inserire una data diversa");
				inserisciData(ID);
			}

			return data;
	}

}
