package fes.aragon.modelo;

public class AmarreOcupado {

	Amarre amarre;
	Barco barco;
	
	public AmarreOcupado(Amarre a, Barco b) {
		// TODO Auto-generated constructor stub
		amarre = a;
		barco = b;
		
		
	}

	public Amarre getAmarre() {
		return amarre;
	}

	public void setAmarre(Amarre amarre) {
		this.amarre = amarre;
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Amarre: "+amarre.getNumAmarre() +" Barco: " +barco.getMatricula() +" - "+ barco.getNombre();
	}
}
