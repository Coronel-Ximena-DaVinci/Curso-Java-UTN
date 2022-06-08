package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelos.Cuenta;

public interface ICuentaDAO {

    public void agregarCuenta(Cuenta cuenta);
    public Cuenta mostrarCuenta(Cuenta cuenta);
    public void realizaDeposito(Cuenta cuenta);
    //boolean listar();
    //boolean eliminar();

}

