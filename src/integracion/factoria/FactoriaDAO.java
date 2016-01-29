package integracion.factoria;

import integracion.actividades.DAOActividades;
import integracion.clientes.DAOClientes;
import integracion.matriculas.DAOMatriculas;

public abstract class FactoriaDAO {
	
	private static FactoriaDAO instancia;

	public static FactoriaDAO getInstancia() {
		if (instancia == null) instancia = new FactoriaDAOImp(); 
		return instancia; 
	}

	public abstract DAOClientes crearDAOClientes();

	public abstract DAOActividades crearDAOActividades();

	public abstract DAOMatriculas crearDAOMatriculas();
}