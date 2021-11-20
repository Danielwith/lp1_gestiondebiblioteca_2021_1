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

import entidad.RegistroAlumno;
import model.AlumnoModel;
import util.Validaciones;

public class FrmRegistroAlumno  extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtapellidos;
	private JTextField txtdni;
	private JTextField txtcorreo;
	private JTextField txtfechanacimiento;
	private JButton btnRegistrar;

	
	//Es el Id que se obtiene al seleccionar la fila
		private JTextField txtnombres;


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
	public FrmRegistroAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Alumno");
		setBounds(100, 100, 911, 552);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoAlumno = new JLabel("Registro Alumno");
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
		
		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(298, 178, 278, 20);
		getContentPane().add(txtapellidos);
		
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
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(342, 414, 205, 55);
		getContentPane().add(btnRegistrar);
		
		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBounds(298, 139, 278, 20);
		getContentPane().add(txtnombres);

		

	}
	

	
	void limpiarCajasTexto() {
		txtnombres.setText("");
		txtapellidos.setText("");
		txtdni.setText("");
	    txtcorreo.setText("");
		txtfechanacimiento.setText("");
	}
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String nombres = txtnombres.getText();
		String apellidos = txtapellidos.getText();
		String dni = txtdni.getText();
		String correo = txtcorreo.getText();
		String fnac = txtfechanacimiento.getText();
		
		
		//VALIDACIONESS/////
		
		if(!nombres.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
			return;
		}
		if(!apellidos.matches(Validaciones.TEXTOALUMNO)) {
			mensaje("El apellido es de 3 a 30 caracteres");
			return;
		}
		if(!dni.matches(Validaciones.DNI)) {
			mensaje("El dni solo son 8 digitos");
			return;
		}
		if(!correo.matches(Validaciones.CORREO)) {
			mensaje("Ingresar el formato correcto");
			return;
		}
		if(!fnac.matches(Validaciones.FECHA)) {
			mensaje("La fecha es de formato yyyy-MM-dd");
			return;
		}

		
		
		RegistroAlumno obj = new RegistroAlumno();
		obj.setNombres(nombres);
		obj.setApellido(apellidos);
		obj.setDni(Integer.parseInt(dni));
		obj.setCorreo(correo);
		obj.setFechanacimiento(Date.valueOf(fnac));
		
		
		AlumnoModel model = new AlumnoModel();
		int salida = model.insertarAlumno(obj);
		
		if(salida>0) {
			mensaje("Registro exitoso");
			limpiarCajasTexto();
		}
		else
		{
			mensaje("Registro Fallido");
		}
		
		}
	}

	
	



