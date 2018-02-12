package Fachada;

public class Asignatura {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	
	//Constructor
	
	public Asignatura(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	//get
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String toString() {
		return "Codigo: " + getCodigo() + " - Nombre: " + getNombre() + " - Descripcion: " + getDescripcion();
	}
}
