package presentacion.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnClientes;
	private JMenu mnActividades;
	private JMenuItem mntmCrearCliente;
	private JMenuItem mntmEliminarCliente;
	private JMenuItem mntmModificarCliente;
	private JMenuItem mntmMostrarCliente;
	private JMenuItem mntmListarClientes;
	private JMenuItem mntmCrearActividad;
	private JMenuItem mntmEliminarActividad;
	private JMenuItem mntmModificarActividad;
	private JMenuItem mntmMostrarActividad;
	private JMenuItem mntmListarActividades;
	private JMenu mnMatricula;
	private JMenuItem mntmRealizarMatricula;
	private JMenuItem mntmCancelarMatricula;
	private JMenuItem mntmListarMatriculados;
	private JMenuItem mntmListarMatriculas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal frame = new GUIPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIPrincipal() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setTitle("SPARTANS GYM & FITNESS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Calibri", Font.PLAIN, 12));
		menuBar.add(mnClientes);
		
		mntmCrearCliente = new JMenuItem("Crear Cliente");
		mntmCrearCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCrearClienteActionPerformed(e);
			}
		});
		mnClientes.add(mntmCrearCliente);
		
		mntmEliminarCliente = new JMenuItem("Eliminar Cliente");
		mntmEliminarCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionEliminarClienteActionPerformed(e);
			}
		});
		mnClientes.add(mntmEliminarCliente);
		
		mntmModificarCliente = new JMenuItem("Modificar Cliente");
		mntmModificarCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionModificarClienteActionPerformed(e);
			}
		});
		mnClientes.add(mntmModificarCliente);
		
		mntmMostrarCliente = new JMenuItem("Mostrar Cliente");
		mntmMostrarCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmMostrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionMostrarClienteActionPerformed(e);
			}
		});
		mnClientes.add(mntmMostrarCliente);
		
		mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionListarClientesActionPerformed(e);
			}
		});
		mnClientes.add(mntmListarClientes);
		
		mnActividades = new JMenu("Actividades");
		mnActividades.setFont(new Font("Calibri", Font.PLAIN, 12));
		menuBar.add(mnActividades);
		
		mntmCrearActividad = new JMenuItem("Crear Actividad");
		mntmCrearActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmCrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCrearActividadActionPerformed(e);
			}
		});
		mnActividades.add(mntmCrearActividad);
		
		mntmEliminarActividad = new JMenuItem("Eliminar Actividad");
		mntmEliminarActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmEliminarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionEliminarActividadActionPerformed(e);
			}
		});
		mnActividades.add(mntmEliminarActividad);
		
		mntmModificarActividad = new JMenuItem("Modificar Actividad");
		mntmModificarActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmModificarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionModificarActividadActionPerformed(e);
			}
		});
		mnActividades.add(mntmModificarActividad);
		
		mntmMostrarActividad = new JMenuItem("Mostrar Actividad");
		mntmMostrarActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmMostrarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionMostrarActividadActionPerformed(e);
			}
		});
		mnActividades.add(mntmMostrarActividad);
		
		mntmListarActividades = new JMenuItem("Listar Actividades");
		mntmListarActividades.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmListarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionListarActividadesActionPerformed(e);
			}
		});
		mnActividades.add(mntmListarActividades);
		
		mnMatricula = new JMenu("Matricula");
		mnMatricula.setFont(new Font("Calibri", Font.PLAIN, 12));
		menuBar.add(mnMatricula);
		
		mntmRealizarMatricula = new JMenuItem("Realizar Matricula");
		mntmRealizarMatricula.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRealizarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionMatricularActionPerformed(e);
			}
		});
		mnMatricula.add(mntmRealizarMatricula);
		
		mntmCancelarMatricula = new JMenuItem("Cancelar Matricula");
		mntmCancelarMatricula.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmCancelarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCancelarMatriculaActionPerformed(e);
			}
		});
		mnMatricula.add(mntmCancelarMatricula);
		
		mntmListarMatriculados = new JMenuItem("Listar Matriculados");
		mntmListarMatriculados.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmListarMatriculados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionListarMatriculadosActionPerformed(e);
			}
		});
		mnMatricula.add(mntmListarMatriculados);
		
		mntmListarMatriculas = new JMenuItem("Listar Matriculas");
		mntmListarMatriculas.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmListarMatriculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionListarMatriculasActionPerformed(e);
			}
		});
		mnMatricula.add(mntmListarMatriculas);
	}
	
	private void seleccionCrearClienteActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_CREAR_CLIENTE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionEliminarClienteActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_ELIMINAR_CLIENTE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionModificarClienteActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_MODIFICAR_CLIENTE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionMostrarClienteActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_MOSTRAR_CLIENTE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionListarClientesActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.LISTAR_CLIENTES, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionCrearActividadActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_CREAR_ACTIVIDAD, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionEliminarActividadActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_ELIMINAR_ACTIVIDAD, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionModificarActividadActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_MODIFICAR_ACTIVIDAD, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionMostrarActividadActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_MOSTRAR_ACTIVIDAD, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionListarActividadesActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.LISTAR_ACTIVIDADES, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionMatricularActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_REALIZAR_MATRICULA, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionCancelarMatriculaActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_CANCELAR_MATRICULA, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionListarMatriculadosActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_LISTAR_MATRICULADOS, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void seleccionListarMatriculasActionPerformed(ActionEvent evt) {
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.PRINCIPAL_LISTAR_MATRICULAS, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
