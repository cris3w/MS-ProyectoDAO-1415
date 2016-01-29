package presentacion.controlador.comandos;

public abstract class Comando {

	protected Object datos;

	public abstract RespuestaComando ejecutar() throws Exception;

	public Object getDatos() {
		return datos;
	}

	public void setDatos(Object datos) {
		this.datos = datos;
	}
}
