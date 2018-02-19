package sistema.logica.valueObjects;

public class VOAlumnoDetallado extends VOAlumno {

	private String domicilio;
	private int telefono;
	private String dirCorreo;
	private Float cuotaMensual;
	
	public VOAlumnoDetallado() {
		super();
		this.domicilio = ""; 
		this.telefono = 0;
		this.dirCorreo = "";
		this.cuotaMensual = (float) 0.0;
	}
	
	public VOAlumnoDetallado(Long cedula, String nombre, String apellido, String domicilio, int telefono, String dirCorreo, Float cuotaMensual) {
		super(cedula,nombre,apellido);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.dirCorreo = dirCorreo;
		this.cuotaMensual = cuotaMensual;
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
	
	public Float getCuotaMensual( ) {
		return cuotaMensual;
	}

	@Override
	public String toString() {
		return "VOAlumnoDetallado: domicilio=" + domicilio + ", telefono=" + telefono + ", dirCorreo=" + dirCorreo +", "+ super.toString();
	}
	
	
	
}
