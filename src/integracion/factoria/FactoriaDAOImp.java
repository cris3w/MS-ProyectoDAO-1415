package integracion.factoria;

import integracion.actividades.DAOActividades;
import integracion.actividades.DAOActividadesImp;
import integracion.clientes.DAOClientes;
import integracion.clientes.DAOClientesImp;
import integracion.matriculas.DAOMatriculas;
import integracion.matriculas.DAOMatriculasImp;

public class FactoriaDAOImp extends FactoriaDAO {
	
	public DAOClientes crearDAOClientes() {
		DAOClientes clientes = new DAOClientesImp(); 
		return clientes; 
	}

	public DAOActividades crearDAOActividades() {
		DAOActividades actividades = new DAOActividadesImp(); 
		return actividades; 
	}

	public DAOMatriculas crearDAOMatriculas() {
		DAOMatriculas matriculas = new DAOMatriculasImp(); 
		return matriculas; 
	}
}