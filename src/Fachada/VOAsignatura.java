package Fachada;

public class VOAsignatura {

	private String codigo;
	private String nombre;
	private String descripcion;
	
	public VOAsignatura(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	//Getters
	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	
}