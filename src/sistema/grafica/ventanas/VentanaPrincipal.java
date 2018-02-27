package sistema.grafica.ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sistema.grafica.ventanas.*;


public class VentanaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Flow Layout");
		frame.setBounds(100, 100, 512, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmEjecutarRespaldo = new JMenuItem("Ejecutar respaldo");
		mnArchivo.add(mntmEjecutarRespaldo);
		
		mntmEjecutarRespaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRespaldo ventRespaldo = new VentanaRespaldo();
				ventRespaldo.setVisible(true);
			}
		});
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmRegistrarAsignatura = new JMenuItem("Registrar asignatura");
		mnRegistro.add(mntmRegistrarAsignatura);
		
		JMenuItem mntmRegistrarAlumno = new JMenuItem("Registrar alumno");
		mnRegistro.add(mntmRegistrarAlumno);
		
		JMenuItem mntmInscribirAlumnoEn = new JMenuItem("Inscribir alumno en asignatura");
		mnRegistro.add(mntmInscribirAlumnoEn);
		
		JMenuItem mntmModificarDatosDe = new JMenuItem("Modificar datos de alumno");
		mnRegistro.add(mntmModificarDatosDe);
		
		JMenuItem mntmRegistrarCalificacin = new JMenuItem("Registrar calificaci\u00F3n");
		mnRegistro.add(mntmRegistrarCalificacin);
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmListadoDeAsignaturas = new JMenuItem("Listado de asignaturas");
		mnListados.add(mntmListadoDeAsignaturas);
		
		JMenuItem mntmListadoDeAlumnos = new JMenuItem("Listado de alumnos por apellido");
		mnListados.add(mntmListadoDeAlumnos);
		
		JMenuItem mntmListadoDetalladoDe = new JMenuItem("Listado detallado de alumno");
		mntmListadoDetalladoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoAlumnoDetallado ventAlumn = new ListadoAlumnoDetallado();
				ventAlumn.setVisible(true);
			}
		});
		mnListados.add(mntmListadoDetalladoDe);
		
		JMenuItem mntmListadoDeEgresados = new JMenuItem("Listado de egresados");
		mnListados.add(mntmListadoDeEgresados);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmMontoRecaudadoPor = new JMenuItem("Monto recaudado por inscripciones");
		mnConsultas.add(mntmMontoRecaudadoPor);
		
		JMenuItem mntmConsultaDeEscolaridad = new JMenuItem("Consulta de escolaridad");
		mnConsultas.add(mntmConsultaDeEscolaridad);
		
		JLabel logotipo = new JLabel("");
		Image logoSmall = new ImageIcon(this.getClass().getResource("/LogoSmall.png")).getImage();
		logotipo.setIcon(new ImageIcon(logoSmall));
		frame.getContentPane().add(logotipo);
		
		
		
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}

}
