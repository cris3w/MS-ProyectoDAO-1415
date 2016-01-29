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

import negocio.actividades.TransferActividad;
import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.gui.GUIVista;

@SuppressWarnings("serial")
public class GUIListarMatriculados extends JFrame implements GUIVista {
	
	private static GUIListarMatriculados instancia;
	private JPanel contentPane;
	private JTextField textIdActividad;
	private JLabel lblIdActividad;
	private JButton btnBuscar;

	private GUIListarMatriculados() {
	    initComponents();
	}
	   
	public static GUIListarMatriculados obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIListarMatriculados();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIListarMatriculados frame = new GUIListarMatriculados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("LISTAR MATRICULADOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIdActividad = new JTextField();
		textIdActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		textIdActividad.setBounds(164, 64, 86, 20);
		contentPane.add(textIdActividad);
		textIdActividad.setColumns(10);
		
		lblIdActividad = new JLabel("ID ACTIVIDAD:");
		lblIdActividad.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIdActividad.setBounds(45, 67, 98, 14);
		contentPane.add(lblIdActividad);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionBuscarActionPerformed(e);
			}
		});
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.setBounds(267, 63, 89, 23);
		contentPane.add(btnBuscar);
	}
	
	private void seleccionBuscarActionPerformed(ActionEvent evt) {
		TransferActividad actividad = new TransferActividad();
		actividad.setId(Integer.parseInt(textIdActividad.getText()));
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.LISTAR_MATRICULADOS, actividad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Clientes Por Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(int id_evento_vista, Object datos) {
	
	}
}
