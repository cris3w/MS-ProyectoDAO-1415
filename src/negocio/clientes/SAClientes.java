package negocio.clientes;

import java.util.ArrayList;

public interface SAClientes {
	
	public boolean crear(TransferCliente cliente) throws Exception;

	public boolean eliminar(TransferCliente cliente) throws Exception;

	public boolean modificar(TransferCliente cliente) throws Exception;

	public TransferCliente mostrar(TransferCliente cliente) throws Exception;

	public ArrayList<TransferCliente> listar() throws Exception;
}