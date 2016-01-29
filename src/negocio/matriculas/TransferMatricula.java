package negocio.matriculas;

public class TransferMatricula {
	
	private int idCliente;
	private int idActividad;
	
	public TransferMatricula() {
		this.idCliente = 0;
		this.idActividad = 0;
	}
	
	public TransferMatricula(int idCliente, int idActividad) {
		this.setIdCliente(idCliente);
		this.setIdActividad(idActividad);
	}
	
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
}
