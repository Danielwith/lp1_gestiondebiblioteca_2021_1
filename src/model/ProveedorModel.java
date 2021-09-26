package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
			psnt.setInt(3, obj.getDni());
			psnt.setString(4, obj.getDireccion());
			psnt.setInt(5, obj.getTelefono());
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
	
}
