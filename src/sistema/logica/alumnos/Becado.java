package sistema.logica.alumnos;

import sistema.logica.inscripciones.Inscripciones;

public class Becado extends Alumno {
	
	private int porcentaje;
	private String descripcionBeca;
	
	//Constructor
	public Becado(long cedula, String nombre, String apellido, String domicilio, int telefono, String email,
			Inscripciones inscripcion, int porcentaje, String descripcionBeca) {
		super(cedula, nombre, apellido, domicilio, telefono, email);
		this.porcentaje = porcentaje;
		this.descripcionBeca = descripcionBeca; 
		
	}

	//get y set
	
	public float getPorcentaje() {
		return porcentaje;
	}

	public String getDescripcionBeca() {
		return descripcionBeca;
	}

	@Override
	public String toString() {
		return "Becado [porcentaje=" + porcentaje + ", descripcionBeca=" + descripcionBeca + "]";
	}
	
	//Sobreescritura del metodo CalcularCuotaTotal de Alumno
	public float calcularCuotaAlumno()
	{
		float cuotaTotal=0, descuento=0;
		Inscripciones auxInsAlumno=this.getInscripciones();
		cuotaTotal=auxInsAlumno.calcularCuotasAlumno();
		descuento=auxInsAlumno.calcularCuotasAlumno() / this.porcentaje;
		
		
		return cuotaTotal - descuento;
	}
	
	
}