package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Sala;
import model.SalaModel;
import util.Validaciones;

public class FrmCrudSala  extends JInternalFrame implements ActionListener, MouseListener  {

	private static final long serialVersionUID = 1L;
	private JLabel lblFechaRegistro;
	private JTextField txtNumero;
	private JTextField txtPiso;
	private JTextField txtCapacidad;
	private JTextField txtRecursos;
	private JTextField txtEstado;
	private JTextField txtFechaRegistro;
	private JTable table;
	private JButton btnInsertar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private int idSeleccionado=-1;


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
	public FrmCrudSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Sala");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoDeSala = new JLabel("Mantenimiento de Sala");
		lblMantenimientoDeSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeSala.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeSala.setBounds(101, 37, 641, 38);
		getContentPane().add(lblMantenimientoDeSala);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(117, 115, 46, 14);
		getContentPane().add(lblNumero);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(117, 158, 46, 14);
		getContentPane().add(lblPiso);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(117, 197, 62, 14);
		getContentPane().add(lblCapacidad);
		
		JLabel lblRecursos = new JLabel("Recursos");
		lblRecursos.setBounds(427, 115, 46, 14);
		getContentPane().add(lblRecursos);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(427, 158, 46, 14);
		getContentPane().add(lblEstado);
		
		lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setBounds(427, 197, 86, 14);
		getContentPane().add(lblFechaRegistro);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(192, 112, 86, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(192, 155, 86, 20);
		getContentPane().add(txtPiso);
		txtPiso.setColumns(10);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setBounds(192, 194, 86, 20);
		getContentPane().add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		txtRecursos = new JTextField();
		txtRecursos.setBounds(549, 112, 86, 20);
		getContentPane().add(txtRecursos);
		txtRecursos.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(549, 155, 86, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setBounds(549, 194, 86, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(752, 111, 89, 23);
		getContentPane().add(btnInsertar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(752, 154, 89, 23);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(752, 193, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 232, 818, 261);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Numero", "Piso", "Capacidad", "Recursos", "Estado", "Fecha Registro"
			}
		));
		scrollPane.setViewportView(table);

		lista();

	}

	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	void limpiarCajasTexto() {
		txtNumero.setText("");
		txtPiso.setText("");
		txtCapacidad.setText("");
		txtRecursos.setText("");
		txtEstado.setText("");
		txtFechaRegistro.requestFocus();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnInsertar) {
			actionPerformedBtnInsertarJButton(e);
		}
	}
	protected void actionPerformedBtnInsertarJButton(ActionEvent e) {
		inserta();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualiza();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		elimina();
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
	
	public void lista() {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		
		SalaModel m= new SalaModel();
		List<Sala> lista= m.listaSala();
		
		for(Sala x: lista) {
			Object[] fila= {x.getIdSala(), x.getNumero(), x.getPiso(), x.getCapacidad(),x.getRecursos(),x.getEstado(),x.getFechaRegistro()};
			dtm.addRow(fila);
		}
	}
	public void busca() {
		int fila =table.getSelectedRow();
		idSeleccionado=(Integer)table.getValueAt(fila, 0);
		String num=(String)table.getValueAt(fila, 1);
	    int piso=(Integer)table.getValueAt(fila, 2);
		String capac=(String)table.getValueAt(fila, 3);
		String recur=(String)table.getValueAt(fila, 4);
		int estado=(Integer)table.getValueAt(fila, 5);
		Date fecha=(Date)table.getValueAt(fila, 6);
		
		txtNumero.setText(num);
		txtPiso.setText(String.valueOf(piso));
        txtCapacidad.setText(capac);
		txtRecursos.setText(recur);
        txtEstado.setText(String.valueOf(estado));
		txtFechaRegistro.setText(String.valueOf(fecha));
	}
	public void inserta() {
		String num = txtNumero.getText();
		String piso = txtPiso.getText();
		String capac = txtCapacidad.getText();
		String recur=txtRecursos.getText();
		String estado=txtEstado.getText();
		String fecha=txtFechaRegistro.getText();
		

		if(!recur.matches(Validaciones.TEXTO)) {
			mensaje("LOS RECURSOS ES DE 2 A 30 CARACTERES");
			return;
		}
		
		if(!fecha.matches(Validaciones.FECHA)) {
			mensaje("LA FECHA ES DE FORMATO YYYY-MM-DD");
			return;
		}
		
		if (!fecha.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Sala obj = new Sala();
		obj.setNumero(num);
		obj.setPiso(Integer.parseInt(piso));
		obj.setCapacidad(capac);
		obj.setRecursos(recur);
		obj.setEstado(Integer.parseInt(estado));
		obj.setFechaRegistro(Date.valueOf(fecha));
		
		SalaModel model = new SalaModel();
		int s = model.insertaSala(obj);
		if(s>0) {
			lista();
			limpiarCajasTexto();
			mensaje("Registro exitoso");
		}else {
			mensaje("Error en el registro");
		}
	}
	public void elimina() {
		if(idSeleccionado==-1) {
			mensaje("Seleccione una fila");
		}else {
			SalaModel model = new SalaModel();
			int s = model.eliminaSala(idSeleccionado);
			if(s>0) {
				idSeleccionado =-1;
				lista();
				limpiarCajasTexto();
				mensaje("eliminacion exitosa");
			}else {
				mensaje("Error en la eliminacion");
			}
		}
	}
	public void actualiza() {
		String num = txtNumero.getText();
		String piso = txtPiso.getText();
		String capac = txtCapacidad.getText();
		String recur=txtRecursos.getText();
		String estado=txtEstado.getText();
		String fecha=txtFechaRegistro.getText();
		
		if(idSeleccionado==-1) {
			mensaje("Seleccione una fila de la tabla");
			return;
		}

		if(!recur.matches(Validaciones.TEXTO)) {
			mensaje("LOS RECURSOS ES DE 2 A 30 CARACTERES");
			return;
		}
		
		if(!fecha.matches(Validaciones.FECHA)) {
			mensaje("LA FECHA ES DE FORMATO YYYY-MM-DD");
			return;
		}
		
		if (!fecha.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-dd");
			return;
		}
		
		Sala obj = new Sala();
		obj.setIdSala(idSeleccionado);
		obj.setNumero(num);
		obj.setPiso(Integer.parseInt(piso));
		obj.setCapacidad(capac);
		obj.setRecursos(recur);
		obj.setEstado(Integer.parseInt(estado));
		obj.setFechaRegistro(Date.valueOf(fecha));
		
		SalaModel model = new SalaModel();
		int s = model.actualizaSala(obj);
		if(s>0) {
			idSeleccionado=-1;
			lista();
			limpiarCajasTexto();
			mensaje("Registro exitoso");
		}else {
			mensaje("Error en el registro");
		}
	}

}


