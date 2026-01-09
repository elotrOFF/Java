package app.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import app.service.*;
import app.model.Cliente;
import app.ui.*;

public class CuentasMenu {
	ClienteService clienteService;
	CuentaService cuentaService;
	Scanner teclado;
	MsgPrinter mensaje;
	InputReader input;
	

	public CuentasMenu(ClienteService clienteService, 
						CuentaService cuentaServ, 
						Scanner teclado, 
						InputReader input,
						MsgPrinter mensaje 
						) 
	{
		this.clienteService = clienteService;
		this.teclado = teclado;
		this.mensaje = mensaje;
	}
	
	public void crear() {
		
		Cliente cliente = null;
		String dni = "";		
		
		System.out.println("ALTA NUEVA CUENTA BANCARIA");
		System.out.println();
		System.out.println("1) Cuenta ahorro");
		System.out.println("2) Cuenta Nomina");
		System.out.print("Seleccione modalidad: ");
		int modo = input.leerTeclado();
		
		System.out.println("Dni del titular: ");
		dni = teclado.nextLine();
		
		cliente = clienteService.locateClientByDni(dni);
		System.out.println("El cliente es:" );
		mensaje.printClientInfo(cliente);
		
		if (modo == 1) {
			//cuentaService.crearCuentaAhorro(null, modo)
			System.out.println("Cuenta ahorro");
		}
		else if (modo == 2) {
			System.out.println("Cuenta Nomina");
		}
		else {
			System.out.println("Opcion no valida");
		}		
	}
	
	
	public void eliminar() {
		System.out.println("ELIMINAR CUENTA BANCARIA");
		System.out.println();
		System.out.print("Indique DNI para mostrar cuentas asociadas:");
	}
	
	public void consultar() {
		System.out.println("CONSULTA CUENTA BANCARIA");
		System.out.println();
		System.out.print("Indique DNI para realizar consulta:");
	}

	
}
