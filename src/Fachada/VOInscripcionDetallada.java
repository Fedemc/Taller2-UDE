package Fachada;

public class VOInscripcionDetallada extends VOInscripcion {

	private Float montoBase;
	
	public VOInscripcionDetallada(int numero, String nombreAsignatura, int anioLectivo, int calificacion, Float montoBase) {
		super(numero,nombreAsignatura,anioLectivo,calificacion);
		this.montoBase = montoBase;
	}

	//Getters
	public Float getMontoBase() {
		return montoBase;
	}
	
}
