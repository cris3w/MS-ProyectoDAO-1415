package presentacion.controlador.comandos.matriculas;

import negocio.factoria.FactoriaSA;
import negocio.matriculas.SAMatriculas;
import negocio.matriculas.TransferMatricula;
import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.RespuestaComando;
import presentacion.controlador.dispatcher.EventoVista;

public class ComandoCancelarMatricula extends Comando {

	@Override
	public RespuestaComando ejecutar() throws Exception {
		SAMatriculas sa = FactoriaSA.obtenerInstancia().crearSAMatriculas() ;
		RespuestaComando respuesta;
		if (sa.cancelarMatricula((TransferMatricula) datos)) {
			respuesta = new RespuestaComando(EventoVista.CANCELAR_MATRICULA_EXITO, datos);
		} else {
			respuesta = new RespuestaComando(EventoVista.CANCELAR_MATRICULA_FALLO, datos);
		}
		return respuesta;
	}
}
