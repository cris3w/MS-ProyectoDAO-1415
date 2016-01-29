package presentacion.gui.actividades;

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
import presentacion.controlador.dispatcher.EventoVista;
import presentacion.gui.GUIVista;

@SuppressWarnings("serial")
public class GUIMostrarActividad extends JFrame implements GUIVista {

	static private GUIMostrarActividad instancia;
	private JPanel contentPane;
	private JTextField textBuscarId;
	private JTextField textNombre;
	private JTextField textDiaSemana;
	private JTextField textAforo;
	private JLabel lblBuscarId;
	private JLabel lblNombre;
	private JLabel lblDiaSemana;
	private JLabel lblAforo;
	private JButton btnBuscar;
	
	private GUIMostrarActividad() {
		initComponents();
	}
	   
	static public GUIMostrarActividad obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIMostrarActividad();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMostrarActividad frame = new GUIMostrarActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(43, 76, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setEditable(false);
		textNombre.setBounds(99, 73, 204, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblBuscarId = new JLabel("ID");
		lblBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBuscarId.setBounds(48, 33, 46, 14);
		contentPane.add(lblBuscarId);
		
		textBuscarId = new JTextField();
		textBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		textBuscarId.setBounds(81, 31, 121, 20);
		contentPane.add(textBuscarId);
		textBuscarId.setColumns(10);
		
		lblDiaSemana = new JLabel("Dia");
		lblDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDiaSemana.setBounds(43, 117, 46, 14);
		contentPane.add(lblDiaSemana);
		
		textDiaSemana = new JTextField();
		textDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDiaSemana.setEditable(false);
		textDiaSemana.setBounds(99, 114, 144, 20);
		contentPane.add(textDiaSemana);
		textNombre.setColumns(10);
		
		lblAforo = new JLabel("Aforo");
		lblAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAforo.setBounds(43, 158, 69, 14);
		contentPane.add(lblAforo);
		
		textAforo = new JTextField();
		textAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAforo.setEditable(false);
		textAforo.setBounds(99, 155, 103, 20);
		contentPane.add(textAforo);
		textAforo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionBuscarActionPerformed(e);
			}
		});
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.setBounds(268, 29, 89, 23);
		contentPane.add(btnBuscar);
	}

	private void seleccionBuscarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferActividad();
			((TransferActividad) transfer).setId(Integer.parseInt(textBuscarId.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.MOSTRAR_ACTIVIDAD, transfer);
		} catch (Exception e) {
			textNombre.setText("");
			textDiaSemana.setText("");
			textAforo.setText("");
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Mostrar Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		if(id_evento_vista == EventoVista.MOSTRAR_ACTIVIDAD_EXITO) {
			TransferActividad actividad = (TransferActividad) datos;
			textNombre.setText(actividad.getNombre());
			textDiaSemana.setText(actividad.getDiaSemana());
			textAforo.setText(Integer.toString(actividad.getAforo()));
		} else if(id_evento_vista == EventoVista.MOSTRAR_ACTIVIDAD_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR \nNo se ha encontrado la actividad que se desea mostrar", "Mostrar Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}
}
