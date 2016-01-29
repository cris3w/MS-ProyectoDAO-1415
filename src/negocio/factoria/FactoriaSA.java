package negocio.factoria;

import java.io.IOException;

import negocio.actividades.SAActividades;
import negocio.clientes.SAClientes;
import negocio.matriculas.SAMatriculas;

public abstract class FactoriaSA {
	
	private static FactoriaSA instancia;
	
	public static FactoriaSA obtenerInstancia () { 
		if (instancia == null) instancia = new FactoriaSAImp(); 
		return instancia; 
	} 
	   
	public abstract SAClientes crearSAClientes () throws IOException; 
	
	public abstract SAActividades crearSAActividades () throws IOException; 
	
	public abstract SAMatriculas crearSAMatriculas() throws IOException ; 
}
