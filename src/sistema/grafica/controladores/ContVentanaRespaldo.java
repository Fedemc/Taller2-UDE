package sistema.grafica.controladores;

import sistema.logica.ICapaLogica;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;
import java.io.IOException;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.io.IOException;
import sistema.excepciones.PersistenciaException;
import sistema.grafica.ventanas.VentanaRespaldo;


public class ContVentanaRespaldo
{
	private ICapaLogica fachada;
	private VentanaRespaldo ventResp;
	
	public ContVentanaRespaldo(VentanaRespaldo venRes)
	{
		ventResp=venRes;
		
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
	
	public void Respaldar()
	{
		try
		{
			fachada.respaldarDatos();
			ventResp.mostrarResultado("Respaldo exitoso!");
		}
		catch(PersistenciaException perEx)
		{
			ventResp.mostrarResultado(perEx.darMensaje());
		}
		catch(RemoteException remEx)
		{
			ventResp.mostrarResultado(remEx.toString());
		}
		catch(IOException ioEx)
		{
			ventResp.mostrarResultado(ioEx.toString());
		}
		
	}
	

}
