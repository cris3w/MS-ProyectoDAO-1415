package presentacion.controlador.comandos.matriculas;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;
import negocio.factoria.FactoriaSA;
import negocio.matriculas.SAMatriculas;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoListarMatriculas extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAMatriculas sa = FactoriaSA.obtenerInstancia().crearSAMatriculas();
		RespuestaComando respuesta;
		ArrayList<TransferActividad> array_actividades = sa.listarMatriculas((TransferCliente) datos);
		datos = array_actividades;
		respuesta = new RespuestaComando(EventoVista.LISTAR_ACTIVIDADES_EXITO, datos);
		return respuesta;
	}
}
