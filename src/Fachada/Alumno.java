package Fachada;

public class Alumno {

	private long cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	private Inscripciones inscripcion;
	private int cantAprobaciones;
	
	
	//Constructor
	public Alumno(long cedula, String nombre, String apellido, String domicilio, int telefono, String email,
			int cantAprobaciones) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.cantAprobaciones = cantAprobaciones;
	}

	//get y set
	
	public long getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCantAprobaciones() {
		return cantAprobaciones;
	}
	
	public void setCantAprobaciones(int cantAprobaciones) {
		this.cantAprobaciones = cantAprobaciones;
	}
	
	
	
	
}
