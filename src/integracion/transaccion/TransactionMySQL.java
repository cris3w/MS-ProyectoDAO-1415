package integracion.transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionMySQL implements Transaction {
	
	private Connection connection;

	@SuppressWarnings("finally")
	public Connection start() {
		try {	
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM@//localhost:1521/xe", "SYSTEM", "1234");
			this.connection.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Error: conexion");
		} finally {
			return connection;
		}
	}

	public void commit() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error: Fallo al ejecutar COMMIT");
		}
	}

	public void rollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error: Fallo al ejecutar ROLLBACK");
		}
	}
	
	public Connection getResource() {
		return this.connection;
	}
}