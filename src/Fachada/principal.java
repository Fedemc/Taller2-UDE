package Fachada;


import java.util.*;
//import java.util.TreeMap;

public class principal {

	public static void main(String[] args) {
		
		
		long ced = 2;
		String ape = "zu";
		
		Alumno a1 =  new Alumno(1,"andres","zubbb","br",99,"sss@");
		Alumno a2 =  new Alumno(5,"car","zulll","sr",88,"hooo@");
		Becado b1 =  new Becado(2,"fed","chaa","pp",66,"ppp@",null, 20,"alumno estudioso");
		
		
		Alumnos a = new Alumnos();
		
		a.insert(a1);
		a.insert(a2);
		a.insert(b1);
		
		/*
		//prueba datos del becado
		VOBecadoDetallado vob = new VOBecadoDetallado(null, null, null, null, 0, null, null, null, null);
		vob = a.ListadoAlumnoCedulaBec(ced);
		System.out.println(vob);
		*/
		
		/*
		//prueba de listado por apellido
		List<VOAlumno> vOAlumnos = new ArrayList<>();
		vOAlumnos = a.ListadoAlumnosApe(ape);
		Iterator it = vOAlumnos.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		*/
		
		/*
		//prueba busqueda por ci
		VOAlumno voa = new VOAlumno(a.ListadoAlumnoCedulaCom((long) ced).getCedula(), a.ListadoAlumnoCedulaCom((long) ced).getNombre(), a.ListadoAlumnoCedulaCom((long) ced).getApellido());
		System.out.println(voa);
		*/
		
		/*
		//Prueba treemap con VO
		TreeMap<Long,Alumno> a = new TreeMap<Long,Alumno>();
		a.put(a1.getCedula(), a1);
		a.put(a2.getCedula(), a2);
		a.put(a3.getCedula(), a3);
		
		Iterator iter = a.keySet().iterator();
		while(iter.hasNext()) {
			long ced = (long) iter.next();
			VOAlumno voa = new VOAlumno(a.get(ced).getCedula(), a.get(ced).getNombre(), a.get(ced).getApellido());
			System.out.println(voa.toString());
		}*/
		
	}

}
