package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Autor;
import model.AutorModel;
import util.Validaciones;

public class FrmRegistroAutor extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNacionalidad;
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
		lblNombres.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblNombres.setBounds(162, 130, 110, 22);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblApellidos.setBounds(162, 164, 110, 22);
		getContentPane().add(lblApellidos);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombres.setColumns(10);
		txtNombres.setBounds(360, 127, 256, 26);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(361, 162, 256, 26);
		getContentPane().add(txtApellidos);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD:");
		lblNacionalidad.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblNacionalidad.setBounds(162, 200, 163, 22);
		getContentPane().add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(360, 198, 256, 26);
		getContentPane().add(txtNacionalidad);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO:");
		lblFechaNacimiento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblFechaNacimiento.setBounds(162, 267, 194, 22);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblFechaRegistro = new JLabel("FECHA REGISTRO:");
		lblFechaRegistro.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblFechaRegistro.setBounds(162, 299, 194, 22);
		getContentPane().add(lblFechaRegistro);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(361, 265, 256, 26);
		getContentPane().add(txtFechaNacimiento);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaRegistro.setColumns(10);
		txtFechaRegistro.setBounds(361, 297, 256, 26);
		getContentPane().add(txtFechaRegistro);
		
		JLabel lblGrado = new JLabel("GRADO:");
		lblGrado.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblGrado.setBounds(162, 232, 163, 22);
		getContentPane().add(lblGrado);
		
		txtGrado = new JTextField();
		txtGrado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGrado.setColumns(10);
		txtGrado.setBounds(360, 231, 256, 26);
		getContentPane().add(txtGrado);
		
		JLabel lblRegistroAutor = new JLabel("REGISTRO AUTOR");
		lblRegistroAutor.setForeground(Color.RED);
		lblRegistroAutor.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblRegistroAutor.setBounds(256, 37, 340, 40);
		getContentPane().add(lblRegistroAutor);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(313, 380, 227, 56);
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
		String nacionalidad = txtNacionalidad.getText();
		String grado = txtGrado.getText();
		
		/*VALIDACIONES*/
		if(!nombres.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}	
		if(!apellidos.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El apellido es de 3 a 30 caracteres");
		}
		if(!nacionalidad.matches(Validaciones.TEXTO)) {
			mensaje("El TEXTO es de 3 a 20 caracteres");
		}
		if(!fechaNacimiento.matches(Validaciones.FECHA)) {
			mensaje("La fecha es de formato yyyy-MM-dd");
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
