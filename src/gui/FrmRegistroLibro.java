package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Libro;
import model.LibroModel;
import util.Validaciones;

public class FrmRegistroLibro extends JInternalFrame  {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtanio;
	private JTextField txtCategoria;
	private JTextField txtSerie;
	private JTextField txtPais;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroLibro frame = new FrmRegistroLibro();
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
	public FrmRegistroLibro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Libro");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Libro");
		lblNewLabel.setBounds(279, 33, 350, 57);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(259, 142, 104, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(259, 192, 104, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categor\u00EDa:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(259, 237, 104, 46);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serie:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(259, 293, 104, 38);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pa\u00EDs:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(259, 344, 104, 26);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRegistrar_actionPerformed(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRegistrar.setBounds(359, 414, 185, 57);
		getContentPane().add(btnRegistrar);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(409, 143, 206, 26);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtanio = new JTextField();
		txtanio.setColumns(10);
		txtanio.setBounds(409, 192, 206, 26);
		getContentPane().add(txtanio);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(409, 247, 206, 26);
		getContentPane().add(txtCategoria);
		
		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(409, 298, 206, 26);
		getContentPane().add(txtSerie);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(409, 344, 206, 26);
		getContentPane().add(txtPais);

		

	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		// Recibiendo Datos
		String titulo=txtTitulo.getText();
		String anio=txtanio.getText();
		String cate=txtCategoria.getText();
		String serie=txtSerie.getText();
		String pais=txtPais.getText();
		
		// Validaciones
		if(!titulo.matches(Validaciones.TEXTO)) {
			mensaje("El titulo debe ser de 2 hasta 20 caracteres");
			return;
		}
		
		if(!anio.matches(Validaciones.ANNO)) {
			mensaje("Cada año lleva 4 digitos y solo numeros");
			return;
		}
		
		if(!cate.matches(Validaciones.TEXTO)) {
			mensaje("La categoria debe ser de 2 hasta 20 caracteres");
			return;
		}
		
		if(!serie.matches(Validaciones.NUMERO)) {
			mensaje("La serie no contiene letras");
			return;
		}
		
		if(!pais.matches(Validaciones.TEXTO)) {
			mensaje("Los paises deben llevar de 2 a 20 caracteres");
			return;
		}
		
		// Obtencion de la Fecha Actual
		long millis=System.currentTimeMillis();  
		java.sql.Date fecha=new java.sql.Date(millis);  
		
		// Usando "set" de la entidad Libro
		Libro obj = new Libro();
		obj.setTitulo(titulo);
		obj.setAnio(anio);
		obj.setCategoria(cate);
		obj.setSerie(serie);
		obj.setPais(pais);
		obj.setFechaRegistro(fecha);
		
		// Insercion de los datos al MySQL
		LibroModel model = new LibroModel();
		int salida=model.nuevoLibro(obj);
		if(salida>0) {
			mensaje("Nuevo Libro Registrado Correctamente");
			txtTitulo.setText("");
			txtanio.setText("");
			txtCategoria.setText("");
			txtSerie.setText("");
			txtPais.setText("");	
		}
		else {
			mensaje("Ocurrio un error al realizar el registro");
		}
	}
}
