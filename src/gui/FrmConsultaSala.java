package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Sala;
import model.SalaModel;
import util.Validaciones;

import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaSala extends JInternalFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnFiltrar;
	private JTextField txtNumero;


	public FrmConsultaSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Sala");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta Sala por N\u00FAmero");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(401, 47, 330, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 101, 75, 27);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 166, 886, 324);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "N\u00FAmero", "Piso", "Capacidad", "Recursos", "Estado", "Fecha registro"
			}
		));
		scrollPane.setViewportView(table);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(784, 105, 151, 23);
		getContentPane().add(btnFiltrar);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(134, 106, 210, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		//1 Se obtiene los datos
				String Numero = txtNumero.getText().trim();

				//validadciones

				//invocar al model del jtable
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				//traer la data de la tabla Docente
				SalaModel m = new SalaModel();
				List<Sala> lista = m.listaSalaPorNumero(Numero);
				//pasamos la data de lista al dtm del jtable
				for (Sala x : lista) {
					Object[] fila = {x.getIdSala(),x.getNumero(),x.getPiso(),x.getCapacidad(),x.getRecursos(),x.getEstado(),x.getFechaRegistro()};
					dtm.addRow(fila);
				}
	}
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
}
