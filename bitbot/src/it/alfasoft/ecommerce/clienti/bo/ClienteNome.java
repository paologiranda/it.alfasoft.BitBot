package it.alfasoft.ecommerce.clienti.bo;

public class ClienteNome {
	int codiceCliente;
	String nome;
	
	public ClienteNome(){}
	
	public ClienteNome(String nome, int codiceCliente) {
		this.nome = nome;
		this.codiceCliente = codiceCliente;
	}

	public int getCodiceCliente() {
		return codiceCliente;
	}
	
	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
