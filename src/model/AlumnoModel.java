package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.RegistroAlumno;
import util.MiConexion;

public class AlumnoModel {
	
	public int insertarAlumno(RegistroAlumno obj) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = new MiConexion().getConexion();
			
			
			String sql = "Insert into alumno values(null,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombres());
			psmt.setString(2, obj.getApellido());
			psmt.setInt(3, obj.getDni());
			psmt.setString(4, obj.getCorreo());
			psmt.setDate(5, obj.getFechanacimiento());
			psmt.setDate(6, obj.getFecharegistro()); 
			
			
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
