package it.alfasoft.ecommerce.integration;

import java.sql.SQLException;

import it.alfasoft.ecommerce.integration.dao.DAOMagazzino;
import it.alfasoft.ecommerce.integration.dto.Prodotto;

public class CaricareMagazzino {
	
	public static void main(String[] args) throws ClassNotFoundException{
		MagazzinoMock m = new MagazzinoMock();
//		for(Prodotto p : m.elencoProdotti()){
//			System.out.println(p.toString());
//		}
		
		DAOMagazzino dm = new DAOMagazzino();
		
		for(Prodotto p : m.elencoProdotti()){
			try {
				dm.createProdotto(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore db"+e.toString());
			}
			finally{
				System.out.println("Prodotti caricati");
			}
		}
	}
}
