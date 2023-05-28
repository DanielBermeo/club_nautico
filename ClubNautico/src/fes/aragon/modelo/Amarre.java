package fes.aragon.modelo;

public class Amarre {

	private int numAmarre, disponibilidad;
	private String fechaRegistro;
	private double cuota;
	
	public Amarre(int numAmarre, String fechaRegistro, double cuota, int disponibilidad) {
		
		this.numAmarre = numAmarre;
		this.fechaRegistro = fechaRegistro;
		this.cuota = cuota;
		this.disponibilidad = disponibilidad;
	}

	public int getNumAmarre() {
		return numAmarre;
	}

	public void setNumAmarre(int numAmarre) {
		this.numAmarre = numAmarre;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	@Override
	public String toString() {
		return numAmarre + " : $" + cuota;
	}
	
	
	
}
