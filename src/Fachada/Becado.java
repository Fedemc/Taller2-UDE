package Fachada;

public class Becado extends Alumno {
	
	private int porcentaje;
	private String descripcionBeca;
	
	//Constructor
	public Becado(long cedula, String nombre, String apellido, String domicilio, int telefono, String email,
			int cantAprobaciones, int porcentaje, String descripcionBeca) {
		super(cedula, nombre, apellido, domicilio, telefono, email, cantAprobaciones);
		this.porcentaje = porcentaje;
		this.descripcionBeca = descripcionBeca;
	}

	//get y set
	
	public int getPorcentaje() {
		return porcentaje;
	}

	public String getDescripcionBeca() {
		return descripcionBeca;
	}
	
	
	
	
}
