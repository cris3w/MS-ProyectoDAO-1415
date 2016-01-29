package presentacion.gui.matriculas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.matriculas.TransferMatricula;
import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.controlador.dispatcher.EventoVista;
import presentacion.gui.GUIVista;

@SuppressWarnings("serial")
public class GUICancelarMatricula extends JFrame implements GUIVista {

	private JPanel contentPane;
	static private GUICancelarMatricula instancia;
	private JTextField textIdCliente;
	private JTextField textIdActividad;
	private JLabel lblIdCliente;
	private JLabel lblIdActividad;
	private JButton btnEliminar;
	
	private GUICancelarMatricula() {
	    initComponents();
	}
	   
	public static GUICancelarMatricula obtenerInstancia(){
		if(instancia == null){
				instancia = new GUICancelarMatricula();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICancelarMatricula frame = new GUICancelarMatricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("CANCELAR MATRICULA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdCliente = new JLabel("ID CLIENTE");
		lblIdCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIdCliente.setBounds(54, 38, 81, 14);
		contentPane.add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		textIdCliente.setBounds(163, 35, 144, 20);
		contentPane.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		lblIdActividad = new JLabel("ID ACTIVIDAD");
		lblIdActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIdActividad.setBounds(54, 68, 81, 14);
		contentPane.add(lblIdActividad);
		
		textIdActividad = new JTextField();
		textIdActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		textIdActividad.setBounds(163, 65, 144, 20);
		contentPane.add(textIdActividad);
		textIdActividad.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionEliminarActionPerformed(e);
			}
		});
		btnEliminar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnEliminar.setBounds(305, 216, 89, 23);
		contentPane.add(btnEliminar);
	}
	
	private void seleccionEliminarActionPerformed(ActionEvent evt) {
		int idCliente = Integer.parseInt(textIdCliente.getText());
		int idActividad = Integer.parseInt(textIdActividad.getText());
		TransferMatricula matricula = new TransferMatricula(idCliente, idActividad);
			
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.CANCELAR_MATRICULA, matricula);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Cancelar Matricula", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		if (id_evento_vista == EventoVista.CANCELAR_MATRICULA_EXITO) {
			JOptionPane.showMessageDialog(null, "La matricula se ha cancelado con exito", "Cancelar Matricula", JOptionPane.OK_OPTION);
			this.setVisible(false);
			textIdCliente.setText("");
			textIdActividad.setText("");
		} else if (id_evento_vista == EventoVista.CANCELAR_MATRICULA_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR No se ha podido cancelar la matricula", "Cancelar Matricula", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
