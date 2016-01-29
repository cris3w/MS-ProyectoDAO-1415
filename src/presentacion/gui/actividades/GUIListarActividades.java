package presentacion.gui.actividades;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import negocio.actividades.TransferActividad;
import presentacion.gui.GUIVista;


@SuppressWarnings("serial")
public class GUIListarActividades extends JFrame implements GUIVista {
	
	static private GUIListarActividades instancia;
	private JPanel contentPane;
	private JTable m_simpleTable;
	private SimpleTableModel m_simpleTableModel;
	@SuppressWarnings("rawtypes")
	Vector dummyMacData;
	
	private GUIListarActividades() {
	    initComponents();
	}
	   
	public static GUIListarActividades obtenerInstancia(){
		if(instancia == null){
				instancia = new GUIListarActividades();
		}
		return instancia;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIListarActividades frame = new GUIListarActividades();
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
		setTitle("LISTAR ACTIVIDADES");
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
					TransferActividad act = (TransferActividad) array_datos.get(i);
					dummyMacData.addElement(new TransferActividad(act.getId(), act.getNombre(), act.getDiaSemana(), 
							act.getAforo(), act.getActivo(), act.getMatriculados()));
				}
			}
		}		
	}
	
	class SimpleTableModel extends AbstractTableModel {
		
		private String[] m_colNames = { "ID", "NOMBRE", "DÍA", "AFORO", "MATRICULADOS" };
		@SuppressWarnings("rawtypes")
		private Class[] m_colTypes = { Integer.class, String.class, String.class, Integer.class, 
				Integer.class };
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
			TransferActividad macData = (TransferActividad) (m_macDataVector.elementAt(row));

		      switch (col) {
		      case 0:
		    	  return macData.getId();
		      case 1:
		          return macData.getNombre();
		      case 2:
		          return macData.getDiaSemana();
		      case 3:
		          return macData.getAforo();
		      case 4:
		          return macData.getMatriculados();
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
		      TransferActividad macData = (TransferActividad) (m_macDataVector.elementAt(row));

		      switch (col) {
		      case 0:
		    	  macData.setId((int) value);
		          break;
		      case 1:
		          macData.setNombre((String) value);
		          break;
		      case 2:
		          macData.setDiaSemana((String) value);
		          break;
		      case 3:
		          macData.setAforo((int) value);
		          break;
		      case 4:
		          macData.setMatriculados((int) value);
		          break;
		      }
		}
	}
}
