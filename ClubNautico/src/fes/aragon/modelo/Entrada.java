package fes.aragon.modelo;

public class Entrada {

	private int idEntrada,numAmarre;
	private String fecha, matricula;
	
	public Entrada(int idEntrada, String fecha , int numAmarre , String matricula) {
		super();
		this.idEntrada = idEntrada;
		this.numAmarre = numAmarre;
		this.fecha = fecha;
		this.matricula = matricula;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public int getNumAmarre() {
		return numAmarre;
	}

	public void setNumAmarre(int numAmarre) {
		this.numAmarre = numAmarre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
