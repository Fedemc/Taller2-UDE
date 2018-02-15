package Fachada;

import java.util.ArrayList;

public class Inscripciones {

	private ArrayList<Inscripcion> listaInscripciones;
	
	
	//Constructor simple Inscripciones
	public Inscripciones()
	{
		listaInscripciones= new ArrayList<Inscripcion>();
	}
	
	public ArrayList<Inscripcion> getListaInscripciones() {
		return listaInscripciones;
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
	
	public float calcularPromedioTotal()
	{
		float promedioTotal=0;
		for(int i=0;i<listaInscripciones.size();i++)
		{
			Inscripcion auxIns=listaInscripciones.get(i);
			promedioTotal = promedioTotal + (auxIns.getCalificacion());
		}
		promedioTotal = promedioTotal / listaInscripciones.size();
		return promedioTotal;
	}
	
	public float calcularPromedioAprob()
	{
		float promedioAprob=0;
		for(int i=0;i<listaInscripciones.size();i++)
		{
			Inscripcion auxIns=listaInscripciones.get(i);
			if(auxIns.getCalificacion() != 0)
				promedioAprob = promedioAprob + (auxIns.getCalificacion());
		}
		promedioAprob = promedioAprob / 10;
		return promedioAprob;
	}
	
	
}
