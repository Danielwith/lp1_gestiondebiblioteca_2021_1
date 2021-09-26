package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Sala;
import util.MiConexion;
public class SalaModel {
	
	private static final Logger log = Logger.getLogger(Sala.class.getName());
 
	public int insertaSala(Sala obj) {
		int salida=-1;
		Connection conn= null;
		PreparedStatement pstm=null;
		try {
			conn =new MiConexion().getConexion();
			
			String sql = "insert into sala values(null,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNumero());
			pstm.setInt(2, obj.getPiso());
			pstm.setString(3, obj.getCapacidad());
			pstm.setString(4, obj.getRecursos());
			pstm.setInt(5, obj.getEstado());
			pstm.setDate(6, obj.getFechaRegistro());
			
			log.info(">>>" + pstm);

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

}


