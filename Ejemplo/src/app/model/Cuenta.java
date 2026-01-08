package app.model;
import java.util.*;

public abstract class Cuenta {
	
	
	private Cliente titular;
	private int numeroCuenta;
	private double saldo;
	private boolean cuentaActiva;
	
	Cuenta(Cliente titular, int saldo, int numeroCuenta){		
		this.titular = titular;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
		activar();		
	}
	
	public void ingresar(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void retirar(double cantidad) {
		if(this.saldo >= cantidad)
			this.saldo -= cantidad;
	}
	
	public void activar(){
		this.cuentaActiva = false;		
	}
	
	public void cancelar() {
		this.cuentaActiva = true;
	}	
	
}