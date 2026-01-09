package app.ui;
import java.util.InputMismatchException;
import app.ui.*;

import java.util.*;
import app.service.*;

public class ConsoleMenu {
	Scanner teclado = new Scanner(System.in);
	InputReader input;
	MsgPrinter mensaje;
	
	ClienteService cliente;
	CuentaService cuenta;
	
	ClientesMenu clienteMenu;
	CuentasMenu cuentaMenu;
	
	public ConsoleMenu(ClienteService cliSrv, CuentaService cuentaSrv){
		this.cliente = cliSrv;
		this.cuenta = cuentaSrv;
		this.input = new InputReader(teclado);
		this.mensaje = new MsgPrinter(); 
		this.clienteMenu = new ClientesMenu(cliente, teclado, input, mensaje);
		this.cuentaMenu = new CuentasMenu(cliente, cuenta, teclado, input, mensaje);
		
	}
	
	public void showMenu() {
		cliente.crearCliente("Arturo", "Romero", "Av. Hispanidad, 43", "111555X");
		cliente.crearCliente("Juan", "Rigoberto", "Calle Mexico, 21", "444666J");
		cliente.crearCliente("Alberto", "Garrido", "Sbda. Meixoeiro s/n", "888222K");
		cliente.crearCliente("Rocio", "Garcia", "Av. Madrid, 102", "333444L");
		cliente.crearCliente("Paula", "Lomera", "Crt. Fragoso, 7", "444666Q");
		
		
		boolean exit = false;
		int menu = 0;
		
		
		while(!exit){
			switch(menu) {
			
				// MAIN MENU
				case 0:
					printMenu0();
					menu = input.leerTeclado();
					if(menu == 0) {									
						exit = true;		// END PROGRAM
					}
					break;

				// CLIENTES	
				case 1:		
					printMenu1();
					menu =  input.leerTeclado();
					if(menu == 0) {
						System.out.println(">>> Atras");
						break;
					}
					else if(menu == 1) clienteMenu.crear();
					else if(menu == 2) clienteMenu.cursarBaja();
					else if(menu == 3) clienteMenu.reactivar();
					else if(menu == 4) clienteMenu.consultar();
					else if(menu == 5) clienteMenu.listar();
					else {
						System.out.println(">>> Opcion no valida");						
					}
					menu = 1;						
					break;
					
				// CUENTAS
				case 2:
					printMenu2();
					menu =  input.leerTeclado();
					if(menu == 0) {
						System.out.println(">>> Atras");
						break;
					}
					else if(menu == 1) cuentaMenu.crear();
					else if(menu == 2) cuentaMenu.eliminar();
					else if(menu == 3) cuentaMenu.consultar();
					else {
						System.out.println(">>> Opcion no valida");
					}
					menu = 2;
					break;
					
				// MOVIMIENTOS
				case 3:
					printMenu3();
					menu =  input.leerTeclado();
					if(menu == 0) {
						System.out.println(">>> Atras");
						break;
					}
					else if(menu == 1) System.out.println(">>> Ingresar");
					else if(menu == 2) System.out.println(">>> Retirar");
					else if(menu == 3) System.out.println(">>> Hacer transferencia");
					else {
						System.out.println(">>> Opcion no valida");
						
					}
					menu = 3;
					break;
				
				default: 
					menu = 0;
					break;
			};	
		}	
		teclado.close();
	}
	
	
	private void printMenu0() {
		System.out.println("");
		System.out.println("Bienvenido al Sistema Bancario de Eloy ");
		System.out.println("Elija una opcion:");
		System.out.println("------------------");
		System.out.println("1) Clientes");
		System.out.println("2) Cuentas");
		System.out.println("3) Movimientos");
		System.out.println("0) EXIT");
	}
	
	void printMenu1() {
		System.out.println("");
		System.out.println("#################");
		System.out.println("#  1) CLIENTES  #");
		System.out.println("#################");
		System.out.println("1) Alta nuevo cliente");
		System.out.println("2) Baja cliente");
		System.out.println("3) Reactivar cliente");
		System.out.println("4) Consultar datos");
		System.out.println("5) Listar todos los clientes");
		System.out.println("0) QUITAR/ATRAS");
	}

	void printMenu2() {	
		System.out.println("");
		System.out.println("################");
		System.out.println("#  2) CUENTAS  #");
		System.out.println("################");;
		System.out.println("1) Crear cuenta");
		System.out.println("2) Eliminar cuenta");
		System.out.println("3) Consultar cuentas");
		System.out.println("0) QUITAR/ATRAS");	
	}
		
	void printMenu3() {		
		System.out.println("");
		System.out.println("####################");
		System.out.println("#  3) MOVIMIENTOS  #");
		System.out.println("####################");
		System.out.println("1) Ingresar");
		System.out.println("2) Retirar");
		System.out.println("3) Hacer transferencia");
		System.out.println("0) QUITAR/ATRAS");
	}

}