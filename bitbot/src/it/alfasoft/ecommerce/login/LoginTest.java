package it.alfasoft.ecommerce.login;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import it.alfasoft.ecommerce.clienti.bo.CategoriaCliente;
import it.alfasoft.ecommerce.clienti.bo.CategoriaVia;
import it.alfasoft.ecommerce.clienti.bo.GestioneClienti;
import it.alfasoft.ecommerce.clienti.dao.DaoClienti;
import it.alfasoft.ecommerce.clienti.dao.IDaoGestioneClienti;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.PivaGiaRegistrata;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.Admin;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;
import it.alfasoft.ecommerce.gestioneAppuntamenti.GestioneAdmin;
import it.alfasoft.ecommerce.gestioneAppuntamenti.UtenteGiaEsistente;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginTest {
	Login lg = new Login();
	private GestioneAdmin ga = new GestioneAdmin();
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			new String[] { "clientiBo.xml" });
	GestioneClienti gc = ctx.getBean("clienti", GestioneClienti.class);

	@Test
	public void loginClienteEsistenteTest() throws ClassNotFoundException,
			ErroreSistema, TabellaNonTrovata, SQLException {

		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		IDaoGestioneClienti dao = new DaoClienti(url);

		try {
			gc.aggiungiCliente("rag", "11216", CategoriaCliente.Azienda,
					"01103253", "ciao@ciao.it", "Italia", "Torino", "TO", 3,
					"B", CategoriaVia.via, "Tripoli", 10100, "9", "ciao");
		} catch (ClienteGiaRegistrato | PivaGiaRegistrata e) {

		}

		try {
			Assert.assertNotNull(lg.login("ciao@ciao.it", "ciao"));
		} catch (LoginErrato le) {
			Assert.assertTrue(false);
		} catch (ClienteNonattivo e) {

		}
		dao.eliminaCliente("ciao@ciao.it");
	}

	@Test
	public void loginAdminEsistenteTest() throws LoginErrato, ErroreSistema,
			ClienteNonattivo {
		Admin adm = new Admin("luca", "salzone", "luca",
				"luca.salzone@gmail.com");
		try {
			ga.registrazioneAdmin(adm);
		} catch (UtenteGiaEsistente e) {

		}
		Assert.assertNotNull(lg.login("luca.salzone@gmail.com", "luca"));
	}

	@Test
	public void loginClienteNonEsistenteTest() throws ErroreSistema,
			ClienteNonattivo {
		try {
			lg.login("abvdulah", "ghirigori");
			fail("Doveva lanciare eccezione LoginErrato");
		} catch (LoginErrato le) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void loginAdminNonEsistenteTest() throws ErroreSistema,
			ClienteNonattivo {
		try {
			lg.login("abvdulah", "ghirigori");
			fail("Doveva lanciare eccezione LoginErrato");
		} catch (LoginErrato le) {
			Assert.assertTrue(true);
		}
	}
}
