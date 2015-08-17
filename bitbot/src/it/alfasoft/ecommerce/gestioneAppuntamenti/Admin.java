package it.alfasoft.ecommerce.gestioneAppuntamenti;
public class Admin {
		private int ID;
		private String nome;
		private String password;
		private String cognome;
		private String email;
		public Admin(String nome, String cognome,  String password,String mail){
			this.setNome(nome);
			this.cognome=cognome;
			this.password=password;
			email=mail;
		}

		public int getID() {
			return ID;
		}
		public void setID(int id) {
			this.ID=id;
		}

		public String getPassword() {
			return password;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		}
		
