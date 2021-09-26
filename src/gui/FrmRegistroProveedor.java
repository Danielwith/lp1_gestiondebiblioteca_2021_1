package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import entidad.proveedor;
import model.ProveedorModel;
import util.Validaciones;

public class FrmRegistroProveedor extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtdni;
	private JTextField txtdireccion;
	private JTextField txtcorreo;
	private JTextField txtpais;
	private JTextField txtfecharegistro;
	private JButton btnRegistrar;
	private JLabel lblTELEFONO;
	private JTextField txttelefono;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProveedor frame = new FrmRegistroProveedor();
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
	public FrmRegistroProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Proveedor");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNOMBRES = new JLabel("NOMBRES:");
		lblNOMBRES.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNOMBRES.setBounds(245, 149, 110, 14);
		getContentPane().add(lblNOMBRES);
		
		JLabel lblAPELLIDOS = new JLabel("APELLIDOS:");
		lblAPELLIDOS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAPELLIDOS.setBounds(245, 174, 110, 14);
		getContentPane().add(lblAPELLIDOS);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDNI.setBounds(245, 199, 59, 14);
		getContentPane().add(lblDNI);
		
		JLabel lblCORREO = new JLabel("CORREO:");
		lblCORREO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCORREO.setBounds(245, 291, 102, 14);
		getContentPane().add(lblCORREO);
		
		JLabel lblDIRECCION = new JLabel("DIRECCION:");
		lblDIRECCION.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDIRECCION.setBounds(245, 224, 123, 14);
		getContentPane().add(lblDIRECCION);
		
		JLabel lblPAIS = new JLabel("PAIS:");
		lblPAIS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPAIS.setBounds(245, 316, 59, 14);
		getContentPane().add(lblPAIS);
		
		JLabel lblFECHAREGISTRO = new JLabel("FECHA REGISTRO:");
		lblFECHAREGISTRO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFECHAREGISTRO.setBounds(245, 341, 170, 14);
		getContentPane().add(lblFECHAREGISTRO);
		
		txtnombres = new JTextField();
		txtnombres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtnombres.setBounds(415, 146, 256, 20);
		getContentPane().add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtapellidos.setBounds(415, 171, 256, 20);
		getContentPane().add(txtapellidos);
		txtapellidos.setColumns(10);
		
		txtdni = new JTextField();
		txtdni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtdni.setBounds(415, 196, 256, 20);
		getContentPane().add(txtdni);
		txtdni.setColumns(10);
		
		txtdireccion = new JTextField();
		txtdireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtdireccion.setBounds(415, 225, 256, 20);
		getContentPane().add(txtdireccion);
		txtdireccion.setColumns(10);
		
		txtcorreo = new JTextField();
		txtcorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtcorreo.setBounds(415, 288, 256, 20);
		getContentPane().add(txtcorreo);
		txtcorreo.setColumns(10);
		
		txtpais = new JTextField();
		txtpais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpais.setBounds(415, 313, 256, 20);
		getContentPane().add(txtpais);
		txtpais.setColumns(10);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtfecharegistro.setBounds(415, 338, 256, 20);
		getContentPane().add(txtfecharegistro);
		txtfecharegistro.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(391, 373, 152, 54);
		getContentPane().add(btnRegistrar);
		
		JLabel lblREGISTRARPROVEEDOR = new JLabel("REGISTRAR PROVEEDOR");
		lblREGISTRARPROVEEDOR.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblREGISTRARPROVEEDOR.setBounds(228, 42, 463, 54);
		getContentPane().add(lblREGISTRARPROVEEDOR);
		
		lblTELEFONO = new JLabel("TELEFONO:");
		lblTELEFONO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTELEFONO.setBounds(245, 256, 102, 14);
		getContentPane().add(lblTELEFONO);
		
		txttelefono = new JTextField();
		txttelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttelefono.setBounds(415, 257, 256, 20);
		getContentPane().add(txttelefono);
		txttelefono.setColumns(10);

		

	}


	
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		
	
	String nombres=txtnombres.getText();
	String apellidos=txtapellidos.getText();
	String dni=txtdni.getText();
	String direccion=txtdireccion.getText();
	String telefono=txttelefono.getText();
	String correo=txtcorreo.getText();
	String pais=txtpais.getText();
	String fecharegistro=txtfecharegistro.getText();
	
	/*VALIDACIONES*/
	if(!nombres.matches(Validaciones.TEXTO)) {
		mensaje("El nombre es de 3 a 30 caracteres");
	}
	
	if(!apellidos.matches(Validaciones.TEXTO)) {
		mensaje("El apellido es de 3 a 30 caracteres");
	}
	
	if(!dni.matches(Validaciones.DNI)) {
		mensaje("DNI de 8 digitos");
	}
	
	/*if(!telefono.matches(Validaciones.TELEFONO)) {
		mensaje("Ingresa numero de 9 digitos");
	}*/
	
	if(!correo.matches(Validaciones.CORREO)) {
		mensaje("Ingrese un formato corecto");
	}
	
	if(!pais.matches(Validaciones.TEXTO)) {
		mensaje("Ingresa un pais");
	}
	
	
	/**/
	
	proveedor obj = new proveedor();
	obj.setNombres(nombres);
	obj.setApellidos(apellidos);
	obj.setDni(Integer.parseInt(dni));
	obj.setDireccion(direccion);
	obj.setTelefono(Integer.parseInt(telefono));
	obj.setCorreo(correo);
	obj.setPais(pais);
	obj.setFechaRegistro(Date.valueOf(fecharegistro));
	;
	

	ProveedorModel model=new ProveedorModel();
	int salida = model.insertarProveedor(obj);
	
	if(salida>0) {
		mensaje("REGISTRO GUARDADO");
	}
	
	else {
		mensaje("REGISTRO ERRONEO");
	}
	
	
	
	
	}
}
