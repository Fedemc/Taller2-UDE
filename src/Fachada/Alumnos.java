package Fachada;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.stream.*;
import Fachada.Alumno;
import Fachada.VOAlumno;

public class Alumnos {
	
	private TreeMap<Long,Alumno> alumnos;
	
	//Constructor
	public Alumnos() {
		alumnos = new TreeMap<Long,Alumno>();
	}
		
	public boolean member(Long clave) {
		return alumnos.containsKey(clave);
	}
	
	public void insert(Alumno a) {
		alumnos.put(a.getCedula(),a);
	}
	
	public Alumno find(Long clave) {
		return alumnos.get(clave);
	}
	
	public List<VOAlumno> ListadoAlumnosApe(String ape) {
		Iterator it = alumnos.keySet().iterator();	//Me genero un iterador con el set de cedulas del treemap
		List<VOAlumno> vOAlumnos = new ArrayList<>();
		while (it.hasNext()) {
			Long clave = (Long) it.next();	//El iterador solo tiene cedulas, casteo como long para traerme las cedulas
			Alumno tempAlu = alumnos.get(clave);	//me genero un alumno temporal para almacenar los datos del que estoy leyendo con el iterador
			if (tempAlu.getApellido().startsWith(ape)) {	//comparo si el apellido del alumno empieza con el string que se ingresó por parametro
				//Convertir a VOAlumno y almacenar
				VOAlumno voa = new VOAlumno(tempAlu.getCedula(),tempAlu.getNombre(),tempAlu.getApellido());
				vOAlumnos.add(voa);
			}
		}
		return vOAlumnos;
	}
	
	public VOAlumnoDetallado ListadoAlumnoCedulaCom(Long clave) {
		Alumno tempAlu = (Alumno) alumnos.get(clave);
		VOAlumnoDetallado voad = new VOAlumnoDetallado(tempAlu.getCedula(),tempAlu.getNombre(),tempAlu.getApellido(),tempAlu.getDomicilio(),
					tempAlu.getTelefono(),tempAlu.getEmail(),tempAlu.calcularCuotaAlumno());
		return voad;
	}
	
	public VOBecadoDetallado ListadoAlumnoCedulaBec(Long clave) {
		Becado tempBec = (Becado) alumnos.get(clave);
		VOBecadoDetallado vobd = new VOBecadoDetallado(tempBec.getCedula(),tempBec.getNombre(),tempBec.getApellido(),tempBec.getDomicilio(),
					tempBec.getTelefono(),tempBec.getEmail(),tempBec.calcularCuotaAlumno(),tempBec.getPorcentaje(), tempBec.getDescripcionBeca());
		return vobd;
	}
	
}
