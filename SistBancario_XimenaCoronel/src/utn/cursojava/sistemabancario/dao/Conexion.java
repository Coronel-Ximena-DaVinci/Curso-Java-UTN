package utn.cursojava.sistemabancario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/sistema_bancario";
	String userName = "root";
	String password = "4630";

	Connection con = null;

	public Connection getCon() {
		try {
			// 1) Register the driver class
			Class.forName(driver);

			// 2) Create the connection object
			con = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error2" + e);
		}
		return con;

	}
}
