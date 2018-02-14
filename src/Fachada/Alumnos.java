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
		Iterator it = alumnos.keySet().iterator();
		List<VOAlumno> vOAlumnos = new ArrayList<>();
		while (it.hasNext()) {
			Long clave = (Long) it.next();
			Alumno tempAlu = alumnos.get(clave);
			if (tempAlu.getApellido().startsWith(ape)) {
				//Convertir a VOAlumno y almacenar
				VOAlumno voa = new VOAlumno(tempAlu.getCedula(),tempAlu.getNombre(),tempAlu.getApellido());
				vOAlumnos.add(voa);
			}
		}
		return vOAlumnos;
	}
	
	
}
