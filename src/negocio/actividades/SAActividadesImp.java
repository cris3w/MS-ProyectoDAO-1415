package negocio.actividades;

import integracion.actividades.DAOActividades;
import integracion.factoria.FactoriaDAO;
import integracion.matriculas.DAOMatriculas;
import integracion.transaccion.Transaction;
import integracion.transaccion.TransactionManager;

import java.util.ArrayList;

import negocio.clientes.TransferCliente;
import negocio.matriculas.TransferMatricula;

public class SAActividadesImp implements SAActividades {

	@Override
	public boolean crear(TransferActividad actividad) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		try {
			TransferActividad act = new TransferActividad();
			act.setNombre(actividad.getNombre()); 
			
			act = daoActividad.buscarPorNombre(act);
			if (act == null) {
				actividad.setActivo(1);
				actividad.setMatriculados(0);
				verificar = daoActividad.crear(actividad);
				transaccion.commit();
			} else { 
				if (!act.isActivo()) {
					actividad.setId(act.getId());
					verificar = daoActividad.modificar(actividad);
					transaccion.commit();
				} else throw new Exception("La actividad ya existe");
			}					
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido crear la actividad \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
		return verificar;
	}

	@Override
	public boolean eliminar(TransferActividad actividad) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		
		TransferActividad act = daoActividad.mostrar(actividad);
		try {
			if (act != null && act.getActivo() == 1) {
				ArrayList<TransferCliente> matriculados = daoMatricula.listarMatriculados(actividad); 
				if (matriculados.size() > 0) {
					for (int i = 0; i < matriculados.size(); i++) {
						TransferMatricula matricula = new TransferMatricula(matriculados.get(i).getId(), act.getId());
						verificar = daoMatricula.cancelarMatricula(matricula);
						act.setMatriculados(act.getMatriculados()-1);
						verificar = daoActividad.modificar(act);
					}
				}
				verificar = daoActividad.eliminar(act);
				transaccion.commit();
			} else throw new Exception("La actividad no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido eliminar la actividad \n" + e.getMessage());
		} finally{
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return verificar;
	}

	@Override
	public boolean modificar(TransferActividad actividad) throws Exception {
		boolean verificar = false;
		
    	Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
			
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		TransferActividad act = daoActividad.mostrar(actividad);
		try {
			if (act != null) {
				if (daoActividad.buscarPorNombre(actividad) == null || act.getNombre().equals(actividad.getNombre())) {
					actividad.setMatriculados(act.getMatriculados());
					actividad.setActivo(1);
					verificar = daoActividad.modificar(actividad);
					transaccion.commit();
				} else throw new Exception ("El nombre no es valido");
			} else throw new Exception("La actividad no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido modificar la actividad \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return verificar;
	}

	@Override
	public TransferActividad mostrar(TransferActividad actividad) throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		TransferActividad act = daoActividad.mostrar(actividad);
		try {
			if (act != null){
				if (act.isActivo()){
					actividad = act;
					transaccion.commit();
				} else throw new Exception("La actividad no existe");
			} else throw new Exception("La actividad no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido mostrar la actividad \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
		return actividad;
	}

	@Override
	public ArrayList<TransferActividad> listar() throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		ArrayList<TransferActividad> actividades = new ArrayList<TransferActividad>();
		
		try {
			actividades = daoActividad.listar();
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido listar las actividades \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return actividades;
	}
}
