package it.alfasoft.ecommerce.login;

import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;

public interface ILogin {
Utente login(String mail, String pwd) throws LoginErrato, ErroreSistema, ClienteNonattivo;
}
 