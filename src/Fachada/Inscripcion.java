package Fachada;

public class Inscripcion {
	
	private int nroInscripcion;
	private int anioLectivo;
	private int montoBase;
	private int calificacion;
	private Asignatura asignatura;
	
	//Constructor
	
	public Inscripcion(int nroInscripcion, int anioLectivo, int montoBase, int calificacion, Asignatura asignatura) {
		this.nroInscripcion = nroInscripcion;
		this.anioLectivo = anioLectivo;
		this.montoBase = montoBase;
		this.calificacion = calificacion;
		this.asignatura = asignatura;
	}

	
	//get y set
	
	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public int getNroInscripcion() {
		return nroInscripcion;
	}
	
	public int getAnioLectivo() {
		return anioLectivo;
	}

	public int getMontoBase() {
		return montoBase;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}
	
}
