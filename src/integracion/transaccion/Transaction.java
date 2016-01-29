package integracion.transaccion;

import java.sql.Connection;

public interface Transaction {
	
	public Connection start();
	
	public void commit();

	public void rollback();

	public Object getResource();
}