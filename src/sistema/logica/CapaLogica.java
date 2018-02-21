package sistema.logica;
import sistema.logica.alumnos.*;
import sistema.logica.asignaturas.*;
import sistema.logica.inscripciones.*;
import sistema.logica.valueObjects.*;
import sistema.persistencia.Respaldo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import sistema.excepciones.*;

public class CapaLogica
{
	Alumnos alumnos = new Alumnos();
	Asignaturas asignaturas = new Asignaturas(); 
	Respaldo res= new Respaldo();
	Monitor monitor=new Monitor();
	
	/*Req. 1: Registrar una asignatura en el sistema. */
	public void registrarAsignatura (Asignatura as) throws AsignaturaException 
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
				String msj="Error: Ya existe una asignatura con ese c�digo ingresada en el sistema";
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
	public void registrarAlumno(Alumno al) throws AlumnoException 
	{
		monitor.comienzoEscritura();
		if (alumnos.member(al.getCedula()))
		{
			//System.out.println("Exception alumno ya registrado.");
			monitor.terminoEscritura();
			String msj= "Error: Ya existe un alumno con la c�dula en el sistema.";
			throw new AlumnoException(msj);
		}
		else
		{
			monitor.terminoEscritura();
			alumnos.insert(al); //Falta ver becado
		}
			
	}
	
	/*Req. 3: Modificaci�n de datos de un alumno (Domicilio, tel�fono y direcci�n de correo electr�nico.*/
	public void modificarDatosAlumno(Long ced, String dom, int tel, String email) throws AlumnoException 
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
				String msj= "Error: No se puede ingresar un domicilio vac�o.";
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
				String msj= "Error: No se puede ingresar un telefono vac�o";
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
				String msj= "Error: No se puede ingresar una direccion de correo vac�a";
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
	public VOAsignaturas listadoAsignaturas() throws AsignaturaException 
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
	public VOAlumnos listadoAlumnoApellido (String s) throws AlumnoException 
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
	
	/*Req. 6: Listado detallado de un alumno, dada una cedula. Si es becado, tambi�n listar detalles de la beca.*/
	public VOAlumnoDetallado listadoAlumnoCedulaComun(Long ced) throws AlumnoException
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
	
	public VOBecadoDetallado listadoAlumnoCedulaBecado(Long ced) throws AlumnoException
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
	public void inscripcionAsignatura(Long ced, String cod) throws AsignaturaException, AlumnoException, InscripcionException
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
					Inscripcion i = new Inscripcion(1000,asignaturas.findAsignatura(cod));
					alu.registrarInscripcion(i);
					monitor.terminoEscritura();
				}
				else
				{
					monitor.terminoEscritura();
					String msj="Error: La inscripcion no es valida. Ya se registr� una inscripci�n para esa materia en el a�o actual";
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
	public void registrarResultadoAsignatura(long ced, int codIns, int nota) throws AlumnoException, InscripcionException
	{
		monitor.comienzoEscritura();
		if(nota>0 && nota<13)
		{
			if(alumnos.member(ced))
			{
				Alumno aluTemp=alumnos.find(ced);
				if(aluTemp.getInscripciones().member(codIns))
				{
					//Verifico que no sea egresado, si lo es NO le modifico las notas
					if(aluTemp.getCantAprobaciones()!=10)
					{
						alumnos.find(ced).getInscripciones().find(codIns).setCalificacion(nota);
						if(nota >= 6)	//Si la nota es de aprobacion, sumo 1 a las aprobaciones del alumno
						{
							alumnos.find(ced).setCantAprobaciones(aluTemp.getCantAprobaciones()+1);
						}
						monitor.terminoEscritura();
					}
					else
					{
						monitor.terminoEscritura();
						String msj="Error: El alumno es egresado, no se puede asignar la calificacion";
						throw new AlumnoException(msj);
					}					
				}
				else
				{
					monitor.terminoEscritura();
					String msj="Error: No existe una inscripcion para el alumno con ese nro de inscripcion.";
					throw new InscripcionException(msj);
				}
			}
			else
			{
				monitor.terminoEscritura();
				String msj="Error: No existe un alumno con esa cedula en el sistema.";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			monitor.terminoEscritura();
			String msj="Error: La nota debe ser un valor entre 1 y 12";
			throw new InscripcionException(msj);
		}			
	}
	
	/*Req. 9: Monto recaudado por inscripcioens. */
	public float montoTotalPorInscripciones(long ced, int anio) throws AlumnoException
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
	//FALTA CAMBIAR ESTOS TRY Y CATCH POR THROWS!!!
	public void respaldarDatos()
	{
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
}
