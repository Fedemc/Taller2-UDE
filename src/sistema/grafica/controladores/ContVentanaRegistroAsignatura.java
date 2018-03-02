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
import sistema.grafica.ventanas.VentanaRegistroAsignatura;
import sistema.logica.ICapaLogica;
import sistema.logica.asignaturas.Asignatura;

public class ContVentanaRegistroAsignatura {
	
	private ICapaLogica interfazFachada;
	private VentanaRegistroAsignatura ventRegAsignatura;

	public ContVentanaRegistroAsignatura(VentanaRegistroAsignatura asig){
		ventRegAsignatura = asig;
		
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
	
	public void registrarAsignatura (String codigo, String nombre, String descripcion) {
		
		Asignatura as = new Asignatura(codigo, nombre, descripcion);
		
		try
		{
			interfazFachada.registrarAsignatura(as);
			ventRegAsignatura.mostrarError("Asignatura ingresada correctamente!");
			
		}
		catch(AsignaturaException res)
		{
			ventRegAsignatura.mostrarError(res.toString());;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
