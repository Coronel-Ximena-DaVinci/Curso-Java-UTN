package utn.cursojava.sistemabancario.service;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.excepciones.CuilInvalidException;
import utn.cursojava.sistemabancario.modelos.Cliente;

public class ClienteService implements IClienteService {
	private ClienteDAO clienteDAO;

	public ClienteService() {
		clienteDAO = ClienteDAO.getInstance();
	}

	public void agregarCliente(Cliente cliente) throws CuilInvalidException {
		if (cliente.getCuil().length() != 11) {
			throw new CuilInvalidException("El Cuil " + cliente.getCuil() + " no contiene un formato valido ");
		}

		clienteDAO.agregarCliente(cliente);
	}
	public void mostrarCliente(Cliente cliente1) throws CuilInvalidException {
		if (cliente1.getCuil().length() != 11) {
			throw new CuilInvalidException("El Cuil " + cliente1.getCuil() + " no contiene un formato valido ");
		}

		clienteDAO.mostrarCliente(cliente1);
	}
}
