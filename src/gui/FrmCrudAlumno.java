package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.RegistroAlumno;
import model.AlumnoModel;
import util.Validaciones;

public class FrmCrudAlumno  extends JInternalFrame implements ActionListener, MouseListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombres;
	private JTextField txtapellido;
	private JTextField txtdni;
	private JTextField txtcorreo;
	private JTextField txtfechanacimiento;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;

	
	//Es el Id que se obtiene al seleccionar la fila
		private int idSeleccionado = -1; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroUsuario frame = new FrmRegistroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Alumno");
		setBounds(100, 100, 900, 722);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoAlumno = new JLabel("Mantenimiento Alumno");
		lblMantenimientoAlumno.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblMantenimientoAlumno.setBackground(Color.WHITE);
		lblMantenimientoAlumno.setBounds(298, 21, 486, 55);
		getContentPane().add(lblMantenimientoAlumno);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNombre.setBounds(52, 139, 135, 24);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblApellido.setBounds(52, 178, 135, 41);
		getContentPane().add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblDni.setBounds(52, 229, 135, 24);
		getContentPane().add(lblDni);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblCorreo.setBounds(52, 276, 135, 24);
		getContentPane().add(lblCorreo);
		
		JLabel lblFechanac = new JLabel("Fecha Nacimiento");
		lblFechanac.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblFechanac.setBounds(52, 326, 249, 24);
		getContentPane().add(lblFechanac);
		
		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBackground(Color.WHITE);
		txtnombres.setBounds(298, 139, 278, 20);
		getContentPane().add(txtnombres);
		
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(298, 178, 278, 20);
		getContentPane().add(txtapellido);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(298, 222, 278, 20);
		getContentPane().add(txtdni);
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(298, 276, 278, 20);
		getContentPane().add(txtcorreo);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setColumns(10);
		txtfechanacimiento.setBounds(298, 334, 278, 20);
		getContentPane().add(txtfechanacimiento);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Carlo\\OneDrive\\Escritorio\\Ciclo 3 - 2021-ll\\Lenguaje de Programacion l\\Sesion 1\\iconos\\Accept.gif"));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(719, 136, 135, 41);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Carlo\\OneDrive\\Escritorio\\Ciclo 3 - 2021-ll\\Lenguaje de Programacion l\\Sesion 1\\iconos\\Up.gif"));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(719, 193, 135, 41);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Carlo\\OneDrive\\Escritorio\\Ciclo 3 - 2021-ll\\Lenguaje de Programacion l\\Sesion 1\\iconos\\Delete.gif"));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(719, 255, 135, 41);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 388, 800, 280);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Correo", "Fecha Nacimiento"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(111);
		scrollPane.setViewportView(table);

		lista();

	}
	

	
	void limpiarCajasTexto() {
		txtnombres.setText("");
		txtapellido.setText("");
		txtdni.setText("");
	    txtcorreo.setText("");
		txtfechanacimiento.setText("");
	}
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		inserta();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualiza();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		elimina();
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTableJTable(MouseEvent e) {
		buscar();
	}
	
	public void lista() {
		
		DefaultTableModel  dtm =(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		AlumnoModel m = new AlumnoModel();
		List<RegistroAlumno> lista = m.listaAlumno();
		
		for ( RegistroAlumno x : lista) {
			Object [] fila = {x.getIdAlumno(), x.getNombres(), x.getApellido(), x.getDni(), x.getCorreo() , x.getFechanacimiento()};
			dtm.addRow(fila);
		}		
		
	}
	public void buscar() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nom = (String)table.getValueAt(fila, 1);
		String ape = (String)table.getValueAt(fila, 2);
        int  dni = (Integer)table.getValueAt(fila, 3);
		String correo = (String)table.getValueAt(fila,4);
		Date fecha = (Date) table.getValueAt(fila, 5);
		
		txtnombres.setText(nom);
		txtapellido.setText(ape);
	    txtdni.setText(String.valueOf(dni));
		txtcorreo.setText(correo);
		txtfechanacimiento.setText(String.valueOf(fecha));
		
		System.out.println(">>> idSeleccionado -> " + idSeleccionado);
		
	}
	public void inserta() {
		String nom  = txtnombres.getText();
		String ape = txtapellido.getText();
		String dni = txtdni.getText();
		String corre = txtcorreo.getText();
		String fec = txtfechanacimiento.getText();
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
			return;
		}
		if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni son de 8 digitos");
			return;
		}
		if(!corre.matches(Validaciones.CORREO)) {
			mensaje("Ingrese el formato correcto");
			return;
		}
		if (!fec.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		RegistroAlumno obj = new RegistroAlumno();
		obj.setNombres(nom);
		obj.setApellido(ape);
		obj.setDni(Integer.valueOf(dni));
		obj.setCorreo(corre);
		obj.setFechanacimiento(Date.valueOf(fec));
		
		AlumnoModel model = new AlumnoModel();
		int s = model.insertarAlumno(obj);
		if(s>0) {
			lista();
			limpiarCajasTexto();
			mensaje("Registro Exitoso");
		}else {
			mensaje("Error en el registro");
		}
		
	}
	
	
	public void actualiza() {
		
		String nom  = txtnombres.getText();
		String ape = txtapellido.getText();
		String dni = txtdni.getText();
		String corre = txtcorreo.getText();
		String fec = txtfechanacimiento.getText();
		
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
			return;
		}
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
			return;
		}
		if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni son de 8 digitos");
			return;
		}
		if(!corre.matches(Validaciones.CORREO)) {
			mensaje("Ingrese el formato correcto");
			return;
		}
		if (!fec.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		RegistroAlumno obj = new RegistroAlumno();
		obj.setIdAlumno(idSeleccionado);
		obj.setNombres(nom);
		obj.setApellido(ape);
		obj.setDni(Integer.valueOf(dni));
		obj.setCorreo(corre);
		obj.setFechanacimiento(Date.valueOf(fec));
		
	AlumnoModel model = new AlumnoModel();
		int s = model.actualizaAlumno(obj);
		if(s>0) {
			idSeleccionado = -1;
			lista();
			limpiarCajasTexto();
			mensaje("Actualización exitosa");
		}else {
			mensaje("Error en la actualización");
		}
		
	}
	
	
	public void elimina() {
		
		if(idSeleccionado ==-1) {
			mensaje("Seleccione una fila");
		}else {
			AlumnoModel model = new AlumnoModel();
			int salida = model.eliminarAlumno(idSeleccionado);
			if(salida >0) {
				idSeleccionado = -1;
				lista();
				limpiarCajasTexto();
				mensaje("Eliminacion Exitosa");
			}else {
				mensaje("Error en la eliminacion");
			}
		}
		
	}
}


