package sistema.logica.inscripciones;

import java.util.ArrayList;

public class Inscripciones {

	private ArrayList<Inscripcion> listaInscripciones;
	
	
	//Constructor simple Inscripciones
	public Inscripciones()
	{
		listaInscripciones= new ArrayList<Inscripcion>();
	}
	
	//Getter
	public ArrayList<Inscripcion> getListaInscripciones() {
		return listaInscripciones;
	}

	//Inserta una inscripcion en la lista
	public void insert(Inscripcion i) 
	{
		int nroIns = listaInscripciones.size() + 1;
		i.setNroInscripcion(nroIns);
		listaInscripciones.add(i);
	}
	
	public boolean member(int nroIns)
	{
		boolean existe=false;
		int i=0;
		while(!existe && i<listaInscripciones.size())
		{
			if(nroIns==listaInscripciones.get(i).getNroInscripcion())
				existe=true;
			else
				i++;
		}
		return existe;
	}
	
	//Precondicion: Existe la inscripcion con ese nro de inscripcion en la lista
	public Inscripcion find(int nroIns)
	{
		return listaInscripciones.get(nroIns);
		/*boolean encontre=false;
		int i=0;
		
		while (!encontre && i<listaInscripciones.size())
		{
			if(nroIns!=listaInscripciones.get(i).getNroInscripcion())
				i++;
		}
		return listaInscripciones.get(i);*/
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
