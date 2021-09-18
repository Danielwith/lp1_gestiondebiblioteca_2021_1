package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Opcion;
import entidad.Usuario;
import util.MySqlDBConexion;

public class UsuarioModel {

	public Usuario valida(String login, String clave) {
		Usuario bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from usuario where login=? and password =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			System.out.println(pstm);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido(rs.getString("apellido"));
				bean.setDni(rs.getString("dni"));
				bean.setLogin(rs.getString("login"));
				bean.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}

	public List<Opcion> obtieneOpciones(int idUsuario) {
		ArrayList<Opcion> data = new ArrayList<Opcion>();
		Opcion bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select p.idopcion, p.nombre  from opcion p inner join rol_has_opcion r on p.idopcion = r.idopcion inner join rol c on r.idrol = c.idrol inner join usuario_has_rol h on c.idrol = h.idrol where idusuario = ? order by 2;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idUsuario);
			System.out.println(pstm);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				bean = new Opcion();
				bean.setIdOpcion(rs.getInt("idopcion"));
				bean.setNombre(rs.getString("nombre"));
				data.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}

	
}
