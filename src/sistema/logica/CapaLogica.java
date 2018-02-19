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
	
	/*Req. 1: Registrar una asignatura en el sistema. */
	public void registrarAsignatura (Asignatura as) throws AsignaturaException {
		if (asignaturas.getTope() >= 10)
		{
			String msj="Error: Ya existen 10 asignaturas registradas en el sistema";
			throw new AsignaturaException(msj);
		}
		else
		{
			if  (asignaturas.memberAsignatura(as.getCodigo()))
			{
				String msj="Error: Ya existe una asignatura con ese código ingresada en el sistema";
				throw new AsignaturaException(msj);
			}
			else
				asignaturas.insertAsignatura(as);
		}
	}
	
	/*Req. 2: Registro de un alumno en el sistema.*/
	public void registrarAlumno(Alumno al) throws AlumnoException {
		if (alumnos.member(al.getCedula()))
		{
			//System.out.println("Exception alumno ya registrado.");
			String msj= "Error: Ya existe un alumno con la cédula en el sistema.";
			throw new AlumnoException(msj);
		}
		else
			alumnos.insert(al); //Falta ver becado
	}
	
	/*Req. 3: Modificación de datos de un alumno (Domicilio, teléfono y dirección de correo electrónico.*/
	public void modificarDatosAlumno(Long ced, String dom, int tel, String email) throws AlumnoException {
		if (alumnos.member(ced)) 
		{
			if (!(dom.isEmpty()))
				alumnos.find(ced).setDomicilio(dom);
			else
			{
				String msj= "Error: No se puede ingresar un domicilio vacío.";
				throw new AlumnoException(msj);
			}
			if (tel != 0)
				alumnos.find(ced).setTelefono(tel);
			else
			{
				String msj= "Error: No se puede ingresar un telefono vacío";
				throw new AlumnoException(msj);
			}
			if (!(email.isEmpty()))
				alumnos.find(ced).setEmail(email);
			else
			{
				String msj= "Error: No se puede ingresar una direccion de correo vacía";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
	}
	
	/*Req. 4: Listado de asignaturas*/
	public VOAsignaturas listadoAsignaturas() throws AsignaturaException {
		VOAsignaturas voas = new VOAsignaturas();
		if (asignaturas.getTope() == 0)
		{
			String msj="Error: No hay asignaturas registrados.";
			throw new AsignaturaException(msj);
		}
		else
			voas = asignaturas.listadoAsignaturas();
		return voas;
	}
	
	/*Req. 5: Listado de alumnos cuyo apellido empiece con un substring dado.*/
	public VOAlumnos listadoAlumnoApellido (String s) throws AlumnoException {
		VOAlumnos voas = new VOAlumnos();
		if (alumnos.getCantidadElementos() == 0)
		{
			String msj="Error: No hay alumnos registrados.";
			throw new AlumnoException(msj);
		}
		else
			voas = alumnos.ListadoAlumnosApe(s);
		return voas;
	}
	
	/*Req. 6: Listado detallado de un alumno, dada una cedula. Si es becado, también listar detalles de la beca.*/
	public VOAlumnoDetallado listadoAlumnoCedulaComun(Long ced) throws AlumnoException{
		VOAlumnoDetallado voad = new VOAlumnoDetallado();
		if (alumnos.member(ced))
			voad = alumnos.ListadoAlumnoCedulaCom(ced);
		else
		{
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		return voad;
	}
	
	public VOBecadoDetallado listadoAlumnoCedulaBecado(Long ced) throws AlumnoException{
		VOBecadoDetallado vobd = new VOBecadoDetallado();
		if (alumnos.member(ced))
			vobd = alumnos.ListadoAlumnoCedulaBec(ced);
		else
		{
			String msj= "Error: No existe un alumno con esa cedula en el sistema.";
			throw new AlumnoException(msj);
		}
		return vobd;
	}
	
	/*Req. 7: Registrar la inscripcion de un alumno.*/
	public void inscripcionAsignatura(Long ced, String cod) throws AsignaturaException, AlumnoException, InscripcionException{
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
					throw new InscripcionException(inscEx.darMensaje());
				}
				if (retorno) 
				{
					Inscripcion i = new Inscripcion(1000,asignaturas.findAsignatura(cod));
					alu.registrarInscripcion(i);
				}
				else
				{
					String msj="Error: La inscripcion no es valida. Ya se registró una inscripción para esa materia en el año actual";
					throw new InscripcionException(msj);
				}
			}
			else
			{
				String msj= "Error: No existe un alumno con esa cedula en el sistema.";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			String msj="Error: No se encontro la asignatura en el sistema.";
			throw new AsignaturaException(msj);
		}
	}
	
	/*Req. 8: Registro de resultado de una asignatura. */
	public void registrarResultadoAsignatura(long ced, int codIns, int nota) throws AlumnoException, InscripcionException
	{
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
					}
					else
					{
						String msj="Error: El alumno es egresado, no se puede asignar la calificacion";
						throw new AlumnoException(msj);
					}					
				}
				else
				{
					String msj="Error: No existe una inscripcion para el alumno con ese nro de inscripcion.";
					throw new InscripcionException(msj);
				}
			}
			else
			{
				String msj="Error: No existe un alumno con esa cedula en el sistema.";
				throw new AlumnoException(msj);
			}
		}
		else
		{
			String msj="Error: La nota debe ser un valor entre 1 y 12";
			throw new InscripcionException(msj);
		}			
	}
	
	/*Req. 9: Monto recaudado por inscripcioens. */
	public float montoTotalPorInscripciones(long ced, int anio) throws AlumnoException
	{
		float montoTotal=0;
		
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
		}
		else
		{
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
