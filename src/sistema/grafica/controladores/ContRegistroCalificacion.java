package sistema.grafica.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import sistema.excepciones.AlumnoException;
import sistema.excepciones.AsignaturaException;
import sistema.excepciones.InscripcionException;
import sistema.grafica.ventanas.VentanaListadoAlumnoDetallado;
import sistema.grafica.ventanas.VentanaRegistroCalificacion;
import sistema.logica.ICapaLogica;
import sistema.logica.inscripciones.Inscripciones;
import sistema.logica.valueObjects.VOAlumnoDetallado;
import sistema.logica.valueObjects.VOInscripciones;

public class ContRegistroCalificacion{

	private ICapaLogica interfazFachada;
	private VentanaRegistroCalificacion ventRegCalif;
	
	public ContRegistroCalificacion(VentanaRegistroCalificacion vRegCal) {
		ventRegCalif = vRegCal;
		
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
	
	public void registrarCalificacion (long ced, int codIns, int nota) throws AlumnoException, InscripcionException, RemoteException {
		
		try {
			interfazFachada.registrarResultadoAsignatura(ced, codIns, nota);
			ventRegCalif.mostrarResultado("Calificacion ingresada!");
		}
		catch (InscripcionException insEx) {
			ventRegCalif.mostrarError(insEx.darMensaje());
		}
		catch (AlumnoException aluEx) {
			ventRegCalif.mostrarError(aluEx.darMensaje());
		}
		catch (RemoteException remEx) {
			ventRegCalif.mostrarError(remEx.toString());
		}
	}
	
	
	

	
}
