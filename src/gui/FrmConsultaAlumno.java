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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.RegistroAlumno;
import model.AlumnoModel;

public class FrmConsultaAlumno extends JInternalFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;

	int hoveredRow = -1, hoveredColumn = -1;
	
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
		txtFiltro.setBounds(222, 121, 604, 20);
		getContentPane().add(txtFiltro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 170, 751, 309);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Correo", "Fecha Nacimiento"
			}
		));
		
		//alineación
				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
				rightRenderer.setHorizontalAlignment(JLabel.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
				
				
				//tamano de la fila	
				table.getColumnModel().getColumn(0).setPreferredWidth(25);
				table.getColumnModel().getColumn(1).setPreferredWidth(120);
				table.getColumnModel().getColumn(2).setPreferredWidth(100);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(4).setPreferredWidth(150);
				table.getColumnModel().getColumn(4).setPreferredWidth(150);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				//selecciona una sola fila
				table.setRowSelectionAllowed(true);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				//desabilita mover las columnas
				table.getTableHeader().setReorderingAllowed(false);
				
				//color de la fila seleccionada
				table.setSelectionBackground(Color.GREEN);
				
				//el mouse over
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
