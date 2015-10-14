package it.alfasoft.ecommerce.local.test;

import it.alfasoft.ecommerce.local.dao.DAOLocalita;
import it.alfasoft.ecommerce.local.dto.Comune;
import it.alfasoft.ecommerce.local.dto.Provincia;
import it.alfasoft.ecommerce.local.dto.Regione;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TLocal {
	public static void main(String[] args) {
		
		
		List<Regione> regioni = new ArrayList<Regione>();
		List<Provincia> province = new ArrayList<Provincia>(); 
		List<Comune> comuni = new ArrayList<Comune>();
		
		try {
			DAOLocalita loc = new DAOLocalita();
			//regioni = loc.leggiRegioni();
			//province = loc.leggiProvince(1);
			comuni = loc.leggiComuni(1, 1);
			
//			for(Regione reg: regioni){
//				
//				System.out.println(reg.getId() +" " + reg.getNome());
//			}
//			for(Provincia prov: province){
//				
//				System.out.println(prov.getIdprovincia() +" " + prov.getIdregione()+" " + prov.getNomeprovincia()+" " + prov.getSiglaprovincia());
//			}
			for(Comune comune: comuni){
				System.out.println(comune.getCatasto() +" " + comune.getId()+" " + comune.getIdprovincia()+" " + comune.getIdregione()+" " + comune.getNomecomune());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
