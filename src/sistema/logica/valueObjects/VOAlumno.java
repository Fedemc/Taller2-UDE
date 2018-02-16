package sistema.logica.valueObjects;

public class VOAlumno {

	private Long cedula;
	private String nombre;
	private String apellido;
		
	public VOAlumno(Long cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//Getters
	public Long getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public String toString() {
		return "VOAlumno: cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido;
	}
	
	
}
