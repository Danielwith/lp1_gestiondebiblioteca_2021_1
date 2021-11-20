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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.RegistrarUsuario;
import model.RegistroUsuarioModel;
import util.Validaciones;

public class FrmCrudUsuario  extends JInternalFrame implements MouseListener, ActionListener  {

	private static final long serialVersionUID = 1L;
	private JTextField txtNoUsuario;
	private JTextField txtApeUsuario;
	private JTextField txtFeNacimiento;
	private JTextField txtLogin;
	private JTextField txtContra;
	private JTextField txtCorreo;
	private JTextField txtDirec;
	private JTextField txtDNI;
	private JTable table;
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private int idSeleccionado = -1;
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
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Usuario");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(327, 11, 254, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 61, 142, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido de Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 100, 142, 19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(23, 130, 164, 27);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(351, 65, 55, 21);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contrase\u00F1a");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(351, 96, 96, 26);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Correo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(351, 136, 49, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Direcci\u00F3n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(651, 65, 71, 21);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("DNI");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(651, 102, 49, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtNoUsuario = new JTextField();
		txtNoUsuario.setBounds(175, 67, 142, 20);
		getContentPane().add(txtNoUsuario);
		txtNoUsuario.setColumns(10);
		
		txtApeUsuario = new JTextField();
		txtApeUsuario.setBounds(175, 101, 142, 20);
		getContentPane().add(txtApeUsuario);
		txtApeUsuario.setColumns(10);
		
		txtFeNacimiento = new JTextField();
		txtFeNacimiento.setBounds(175, 135, 142, 20);
		getContentPane().add(txtFeNacimiento);
		txtFeNacimiento.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(452, 67, 129, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setBounds(452, 101, 129, 20);
		getContentPane().add(txtContra);
		txtContra.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(452, 135, 194, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtDirec = new JTextField();
		txtDirec.setBounds(733, 67, 147, 20);
		getContentPane().add(txtDirec);
		txtDirec.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(730, 101, 150, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 870, 255);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido", "DNI", "Login", "Password", "Correo", "FechaNacimiento", "Direcci\u00F3n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(82);
		table.getColumnModel().getColumn(7).setPreferredWidth(97);
		
		//No se pueda editar

		  table.setDefaultEditor(Object.class, null);
		
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
		
		//tamano de la fila	

				table.getColumnModel().getColumn(0).setPreferredWidth(15);

				table.getColumnModel().getColumn(1).setPreferredWidth(120);

				table.getColumnModel().getColumn(2).setPreferredWidth(120);

				table.getColumnModel().getColumn(3).setPreferredWidth(50);

				table.getColumnModel().getColumn(4).setPreferredWidth(50);

				table.getColumnModel().getColumn(5).setPreferredWidth(90);

				table.getColumnModel().getColumn(6).setPreferredWidth(120);
				
				table.getColumnModel().getColumn(7).setPreferredWidth(90);
				
				table.getColumnModel().getColumn(8).setPreferredWidth(90);

				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				//alineación

				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();

				rightRenderer.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);

				table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
				
				table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
				
				table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
				
				table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
				
		
		//selecciona una sola fila

		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);				
		scrollPane.setViewportView(table);
		
		//desabilita mover las columnas

		table.getTableHeader().setReorderingAllowed(false);
		
		//color de la fila seleccionada

		table.setSelectionBackground(Color.RED);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(247, 468, 89, 23);
		getContentPane().add(btnIngresar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(373, 468, 104, 23);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(511, 468, 89, 23);
		getContentPane().add(btnEliminar);

		listar();

	}

	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	void limpiarCajasTexto() {
		txtNoUsuario.setText("");
		txtApeUsuario.setText("");
		txtDNI.setText("");
		txtFeNacimiento.setText("");
		txtLogin.setText("");
		txtContra.setText("");
		txtCorreo.setText("");
		txtDirec.setText("");
		txtNoUsuario.requestFocus();
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
		busca();
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
		inserta();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualiza();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		elimina();
	}
	
	public void listar() {
		RegistroUsuarioModel m = new RegistroUsuarioModel();
		List<RegistrarUsuario> lista = m.listaUsuario();
		
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        dtm.setRowCount(0);
		
		for (RegistrarUsuario x : lista) {
			Object[] fila = {x.getIdUsuario(),x.getNombreUsuario(),x.getApellidoUsuario(),
					x.getDNI(),x.getLogin(),x.getPassword(),x.getCorreo(),x.getFechaNacimientoUsuario(),x.getDirección()};
			
			dtm.addRow(fila);
		}
	}
	public void busca() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nom =(String)table.getValueAt(fila, 1);
		String ape =(String)table.getValueAt(fila, 2);
		Integer dni =(Integer)table.getValueAt(fila, 3);
		String log =(String)table.getValueAt(fila, 4);
		String pass =(String)table.getValueAt(fila, 5);
		String corr =(String)table.getValueAt(fila, 6);
		Date fec =(Date)table.getValueAt(fila, 7);
		String direc =(String)table.getValueAt(fila, 8);
		
		txtNoUsuario.setText(nom);
		txtApeUsuario.setText(ape);
		txtDNI.setText(String.valueOf(dni));
		txtFeNacimiento.setText(String.valueOf(fec));
		txtLogin.setText(log);
		txtContra.setText(pass);
		txtCorreo.setText(corr);
		txtDirec.setText(direc);
	}
	public void inserta() {
		String nom = txtNoUsuario.getText();
		String ape= txtApeUsuario.getText();
		String fec = txtFeNacimiento.getText();
		String log = txtLogin.getText();
		String pass = txtContra.getText();
		String corr = txtCorreo.getText();
		String direc = txtDirec.getText();
		String dni = txtDNI.getText();
		
		// Validaciones
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 3 a 30 caracteres");
			return;
		}
		if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
			return;
		}
		if (!fec.matches(Validaciones.FECHA)) {
			mensaje("El formato de fecha es yyyy-MM-dd");
			return;
		}
		if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI tiene que tener 8 caracteres");
			return;
		}
		if (!corr.matches(Validaciones.CORREO)) {
			mensaje("El Correo es con formato @gmail.com");
			return;
		}

		RegistrarUsuario obj = new RegistrarUsuario();

		obj.setNombreUsuario(nom);
		obj.setApellidoUsuario(ape);
		obj.setDNI(Integer.parseInt(dni));
		obj.setLogin(log);
		obj.setPassword(pass);
		obj.setCorreo(corr);
		obj.setFechaNacimientoUsuario(Date.valueOf(fec));
		obj.setDirección(direc);

		RegistroUsuarioModel model = new RegistroUsuarioModel();
		int salida = model.insertaUsuario(obj);
		if (salida > 0) {
			listar();
			limpiarCajasTexto();
			mensaje("Inserta exitoso");
		} else {
			mensaje("Error en el registro");
		}
	}
	
	public void actualiza() {
		if(idSeleccionado == -1) {
    		mensaje("Seleccione una fila");
    	}else {
    		String nom = txtNoUsuario.getText();
    		String ape= txtApeUsuario.getText();
    		String fec = txtFeNacimiento.getText();
    		String log = txtLogin.getText();
    		String pass = txtContra.getText();
    		String corr = txtCorreo.getText();
    		String direc = txtDirec.getText();
    		String dni = txtDNI.getText();
    		
        	if(!nom.matches(Validaciones.TEXTO)) {
        		mensaje("Nombre es de 2 a 20 caracteres");
        		return;
        	}
        	if(!ape.matches(Validaciones.TEXTO)) {
        		mensaje("Nombre es de 2 a 20 caracteres");
        		return;
        	}
        	if(!fec.matches(Validaciones.FECHA)) {
        		mensaje("La fecha tiene formato YYYY-MM-dd");
        		return;
        	}
        	
        	RegistrarUsuario obj = new RegistrarUsuario();
        	
        	obj.setIdUsuario(idSeleccionado);
    		obj.setNombreUsuario(nom);
    		obj.setApellidoUsuario(ape);
    		obj.setDNI(Integer.parseInt(dni));
    		obj.setLogin(log);
    		obj.setPassword(pass);
    		obj.setCorreo(corr);
    		obj.setFechaNacimientoUsuario(Date.valueOf(fec));
    		obj.setDirección(direc);
        	
    		RegistroUsuarioModel model = new RegistroUsuarioModel();
    		
    		int salida = model.actualizaUsuario(obj);
    		
    		if (salida > 0) {
    			listar();
    			limpiarCajasTexto();
    			mensaje("Actualizacion exitoso");
    		} else {
    			mensaje("Error en la actualización");
    		}
		
    	}
	}
	public void elimina() {
		if(idSeleccionado == -1) {
    		mensaje("Seleccione una fila");
    	}else {
    		RegistroUsuarioModel m = new RegistroUsuarioModel();
        	int s = m.eliminarUsuario(idSeleccionado);
        	if(s>0) {
        		mensaje("Se eliminó correctamente");
        		listar();
        		limpiarCajasTexto();
        		idSeleccionado = -1;
        	}else {
        		mensaje("Error al eleiminar");
        	}
    	}
	}
}


