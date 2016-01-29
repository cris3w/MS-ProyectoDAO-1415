package presentacion.gui.clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.controlador.dispatcher.EventoVista;
import presentacion.gui.GUIVista;
import negocio.clientes.TransferCliente;
import negocio.clientes.TransferNormal;
import negocio.clientes.TransferVip;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class GUIModificarCliente extends JFrame implements GUIVista {

	static private GUIModificarCliente instancia;
	private JPanel contentPane;
	private JTextField textBuscarId;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textVip;
	private JTextField textNormal;
	private JTextField textPuntos;
	private JTextField textPiscina;
	private JLabel lblBuscarId;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblVip;
	private JLabel lblNormal;
	private JLabel lblPuntos;
	private JLabel lblPiscina;
	private JButton btnModificar;
	private JButton btnBuscar;

	private GUIModificarCliente() {
       initComponents();
	}
   
	static public GUIModificarCliente obtenerInstancia(){
		if(instancia == null){
			instancia = new GUIModificarCliente();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModificarCliente frame = new GUIModificarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("MODIFICAR CLIENTE");
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
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombre.setBounds(24, 91, 46, 14);
		contentPane.add(lblNombre);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTelefono.setBounds(24, 123, 67, 14);
		contentPane.add(lblTelefono);
		
		textBuscarId = new JTextField();
		textBuscarId.setFont(new Font("Calibri", Font.PLAIN, 12));
		textBuscarId.setBounds(56, 27, 122, 20);
		contentPane.add(textBuscarId);
		textBuscarId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNombre.setBounds(87, 88, 188, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Calibri", Font.PLAIN, 12));
		textTelefono.setBounds(87, 120, 188, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
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
		
		lblNormal = new JLabel("Normal");
		lblNormal.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNormal.setBounds(36, 154, 46, 14);
		contentPane.add(lblNormal);
		
		textNormal = new JTextField();
		textNormal.setFont(new Font("Calibri", Font.PLAIN, 12));
		textNormal.setBounds(87, 151, 67, 20);
		contentPane.add(textNormal);
		textNormal.setColumns(10);
		
		lblPiscina = new JLabel("Piscina");
		lblPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPiscina.setBounds(186, 154, 46, 14);
		contentPane.add(lblPiscina);
		
		textPiscina = new JTextField();
		textPiscina.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPiscina.setBounds(242, 151, 67, 20);
		contentPane.add(textPiscina);
		textPiscina.setColumns(10);
		
		lblVip = new JLabel("Vip");
		lblVip.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblVip.setBounds(36, 182, 46, 14);
		contentPane.add(lblVip);
		
		textVip = new JTextField();
		textVip.setFont(new Font("Calibri", Font.PLAIN, 12));
		textVip.setBounds(87, 179, 67, 20);
		contentPane.add(textVip);
		textVip.setColumns(10);
		
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPuntos.setBounds(186, 182, 46, 14);
		contentPane.add(lblPuntos);
		
		textPuntos = new JTextField();
		textPuntos.setFont(new Font("Calibri", Font.PLAIN, 12));
		textPuntos.setBounds(242, 179, 67, 20);
		contentPane.add(textPuntos);
		textPuntos.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDni.setBounds(24, 60, 46, 14);
		contentPane.add(lblDni);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Calibri", Font.PLAIN, 12));
		textDni.setBounds(88, 57, 187, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
	}
	
	private void seleccionBuscarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferCliente();
			((TransferCliente)transfer).setId(Integer.parseInt(textBuscarId.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.BUSCAR_CLIENTE, transfer);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Modificar Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void seleccionModificarActionPerformed(ActionEvent evt) {
		try {
			Object transfer = new TransferCliente();
			String tipoNormal = textNormal.getText();
			String tipoVip = textVip.getText();
			if (tipoVip.equals("x")) {
				transfer = new TransferVip();
				((TransferVip) transfer).setPuntos(Integer.parseInt(textPuntos.getText()));
				((TransferVip) transfer).setTipo(1);
			} else if (tipoNormal.equals("x")) {
				transfer = new TransferNormal();
				((TransferNormal) transfer).setPiscina(Integer.parseInt(textPiscina.getText()));
				((TransferNormal) transfer).setTipo(0);
			}
			((TransferCliente) transfer).setId(Integer.parseInt(textBuscarId.getText()));
			((TransferCliente) transfer).setDni(textDni.getText());
			((TransferCliente) transfer).setNombre(textNombre.getText());
			((TransferCliente) transfer).setTelefono(Integer.parseInt(textTelefono.getText()));
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.MODIFICAR_CLIENTE, transfer);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Modificar Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
        if (id_evento_vista == EventoVista.BUSCAR_CLIENTE_EXITO) {
        	TransferCliente transfer = (TransferCliente) datos;
        	if (transfer.getTipo() == 1) {
        		TransferVip cliente = (TransferVip) datos;
        		textVip.setText("x");
        		textPuntos.setText(Integer.toString(cliente.getPuntos()));
        		transfer = cliente;
        	} else if (transfer.getTipo() == 0) {
        		TransferNormal cliente = (TransferNormal) datos;
        		textNormal.setText("x");
        		textPiscina.setText(Integer.toString(cliente.getPiscina()));
        		transfer = cliente;
        	}
			textDni.setText(transfer.getDni());
			textNombre.setText(transfer.getNombre());
			textTelefono.setText(Integer.toString(transfer.getTelefono()));
        } else if (id_evento_vista == EventoVista.BUSCAR_CLIENTE_FALLO) {
        	JOptionPane.showMessageDialog(null, "ERROR \nNo se ha encontrado el cliente que se desea modificar", "Modificar Cliente", JOptionPane.ERROR_MESSAGE);
        } else if (id_evento_vista == EventoVista.MODIFICAR_CLIENTE_EXITO) {
			JOptionPane.showMessageDialog(null, "El cliente se ha modificado correctamente", "Modificar Cliente", JOptionPane.OK_OPTION);
			this.setVisible(false);
			textBuscarId.setText("");
			textDni.setText("");
	        textNombre.setText("");
	        textTelefono.setText("");
	        textVip.setText("");
	        textNormal.setText("");
	        textPuntos.setText("");
	        textPiscina.setText("");
        } else if (id_evento_vista == EventoVista.MODIFICAR_CLIENTE_FALLO) {
        	JOptionPane.showMessageDialog(null, "ERROR \nEl cliente no se ha modificado correctamente", "Modificar Cliente", JOptionPane.ERROR_MESSAGE);
        }
	}
}
