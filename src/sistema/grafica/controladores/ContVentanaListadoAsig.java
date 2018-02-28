package sistema.grafica.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.*;
import javax.swing.*;

import sistema.grafica.ventanas.VentanaListadoAsig;
import sistema.logica.ICapaLogica;
import sistema.logica.valueObjects.*;
import java.rmi.RemoteException;
import sistema.excepciones.AsignaturaException;

public class ContVentanaListadoAsig {
	
	private ICapaLogica fachada;
	private VentanaListadoAsig ventListadoAsig;
	
	public ContVentanaListadoAsig(VentanaListadoAsig vListAsig) {
		ventListadoAsig = vListAsig;
		
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
	
	public ArrayList<VOAsignatura> cargarDatos() {
		VOAsignaturas voas = new VOAsignaturas();
		ArrayList<VOAsignatura> listado = new ArrayList<VOAsignatura>();
		try {
			//Obtengo el listado de asignaturas.
			voas = fachada.listadoAsignaturas();
			listado = voas.getVOAsignaturasArray();
			
		}
		catch(AsignaturaException asigEx) {
			ventListadoAsig.mostrarError(asigEx.toString());
		}
		catch(RemoteException remEx) {
			ventListadoAsig.mostrarError(remEx.toString());
		}
		return listado;
	}

}
