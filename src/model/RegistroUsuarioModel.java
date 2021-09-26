package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.RegistrarUsuario;
import util.MiConexion;


public class RegistroUsuarioModel {
	
	private static final Logger log = Logger.getLogger(RegistrarUsuario.class.getName());
	
	public int insertaUsuario(RegistrarUsuario obj) {
		int salida = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = new MiConexion().getConexion();
			
			String sql = "insert into usuario values(null,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombreUsuario());
			psmt.setString(2, obj.getApellidoUsuario());
			psmt.setInt(3, obj.getDNI());
			psmt.setString(4, obj.getLogin());
			psmt.setString(5, obj.getPassword());
			psmt.setString(6, obj.getCorreo());
			psmt.setDate(7, obj.getFechaNacimientoUsuario());
			psmt.setString(8, obj.getDirección());
			
			
			
			log.info(">>> " + psmt);
			salida = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
}
