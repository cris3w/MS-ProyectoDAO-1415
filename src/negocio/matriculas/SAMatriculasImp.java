package negocio.matriculas;

import java.util.ArrayList;

import integracion.actividades.DAOActividades;
import integracion.clientes.DAOClientes;
import integracion.factoria.FactoriaDAO;
import integracion.matriculas.DAOMatriculas;
import integracion.transaccion.Transaction;
import integracion.transaccion.TransactionManager;
import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;

public class SAMatriculasImp implements SAMatriculas {

	@Override
	public boolean realizarMatricula(TransferMatricula matricula) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		TransferCliente cli = new TransferCliente();
		cli.setId(matricula.getIdCliente());
		TransferActividad act = new TransferActividad();
		act.setId(matricula.getIdActividad());
		TransferMatricula mat = new TransferMatricula();
		
		try {
			cli = daoCliente.mostrar(cli);
			act = daoActividad.mostrar(act);
			if (cli != null && cli.isActivo()) {
				if (act != null && act.isActivo()) {
					mat = daoMatricula.buscarPorKey(matricula);
					if (mat == null) {
						if (!act.isCompleta()) {
							act.setMatriculados(act.getMatriculados()+1);
							verificar = daoActividad.modificar(act);
							verificar = daoMatricula.realizarMatricula(matricula);
							transaccion.commit();
						} else throw new Exception("La actividad está completa");
					} else throw new Exception ("El cliente ya está matriculado en esa actividad");	
				} else throw new Exception("La actividad no existe");
			} else throw new Exception ("El cliente no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido realizar la matricula \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
		return verificar;
	}

	@Override
	public boolean cancelarMatricula(TransferMatricula matricula) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		TransferMatricula mat = new TransferMatricula();
		
		try {
			mat = daoMatricula.buscarPorKey(matricula);
			if (mat != null) {
				DAOActividades daoActividad = factoria.crearDAOActividades();
				TransferActividad act = new TransferActividad();
				act.setId(matricula.getIdActividad());
				act = daoActividad.mostrar(act);
				act.setMatriculados(act.getMatriculados()-1);
				verificar = daoActividad.modificar(act);
				verificar = daoMatricula.cancelarMatricula(matricula);
				transaccion.commit();
			} else throw new Exception("La matricula no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido realizar la matricula \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
		return verificar;
	}
	
	public ArrayList<TransferCliente> listarMatriculados(TransferActividad actividad) throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		TransferActividad act = new TransferActividad();
		act.setId(actividad.getId());
		ArrayList<TransferCliente> clientes = new ArrayList<TransferCliente>();

		try {
			act = daoActividad.mostrar(act);
			if (act != null && act.getActivo() == 1) {
				clientes = daoMatricula.listarMatriculados(actividad);
				if (clientes.size() > 0) {
					DAOClientes daoCliente = factoria.crearDAOClientes();
					for (int i = 0; i < clientes.size(); i++) {
						clientes.set(i, daoCliente.mostrar(clientes.get(i)));
					}
					transaccion.commit();
				} else throw new Exception ("No hay clientes matriculados en esa actividad");
			} else throw new Exception("La actividad no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se han podido listar los matriculados \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return clientes;
	}
	
	public ArrayList<TransferActividad> listarMatriculas(TransferCliente cliente) throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		TransferCliente cli = new TransferCliente();
		cli.setId(cliente.getId());
		ArrayList<TransferActividad> actividades = new ArrayList<TransferActividad>();

		try {
			cli = daoCliente.mostrar(cli);
			if (cli != null && cli.getActivo() == 1) {
				actividades = daoMatricula.listarMatriculas(cliente);
				if (actividades.size() > 0) {
					DAOActividades daoActividad = factoria.crearDAOActividades();
					for (int i = 0; i < actividades.size(); i++) {
						actividades.set(i, daoActividad.mostrar(actividades.get(i)));
					}
					transaccion.commit();
				} else throw new Exception ("El cliente no está matriculado ninguna actividad");
			} else throw new Exception("El cliente no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se han podido listar las matriculas \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return actividades;
	}
}
