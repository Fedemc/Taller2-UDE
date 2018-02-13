package Fachada;

import java.util.TreeMap;
import java.util.Iterator;
import Fachada.Alumno;

public class Alumnos {
	
	private TreeMap<Long,Alumno> alumnos;
	
	//Constructor
	public Alumnos() {
		alumnos = new TreeMap();
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
	
	//public  ListadoAlumnosApe(String ape) {
		
	//}
	

}
