package sistema.logica.valueObjects;

import java.util.ArrayList;

public class VOEgresados {
	
	private ArrayList<VOEgresadoPromedioCal> voEgresados;

	//Constructor.
	public VOEgresados()
	{	 
		voEgresados = new ArrayList<VOEgresadoPromedioCal>(); 
	}
	
	public void insert(VOEgresadoPromedioCal e) 
	{
		voEgresados.add(e);
	}
	
	public ArrayList<VOEgresadoPromedioCal> getVOEgresadosArray()
	{
		return voEgresados;
	}

}
