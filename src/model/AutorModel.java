package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Autor;
import util.MiConexion;

public class AutorModel {
	
	public int insertarAutor(Autor obj) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = new MiConexion().getConexion();
			
			
			String sql = "Insert into autor values(null,?,?,?,curtime(),?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombres() );
			psmt.setString(2, obj.getApellidos());
			psmt.setDate(3, obj.getFechaNacimiento());
			psmt.setString(5, obj.getNacionalidad());
			psmt.setInt(4, obj.getGrado());

		
			
			salida = psmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
 				
			} catch (Exception e2) {
				
			}
		} 
		
		return salida;
		
	}
}
