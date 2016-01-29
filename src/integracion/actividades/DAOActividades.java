package integracion.actividades;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;

public interface DAOActividades {
	
	boolean crear(TransferActividad actividad) throws Exception; 
    
    boolean eliminar(TransferActividad actividad) throws Exception; 
  
    boolean modificar(TransferActividad actividad) throws Exception; 
  
    TransferActividad mostrar(TransferActividad actividad) throws Exception; 
	
    ArrayList<TransferActividad> listar() throws Exception;

    TransferActividad buscarPorNombre(TransferActividad actividad) throws Exception;
}
