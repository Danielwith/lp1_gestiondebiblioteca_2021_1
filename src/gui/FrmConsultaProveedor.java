package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.awt.event.KeyEvent;

public class FrmConsultaProveedor extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;
	int hoveredRow = -1, hoveredColumn = -1;

	public FrmConsultaProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Proveedor");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTA PROVEEDOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(332, 31, 334, 53);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 93, 68, 17);
		getContentPane().add(lblNewLabel_1);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(129, 93, 767, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 136, 930, 373);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Dirección", "Telefono", "Correo", "País", "Fecha Registro"
			}
		));
		
		//desabilita mover las columnas

		table.getTableHeader().setReorderingAllowed(false);
		
		//color de la fila seleccionada

		table.setSelectionBackground(Color.BLUE);
		
		//tamano de la fila	

				table.getColumnModel().getColumn(0).setPreferredWidth(15);

				table.getColumnModel().getColumn(1).setPreferredWidth(100);

				table.getColumnModel().getColumn(2).setPreferredWidth(100);

				table.getColumnModel().getColumn(3).setPreferredWidth(80);

				table.getColumnModel().getColumn(4).setPreferredWidth(120);

				table.getColumnModel().getColumn(5).setPreferredWidth(90);

				table.getColumnModel().getColumn(6).setPreferredWidth(120);
				
				table.getColumnModel().getColumn(7).setPreferredWidth(75);
				
				table.getColumnModel().getColumn(8).setPreferredWidth(100);

				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				/**/
				table.addMouseMotionListener(new MouseMotionListener() {

				    @Override

				    public void mouseMoved(MouseEvent e) {

				      Point p = e.getPoint();

				      hoveredRow = table.rowAtPoint(p);

				      hoveredColumn = table.columnAtPoint(p);

				      table.setRowSelectionInterval(hoveredRow, hoveredRow);

				      table.repaint();   

				    }

				    @Override

				    public void mouseDragged(MouseEvent e) {

				      hoveredRow = hoveredColumn = -1;

				      table.repaint();

				    }

				  });
				
				 //No se pueda editar

				  table.setDefaultEditor(Object.class, null);
		
		scrollPane.setViewportView(table);


	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			keyReleasedTextFieldJTextField(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTextFieldJTextField(KeyEvent e) {
		String filtro=txtFiltro.getText();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		ProveedorModel p= new ProveedorModel();
		List<Proveedor> lista= p.listaProveedorPorNombre(filtro);
		
		for(Proveedor x: lista) {
			Object[] fila= {x.getIdproveedor(),x.getNombres(),x.getApellidos(),x.getDni(),x.getDireccion(),x.getTelefono(),x.getCorreo(),x.getPais(),x.getFechaRegistro()};
			dtm.addRow(fila);
		}
	}
}
