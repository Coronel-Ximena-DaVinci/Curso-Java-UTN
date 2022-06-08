package utn.cursojava.sistemabancario.service;

import utn.cursojava.sistemabancario.excepciones.CuilInvalidException;
import utn.cursojava.sistemabancario.modelos.Cliente;

public interface IClienteService {

	public void agregarCliente(Cliente cliente) throws CuilInvalidException;
	public void mostrarCliente(Cliente cliente) throws CuilInvalidException ;
}
