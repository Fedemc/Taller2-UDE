package Fachada;

public class VOAlumnoDetallado extends VOAlumno {

	private String domicilio;
	private int telefono;
	private String dirCorreo;
	
	public VOAlumnoDetallado(Long cedula, String nombre, String apellido, String domicilio, int telefono, String dirCorreo) {
		super(cedula,nombre,apellido);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.dirCorreo = dirCorreo;
	}

	//Getters
	public String getDomicilio() {
		return domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getDirCorreo() {
		return dirCorreo;
	}

	@Override
	public String toString() {
		return "VOAlumnoDetallado [domicilio=" + domicilio + ", telefono=" + telefono + ", dirCorreo=" + dirCorreo
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
