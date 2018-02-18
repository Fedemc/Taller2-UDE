package sistema.logica.valueObjects;

import java.util.ArrayList;

public class VOAsignaturas {

	private ArrayList<VOAsignatura> voasignaturas;

	//Constructor.
	public VOAsignaturas()
	{	
		voasignaturas = new ArrayList<VOAsignatura>();
	}
	
	public void insert(VOAsignatura a) 
	{
		voasignaturas.add(a);
	}
	
}
