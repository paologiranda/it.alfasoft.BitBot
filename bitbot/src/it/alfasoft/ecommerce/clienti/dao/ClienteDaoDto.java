package it.alfasoft.ecommerce.clienti.dao;



public abstract class ClienteDaoDto implements Comparable<ClienteDaoDto> {

		int attivo;
		String telefono;
		String mail;
		int codiceCliente;
		String codiceConferma;
		String via;
		int cap;
		String scala;
		int piano;
		String provincia; 
		String citta;
		String password; 
		String paese;
		public ClienteDaoDto (String telefono,String password,String mail,String via,int cap,String scala,int piano,String provincia,String paese, String citta){
			this.telefono=telefono;
			this.password=password;
			this.via=via;
			this.mail=mail;
			this.cap=cap;
			this.piano=piano;
			this.scala=scala;
			this.citta=citta;
			this.provincia=provincia;
			this.paese=paese;
			
		}

		
		


		public int isAttivo() {
			return attivo;
		}
		public void setAttivo(int attivo) {
			this.attivo = attivo;
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

		public int compareTo(ClienteDaoDto o){
			if(this.codiceCliente>o.codiceCliente)
			return 1;
			else if (this.codiceCliente==o.codiceCliente)
					return 0;
			return -1;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public String getVia() {
			return via;
		}


		public void setVia(String via) {
			this.via = via;
		}


		public int getCap() {
			return cap;
		}


		public void setCap(int cap) {
			this.cap = cap;
		}


		

		public String getScala() {
			return scala;
		}


		public void setScala(String scala) {
			this.scala = scala;
		}


		public int getPiano() {
			return piano;
		}


		public void setPiano(int piano) {
			this.piano = piano;
		}


		public int getAttivo() {
			return attivo;
		}


		public String getProvincia() {
			return provincia;
		}


		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}


		public String getCitta() {
			return citta;
		}


		public void setCitta(String citta) {
			this.citta = citta;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getPaese() {
			return paese;
		}


		public void setPaese(String paese) {
			this.paese = paese;
		}
		
}


