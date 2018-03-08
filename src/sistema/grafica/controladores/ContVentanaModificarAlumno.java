package sistema.grafica.controladores;

import sistema.grafica.ventanas.VentanaModificarAlumno;
import sistema.logica.ICapaLogica;

import sistema.excepciones.AlumnoException;
import java.rmi.RemoteException;

public class ContVentanaModificarAlumno {
	private ICapaLogica interfazFachada;
	private VentanaModificarAlumno ventModAlu;
	
	public ContVentanaModificarAlumno(VentanaModificarAlumno vent) {
		ventModAlu = vent;
		interfazFachada=ContSingleton.getInstancia().getInterfazFachada();
	}
	
	public void modificarDatosAlumno(long ced, String dom, int tel, String email) {
		try {
			interfazFachada.modificarDatosAlumno(ced, dom, tel, email);
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
