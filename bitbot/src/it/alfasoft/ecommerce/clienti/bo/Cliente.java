package it.alfasoft.ecommerce.clienti.bo;

import java.io.Serializable;




public abstract class Cliente implements Comparable<Cliente>,Serializable{

	private static final long serialVersionUID = 1L;
	
	CategoriaCliente categoria;
	int attivo;
	String telefono;
	String mail; 
	int codiceCliente;
	String codiceConferma;
	String paese;
	String citta;
	String provincia;
	int piano;
	String scala;
	CategoriaVia via;
	String nomeVia;
	int cap;
	String numeroCivico;
	String password;
	
	public Cliente(CategoriaCliente categoria, String telefono,
			String mail,String paese, String citta, String provincia, int piano,
			String scala, CategoriaVia via, String nomeVia, int cap,
			String numeroCivico, String password) {
		this.categoria = categoria;
		this.telefono = telefono;
		this.mail = mail;
		this.paese = paese;
		this.citta = citta;
		this.provincia = provincia;
		this.piano = piano;
		this.scala = scala;
		this.via = via;
		this.nomeVia = nomeVia;
		this.cap = cap;
		this.numeroCivico = numeroCivico;
		this.password = password;
		this.attivo=0;
	}
	public CategoriaCliente getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaCliente categoria) {
		this.categoria = categoria;
	}
	public int isAttivo() {
		return attivo;
	}
	public void setAttivo(int attivo) {
		this.attivo = attivo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return mail;
	}
	public void setEmail(String mail) {
		this.mail = mail;
	}
	public int getCodiceCliente() {
		return codiceCliente;
	}
	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}
	public String getCodiceConferma() {
		return codiceConferma;
	}
	public void setCodiceConferma(String codiceConferma) {
		this.codiceConferma = codiceConferma;
	}
	public int compareTo(Cliente o){
		if(this.codiceCliente>o.codiceCliente)
		return 1;
		else if (this.codiceCliente==o.codiceCliente)
				return 0;
		return -1;
	}
	public String getPaese() {
		return paese;
	}
	public String getCitta() {
		return citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public int getPiano() {
		return piano;
	}
	public String getScala() {
		return scala;
	}
	public CategoriaVia getVia() {
		return via;
	}
	public String getNomeVia() {
		return nomeVia;
	}
	public int getCap() {
		return cap;
	}
	public String getNumeroCivico() {
		return numeroCivico;
	}
	public String getPassword() {
		return password;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setPiano(int piano) {
		this.piano = piano;
	}
	public void setScala(String scala) {
		this.scala = scala;
	}
	public void setVia(CategoriaVia via) {
		this.via = via;
	}
	public void setNomeVia(String nomeVia) {
		this.nomeVia = nomeVia;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
