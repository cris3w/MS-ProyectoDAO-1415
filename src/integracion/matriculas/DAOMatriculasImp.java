package integracion.matriculas;

import integracion.transaccion.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.actividades.TransferActividad;
import negocio.clientes.TransferCliente;
import negocio.matriculas.TransferMatricula;

public class DAOMatriculasImp implements DAOMatriculas {

	@Override
	public boolean realizarMatricula(TransferMatricula matricula) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("insert into matriculas values(?,?)");
		ps.setInt(1, matricula.getIdCliente());
		ps.setInt(2, matricula.getIdActividad());
		ps.execute();
		verificacion = true;
		
		return verificacion;
	}

	@Override
	public boolean cancelarMatricula(TransferMatricula matricula) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("delete from matriculas where id_cliente=? and id_actividad=?");
		ps.setInt(1, matricula.getIdCliente());	
		ps.setInt(2, matricula.getIdActividad());	
		ps.execute();
		verificacion = true;
		
		return verificacion;
	}
	
	@Override
	public TransferMatricula buscarPorKey(TransferMatricula matricula) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("select id_cliente, id_actividad from matriculas where id_cliente=? and id_actividad=? for update");
		ps.setInt(1, matricula.getIdCliente());	
		ps.setInt(2, matricula.getIdActividad());	
		ResultSet rs = ps.executeQuery();
        
		TransferMatricula mat = new TransferMatricula();
	    if (rs.next()) {
	    	mat.setIdCliente(rs.getInt("id_cliente"));
	    	mat.setIdActividad(rs.getInt("id_actividad"));
        } else mat = null;

		return mat;
	}
	
	@Override
	public ArrayList<TransferCliente> listarMatriculados(TransferActividad actividad) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		TransferCliente cliente;
    	ArrayList<TransferCliente> clientes = new ArrayList<TransferCliente>();
		
		PreparedStatement ps;		
    	ps = conexion.prepareStatement("select id_cliente from matriculas where id_actividad=? for update");
    	ps.setInt(1, actividad.getId());
	    ResultSet rs = ps.executeQuery();
	    
		while (rs.next()) {
		    cliente = new TransferCliente();
			cliente.setId(rs.getInt("id_cliente"));	
			
			clientes.add(cliente);
		} 
	    
    	return clientes;
    }
	
	@Override
	public ArrayList<TransferActividad> listarMatriculas(TransferCliente cliente) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		TransferActividad actividad;
    	ArrayList<TransferActividad> actividades = new ArrayList<TransferActividad>();
		
		PreparedStatement ps;		
    	ps = conexion.prepareStatement("select id_actividad from matriculas where id_cliente=? for update");
    	ps.setInt(1, cliente.getId());
	    ResultSet rs = ps.executeQuery();
	    
		while (rs.next()) {
		    actividad = new TransferActividad();
			actividad.setId(rs.getInt("id_actividad"));	
			
			actividades.add(actividad);
		} 
	    
    	return actividades;
    }
}
