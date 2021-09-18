package inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidad.Usuario;
import model.UsuarioModel;
import util.DatosGlobales;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class FrmLogin extends JDialog implements ActionListener{
	
	public JLabel lblLogin, lblClave;
	public JTextField txtLogin;
	public JPasswordField txtClave;
	public JButton btnEnviar, btnLimpiar;
	private UsuarioModel model = new UsuarioModel();
	public FrmPrincipal frm;
	
	
	public FrmLogin(FrmPrincipal frm) {
		getContentPane().setBackground(new Color(44,62,80));
			this.frm = frm;
			
			getContentPane().setLayout(null);
			this.setSize(340, 200);
			this.setLocationRelativeTo(null);
		    this.setTitle("Sistema de gestión de biblioteca");
		    
			lblLogin = new JLabel("Username:");
			lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLogin.setForeground(new Color(255, 255, 255));
			lblLogin.setBounds(50,15,100,25);
			getContentPane().add(lblLogin);
			
			txtLogin = new JTextField("luis");
			txtLogin.setBackground(new Color(108, 122, 137));
			txtLogin.setBounds(147,15,144,25);
			txtLogin.addActionListener(this);
			getContentPane().add(txtLogin);
			
			lblClave = new JLabel("Password:");
			lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblClave.setForeground(new Color(255, 255, 255));
			lblClave.setBounds(50,47,100,25);
			getContentPane().add(lblClave);
			
			txtClave = new JPasswordField("luis");
			txtClave.setBackground(new Color(108, 122, 137));
			txtClave.addActionListener(this);
			txtClave.setBounds(147,47,144,25);
			getContentPane().add(txtClave);
			
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBackground(Color.WHITE);
			btnEnviar.addActionListener(this);
			btnEnviar.setBounds(36,96,255,25);
			getContentPane().add(btnEnviar);
			
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setBackground(Color.WHITE);
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(114,125,100,25);
			getContentPane().add(btnLimpiar);
			
			
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnEnviar || e.getSource()== txtLogin || e.getSource() == txtClave){
				
				String login = txtLogin.getText().trim();
				String clave = new String(txtClave.getPassword());
				
				Usuario bean =  model.valida(login, clave);
				
				
				if(bean!= null){
					DatosGlobales.ID_USUARIO = bean.getIdUsuario();
					frm.setVisible(true);
					this.setVisible(false);
					frm.muestraOpciones();
				}else{
					JOptionPane.showMessageDialog(this, "Usuario no valido");
				}
				
			}
			if(e.getSource() == btnLimpiar){
				txtLogin.setText("");
				txtClave.setText("");
				txtLogin.requestFocus();
			}
		
	}
	

	public void windowDeactivated(WindowEvent e) {}

	

}





