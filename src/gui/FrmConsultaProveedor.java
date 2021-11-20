package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;

public class FrmConsultaProveedor extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;

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
				"ID", "Nombres", "Apellidos", "dni", "Direccion", "Telefono", "Correo", "Pais", "fechaRegistro"
			}
		));
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
