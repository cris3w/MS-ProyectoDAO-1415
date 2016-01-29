package negocio.clientes;

public class TransferVip extends TransferCliente {
	
	private int puntos;
	
	public TransferVip() {
		super();
		this.setPuntos(0);
	}
	
	public TransferVip(int id, String dni, String nombre, int telefono, int activo, int tipo,  int puntos) {
		super(id, dni, nombre, telefono, activo, tipo);
		this.setPuntos(puntos);
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
