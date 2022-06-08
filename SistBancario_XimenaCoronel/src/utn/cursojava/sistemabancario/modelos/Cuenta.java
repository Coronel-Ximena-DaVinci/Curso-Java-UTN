package utn.cursojava.sistemabancario.modelos;

public class Cuenta {
    protected int nroCuenta;
    protected String cbu;
    protected Cliente cliente;
    protected double saldo;

    // Constructor
    public Cuenta(){

    }
    public Cuenta(int nroCuenta, String cbu, Cliente cliente) {
    }

    public Cuenta(int nroCuenta, String cbu, Cliente cliente, double saldo) {
        this.nroCuenta = nroCuenta;
        this.cbu = cbu;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
