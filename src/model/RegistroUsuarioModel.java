package model;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.RegistrarUsuario;
import util.MiConexion;


public class RegistroUsuarioModel {
	
	private static final Logger log = Logger.getLogger(RegistrarUsuario.class.getName());
	
	public int insertaUsuario(RegistrarUsuario obj) {
		int salida = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = new MiConexion().getConexion();
			
			String sql = "insert into usuario values(null,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombreUsuario());
			psmt.setString(2, obj.getApellidoUsuario());
			psmt.setInt(3, obj.getDNI());
			psmt.setString(4, obj.getLogin());
			psmt.setString(5, obj.getPassword());
			psmt.setString(6, obj.getCorreo());
			psmt.setDate(7, obj.getFechaNacimientoUsuario());
			psmt.setString(8, obj.getDirección());
			
			
			
			log.info(">>> " + psmt);
			salida = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) psmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public int eliminarUsuario(int idUsuario) {

		int salida = -1;

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			//1 Se crea la conexión

			conn = new MiConexion().getConexion();



			//2 Se prepara el SQL

			String sql = "delete from usuario where idUsuario = ?";

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idUsuario);

			System.out.println("SQL -> " + pstm);

			

			//3 Se envía el SQL a la base de datos

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
	public int actualizaUsuario(RegistrarUsuario obj) {

		int salida = -1;

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			//1 Se crea la conexión

			conn = new MiConexion().getConexion();
			//2 Se prepara el SQL

			String sql = "update usuario set nombre=?,apellido=?,dni=?,login=?,password=?,correo=?,fechaNacimiento=?,direccion=? where idUsuario=?";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombreUsuario());
			pstm.setString(2, obj.getApellidoUsuario());
			pstm.setInt(3, obj.getDNI());
			pstm.setString(4, obj.getLogin());
			pstm.setString(5, obj.getPassword());
			pstm.setString(6, obj.getCorreo());
			pstm.setDate(7, obj.getFechaNacimientoUsuario());
			pstm.setString(8, obj.getDirección());
			pstm.setInt(9,obj.getIdUsuario());
			
			System.out.println("SQL -> " + pstm);
			//2Se envía el SQL a la base de datos

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
	public List<RegistrarUsuario> listaUsuario(){
		
		ArrayList<RegistrarUsuario> salida = new ArrayList<RegistrarUsuario>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {

			//1 Se crea la conexión

			conn = new MiConexion() .getConexion();



			//2 Se prepara el SQL

			String sql = "select * from usuario";

			pstm = conn.prepareStatement(sql);


			System.out.println("SQL -> " + pstm);
			
			rs = pstm.executeQuery();
			RegistrarUsuario obj = null;
			while(rs.next()) {
				obj= new RegistrarUsuario();
				obj.setIdUsuario(rs.getInt(1));
				obj.setNombreUsuario(rs.getString(2));
				obj.setApellidoUsuario(rs.getString(3));
				obj.setDNI(rs.getInt(4));
				obj.setLogin(rs.getString(5));
				obj.setPassword(rs.getString(6));
				obj.setCorreo(rs.getString(7));
				obj.setFechaNacimientoUsuario(rs.getDate(8));
				obj.setDirección(rs.getString(9));
				salida.add(obj);
			}
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
	public List<RegistrarUsuario> listaUsuarioPorNomre(String filtro) {
		ArrayList<RegistrarUsuario> data = new ArrayList<RegistrarUsuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con =new MiConexion().getConexion();
			String sql ="select * from usuario where nombre like ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, filtro+"%");
			System.out.println("SQL-->" + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			RegistrarUsuario c = null;
			while(rs.next()){
				c = new RegistrarUsuario();
				
				// Se colocan los campos de la base de datos
				c.setIdUsuario(rs.getInt("idUsuario"));
				c.setNombreUsuario(rs.getString("nombre"));
				c.setApellidoUsuario(rs.getString("apellido"));
				c.setDNI(rs.getInt("dni"));
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));
				c.setCorreo(rs.getString("correo"));
				c.setFechaNacimientoUsuario(rs.getDate("fechaNacimiento"));
				c.setDirección(rs.getString("direccion"));
				data.add(c);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
		
	}

