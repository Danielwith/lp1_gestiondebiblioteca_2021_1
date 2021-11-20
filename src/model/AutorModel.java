package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import entidad.Autor;

import util.MiConexion;
import util.MySqlDBConexion;

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
			psmt.setString(4, obj.getNacionalidad());
			psmt.setString(5, obj.getGrado());

		
			
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
	
	
	/**********************************************/
	
	public int eliminarAutor(int idCodigo) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = new MiConexion().getConexion();
			
			
			String sql = "delete from autor where idAutor=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idCodigo);
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
	
	/**********************************************/
	
	public List<Autor> listaAutor() {
		ArrayList<Autor> salida = new  ArrayList<Autor>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		
		try {
			
			con = MySqlDBConexion.getConexion();
			
			String sql = "select * from autor";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL -- >" + pstm);
			
				
			rs = pstm.executeQuery();
			Autor obj = null;
			while (rs.next()) {
				obj = new Autor();
				obj.setIdCodigo(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setFechaNacimiento(rs.getDate(4));
				obj.setFechaRegistro(rs.getDate(5));
				obj.setNacionalidad(rs.getString(6));
				obj.setGrado(rs.getString(7));
				
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
	
	public int actualizaAutor(Autor obj) {
		int salida= -1;
		
		Connection conn = null;
		PreparedStatement  psmt = null;
		
		try {
			
			conn = MySqlDBConexion.getConexion();
			
			
			String sql = "update autor set nombres=?, apellidos=?, fechaNacimiento=?, fechaRegistro=?, nacionalidad=?, grado=?  where idAutor=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, obj.getNombres());
			psmt.setString(2, obj.getApellidos());
			psmt.setDate(3, obj.getFechaNacimiento());
			psmt.setDate(4, obj.getFechaRegistro());
			psmt.setString(5, obj.getNacionalidad());
			psmt.setString(6, obj.getGrado());
			psmt.setInt(7, obj.getIdCodigo());
			
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
	
	public List<Autor> listaAutorPorNombre(String filtro) {
		ArrayList<Autor> salida = new  ArrayList<Autor>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		
		try {
			
			con = MySqlDBConexion.getConexion();
			
			String sql = "select * from autor where nombres like ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			
			System.out.println("SQL -- >" + pstm);
			
				
			rs = pstm.executeQuery();
			
			Autor obj = null;
			while (rs.next()) {
				obj = new Autor();
				
				obj.setIdCodigo(rs.getInt("idAutor"));
				obj.setNombres(rs.getString("nombres"));
				obj.setApellidos(rs.getString("apellidos"));
				obj.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				obj.setFechaRegistro(rs.getDate("fechaRegistro"));
				obj.setNacionalidad(rs.getString("nacionalidad"));
				obj.setGrado(rs.getString("grado"));
				
				/*obj.setIdCodigo(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setFechaNacimiento(rs.getDate(4));
				obj.setFechaRegistro(rs.getDate(5));
				obj.setNacionalidad(rs.getString(6));
				obj.setGrado(rs.getString(7));*/
				
				salida.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	return salida;

	}
	
}
