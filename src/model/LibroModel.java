package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Libro;
import util.MySqlDBConexion;


public class LibroModel {
	
	private static final Logger log = Logger.getLogger(Libro.class.getName());
	
	public int nuevoLibro(Libro obj) {
		int salida=-1;
		Connection conn = null;
		PreparedStatement pstm=null;
		try {
			conn=MySqlDBConexion.getConexion();
			
			String sql="INSERT INTO libro VALUES(null,?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getTitulo());
			pstm.setString(2, obj.getAnio());
			pstm.setString(3,obj.getCategoria());
			pstm.setString(4, obj.getSerie());
			pstm.setDate(5, obj.getFechaRegistro());
			pstm.setString(6, obj.getPais());
			
			log.info(">>>" + pstm);

			salida = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}	
		}
		return salida;
	}
	
	public int eliminarLibro(int idLibro) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "DELETE FROM libro WHERE idLibro = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idLibro);
			log.info("SQL -> " + pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public int actualizarLibro(Libro obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "UPDATE libro SET titulo = ?, anio = ?, categoria = ?, serie = ?, fechaRegistro = ?, pais = ?  WHERE idLibro = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getTitulo());
			pstm.setString(2, obj.getAnio());
			pstm.setString(3, obj.getCategoria());
			pstm.setString(4, obj.getSerie());
			pstm.setDate(5,obj.getFechaRegistro());
			pstm.setString(6,obj.getPais());
			pstm.setInt(7, obj.getIdLibro());
			
			log.info("SQL -> " + pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public List<Libro> listarLibro() {
		ArrayList<Libro> lista=new ArrayList<Libro>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "SELECT * FROM libro";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL -> " + pstm);
			
			rs = pstm.executeQuery();
			Libro obj=null;
			while(rs.next()) {
				obj=new Libro();
				obj.setIdLibro(rs.getInt(1));
				obj.setTitulo(rs.getString(2));
				obj.setAnio(rs.getString(3));
				obj.setCategoria(rs.getString(4));
				obj.setSerie(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setPais(rs.getString(7));
				lista.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return lista;
	}
	
	public List<Libro> listarLibrosPorNombre(String nombre){
		ArrayList<Libro> lista = new ArrayList<Libro>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from libro where titulo like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre+"%");
			System.out.println("SQL -> " + pstm);
			
			rs = pstm.executeQuery();
			Libro obj = null;
			while(rs.next()) {
				obj = new Libro();
				obj.setIdLibro(rs.getInt(1));
				obj.setTitulo(rs.getString(2));
				obj.setAnio(rs.getString(3));
				obj.setCategoria(rs.getString(4));
				obj.setSerie(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setPais(rs.getString(7));
				lista.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return lista;
	}
}
