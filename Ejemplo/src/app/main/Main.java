package app.main;
import app.service.ClienteService;
import app.service.CuentaService;
import app.ui.ConsoleMenu;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("Programa iniciado");
		
		ClienteService clienteService = new ClienteService();
		CuentaService cuentaService  = new CuentaService();
		ConsoleMenu menu = new ConsoleMenu(clienteService, cuentaService);
		
		menu.showMenu();
		System.out.println("<<< PROGRAMA FINALIZADO >>>");

	}
}