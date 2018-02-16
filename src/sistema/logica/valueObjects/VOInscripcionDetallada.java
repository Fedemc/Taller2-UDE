package sistema.logica.valueObjects;

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

	@Override
	public String toString() {
		return "VOInscripcionDetallada [montoBase=" + montoBase + ", toString()=" + super.toString() + "]";
	}
	
	
}
