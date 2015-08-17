package it.alfasoft.ecommerce.gestioneAppuntamenti;

import it.alfasoft.ecommerce.gestioneAppuntamenti.dao.*;


import java.sql.SQLException;

public class GestioneAdmin implements IGestioneAdmin{
	private String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	
	

	private DtoAdmin converti(Admin ad) {
		DtoAdmin adminConvertito = new DtoAdmin(ad.getNome(),ad.getCognome(), ad.getPassword(),ad.getEmail());
		adminConvertito.setID(ad.getID());
		return adminConvertito;
	}
	
	
	@Override
	public void registrazioneAdmin(Admin adm)
			throws UtenteGiaEsistente, ErroreSistema {
		try {
			IDaoAdmin dad = new DaoAdmin(url);
			DtoAdmin add = converti(adm);
			int risultato = dad.searchAdmin(add);
			if(risultato==0)
			dad.createDtoAdmin(add);
			else 
				throw new UtenteGiaEsistente();
		} catch (ClassNotFoundException e) {
			throw new ErroreSistema("Driver DB non trovato", e);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore nella costruzione della query", e);
		}
		
		
	}



	@Override
	public void modificaAdmin(Admin adm, Admin admMod) throws AdminNonTrovato, ErroreSistema {
		try {
			IDaoAdmin db = new DaoAdmin(url);
			int result = db.updateDtoAdmin(converti(adm), converti(admMod));
			if(result<=0){
				throw new AdminNonTrovato();
			}
			} catch (ClassNotFoundException e) {
				throw new ErroreSistema("Driver DB non trovato", e);
			} catch (SQLException e) {
				throw new ErroreSistema("Errore nella costruzione della query", e);
			}
	}

	@Override
	public void eliminaAdmin(Admin admindel) throws AdminNonTrovato, ErroreSistema {
		try {
			IDaoAdmin db = new DaoAdmin(url);
			int result = db.deleteDtoAdmin(converti(admindel));
			if(result<=0){
				throw new AdminNonTrovato();
			}
		} catch (ClassNotFoundException e) {
			throw new ErroreSistema("Driver DB non trovato", e);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore nella costruzione della query", e);
		}
		
	}


	@Override
	public int cercaAdmin(Admin adm) throws AdminNonTrovato, ErroreSistema {
		int risultato=0;
		try{
		IDaoAdmin dad = new DaoAdmin(url);
		 risultato = dad.searchAdmin(converti(adm));
		} catch (ClassNotFoundException e) {
			throw new ErroreSistema("Driver DB non trovato", e);
		} catch (SQLException e) {
			throw new ErroreSistema("Errore nella costruzione della query", e);
		}
		return risultato;
	}

	

	
	

}
