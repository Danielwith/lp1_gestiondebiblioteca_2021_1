package gui;

import javax.swing.JFrame;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.RegistrarUsuario;
import model.RegistroUsuarioModel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reporte.GeneradorReporte;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;

public class FrmReporteUsuario extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField txtNoUsu;
	private JPanel panelReporte;

	public FrmReporteUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Usuario");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTA DE USUARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(348, 11, 334, 54);
		getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("FILTRAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(435, 65, 255, 33);
		getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 75, 168, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNoUsu = new JTextField();
		txtNoUsu.setBounds(158, 72, 233, 20);
		getContentPane().add(txtNoUsu);
		txtNoUsu.setColumns(10);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "REPORTES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "REPORTES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "REPORTES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReporte.setBounds(10, 109, 895, 401);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		String filtro = txtNoUsu.getText();
		RegistroUsuarioModel model = new RegistroUsuarioModel();
		List<RegistrarUsuario> data = model.listaUsuarioPorNomre(filtro);
		
		// 1 La data
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
				
				String file ="ReporteUsuario.jasper";
				
				// 3 Se genera el reporte
				JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);

				// 4 Se muestra en el visor
				JRViewer jRViewer = new JRViewer(jasperPrint);
				
				// 5 Se añade el visor al panel
				panelReporte.removeAll();
				panelReporte.add(jRViewer);
				panelReporte.repaint();
				panelReporte.revalidate();
	}
}
