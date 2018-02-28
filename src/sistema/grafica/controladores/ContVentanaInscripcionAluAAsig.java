package sistema.grafica.controladores;

import sistema.logica.ICapaLogica;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import sistema.grafica.ventanas.VentanaInscripcionAluAAsig;
import sistema.grafica.ventanas.VentanaListadoAluApe;
import sistema.excepciones.*;
import java.rmi.RemoteException;

public class ContVentanaInscripcionAluAAsig {
	private ICapaLogica fachada;
	private VentanaInscripcionAluAAsig ventInscripcion;
	
	public ContVentanaInscripcionAluAAsig(VentanaInscripcionAluAAsig vent) {
		ventInscripcion = vent;
		
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
	
	public void inscribirAlumnoAsig(long ced, String cod, int monto){
		try {
			fachada.inscripcionAsignatura(ced, cod, monto);
			ventInscripcion.mostrarResultado("Alumno inscripto con éxito");
		}
		catch (AsignaturaException asigEx) {
			ventInscripcion.mostrarError(asigEx.darMensaje());
		}
		catch (AlumnoException aluEx) {
			ventInscripcion.mostrarError(aluEx.darMensaje());
		}
		catch (InscripcionException insEx) {
			ventInscripcion.mostrarError(insEx.darMensaje());
		}
		catch (RemoteException remEx) {
			ventInscripcion.mostrarError(remEx.toString());
		}
	}
	
}
