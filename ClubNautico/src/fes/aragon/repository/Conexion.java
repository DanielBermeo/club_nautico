package fes.aragon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fes.aragon.modelo.Amarre;
import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Entrada;
import fes.aragon.modelo.Salida;
import fes.aragon.modelo.Usuario;

public class Conexion {

	private String url = "jdbc:mariadb://127.0.0.1:3306/club_nautico?serverTimezone = UTC";
	private String usuario = "root";
	private String clave = "1234";
	private Connection conexion;

	public Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		conexion = DriverManager.getConnection(url, usuario, clave);
	}

	public Usuario consultarUnUsuario(String busqueda) throws SQLException {
		String query = "SELECT * FROM contactos where id_cto = " + busqueda;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		Usuario u = null;
		while (rs.next()) {
			u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
		}
		rs.close();
		st.close();

		return u;
	}
	
	public ArrayList<Usuario> consultarTodosUsuarios() throws SQLException {
		String query = "SELECT * FROM contactos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<Usuario> consultarTodosSocios() throws SQLException {
		String query = "select * from contactos a, socios b where a.id_cto = b.id_cto;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	

	
	public ArrayList<Usuario> consultarTodosPatrones() throws SQLException {
		String query = "SELECT * FROM contactos a, patrones b where a.id_cto = b.id_cto;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Barco> consultarTodosBarcos() throws SQLException {
		String query = "SELECT * FROM barcos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Barco> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Barco(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Entrada> consultarTodasEntradas() throws SQLException {
		String query = "SELECT * FROM entradas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Entrada> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Entrada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<String> consultarFechaEntradas() throws SQLException {
		String query = "SELECT distinct fecha_llegada FROM entradas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(rs.getString(1));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Salida> consultarTodasSalidas() throws SQLException {
		String query = "SELECT * FROM salidas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Salida> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Salida(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<String> consultarFechaSalida() throws SQLException {
		String query = "SELECT distinct fecha_salida FROM salidas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(rs.getString(1));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Usuario> consultarUsuarios(String seleccion, String busqueda) throws SQLException {
		String query = "SELECT * FROM contactos where " + seleccion + " like " + "'%" + busqueda + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Barco> consultarBarcos(String seleccion, String busqueda) throws SQLException {
		String query = "SELECT * FROM barcos where " + seleccion + " like " + "'%" + busqueda + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Barco> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Barco(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Entrada> consultarEntradas(String seleccion, String busqueda, String filtroFecha)
			throws SQLException {
		
		String query = "SELECT * FROM entradas where " + seleccion + busqueda + filtroFecha;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Entrada> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Entrada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public boolean estaDentroBarco(Barco b) throws SQLException {
		ArrayList<Entrada> entradas = consultarEntradas("num_mta = ", b.getMatricula()  , "");
		ArrayList<Salida> salidas = consultarSalidas("num_mta = ", b.getMatricula(), "");
		
		return entradas.size() > salidas.size(); 
	}

	public ArrayList<Salida> consultarSalidas(String seleccion, String busqueda, String filtroFecha)
			throws SQLException {
		String query = "SELECT * FROM salidas where " + seleccion + busqueda + filtroFecha;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Salida> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Salida(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public int InsertarUsuario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub
		int id = 0;
		String query = "INSERT INTO contactos VALUES (null,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApPat());
		ps.setString(3, u.getApMat());
		ps.setString(4, u.getTelefono());
		ps.setString(5, u.getEmail());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
		
		
	}

	public int InsertarSocio(int idUsuario) throws SQLException {

		int id = 0;
		String query = "INSERT INTO socios VALUES (null,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idUsuario);
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
	}

	public int insertarDueno(Usuario contacto) throws SQLException {
		int id = 0;
		String query = "INSERT INTO duenos VALUES (null,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, contacto.getIdContacto());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
	}
	public void InsertarPatron(int idUsuario, int idSocio) throws SQLException {

		String query = "INSERT INTO patrones (id_sco , id_cto) VALUES ( " + idSocio + " , " + idUsuario +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
	}
	
	public void insertarBarco(Barco barco, int idDueno) throws SQLException {
		String query = "INSERT INTO barcos (num_matricula , nombre, id_ptn, id_dno) VALUES ( '" + barco.getMatricula() + 
				"' , '" + barco.getNombre() + "' , " + barco.getPatron().getIdContacto()+" , "+ idDueno +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
	}
	
	public int getIdSocio(int idUsuario) throws SQLException {
		int id = -1;
		
		String query = "SELECT id_sco FROM socios where id_cto = " + idUsuario;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	public boolean getExisteSocio(int idContacto) throws SQLException {
		String query = "select * from socios where id_cto = " + idContacto;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		int id;
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public  boolean getExistePatron(int idContacto) throws SQLException {
		String query = "select * from patrones where id_cto = " + idContacto;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		int id;
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getIdPatron(Usuario patron) throws SQLException{

		int id = -1;
		String query = "SELECT id_sco FROM socios where id_cto = " + patron.getIdContacto();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	public ArrayList<Amarre> getAmarresDispobibles() throws SQLException{
		String query = "select * from amarres where disponibilidad =  1;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Amarre> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Amarre(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public void registrarEntrada(Barco barco, Amarre amarre, String fecha) throws SQLException {
		String query = "INSERT INTO entradas VALUES ( null, '" + fecha + "' , " + amarre.getNumAmarre() + ","+ barco.getMatricula()+ " )" ;
		cambioEstAmarre(amarre.getNumAmarre());
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
		
	}

	private void cambioEstAmarre(int numAmarre) throws SQLException {
		// TODO Auto-generated method stub
		String query = "UPDATE amarres SET disponibilidad = 0 where num_amarres = " + numAmarre;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		st.close();
		rs.close();
	}
	
	public void insertarAmarre(Amarre a) throws SQLException {
		
		if(exiteAmarre(a)) {
			desabilitarAnterioresAmarres(a);
		}
		
		String query = "INSERT INTO amarres (num_amarres , fecha_registro, cuota, disponibilidad) VALUES "
				+ "( " + a.getNumAmarre() + " , '" + a.getFechaRegistro() + "' , " +a.getCuota()
				+" , "+ a.getDisponibilidad() +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		st.close();
		rs.close();
	}

	private void desabilitarAnterioresAmarres(Amarre a) throws SQLException {
		
		
		String query = "UPDATE amarres SET disponibilidad = NULL where num_amarres = " + a.getNumAmarre();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		st.close();
		rs.close();
		
	}

	private boolean exiteAmarre(Amarre a) throws SQLException {

		String query = "select * from amarres where num_amarres = " + a.getNumAmarre();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int consultarEstadoAmarre(Amarre a) throws SQLException {
		String query = "select * from amarres where num_amarres = " + a.getNumAmarre() + " order by fecha_registro desc";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Amarre> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Amarre(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		int disponibilidad;
		if(datos.size()>0) {
			Amarre amarre = datos.get(datos.size()-1);
			disponibilidad = amarre.getDisponibilidad();
		}else {
			disponibilidad = 1;
		}
			
		return disponibilidad;
	}

	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	

	

	

	



}
