package negocio.clientes;

import integracion.actividades.DAOActividades;
import integracion.clientes.DAOClientes;
import integracion.factoria.FactoriaDAO;
import integracion.matriculas.DAOMatriculas;
import integracion.transaccion.Transaction;
import integracion.transaccion.TransactionManager;

import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.matriculas.TransferMatricula;

public class SAClientesImp implements SAClientes {
	
	@Override
	public boolean crear(TransferCliente cliente) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		
		try {
			TransferCliente cli = new TransferCliente();
			cli.setDni(cliente.getDni()); 
			
			cli = daoCliente.buscarPorDni(cli);
			if (cli == null) {
				cliente.setActivo(1);
				verificar = daoCliente.crear(cliente);
				transaccion.commit();
			} else { 
				if (!cli.isActivo()) {
					cliente.setId(cli.getId());
					verificar = daoCliente.modificar(cliente);
					transaccion.commit();
				} else throw new Exception("El cliente ya existe"); 
			}					
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido crear el cliente \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
		return verificar;
	}

	@Override
	public boolean eliminar(TransferCliente cliente) throws Exception {
		boolean verificar = false;
		
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		DAOMatriculas daoMatricula = factoria.crearDAOMatriculas();
		DAOActividades daoActividad = factoria.crearDAOActividades();
		
		TransferCliente cli = daoCliente.mostrar(cliente);
		TransferActividad act = new TransferActividad();
		try {
			if (cli != null && cli.getActivo() == 1) {
				ArrayList<TransferActividad> matriculas = daoMatricula.listarMatriculas(cliente); 
				if (matriculas.size() > 0) {
					for (int i = 0; i < matriculas.size(); i++) {
						act.setId(matriculas.get(i).getId());
						act = daoActividad.mostrar(act);
						TransferMatricula matricula = new TransferMatricula(cli.getId(), act.getId());
						verificar = daoMatricula.cancelarMatricula(matricula);
						act.setMatriculados(act.getMatriculados()-1);
						verificar = daoActividad.modificar(act);
					}
				}
				verificar = daoCliente.eliminar(cliente);
				transaccion.commit();
			} else throw new Exception("El cliente no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido eliminar el cliente \n" + e.getMessage());
		} finally{
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return verificar;
	}

	@Override
	public boolean modificar(TransferCliente cliente) throws Exception {
		boolean verificar = false;
		
    	Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
			
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		
		TransferCliente cli = daoCliente.mostrar(cliente);
		try {
			if (cli != null) {
				if (daoCliente.buscarPorDni(cliente) == null || cli.getDni().equals(cliente.getDni())) {
					cliente.setActivo(1);
					verificar = daoCliente.modificar(cliente);
					transaccion.commit();
				} else throw new Exception ("El DNI no es valido");
			} else throw new Exception("El cliente no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido modificar el cliente \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return verificar;
	}

	@Override
	public TransferCliente mostrar(TransferCliente cliente) throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		
		TransferCliente cli = daoCliente.mostrar(cliente);
		try {
			if (cli != null){
				if (cli.isActivo()){
					cliente = cli;
					transaccion.commit();
				} else throw new Exception("El cliente no existe");
			} else throw new Exception("El cliente no existe");
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido mostrar el cliente \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return cliente;
	}

	@Override
	public ArrayList<TransferCliente> listar() throws Exception {
		Transaction transaccion = TransactionManager.getInstancia().getTransaccion();
		transaccion.start();
		
		FactoriaDAO factoria = FactoriaDAO.getInstancia ();
		DAOClientes daoCliente = factoria.crearDAOClientes();
		
		ArrayList<TransferCliente> clientes = new ArrayList<TransferCliente>();
		
		try {
			clientes = daoCliente.listar();
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw new Exception("No se ha podido listar los clientes \n" + e.getMessage());
		} finally {
			TransactionManager.getInstancia().eliminarTransaccion();
		}
		
    	return clientes;
	}
}