package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Proveedor;
import model.ProveedorModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class FrmReporteProveedor extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JPanel pnlReporte;
	private JButton btnBuscar;
	private JButton btnFiltrartodo;


	public FrmReporteProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Proveedor");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE PROVEEDOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(307, 26, 315, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(37, 86, 73, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(124, 84, 486, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(620, 83, 160, 23);
		getContentPane().add(btnBuscar);
		
		pnlReporte = new JPanel();
		pnlReporte.setBorder(new TitledBorder(null, "REPORTE", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnlReporte.setBounds(37, 122, 907, 387);
		getContentPane().add(pnlReporte);
		pnlReporte.setLayout(new BorderLayout(0, 0));
		
		btnFiltrartodo = new JButton("Filtrar todo");
		btnFiltrartodo.addActionListener(this);
		btnFiltrartodo.setBounds(790, 83, 154, 23);
		getContentPane().add(btnFiltrartodo);
		
	}
	
	void limpiarCajasTexto() {
		txtFiltro.setText("");
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrartodo) {
			actionPerformedBtnNewButtonJButton(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String nombre= txtFiltro.getText();
		
		if (!nombre.matches(Validaciones.TEXTOPROV)) {
			mensaje("Ingresa una letra o un nombre");
			return;
		}
		
		ProveedorModel p =new ProveedorModel();
		List<Proveedor> lstProveedor=p.listaProveedorPorNombre(nombre);
		
		// 1 La data
		JRBeanCollectionDataSource dataSource	= new JRBeanCollectionDataSource(lstProveedor);
				
		//2 el diseño del reporte
		String file = "reportaProveedor.jasper";
				
		//3 se genera el reporte
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);
				
		//4 se muestra el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);
				
		//5 Se añade el visor al panel
		pnlReporte.removeAll();
		pnlReporte.add(jRViewer);
		pnlReporte.repaint();
		pnlReporte.revalidate();
		
		limpiarCajasTexto();
				
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
        
		String nombre= txtFiltro.getText();

		ProveedorModel p =new ProveedorModel();
		List<Proveedor> lstProveedor=p.listaProveedorPorNombre(nombre);
		
		// 1 La data
		JRBeanCollectionDataSource dataSource	= new JRBeanCollectionDataSource(lstProveedor);
				
		//2 el diseño del reporte
		String file = "reportaProveedor.jasper";
				
		//3 se genera el reporte
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);
				
		//4 se muestra el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);
				
		//5 Se añade el visor al panel
		pnlReporte.removeAll();
		pnlReporte.add(jRViewer);
		pnlReporte.repaint();
		pnlReporte.revalidate();
		
	}
}
