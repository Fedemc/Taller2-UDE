package sistema.logica.valueObjects;

public class VOInscripcionDetallada extends VOInscripcion {

	private int montoBase;
	
	public VOInscripcionDetallada(int numero, String nombreAsignatura, int anioLectivo, int calificacion, int montoBase) {
		super(numero,nombreAsignatura,anioLectivo,calificacion);
		this.montoBase = montoBase;
	}

	//Getters
	public int getMontoBase() { 
		return montoBase;
	}

	@Override
	public String toString() {
		return "VOInscripcionDetallada [montoBase=" + montoBase + ", toString()=" + super.toString() + "]";
	}
	
	
}
