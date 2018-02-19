package sistema.logica.valueObjects;

import java.util.*;

import sistema.logica.inscripciones.Inscripcion;

public class VOAlumnos {
	
	private ArrayList<VOAlumno> voalumnos;

	//Constructor.
	public VOAlumnos()
	{	
		voalumnos = new ArrayList<VOAlumno>(); 
	}
	
	public void insert(VOAlumno a) 
	{
		voalumnos.add(a);
	}
	
	public ArrayList<VOAlumno> getVOAlumnosArray()
	{
		return voalumnos;
	}
	
}
