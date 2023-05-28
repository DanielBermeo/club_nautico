package fes.aragon.modelo;

import java.sql.SQLException;

import fes.aragon.repository.Conexion;

public class Barco {
	private String matricula, nombre, nomPatron, nomDueno;
	private Usuario patron, dueno;
	private int idDueno, idPatron;
	

	public Barco(String numMatricula, String nombre, int idPatron, int idDueno) {
		super();
		this.matricula = numMatricula;
		this.nombre = nombre;
		this.idPatron = idPatron;
		this.idDueno = idDueno;
		try {
			Conexion cnn = new Conexion();
			setDueno(cnn.consultarUnUsuario(idDueno+""));
			setPatron(cnn.consultarUnUsuario(idPatron+""));
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public Barco(String numMatricula, String nombre, Usuario patron, Usuario dueno) {
		super();
		this.matricula = numMatricula;
		this.nombre = nombre;
		this.patron = patron;
		this.dueno = dueno;
		nomPatron = patron.getFullName();
		nomDueno = dueno.getFullName();

	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String numMatricula) {
		this.matricula = numMatricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario getPatron() {
		return patron;
	}
	public void setPatron(Usuario patron) {
		this.patron = patron;
	}
	public Usuario getDueno() {
		return dueno;
	}
	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}
	
	
	public String getNomPatron() {
		return patron.getFullName();
	}

	public void setNomPatron(String nomPatron) {
		this.nomPatron = nomPatron;
	}

	public String getNomDueno() {
		return dueno.getFullName();
	}

	public void setNomDueno(String nomDueno) {
		this.nomDueno = nomDueno;
	}

	public int getIdDueno() {
		return idDueno;
	}

	public void setIdDueno(int idDueno) {
		this.idDueno = idDueno;
	}

	public int getIdPatron() {
		return idPatron;
	}

	public void setIdPatron(int idPatron) {
		this.idPatron = idPatron;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMatricula() +" : " +getNombre();
	}
	
	
}
