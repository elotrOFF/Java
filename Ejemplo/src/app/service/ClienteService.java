package app.service;
import java.util.ArrayList;
import java.util.List;
import app.model.Cliente;


public class ClienteService {
	private final List<Cliente> clientes = new ArrayList<>();

	public boolean crearCliente(String nombre, String apellidos, String direccion, String dni) {
		if(!dniIsValid(dni)) 
			return false;
			
		Cliente c = new Cliente(nombre, apellidos, direccion, dni);
		clientes.add(c);
		return true;			
	}

	public List<Cliente> getClientes(){
		return new ArrayList<>(clientes);		
	}

	public Cliente bajaCliente(String dni) {
		
		if( !dniIsValid(dni) )
			return null;
	
		Cliente c = locateClientByDni(dni);
		if(c == null)
			return null;
			
		c.bajaCliente();
		return c;
	}
	

	public Cliente reactivarCliente(String dni) {
		Cliente c = locateClientByDni(dni);
		
		if(!dniIsValid(dni) || c.isActive() )
			return null;
		
		c.altaCliente();
		return c;
	}
	
	public Cliente locateClientByDni(String dni) {
		for(Cliente c : clientes) {
			if ( dni.equalsIgnoreCase(c.getDni()) ) {
				return c;
			}
		}		
		return null;
	}
	
	private boolean dniIsValid(String dni) {
		if (dni.equals("")) {
			return false;
		}
		return true;		
	}
	
	
	}