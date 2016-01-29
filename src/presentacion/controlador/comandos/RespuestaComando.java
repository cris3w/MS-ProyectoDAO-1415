package presentacion.controlador.comandos;

public class RespuestaComando {
	
	private int id_evento_vista; 
	private Object datos;
	
	public RespuestaComando(int id_evento_vista, Object datos){
		this.id_evento_vista = id_evento_vista;
		this.datos = datos;
	}
	
	public int getId_evento_vista() {
		return id_evento_vista;
	}
	
	public void setId_evento_vista(int id_evento_vista) {
		this.id_evento_vista = id_evento_vista;
	}
	
	public Object getDatos() {
		return datos;
	}
	
	public void setDatos(Object datos) {
		this.datos = datos;
	}
}
