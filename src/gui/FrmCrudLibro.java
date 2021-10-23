package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Libro;
import model.LibroModel;
import util.Validaciones;

public class FrmCrudLibro  extends JInternalFrame  {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTextField txtPais;
	private JTextField txtSerie;
	private JTextField txtAnio;
	private JTable table;

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
	public FrmCrudLibro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Libro");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Libro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(292, 23, 342, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(66, 98, 151, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(403, 206, 57, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(66, 150, 151, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serie:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(402, 150, 151, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Pais:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(66, 210, 151, 27);
		getContentPane().add(lblNewLabel_6);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(139, 102, 495, 27);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(165, 158, 164, 27);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(165, 214, 164, 27);
		getContentPane().add(txtPais);
		
		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(470, 157, 164, 27);
		getContentPane().add(txtSerie);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(470, 213, 164, 27);
		getContentPane().add(txtAnio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 287, 818, 211);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "A\u00F1o", "Categoria", "Serie", "Fecha de Registro", "Pais"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnIngresar = new JButton("Agregar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnIngresar_actionPerformed(e);
			}
		});
		btnIngresar.setBounds(696, 98, 118, 39);
		getContentPane().add(btnIngresar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnActualizar_actionPerformed(e);
			}
		});
		btnActualizar.setBounds(696, 150, 118, 39);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEliminar_actionPerformed(e);
			}
		});
		btnEliminar.setBounds(696, 206, 118, 39);
		getContentPane().add(btnEliminar);

		
		lista();
	}
	
	void limpiarCajasTexto() {
		txtTitulo.setText("");
		txtCategoria.setText("");
		txtPais.setText("");
		txtSerie.setText("");
		txtAnio.setText("");
		txtTitulo.requestFocus();
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		insertar();
	}
	
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		actualizar();
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		elimina();
	}
	
	protected void do_table_mouseClicked(MouseEvent e) {
		buscar();
	}
	
	public void lista() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		LibroModel lm = new LibroModel();
		List<Libro> lista = lm.listarLibro();
		
		for(Libro x:lista) {
			Object[] fila = { x.getIdLibro(), x.getTitulo() , x.getAnio(), x.getCategoria(), x.getSerie(), x.getFechaRegistro(), x.getPais()};
			dtm.addRow(fila);
		}
	}
	
	public void buscar() {
		int fila=table.getSelectedRow();
		
		idSeleccionado=(Integer) table.getValueAt(fila,0);
		String titu = (String) table.getValueAt(fila, 1);
		String anio = (String) table.getValueAt(fila, 2);
		String cate = (String) table.getValueAt(fila, 3);
		String seri = (String) table.getValueAt(fila, 4);
		Date fec = (Date) table.getValueAt(fila, 5);
		String pais = (String) table.getValueAt(fila, 6);
		
		txtTitulo.setText(titu);
		txtAnio.setText(anio);
		txtCategoria.setText(cate);
		txtSerie.setText(seri);
		txtPais.setText(pais);
	}
	
	public void insertar() {
		String titu = txtTitulo.getText();
		String cate = txtCategoria.getText();
		String pais = txtPais.getText();
		String seri = txtSerie.getText();
		String anio = txtAnio.getText();

		if(!titu.matches(Validaciones.TEXTO)) {
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
		
		if(!seri.matches(Validaciones.NUMERO)) {
			mensaje("La serie no contiene letras");
			return;
		}
		
		if(!pais.matches(Validaciones.TEXTO)) {
			mensaje("Los paises deben llevar de 2 a 20 caracteres");
			return;
		}
		
		long millis=System.currentTimeMillis();  
		java.sql.Date fecha=new java.sql.Date(millis);  
		
		Libro obj = new Libro();
		obj.setTitulo(titu);
		obj.setCategoria(cate);
		obj.setAnio(anio);
		obj.setSerie(seri);
		obj.setPais(pais);
		obj.setFechaRegistro(fecha);
		
		LibroModel model = new LibroModel();
		int s = model.nuevoLibro(obj);
		if(s>0) {
			lista();
			limpiarCajasTexto();
			mensaje("Registro exitoso");
		}else {
			mensaje("Error en el registro");
		}
	}
	
	public void actualizar() {
		String titu = txtTitulo.getText();
		String cate = txtCategoria.getText();
		String pais = txtPais.getText();
		String seri = txtSerie.getText();
		String anio = txtAnio.getText();

		if(idSeleccionado==-1) {
			mensaje("Seleccione una fila de la tabla");
			return;
		}
		
		if(!titu.matches(Validaciones.TEXTO)) {
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
		
		if(!seri.matches(Validaciones.NUMERO)) {
			mensaje("La serie no contiene letras");
			return;
		}
		
		if(!pais.matches(Validaciones.TEXTO)) {
			mensaje("Los paises deben llevar de 2 a 20 caracteres");
			return;
		}
		
		long millis=System.currentTimeMillis();  
		java.sql.Date fecha=new java.sql.Date(millis);  
		
		Libro obj = new Libro();
		obj.setIdLibro(idSeleccionado);
		obj.setTitulo(titu);
		obj.setCategoria(cate);
		obj.setAnio(anio);
		obj.setSerie(seri);
		obj.setPais(pais);
		obj.setFechaRegistro(fecha);
		
		LibroModel model = new LibroModel();
		int s = model.actualizarLibro(obj);
		if(s>0) {
			idSeleccionado=-1;
			lista();
			limpiarCajasTexto();
			mensaje("Actualizacion exitosa");
		}else {
			mensaje("Error en la actualizacion");
		}
	}

	public void elimina() {
		if(idSeleccionado==-1) {
			mensaje("Seleccione una fila");
		}else {
			LibroModel model = new LibroModel();
			int s = model.eliminarLibro(idSeleccionado);
			if(s>0) {
				idSeleccionado =-1;
				lista();
				limpiarCajasTexto();
				mensaje("Eliminado exitosamente");
			}else {
				mensaje("Error en la eliminacion");
			}
		}
	}
}


