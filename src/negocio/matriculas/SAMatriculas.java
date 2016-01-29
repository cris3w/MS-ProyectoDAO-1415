package negocio.matriculas;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;

public interface SAMatriculas {
	
	public boolean realizarMatricula(TransferMatricula matricula) throws Exception;
	
	public boolean cancelarMatricula(TransferMatricula matricula) throws Exception;
	
	public ArrayList<TransferCliente> listarMatriculados(TransferActividad actividad) throws Exception;
	
	public ArrayList<TransferActividad> listarMatriculas(TransferCliente cliente) throws Exception;
}
