package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Autor;
import model.AutorModel;
import util.Validaciones;
import javax.swing.ImageIcon;

public class FrmRegistroAutor extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JComboBox<String> cboNacionalidad;
	private JTextField txtFechaNacimiento;
	private JTextField txtFechaRegistro;
	private JTextField txtGrado;
	private JButton btnRegistrar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroAutor frame = new FrmRegistroAutor();
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
	public FrmRegistroAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Autor");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("NOMBRES:");
		lblNombres.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblNombres.setBounds(32, 129, 133, 22);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblApellidos.setBounds(32, 180, 136, 22);
		getContentPane().add(lblApellidos);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombres.setColumns(10);
		txtNombres.setBounds(182, 128, 243, 26);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(182, 179, 243, 26);
		getContentPane().add(txtApellidos);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD:");
		lblNacionalidad.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblNacionalidad.setBounds(29, 228, 163, 22);
		getContentPane().add(lblNacionalidad);
		
		String[] arrayPais =  new String[] {" [Seleccione] ","Perú", "Venezuela", "Argentina", "Alemania", "Cuba", "Holanda"};
		Arrays.sort(arrayPais);
		
		cboNacionalidad = new JComboBox<String>();
		cboNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNacionalidad.setModel(new DefaultComboBoxModel(new String[] {" [Seleccione] ", "Per\u00FA", "Venezuela", "Argentina", "Alemania", "Cuba", "Holanda"}));
		cboNacionalidad.setBounds(182, 227, 243, 26);
		getContentPane().add(cboNacionalidad);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO:");
		lblFechaNacimiento.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblFechaNacimiento.setBounds(448, 180, 194, 22);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblFechaRegistro = new JLabel("FECHA REGISTRO:");
		lblFechaRegistro.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblFechaRegistro.setBounds(448, 226, 194, 22);
		getContentPane().add(lblFechaRegistro);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(645, 179, 229, 26);
		getContentPane().add(txtFechaNacimiento);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaRegistro.setColumns(10);
		txtFechaRegistro.setBounds(646, 225, 228, 26);
		getContentPane().add(txtFechaRegistro);
		
		JLabel lblGrado = new JLabel("GRADO:");
		lblGrado.setFont(new Font("Dubai", Font.PLAIN, 20));
		lblGrado.setBounds(449, 130, 99, 22);
		getContentPane().add(lblGrado);
		
		txtGrado = new JTextField();
		txtGrado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGrado.setColumns(10);
		txtGrado.setBounds(645, 128, 229, 26);
		getContentPane().add(txtGrado);
		
		JLabel lblRegistroAutor = new JLabel("REGISTRO AUTOR");
		lblRegistroAutor.setForeground(Color.WHITE);
		lblRegistroAutor.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblRegistroAutor.setBounds(264, 49, 340, 40);
		getContentPane().add(lblRegistroAutor);
		
		btnRegistrar = new JButton("  Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(316, 355, 227, 56);
		getContentPane().add(btnRegistrar);

	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		
		String nombres = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		String fechaNacimiento = txtFechaNacimiento.getText();
		String fechaRegistro = txtFechaRegistro.getText();
		String nacionalidad = cboNacionalidad.getSelectedItem().toString();
		String grado = txtGrado.getText();
		
		/*VALIDACIONES*/
		if(!nombres.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
			return;
		}	
		if(!apellidos.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El apellido es de 3 a 30 caracteres");
			return;
		}
		if(!grado.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El texto es de 3 a 30 caracteres");
			return;
		}
		if(cboNacionalidad.getSelectedIndex() == 0) {
			mensaje("Seleccione una nacionalidad");
			return;
		}
		if(!fechaNacimiento.matches(Validaciones.FECHA)) {
			mensaje("La fecha es de formato yyyy-MM-dd");
			return;
		}
		if(!fechaRegistro.matches(Validaciones.FECHA)) {
			mensaje("La fecha es de formato yyyy-MM-dd");
			return;
		}
		
		
		Autor obj = new Autor();
		
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setFechaNacimiento(Date.valueOf(fechaNacimiento));
		obj.setFechaRegistro(Date.valueOf(fechaRegistro));
		obj.setNacionalidad(nacionalidad);
		obj.setGrado(grado);
		

		AutorModel model=new AutorModel();
		int salida = model.insertarAutor(obj);
		
		if(salida>0) {
			mensaje("REGISTRO GUARDADO");
		}
		
		else {
			mensaje("NO SE REGISTRO");
		}
		
	}
}
