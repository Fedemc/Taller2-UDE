package sistema.logica.alumnos;

import java.util.*;

import sistema.logica.alumnos.Alumno;
import sistema.logica.valueObjects.VOAlumno;
import sistema.logica.valueObjects.VOAlumnoDetallado;
import sistema.logica.valueObjects.VOBecadoDetallado;

public class Alumnos {
	
	private TreeMap<Long,Alumno> arbol;
	
	//Constructor
	public Alumnos() {
		arbol = new TreeMap<Long,Alumno>();
	}
		
	public boolean member(Long clave) {
		return arbol.containsKey(clave);
	}
	
	public void insert(Alumno a) {
		arbol.put(a.getCedula(),a);
	}
	
	public Alumno find(Long clave) {
		return arbol.get(clave);
	}
	
	//Crear Iterador
	public Iterator crearIterador() {
		Iterator it = arbol.keySet().iterator();
		return it;
	}
	
	public List<VOAlumno> ListadoAlumnosApe(String ape) {
		Iterator it = arbol.keySet().iterator();	//Me genero un iterador con el set de cedulas del treemap
		List<VOAlumno> vOAlumnos = new ArrayList<>();
		while (it.hasNext()) {
			Long clave = (Long) it.next();	//El iterador solo tiene cedulas, casteo como long para traerme las cedulas
			Alumno tempAlu = arbol.get(clave);	//me genero un alumno temporal para almacenar los datos del que estoy leyendo con el iterador
			if (tempAlu.getApellido().startsWith(ape)) {	//comparo si el apellido del alumno empieza con el string que se ingresó por parametro
				//Convertir a VOAlumno y almacenar
				VOAlumno voa = new VOAlumno(tempAlu.getCedula(),tempAlu.getNombre(),tempAlu.getApellido());
				vOAlumnos.add(voa);
			}
		}
		return vOAlumnos;
	}
	
	public VOAlumnoDetallado ListadoAlumnoCedulaCom(Long clave) {
		Alumno tempAlu = (Alumno) arbol.get(clave);
		VOAlumnoDetallado voad = new VOAlumnoDetallado(tempAlu.getCedula(),tempAlu.getNombre(),tempAlu.getApellido(),tempAlu.getDomicilio(),
					tempAlu.getTelefono(),tempAlu.getEmail(),tempAlu.calcularCuotaAlumno());
		return voad;
	}
	
	public VOBecadoDetallado ListadoAlumnoCedulaBec(Long clave) {
		Becado tempBec = (Becado) arbol.get(clave);
		VOBecadoDetallado vobd = new VOBecadoDetallado(tempBec.getCedula(),tempBec.getNombre(),tempBec.getApellido(),tempBec.getDomicilio(),
					tempBec.getTelefono(),tempBec.getEmail(),tempBec.calcularCuotaAlumno(),tempBec.getPorcentaje(), tempBec.getDescripcionBeca());
		return vobd;
	}
	
}
