package sistema.grafica.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import sistema.excepciones.AlumnoException;
import sistema.excepciones.AsignaturaException;
import sistema.excepciones.InscripcionException;
import sistema.excepciones.PersistenciaException;
import sistema.grafica.ventanas.VentanaListadoAlumnoDetallado;
import sistema.logica.ICapaLogica;
import sistema.logica.alumnos.Alumno;
import sistema.logica.asignaturas.Asignatura;
import sistema.logica.valueObjects.VOAlumnoDetallado;
import sistema.logica.valueObjects.VOAlumnos;
import sistema.logica.valueObjects.VOAsignaturas;
import sistema.logica.valueObjects.VOBecadoDetallado;
import sistema.logica.valueObjects.VOEgresados;
import sistema.logica.valueObjects.VOInscripciones;

public class ContVentAlumnoDet {

	private ICapaLogica interfazFachada;
	private VentanaListadoAlumnoDetallado ventAlumDet;
	
	public ContVentAlumnoDet(VentanaListadoAlumnoDetallado ventAlum) {
		ventAlumDet = ventAlum;
		
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
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
	
	public void listar(long ced)
	{
		//Verifico si es alumno o becado y llamo al metodo correspondiente
		try
		{
			if(interfazFachada.consultaEsBecado(ced))
			{
				//llamo al que devuelve VOBecadoDetallado
				generarVOABecadoDet(ced);
			}
			else
			{
				//llamo la que devuelve el VOAlumnoDetallado
				generarVOAAlumnoDet(ced);
			}
		}
		catch(AlumnoException aluEx)
		{
			ventAlumDet.mostrarError(aluEx.darMensaje());			
		}
		catch(RemoteException remEx)
		{
			ventAlumDet.mostrarError(remEx.toString());
		}
		
	}
	
	public void generarVOAAlumnoDet(long ced) 
	{
		VOAlumnoDetallado alu=new VOAlumnoDetallado();
		
		try
		{
			alu=interfazFachada.listadoAlumnoCedulaComun(ced);
			//lo mando a la ventana
			//ventAlumDet.mostrarVOAlumDet(alu);
		}
		catch(AlumnoException aluEx)
		{
			ventAlumDet.mostrarError(aluEx.darMensaje());			
		}
		catch(RemoteException remEx)
		{
			ventAlumDet.mostrarError(remEx.toString());
		}
	}
	
	public void generarVOABecadoDet(long ced) 
	{
		VOBecadoDetallado bec=new VOBecadoDetallado();
		
		try
		{
			bec=interfazFachada.listadoAlumnoCedulaBecado(ced);
			//lo mando a la ventana
			//ventAlumDet.mostrarVOBecDet(alu);
		}
		catch(AlumnoException aluEx)
		{
			ventAlumDet.mostrarError(aluEx.darMensaje());			
		}
		catch(RemoteException remEx)
		{
			ventAlumDet.mostrarError(remEx.toString());
		}
	}
		
		
}
