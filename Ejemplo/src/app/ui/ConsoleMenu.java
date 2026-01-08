package app.ui;
import java.util.InputMismatchException;
import java.util.*;
import java.util.Scanner;

import app.model.Cliente;
import app.service.ClienteService;
import app.service.CuentaService;

public class ConsoleMenu {
	ClienteService clienteServ;
	Scanner teclado = new Scanner(System.in);
	ClientesMenu cliente;
	CuentasMenu cuenta;
	
	public ConsoleMenu(ClienteService cliSrv){
		this.clienteServ = cliSrv;
		this.cliente = new ClientesMenu(clienteServ, teclado);
		this.cuenta = new CuentasMenu(clienteServ, teclado);
	}
	
	public void showMenu() {
		clienteServ.crearCliente("Arturo", "Romero", "Av. Hispanidad, 43", "111555X");
		clienteServ.crearCliente("Juan", "Rigoberto", "Calle Mexico, 21", "444666J");
		clienteServ.crearCliente("Alberto", "Garrido", "Sbda. Meixoeiro s/n", "888222K");
		clienteServ.crearCliente("Rocio", "Garcia", "Av. Madrid, 102", "333444L");
		clienteServ.crearCliente("Paula", "Lomera", "Crt. Fragoso, 7", "444666Q");
		
		
		boolean exit = false;
		int menu = 0;
		
		
		while(!exit){
			switch(menu) {
			
				// MAIN MENU
				case 0:
					printMenu0();
					menu = leerTeclado();
					if(menu == 0) {									
						exit = true;		// END PROGRAM
					}
					break;

				// CLIENTES	
				case 1:		
					printMenu1();
					menu =  leerTeclado();
					if(menu == 0) {
						System.out.println(">>> Atras");
						break;
					}
					else if(menu == 1) cliente.crear();
					else if(menu == 2) cliente.cursarBaja();
					else if(menu == 3) cliente.reactivar();
					else if(menu == 4) cliente.consultar();
					else if(menu == 5) cliente.listar();
					else {
						System.out.println(">>> Opcion no valida");						
					}
					menu = 1;						
					break;
					
				// CUENTAS
				case 2:
					printMenu2();
					menu =  leerTeclado();
					if(menu == 0) {
						System.out.println(">>> Atras");
						break;
					}
					else if(menu == 1) cuenta.crear();
					else if(menu == 2) cuenta.eliminar();
					else if(menu == 3) cuenta.consultar();
					else {
						System.out.println(">>> Opcion no valida");
					}
					menu = 2;
					break;
					
				// MOVIMIENTOS
				case 3:
					printMenu3();
					menu =  leerTeclado();
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
	
	
	void printMenu0() {
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

	
	int leerTeclado() {
		int opcion = 0;
		boolean valido = false;
		do {
			try {
				opcion = teclado.nextInt();
				valido = true;
			}catch(InputMismatchException n) {
				System.out.println("Valor introducido no valido.");
				valido = false;
			}finally {
				teclado.nextLine();		//para limpiar el buffer
			}			
		}while (!valido);
		return opcion;
	}

	
	

}