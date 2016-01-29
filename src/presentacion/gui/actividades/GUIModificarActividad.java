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
public class GUIModificarActividad extends JFrame implements GUIVista {
	
	static private GUIModificarActividad instancia;
	private JPanel contentPane;
	private JTextField textBuscarId;
	private JTextField textNombre;
	private JTextField textDiaSemana;
	private JTextField textAforo;
	private JLabel lblBuscarId;
	private JLabel lblNombre;
	private JLabel lblDiaSemana;
	private JLabel lblAforo;
	private JButton btnModificar;
	private JButton btnBuscar;

	private GUIModificarActividad() {
       initComponents();
	}
   
	static public GUIModificarActividad obtenerInstancia(){
		if(instancia == null){
			instancia = new GUIModificarActividad();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModificarActividad frame = new GUIModificarActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("MODIFICAR ACTIVIDAD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBuscarId = new JLabel("ID");
		lblBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBuscarId.setBounds(24, 30, 46, 14);
		contentPane.add(lblBuscarId);
		
		lblDiaSemana = new JLabel("Dia");
		lblDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDiaSemana.setBounds(24, 91, 46, 14);
		contentPane.add(lblDiaSemana);
		
		lblAforo = new JLabel("Aforo");
		lblAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAforo.setBounds(24, 123, 67, 14);
		contentPane.add(lblAforo);
		
		textBuscarId = new JTextField();
		textBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		textBuscarId.setBounds(56, 27, 122, 20);
		contentPane.add(textBuscarId);
		textBuscarId.setColumns(10);
		
		textDiaSemana = new JTextField();
		textDiaSemana.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDiaSemana.setBounds(87, 88, 188, 20);
		contentPane.add(textDiaSemana);
		textDiaSemana.setColumns(10);
		
		textAforo = new JTextField();
		textAforo.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAforo.setBounds(87, 120, 188, 20);
		contentPane.add(textAforo);
		textAforo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionBuscarActionPerformed(e);
			}
		});
		btnBuscar.setBounds(309, 26, 89, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionModificarActionPerformed(e);
			}
		});
		btnModificar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnModificar.setBounds(295, 210, 103, 23);
		contentPane.add(btnModificar);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(24, 60, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setBounds(88, 57, 187, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
	}
	
	private void seleccionBuscarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferActividad();
			((TransferActividad) transfer).setId(Integer.parseInt(textBuscarId.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.BUSCAR_ACTIVIDAD, transfer);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Modificar Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void seleccionModificarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferActividad();
			((TransferActividad) transfer).setId(Integer.parseInt(textBuscarId.getText()));
			((TransferActividad) transfer).setNombre(textNombre.getText());
			((TransferActividad) transfer).setDiaSemana(textDiaSemana.getText());
			((TransferActividad) transfer).setAforo(Integer.parseInt(textAforo.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.MODIFICAR_ACTIVIDAD, transfer);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Modificar Actividad", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		if (id_evento_vista == EventoVista.BUSCAR_ACTIVIDAD_EXITO) {
        	TransferActividad transfer = (TransferActividad) datos;
			textNombre.setText(transfer.getNombre());
			textDiaSemana.setText(transfer.getDiaSemana());
			textAforo.setText(Integer.toString(transfer.getAforo()));
        } else if (id_evento_vista == EventoVista.BUSCAR_ACTIVIDAD_FALLO) {
        	JOptionPane.showMessageDialog(null, "ERROR \nNo se ha encontrado la actividad que se desea modificar", "Modificar Actividad", JOptionPane.ERROR_MESSAGE);
        } else if (id_evento_vista == EventoVista.MODIFICAR_ACTIVIDAD_EXITO) {
			JOptionPane.showMessageDialog(null, "La actividad se ha modificado correctamente", "Modificar Actividad", JOptionPane.OK_OPTION);
			this.setVisible(false);
			textBuscarId.setText("");
			textNombre.setText("");
	        textDiaSemana.setText("");
	        textAforo.setText("");
        } else if (id_evento_vista == EventoVista.MODIFICAR_ACTIVIDAD_FALLO) {
        	JOptionPane.showMessageDialog(null, "ERROR \nLa actividad no se ha modificado correctamente", "Modificar Actividad", JOptionPane.ERROR_MESSAGE);
        }
	}
}
