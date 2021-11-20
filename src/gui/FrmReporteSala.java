package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Sala;
import model.SalaModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class FrmReporteSala extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnFiltrar;
	private JLabel lblNewLabel;


	public FrmReporteSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Sala");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Lista de Salas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(438, 36, 209, 37);
		getContentPane().add(lblNewLabel);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFiltrar.setBounds(438, 114, 189, 23);
		getContentPane().add(btnFiltrar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reportes", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(26, 166, 932, 343);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		SalaModel model= new SalaModel();
		List<Sala> data=model.listaSala();
		
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(data);
		
		String file="Reporte_Sala.jasper";
		
		JasperPrint jasperPrint=GeneradorReporte.genera(file, dataSource, null);
		
		JRViewer jRViewer=new JRViewer(jasperPrint);
		
		panel.removeAll();
		panel.add(jRViewer);
		panel.repaint();
		panel.revalidate();

	}
}
