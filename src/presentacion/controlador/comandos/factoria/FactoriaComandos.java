package presentacion.controlador.comandos.factoria;

import presentacion.controlador.comandos.Comando;

public abstract class FactoriaComandos {
	
	private static FactoriaComandos instancia;

	public static FactoriaComandos obtenerInstancia() {
		if (instancia == null) instancia = new FactoriaComandosImp(); 
        return instancia; 
	}
	
	public abstract Comando producirComando(int numeroComando, Object transfer);
}