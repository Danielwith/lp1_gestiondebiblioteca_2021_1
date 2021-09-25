package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class FrmRegistroAlumno extends JInternalFrame  {

	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroAlumno frame = new FrmRegistroAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public FrmRegistroAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Alumno");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);

		

	}


	
	

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
}
