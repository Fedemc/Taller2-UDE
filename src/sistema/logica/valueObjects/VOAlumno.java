package sistema.logica.valueObjects;

import java.io.Serializable;

public class VOAlumno implements Serializable {

	private Long cedula;
	private String nombre;
	private String apellido;
	private String tipoAlumno; 
	
	public VOAlumno() {
		this.cedula = (long) 0;
		this.nombre = "";
		this.apellido = "";
	}
	
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
	
	public void setTipoAlumno(String tipoAl)
	{
		this.tipoAlumno=tipoAl;
	}

	@Override
	public String toString() {
		return "VOAlumno: cedula= " + cedula + ", nombre= " + nombre + ", apellido= " + apellido + ", tipo alumno= " + tipoAlumno;
	}
	
	
}
