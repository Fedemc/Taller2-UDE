package sistema.logica.valueObjects;

import java.util.*;

public class VOInscripciones {

		private ArrayList<VOInscripcion> voinscripciones;

		//Constructor.
		public VOInscripciones()
		{	 
			voinscripciones = new ArrayList<VOInscripcion>(); 
		}
		
		public void insert(VOInscripcion voi) 
		{
			voinscripciones.add(voi);
		}
		
		public ArrayList<VOInscripcion> getVOInscripcionesArray()
		{
			return voinscripciones;
		}
		
		public boolean esVacia() {
			return voinscripciones.isEmpty();
		}
		
}

