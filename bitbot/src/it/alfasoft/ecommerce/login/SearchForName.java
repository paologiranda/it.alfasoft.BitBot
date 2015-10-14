package it.alfasoft.ecommerce.login;

import java.sql.SQLException;

public class SearchForName {

	DaoLogin Dao = null;
	String privato;
	String azienda;

	public String searchUtente(String mail) throws ClassNotFoundException,
			SQLException, ClienteNonattivo {
		String mailPrivato = Dao.searchDataForPrivati(mail);
		String mailAzienda = Dao.searchDataForAzienda(mail);
		
		if (mailPrivato != null){
			privato = Dao.searchDataForPrivati(mail);

		}
		if (mailAzienda != null) {
			azienda = Dao.searchDataForAzienda(mail);
		}
		return null;

	}
}
