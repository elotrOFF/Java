package app.model;


public class CuentaNomina extends Cuenta{
	double interesAnual = 0.5; 
	
	public CuentaNomina(Cliente titular, double saldo, int numeroCuenta){
		super(titular, saldo, numeroCuenta);		
		}

	public double getInteresAnual() {
		return interesAnual;
	}
	
	public void setInteresAnual(double nuevoInteres) {
		this.interesAnual = nuevoInteres;
	}

}