package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import entidad.RegistroAlumno;

import util.MiConexion;
import util.MySqlDBConexion;

public class AlumnoModel {
	
	//Insertar alumnos // 
	public int insertarAlumno(RegistroAlumno obj) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = new MiConexion().getConexion();
			
			
			String sql = "Insert into alumno values(null,?,?,?,?,?,curtime())";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombres());
			psmt.setString(2, obj.getApellido());
			psmt.setInt(3, obj.getDni());
			psmt.setString(4, obj.getCorreo());
			psmt.setDate(5, obj.getFechanacimiento());
		
			
			
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
	
	//Eliminar Alumno

	public int eliminarAlumno(int idAlumno ) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = new MiConexion().getConexion();
			
			
			String sql = "delete from alumno where idAlumno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idAlumno);
			System.out.println("SQL -> " + psmt);
			
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
	

	// Lista de alumnos
	public List<RegistroAlumno> listaAlumno() {
		ArrayList<RegistroAlumno> salida = new  ArrayList<RegistroAlumno>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; // trae la data de la BD
		
		try {
			
			con = MySqlDBConexion.getConexion();
			
			String sql = "select * from alumno";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL -- >" + pstm);
			
			// en rs se trae los datos de la BD segun el SQL	
			rs = pstm.executeQuery();
			RegistroAlumno obj = null;
			while (rs.next()) {
				obj = new RegistroAlumno();
				obj.setIdAlumno(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setCorreo(rs.getString(5));
				obj.setFechanacimiento(rs.getDate(6));
				salida.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if (con != null) con.close();
			} catch (Exception e2) {}
		}
	
	return salida;

}
	
	//Actualiza Alumno // 
		public int actualizaAlumno(RegistroAlumno obj) {
			int salida= -1;
			
			Connection conn = null;
			PreparedStatement  psmt = null;
			
			try {
				
				conn = MySqlDBConexion.getConexion();
				
				
				String sql = "update alumno set nombres=?, apellidos=?, dni=?, correo=?, fechaNacimiento=?  where idAlumno=?";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, obj.getNombres());
				psmt.setString(2, obj.getApellido());
				psmt.setInt(3, obj.getDni());
				psmt.setString(4, obj.getCorreo());
				psmt.setDate(5, obj.getFechanacimiento());
				psmt.setInt(6, obj.getIdAlumno());
				System.out.println("SQL -> " + psmt);
				
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
		
		//Consulta alumno
		public List<RegistroAlumno> listaAlumnoPorConsultaNombre(String filtro) {
			ArrayList<RegistroAlumno> salida = new  ArrayList<RegistroAlumno>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null; // trae la data de la BD
			
			try {
				
				con = MySqlDBConexion.getConexion();
				
				String sql = "select * from alumno where nombres like ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, filtro+"%");
				System.out.println("SQL -- >" + pstm);
				
				// en rs se trae los datos de la BD segun el SQL	
				rs = pstm.executeQuery();
				RegistroAlumno obj = null;
				while (rs.next()) {
					obj = new RegistroAlumno();
					obj.setIdAlumno(rs.getInt(1));
					obj.setNombres(rs.getString(2));
					obj.setApellido(rs.getString(3));
					obj.setDni(rs.getInt(4));
					obj.setCorreo(rs.getString(5));
					obj.setFechanacimiento(rs.getDate(6));
					salida.add(obj);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) pstm.close();
					if (con != null) con.close();
				} catch (Exception e2) {}
			}
		
		return salida;

	}
		
		

}
