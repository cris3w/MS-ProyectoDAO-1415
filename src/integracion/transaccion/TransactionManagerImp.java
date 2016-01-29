package integracion.transaccion;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager {
	
	private ConcurrentHashMap<Thread, Transaction> transacciones;
	
	TransactionManagerImp() {
		transacciones = new ConcurrentHashMap<Thread, Transaction>();
	}
	
	public Transaction nuevaTransaccion() {
		Transaction transaccion = TransactionFactory.getInstancia().nuevaTransactionMYSQL();
		transacciones.put(Thread.currentThread(), transaccion);
		return transaccion;
	}

	public Transaction getTransaccion() {
		if (transacciones.get(Thread.currentThread()) == null) {
			nuevaTransaccion();
		}
		return transacciones.get(Thread.currentThread());
	}

	public void eliminarTransaccion() throws Exception {
		transacciones.remove(Thread.currentThread());
	}
}