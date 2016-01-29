package presentacion.gui.clientes;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;

import presentacion.gui.GUIVista;
import negocio.clientes.TransferCliente;
import negocio.clientes.TransferNormal;
import negocio.clientes.TransferVip;

@SuppressWarnings("serial")
public class GUIListarClientes extends JFrame implements GUIVista {

	static private GUIListarClientes instancia;
	private JPanel contentPane;
	private JTable m_simpleTable;
	private SimpleTableModel m_simpleTableModel;
	@SuppressWarnings("rawtypes")
	Vector dummyMacData;
	
	private GUIListarClientes() {
		
	    initComponents();
	}
	   
	public static GUIListarClientes obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIListarClientes();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIListarClientes frame = new GUIListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public void initComponents() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setTitle("LISTAR CLIENTES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dummyMacData = new Vector(10, 10);
		m_simpleTableModel = new SimpleTableModel(dummyMacData);
	    m_simpleTable = new JTable(m_simpleTableModel);
	    m_simpleTable.setFont(new Font("Calibri", Font.PLAIN, 12));
	    JScrollPane scrollPane = new JScrollPane(m_simpleTable);
	    scrollPane.setBounds(10, 11, 414, 240);
		contentPane.add(scrollPane);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		dummyMacData.removeAllElements();
		if (datos!= null) {
			ArrayList<Object> array_datos = (ArrayList<Object>) datos;
			for (int i = 0; i < array_datos.size(); i++){
				if (array_datos.get(i)!= null){
					if (((TransferCliente) array_datos.get(i)).getTipo() == 1) {
						TransferVip vip = new TransferVip();
						vip = (TransferVip) array_datos.get(i);
						dummyMacData.addElement(new Data(vip.getId(), vip.getDni(), vip.getNombre(), vip.getTelefono(), vip.getTipo(),
								vip.getPuntos(), 1));
					} else if (((TransferCliente) array_datos.get(i)).getTipo() == 0) {
						TransferNormal normal = new TransferNormal();
						normal = (TransferNormal) array_datos.get(i);
						dummyMacData.addElement(new Data(normal.getId(), normal.getDni(), normal.getNombre(), normal.getTelefono(), normal.getTipo(),
								0, normal.getPiscina()));
					}							
				}
			}
		}		
	}
	
	class SimpleTableModel extends AbstractTableModel {
		
		private String[] m_colNames = { "ID", "DNI", "NOMBRE","TELF", "TIPO", "PUNTOS", "PISCINA" };
		@SuppressWarnings("rawtypes")
		private Class[] m_colTypes = { Integer.class, String.class, String.class, Integer.class,
		        String.class, Integer.class, Integer.class };
		@SuppressWarnings("rawtypes")
		private Vector m_macDataVector;

		@SuppressWarnings("rawtypes")
		public SimpleTableModel(Vector macDataVector) {
			super();
		    m_macDataVector = macDataVector;
		}

		@Override
		public int getColumnCount() {
			return m_colNames.length;
		}

		@Override
		public int getRowCount() {
			return m_macDataVector.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			Data macData = (Data) (m_macDataVector.elementAt(row));

		      switch (col) {
		      case 0:
		    	  return macData.getID();
		      case 1:
		          return macData.getDNI();
		      case 2:
		          return macData.getNombre();
		      case 3:
		          return macData.getTelefono();
		      case 4:
		          return macData.getTipo();
		      case 5: 
		    	  return macData.getPuntos();
		      case 6:
		    	  return macData.getPiscina();
		      }
		      return new String();
		}
		
		public String getColumnName(int col) {
			return m_colNames[col];
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int col) {
			return m_colTypes[col];
		}
		
		public void setValueAt(Object value, int row, int col) {
		      Data macData = (Data) (m_macDataVector.elementAt(row));

		      switch (col) {
		      case 0:
		    	  macData.setID((int) value);
		          break;
		      case 1:
		          macData.setDNI((String) value);
		          break;
		      case 2:
		          macData.setNombre((String) value);
		          break;
		      case 3:
		          macData.setTelefono((int) value);
		          break;
		      case 4:
		          macData.setTipo((int) value);
		          break;
		      case 5:
		    	  macData.setPuntos((int) value);
			      break;
		      case 6:
		    	  macData.setPiscina((int) value);
			      break;
		      }
		}
	}
	
	public class Data {
		private int id;
		private String dni;
		private String nombre;
		private int telefono;
		private int tipo;
		private int puntos;
		private int piscina;
		
		public Data(int new_id, String new_dni, String new_nombre, int new_telefono, int new_tipo, int new_puntos, int new_piscina) {
			this.id = new_id;
			this.dni = new_dni;
			this.nombre = new_nombre;
			this.telefono = new_telefono;
			this.tipo = new_tipo;
			this.puntos = new_puntos;
			this.piscina = new_piscina;
		}
		
		public int getID() {
			return this.id;
		}
		
		public String getDNI() {
			return this.dni;
		}
		
		public String getNombre() {
			return this.nombre;
		}
		
		public int getTelefono() {
			return this.telefono;
		}
		
		public int getTipo() {
			return this.tipo;
		}
		
		public int getPuntos() {
			return this.puntos;
		}
		
		public int getPiscina() {
			return this.piscina;
		}
		
		public void setID(int new_id) {
			this.id = new_id;
		}
		
		public void setDNI(String new_dni) {
			this.dni = new_dni;
		}
		
		public void setNombre(String new_nombre) {
			this.nombre = new_nombre;
		}
		
		public void setTelefono(int new_telefono) {
			this.telefono = new_telefono;
		}
		
		public void setTipo(int new_tipo) {
			this.tipo = new_tipo;
		}
		
		public void setPuntos(int new_puntos) {
			this.puntos = new_puntos;
		}
		
		public void setPiscina(int new_piscina) {
			this.piscina = new_piscina;
		}
	}
}

