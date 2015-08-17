package it.alfasoft.ecommerce.clienti.bo;

import it.alfasoft.ecommerce.clienti.dao.IDaoGestioneClienti;
import it.alfasoft.ecommerce.clienti.exception.ClienteGiaRegistrato;
import it.alfasoft.ecommerce.clienti.exception.ClienteInesistente;
import it.alfasoft.ecommerce.clienti.exception.ClienteNonCancellabile;
import it.alfasoft.ecommerce.clienti.exception.DatabaseNonTrovato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientiMock implements IGestioneClientiService {
	private ArrayList<Cliente> elencoClienti;
	static int codiceCliente=0;
	public ClientiMock() {
		elencoClienti = new ArrayList<Cliente>();
		
		elencoClienti.add(new Privato(CategoriaCliente.Privato, "01103253", "fabiorossi@gmail.com",
				"Italia", "Torino", "TO", 3, 
				"B", CategoriaVia.via, "Tripoli", 10100,
				"9", "password523", "Fabio", "Rossi",
				"ARBARB23523L"));
		elencoClienti.get(0).codiceCliente=codiceCliente++;
		
		elencoClienti.add(new Privato(CategoriaCliente.Privato, "01103253", "Arber@gmail.com",
				"Italia", "Torino", "TO", 3,
				"B", CategoriaVia.via, "Roma", 10100,
				"9", "password2342523", "Arber", "Arber",
				"ARBARB23523L"));
		elencoClienti.get(1).codiceCliente=codiceCliente++;
		
		elencoClienti.add(new Azienda(CategoriaCliente.Azienda, "01103253", "arbersrl@gmail.com",
				"Italia", "Torino", "TO", 3,
				"B", CategoriaVia.via, "Roma", 10100,
				"9", "password2342523", "Arber SRL",
				"3125523523"));
		elencoClienti.get(2).codiceCliente=codiceCliente++;
		
		elencoClienti.add(new Azienda(CategoriaCliente.Azienda, "011321424", "cirogiggeeno@gmail.com",
				"Italia", "Torino", "TO", 3,
				"B", CategoriaVia.via, "Roma", 10100,
				"9", "password2342523", "Ciccio Giggeeno spa",
				"14314412841"));
		elencoClienti.get(3).codiceCliente=codiceCliente++;
		
		elencoClienti.add(new Privato(CategoriaCliente.Privato, "01103253", "Ciro@gmail.com",
				"Italia", "Torino", "TO", 3,
				"B", CategoriaVia.via, "Roma", 10100,
				"9", "password2342523", "Ciro", "Apapa",
				"CiroCRO4234213"));
		elencoClienti.get(4).codiceCliente=codiceCliente++;
		
	}


/*	public void aggiungiCliente(Cliente c) throws ClienteGiaRegistrato {
		for (Cliente cliente : elencoClienti) {
			String s = cliente.getEmail();
			String s2 = c.getEmail();
			if (s.equals(s2)) {
				throw new ClienteGiaRegistrato(s);
			} else 
				{
					c.setCodiceCliente(codiceCliente++);
					System.out.println(codiceCliente);
					elencoClienti.add(c);
			}
		}
	}
*/


	
	public boolean emailConferma(int i) throws ClienteInesistente {
		for (Cliente cliente : elencoClienti) {
			int num = cliente.getCodiceCliente();
			if (i == num && cliente.isAttivo() == 0) {
				String s = GeneraToken.generaToken();
				GeneraMailConferma.generaMailConferma(s);
				cliente.setCodiceConferma(s);
				return true;
			}
		}
		throw new ClienteInesistente("i");
	}




  @Override public int cercaCliente(int i) throws ClienteInesistente 
  {  
	  for (Cliente cliente : elencoClienti) { 
		  if (cliente.getCodiceCliente()==i) 
			  return i; 
		  } 
	  throw new ClienteInesistente("i"); 
  }
  
  
/*  @Override public int cercaCliente(String mail) throws ClienteInesistente 
  {  
	  for (Cliente cliente : elencoClienti) { 
		  if (cliente.getEmail()==mail) 
			  return cliente.getCodiceCliente(); 
		  } throw new ClienteInesistente(0); 
  }
*/

@Override
public int aggiungiCliente(String ragioneSociale, String pIva,
		CategoriaCliente categoria, String telefono, String mail,
		String paese, String citta, String provincia, int piano, String scala,
		CategoriaVia via, String nomeVia, int cap, String numeroCivico,
		String password) throws ClienteGiaRegistrato {
		Cliente c=new Azienda(categoria, telefono, mail,
				paese, citta, provincia, piano,
				scala, via, nomeVia, cap,
				numeroCivico, password, ragioneSociale,
				pIva);
		for (Cliente cliente:elencoClienti){
			if (cliente.mail==c.mail)
				throw new ClienteGiaRegistrato(c.mail,pIva);
			}
		codiceCliente++;
		c.setCodiceCliente(codiceCliente);
		elencoClienti.add(c);
		return 1;
}


@Override
public int aggiungiCliente(String nome, String cognome, String codiceFiscale,
		CategoriaCliente categoria, String telefono, String mail,
		String paese, String citta, String provincia, int piano, String scala,
		CategoriaVia via, String nomeVia, int cap, String numeroCivico,
		String password) throws ClienteGiaRegistrato {
	System.out.println("PROVA");
	Cliente c=new Privato(categoria, telefono, mail,
			paese, citta, provincia, piano,
			scala, via, nomeVia, cap,
			numeroCivico, password, nome, cognome, codiceFiscale);

	for (Cliente cliente:elencoClienti){
		
		if (cliente.mail==c.mail)
			throw new ClienteGiaRegistrato(c.mail,codiceFiscale);
		}
	codiceCliente++;
	c.setCodiceCliente(codiceCliente);
	System.out.println(codiceCliente);
	elencoClienti.add(c);
	return 1;
}


@Override
public List<Cliente> listaClienti() {
	
	return elencoClienti;
}





@Override
public int controllaAttivazione(String mail, String codConferma)
		throws ClienteInesistente {
	// TODO Auto-generated method stub
	return 0;
}



public String getCodiceConferma(String mail) throws ClienteInesistente {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void modificaDatiPersonali(Cliente c) throws ClienteInesistente,
		DatabaseNonTrovato {
	// TODO Auto-generated method stub
	
}




}


/*
 * @Override public void modificaDatiPersonali(Cliente c) throws
 * ClienteInesistente{ Scanner sc = new Scanner(System.in); for (Cliente cliente
 * : elencoClienti) { int num1 = c.getCodiceCliente(); int num2 =
 * cliente.getCodiceCliente(); if (num1 == num2) {
 * System.out.println("Quale campo vuoi modificare?"); String s = sc.next();
 * System.out.println("Inserisci nuovo valore per il campo " + s); String
 * nuovoValore = sc.next(); // if (s.equals(nome)) {
 * 
 * }
 * 
 * } } //throw new ClienteInesistente(c.getCodiceCliente()); }
 */

