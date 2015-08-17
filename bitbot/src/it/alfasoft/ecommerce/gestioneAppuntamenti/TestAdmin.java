package it.alfasoft.ecommerce.gestioneAppuntamenti;

import static org.junit.Assert.fail;


import it.alfasoft.ecommerce.login.Login;
import it.alfasoft.ecommerce.login.LoginErrato;


import org.junit.Test;

public class TestAdmin {
	Login lg = new Login();
	IGestioneAdmin adminService=new GestioneAdmin();

	@Test
	public void testRegistrazioneAdmin() throws ErroreSistema, LoginErrato {
		Admin adm=new Admin("nome","cognome","psw","mail" );
		try {
			adminService.registrazioneAdmin(adm);
			adm.setID(adminService.cercaAdmin(adm));

		} catch (UtenteGiaEsistente e){
			try {
				adm.setID(adminService.cercaAdmin(adm));
			} catch (AdminNonTrovato e1) {
				fail("la ricerca non dovrebbe fallire");

			}
		} catch (AdminNonTrovato e) {
			fail("la ricerca non dovrebbe fallire");

		} 
		try {
			adminService.eliminaAdmin(adm);
		} catch (AdminNonTrovato e) {
			fail("Dovrebbe trovare l'admin");
		}
	}
	
	@Test
	public void testModificaAdmin() throws ErroreSistema{
		IGestioneAdmin adminService=new GestioneAdmin();
		Admin adm=new Admin("marco","marco","marco","marco");
		try {
			adminService.registrazioneAdmin(adm);
		} catch (UtenteGiaEsistente e1) {
			try {
				adm.setID(adminService.cercaAdmin(adm));
			} catch (AdminNonTrovato e) {
				fail("la ricerca non dovrebbe fallire");
			}
		}
		try {
			adm.setID(adminService.cercaAdmin(adm));
		}  catch (AdminNonTrovato e1) {
			fail("Il login non dovrebbe fallire");
		}
		Admin admMod=new Admin("antonio","antonio","antonio", "antonio");
		admMod.setID(adm.getID());
	
			try {
				adminService.modificaAdmin(adm, admMod);
			} catch (AdminNonTrovato e1) {
				fail("la ricerca non dovrebbe fallire");

			}
		
		try {
			adminService.eliminaAdmin(admMod);
		} catch (AdminNonTrovato e) {
			fail("Dovrebbe trovare l'admin");
		}
	}
	
	@Test
	public void testEliminaAdmin() throws AdminNonTrovato, ErroreSistema {
		IGestioneAdmin adminService=new GestioneAdmin();
		Admin adm=new Admin("marco","marco","marco","marco");
		try {
			adminService.registrazioneAdmin(adm);
		} catch (UtenteGiaEsistente e1) {
			try {
				adm.setID(adminService.cercaAdmin(adm));
			} catch (AdminNonTrovato e) {
				fail("la ricerca non dovrebbe fallire");

			}
		}
		try {
			adm.setID(adminService.cercaAdmin(adm));
		}  catch (AdminNonTrovato e1) {
			fail("Il login non dovrebbe fallire");
		}
		
		try {
			adminService.eliminaAdmin(adm);
		} catch (AdminNonTrovato e) {
			fail("Dovrebbe trovare l'admin");
		}
	}
	

}
