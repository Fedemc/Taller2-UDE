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
	
}
