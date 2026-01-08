package app.model;


class CuentaAhorro extends Cuenta{ 
		double interesAnual = 3.0;	
	
	CuentaAhorro(Cliente titular, int saldo, int numeroCuenta){
		super(titular, saldo, numeroCuenta);			
		}	
}