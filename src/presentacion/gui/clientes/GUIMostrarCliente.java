package presentacion.gui.clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
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
public class GUIMostrarCliente extends JFrame implements GUIVista {
	
	static private GUIMostrarCliente instancia;
	private JPanel contentPane;
	private JTextField textBuscarId;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textTipo;
	private JTextField textPuntos;
	private JTextField textPiscina;
	private JLabel lblBuscarId;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblTipo;
	private JLabel lblPuntos;
	private JLabel lblPiscina;
	private JButton btnBuscar;
	
	private GUIMostrarCliente() {
		initComponents();
	}
	   
	static public GUIMostrarCliente obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIMostrarCliente();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMostrarCliente frame = new GUIMostrarCliente();
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
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDni.setBounds(48, 76, 46, 14);
		contentPane.add(lblDni);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDni.setEditable(false);
		textDni.setBounds(87, 74, 103, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		lblBuscarId = new JLabel("ID");
		lblBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBuscarId.setBounds(48, 33, 46, 14);
		contentPane.add(lblBuscarId);
		
		textBuscarId = new JTextField();
		textBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		textBuscarId.setBounds(87, 31, 103, 20);
		contentPane.add(textBuscarId);
		textBuscarId.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(48, 121, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setEditable(false);
		textNombre.setBounds(112, 119, 204, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTelefono.setBounds(216, 76, 69, 14);
		contentPane.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		textTelefono.setEditable(false);
		textTelefono.setBounds(280, 72, 103, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionBuscarActionPerformed(e);
			}
		});
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.setBounds(227, 30, 89, 23);
		contentPane.add(btnBuscar);
		
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPuntos.setBounds(48, 198, 46, 14);
		contentPane.add(lblPuntos);
		
		textPuntos = new JTextField();
		textPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPuntos.setEditable(false);
		textPuntos.setBounds(112, 194, 61, 20);
		contentPane.add(textPuntos);
		textPuntos.setColumns(10);
		
		lblPiscina = new JLabel("Piscina");
		lblPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPiscina.setBounds(245, 198, 69, 14);
		contentPane.add(lblPiscina);
		
		textPiscina = new JTextField();
		textPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPiscina.setEditable(false);
		textPiscina.setBounds(322, 194, 61, 20);
		contentPane.add(textPiscina);
		textPiscina.setColumns(10);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTipo.setBounds(48, 167, 46, 14);
		contentPane.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setFont(new Font("Calibri", Font.PLAIN, 12));
		textTipo.setEditable(false);
		textTipo.setBounds(111, 163, 103, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
	}
	
	private void seleccionBuscarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferCliente();
			((TransferCliente)transfer).setId(Integer.parseInt(textBuscarId.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.MOSTRAR_CLIENTE, transfer);
		} catch (Exception e) {
			textDni.setText("");
			textNombre.setText("");
			textTelefono.setText("");
			textTipo.setText("");
			textPuntos.setText("");
			textPiscina.setText("");
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Mostrar Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actualizar(int id_evento_vista, Object datos) {        
		if(id_evento_vista == EventoVista.MOSTRAR_CLIENTE_EXITO) {
			TransferCliente cliente = (TransferCliente)datos;
			if (cliente.getTipo() == 1) {
				TransferVip vip = (TransferVip)datos;
				textDni.setText(vip.getDni());
				textNombre.setText(vip.getNombre());
				textTelefono.setText(Integer.toString(vip.getTelefono()));
				textTipo.setText("vip");
				textPuntos.setText(Integer.toString(vip.getPuntos()));
			} else if (cliente.getTipo() == 0) {
				TransferNormal normal = (TransferNormal)datos;
				textDni.setText(normal.getDni());
				textNombre.setText(normal.getNombre());
				textTelefono.setText(Integer.toString(normal.getTelefono()));
				textTipo.setText("normal");
				if (normal.getPiscina() == 1) textPiscina.setText("si");
				else if (normal.getPiscina() == 0) textPiscina.setText("no");
			}
		} else if(id_evento_vista == EventoVista.MOSTRAR_CLIENTE_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR \nNo se ha encontrado el cliente que se desea mostrar", "Mostrar Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}

}
