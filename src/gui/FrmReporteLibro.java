package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entidad.Libro;
import model.LibroModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

public class FrmReporteLibro extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JPanel	panelReporte;


	public FrmReporteLibro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Libro");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblReporteDeLibro = new JLabel("Reporte de Libro por Nombre");
		lblReporteDeLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeLibro.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblReporteDeLibro.setBounds(10, 30, 968, 49);
		getContentPane().add(lblReporteDeLibro);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 118, 127, 25);
		getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(160, 118, 653, 26);
		getContentPane().add(txtNombre);
		
		JButton btnReporte = new JButton("Generar Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReporte_actionPerformed(e);
			}
		});
		btnReporte.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReporte.setBounds(842, 110, 109, 40);
		getContentPane().add(btnReporte);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelReporte.setBounds(21, 160, 943, 335);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0,0));
	}
	
	protected void do_btnReporte_actionPerformed(ActionEvent e) {
		String nombre = txtNombre.getText();
		
		LibroModel model = new LibroModel();
		List<Libro> lista = model.listarLibrosPorNombre(nombre);
		
		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
		
		String file = "ReporteLibro.jasper";
		
		JasperPrint jPrint = GeneradorReporte.genera(file, data, null);
		
		JRViewer jView = new JRViewer(jPrint);
		
		panelReporte.removeAll();
		panelReporte.add(jView);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
