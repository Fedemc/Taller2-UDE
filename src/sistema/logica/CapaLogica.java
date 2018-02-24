package sistema.logica;
import sistema.logica.alumnos.*;
import sistema.logica.asignaturas.*;
import sistema.logica.inscripciones.*;
import sistema.logica.valueObjects.*;
import sistema.persistencia.Respaldo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import sistema.excepciones.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CapaLogica extends UnicastRemoteObject implements ICapaLogica
{
	
	Alumnos alumnos = null;
	Asignaturas asignaturas = null; 
	Monitor monitor=new Monitor();
	private static final long serialVersionUID = 1L;
	
	public CapaLogica() throws RemoteException
	{
		
	}	
	
	public void crearColeccionesFachada() throws RemoteException
	{
		alumnos= new Alumnos();
		asignaturas= new Asignaturas();
	}

	/*Req. 1: Registrar una asignatura en el sistema. */
	public void registrarAsignatura (Asignatura as) throws AsignaturaException, RemoteException 
	{
		monitor.comienzoEscritura();
		if (asignaturas.getTope() >= 10)
		{
			monitor.terminoEscritura();
			String msj="Error: Ya existen 10 asignaturas registradas en el sistema";
			throw new AsignaturaException(msj);
		}
		else
		{
			if  (asignaturas.memberAsignatura(as.getCodigo()))
			{
				monitor.terminoEscritura();
				String msj="Error: Ya existe una asignatura con ese código ingresada en el sistema";
				throw new AsignaturaException(msj);
			}
			else
			{
				asignaturas.insertAsignatura(as);
				monitor.terminoEscritura();
			}
		}
	}
	
	/*Req. 2: Registro de un alumno en el sistema.*/
	public void registrarAlumno(Alumno al) throws AlumnoException, RemoteException 
	{
		monitor.comienzoEscritura();
		if (alumnos.member(al.getCedula()))
		{
			//System.out.println("Exception alumno ya registrado.");
			monitor.terminoEscritura();
			String msj= "Error: Ya existe un alumno con la cédula en el sistema.";
			throw new AlumnoException(msj);
		}
		else
		{
			monitor.terminoEscritura();
			alumnos.insert(al); //Falta ver becado
		}
			
	}
	
	/*Req. 3: Modificación de datos de un alumno (Domicilio, teléfono y dirección de correo electrónico.*/
	public void modificarDatosAlumno(Long ced, String dom, int tel, String email) throws AlumnoException, RemoteException 
	{
		monitor.comienzoEscritura();
		if (alumnos.member(ced)) 
		{
			if (!(dom.isEmpty()))
			{
				monitor.terminoEscritura();
				alumnos.find(ced).setDomicilio(dom);
			}
			else
			{
				monitor.terminoEscritura();
				String msj= "Error: No se puede ingresar un domicilio vacío.";
				throw new AlumnoException(msj);
			}
			if (tel != 0)
			{
				alumnos.find(ced).setTelefono(tel);
				monitor.terminoEscritura();
			}
				
			else
			{
				monitor.terminoEscritura();
				String msj= "Error: No se puede ingresar un telefono vacío";
				throw new AlumnoException(msj);
			}
			if (!(email.isEmpty()))
			{
				alumnos.find(ced).setEmail(email);
				monitor.terminoEscritura();
			}
				
			else
			{
				monitor.terminoEscritura();
				String msj= "Error: No se puede ingresar una direccion de correo vacía";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			monitor.terminoEscritura();
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
	}
	
	/*Req. 4: Listado de asignaturas*/
	public VOAsignaturas listadoAsignaturas() throws AsignaturaException, RemoteException 
	{
		VOAsignaturas voas = new VOAsignaturas();
		monitor.comienzoLectura();
		if (asignaturas.getTope() == 0)
		{
			monitor.terminoLectura();
			String msj="Error: No hay asignaturas registrados.";
			throw new AsignaturaException(msj);
		}
		else
		{
			voas = asignaturas.listadoAsignaturas();
			monitor.terminoLectura();
		}
			
		return voas;
	}
	
	/*Req. 5: Listado de alumnos cuyo apellido empiece con un substring dado.*/
	public VOAlumnos listadoAlumnoApellido (String s) throws AlumnoException, RemoteException 
	{
		VOAlumnos voas = new VOAlumnos();
		monitor.comienzoLectura();
		if (alumnos.getCantidadElementos() == 0)
		{
			monitor.terminoLectura();
			String msj="Error: No hay alumnos registrados.";
			throw new AlumnoException(msj);
		}
		else
		{
			monitor.terminoLectura();
			voas = alumnos.ListadoAlumnosApe(s);
		}
			
		return voas;
	}
	
	/*Req. 6: Listado detallado de un alumno, dada una cedula. Si es becado, también listar detalles de la beca.*/
	public VOAlumnoDetallado listadoAlumnoCedulaComun(Long ced) throws AlumnoException, RemoteException
	{
		VOAlumnoDetallado voad = new VOAlumnoDetallado();
		monitor.comienzoLectura();
		if (alumnos.member(ced))
		{
			voad = alumnos.ListadoAlumnoCedulaCom(ced);
			monitor.terminoLectura();
		}
		else
		{
			monitor.terminoLectura();
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		return voad;
	}
	
	public VOBecadoDetallado listadoAlumnoCedulaBecado(Long ced) throws AlumnoException, RemoteException
	{
		VOBecadoDetallado vobd = new VOBecadoDetallado();
		monitor.comienzoLectura();
		if (alumnos.member(ced))
		{
			vobd = alumnos.ListadoAlumnoCedulaBec(ced);
			monitor.terminoLectura();
		}
		else
		{
			monitor.terminoLectura();
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		return vobd;
	}
	
	/*Req. 7: Registrar la inscripcion de un alumno.*/
	public void inscripcionAsignatura(Long ced, String cod) throws AsignaturaException, AlumnoException, InscripcionException, RemoteException
	{
		monitor.comienzoEscritura();
		if (asignaturas.memberAsignatura(cod)) 
		{
			if (alumnos.member(ced)) 
			{
				Alumno alu = alumnos.find(ced);
				boolean retorno=false;
				try
				{
					retorno=alu.esValidaInscripcion(cod);
				}
				catch(InscripcionException inscEx)
				{
					monitor.terminoEscritura();
					throw new InscripcionException(inscEx.darMensaje());
				}
				
				if (retorno) 
				{
					int nroInscripcion= alu.getInscripciones().getListaInscripciones().size() +1;
					Inscripcion i = new Inscripcion(nroInscripcion, 1000 ,asignaturas.findAsignatura(cod));
					alu.registrarInscripcion(i);
					monitor.terminoEscritura();
				}
				else
				{
					monitor.terminoEscritura();
					String msj="Error: La inscripcion no es valida. Ya se registró una inscripción para esa materia en el año actual";
					throw new InscripcionException(msj);
				}
			}
			else
			{
				monitor.terminoEscritura();
				String msj= "Error: No existe un alumno con esa cedula en el sistema.";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			monitor.terminoEscritura();
			String msj="Error: No se encontro la asignatura en el sistema.";
			throw new AsignaturaException(msj);
		}
	}
	
	/*Req. 8: Registro de resultado de una asignatura. */
	public void registrarResultadoAsignatura(long ced, int codIns, int nota) throws AlumnoException, InscripcionException, RemoteException
	{
		monitor.comienzoEscritura();
		if(alumnos.member(ced)) {
			if(alumnos.find(ced).getInscripciones().member(codIns)) {
				if(alumnos.find(ced).getInscripciones().find(codIns).getCalificacion()>0) 
				{
					String msj="Error: El alumno ya tuvo calificacion para esta inscripcion.";
					throw new InscripcionException(msj);
				}
				else 
				{
					alumnos.find(ced).getInscripciones().find(codIns).setCalificacion(nota);
					if(nota>=6) 
					{
						alumnos.find(ced).setCantAprobaciones(alumnos.find(ced).getCantAprobaciones()+1);
					}
				}
			}
			else 
			{
				String msj="Error: El alumno no tiene una inscripcion con el codigo dado.";
				throw new InscripcionException(msj);
			}	
		}else {
			String msj="Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		monitor.terminoEscritura();
	}
	
	/*Req. 9: Monto recaudado por inscripcioens. */
	public float montoTotalPorInscripciones(long ced, int anio) throws AlumnoException, RemoteException
	{
		float montoTotal=0;
		
		monitor.comienzoLectura();
		if(alumnos.member(ced))
		{
			Alumno aluTemp=alumnos.find(ced); //Obtengo el alumno por su cedula
			Inscripciones auxIns=aluTemp.getInscripciones();	//Obtengo las inscripciones del alumno
			for(Inscripcion ins: auxIns.getListaInscripciones())	//Recorro las inscripciones
			{
				if(ins.getAnioLectivo() == anio)	//verifico que el anio de la inscripcion en la que estoy parado sea igual al anio lectivo ingresado por parametro
				{
					montoTotal=montoTotal + ins.getMontoBase();
				}
			}
			//Verifico si es becado, si lo es aplico el descuento correspondiente
			if(alumnos.find(ced) instanceof Becado)
			{
				float porcentaje=((Becado)aluTemp).getPorcentaje() / 100;
				montoTotal=montoTotal - (montoTotal * porcentaje);
			}
			monitor.terminoEscritura();
		}
		else
		{
			monitor.terminoEscritura();
			String msj="Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		return montoTotal;
	}
	
	/*Req. 10: Respaldo de datos. */
	public void respaldarDatos() throws PersistenciaException, IOException, RemoteException
	{
		Respaldo res= new Respaldo();
		
		try
		{
			Properties p=new Properties();
			String nomArch = "config/config.properties";
			
			//Abro el archivo properties
			p.load(new FileInputStream(nomArch));
			String datosRespaldoAsignaturas= p.getProperty("rutaRespaldoAsignaturas");
			String datosRespaldoAlumnos= p.getProperty("rutaRespaldoAlumnos");

			//Respaldar datos
			try
			{
				res.respaldarAsignaturas(datosRespaldoAsignaturas, asignaturas);
				res.respaldarAlumnos(datosRespaldoAlumnos, alumnos);
			}
			catch(PersistenciaException pExc)
			{
				pExc.darMensaje();
			}		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//Restaurar datos
	public void restaurarDatos() throws PersistenciaException, IOException, RemoteException
	{
		Respaldo res= new Respaldo();
		
		try
		{
			Properties p=new Properties();
			String nomArch = "config/config.properties";
			
			//Abro el archivo properties
			p.load(new FileInputStream(nomArch));
			String datosRespaldoAsignaturas= p.getProperty("rutaRespaldoAsignaturas");
			String datosRespaldoAlumnos= p.getProperty("rutaRespaldoAlumnos");

			//Restaurar datos
			try
			{
				asignaturas=res.recuperarAsignaturas(datosRespaldoAsignaturas);
				alumnos=(res.recuperarAlumnos(datosRespaldoAlumnos));
				System.out.println("Datos recuperados.");
			}
			catch(PersistenciaException pExc)
			{
				System.out.println(pExc.darMensaje());
			}		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	/*Req. 11: Consulta parcial o completa de escolaridad de un alumno*/
	public VOInscripciones consultaEscolaridadParcial(Long ced) throws InscripcionException, AlumnoException, RemoteException {
		VOInscripciones vois = new VOInscripciones();
		monitor.comienzoLectura();
		if (alumnos.member(ced)) {
			Alumno aluTemp = alumnos.find(ced);
			vois = aluTemp.consultaEscolaridadParcial();
			if (vois.esVacia()) {
				String msj = "No hay inscripciones para este alumno.";
				throw new InscripcionException(msj);
			}
		}
		else {
			String msj = "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		monitor.terminoLectura();
		return vois;
	}
	
	public VOInscripciones consultaEscolaridadCompleta(Long ced) throws InscripcionException, AlumnoException, RemoteException {
		VOInscripciones vois = new VOInscripciones();
		monitor.comienzoLectura();
		if (alumnos.member(ced)) {
			Alumno aluTemp = alumnos.find(ced);
			vois = aluTemp.consultaEscolaridadCompleta();
			if (vois.esVacia()) {
				String msj = "No hay inscripciones para este alumno.";
				throw new InscripcionException(msj);
			}
		}
		else {
			String msj = "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		monitor.terminoLectura();
		return vois;
	}
	
	/*Req. 12: Listado parcial o completo de alumnos egresados*/
	public VOAlumnos listadoEgresadosParcial() throws AlumnoException, RemoteException {
		VOAlumnos voas = new VOAlumnos();
		monitor.comienzoLectura();
		voas = alumnos.listadoEgresadosParcial();
		monitor.terminoLectura();
		if (voas.esVacia()) {
			String msj = "Error: No hay alumnos egresados en el sistema.";
			throw new AlumnoException(msj);
		}
		return voas;
	}
	
	public VOEgresados listadoEgresadosCompleto() throws AlumnoException, RemoteException {
		VOEgresados voegs = new VOEgresados();
		monitor.comienzoLectura();
		voegs = alumnos.listadoEgresadosCompleto();
		monitor.terminoLectura();
		if (voegs.esVacia()) {
			String msj = "Error: No hay alumnos egresados en el sistema.";
			throw new AlumnoException(msj);
		}
		return voegs;
	}
	
}
