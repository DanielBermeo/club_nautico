package fes.aragon.modelo;

public class Salida {

	private int idSalida;
	private String fecha, destino, matricula;
	
	public Salida(int idSalida, String fecha, String destino, String matricula) {
		super();
		this.idSalida = idSalida;
		this.fecha = fecha;
		this.destino = destino;
		this.matricula = matricula;
	}

	public int getIdSalida() {
		return idSalida;
	}

	public void setIdSalida(int idSalida) {
		this.idSalida = idSalida;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Salida [idSalida=" + idSalida + ", fecha=" + fecha + ", destino=" + destino + ", matricula=" + matricula
				+ "]";
	}
	
	
	
}
