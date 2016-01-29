package presentacion.controlador.comandos.actividades;

import negocio.actividades.SAActividades;
import negocio.actividades.TransferActividad;
import negocio.factoria.FactoriaSA;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoCrearActividad extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAActividades sa = FactoriaSA.obtenerInstancia().crearSAActividades() ;
		RespuestaComando respuesta;
		if (sa.crear((TransferActividad) datos)) {
			respuesta = new RespuestaComando(EventoVista.CREAR_ACTIVIDAD_EXITO, datos);
		} else {
			respuesta = new RespuestaComando(EventoVista.CREAR_ACTIVIDAD_FALLO, datos);
		}
		return respuesta;
	}
}
