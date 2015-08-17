//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//import it.alfasoft.ecommerce.acquisto.GestioneOrdini;
//import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
//import it.alfasoft.ecommerce.integration.Prodotto;
//import it.alfasoft.ecommerce.integration.MagService;
//import it.alfasoft.ecommerce.integration.MagazzinoMock;
//
//
//
//public class MainOrdini {
//	private static Scanner sc = new Scanner(System.in);
//	private static	Map<Integer,Prodotto> prodottiMap = new TreeMap<Integer,Prodotto>();
//	private static ArrayList<Prodotto> prodottiScelti = new ArrayList<Prodotto>();
//	public static void main(String[] args) throws ErroreSistema {
//			mostraProdotti();
//			inserisciProdotti();
//			mostraProdottiScelti();
//			GestioneOrdini go = new GestioneOrdini();
//			while(go.acquisto(prodottiScelti, 1)==0){
//				mostraProdotti();
//				inserisciProdotti();
//				mostraProdottiScelti();
//			}
//			if(prodottiScelti.size()>0){
//				System.out.println("Ordine effettuato con successo.");
//			}
//	}
//	
//	private static void mostraProdotti(){
//		ArrayList<Prodotto> prodottiList = new ArrayList<Prodotto>();
//		MagService magazzino = new MagazzinoMock();
//		prodottiList = magazzino.elencoProdotti();
//		System.out.println("Nome prodotto/Prezzo");
//		for (int i = 0; i<prodottiList.size(); i++){
//			prodottiMap.put(i+1, prodottiList.get(i));
//			System.out.println((i+1)+") "+prodottiMap.get(i+1).getNome()+"\t"+prodottiMap.get(i+1).getPrezzo());
//		}
//		System.out.println("Inserisci il numero corrispondente al prodotto che vuoi ordinare.");
//		System.out.println("Premi 0 per confermare l'acquisto");
//	}
//	
//	private static void inserisciProdotti(){
//		boolean acquistoTerminato = false;
//		String sceltaProdotto;
//		int prodottoScelto;
//		while(!acquistoTerminato){
//				// implementare controllo sul numero inserito
//			try{
//				sceltaProdotto = sc.nextLine();
//				prodottoScelto = Integer.parseInt(sceltaProdotto);
//				if(prodottoScelto==0){
//					acquistoTerminato=true;
//					break;
//				}
//				if(prodottoScelto<0 || prodottoScelto>prodottiMap.size()){
//					System.out.println("Il numero non corrisponde a nessun prodotto.");
//					continue;
//				}
//				prodottiScelti.add(prodottiMap.get(prodottoScelto));
//				System.out.println("Prodotto aggiunto al carrello.");
//			}catch (NumberFormatException nfe){
//				System.out.println("Valore inserito non valido.");
//				continue;
//			}
//				
//		}
//	}
//	
//	private static void mostraProdottiScelti(){
//		System.out.println("Prodotti selezionati:");
//		for(Prodotto p : prodottiScelti){
//			System.out.println(p.getNome() +" "+ p.getPrezzo());
//		}
//	}
//}
