package presentacion.controlador.comandos.factoria;

import presentacion.controlador.comandos.Comando;
import presentacion.controlador.comandos.actividades.ComandoBuscarActividad;
import presentacion.controlador.comandos.actividades.ComandoCrearActividad;
import presentacion.controlador.comandos.actividades.ComandoEliminarActividad;
import presentacion.controlador.comandos.actividades.ComandoListarActividades;
import presentacion.controlador.comandos.actividades.ComandoModificarActividad;
import presentacion.controlador.comandos.actividades.ComandoMostrarActividad;
import presentacion.controlador.comandos.clientes.ComandoBuscarCliente;
import presentacion.controlador.comandos.clientes.ComandoCrearCliente;
import presentacion.controlador.comandos.clientes.ComandoEliminarCliente;
import presentacion.controlador.comandos.clientes.ComandoListarClientes;
import presentacion.controlador.comandos.clientes.ComandoModificarCliente;
import presentacion.controlador.comandos.clientes.ComandoMostrarCliente;
import presentacion.controlador.comandos.matriculas.ComandoCancelarMatricula;
import presentacion.controlador.comandos.matriculas.ComandoListarMatriculados;
import presentacion.controlador.comandos.matriculas.ComandoListarMatriculas;
import presentacion.controlador.comandos.matriculas.ComandoRealizarMatricula;
import presentacion.controlador.comandos.vistas.ComandoVistas;

public class FactoriaComandosImp extends FactoriaComandos {

	public Comando producirComando(int id_comando, Object datos) {
		
		Comando comando = null;
		
		switch (id_comando) {
		
			// CLIENTES
				
			case EventoNegocio.CREAR_CLIENTE:
				comando = new ComandoCrearCliente();
				break; 
				
			case EventoNegocio.ELIMINAR_CLIENTE:
				comando = new ComandoEliminarCliente();
				break;
				
			case EventoNegocio.MODIFICAR_CLIENTE:
				comando = new ComandoModificarCliente();
				break;
				
			case EventoNegocio.MOSTRAR_CLIENTE:
				comando = new ComandoMostrarCliente();
				break;
			
			case EventoNegocio.LISTAR_CLIENTES:
				comando = new ComandoListarClientes();
				break;
			
			case EventoNegocio.BUSCAR_CLIENTE:
				comando = new ComandoBuscarCliente();
				break;
			
			case EventoNegocio.PRINCIPAL_CREAR_CLIENTE:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_CREAR_CLIENTE);
				break;

			case EventoNegocio.PRINCIPAL_ELIMINAR_CLIENTE:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_ELIMINAR_CLIENTE);
				break;

			case EventoNegocio.PRINCIPAL_MODIFICAR_CLIENTE:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_MODIFICAR_CLIENTE);
				break;

			case EventoNegocio.PRINCIPAL_MOSTRAR_CLIENTE:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_MOSTRAR_CLIENTE);
				break;
				
			// ACTIVIDADES
			
			case EventoNegocio.CREAR_ACTIVIDAD:
				comando = new ComandoCrearActividad();
				break; 
				
			case EventoNegocio.ELIMINAR_ACTIVIDAD:
				comando = new ComandoEliminarActividad();
				break;
				
			case EventoNegocio.MODIFICAR_ACTIVIDAD:
				comando = new ComandoModificarActividad();
				break;
				
			case EventoNegocio.MOSTRAR_ACTIVIDAD:
				comando = new ComandoMostrarActividad();
				break;
			
			case EventoNegocio.LISTAR_ACTIVIDADES:
				comando = new ComandoListarActividades();
				break;
			
			case EventoNegocio.BUSCAR_ACTIVIDAD:
				comando = new ComandoBuscarActividad();
				break;
			
			case EventoNegocio.PRINCIPAL_CREAR_ACTIVIDAD:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_CREAR_ACTIVIDAD);
				break;

			case EventoNegocio.PRINCIPAL_ELIMINAR_ACTIVIDAD:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_ELIMINAR_ACTIVIDAD);
				break;

			case EventoNegocio.PRINCIPAL_MODIFICAR_ACTIVIDAD:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_MODIFICAR_ACTIVIDAD);
				break;

			case EventoNegocio.PRINCIPAL_MOSTRAR_ACTIVIDAD:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_MOSTRAR_ACTIVIDAD);
				break;
				
			// MATRICULAS
				
			case EventoNegocio.REALIZAR_MATRICULA:
				comando = new ComandoRealizarMatricula();
				break; 
				
			case EventoNegocio.CANCELAR_MATRICULA:
				comando = new ComandoCancelarMatricula();
				break;
			
			case EventoNegocio.LISTAR_MATRICULADOS:
				comando = new ComandoListarMatriculados();
				break;
			
			case EventoNegocio.LISTAR_MATRICULAS:
				comando = new ComandoListarMatriculas();
				break;
			
			case EventoNegocio.PRINCIPAL_REALIZAR_MATRICULA:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_REALIZAR_MATRICULA);
				break;

			case EventoNegocio.PRINCIPAL_CANCELAR_MATRICULA:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_CANCELAR_MATRICULA);
				break;
			
			case EventoNegocio.PRINCIPAL_LISTAR_MATRICULADOS:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_LISTAR_MATRICULADOS);
				break;
				
			case EventoNegocio.PRINCIPAL_LISTAR_MATRICULAS:
				comando = new ComandoVistas((Integer) EventoNegocio.PRINCIPAL_LISTAR_MATRICULAS);
				break;
		}
		
		return comando;
	}
}