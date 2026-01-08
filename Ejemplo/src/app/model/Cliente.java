package app.model;

public class Cliente {	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String dni;
	private boolean isActive;
	
	public Cliente(String nombre, String apellidos, String direccion, String dni){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;	
		this.dni = dni;
		altaCliente();		
	}
	
	public void altaCliente() {
		this.isActive = true;
	}
	
	public void bajaCliente() {
		isActive = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getDni() {
		return dni;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	
	


	

}
