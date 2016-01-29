package presentacion.controlador.comandos.vistas;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoVistas extends Comando {

	private int id;
	
	public ComandoVistas(int id) {
		this.id = id;
	}
	
	public RespuestaComando ejecutar() throws Exception {
		
		RespuestaComando respuesta;
		
		switch(this.id) {
		
			case EventoNegocio.PRINCIPAL_CREAR_CLIENTE:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_CREAR_CLIENTE, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_ELIMINAR_CLIENTE:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_ELIMINAR_CLIENTE, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_MODIFICAR_CLIENTE:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_MODIFICAR_CLIENTE, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_MOSTRAR_CLIENTE:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_MOSTRAR_CLIENTE, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_CREAR_ACTIVIDAD:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_CREAR_ACTIVIDAD, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_ELIMINAR_ACTIVIDAD:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_ELIMINAR_ACTIVIDAD, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_MODIFICAR_ACTIVIDAD:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_MODIFICAR_ACTIVIDAD, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_MOSTRAR_ACTIVIDAD:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_MOSTRAR_ACTIVIDAD, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_REALIZAR_MATRICULA:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_REALIZAR_MATRICULA, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_CANCELAR_MATRICULA:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_CANCELAR_MATRICULA, datos);
				break;
				
			case EventoNegocio.PRINCIPAL_LISTAR_MATRICULADOS:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_LISTAR_MATRICULADOS, datos);
				break;
			
			case EventoNegocio.PRINCIPAL_LISTAR_MATRICULAS:
				respuesta = new RespuestaComando(EventoVista.PRINCIPAL_LISTAR_MATRICULAS, datos);
				break;
				
			default:
				respuesta = null;
				
		}
		
		return respuesta;
	}
}
