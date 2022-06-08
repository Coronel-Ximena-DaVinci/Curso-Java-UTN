package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelos.Cliente;

public interface IClienteDAO {

	public void agregarCliente(Cliente cliente);
	public Cliente mostrarCliente(Cliente cliente);

	// boolean actualizar(Cliente cliente);
	// boolean eliminar(String cuil);
	// boolean listar(Cliente cliente);
}