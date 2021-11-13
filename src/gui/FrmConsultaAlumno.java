package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.RegistroAlumno;
import model.AlumnoModel;

import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;

public class FrmConsultaAlumno extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;

	public FrmConsultaAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Alumno");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblConsultaDeAlumno = new JLabel("Consulta de alumno por nombre");
		lblConsultaDeAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAlumno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeAlumno.setBounds(117, 21, 751, 34);
		getContentPane().add(lblConsultaDeAlumno);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(75, 127, 140, 14);
		getContentPane().add(lblNombre);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(222, 121, 520, 20);
		getContentPane().add(txtFiltro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 170, 694, 309);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idAlumno", "Nombres", "Apellidos", "DNI", "Correo", "Fecha de Nacimiento"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		scrollPane.setViewportView(table);


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
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		AlumnoModel a = new AlumnoModel();
		List<RegistroAlumno> lista = a.listaAlumnoPorConsultaNombre(filtro);
		
		for ( RegistroAlumno x: lista) {
			Object [] fila = {x.getIdAlumno(),x.getNombres(),x.getApellido(),x.getDni(),x.getCorreo(),x.getFechanacimiento()};
			dtm.addRow(fila);
		}
		
	}
}
