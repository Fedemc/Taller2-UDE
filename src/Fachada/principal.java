package Fachada;


import java.util.*;
//import java.util.TreeMap;

public class principal {

	public static void main(String[] args) {
		
		
		TreeMap<Long,Alumno> a = new TreeMap<Long,Alumno>();
		
		
		Alumno a1 =  new Alumno(1,"andres","zubi","br",99,"sss@");
		Alumno a2 =  new Alumno(5,"car","cha","sr",88,"hooo@");
		Alumno a3 =  new Alumno(2,"fed","kol","pp",66,"ppp@");
		a.put(a1.getCedula(), a1);
		a.put(a2.getCedula(), a2);
		a.put(a3.getCedula(), a3);
		
		Iterator iter = a.keySet().iterator();
		while(iter.hasNext()) {
			long ced = (long) iter.next();
			VOAlumno voa = new VOAlumno(a.get(ced).getCedula(), a.get(ced).getNombre(), a.get(ced).getApellido());
			System.out.println(voa.toString());
		}
		
	}

}
