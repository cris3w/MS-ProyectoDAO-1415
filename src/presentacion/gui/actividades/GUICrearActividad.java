package presentacion.gui.actividades;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.controlador.dispatcher.EventoVista;
import presentacion.gui.GUIVista;
import negocio.actividades.TransferActividad;

@SuppressWarnings("serial")
public class GUICrearActividad extends JFrame implements GUIVista {

	private JPanel contentPane;
	static private GUICrearActividad instancia;
	private JTextField textNombre;
	private JTextField textDiaSemana;
	private JTextField textAforo;
	private JLabel lblDiaSemana;
	private JLabel lblNombre;
	private JLabel lblAforo;
	private JButton btnCrear;
	
	private GUICrearActividad() {
	    initComponents();
	}
	   
	public static GUICrearActividad obtenerInstancia(){
		if(instancia == null){
				instancia = new GUICrearActividad();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICrearActividad frame = new GUICrearActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("CREAR ACTIVIDAD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(54, 38, 81, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setBounds(145, 34, 200, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblDiaSemana = new JLabel("Dia");
		lblDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDiaSemana.setBounds(54, 68, 46, 14);
		contentPane.add(lblDiaSemana);
		
		textDiaSemana = new JTextField();
		textDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDiaSemana.setBounds(145, 65, 200, 20);
		contentPane.add(textDiaSemana);
		textDiaSemana.setColumns(10);
		
		lblAforo = new JLabel("Aforo");
		lblAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAforo.setBounds(54, 100, 72, 14);
		contentPane.add(lblAforo);
		
		textAforo = new JTextField();
		textAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAforo.setBounds(145, 96, 200, 20);
		contentPane.add(textAforo);
		textAforo.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCrearActionPerformed(e);
			}
		});
		btnCrear.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnCrear.setBounds(305, 216, 89, 23);
		contentPane.add(btnCrear);
	}
	
	private void seleccionCrearActionPerformed(ActionEvent evt) {
		String nombre = textNombre.getText();
		String diaSemana = textDiaSemana.getText();
		int aforo = Integer.parseInt(textAforo.getText());
		TransferActividad actividad = new TransferActividad(0, nombre, diaSemana, aforo, 1, 0);
		
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.CREAR_ACTIVIDAD, actividad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n " + e.getMessage(), "Crear Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(int id_evento_vista, Object datos) {
		if (id_evento_vista == EventoVista.CREAR_ACTIVIDAD_EXITO) {
			JOptionPane.showMessageDialog(null, "La actividad se ha creado con éxito", "Crear Actividad", JOptionPane.OK_OPTION);
			this.setVisible(false);
			textDiaSemana.setText("");
	        textNombre.setText("");
	        textAforo.setText("");
		} else if (id_evento_vista == EventoVista.CREAR_ACTIVIDAD_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR No se ha podido crear el cliente", "Crear Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}
}
