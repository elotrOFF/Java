package app.model;


public class CuentaAhorro extends Cuenta{ 
		double interesAnual = 3.0;	
	
	public CuentaAhorro(Cliente titular, double saldo, int numeroCuenta){
		super(titular, saldo, numeroCuenta);
		
		}
	
	public double getInteresAnual() {
		return interesAnual;
	}
	
	public void setInteresAnual(double nuevoInteres) {
		this.interesAnual = nuevoInteres;
	}
	

	

	
	
}