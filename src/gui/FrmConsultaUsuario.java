package gui;

import javax.swing.JFrame;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.RegistrarUsuario;
import model.RegistroUsuarioModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;

public class FrmConsultaUsuario extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtFiltro;

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
