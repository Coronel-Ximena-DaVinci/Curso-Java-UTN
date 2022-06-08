package utn.cursojava.sistemabancario.main;

import java.util.Scanner;

import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.excepciones.CuilInvalidException;
import utn.cursojava.sistemabancario.modelos.Cliente;
import utn.cursojava.sistemabancario.modelos.Cuenta;
import utn.cursojava.sistemabancario.service.ClienteService;
import utn.cursojava.sistemabancario.service.IClienteService;

/**
 * Tomando como punto de partida el diagrama de Clases del sistema de Gesti�n
 * Bancaria construya una aplicaci�n que permita realizar las siguientes
 * operaciones:
 *
 *
 * **********MENU PRINCIPAL********** <br>
 * 1) Agregar Cliente<br>
 * 2) Agregar cuenta a Cliente<br>
 * 3) Listar Clientes por sucursal<br>
 * 4) Listar Clientes de una sucursal<br>
 * 5) Extraer dinero<br>
 * 6) Consultar Saldo<br>
 * 7) Realizar Deposito<br>
 * 8) Realizar transferencias<br>
 * 9) Eliminar una sucursal<br>
 *
 * @author Coronel Ximena
 *
 */
public class SistemaBancario {

	/**
	 * 
	 * @return
	 */
	public static Cliente fillCliente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nombre y apellido del Cliente: ");
		Cliente cliente = new Cliente();
		cliente.setNombreApellido(entrada.nextLine());

		System.out.println("Ingrese Cuil del Cliente: ");
		cliente.setCuil();

		System.out.println("Ingrese telefono del Cliente: ");
		cliente.setTelefono(entrada.nextLine());

		System.out.println("Ingrese e-mail del Cliente: ");
		cliente.setEmail(entrada.nextLine());

		System.out.println("Ingrese localidad del Cliente: ");
		cliente.setDireccion(entrada.nextLine());

		return cliente;

	}
	public static Cuenta createCuenta() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el cbu del Cliente: ");
		Cuenta cuenta = new Cuenta();
		cuenta.setCbu(entrada.nextLine());
		System.out.println("Ingrese saldo que posee del Cliente: ");
		cuenta.setSaldo(entrada.nextDouble());


		return cuenta;

	}
	public static Cliente mostrarCliente() {
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("Ingrese el CUIL del Cliente: ");
		cliente.setCuil();

		return cliente;

	}
	public static Cuenta mostrarCuenta() {
		Scanner entrada = new Scanner(System.in);
		Cuenta cuenta = new Cuenta();
		System.out.println("Ingrese el nro de cuenta del Cliente: ");
		cuenta.setNroCuenta(entrada.nextInt());

		return cuenta;

	}
	public static  Cuenta realizarDeposito(){
		Scanner entrada = new Scanner(System.in);
		Cuenta cuenta = new Cuenta();
		System.out.println("Ingrese el monto a depositar");
		cuenta.setSaldo(entrada.nextDouble());
		System.out.println("Ingrese el NUMERO de CUENTA del destino");
		cuenta.setNroCuenta(entrada.nextInt());
		return cuenta;
	}

	public static void main(String[] args) {


		System.out.println("Punto de inicio del Sistema Bancario");
		System.out.println("***********MENU PRINCIPAL**********");
		System.out.println("1. Agregar Cliente");
		System.out.println("2. Agregar cuenta");
		System.out.println("3. Mostrar datos del cliente");
		System.out.println("4. Mostrar datos de la cuenta");
		System.out.println("Agregar cuenta a Cliente");
		System.out.println("Listar Clientes por sucursal");
		System.out.println("Listar Clientes de una sucursal");
		System.out.println("Extraer dinero");
		System.out.println("Consultar Saldo");
		System.out.println("Realizar Deposito");
		System.out.println("Realizar transferencias");
		System.out.println("Eliminar una sucursal");

		IClienteService clienteService = new ClienteService();

		Scanner entrada = new Scanner(System.in);
		System.out.println("\nIngrese una opción del menu: ");
		int opcionMenu = entrada.nextInt();

		switch (opcionMenu) {
		case 1: // 1) Agregar Cliente
			Cliente cliente = fillCliente();

			try {
				clienteService.agregarCliente(cliente);
			} catch (CuilInvalidException e) {
				System.out.println("ERROR " + e.getMessage());
			}
			break;
			case 2: // 2) Agregar Cuenta
				Cuenta cuenta = createCuenta();
				try {
					CuentaDAO.getInstance().agregarCuenta(cuenta);
		} catch (Exception e) {
			System.out.println("ERROR ");
		}
		break;
			case 3: // *) Mostrar cliente
				Cliente cliente1 = mostrarCliente();
				try {
					clienteService.mostrarCliente(cliente1);
				} catch (CuilInvalidException e) {
					System.out.println("ERROR " + e.getMessage());
				}
				break;
			case 4: // *) Mostrar cuenta
				Cuenta cuenta1 = mostrarCuenta();
				try {
					CuentaDAO.getInstance().mostrarCuenta(cuenta1);
				} catch (Exception e) {
					System.out.println("ERROR " + e.getMessage());
				}
				break;
			case 5: // ) Realizar deposito
				Scanner ingTeclado = new Scanner(System.in);
				int opcionCliente=0;
				System.out.println("Requiere tener su nro de cuenta");
				System.out.println("");
				System.out.println("¿Desea continuar? Seleccione el numero correspondiente.");
				System.out.println("1. Si" + "\n2. No");
				opcionCliente = ingTeclado.nextInt();
				if(opcionCliente == 1) {
					Cuenta cuenta2 = realizarDeposito();
					try {

						CuentaDAO.getInstance().realizaDeposito(cuenta2);
					} catch (Exception e) {
						System.out.println("ERROR " + e.getMessage());
					}
				}else {
					System.out.println("Solicitud cancelada correctamente");
				}
				break;

		default:
			System.out.println("ERROR - Selecciono una opcion no valida" );
			break;
		}

	}

}
