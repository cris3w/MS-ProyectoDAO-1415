package negocio.clientes;

public class TransferNormal extends TransferCliente {
	
	private int piscina;
	
	public TransferNormal() {
		super();
		setPiscina(0);
	}
	
	public TransferNormal(int id, String dni, String nombre, int telefono, int activo, int tipo, int piscina) {
		super(id, dni, nombre, telefono, activo, tipo);
		this.setPiscina(piscina);
	}
	
	public int getPiscina() {
		return this.piscina;
	}
	
	public void setPiscina(int piscina) {
		this.piscina = piscina;
	}

}
