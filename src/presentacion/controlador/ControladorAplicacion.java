package presentacion.controlador;

public abstract class ControladorAplicacion {

	private static ControladorAplicacion instancia;

	public static ControladorAplicacion obtenerInstancia() {
		if (instancia == null) 
        	instancia = new ControladorAplicacionImp(); 
        return instancia; 
	}
	
	public abstract void accion(int id_evento, Object datos) throws Exception;; 
}