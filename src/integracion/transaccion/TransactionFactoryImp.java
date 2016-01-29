package integracion.transaccion;

public class TransactionFactoryImp extends TransactionFactory {
	
	public Transaction nuevaTransactionMYSQL() {
		return new TransactionMySQL();
	}
}