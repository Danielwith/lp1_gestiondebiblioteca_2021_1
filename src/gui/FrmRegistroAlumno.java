package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import entidad.RegistroAlumno;
import model.AlumnoModel;
import util.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class FrmRegistroAlumno extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtcorreo;
	private JTextField txtfechanacimiento;
	private JTextField txtfecharegistro;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_2;
	private JTextField txtdni;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroAlumno frame = new FrmRegistroAlumno();
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
	public FrmRegistroAlumno() {
		getContentPane().setBackground(new Color(255, 250, 240));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Alumno");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Alumno");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carlos\\Desktop\\CIBERTEC\\Ciclo 3 - 2021-ll\\Lenguaje de Programacion l\\Proyecto\\Iconos 2\\Boy.gif"));
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel.setBounds(287, 25, 335, 55);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(32, 114, 135, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(32, 159, 135, 41);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1_2.setBounds(32, 269, 135, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1_3.setBounds(32, 327, 249, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Fecha de Registro");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1_3_1.setBounds(32, 377, 249, 35);
		getContentPane().add(lblNewLabel_1_3_1);
		
		txtnombres = new JTextField();
		txtnombres.setBackground(SystemColor.text);
		txtnombres.setBounds(287, 124, 278, 20);
		getContentPane().add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(287, 177, 278, 20);
		getContentPane().add(txtapellidos);
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(287, 279, 278, 20);
		getContentPane().add(txtcorreo);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setColumns(10);
		txtfechanacimiento.setBounds(287, 334, 278, 20);
		getContentPane().add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setColumns(10);
		txtfecharegistro.setBounds(287, 388, 278, 22);
		getContentPane().add(txtfecharegistro);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\carlos\\Desktop\\CIBERTEC\\Ciclo 3 - 2021-ll\\Lenguaje de Programacion l\\Proyecto\\Iconos 2\\Download.gif"));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(363, 448, 202, 61);
		getContentPane().add(btnRegistrar);
		
		lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(32, 218, 135, 24);
		getContentPane().add(lblNewLabel_2);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(287, 222, 278, 20);
		getContentPane().add(txtdni);

		

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
		
		String nombres = txtnombres.getText();
		String apellidos = txtapellidos.getText();
		String dni = txtdni.getText();
		String correo = txtcorreo.getText();
		String fnac = txtfechanacimiento.getText();
		String fregis = txtfecharegistro.getText();
		
		//VALIDACIONESS/////
		
		if(!nombres.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}
		if(!apellidos.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El apellido es de 3 a 30 caracteres");
		}
		if(!dni.matches(Validaciones.DNI)) {
			mensaje("El dni solo son 8 digitos");
		}
		if(!correo.matches(Validaciones.CORREO)) {
			mensaje("Ingresar el formato correcto");
		}
		if(!fnac.matches(Validaciones.FECHA)) {
			mensaje("Formato incorrecto de fecha");
		}
		if(!fregis.matches(Validaciones.FECHA))
		{
			mensaje("Formato incorrecto de Fecha de Registro");
		}
		
		
		
		RegistroAlumno obj = new RegistroAlumno();
		obj.setNombres(nombres);
		obj.setApellido(apellidos);
		obj.setDni(Integer.parseInt(dni));
		obj.setCorreo(correo);
		obj.setFechanacimiento(Date.valueOf(fnac));
		obj.setFecharegistro(Date.valueOf(fregis));
		
		AlumnoModel model = new AlumnoModel();
		int salida = model.insertarAlumno(obj);
		
		if(salida>0) {
			mensaje("Registro exitoso");
		}
		else
		{
			mensaje("Registro Fallido");
		}
		
		
		
		
	}
}
