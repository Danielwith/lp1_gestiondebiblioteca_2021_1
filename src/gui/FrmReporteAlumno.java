package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.RegistroAlumno;

import java.util.List;

import model.AlumnoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FrmReporteAlumno extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JButton btnFiltrar;
	private JPanel pnlReporte;


	public FrmReporteAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Alumno");
		setBounds(100, 100, 1115, 586);
		getContentPane().setLayout(null);
		
		JLabel lblReporteDeNombre = new JLabel("Consulta de alumno por nombre");
		lblReporteDeNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReporteDeNombre.setBounds(97, 26, 751, 34);
		getContentPane().add(lblReporteDeNombre);
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(62, 97, 140, 14);
		getContentPane().add(lblNombre);
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(213, 97, 520, 20);
		getContentPane().add(txtFiltro);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(923, 96, 113, 21);
		getContentPane().add(btnFiltrar);
		
		pnlReporte = new JPanel();
		pnlReporte.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlReporte.setBounds(10, 121, 1083, 426);
		getContentPane().add(pnlReporte);
		pnlReporte.setLayout(new BorderLayout(0, 0));


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String filtro = txtFiltro.getText();
		
		
		AlumnoModel a = new  AlumnoModel();
		List<RegistroAlumno> listaalum = a.listaAlumnoPorConsultaNombre(filtro);	
		
		// 1 La data
		JRBeanCollectionDataSource dataSource	= new JRBeanCollectionDataSource(listaalum);
		
		//2 el diseño del reporte
		String file = "ReporteAlumnov.jasper";
		
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
