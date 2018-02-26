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

public class MainCliente
{
	public static void main(String[] args)
	{
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
			
			
			//Llamar ventana
			VentanaPrincipal vPrinc = new VentanaPrincipal();
			vPrinc.setVisible(true);
			
			
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
