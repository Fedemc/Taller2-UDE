package sistema.persistencia;

import java.io.*;
import sistema.logica.asignaturas.Asignaturas;
import sistema.excepciones.PersistenciaException;

public class Respaldo
{
	public void respaldarAsignaturas(String nomArch, Asignaturas asigns) throws PersistenciaException
	{
		try
		{
			//Buscar archivo
			//Abrirlo
			FileOutputStream f= new FileOutputStream(nomArch);
			ObjectOutputStream o= new ObjectOutputStream(f);
			
			//Guardar coleccion en archivo
			o.writeObject(asigns);
			o.close();
			f.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new PersistenciaException("Error al respaldar");
		}
	}
	
	public Asignaturas recuperarAsignaturas(String nomArch) throws PersistenciaException
	{
		try 
		{
			//Abrir archivo
			FileInputStream f= new FileInputStream(nomArch);
			ObjectInputStream o= new ObjectInputStream(f);
			
			//Leer coleccion de archivo
			Asignaturas asigns= (Asignaturas) o.readObject();
			o.close();
			f.close();
			
			//Devolver coleccion
			return asigns;
		}
		catch (IOException | ClassNotFoundException e)	//Consultar a Sirely si esta bien el ClassNotFoundException
		{
			e.printStackTrace();
			throw new PersistenciaException("Error al restaurar");
		}
	}

}
