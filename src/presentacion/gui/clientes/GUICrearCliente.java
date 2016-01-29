package presentacion.gui.clientes;

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
import negocio.clientes.TransferCliente;
import negocio.clientes.TransferNormal;
import negocio.clientes.TransferVip;

@SuppressWarnings("serial")
public class GUICrearCliente extends JFrame implements GUIVista {

	private JPanel contentPane;
	static private GUICrearCliente instancia;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textPuntos;
	private JTextField textNormal;
	private JTextField textVip;
	private JTextField textPiscina;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblPuntos;
	private JLabel lblPiscina;
	private JLabel lblVip;
	private JLabel lblNormal;
	private JButton btnCrear;
	
	private GUICrearCliente() {
	    initComponents();
	}
	   
	public static GUICrearCliente obtenerInstancia(){
		if(instancia == null){
				instancia = new GUICrearCliente();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICrearCliente frame = new GUICrearCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("CREAR CLIENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDni.setBounds(54, 38, 72, 14);
		contentPane.add(lblDni);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDni.setBounds(145, 34, 200, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(54, 68, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setBounds(145, 65, 200, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTelefono.setBounds(54, 100, 72, 14);
		contentPane.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		textTelefono.setBounds(145, 96, 200, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionCrearActionPerformed(e);
			}
		});
		btnCrear.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnCrear.setBounds(305, 216, 89, 23);
		contentPane.add(btnCrear);
		
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPuntos.setBounds(212, 178, 46, 14);
		contentPane.add(lblPuntos);
		
		textPuntos = new JTextField();
		textPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPuntos.setBounds(268, 175, 77, 20);
		contentPane.add(textPuntos);
		textPuntos.setColumns(10);
		
		lblVip = new JLabel("Vip");
		lblVip.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblVip.setBounds(54, 178, 46, 14);
		contentPane.add(lblVip);
		
		textVip = new JTextField();
		textVip.setFont(new Font("Calibri", Font.PLAIN, 12));
		textVip.setBounds(110, 175, 46, 20);
		contentPane.add(textVip);
		textVip.setColumns(10);
		
		lblNormal = new JLabel("Normal");
		lblNormal.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNormal.setBounds(54, 139, 46, 14);
		contentPane.add(lblNormal);
		
		textNormal = new JTextField();
		textNormal.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNormal.setBounds(110, 135, 46, 20);
		contentPane.add(textNormal);
		textNormal.setColumns(10);
		
		lblPiscina = new JLabel("Piscina");
		lblPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPiscina.setBounds(212, 138, 62, 14);
		contentPane.add(lblPiscina);
		
		textPiscina = new JTextField();
		textPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPiscina.setBounds(268, 135, 77, 20);
		contentPane.add(textPiscina);
		textPiscina.setColumns(10);
	}
	
	private void seleccionCrearActionPerformed(ActionEvent evt) {

		TransferCliente cliente = null;
		String dni = textDni.getText();
		String nombre = textNombre.getText();
		int telefono = Integer.parseInt(textTelefono.getText());
		String tipoNormal = textNormal.getText();
		String tipoVip = textVip.getText();
		
		if (tipoVip.equals("x")) {
			int puntos = Integer.parseInt(textPuntos.getText());
			TransferVip vip = new TransferVip(0, dni, nombre, telefono, 1, 1, puntos);
			cliente = vip;
        } else if (tipoNormal.equals("x")) {
        	int piscina = Integer.parseInt(textPiscina.getText());
        	TransferNormal normal = new TransferNormal(0, dni, nombre, telefono, 1, 0, piscina);
        	cliente = normal;
        }
		
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.CREAR_CLIENTE, cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n " + e.getMessage(), "Crear Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(int id_evento_vista, Object datos) {
		if (id_evento_vista == EventoVista.CREAR_CLIENTE_EXITO) {
			JOptionPane.showMessageDialog(null, "El cliente se ha creado con éxito", "Crear Cliente", JOptionPane.OK_OPTION);
			this.setVisible(false);
			textDni.setText("");
	        textNombre.setText("");
	        textTelefono.setText("");
	        textNormal.setText("");
	        textPiscina.setText("");
	        textVip.setText("");
	        textPuntos.setText("");
		} else if (id_evento_vista == EventoVista.CREAR_CLIENTE_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR No se ha podido crear el cliente", "Crear Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}
}
