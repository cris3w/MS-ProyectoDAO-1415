package integracion.actividades;

import integracion.transaccion.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.actividades.TransferActividad;


public class DAOActividadesImp implements DAOActividades {

	@Override
	public boolean crear(TransferActividad actividad) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("insert into actividades values(SECUENCIA_ACTIVIDADES.nextval,?,?,?,?,?)");
	
		ps.setString(1, actividad.getNombre());
		ps.setString(2, actividad.getDiaSemana());
		ps.setInt(3, actividad.getAforo());
		ps.setInt(4, actividad.getActivo());
		ps.setInt(5, actividad.getMatriculados());
        ps.execute();
        verificacion = true;
        
		return verificacion;
	}

	@Override
	public boolean eliminar(TransferActividad actividad) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
 
		PreparedStatement ps;
		ps = conexion.prepareStatement("update actividades set activo=0 where id=?");
		ps.setInt(1, actividad.getId());
		ps.execute();
		verificacion = true;
					        
		return verificacion;
	}

	@Override
	public boolean modificar(TransferActividad actividad) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("update actividades set nombre=?, dia_semana=?, aforo=?, activo=?, matriculados=? where id=?");
		
		ps.setInt(6, actividad.getId());
		ps.setString(1, actividad.getNombre());
		ps.setString(2, actividad.getDiaSemana());
		ps.setInt(3, actividad.getAforo());
		ps.setInt(4, actividad.getActivo());
		ps.setInt(5, actividad.getMatriculados());
		ps.execute();
		verificacion = true;
				
		return verificacion;	
	}

	@Override
	public TransferActividad mostrar(TransferActividad actividad) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("select id, nombre, dia_semana, aforo, activo, matriculados from actividades where id=? for update");
		ps.setInt(1, actividad.getId());	
	    ResultSet rs = ps.executeQuery();
	    
	    TransferActividad act = new TransferActividad();
	    if (rs.next()) {
	    	act.setId(rs.getInt("id"));
	    	act.setNombre(rs.getString("nombre"));
	    	act.setDiaSemana(rs.getString("dia_semana"));
	    	act.setAforo(rs.getInt("aforo"));
	    	act.setActivo(rs.getInt("activo"));
	    	act.setMatriculados(rs.getInt("matriculados"));
	    } else act = null;
	    
		return act;
	}

	@Override
	public ArrayList<TransferActividad> listar() throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		TransferActividad actividad = new TransferActividad();
    	ArrayList<TransferActividad> actividades = new ArrayList<TransferActividad>();
		
		PreparedStatement ps;		
    	ps = conexion.prepareStatement("select id, nombre, dia_semana, aforo, activo, matriculados from actividades where activo=1 for update");
	    ResultSet rs = ps.executeQuery();
	    
	    while (rs.next()) {
	    	actividad = new TransferActividad();
		    actividad.setId(rs.getInt("id"));
		    actividad.setNombre(rs.getString("nombre"));
		    actividad.setDiaSemana(rs.getString("dia_semana")) ;
		    actividad.setAforo(rs.getInt("aforo"));
		    actividad.setActivo(rs.getInt("activo"));
		    actividad.setMatriculados(rs.getInt("matriculados"));
		    
		    actividades.add(actividad);
	    }
	    
    	return actividades;
	}

	@Override
	public TransferActividad buscarPorNombre(TransferActividad actividad) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("select id, nombre, dia_semana, aforo, activo, matriculados from actividades where nombre=? for update");
		ps.setString(1, actividad.getNombre());	
		ResultSet rs = ps.executeQuery();
		
		TransferActividad act = new TransferActividad();
	    if (rs.next()) {
	    	act.setId(rs.getInt("id"));
	    	act.setNombre(rs.getString("nombre"));
	    	act.setDiaSemana(rs.getString("dia_semana"));
	    	act.setAforo(rs.getInt("aforo"));
	    	act.setActivo(rs.getInt("activo"));
	    	act.setMatriculados(rs.getInt("matriculados"));
	    } else act = null;
	    
		return act;
	}
}
