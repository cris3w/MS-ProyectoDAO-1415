package presentacion.controlador.dispatcher;

public abstract class Dispatcher {
	
	private static Dispatcher instancia; 
	   
 	public static Dispatcher obtenerInstancia() { 
        if (instancia == null) instancia = new DispatcherImp(); 
        return instancia; 
    } 
 	
   public abstract void redirigirVista(int id_evento_vista, Object datos); 
}
