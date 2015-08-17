package it.alfasoft.ecommerce.gestioneAppuntamenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

	public class GestioneAppuntamentiMock implements IGestioneAppuntamenti {
	private ArrayList<Appuntamento> elencoAppuntamenti;


	public GestioneAppuntamentiMock() {
		
		elencoAppuntamenti=new ArrayList<Appuntamento>();
		

	}

	
	@Override
	public void dataIsAvaiable(GregorianCalendar data, int IDadmin) throws DataOccupata {
		for(Appuntamento p:elencoAppuntamenti){
			if(p.getData().equals(data) && p.getIDAdmin()==IDadmin) // controlla anche amministratore
				throw new DataOccupata();
		}
	}

	
	@Override
	public void eliminaAppuntamento(Appuntamento appuntamento)
			throws AppuntamentoInesistente {
		if(elencoAppuntamenti.indexOf(appuntamento)==-1){
			throw new AppuntamentoInesistente();
	}else{
	elencoAppuntamenti.remove(appuntamento);
	}
	}

	
	@Override
	public void modificaAppuntamento(Appuntamento appuntamento, GregorianCalendar data) throws AppuntamentoInesistente {
		if (elencoAppuntamenti.indexOf(appuntamento) == -1) {
			throw new AppuntamentoInesistente();
		} else {
			int a = elencoAppuntamenti.indexOf(appuntamento);
			Appuntamento mod = elencoAppuntamenti.get(a);
			mod.setData(data);
			elencoAppuntamenti.set(a, mod);
		}
	ordinaAppuntamenti();
		
	}

		public ArrayList<Appuntamento> getAppuntamenti() {
		
		return elencoAppuntamenti;
	}


	private void ordinaAppuntamenti() {
	Collections.sort(elencoAppuntamenti);
		
	}
	
	public void aggiungiAppuntamento(Appuntamento a) {
		elencoAppuntamenti.add(a);
	    ordinaAppuntamenti();
	}
}
