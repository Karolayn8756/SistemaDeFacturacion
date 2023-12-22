package ec.edu.puce.interfaces;

public abstract class FiguraGeometrica {
private String nombre;
	abstract public double calcularArea();
	
	public FiguraGeometrica(String nombre) {
		this.nombre = nombre;
	}
	public boolean mayorQue(FiguraGeometrica figura2) {
		return this.calcularArea()>figura2.calcularArea();
	}
	@Override
	public String toString() {
		return this.nombre + " con área " + this.calcularArea();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
