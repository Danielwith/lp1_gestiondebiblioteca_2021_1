package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Sala;
import util.MySqlDBConexion;

public class SalaModel {

	public int insertaSala(Sala obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "insert into sala values(null,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, obj.getNumero());
			pstm.setInt(2, obj.getPiso());
			pstm.setString(3, obj.getCapacidad());
			pstm.setString(4, obj.getRecursos());
			pstm.setInt(5, obj.getEstado());
			pstm.setDate(6, obj.getFechaRegistro());
			System.out.println("SQL -> " + pstm);

			// 2Se envía el SQL a la base de datos
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	public int actualizaSala(Sala obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "update sala set numero=?, piso=?, capacidad=?, recursos=?, estado=?, fechaRegistro=? where idSala=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNumero());
			pstm.setInt(2, obj.getPiso());
			pstm.setString(3, obj.getCapacidad());
			pstm.setString(4, obj.getRecursos());
			pstm.setInt(5, obj.getEstado());
			pstm.setDate(6, obj.getFechaRegistro());
			pstm.setInt(7, obj.getIdSala());
			System.out.println("SQL -> " + pstm);

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
			}

		}
		return salida;
	}

	public int eliminaSala(int idSala) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "delete from sala where idSala= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idSala);
			System.out.println("SQL -> " + pstm);

			// 2Se envía el SQL a la base de datos
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	public List<Sala> listaSala() {
		ArrayList<Sala> salida = new ArrayList<Sala>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "select * from sala";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL -> " + pstm);

			// 2Se envía el SQL a la base de datos
			rs = pstm.executeQuery();
			Sala obj = null;
			while (rs.next()) {
				obj = new Sala();
				obj.setIdSala(rs.getInt(1));
				obj.setNumero(rs.getString(2));
				obj.setPiso(rs.getInt(3));
				obj.setCapacidad(rs.getString(4));
				obj.setRecursos(rs.getString(5));
				obj.setEstado(rs.getInt(6));
				obj.setFechaRegistro(rs.getDate(7));
				salida.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	public List<Sala> listaSalaPorNumero(String filtro) {
		ArrayList<Sala> data = new ArrayList<Sala>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// 1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// 2 Se prepara el SQL
			String sql = "select * from sala where numero like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro+"%");
			System.out.println("SQL -> " + pstm);

			// 2Se envía el SQL a la base de datos
			rs = pstm.executeQuery();
			Sala obj = null;
			while (rs.next()) {
				obj = new Sala();
				obj.setIdSala(rs.getInt(1));
				obj.setNumero(rs.getString(2));
				obj.setPiso(rs.getInt(3));
				obj.setCapacidad(rs.getString(4));
				obj.setRecursos(rs.getString(5));
				obj.setEstado(rs.getInt(6));
				obj.setFechaRegistro(rs.getDate(7));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}
}
