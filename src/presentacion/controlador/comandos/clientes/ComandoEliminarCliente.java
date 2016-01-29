package presentacion.controlador.comandos.clientes;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;
import negocio.clientes.SAClientes;
import negocio.clientes.TransferCliente;
import negocio.factoria.FactoriaSA;

public class ComandoEliminarCliente extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAClientes sa = FactoriaSA.obtenerInstancia().crearSAClientes() ;
		RespuestaComando respuesta;
		if (sa.eliminar((TransferCliente) datos)) {
			respuesta = new RespuestaComando(EventoVista.ELIMINAR_CLIENTE_EXITO, datos);
		} else {
			respuesta = new RespuestaComando(EventoVista.ELIMINAR_CLIENTE_FALLO, datos);
		}
		return respuesta;
	}
}