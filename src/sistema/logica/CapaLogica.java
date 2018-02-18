package sistema.logica;
import sistema.logica.alumnos.*;
import sistema.logica.asignaturas.*;
import sistema.logica.inscripciones.*;
import sistema.logica.valueObjects.*;

public class CapaLogica
{
	Alumnos alumnos = new Alumnos();
	Asignaturas asignaturas = new Asignaturas();
	
	/*Req. 1: Registrar una asignatura en el sistema. */
	public void registrarAsignatura (Asignatura as) {
		if (asignaturas.getTope() >= 10)
			System.out.println("Exception ya hay 10 asignaturas registradas.");//Throw exception ya hay 10 asignaturas registradas.			 
		else
			if  (asignaturas.memberAsignatura(as.getCodigo()))
				System.out.println("Exception asignatura ya registrada.");//Throw exception asignatura ya registrada.
			else
				asignaturas.insertAsignatura(as);
	}
	
	/*Req. 2: Registro de un alumno en el sistema.*/
	public void registrarAlumno(Alumno al) {
		if (alumnos.member(al.getCedula()))
			System.out.println("Exception alumno ya registrado.");//Throw exception alumno ya registrado.
		else
			alumnos.insert(al); //Falta ver becado
	}
	
	/*Req. 3: Modificación de datos de un alumno (Domicilio, teléfono y dirección de correo electrónico.*/
	public void modificarDatosAlumno(Long ced, String dom, int tel, String email) {
		if (alumnos.member(ced)) {
			if (!(dom.isEmpty()))
				alumnos.find(ced).setDomicilio(dom);
			if (tel != 0)
				alumnos.find(ced).setTelefono(tel);
			if (!(email.isEmpty()))
				alumnos.find(ced).setDomicilio(email);
		}
	}
	
	/*Req. 4: Listado de asignaturas*/
	public VOAsignaturas listadoAsignaturas() {
		VOAsignaturas voas = new VOAsignaturas();
		if (asignaturas.getTope() == 0)
			System.out.println("Exception no hay asignaturas registrados.");//Throw exception no hay asignaturas registrados.
		else
			voas = asignaturas.listadoAsignaturas();
		return voas;
	}
	
	/*Req. 5: Listado de alumnos cuyo apellido empiece con un substring dado.*/
	public VOAlumnos listadoAlumnoApellido (String s) {
		VOAlumnos voas = new VOAlumnos();
		if (alumnos.getCantidadElementos() == 0)
			System.out.println("Exception no hay alumnos registrados.");//Throw exception no hay alumnos registrados.
		else
			voas = alumnos.ListadoAlumnosApe(s);
		return voas;
	}
	
	/*Req. 6: Listado detallado de un alumno, dada una cedula. Si es becado, también listar detalles de la beca.*/
	public VOAlumnoDetallado listadoAlumnoCedulaComun(Long ced) {
		VOAlumnoDetallado voad = new VOAlumnoDetallado();
		if (alumnos.member(ced))
			voad = alumnos.ListadoAlumnoCedulaCom(ced);
		else
			System.out.println("Exception el alumno no existe.");//Throw exception el alumno no existe.
		return voad;
	}
	
	public VOBecadoDetallado listadoAlumnoCedulaBecado(Long ced) {
		VOBecadoDetallado vobd = new VOBecadoDetallado();
		if (alumnos.member(ced))
			vobd = alumnos.ListadoAlumnoCedulaBec(ced);
		else
			System.out.println("Exception el alumno no existe.");//Throw exception el alumno no existe.
		return vobd;
	}
	
	/*Req. 7: */
	
}
