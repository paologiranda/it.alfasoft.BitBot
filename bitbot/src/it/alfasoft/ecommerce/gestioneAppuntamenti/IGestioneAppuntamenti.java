package it.alfasoft.ecommerce.gestioneAppuntamenti;

import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IGestioneAppuntamenti {
		public void aggiungiAppuntamento(Appuntamento appuntamento) throws ErroreSistema, ClienteInesistente;
		public void eliminaAppuntamento(Appuntamento appuntamento) throws AppuntamentoInesistente;
		public ArrayList<Appuntamento> getAppuntamenti() throws NessunAppuntamento;
		public void dataIsAvaiable(GregorianCalendar data, int IDadmin) throws DataOccupata;
		void modificaAppuntamento(Appuntamento appuntamento, GregorianCalendar data) throws AppuntamentoInesistente;

}
