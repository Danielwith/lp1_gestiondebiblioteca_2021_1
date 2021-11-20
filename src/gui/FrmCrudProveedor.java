package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;

public class FrmCrudProveedor  extends JInternalFrame implements ActionListener, MouseListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtPais;
	private JTextField txtFecha;
	private JTable table;
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private int idSeleccionado=-1;
	int hoveredRow = -1, hoveredColumn = -1;


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
	public FrmCrudProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Proveedor");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Mantenimiento Proveedor");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(263, 24, 341, 48);
		getContentPane().add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(26, 101, 58, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(26, 139, 77, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(26, 180, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(26, 218, 77, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(315, 102, 77, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(315, 140, 77, 14);
		getContentPane().add(lblCorreo);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(315, 180, 58, 15);
		getContentPane().add(lblPais);
		
		JLabel lblFecha = new JLabel("Fecha Registro");
		lblFecha.setBounds(315, 218, 95, 14);
		getContentPane().add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 98, 171, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(114, 136, 171, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(114, 176, 171, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(114, 214, 171, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(420, 98, 157, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setBounds(420, 136, 157, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setBounds(420, 176, 157, 20);
		getContentPane().add(txtPais);
		txtPais.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(420, 214, 157, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(631, 100, 164, 33);
		getContentPane().add(btnIngresar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(631, 144, 164, 38);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(631, 193, 164, 38);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 864, 257);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Dirrección", "Telefono", "Correo", "País", "Fecha Registro"
			}
		));
		scrollPane.setViewportView(table);

		//selecciona una sola fila

		table.setRowSelectionAllowed(true);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//desabilita mover las columnas

		table.getTableHeader().setReorderingAllowed(false);
		
		//color de la fila seleccionada

		table.setSelectionBackground(Color.BLUE);
		
		//tamano de la fila	

				table.getColumnModel().getColumn(0).setPreferredWidth(15);

				table.getColumnModel().getColumn(1).setPreferredWidth(100);

				table.getColumnModel().getColumn(2).setPreferredWidth(100);

				table.getColumnModel().getColumn(3).setPreferredWidth(80);

				table.getColumnModel().getColumn(4).setPreferredWidth(120);

				table.getColumnModel().getColumn(5).setPreferredWidth(90);

				table.getColumnModel().getColumn(6).setPreferredWidth(120);
				
				table.getColumnModel().getColumn(7).setPreferredWidth(75);
				
				table.getColumnModel().getColumn(8).setPreferredWidth(100);

				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				/**/
				table.addMouseMotionListener(new MouseMotionListener() {

				    @Override

				    public void mouseMoved(MouseEvent e) {

				      Point p = e.getPoint();

				      hoveredRow = table.rowAtPoint(p);

				      hoveredColumn = table.columnAtPoint(p);

				      table.setRowSelectionInterval(hoveredRow, hoveredRow);

				      table.repaint();   

				    }

				    @Override

				    public void mouseDragged(MouseEvent e) {

				      hoveredRow = hoveredColumn = -1;

				      table.repaint();

				    }

				  });
				
				 //No se pueda editar

				  table.setDefaultEditor(Object.class, null);
				
		
		lista();

	}

	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText(String.valueOf(""));
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtPais.setText("");
		txtFecha.setText(String.valueOf(""));
		txtNombre.requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresarJButton(e);
		}
	}
	protected void actionPerformedBtnIngresarJButton(ActionEvent e) {
		insertar();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualizar();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		eliminar();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
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
	protected void mouseClickedTableJTable(MouseEvent e) {
		buscar();
	}
	
	void lista() {
		
		DefaultTableModel ptm = (DefaultTableModel) table.getModel();
		ptm.setRowCount(0);
		
		ProveedorModel p = new ProveedorModel();
		List<Proveedor> lista= p.listaProveedor();
		
		for(Proveedor x: lista) {
			Object[] fila= {x.getIdproveedor(),x.getNombres(),x.getApellidos(),x.getDni(),x.getDireccion(),x.getTelefono(),x.getCorreo(),x.getPais(),x.getFechaRegistro()};
			ptm.addRow(fila);
		}
		
	}
	
	void buscar() {
		
		int fila = table.getSelectedRow();
		
		idSeleccionado =(Integer)table.getValueAt(fila, 0);
		String nom =(String)table.getValueAt(fila, 1);
		String ape =(String)table.getValueAt(fila, 2);
		String dni =(String)table.getValueAt(fila, 3);
		String dire =(String)table.getValueAt(fila, 4);
		String tele =(String)table.getValueAt(fila, 5);
		String correo =(String)table.getValueAt(fila, 6);
		String pais =(String)table.getValueAt(fila, 7);
		Date fech=(Date)table.getValueAt(fila, 8);
		
		txtNombre.setText(nom);
		txtApellido.setText(ape);
		txtDni.setText(String.valueOf(dni));
		txtDireccion.setText(dire);
		txtTelefono.setText(tele);
		txtCorreo.setText(correo);
		txtPais.setText(pais);
		txtFecha.setText(String.valueOf(fech));
		
	}
	
	void insertar() {
		String nom= txtNombre.getText();
		String ape= txtApellido.getText();
		String dni= txtDni.getText();
		String dire= txtDireccion.getText();
		String tele= txtTelefono.getText();
		String correo= txtCorreo.getText();
		String pais= txtPais.getText();
		String fech= txtFecha.getText();
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
			return;
		}
		
		if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		
		if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni es de 8 digitos");
			return;
		}
		
		
		if (!tele.matches(Validaciones.NUMERO)) {
			mensaje("Ingresa un telefono de 9 digitos");
			return;
		}
		
		if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Ingresa un correo valido");
			return;
		}
		
		if (!pais.matches(Validaciones.TEXTO)) {
			mensaje("Ingresa un pais");
			return;
		}
		
		if (!fech.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Proveedor obj = new Proveedor();
		obj.setNombres(nom);
		obj.setApellidos(ape);
		obj.setDni(dni);
		obj.setDireccion(dire);
		obj.setTelefono(tele);
		obj.setCorreo(correo);
		obj.setPais(pais);
		obj.setFechaRegistro(Date.valueOf(fech));
		
		ProveedorModel model= new ProveedorModel();
		int p = model.insertarProveedor(obj);
		
		if(p>0) {

			lista();
			limpiarCajasTexto();
			mensaje("Se registro correctamente");
		}else {
			mensaje("Error en el registro");
		}
		
	}
	
	void actualizar() {
		String nom= txtNombre.getText();
		String ape= txtApellido.getText();
		String dni= txtDni.getText();
		String dire= txtDireccion.getText();
		String tele= txtTelefono.getText();
		String correo= txtCorreo.getText();
		String pais= txtPais.getText();
		String fech= txtFecha.getText();
		
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila de la tabla");
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
		
		if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni es de 8 digitos");
			return;
		}
		
		if (!tele.matches(Validaciones.NUMERO)) {
			mensaje("Ingresa un telefono de 9 digitos");
			return;
		}
		
		if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Ingresa un correo valido");
			return;
		}
		
		if (!pais.matches(Validaciones.TEXTO)) {
			mensaje("Ingresa un pais");
			return;
		}
		
		if (!fech.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Proveedor obj = new Proveedor();
		obj.setIdproveedor(idSeleccionado);
		obj.setNombres(nom);
		obj.setApellidos(ape);
		obj.setDni(dni);
		obj.setDireccion(dire);
		obj.setTelefono(tele);
		obj.setCorreo(correo);
		obj.setPais(pais);
		obj.setFechaRegistro(Date.valueOf(fech));
		
		ProveedorModel model= new ProveedorModel();
		int p = model.actualizaProveedor(obj);
		
		if(p>0) {
			idSeleccionado=-1;
			lista();
			limpiarCajasTexto();
			mensaje("Se actualizo correctamente");
		}else {
			mensaje("Error en la actualizacion");
		}
		
	}
	
	void eliminar() {
		if (idSeleccionado ==-1) {
			mensaje("SELECCIONA UNA FILA");
		}
		else {
			ProveedorModel model= new ProveedorModel();
			int p =model.eliminarProveedor(idSeleccionado);
			if(p>0) {
				idSeleccionado = -1;
				lista();
				limpiarCajasTexto();
				mensaje("Eliminación exitosa");
			}
			else {
				mensaje("Error en la eliminación");
			}
		}
		
		}
	}
	


