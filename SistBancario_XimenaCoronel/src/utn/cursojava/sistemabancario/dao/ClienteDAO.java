package utn.cursojava.sistemabancario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import utn.cursojava.sistemabancario.modelos.Cliente;

public class ClienteDAO implements IClienteDAO {

	protected List<Cliente> clientes;

	// 1-. Crear un objeto de tipo ClienteDAO
	private static ClienteDAO instance;

	// 2-. Definir el constructor como private
	private ClienteDAO() {
	}

	// 3-. Retornar el unico objeto disponible a traves de un metodo estatico
	public synchronized static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	@Override
	public void agregarCliente(Cliente cliente) {
		Boolean band = Boolean.FALSE;
		Connection con = new Conexion().getCon();
		try {
			/// 2) Create the PreparedStatement object
			String sql = "INSERT INTO clientes (nombre_apellido, cuil, telefono, email,direccion) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombreApellido());
			ps.setString(2, cliente.getCuil());
			ps.setString(3, cliente.getTelefono());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getDireccion());


			if (ps.executeUpdate() > 0) {
				band = Boolean.TRUE;
				System.out.println("El cliente  fue guardado satisfactoriamente");
			}
		} catch (Exception e) {
			System.out.println("Error" + e);

		}
	}
	@Override
	public Cliente mostrarCliente(Cliente cliente) {
		Boolean band = Boolean.FALSE;
		Connection con = new Conexion().getCon();
		try {
			/// 2) Create the PreparedStatement object
			String sql = "SELECT * FROM clientes where cuil Like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getCuil());

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				 cliente =new Cliente();
				System.out.println(rs.getInt("nro_cliente") + " " + rs.getString("nombre_apellido") + " " + rs.getString("cuil") + " " + rs.getString("telefono")+ " " + rs.getString("email")+ " " + rs.getString("direccion"));
			}



		} catch (Exception e) {
			System.out.println("Error" + e);

		}
		return cliente;
	}



}
