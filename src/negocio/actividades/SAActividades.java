package negocio.actividades;

import java.util.ArrayList;

public interface SAActividades {
	
	public boolean crear(TransferActividad actividad) throws Exception;

	public boolean eliminar(TransferActividad actividad) throws Exception;

	public boolean modificar(TransferActividad actividad) throws Exception;

	public TransferActividad mostrar(TransferActividad actividad) throws Exception;

	public ArrayList<TransferActividad> listar() throws Exception;
}
