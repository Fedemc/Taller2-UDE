package Fachada;

public class VOEgresadoPromedioCal extends VOAlumno {

	private Float promedioCal;
	
	public VOEgresadoPromedioCal(Long cedula, String nombre, String apellido, Float promedioCal) {
		super(cedula,nombre,apellido);
		this.promedioCal = promedioCal;
	}

	//Getters
	public Float getPromedioCal() {
		return promedioCal;
	}
	
	
}
