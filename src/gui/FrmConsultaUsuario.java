package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.RegistrarUsuario;
import model.RegistroUsuarioModel;

public class FrmConsultaUsuario extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtFiltro;

	
	int hoveredRow = -1, hoveredColumn = -1;

	public FrmConsultaUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Usuario");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 970, 304);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido", "DNI", "Login", "Password", "Correo", "FechaNacimiento", "Direcci\u00F3n"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(79);
		table.getColumnModel().getColumn(6).setPreferredWidth(94);
		table.getColumnModel().getColumn(7).setPreferredWidth(99);
		scrollPane.setViewportView(table);
		
		//No se pueda editar

		 table.setDefaultEditor(Object.class, null);
		
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
		//tamano de la fila	

			table.getColumnModel().getColumn(0).setPreferredWidth(15);

			table.getColumnModel().getColumn(1).setPreferredWidth(120);

			table.getColumnModel().getColumn(2).setPreferredWidth(120);

			table.getColumnModel().getColumn(3).setPreferredWidth(50);

			table.getColumnModel().getColumn(4).setPreferredWidth(50);

			table.getColumnModel().getColumn(5).setPreferredWidth(90);

			table.getColumnModel().getColumn(6).setPreferredWidth(120);
			
			table.getColumnModel().getColumn(7).setPreferredWidth(90);
			
			table.getColumnModel().getColumn(8).setPreferredWidth(90);

			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			
			//alineación

			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();

			rightRenderer.setHorizontalAlignment(JLabel.CENTER);

			table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);

			table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
			
			table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
			
			table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
			
			table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
			
			//selecciona una sola fila

			table.setRowSelectionAllowed(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			//desabilita mover las columnas

			table.getTableHeader().setReorderingAllowed(false);
			
			//color de la fila seleccionada

			table.setSelectionBackground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 115, 91, 35);
		getContentPane().add(lblNewLabel);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(144, 117, 341, 35);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JLabel lblConsultaDeUsario = new JLabel("CONSULTA DE USARIO POR NOMBRE");
		lblConsultaDeUsario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeUsario.setBounds(298, 34, 354, 35);
		getContentPane().add(lblConsultaDeUsario);


	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			keyReleasedTxtFiltroJTextField(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtFiltroJTextField(KeyEvent e) {
	String filtro = txtFiltro.getText();
		
		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		RegistroUsuarioModel m = new RegistroUsuarioModel();
		List<RegistrarUsuario> lista = m.listaUsuarioPorNomre(filtro);
		
		for (RegistrarUsuario x : lista){
			Object[] fila = {x.getIdUsuario(), x.getNombreUsuario(), x.getApellidoUsuario(),x.getDNI(),
					x.getLogin(),x.getPassword(),x.getCorreo(),x.getFechaNacimientoUsuario(),x.getDirección()};
			dtm.addRow(fila);
		}	
	}
}
