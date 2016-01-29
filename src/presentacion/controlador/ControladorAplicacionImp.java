package presentacion.controlador;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.comandos.factoria.FactoriaComandos;
import presentacion.controlador.dispatcher.Dispatcher;

public class ControladorAplicacionImp extends ControladorAplicacion {

	public void accion(int id_evento, Object datos) throws Exception {
		
		Comando comando = FactoriaComandos.obtenerInstancia().producirComando(id_evento, datos);
		comando.setDatos(datos); //le da los datos al comando
		RespuestaComando respuesta = comando.ejecutar(); //lo ejecuta
		Dispatcher.obtenerInstancia().redirigirVista(respuesta.getId_evento_vista(), respuesta.getDatos()); 
		//redirige la vista en funcion de la respuesta
	}
}