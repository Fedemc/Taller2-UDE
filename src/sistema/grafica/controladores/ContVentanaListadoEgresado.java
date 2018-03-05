package sistema.grafica.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import sistema.logica.ICapaLogica;
import sistema.grafica.ventanas.VentanaListadoEgresados;
import sistema.logica.valueObjects.VOEgresados;
import sistema.logica.valueObjects.VOAlumnos;

import java.rmi.RemoteException;
import sistema.excepciones.AlumnoException;

public class ContVentanaListadoEgresado 
{
	private ICapaLogica interfazFachada;
	private VentanaListadoEgresados ventEgr;
	
	public ContVentanaListadoEgresado(VentanaListadoEgresados ventEgresados)
	{
		ventEgr=ventEgresados;
		
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
			interfazFachada = (ICapaLogica) Naming.lookup(ruta);
		}
		catch(MalformedURLException mEx)
		{
			mEx.printStackTrace();			
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();			
		}
		catch(NotBoundException nobEx)
		{
			nobEx.printStackTrace();
		}
	}
	
	
	public void generarListado(boolean esParcial)
	{
		if(esParcial)
		{
			VOAlumnos voAls=new VOAlumnos();
			try
			{
				voAls=interfazFachada.listadoEgresadosParcial();
			}
			catch(RemoteException remEx)
			{
				ventEgr.mostrarError(remEx.toString());
			}
			catch(AlumnoException alEx)
			{
				ventEgr.mostrarError(alEx.darMensaje());
			}
			
			ventEgr.mostrarVOEgrParcial(voAls);
		}
		else
		{
			VOEgresados voEgr=new VOEgresados();
			try
			{
				voEgr=interfazFachada.listadoEgresadosCompleto();
			}
			catch(RemoteException remEx)
			{
				ventEgr.mostrarError(remEx.toString());
			}
			catch(AlumnoException alEx)
			{
				ventEgr.mostrarError(alEx.darMensaje());
			}
			
			ventEgr.mostrarVOEgrCompleto(voEgr);
		}
	}
	
	
	
	
}