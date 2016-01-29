package integracion.transaccion;

public abstract class TransactionFactory {
	
	private static TransactionFactory instancia;
	
	public static TransactionFactory getInstancia() {
		if (instancia == null) instancia = new TransactionFactoryImp();
		return instancia;
	}
	
	public abstract Transaction nuevaTransactionMYSQL();
}