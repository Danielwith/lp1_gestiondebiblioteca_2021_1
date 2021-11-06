package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmConsultaLibro extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmConsultaLibro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Libro");
		setBounds(100, 100, 1000, 550);


	}

}
