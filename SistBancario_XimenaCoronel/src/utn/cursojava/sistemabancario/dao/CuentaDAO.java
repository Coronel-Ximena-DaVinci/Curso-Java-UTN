package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelos.Cuenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public  class CuentaDAO implements  ICuentaDAO{
    protected List<Cuenta> cuentas;

    // 1-. Crear un objeto de tipo CuentaDAO
    private static CuentaDAO instance;

    // 2-. Definir el constructor como private
    private CuentaDAO() {
    }

    // 3-. Retornar el unico objeto disponible a traves de un metodo estatico
    public synchronized static CuentaDAO getInstance() {
        if (instance == null) {
            instance = new CuentaDAO();
        }

        return instance;
    }

    public void agregarCuenta(Cuenta cuenta) {
        Boolean band = Boolean.FALSE;
        Connection con = new Conexion().getCon();
        try {
            /// 2) Create the PreparedStatement object
            String sql = "INSERT INTO cuentas (cbu, saldo) VALUES (?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getCbu());
            ps.setDouble(2, cuenta.getSaldo());


            if (ps.executeUpdate() > 0) {
                band = Boolean.TRUE;
                System.out.println("La cuenta fue creada satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);

        }

        }

    public Cuenta mostrarCuenta(Cuenta cuenta) {
        Boolean band = Boolean.FALSE;
        Connection con = new Conexion().getCon();
        try {
            /// 2) Create the PreparedStatement object
            String sql = "SELECT * FROM cuentas where nro_cuenta Like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cuenta.getNroCuenta());

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                cuenta =new Cuenta();
                System.out.println("Nro de cuenta: ");
                System.out.println(rs.getInt( "nro_cuenta"));
                System.out.println("Nro cbu: ");
                System.out.println(rs.getString("cbu"));
                System.out.println("Saldo actual: ");
                System.out.println(rs.getDouble("saldo"));
            }



        } catch (Exception e) {
            System.out.println("Error" + e);

        }
        return cuenta;
    }
    public void realizaDeposito(Cuenta cuenta) {
        Boolean band = Boolean.FALSE;
        Connection con = new Conexion().getCon();
        try {
            /// 2) Create the PreparedStatement object
            String sql = "UPDATE cuentas SET saldo = ? where nro_cuenta like ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, cuenta.getSaldo());
            ps.setInt(2, cuenta.getNroCuenta());


            if (ps.executeUpdate() > 0) {
                band = Boolean.TRUE;
                System.out.println("El deposito se realizao satisfactoriamente");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);

        }

    }



}


