package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmConsultaAlumno extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmConsultaAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Alumno");
		setBounds(100, 100, 1000, 550);


	}

}
