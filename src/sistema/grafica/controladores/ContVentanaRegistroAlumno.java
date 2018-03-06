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
import sistema.logica.alumnos.Alumno;
import sistema.logica.alumnos.Becado;
import sistema.excepciones.AlumnoException;

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
	
	public void crearAlumno(long ced, String nom, String ape, String dom, int tel, String mail) 
	{
		Alumno alu=new Alumno(ced,nom,ape,dom,tel,mail);
		//try y catch de registrarAlumno
		try
		{
			interfazFachada.registrarAlumno(alu);
			ventRegAlu.mostrarResultado("Alumno ingresado correctamente!");
		}
		catch(AlumnoException alEx)
		{
			ventRegAlu.mostrarError(alEx.darMensaje());
		}
		catch(RemoteException remEx)
		{
			ventRegAlu.mostrarError(remEx.toString());
		}
	}
	
	public void crearBecado(long ced, String nom, String ape, String dom, int tel, String mail, int descuento, String descripcion)
	{
		Becado bec=new Becado(ced,nom,ape,dom,tel,mail,descuento,descripcion);
		//try y catch
		try
		{
			//interfazFachada.registrarAlumno(bec, true);
			interfazFachada.registrarBecado(bec);
			ventRegAlu.mostrarResultado("Becado ingresado correctamente!");
		}
		catch(AlumnoException alEx)
		{
			ventRegAlu.mostrarError(alEx.darMensaje());
		}
		catch(RemoteException remEx)
		{
			ventRegAlu.mostrarError(remEx.toString());
		}		
	}
}
