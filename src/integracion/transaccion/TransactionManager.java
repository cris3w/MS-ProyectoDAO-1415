package integracion.transaccion;

public abstract class TransactionManager {
	
	private static TransactionManager instanciaTransactionManager;

	public static TransactionManager getInstancia() {
		if (instanciaTransactionManager == null) instanciaTransactionManager = new TransactionManagerImp();
		return instanciaTransactionManager;
	}

	public abstract Transaction nuevaTransaccion();

	public abstract Transaction getTransaccion();

	public abstract void eliminarTransaccion() throws Exception;
}