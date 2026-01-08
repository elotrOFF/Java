package app.model;


public class CuentaNomina extends Cuenta{
	double interesAnual = 0.5; 
	
	CuentaNomina(Cliente titular, int saldo, int numeroCuenta){
		super(titular, saldo, numeroCuenta);		
		}


}