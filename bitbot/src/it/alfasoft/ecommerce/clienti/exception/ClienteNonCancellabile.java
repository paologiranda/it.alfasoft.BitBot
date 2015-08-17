package it.alfasoft.ecommerce.clienti.exception;

public class ClienteNonCancellabile extends Exception {
	private static final long serialVersionUID = 1L;
	private int codiceCliente;
	public  ClienteNonCancellabile(int codiceCliente) {
		super("Il cliente con codice " + codiceCliente + " non e' eliminaile perche' gia' attivo.");
		this.codiceCliente=codiceCliente;
	}
	public int getCodiceCliente(){
		return codiceCliente;
	} 
	public int setCodiceCliente(int codiceCliente){
		return this.codiceCliente=codiceCliente;
	}
}
