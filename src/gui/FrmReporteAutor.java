package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

 
import entidad.Autor;
import model.AutorModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

import java.util.List;
import java.awt.BorderLayout;

public class FrmReporteAutor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JPanel panelReporte;
	private JButton btnFiltrar_1;


	public FrmReporteAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Autor");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombres");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre_1.setBounds(66, 115, 67, 20);
		getContentPane().add(lblNombre_1);
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(137, 114, 532, 27);
		getContentPane().add(txtFiltro);
		
		JLabel lblConsultaDeAutor = new JLabel("CONSULTA DE AUTOR POR NOMBRE");
		lblConsultaDeAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAutor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblConsultaDeAutor.setBounds(169, 36, 572, 36);;
		getContentPane().add(lblConsultaDeAutor);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reportes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(42, 163, 863, 325);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
		
		btnFiltrar_1 = new JButton("FILTRAR");
		btnFiltrar_1.addActionListener(this);
		btnFiltrar_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnFiltrar_1.setBounds(717, 108, 127, 33);
		getContentPane().add(btnFiltrar_1);


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar_1) {
			do_btnFiltrar_actionPerformed(e);
		}
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent e) {
		
		String filtro = txtFiltro.getText();
		
		AutorModel a = new AutorModel();
		List<Autor> lista = a.listaAutorPorNombre(filtro);
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(lista);
		
		String file = "Autor.jasper";
		
		JasperPrint jasperPrint = GeneradorReporte.genera(file, datasource, null);
		
		JRViewer jrviewer = new JRViewer(jasperPrint);
		
		panelReporte.removeAll();
		panelReporte.add(jrviewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		
		
	}
}














