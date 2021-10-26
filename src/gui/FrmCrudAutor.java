package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;

import entidad.Autor;
import model.AutorModel;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.MouseEvent;

public class FrmCrudAutor  extends JInternalFrame implements ActionListener, MouseListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtFechaNa;
	private JTextField txtFechaRe;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;

	
	//
			private int idSeleccionado = -1;
			private JTextField txtGrado;

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
	public FrmCrudAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Autor");
		setBounds(100, 100, 900, 626);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoAutor = new JLabel("Mantenimiento Autor");
		lblMantenimientoAutor.setBounds(234, 45, 374, 55);
		lblMantenimientoAutor.setFont(new Font("Trebuchet MS", Font.BOLD, 37));
		lblMantenimientoAutor.setBackground(Color.WHITE);
		getContentPane().add(lblMantenimientoAutor);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(23, 129, 135, 24);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(23, 168, 88, 41);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblApellido);
		
		JLabel lblFechanac = new JLabel("Fecha Nacimiento");
		lblFechanac.setBounds(335, 124, 192, 24);
		lblFechanac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblFechanac);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(24, 220, 157, 41);
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNacionalidad);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setBounds(335, 170, 140, 32);
		lblFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblFechaRegistro);
		
		JLabel lblGrado = new JLabel("Grado");
		lblGrado.setBounds(336, 219, 58, 32);
		lblGrado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblGrado);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(144, 132, 175, 20);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(145, 179, 176, 20);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		getContentPane().add(txtApellido);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(146, 231, 176, 20);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBackground(Color.WHITE);
		getContentPane().add(txtNacionalidad);
		
		txtFechaNa = new JTextField();
		txtFechaNa.setBounds(504, 126, 202, 20);
		txtFechaNa.setColumns(10);
		txtFechaNa.setBackground(Color.WHITE);
		getContentPane().add(txtFechaNa);
		
		txtFechaRe = new JTextField();
		txtFechaRe.setBounds(507, 179, 200, 20);
		txtFechaRe.setColumns(10);
		txtFechaRe.setBackground(Color.WHITE);
		getContentPane().add(txtFechaRe);
		
		txtGrado = new JTextField();
		txtGrado.setBounds(508, 227, 202, 22);
		txtGrado.setColumns(10);
		txtGrado.setBackground(Color.WHITE);
		getContentPane().add(txtGrado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(732, 97, 135, 41);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(732, 157, 135, 41);
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(732, 216, 135, 41);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 294, 755, 255);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Fecha Nacimiento", "Fecha Registro", "Nacionalidad", "Grado"
			}
		));
		scrollPane.setViewportView(table);

		lista();

	}
	
	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
	    txtFechaNa.setText("");
		txtFechaRe.setText("");
		txtNacionalidad.setText("");
		txtGrado.setText("");
	}
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		
		inserta();
		
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		
		actualiza(); 
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		elimina();
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
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
	protected void do_table_mouseClicked(MouseEvent e) {
		
		busca();
		
	}
	
	public void lista() {
		
		DefaultTableModel  dtm =(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		AutorModel m = new AutorModel();
		List<Autor> lista = m.listaAutor();
		
		for ( Autor x : lista) {
			Object [] fila = {x.getIdCodigo(),x.getNombres(), x.getApellidos(), x.getFechaNacimiento(), x.getFechaRegistro(),
								x.getNacionalidad(), x.getGrado()};
			dtm.addRow(fila);
		}
		
	}
	public void busca() {
		
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nom = (String)table.getValueAt(fila, 1);
		String ape = (String)table.getValueAt(fila, 2);
        Date  fechaNA = (Date) table.getValueAt(fila, 3);
        Date fechaRE = (Date) table.getValueAt(fila, 4);
		String naci = (String)table.getValueAt(fila, 5);
		String grado = (String)table.getValueAt(fila, 6);
		
		txtNombre.setText(nom);
		txtApellido.setText(ape);
		txtFechaNa.setText(String.valueOf(fechaNA));
		txtFechaRe.setText(String.valueOf(fechaRE));
		txtNacionalidad.setText(naci);
		txtGrado.setText(String.valueOf(grado));
		
		System.out.println(">>> idSeleccionado -> " + idSeleccionado);
		
	}
	public void inserta() {
		
		String nom  = txtNombre.getText();
		String ape = txtApellido.getText();
		String fecNa = txtFechaNa.getText();
		String fecRe = txtFechaRe.getText();
		String nac = txtNacionalidad.getText();
		String gra = txtGrado.getText();
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
			return;
		}
		if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		if (!nac.matches(Validaciones.TEXTO)) {
			mensaje("El texto es de 2 a 20 caracteres");
			return;
		}
		if (!fecNa.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		if (!fecRe.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Autor obj = new Autor();
		obj.setNombres(nom);
		obj.setApellidos(ape);
		obj.setFechaNacimiento(Date.valueOf(fecNa));
		obj.setFechaRegistro(Date.valueOf(fecRe));
		obj.setNacionalidad(nac);
		obj.setGrado(gra);
		
		AutorModel model = new AutorModel();
		int s = model.insertarAutor(obj);
		if(s>0) {
			lista();
			limpiarCajasTexto();
			mensaje("Registro Exitoso");
		}else {
			mensaje("Error en el registro");
		}
	}
	public void actualiza() {
		
		String nom  = txtNombre.getText();
		String ape = txtApellido.getText();
		String fecNa = txtFechaNa.getText();
		String fecRe = txtFechaRe.getText();
		String nac = txtNacionalidad.getText();
		String gra = txtGrado.getText();
		
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
		if (!nac.matches(Validaciones.TEXTO)) {
			mensaje("El texto es de 2 a 20 caracteres");
			return;
		}
		if (!fecNa.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		if (!fecRe.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Autor obj = new Autor();
		
		obj.setIdCodigo(idSeleccionado);
		obj.setNombres(nom);
		obj.setApellidos(ape);
		obj.setFechaNacimiento(Date.valueOf(fecNa));
		obj.setFechaRegistro(Date.valueOf(fecRe));
		obj.setNacionalidad(nac);
		obj.setGrado(gra);
		
		AutorModel model = new AutorModel();
		
		int s = model.actualizaAutor(obj);
		if(s>0) {
			idSeleccionado = -1;
			lista();
			limpiarCajasTexto();
			mensaje("Registro Exitoso");
		}else {
			mensaje("Error en el registro");
		}
		
	}
	public void elimina() {
		
		if(idSeleccionado ==-1) {
			mensaje("Seleccione una fila");
		}else {
			AutorModel model = new AutorModel();
			int salida = model.eliminarAutor(idSeleccionado);
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


