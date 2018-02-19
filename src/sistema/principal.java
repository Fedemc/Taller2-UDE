package sistema;

import java.util.*;
import java.io.*;

import sistema.excepciones.PersistenciaException;
import sistema.logica.alumnos.Alumno;
import sistema.logica.alumnos.Alumnos;
import sistema.logica.alumnos.Becado;
import sistema.logica.asignaturas.Asignatura;
import sistema.logica.asignaturas.Asignaturas;
import sistema.logica.inscripciones.Inscripcion;
import sistema.logica.inscripciones.Inscripciones;
import sistema.logica.*;
import sistema.persistencia.*;
import sistema.logica.valueObjects.*;

public class principal { 

	public static void main(String[] args) {
		
		CapaLogica fachada= new CapaLogica();
		
		long ced = 2;
		String ape = "zu";
		
		//Prueba registrar asignatura
		Asignatura asig1 = new Asignatura("asignatura 1",  "Taller", "Taller de programacion en JAVA");
		Asignatura asig2 = new Asignatura("asignatura 2",  "S.O.", "Sistemas Operativos");
		Asignatura asig3 = new Asignatura("asignatura 3",  "BD", "Base de Datos");
		Asignatura asig4 = new Asignatura("asignatura 4",  "Redes", "Redes de Computadores");
		
		fachada.registrarAsignatura(asig1);
		fachada.registrarAsignatura(asig2);
		fachada.registrarAsignatura(asig3);
		fachada.registrarAsignatura(asig4);
		
		//Listado asignaturas
		VOAsignaturas voAsigns=new VOAsignaturas();
		voAsigns=fachada.listadoAsignaturas();
		
		System.out.println("\nListado asignaturas");
		for(VOAsignatura asig: voAsigns.getVOAsignaturasArray())
		{
			System.out.println(asig.toString());
		}
		
		Calendar fecha = Calendar.getInstance();
	    int anioLec = fecha.get(Calendar.YEAR);
		
		Inscripcion insc1 = new Inscripcion(100, asig1);
		//a1.agregarInscripcion(insc1);
		
		
		//Prueba registrar alumno
		Alumno a1 =  new Alumno(1,"andres","zubbb","br",99,"sss@");
		Alumno a2 =  new Alumno(5,"car","zulll","sr",88,"hooo@");
		Becado b1 =  new Becado(2,"fed","zur","pp",66,"ppp@",null, 20,"alumno estudioso");
		Alumno a3 =  new Alumno(66,"sak","chaa","qwe",123,"acll@");
		
		fachada.registrarAlumno(a1);
		fachada.registrarAlumno(a2);
		fachada.registrarAlumno(a3);
		fachada.registrarAlumno(b1);
		
		
		//Listado alumnos
		VOAlumnos voAlus=new VOAlumnos();
		voAlus=fachada.listadoAlumnoApellido(ape);
		
		System.out.println("\nListado alumnos");
		for(VOAlumno alu: voAlus.getVOAlumnosArray())
		{
			System.out.println(alu.toString());
		}
		
		//Respaldo
		
		
		
		//sin probar!!!!
		//List<VOInscripcion> vOInscripcion = new ArrayList<>();
		//vOInscripcion = (List<VOInscripcion>) a1.getInscripciones();	
		//while(it.hasNext()) {
			//System.out.println(it.next());
		//}
		
		/*
		List<VOAsignatura> vOAsignaturas = new ArrayList<>();
		vOAsignaturas = arrayAsignaturas.listadoAsignaturas();
		Iterator it = vOAsignaturas.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		//verifico cuanto vale el tope del array
		 System.out.println(arrayAsignaturas.getTope());
		*/
		
		
		/*
		//prueba datos del becado
		VOBecadoDetallado vob = new VOBecadoDetallado(null, null, null, null, 0, null, null, null, null);
		vob = a.ListadoAlumnoCedulaBec(ced);
		System.out.println(vob);
		*/
		
		/*
		//prueba de listado por apellido
		List<VOAlumno> vOAlumnos = new ArrayList<>();
		vOAlumnos = a.ListadoAlumnosApe(ape);
		Iterator it = vOAlumnos.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		*/
		
		/*
		//prueba busqueda por ci
		VOAlumno voa = new VOAlumno(a.ListadoAlumnoCedulaCom((long) ced).getCedula(), a.ListadoAlumnoCedulaCom((long) ced).getNombre(), a.ListadoAlumnoCedulaCom((long) ced).getApellido());
		System.out.println(voa);
		*/
		
		/*
		//Prueba treemap con VO
		TreeMap<Long,Alumno> a = new TreeMap<Long,Alumno>();
		a.put(a1.getCedula(), a1);
		a.put(a2.getCedula(), a2);
		a.put(a3.getCedula(), a3);
		
		Iterator iter = a.keySet().iterator();
		while(iter.hasNext()) {
			long ced = (long) iter.next();
			VOAlumno voa = new VOAlumno(a.get(ced).getCedula(), a.get(ced).getNombre(), a.get(ced).getApellido());
			System.out.println(voa.toString());
		}*/
		
	}

}
