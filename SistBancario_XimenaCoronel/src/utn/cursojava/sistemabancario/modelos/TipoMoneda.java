package utn.cursojava.sistemabancario.modelos;

public enum TipoMoneda {
    PESOS("Moneda pesos", 1), DOLARES("Moneda dolares", 2);

    private String descripcion;
    private int nroTipo;


    TipoMoneda(String descripcion, int nroTipo) {
        this.descripcion = descripcion;
        this.nroTipo = nroTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNroTipo() {
        return nroTipo;
    }
}
