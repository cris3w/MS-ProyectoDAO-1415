package presentacion.controlador.dispatcher;

import presentacion.gui.actividades.GUICrearActividad;
import presentacion.gui.actividades.GUIEliminarActividad;
import presentacion.gui.actividades.GUIListarActividades;
import presentacion.gui.actividades.GUIModificarActividad;
import presentacion.gui.actividades.GUIMostrarActividad;
import presentacion.gui.clientes.GUICrearCliente;
import presentacion.gui.clientes.GUIEliminarCliente;
import presentacion.gui.clientes.GUIListarClientes;
import presentacion.gui.clientes.GUIModificarCliente;
import presentacion.gui.clientes.GUIMostrarCliente;
import presentacion.gui.matriculas.GUICancelarMatricula;
import presentacion.gui.matriculas.GUIListarMatriculados;
import presentacion.gui.matriculas.GUIListarMatriculas;
import presentacion.gui.matriculas.GUIRealizarMatricula;

public class DispatcherImp extends Dispatcher {

	public void redirigirVista(int id_evento_vista, Object datos) {
		
		switch (id_evento_vista) {
		
		//CLIENTES
		
		case EventoVista.CREAR_CLIENTE_EXITO:
			GUICrearCliente.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.CREAR_CLIENTE_FALLO:
			GUICrearCliente.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.ELIMINAR_CLIENTE_EXITO:
			GUIEliminarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.ELIMINAR_CLIENTE_FALLO:
			GUIEliminarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.MODIFICAR_CLIENTE_EXITO:
			GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); 
			break;
			
		case EventoVista.MODIFICAR_CLIENTE_FALLO:
			GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.BUSCAR_CLIENTE_EXITO:
			GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.BUSCAR_CLIENTE_FALLO:
			GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;

		case EventoVista.MOSTRAR_CLIENTE_EXITO:
			GUIMostrarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.MOSTRAR_CLIENTE_FALLO:
			GUIMostrarCliente.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;

		case EventoVista.LISTAR_CLIENTES_EXITO: 
			GUIListarClientes.obtenerInstancia().actualizar(id_evento_vista, datos);
			GUIListarClientes.obtenerInstancia().setVisible(true);
			break;
			
		case EventoVista.LISTAR_CLIENTES_FALLO: 
			GUIListarClientes.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;

		case EventoVista.PRINCIPAL_CREAR_CLIENTE:
			GUICrearCliente.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_ELIMINAR_CLIENTE:
			GUIEliminarCliente.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_MODIFICAR_CLIENTE:
			GUIModificarCliente.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_MOSTRAR_CLIENTE:
			GUIMostrarCliente.obtenerInstancia().setVisible(true);
			break;
			
		// ACTIVIDADES
			
		case EventoVista.CREAR_ACTIVIDAD_EXITO:
			GUICrearActividad.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.CREAR_ACTIVIDAD_FALLO:
			GUICrearActividad.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.ELIMINAR_ACTIVIDAD_EXITO:
			GUIEliminarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.ELIMINAR_ACTIVIDAD_FALLO:
			GUIEliminarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.MODIFICAR_ACTIVIDAD_EXITO:
			GUIModificarActividad.obtenerInstancia().actualizar(id_evento_vista, datos); 
			break;
			
		case EventoVista.MODIFICAR_ACTIVIDAD_FALLO:
			GUIModificarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
			
		case EventoVista.BUSCAR_ACTIVIDAD_EXITO:
			GUIModificarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.BUSCAR_ACTIVIDAD_FALLO:
			GUIModificarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;

		case EventoVista.MOSTRAR_ACTIVIDAD_EXITO:
			GUIMostrarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.MOSTRAR_ACTIVIDAD_FALLO:
			GUIMostrarActividad.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;

		case EventoVista.LISTAR_ACTIVIDADES_EXITO: 
			GUIListarActividades.obtenerInstancia().actualizar(id_evento_vista, datos);
			GUIListarActividades.obtenerInstancia().setVisible(true);
			break;
			
		case EventoVista.LISTAR_ACTIVIDADES_FALLO: 
			GUIListarActividades.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.PRINCIPAL_CREAR_ACTIVIDAD:
			GUICrearActividad.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_ELIMINAR_ACTIVIDAD:
			GUIEliminarActividad.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_MODIFICAR_ACTIVIDAD:
			GUIModificarActividad.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_MOSTRAR_ACTIVIDAD:
			GUIMostrarActividad.obtenerInstancia().setVisible(true);
			break;
			
		// MATRICULAS
			
		case EventoVista.REALIZAR_MATRICULA_EXITO:
			GUIRealizarMatricula.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.REALIZAR_MATRICULA_FALLO:
			GUIRealizarMatricula.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
		
		case EventoVista.CANCELAR_MATRICULA_EXITO:
			GUICancelarMatricula.obtenerInstancia().actualizar(id_evento_vista, datos);	
			break;
			
		case EventoVista.CANCELAR_MATRICULA_FALLO:
			GUICancelarMatricula.obtenerInstancia().actualizar(id_evento_vista, datos);
			break;
		
		case EventoVista.PRINCIPAL_REALIZAR_MATRICULA:
			GUIRealizarMatricula.obtenerInstancia().setVisible(true);
			break;

		case EventoVista.PRINCIPAL_CANCELAR_MATRICULA:
			GUICancelarMatricula.obtenerInstancia().setVisible(true);
			break;
		
		case EventoVista.PRINCIPAL_LISTAR_MATRICULADOS:
			GUIListarMatriculados.obtenerInstancia().setVisible(true);
			break;
		
		case EventoVista.PRINCIPAL_LISTAR_MATRICULAS:
			GUIListarMatriculas.obtenerInstancia().setVisible(true);
			break;
		}
	}
}
