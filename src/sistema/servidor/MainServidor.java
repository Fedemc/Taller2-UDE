package sistema.servidor;

import sistema.excepciones.AlumnoException;
import sistema.excepciones.AsignaturaException;
import sistema.excepciones.InscripcionException;
import sistema.excepciones.PersistenciaException;
import sistema.logica.CapaLogica;
import sistema.logica.valueObjects.VOAsignatura;
import sistema.logica.valueObjects.VOAsignaturas;

import java.util.Properties;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.net.MalformedURLException;

public class MainServidor
{
	public static void main(String[] args)
	{
		try
		{
			//Obtengo datos de config de server
			Properties p=new Properties();
			String nomArch="config/config.properties";
			p.load(new FileInputStream(nomArch));
			String ip=p.getProperty("ipServidor");
			String puerto=p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			
			//Pongo a correr el rmiregistry
			LocateRegistry.createRegistry(port);
			
			//publico el objeto remoto en dicha ip y puerto
			String ruta="//"+ip+":"+puerto+"/fachada";
			CapaLogica fachada=new CapaLogica();
					
			System.out.println("Intento restaurar datos");
			try
			{
				fachada.restaurarDatos();
			}
			catch(PersistenciaException pEx)
			{
				System.out.println(pEx.darMensaje());
				System.out.println("No hay archivos, creo de cero");
				//Si no pudo abrir el respaldo, crear las colecciones vacias
				fachada.crearColeccionesFachada();
			}
			
			System.out.println("Antes de publicar.");
			Naming.rebind(ruta, fachada);
			System.out.println("Luego de publicar.");
			
			/*
			//Prueba inscripciones
			System.out.println("Voy a ingresar: ");
			try 
			{
				System.out.println("Antes de ingresar");
				//agrego inscripcion
				fachada.inscripcionAsignatura((long)1, "asignatura 1",2500);
				fachada.inscripcionAsignatura((long)1, "asig 2", 5045);
				fachada.inscripcionAsignatura((long)1, "asignatura 1",2500);
				System.out.println("Inscripciones realizadas");
			}
			catch (AlumnoException a) 
			{
				System.out.println(a.darMensaje());
			}
			catch (InscripcionException s) 
			{
				System.out.println(s.darMensaje());
			}
			catch (AsignaturaException e) 
			{
				System.out.println(e.darMensaje());
			}
			catch(RemoteException remEx)
			{
				System.out.println(remEx.toString());
			}
			
			System.out.println("Ingres�!");
			*/
		}
		catch(RemoteException rE)
		{
			rE.printStackTrace();
		}
		catch(MalformedURLException mEx)
		{
			mEx.printStackTrace();
		}
		catch(FileNotFoundException fnotfEx)
		{
			fnotfEx.printStackTrace();
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
	}
}
