package presentacion.controlador.comandos.matriculas;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;
import negocio.factoria.FactoriaSA;
import negocio.matriculas.SAMatriculas;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoListarMatriculados extends Comando {
	
	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAMatriculas sa = FactoriaSA.obtenerInstancia().crearSAMatriculas();
		RespuestaComando respuesta;
		ArrayList<TransferCliente> array_clientes = sa.listarMatriculados((TransferActividad) datos);
		datos = array_clientes;
		respuesta = new RespuestaComando(EventoVista.LISTAR_CLIENTES_EXITO, datos);
		return respuesta;
	}

}
