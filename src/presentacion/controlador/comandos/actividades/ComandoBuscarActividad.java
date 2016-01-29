package presentacion.controlador.comandos.actividades;

import negocio.actividades.SAActividades;
import negocio.actividades.TransferActividad;
import negocio.factoria.FactoriaSA;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoBuscarActividad extends Comando {
	
	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAActividades sa = FactoriaSA.obtenerInstancia().crearSAActividades() ;
		TransferActividad actividad = sa.mostrar((TransferActividad) datos);
		RespuestaComando respuesta;
		if (actividad != null) {
			respuesta = new RespuestaComando(EventoVista.BUSCAR_ACTIVIDAD_EXITO, actividad);
		} else {
			respuesta = new RespuestaComando(EventoVista.BUSCAR_ACTIVIDAD_FALLO, actividad);
		}
		return respuesta;
	}
}
