package sistema.grafica.controladores;

import sistema.logica.ICapaLogica;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.util.Properties;
import java.rmi.RemoteException;

import sistema.grafica.ventanas.VentanaEscolaridad;
import sistema.logica.valueObjects.VOInscripciones;
import sistema.excepciones.AlumnoException;
import sistema.excepciones.InscripcionException;

public class ContVentanaEscolaridad 
{
	ICapaLogica interfazFachada;
	VentanaEscolaridad ventEscolaridad;
	
	public ContVentanaEscolaridad(VentanaEscolaridad ventEsc)
	{
		ventEscolaridad=ventEsc;
		
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
	
	public VOInscripciones crearListadoEscolaridad(long ced, boolean esCompleto)
	{
		VOInscripciones voins=new VOInscripciones();
		
		try
		{
			if(esCompleto)
			{
				voins=interfazFachada.consultaEscolaridadCompleta(ced);
			}
			else
			{
				voins=interfazFachada.consultaEscolaridadParcial(ced);
			}
			
		}
		catch(RemoteException remEx)
		{
			ventEscolaridad.mostrarError(remEx.toString());
		}
		catch(AlumnoException aluEx)
		{
			ventEscolaridad.mostrarError(aluEx.darMensaje());
		}
		catch(InscripcionException inscrEx)
		{
			ventEscolaridad.mostrarError(inscrEx.darMensaje());
		}
		
		return voins;
	}
}
