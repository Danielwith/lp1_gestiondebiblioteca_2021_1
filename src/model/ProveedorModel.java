package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Proveedor;
import util.MiConexion;

public class ProveedorModel {

	public int insertarProveedor(Proveedor obj) {
		int salida= -1;
		
		Connection conn=null;
		PreparedStatement psnt = null;
	
		try {
			
			conn= new MiConexion().getConexion();
			
			String sql= "insert into proveedor values(null,?,?,?,?,?,?,?,?)";
			psnt = conn.prepareStatement(sql);
			psnt.setString(1, obj.getNombres());
			psnt.setString(2, obj.getApellidos());
			psnt.setString(3, obj.getDni());
			psnt.setString(4, obj.getDireccion());
			psnt.setString(5, obj.getTelefono());
			psnt.setString(6, obj.getCorreo());
			psnt.setString(7,obj.getPais());
			psnt.setDate(8, obj.getFechaRegistro());
			
			salida = psnt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		finally {
			try {
				
				if(psnt !=null) psnt.close();
				if(conn !=null) psnt.close();
				
			} catch (Exception e2) {
				
			}
		}
		return salida;
		
	}
	
	
	public int eliminarProveedor(int idProveedor) {
		int salida= -1;
		Connection conn=null;
		PreparedStatement psnt = null;
	
		try {
			
			conn= new MiConexion().getConexion();
			
			String sql= "delete from proveedor where idProveedor =?";
			psnt = conn.prepareStatement(sql);
			psnt.setInt(1, idProveedor);

			
			salida = psnt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		finally {
			try {
				
				if(psnt !=null) psnt.close();
				if(conn !=null) psnt.close();
				
			} catch (Exception e2) {
				
			}
		}
		return salida;
		
	}
	
	
	public int actualizaProveedor(Proveedor obj) {
		int salida= -1;
		Connection conn=null;
		PreparedStatement psnt = null;
	
		try {
			
			conn= new MiConexion().getConexion();
			
			String sql= "update proveedor set nombres=?, apellidos=?, dni=?, direccion=?, telefono=?,correo=?, pais=?, fechaRegistro=? where idProveedor=?";
			psnt = conn.prepareStatement(sql);
			
			psnt.setString(1, obj.getNombres());
			psnt.setString(2, obj.getApellidos());
			psnt.setString(3, obj.getDni());
			psnt.setString(4, obj.getDireccion());
			psnt.setString(5, obj.getTelefono());
			psnt.setString(6, obj.getCorreo());
			psnt.setString(7,obj.getPais());
			psnt.setDate(8, obj.getFechaRegistro());
			psnt.setInt(9,obj.getIdproveedor());
			
			salida = psnt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		finally {
			try {
				
				if(psnt !=null) psnt.close();
				if(conn !=null) psnt.close();
				
			} catch (Exception e2) {
				
			}
		}
		return salida;
		
	}
	
	
	public List<Proveedor> listaProveedor(){
		ArrayList<Proveedor> salida= new ArrayList<Proveedor>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn= new MiConexion().getConexion();
			
			String sql = "select * from proveedor";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL -> " + pstm);
			
			rs = pstm.executeQuery();
			Proveedor obj = null;
			while(rs.next()) {
				obj = new Proveedor();
				obj.setIdproveedor(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDni(rs.getString(4));
				obj.setDireccion(rs.getString(5));
				obj.setTelefono(rs.getString(6));
				obj.setCorreo(rs.getString(7));
				obj.setPais(rs.getString(8));
				obj.setFechaRegistro(rs.getDate(9));
				salida.add(obj);
			}} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (conn != null) conn.close();
				} catch (Exception e2) {}
			}
			return salida;
		}
	
	
	public List<Proveedor> listaProveedorPorNombre(String filtro){
		ArrayList<Proveedor> salida= new ArrayList<Proveedor>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn= new MiConexion().getConexion();
			
			String sql = "select * from proveedor where nombres like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro+"%");
			System.out.println("SQL -> " + pstm);
			
			rs = pstm.executeQuery();
			Proveedor obj = null;
			while(rs.next()) {
				obj = new Proveedor();
				obj.setIdproveedor(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDni(rs.getString(4));
				obj.setDireccion(rs.getString(5));
				obj.setTelefono(rs.getString(6));
				obj.setCorreo(rs.getString(7));
				obj.setPais(rs.getString(8));
				obj.setFechaRegistro(rs.getDate(9));
				salida.add(obj);
			}} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (conn != null) conn.close();
				} catch (Exception e2) {}
			}
			return salida;
		}
	
					
	}
	
	
