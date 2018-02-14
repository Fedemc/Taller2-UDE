package Fachada;

import java.util.ArrayList;

public class Inscripciones {

	private ArrayList<Inscripcion> listaInscripciones;
	
	
	//Constructor simple Inscripciones
	public Inscripciones()
	{
		listaInscripciones= new ArrayList<Inscripcion>();
	}
	
	//Inserta una inscripcion en la lista
	public void insertInscripcion(Inscripcion i) 
	{
		listaInscripciones.add(i);
	}
	
	
	//Calculo el monto total del costo de las inscripciones que estan activas (nota == 0)
	public float calcularCuotasAlumno()
	{
		float cuotaTotal=0;
		for(int i=0;i<listaInscripciones.size();i++)
		{
			Inscripcion auxIns=listaInscripciones.get(i);
			if(auxIns.getCalificacion() == 0)
				cuotaTotal=cuotaTotal + (auxIns.getMontoBase()/10);
		}

		return cuotaTotal;
	}
}
