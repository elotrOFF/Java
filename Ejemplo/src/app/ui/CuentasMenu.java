package app.ui;

import java.util.Scanner;
import app.service.ClienteService;

public class CuentasMenu {
	ClienteService clienteService;
	Scanner teclado;

	public CuentasMenu(ClienteService clienteService, Scanner teclado) {
		this.clienteService = clienteService;
		this.teclado = teclado;
	}
	
	public void crear() {
		System.out.println("ALTA NUEVA CUENTA BANCARIA");
		System.out.println();
		System.out.println("1) Cuenta ahorro");
		System.out.println("2) Cuenta Nomina");
		System.out.print("Seleccione modalidad:");
		
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
