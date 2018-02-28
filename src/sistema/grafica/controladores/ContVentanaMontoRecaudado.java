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
import sistema.excepciones.PersistenciaException;
import sistema.grafica.ventanas.VentanaMontoRecaudado;
import sistema.excepciones.AlumnoException;


public class ContVentanaMontoRecaudado
{
	private ICapaLogica fachada;
	private VentanaMontoRecaudado ventMontRec;
	
	public ContVentanaMontoRecaudado(VentanaMontoRecaudado venMontoRec)
	{
		ventMontRec=venMontoRec;
		
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
			fachada= (ICapaLogica) Naming.lookup(ruta);
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
	
	public float ObtenerMontoRecaudado(long ci, int anioLec)
	{
		float res=0;
		try
		{
			res=fachada.montoTotalPorInscripciones(ci, anioLec);
		}
		catch(AlumnoException alEx)
		{
			ventMontRec.mostrarError(alEx.darMensaje());
		}
		catch(RemoteException remEx)
		{
			ventMontRec.mostrarError(remEx.toString());
		}
		
		return res;
	}
	
}
