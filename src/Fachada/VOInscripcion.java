package Fachada;

public class VOInscripcion {

	private int numero;
	private String nombreAsignatura;
	private int anioLectivo;
	private int calificacion;
	
	public VOInscripcion(int numero, String nombreAsignatura, int anioLectivo, int calificacion) {
		this.numero = numero;
		this.nombreAsignatura = nombreAsignatura;
		this.anioLectivo = anioLectivo;
		this.calificacion = calificacion;
	}

	//Getters
	public int getNumero() {
		return numero;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public int getAnioLectivo() {
		return anioLectivo;
	}

	public int getCalificacion() {
		return calificacion;
	}

	@Override
	public String toString() {
		return "VOInscripcion [numero=" + numero + ", nombreAsignatura=" + nombreAsignatura + ", anioLectivo="
				+ anioLectivo + ", calificacion=" + calificacion + ", toString()=" + super.toString() + "]";
	}
	
		
	
}
