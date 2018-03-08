package sistema.cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import sistema.logica.ICapaLogica;
import sistema.logica.valueObjects.*;
import sistema.excepciones.*;

import  sistema.grafica.ventanas.*;
import sistema.grafica.controladores.ContSingleton;

public class MainCliente
{
	private ICapaLogica interfazFachada;
	private ContSingleton singleton;
	
	public static void main(String[] args)
	{
		/*
		try
		{
			
			//Intento conectarme
			Properties p=new Properties();
			String nomArch="config/config.properties";
			p.load(new FileInputStream(nomArch));
			String ip=p.getProperty("ipServidor");
			String puerto=p.getProperty("puertoServidor");
			String ruta="//"+ip+":"+puerto+"/fachada";
			
			//Voy a buscar el objeto remoto
			ICapaLogica interfazFachada= (ICapaLogica) Naming.lookup(ruta);
			*/
			
			//Llamar ventana
			VentanaPrincipal vPrinc = new VentanaPrincipal();
			vPrinc.setVisible(true);
			
			
			/*
			//Listo asignaturas desde cliente
			try
			{
				VOAsignaturas voAs=interfazFachada.listadoAsignaturas();
				System.out.println("Voy a listar desde cliente: ");
				for(VOAsignatura voAsig: voAs.getVOAsignaturasArray())
				{
					System.out.println(voAsig.toString());
				}
			}
			catch(AsignaturaException aEx)
			{
				System.out.println(aEx.darMensaje());
			}
			
			//Prueba inscripciones
			System.out.println("Voy a ingresar: ");
			try 
			{
				System.out.println("Antes de ingresar");
				//agrego inscripcion
				interfazFachada.inscripcionAsignatura((long)1, "asignatura 1",2500);
				interfazFachada.inscripcionAsignatura((long)1, "asig 2", 5045);
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
			
			System.out.println("Ingresé!");
			*/
			
		
	}
}
