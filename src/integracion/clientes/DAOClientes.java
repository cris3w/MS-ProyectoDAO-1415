package integracion.clientes;

import java.util.ArrayList;

import negocio.clientes.TransferCliente;

public interface DAOClientes {

    boolean crear(TransferCliente cliente) throws Exception; 
    
    boolean eliminar(TransferCliente cliente) throws Exception; 
  
    boolean modificar(TransferCliente cliente) throws Exception; 
  
    TransferCliente mostrar(TransferCliente cliente) throws Exception; 
	
    ArrayList<TransferCliente> listar() throws Exception;

	TransferCliente buscarPorDni(TransferCliente cliente) throws Exception;
}
