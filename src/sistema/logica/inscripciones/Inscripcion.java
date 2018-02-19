package sistema.logica.inscripciones;

import java.util.Calendar;

import sistema.logica.asignaturas.Asignatura;

public class Inscripcion {
	
	private int nroInscripcion;
	private int anioLectivo;
	private int montoBase;
	private int calificacion;
	private Asignatura asignatura; 
	
	//Constructor
	
	public Inscripcion(/*int anioLectivo, */int montoBase, Asignatura asignatura) {
		this.nroInscripcion = 0;
		this.anioLectivo = Calendar.getInstance().get(Calendar.YEAR);
		this.montoBase = montoBase;
		this.calificacion = 0;
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
	
	public void setNroInscripcion(int nroIns) {
		this.nroInscripcion = nroIns;
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