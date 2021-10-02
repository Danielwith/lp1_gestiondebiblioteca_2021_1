package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import entidad.RegistrarUsuario;
import model.RegistroUsuarioModel;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmRegistroUsuario extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNoUsu;
	private JTextField txtApeUsu;
	private JTextField txtFecNaciUsu;
	private JTextField txtLogin;
	private JTextField txtCorreo;
	private JTextField txtDirec;
	private JTextField txtDNI;
	private JPasswordField txtContra;
	private JButton btnRegistrar;

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
	public FrmRegistroUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Usuario");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("REGISTRAR USUARIO");
		lblNewLabel.setBounds(358, 45, 354, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setBounds(47, 98, 189, 27);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido de Usuario");
		lblNewLabel_1_1.setBounds(47, 147, 189, 27);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_3.setBounds(47, 196, 189, 27);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1_3);

		txtNoUsu = new JTextField();
		txtNoUsu.setBounds(246, 96, 306, 34);
		getContentPane().add(txtNoUsu);
		txtNoUsu.setColumns(10);

		txtApeUsu = new JTextField();
		txtApeUsu.setBounds(246, 146, 306, 34);
		txtApeUsu.setColumns(10);
		getContentPane().add(txtApeUsu);

		txtFecNaciUsu = new JTextField();
		txtFecNaciUsu.setBounds(246, 195, 306, 34);
		txtFecNaciUsu.setColumns(10);
		getContentPane().add(txtFecNaciUsu);

		JLabel lblNewLabel_1_3_1 = new JLabel("Login");
		lblNewLabel_1_3_1.setBounds(47, 247, 189, 27);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1_3_1);

		txtLogin = new JTextField();
		txtLogin.setBounds(246, 240, 306, 34);
		txtLogin.setColumns(10);
		getContentPane().add(txtLogin);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1_1.setBounds(47, 295, 189, 27);
		getContentPane().add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Correo");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1_1_1.setBounds(47, 333, 189, 27);
		getContentPane().add(lblNewLabel_1_3_1_1_1);

		JLabel lblNewLabel_1_3_1_1_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1_1_2.setBounds(47, 384, 189, 27);
		getContentPane().add(lblNewLabel_1_3_1_1_2);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(246, 330, 306, 34);
		getContentPane().add(txtCorreo);

		txtDirec = new JTextField();
		txtDirec.setColumns(10);
		txtDirec.setBounds(246, 377, 306, 34);
		getContentPane().add(txtDirec);

		JLabel lblNewLabel_1_3_1_1_1_1 = new JLabel("DNI");
		lblNewLabel_1_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1_1_1_1.setBounds(47, 424, 189, 27);
		getContentPane().add(lblNewLabel_1_3_1_1_1_1);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(246, 422, 306, 34);
		getContentPane().add(txtDNI);

		txtContra = new JPasswordField();
		txtContra.setBounds(246, 295, 306, 27);
		getContentPane().add(txtContra);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(672, 429, 122, 40);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);

	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}

	public void actionPerformed(ActionEvent e) {
		String nomUsu = txtNoUsu.getText();
		String apUsu = txtApeUsu.getText();
		String fecusu = txtFecNaciUsu.getText();
		String login = txtLogin.getText();
		String con = txtContra.getText();
		String corre = txtCorreo.getText();
		String direc = txtDirec.getText();
		String DNI = txtDNI.getText();
		// Validaciones
		if (!nomUsu.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
			return;
		}
		if (!apUsu.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		if (!fecusu.matches(Validaciones.FECHA)) {
			mensaje("El formato de fecha es yyyy-MM-dd");
			return;
		}
		if (!DNI.matches(Validaciones.DNI)) {
			mensaje("El DNI tiene que tener 8 caracteres");
			return;
		}
		if (!corre.matches(Validaciones.CORREO)) {
			mensaje("El Correo es con formato @gmail.com");
			return;
		}

		RegistrarUsuario obj = new RegistrarUsuario();

		obj.setNombreUsuario(nomUsu);
		obj.setApellidoUsuario(apUsu);
		obj.setDNI(Integer.parseInt(DNI));
		obj.setLogin(login);
		obj.setPassword(con);
		obj.setCorreo(corre);
		obj.setFechaNacimientoUsuario(Date.valueOf(fecusu));
		obj.setDirección(direc);

		RegistroUsuarioModel model = new RegistroUsuarioModel();
		int salida = model.insertaUsuario(obj);
		if (salida > 0) {
			mensaje("Registro exitoso");
		} else {
			mensaje("Error en el registro");
		}
	}
}
