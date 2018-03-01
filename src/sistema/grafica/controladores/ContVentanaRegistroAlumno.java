package sistema.grafica.controladores;

import sistema.logica.ICapaLogica;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.io.IOException;

import sistema.grafica.ventanas.VentanaRegistroAlumno;

public class ContVentanaRegistroAlumno
{
	private VentanaRegistroAlumno ventRegAlu;
	private ICapaLogica interfazFachada;
	

	public ContVentanaRegistroAlumno(VentanaRegistroAlumno vent)
	{
		ventRegAlu=vent;
		
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
			interfazFachada= (ICapaLogica) Naming.lookup(ruta);
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
	
	

}