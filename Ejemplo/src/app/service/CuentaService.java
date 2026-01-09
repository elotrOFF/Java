package app.service;

import java.util.ArrayList;
import java.util.List;
import app.model.*;

public class CuentaService {
	private final List<Cuenta> cuentas = new ArrayList<>();
	private static int numeradorDeCuentas;
	
	
	public void crearCuentaAhorro(Cliente c, double saldoApertura) {
		CuentaAhorro nuevaCuenta = new CuentaAhorro(c, saldoApertura, numeradorDeCuentas);
		
		cuentas.add(nuevaCuenta);
		
	}
	public void crearCuentaNomina(Cliente c, double saldoApertura) {
		CuentaNomina nuevaCuenta = new CuentaNomina(c, saldoApertura, numeradorDeCuentas);
		cuentas.add(nuevaCuenta);
	}
	
	
	public void buscarCuentaPorNumero() {
		
	}
}