package integracion.clientes;

import integracion.transaccion.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Types;

import negocio.clientes.TransferCliente;
import negocio.clientes.TransferNormal;
import negocio.clientes.TransferVip;

public class DAOClientesImp implements DAOClientes {
	
	@Override
	public boolean crear(TransferCliente cliente) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("insert into clientes values(SECUENCIA_CLIENTES.nextval,?,?,?,?,?,?,?)");
	
		ps.setString(1, cliente.getDni());
		ps.setString(2, cliente.getNombre());
		ps.setInt(3, cliente.getTelefono());
		ps.setInt(4, cliente.getActivo());
		ps.setInt(5, cliente.getTipo());
        if (cliente.getTipo() == 1) {
        	ps.setInt(6,((TransferVip) cliente).getPuntos());
        	ps.setNull(7, Types.INTEGER);
        } else if (cliente.getTipo() == 0) {
        	ps.setNull(6, Types.INTEGER);
        	ps.setInt(7, ((TransferNormal) cliente).getPiscina());
        }
        ps.execute();
        verificacion = true;
        
		return verificacion;
	}

	@Override
	public boolean eliminar(TransferCliente cliente) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
 
		PreparedStatement ps;
		ps = conexion.prepareStatement("update clientes set activo=0 where id=?");
		ps.setInt(1, cliente.getId());
		ps.execute();
		verificacion = true;
					        
		return verificacion;
	}

	@Override
	public boolean modificar(TransferCliente cliente) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		boolean verificacion = false;
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("update clientes set dni=?, nombre=?, telefono=?, activo=?, tipo=?, puntos=?, piscina=? where id=?");
		
		ps.setInt(8, cliente.getId());
		ps.setString(1, cliente.getDni());
		ps.setString(2, cliente.getNombre());
		ps.setInt(3, cliente.getTelefono());
		ps.setInt(4, cliente.getActivo());
		ps.setInt(5, cliente.getTipo());
		if (cliente.getTipo() == 1) {
			ps.setInt(6, ((TransferVip) cliente).getPuntos());
			ps.setNull(7, Types.INTEGER);
		} else if (cliente.getTipo() == 0) {
			ps.setNull(6, Types.INTEGER);
			ps.setInt(7, ((TransferNormal) cliente).getPiscina());
		}
		ps.execute();
		verificacion = true;
				
		return verificacion;
	}

	@Override
	public TransferCliente mostrar(TransferCliente cliente) throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("select id, dni, nombre, telefono, activo, tipo, puntos, piscina from clientes where id=? for update");
		ps.setInt(1, cliente.getId());	
	    ResultSet rs = ps.executeQuery();
	    
	    if (rs.next()) {
	    	if (rs.getInt("tipo") == 1) {
	    		TransferVip vip = new TransferVip();
	    		vip.setPuntos(rs.getInt("puntos"));
	    		cliente = vip;
	    	} else if (rs.getInt("tipo") == 0) {
	    		TransferNormal normal = new TransferNormal();
	    		normal.setPiscina(rs.getInt("piscina"));
	    		cliente = normal;
	    	}
	    	cliente.setId(rs.getInt("id"));
	    	cliente.setDni(rs.getString("dni"));
	    	cliente.setNombre(rs.getString("nombre"));
	    	cliente.setTelefono(rs.getInt("telefono"));
	    	cliente.setActivo(rs.getInt("activo"));
	    	cliente.setTipo(rs.getInt("tipo"));	
	    } else cliente = null;
	    
		return cliente;
	}

	@Override
	public ArrayList<TransferCliente> listar() throws SQLException {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		TransferCliente cliente;
    	ArrayList<TransferCliente> clientes = new ArrayList<TransferCliente>();
		
		PreparedStatement ps;		
    	ps = conexion.prepareStatement("select id, dni, nombre, telefono, activo, tipo, puntos, piscina from clientes where activo=1 for update");
	    ResultSet rs = ps.executeQuery();
	    
	    while (rs.next()) {
	    	cliente = new TransferCliente();
		    if (rs.getInt("tipo") == 1) {
		    	TransferVip vip = new TransferVip();
				vip.setPuntos(rs.getInt("puntos"));
				cliente = vip;
				    
		    } else if (rs.getInt("tipo") == 0) {
		        TransferNormal normal = new TransferNormal();
		        normal.setPiscina(rs.getInt("piscina"));
		        cliente = normal;
		    }
		    cliente.setId(rs.getInt("id"));
		    cliente.setDni(rs.getString("dni"));
		    cliente.setNombre(rs.getString("nombre")) ;
		    cliente.setTelefono(rs.getInt("telefono"));
		    cliente.setActivo(rs.getInt("Activo"));
		    cliente.setTipo(rs.getInt("tipo"));
		    
		    clientes.add(cliente);
	    }
	    
    	return clientes;
    }
	
	@Override
	public TransferCliente buscarPorDni(TransferCliente cliente) throws Exception {
		Connection conexion = (Connection)TransactionManager.getInstancia().getTransaccion().getResource();
		
		PreparedStatement ps;
		ps = conexion.prepareStatement("select id, dni, nombre, telefono, activo, tipo, puntos, piscina from clientes where dni=? for update");
		ps.setString(1, cliente.getDni());	
		ResultSet rs = ps.executeQuery();
        
	    if (rs.next()) {
	    	if (rs.getInt("tipo") == 1) {
	    		TransferVip vip = new TransferVip();
	    		vip.setPuntos(rs.getInt("puntos"));
	    		cliente = vip;
	    	} else if (rs.getInt("tipo") == 0) {
	    		TransferNormal normal = new TransferNormal();
	    		normal.setPiscina(rs.getInt("piscina"));
	    		cliente = normal;
	    	}
	    	cliente.setId(rs.getInt("id"));
	    	cliente.setDni(rs.getString("dni"));
	    	cliente.setNombre(rs.getString("nombre"));
	    	cliente.setTelefono(rs.getInt("telefono"));
	    	cliente.setActivo(rs.getInt("activo"));
	    	cliente.setTipo(rs.getInt("tipo"));
        } else cliente = null;
	    
		return cliente;
	}
}