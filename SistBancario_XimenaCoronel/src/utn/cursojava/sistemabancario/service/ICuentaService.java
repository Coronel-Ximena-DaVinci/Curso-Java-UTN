package utn.cursojava.sistemabancario.service;

import utn.cursojava.sistemabancario.excepciones.CbuInvalidException;
import utn.cursojava.sistemabancario.modelos.Cuenta;

public interface ICuentaService {

    public void agregarCuenta(Cuenta cuenta) throws CbuInvalidException;
}
