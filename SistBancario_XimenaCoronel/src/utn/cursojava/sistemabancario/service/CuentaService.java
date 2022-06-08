package utn.cursojava.sistemabancario.service;

import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.excepciones.CbuInvalidException;
import utn.cursojava.sistemabancario.modelos.Cuenta;
import utn.cursojava.sistemabancario.modelos.Cliente;


public class CuentaService implements ICuentaService {
    private CuentaDAO cuentaDAO;

    public CuentaService() {
        cuentaDAO = CuentaDAO.getInstance();
    }

    public void agregarCuenta(Cuenta cuenta) throws CbuInvalidException {
        if (cuenta.getCbu().length() != 22) {
            throw new CbuInvalidException("El CBU " + cuenta.getCbu() + " no cuenta con la cantidad de digitos requeridos ");
        }

        cuentaDAO.agregarCuenta(cuenta);
    }
}

