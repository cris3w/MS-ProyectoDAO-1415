package negocio.clientes;

public class TransferCliente {
	
	private int id;
	private String dni;
	private String nombre;
	private int telefono;
	private int activo;
	private int tipo; // normal = 0, vip = 1
	
	public TransferCliente() {
		this.id = 0;
		this.dni = "";
		this.nombre = "";
		this.telefono = 0;
		this.activo = 0;
		this.tipo = 0;
	}
	
	public TransferCliente(int id, String dni, String nombre, int telefono, int activo, int tipo) {
		this.setId(id);
		this.setDni(dni);
		this.setNombre(nombre); 
		this.setTelefono(telefono);
		this.setActivo(activo);
		this.setTipo(tipo);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public boolean isActivo() {
		if (activo == 1) return true;
		else return false;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return this.tipo;
	}
}