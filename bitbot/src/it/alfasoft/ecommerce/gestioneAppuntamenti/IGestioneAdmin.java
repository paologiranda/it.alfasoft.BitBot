package it.alfasoft.ecommerce.gestioneAppuntamenti;

public interface IGestioneAdmin {
	public void registrazioneAdmin(Admin adm) throws UtenteGiaEsistente, ErroreSistema;

	public void modificaAdmin(Admin adm,Admin admMod) throws AdminNonTrovato, ErroreSistema;

	public int cercaAdmin(Admin adm) throws AdminNonTrovato, ErroreSistema;

	public void eliminaAdmin(Admin admdel) throws AdminNonTrovato, ErroreSistema;
}
