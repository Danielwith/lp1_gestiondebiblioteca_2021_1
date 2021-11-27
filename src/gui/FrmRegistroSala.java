package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.Sala;
import model.SalaModel;
import util.Validaciones;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FrmRegistroSala extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtnumero;
	private JTextField txtpiso;
	private JTextField txtcapacidad;
	private JTextField txtrecursos;
	private JTextField txtfecha;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JTextField txtEstado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroSala frame = new FrmRegistroSala();
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
	public FrmRegistroSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Sala");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 113, 108, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Piso :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(52, 171, 60, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacidad :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(52, 225, 134, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Recursos :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(52, 283, 134, 30);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(52, 390, 99, 27);
		getContentPane().add(lblNewLabel_4);
		
		txtnumero = new JTextField();
		txtnumero.setBounds(275, 112, 153, 20);
		getContentPane().add(txtnumero);
		txtnumero.setColumns(10);
		
		txtpiso = new JTextField();
		txtpiso.setBounds(275, 169, 86, 19);
		getContentPane().add(txtpiso);
		txtpiso.setColumns(10);
		
		txtcapacidad = new JTextField();
		txtcapacidad.setBounds(275, 234, 153, 19);
		getContentPane().add(txtcapacidad);
		txtcapacidad.setColumns(10);
		
		txtrecursos = new JTextField();
		txtrecursos.setBounds(275, 292, 153, 19);
		getContentPane().add(txtrecursos);
		txtrecursos.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(275, 397, 153, 19);
		getContentPane().add(txtfecha);
		txtfecha.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(629, 406, 134, 46);
		getContentPane().add(btnRegistrar);
		
		lblNewLabel_6 = new JLabel("REGISTRO SALA");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_6.setBounds(301, 34, 301, 37);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("Estado :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(52, 339, 119, 19);
		getContentPane().add(lblNewLabel_5);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(275, 342, 86, 19);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

	}


	
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			handleBtnRegistrarActionPerformed(e);
		}
	}
	protected void handleBtnRegistrarActionPerformed(ActionEvent e) {
		String numero=txtnumero.getText();
		String piso=txtpiso.getText();
		String capacidad=txtcapacidad.getText();
		String recursos=txtrecursos.getText();
		String estado=txtEstado.getText();
		String fecha= txtfecha.getText();



		if(!recursos.matches(Validaciones.TEXTO)) {
			mensaje("LOS RECURSOS ES DE 2 A 30 CARACTERES");
			return;
		}
		
		if(!fecha.matches(Validaciones.FECHA)) {
			mensaje("LA FECHA ES DE FORMATO YYYY-MM-DD");
			return;
		}
		
		Sala obj=new Sala();
		obj.setNumero(numero);
		obj.setPiso(Integer.parseInt(piso));
		obj.setCapacidad(capacidad);
		obj.setRecursos(recursos);
		obj.setEstado(Integer.parseInt(estado));
		obj.setFechaRegistro(Date.valueOf(fecha));
		
		SalaModel model=new SalaModel();
		int salida=model.insertaSala(obj);
		if(salida>0) {
			mensaje("REGISTRADO CORRECTAMENTE");
		}
		else {
			mensaje("NO SE REGISTRO");
		}
	}
}
