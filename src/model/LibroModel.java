package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			salida=pstm.executeUpdate();
			
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
	
	
}
