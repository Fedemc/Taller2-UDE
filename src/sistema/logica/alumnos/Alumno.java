package sistema.logica.alumnos;

import java.io.LineNumberInputStream;
import java.util.Calendar;
import java.util.Iterator;
import sistema.logica.asignaturas.Asignatura;
import sistema.logica.inscripciones.Inscripcion;
import sistema.logica.inscripciones.Inscripciones;
import sistema.excepciones.InscripcionException;

public class Alumno {

	private long cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	private Inscripciones inscripciones;
	private int cantAprobaciones; 
	
	
	//Constructor
	public Alumno(long cedula, String nombre, String apellido, String domicilio, int telefono, String email) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.inscripciones = new Inscripciones();
		this.cantAprobaciones = 0;
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
	
	public Inscripciones getInscripciones()
	{
		return this.inscripciones;
	}

	@Override	
	public String toString() {		//Ver si realmente es necesario este metodo
		return "Alumno [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", email=" + email + ", cantAprobaciones="
				+ cantAprobaciones + "]";	//al devolver ese inscripciones va a explotar
	}
	
	//Calcular cuota total del Alumno
	public float calcularCuotaAlumno()
	{
		float cuotaTotal=0;
		cuotaTotal=this.inscripciones.calcularCuotasAlumno();
		
		return cuotaTotal;
	}
	
	public float devolverPromedioTotalAlumno()
	{
		float promedioTotal = 0;
		promedioTotal = this.inscripciones.calcularPromedioTotal();
		return promedioTotal;
	}

	public float devolverPromedioAprobAlumno()
	{
		float promedioAprob = 0;
		promedioAprob = this.inscripciones.calcularPromedioAprob();
		return promedioAprob;
	}
	
	//Dado un codigo de Asignatura se verifica si es valida para inscribir
	//Se recorren las inscripciones del alumno para verificar que no la tenga aprobada ni la esté cursando en el mismo año
	public boolean esValidaInscripcion(String codAsig) throws InscripcionException
	{
		boolean inscripcionValida = true; 
		Iterator<Inscripcion> it = inscripciones.crearIterador();
		while ((it.hasNext()) && (inscripcionValida)) 
		{
			Inscripcion insAux = it.next();
			Asignatura asigAux = insAux.getAsignatura();
			if ((inscripcionValida) && (asigAux.getCodigo() == codAsig)) 
			{
				if (insAux.getCalificacion() >= 6)
				{
					inscripcionValida = false;
					//System.out.println("Throw exception el alumno ya aprobó la materia.");
					String msj="Error: El alumno ya aprobó la materia ingresada";
					throw new InscripcionException(msj);
				}
				else 
				{
					if ((insAux.getCalificacion() == 0) && (insAux.getAnioLectivo() == Calendar.getInstance().get(Calendar.YEAR)))
					{
						inscripcionValida = false;
						//System.out.println("Throw exception el alumno está cursando la materia en este año.");
						String msj="Error: El alumno está cursando la materia en el año actual.";
						throw new InscripcionException(msj);						
					}
				}
			}
		}
		return inscripcionValida;
	}
	
	public void registrarInscripcion(Inscripcion i) {
		inscripciones.insert(i);
	}
	

}
