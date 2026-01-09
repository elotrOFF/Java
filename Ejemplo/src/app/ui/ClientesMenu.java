package app.ui;

import app.service.*;
import java.util.*;
import app.model.Cliente;

public class ClientesMenu {
	ClienteService clienteService;
	Scanner teclado;
	MsgPrinter mensaje;
	InputReader input;
	
	public ClientesMenu(ClienteService clienteService, Scanner teclado, InputReader input, MsgPrinter mensaje) {
		this.clienteService = clienteService;
		this.teclado = teclado;
		this.mensaje = mensaje;
		this.input = input;
		this.mensaje = new MsgPrinter();
	}
	
	
	public void crear() {
		String nombre = "";
		String apellidos = "";
		String direccion = "";
		String dni = "";
		
		System.out.print("Nombre: ");		
		nombre = teclado.nextLine();	
		
		System.out.print("Apellidos: ");		
		apellidos = teclado.nextLine();
		
		System.out.print("Direccion: ");
		direccion = teclado.nextLine();
		
		System.out.print("DNI: ");
		dni = teclado.nextLine();
		
				
		if ( clienteService.crearCliente(nombre, apellidos, direccion, dni) == false) {
			mensaje.msgError("Cliente no creado. Error en los datos");
			return;
		}
		System.out.println("Usuario creado:");
		System.out.println("Nuevo usuario: " + nombre + " " + apellidos + " " + direccion + " " + dni);
	}
	
	
	public void cursarBaja() {
		// obtenemos dni		
		System.out.print("DNI: ");
		String dni = teclado.nextLine();
		
		// si es vacio, salimmos
		if(dni.equals("")) {
			mensaje.msgError("No se ha indicado dni");
			return;
		}
		
		// obtenemos cliente
		Cliente c = clienteService.bajaCliente(dni);
		
		// si cliente = null --> error
		if(c == null) {
			mensaje.msgError("Cliente no encontrado o ya esta inactivo.");
			return;
		}
		System.out.println("Cliente dado de baja:");
		mensaje.printClientInfo(c);
		
		return;
	}
	
	public void reactivar() {
		// obtenemos dni
		System.out.print("DNI: ");
		String dni = teclado.nextLine();
		
		if(dni.equals("")) {
			mensaje.msgError("No se ha indicado dni");
			return;
		}

		// obtenemos cliente
		Cliente c = clienteService.reactivarCliente(dni);
		
		if(c == null) {
			mensaje.msgError("Cliente no encontrado o ya esta activo.");
			return;
		}
		
		System.out.println("Reactivacion realizada correctamente. ");
		mensaje.printClientInfo(c);
			
		return;
	}
	
	public void consultar() {
		System.out.println("CONSULTA CUENTA BANCARIA");
		System.out.println();
		System.out.print("Indique DNI para realizar consulta:");
	}
	
	
	public void listar() {
		List<Cliente> clientes = clienteService.getClientes();
	    
		System.out.printf(
	        "%-10s %-15s %-15s %-25s %-10s%n",
	        "DNI", "Nombre", "Apellidos", "Direccion", "Estado"
	    );
	    System.out.println("----------------------------------------------------------------------------");
	    for( Cliente c : clientes ) {
	    	mensaje.printClientInfo(c);
	    }		
	}	
		
}
