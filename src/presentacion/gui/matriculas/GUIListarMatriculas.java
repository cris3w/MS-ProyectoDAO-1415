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

import negocio.clientes.TransferCliente;
import presentacion.controlador.ControladorAplicacion;
import presentacion.controlador.comandos.factoria.EventoNegocio;
import presentacion.gui.GUIVista;

@SuppressWarnings("serial")
public class GUIListarMatriculas extends JFrame implements GUIVista {

	private static GUIListarMatriculas instancia;
	private JPanel contentPane;
	private JTextField textIdCliente;
	private JLabel lblIdCliente;
	private JButton btnBuscar;

	private GUIListarMatriculas() {
	    initComponents();
	}
	   
	public static GUIListarMatriculas obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIListarMatriculas();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIListarMatriculas frame = new GUIListarMatriculas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponents() {
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("LISTAR MATRICULAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIdCliente = new JTextField();
		textIdCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		textIdCliente.setBounds(164, 64, 86, 20);
		contentPane.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		lblIdCliente = new JLabel("ID CLIENTE:");
		lblIdCliente.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIdCliente.setBounds(80, 67, 76, 14);
		contentPane.add(lblIdCliente);
		
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
		TransferCliente cliente = new TransferCliente();
		cliente.setId(Integer.parseInt(textIdCliente.getText()));
		try {
			ControladorAplicacion.obtenerInstancia().accion(EventoNegocio.LISTAR_MATRICULAS, cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage(), "Actividades Por Cliente", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(int id_evento_vista, Object datos) {
	
	}
}
