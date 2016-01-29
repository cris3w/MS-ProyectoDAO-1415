package integracion.matriculas;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;
import negocio.matriculas.TransferMatricula;

public interface DAOMatriculas {

	boolean realizarMatricula(TransferMatricula matricula) throws Exception;
		
	boolean cancelarMatricula(TransferMatricula matricula) throws Exception;
	
	public TransferMatricula buscarPorKey(TransferMatricula matricula) throws Exception;
	
	public ArrayList<TransferCliente> listarMatriculados(TransferActividad actividad) throws Exception;
	
	public ArrayList<TransferActividad> listarMatriculas(TransferCliente cliente) throws Exception;
}
