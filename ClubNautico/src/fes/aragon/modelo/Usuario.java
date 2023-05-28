package fes.aragon.modelo;

import java.sql.SQLException;

import fes.aragon.repository.Conexion;

public class Usuario {
	
	private int idContacto;
	private String nombre, apPat, apMat,fullName, telefono,email;
	private boolean socio, patron;
	
	
	
	
	public Usuario(int idContacto, String nombre, String apPat, String apMat, String telefono, String email) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apPat = apPat;
		this.apMat = apMat;
		this.telefono = telefono;
		this.email = email;
		this.fullName = nombre +" " +apPat +" " + apMat;
		setSocio();
		setPatron();
	}
	
	
	
	public Usuario(String nombre, String apPat, String apMat, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apPat = apPat;
		this.apMat = apMat;
		this.telefono = telefono;
		this.email = email;
	}



	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPat() {
		return apPat;
	}
	public void setApPat(String apPat) {
		this.apPat = apPat;
	}
	public String getApMat() {
		return apMat;
	}
	public void setApMat(String apMat) {
		this.apMat = apMat;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return nombre +" " +apPat +" " + apMat;
	}

	
	public String isSocio() {
		if(socio) {
			return "✔";
		}else {
			return "X";
		}
	}

	public void setSocio() {
	
		try {
			Conexion cnn = new Conexion();
			this.socio = cnn.getExisteSocio(idContacto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String isPatron() {
		if(patron) {
			return "✔";
		}else {
			return "X";
		}
	}

	public void setPatron() {
			
		try {
			Conexion cnn = new Conexion();
			this.patron =  cnn.getExistePatron(idContacto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fullName;
	}
	
	

	
}
