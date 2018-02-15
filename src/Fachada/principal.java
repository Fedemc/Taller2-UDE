package Fachada;


import java.util.*;
//import java.util.TreeMap;

public class principal {

	public static void main(String[] args) {
		
		
		/*TreeMap<Long,Alumno> a = new TreeMap<Long,Alumno>();*/
		
		Alumnos a = new Alumnos();
		
		Alumno a1 =  new Alumno(1,"andres","zubi","br",99,"sss@");
		Alumno a2 =  new Alumno(5,"car","cha","sr",88,"hooo@");
		Alumno a3 =  new Alumno(2,"fed","kol","pp",66,"ppp@");
		a.insert(a1);
		a.insert(a2);
		a.insert(a3);
		
		Iterator iter = a.crearIterador();
		
		while(iter.hasNext()) {
			long ced = (long) iter.next();
			VOAlumno voa = new VOAlumno(a.find(ced).getCedula(), a.find(ced).getNombre(), a.find(ced).getApellido());
			System.out.println(voa.toString());
		}
		
	}

}
