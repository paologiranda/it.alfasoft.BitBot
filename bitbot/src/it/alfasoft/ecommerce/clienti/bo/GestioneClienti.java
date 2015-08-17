package it.alfasoft.ecommerce.clienti.bo;

import it.alfasoft.ecommerce.clienti.dao.AziendaDaoDto;
import it.alfasoft.ecommerce.clienti.dao.ClienteDaoDto;
import it.alfasoft.ecommerce.clienti.dao.IDaoGestioneClienti;
import it.alfasoft.ecommerce.clienti.dao.PrivatoDaoDto;
import it.alfasoft.ecommerce.clienti.exception.CfGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaAttivato;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.CodiceConfermaErrato;
import it.alfasoft.ecommerce.clienti.exception.PivaGiaRegistrata;
import it.alfasoft.ecommerce.clienti.exception.TabellaNonTrovata;
import it.alfasoft.ecommerce.gestioneAppuntamenti.ErroreSistema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestioneClienti implements IGestioneClientiService {


	private  IDaoGestioneClienti dao;

	public GestioneClienti(IDaoGestioneClienti dao) {
		this.dao=dao;
	}

	@Override
	public int aggiungiCliente(String ragioneSociale, String pIva,
			CategoriaCliente categoria, String telefono, String mail,
			String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password) throws ClienteGiaRegistrato,
			PivaGiaRegistrata, ErroreSistema, TabellaNonTrovata {

		
			AziendaDaoDto a = new AziendaDaoDto(ragioneSociale, pIva, telefono,
					password, mail, via + " " + nomeVia + " "
							+ numeroCivico.replace(" ", ""), cap, scala, piano,
					provincia, paese, citta);
			try {
				return dao.aggiungiCliente(a);
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				try {
					if (dao.eliminaClienteGiaRegistrato(mail) == 1) {
						System.out.println("CANCELLO");
						dao.eliminaCliente(mail);
						throw new PivaGiaRegistrata(pIva);
					}
				} catch (SQLException e1) {
					e.printStackTrace();
					throw new ErroreSistema("Errore in fase di aggiunta cliente Azienda (" + e.getSQLState() + ")",
							e.getCause());

				}
				throw new ClienteGiaRegistrato(mail, pIva);
			} catch (java.sql.SQLSyntaxErrorException e) {
				throw new TabellaNonTrovata();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ErroreSistema("Errore in fase di aggiunta cliente Azienda (" + e.getSQLState() + ")",
						e.getCause());

			}

		
	}

	@Override
	public int aggiungiCliente(String nome, String cognome,
			String codiceFiscale, CategoriaCliente categoria, String telefono,
			String mail, String paese, String citta, String provincia,
			int piano, String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password) throws ClienteGiaRegistrato,
			CfGiaRegistrato, ErroreSistema, TabellaNonTrovata {

		
			
			PrivatoDaoDto a = new PrivatoDaoDto(nome, cognome, codiceFiscale,
					telefono, password, mail, via + " " + nomeVia + " "
							+ numeroCivico.replace(" ", ""), cap, scala, piano,
					provincia, paese, citta);
			try {
				return dao.aggiungiCliente(a);
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				try {
					if (dao.eliminaClienteGiaRegistrato(mail) == 1) {
						dao.eliminaCliente(mail);
						throw new CfGiaRegistrato(codiceFiscale);
					}
				} catch (SQLException e1) {
					e.printStackTrace();
					throw new ErroreSistema("Errore in fase di eliminazione cliente Privato (" + e.getSQLState() + ")",
							e.getCause());

				}
				throw new ClienteGiaRegistrato(mail, codiceFiscale);

			} catch (java.sql.SQLSyntaxErrorException e) {
				throw new TabellaNonTrovata();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ErroreSistema("Errore in fase di aggiunta cliente Privato (" + e.getSQLState() + ")",
						e.getCause());

			}

	}

	public int attivaCliente(int codice) throws  ErroreSistema {
		try {
			return dao.attivaCliente(codice);
		}  catch (SQLException e) {
			e.printStackTrace();
			throw new ErroreSistema("Errore in fase di attivazione Cliente (" + e.getSQLState() + ")",
					e.getCause());

		}
	}

	@Override
	public int controllaAttivazione(String mail, String codConferma)
			throws ClienteInesistente, ClienteGiaAttivato, ErroreSistema, CodiceConfermaErrato {
		int codCliente;
		try {
			codCliente = dao.controlloAttivazione(mail, codConferma);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErroreSistema("Errore in fase di Controllo Attivazione (" + e.getSQLState() + ")",
					e.getCause());

		}
		if (codCliente != 0) {
			int attivazione = attivaCliente(codCliente);
			if (attivazione != 0)
				return attivazione;
			else
				throw new ClienteGiaAttivato(mail);
		} else
			try {
				if (dao.cercaCliente(mail)==0)
					throw new ClienteInesistente(mail);
				else
					throw new CodiceConfermaErrato(codConferma);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ErroreSistema("Errore in fase di Controllo Attivazione (" + e.getSQLState() + ")",
						e.getCause());
			}

	}

	@Override
	public int cercaCliente(int codice) throws ClienteInesistente {

		return 0;
	}

	@Override
	public List<Cliente> listaClienti() throws TabellaNonTrovata, ErroreSistema {

		List<Cliente> risultato = new ArrayList<Cliente>();

		try {
			List<ClienteDaoDto> listaDao = dao.listaClienti();
			for (ClienteDaoDto cliente : listaDao) {
				risultato.add(convertiDaoToBo(cliente));
			}
			return risultato;
		} catch (java.sql.SQLSyntaxErrorException e) {
			throw new TabellaNonTrovata();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErroreSistema("Errore in ricezione lista clienti (" + e.getSQLState() + ")",
					e.getCause());

		}
	}

	private Cliente convertiDaoToBo(ClienteDaoDto cliente) {
		if (cliente instanceof PrivatoDaoDto) {
			CategoriaCliente categoria = CategoriaCliente.Privato;
			PrivatoDaoDto p = (PrivatoDaoDto) cliente;
			int attivo = p.getAttivo();
			String telefono = p.getTelefono();
			String mail = p.getMail();
			int codiceCliente = p.getCodiceCliente();
			String codiceConferma = p.getCodiceConferma();
			String paese = p.getPaese();
			String citta = p.getCitta();
			String provincia = p.getProvincia();
			int piano = p.getPiano();
			String scala = p.getScala();
			String categoriaVia = getCategoriaVia(p.getVia());
			CategoriaVia via = null;
			for (int i = 0; i < CategoriaVia.values().length; i++)
				if (categoriaVia.equals(CategoriaVia.values()[i]))
					via = CategoriaVia.values()[i];
			String nomeVia = getNomeVia(p.getVia());
			int cap = p.getCap();
			String numeroCivico = getNumeroCivico(p.getVia());
			String password = p.getPassword();
			String nome = p.getNome();
			String cognome = p.getCognome();
			String codiceFiscale = p.getCodiceFiscale();
			Cliente privato = new Privato(categoria, telefono, mail, paese,
					citta, provincia, piano, scala, via, nomeVia, cap,
					numeroCivico, password, nome, cognome, codiceFiscale);
			privato.setCodiceCliente(codiceCliente);
			privato.setCodiceConferma(codiceConferma);
			privato.setAttivo(attivo);
			return privato;
		} else {
			CategoriaCliente categoria = CategoriaCliente.Azienda;
			AziendaDaoDto p = (AziendaDaoDto) cliente;
			int attivo = p.getAttivo();
			String telefono = p.getTelefono();
			String mail = p.getMail();
			int codiceCliente = p.getCodiceCliente();
			String codiceConferma = p.getCodiceConferma();
			String paese = p.getPaese();
			String citta = p.getCitta();
			String provincia = p.getProvincia();
			int piano = p.getPiano();
			String scala = p.getScala();
			String categoriaVia = getCategoriaVia(p.getVia());
			CategoriaVia via = null;
			for (int i = 0; i < CategoriaVia.values().length; i++)
				if (categoriaVia.equals(CategoriaVia.values()[i]))
					via = CategoriaVia.values()[i];
			String nomeVia = getNomeVia(p.getVia());
			int cap = p.getCap();
			String numeroCivico = getNumeroCivico(p.getVia());
			String password = p.getPassword();
			String ragioneSociale = p.getRagioneSociale();
			String pIva = p.getPartitaIva();
			Cliente azienda = new Azienda(categoria, telefono, mail, paese,
					citta, provincia, piano, scala, via, nomeVia, cap,
					numeroCivico, password, ragioneSociale, pIva);
			azienda.setCodiceCliente(codiceCliente);
			azienda.setCodiceConferma(codiceConferma);
			azienda.setAttivo(attivo);
			return azienda;
		}

	}

	private String getCategoriaVia(String indirizzo) {
		return indirizzo.split(" ")[0];
	}

	private String getNomeVia(String indirizzo) {
		String temp = "";
		for (int i = 1; i < indirizzo.split(" ").length; i++)
			temp += indirizzo.split(" ")[i];
		return temp;
	}

	private String getNumeroCivico(String indirizzo) {
		return indirizzo.split(" ")[indirizzo.split(" ").length - 1];
	}

	@Override
	public String getCodiceConferma(String mail) throws ErroreSistema, ClienteInesistente {


			try {
				return dao.ritornacodiceConferma(mail);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ErroreSistema("Errore in fase di getCodiceConferma (" + e.getSQLState() + ")",
						e.getCause());

		
			}


	}

	@Override
	public void modificaDatiPersonali(Cliente c) throws ClienteInesistente
			 {
		PrivatoDaoDto pDao;
		Privato p = null;
		Azienda a = null;
		AziendaDaoDto aDao;
		if (c.getCategoria().equals("Privato")) {
			p = (Privato) c;
			pDao = new PrivatoDaoDto(p.getNome(), p.getCognome(),
					p.getCodiceFiscale(), p.getTelefono(), p.getPassword(),
					p.getEmail(), p.getVia() + " " + p.getNomeVia() + " "
							+ p.getNumeroCivico().replace(" ", ""), p.getCap(),
					p.getScala(), p.getPiano(), p.getProvincia(), p.getPaese(),
					p.getCitta());
			try {
				dao.modificaPrivato(pDao);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ClienteInesistente(p.getEmail());
			}
		} else {
			a = (Azienda) c;
			aDao = new AziendaDaoDto(a.getRagioneSociale(), a.getpIva(),
					a.getTelefono(), a.getPassword(), a.getEmail(), a.getVia()
							+ " " + a.getNomeVia() + " "
							+ a.getNumeroCivico().replace(" ", ""), a.getCap(),
					a.getScala(), a.getPiano(), a.getProvincia(), a.getPaese(),
					a.getCitta());
			try {
				dao.modificaAzienda(aDao);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ClienteInesistente(a.getEmail());
			} 
		}

	}


}
