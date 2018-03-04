package sistema.grafica.controladores;

import sistema.grafica.ventanas.VentanaInscripcionAluAAsig;
import sistema.grafica.ventanas.VentanaModificarAlumno;
import sistema.logica.ICapaLogica;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;
import sistema.excepciones.*;
import java.rmi.RemoteException;

public class ContVentanaModificarAlumno {
	private ICapaLogica fachada;
	private VentanaModificarAlumno ventModAlu;
	
	public ContVentanaModificarAlumno(VentanaModificarAlumno vent) {
		ventModAlu = vent;
		
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
	
	public void modificarDatosAlumno(long ced, String dom, int tel, String email) {
		try {
			fachada.modificarDatosAlumno(ced, dom, tel, email);
			ventModAlu.mostrarResultado("Modificación exitosa");
			ventModAlu.limpiarCampos();
		}
		catch (AlumnoException aluEx) {
			ventModAlu.mostrarError(aluEx.darMensaje());
		}
		catch (RemoteException remEx) {
			ventModAlu.mostrarError(remEx.toString());
		}
			
	}
}
