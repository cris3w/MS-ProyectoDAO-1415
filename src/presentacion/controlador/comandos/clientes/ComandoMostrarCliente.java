package presentacion.controlador.comandos.clientes;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;
import negocio.clientes.SAClientes;
import negocio.clientes.TransferCliente;
import negocio.factoria.FactoriaSA;

public class ComandoMostrarCliente extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAClientes sa = FactoriaSA.obtenerInstancia().crearSAClientes() ;
		TransferCliente cliente = sa.mostrar((TransferCliente) datos);
		RespuestaComando respuesta;
		if (cliente != null) {
			respuesta = new RespuestaComando(EventoVista.MOSTRAR_CLIENTE_EXITO, cliente);
		} else {
			respuesta = new RespuestaComando(EventoVista.MOSTRAR_CLIENTE_FALLO, cliente);
		}
		return respuesta;
	}
}