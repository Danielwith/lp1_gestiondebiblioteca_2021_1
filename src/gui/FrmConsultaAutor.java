package gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Autor;
import model.AutorModel;

public class FrmConsultaAutor extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;

	public FrmConsultaAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Autor");
		setBounds(100, 100, 882, 550);
		getContentPane().setLayout(null);
		
		JLabel lblConsultaDeAutor = new JLabel("CONSULTA DE AUTOR POR NOMBRE");
		lblConsultaDeAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAutor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblConsultaDeAutor.setBounds(137, 45, 572, 36);
		getContentPane().add(lblConsultaDeAutor);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(109, 124, 67, 20);
		getContentPane().add(lblNombre);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(186, 123, 330, 27);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 201, 730, 270);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Fecha Nacimiento", "Fecha Registro", "Nacionalidad", "Grado"
			}
		));
		scrollPane.setViewportView(table);


	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			do_textNombre_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void do_textNombre_keyReleased(KeyEvent e) {
		
		String filtro = txtFiltro.getText();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		AutorModel a = new AutorModel();
		List<Autor> lista = a.listaAutorPorNombre(filtro);
		
		for(Autor x : lista) {
			Object[] fila = {x.getGrado(), x.getNombres(), x.getApellidos(), x.getFechaNacimiento(), x.getFechaRegistro(),
					x.getNacionalidad(), x.getGrado()};
			dtm.addRow(fila);
		}
	}
}
