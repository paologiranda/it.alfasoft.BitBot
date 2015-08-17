package it.alfasoft.ecommerce.gestioneAppuntamenti;

import static org.junit.Assert.fail;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.test.SpringTest;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAppuntamenti extends SpringTest<IGestioneAppuntamenti> {
	
	private IGestioneAppuntamenti bo;
	
	@Before
	public void setBoRub() {
		IGestioneAppuntamenti provider = (IGestioneAppuntamenti)getBean("boGestioneAppuntamenti");
		this.bo = provider;
	}

	@Test
	public void testAggiungiAppuntamento() throws ErroreSistema, ClienteInesistente {
		
		int IDadmin = 111;
		GregorianCalendar data = new GregorianCalendar(2015, 04, 06, 12, 00);

		try {
			bo.dataIsAvaiable(data, IDadmin);
		} catch (DataOccupata e1) {
			fail("non dovrebbe lanciare un eccezione");
		}
		
		int codiceCliente = 111;
		String descrizione = "Info";
		Appuntamento appuntamento = new Appuntamento(data, codiceCliente,
				IDadmin, descrizione);
		
		bo.aggiungiAppuntamento(appuntamento);
		try {
			bo.dataIsAvaiable(data, IDadmin);
			fail("non dovrebbe arrivare qui");
		} catch (DataOccupata e1) {
		}
		try {
			bo.eliminaAppuntamento(appuntamento);
		} catch (AppuntamentoInesistente e) {
			fail("non dovrebbe lanciare un eccezione");
		}
	}
	@Test
	public void testModificaAppuntamento() throws ErroreSistema, ClienteInesistente {
		int IDadmin = 111;
		GregorianCalendar data = new GregorianCalendar(2015, 04, 06, 12, 00);

		try {
			bo.dataIsAvaiable(data, IDadmin);
		} catch (DataOccupata e1) {
			fail("non dovrebbe lanciare un eccezione");
		}
		
		int codiceCliente = 111;
		String descrizione = "Info";
		Appuntamento appuntamento = new Appuntamento(data, codiceCliente,
				IDadmin, descrizione);
		bo.aggiungiAppuntamento(appuntamento);
		GregorianCalendar data2 = new GregorianCalendar(2015, 04, 06, 12, 00);

		try {
			bo.modificaAppuntamento(appuntamento, data2);
			bo.eliminaAppuntamento(appuntamento);
		} catch (AppuntamentoInesistente e) {
			fail("non dovrebbe lanciare un eccezione");
		}
		try {
			bo.modificaAppuntamento(appuntamento, data2);
			fail("Dovrebbe lanciare l'eccezione");
		} catch (AppuntamentoInesistente e) {
		}
	}
	
	@Test
	public void delete() throws ErroreSistema, ClienteInesistente {
		int IDadmin = 111;
		GregorianCalendar data = new GregorianCalendar(2015, 04, 06, 12, 00);

		try {
			bo.dataIsAvaiable(data, IDadmin);
		} catch (DataOccupata e1) {
			fail("non dovrebbe lanciare un eccezione");
		}
		
		int codiceCliente = 111;
		String descrizione = "Info";
		Appuntamento appuntamento = new Appuntamento(data, codiceCliente,
				IDadmin, descrizione);
		bo.aggiungiAppuntamento(appuntamento);
		try {
			bo.eliminaAppuntamento(appuntamento);
			
		} catch (AppuntamentoInesistente e) {
			fail("Non dovrebbe lanciare l'eccezione");
		}
		try {
			bo.eliminaAppuntamento(appuntamento);
			fail(" dovrebbe lanciare l'eccezione");

		} catch (AppuntamentoInesistente e) {
		}
	}
	
}
