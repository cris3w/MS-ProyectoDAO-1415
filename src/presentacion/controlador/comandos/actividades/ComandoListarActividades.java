package presentacion.controlador.comandos.actividades;

import java.util.ArrayList;

import negocio.actividades.SAActividades;
import negocio.actividades.TransferActividad;
import negocio.factoria.FactoriaSA;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoListarActividades  extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAActividades sa = FactoriaSA.obtenerInstancia().crearSAActividades();
		RespuestaComando respuesta;
		ArrayList<TransferActividad> array_datos = sa.listar();
		datos = array_datos;
		respuesta = new RespuestaComando(EventoVista.LISTAR_ACTIVIDADES_EXITO, datos);
		return respuesta;
	}
}
