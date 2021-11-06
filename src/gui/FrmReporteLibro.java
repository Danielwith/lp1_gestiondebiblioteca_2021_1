package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmReporteLibro extends JInternalFrame {

	private static final long serialVersionUID = 1L;


	public FrmReporteLibro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte Libro");
		setBounds(100, 100, 1000, 550);


	}

}
