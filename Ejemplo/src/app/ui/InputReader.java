package app.ui;

import java.util.*;

	public class InputReader {
		Scanner teclado;
		
		public InputReader(Scanner teclado) {
			this.teclado = teclado;			
		}
		
		public int leerTeclado() {
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
