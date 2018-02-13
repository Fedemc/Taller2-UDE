package Fachada;

public class VOBecadoDetallado extends VOAlumnoDetallado {

	private Float porcentaje;
	private String descripcion;
	
	public VOBecadoDetallado(Long cedula, String nombre, String apellido, String domicilio, int telefono, String dirCorreo,
			Float porcentaje, String descripcion) {
		super(cedula,nombre,apellido,domicilio,telefono,dirCorreo);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	public Float getPorcentaje() {
		return porcentaje;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
		
}
