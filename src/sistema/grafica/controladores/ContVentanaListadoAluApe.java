package sistema.grafica.controladores;

import sistema.grafica.ventanas.VentanaListadoAluApe;
import sistema.grafica.ventanas.VentanaListadoAsig;
import sistema.logica.ICapaLogica;
import sistema.logica.valueObjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import sistema.excepciones.*;
import java.util.ArrayList;



public class ContVentanaListadoAluApe {
	
	private ICapaLogica fachada;
	private VentanaListadoAluApe ventListadoAluApe;
	
	public ContVentanaListadoAluApe(VentanaListadoAluApe ventListAluApe) {
		ventListadoAluApe = ventListAluApe;
		
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
	
	public ArrayList<VOAlumno> cargarDatos(String ape){
		VOAlumnos voas = new VOAlumnos();
		ArrayList<VOAlumno> listado = new ArrayList<VOAlumno>();
		try {
			//Obtengo el listado de asignaturas.
			voas = fachada.listadoAlumnoApellido(ape);
			listado = voas.getVOAlumnosArray();
		}
		catch(AlumnoException aluEx) {
			ventListadoAluApe.mostrarError(aluEx.toString());
		}
		catch(RemoteException remEx) {
			ventListadoAluApe.mostrarError(remEx.toString());
		}
		return listado;
	}

}
