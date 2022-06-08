package utn.cursojava.sistemabancario.modelos;

import java.util.Date;

public class Cliente extends Persona {
	// Atributos
	protected int nroCliente;
	protected Date altaCliente;

	// Constructor
	public Cliente() {

	}
	public Cliente(String cuil) {
		super(cuil);
	}

	public Cliente(String cuil, String nombreApellido) {
		super(cuil, nombreApellido);
	}
	public Cliente(String cuil, String nombreApellido, int nroCliente) {
		super(cuil, nombreApellido);
		this.nroCliente = nroCliente;
	}
	public Date getAltaCliente() {
		return altaCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente() {
		this.nroCliente = nroCliente;
	}

	public void setAltaCliente(Date altaCliente) {
		this.altaCliente = altaCliente;
	}

}
