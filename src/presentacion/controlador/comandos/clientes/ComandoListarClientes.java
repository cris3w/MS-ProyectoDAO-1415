package presentacion.controlador.comandos.clientes;

import java.util.ArrayList;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;
import negocio.clientes.SAClientes;
import negocio.clientes.TransferCliente;
import negocio.factoria.FactoriaSA;

public class ComandoListarClientes extends Comando {
	
	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAClientes sa = FactoriaSA.obtenerInstancia().crearSAClientes();
		RespuestaComando respuesta;
		ArrayList<TransferCliente> array_datos = sa.listar();
		datos = array_datos;
		respuesta = new RespuestaComando(EventoVista.LISTAR_CLIENTES_EXITO, datos);
		return respuesta;
	}
}
