package utn.cursojava.sistemabancario.modelos;

public class CajaDeAhorro extends Cuenta {
    // Atributos
    protected TipoMoneda tipoMoneda;


    // COSNTRUCTOR
    public CajaDeAhorro() {
    }

    public CajaDeAhorro(int nroCuenta, String cbu, Cliente cliente, TipoMoneda tipoMoneda) {
        super(nroCuenta, cbu, cliente);
        this.tipoMoneda = tipoMoneda;

    }

    public TipoMoneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(TipoMoneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }


}

