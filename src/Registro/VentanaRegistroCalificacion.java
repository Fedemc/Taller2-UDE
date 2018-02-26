package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRegistroCalificacion {

	private JFrame frmRegistroDeCalificacin;
	private JTextField textFieldCedulaAlumno;
	private JTextField textFieldCalificacion;
	private JTextField textFieldNroInscripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroCalificacion window = new VentanaRegistroCalificacion();
					window.frmRegistroDeCalificacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistroCalificacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeCalificacin = new JFrame();
		frmRegistroDeCalificacin.setTitle("Registro de calificaci\u00F3n");
		frmRegistroDeCalificacin.setBounds(100, 100, 511, 349);
		frmRegistroDeCalificacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeCalificacin.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCedulaDelAlumno = new JLabel("Cedula del alumno");
		frmRegistroDeCalificacin.getContentPane().add(lblCedulaDelAlumno, "8, 4");
		
		textFieldCedulaAlumno = new JTextField();
		frmRegistroDeCalificacin.getContentPane().add(textFieldCedulaAlumno, "12, 4, fill, default");
		textFieldCedulaAlumno.setColumns(10);
		
		JLabel lblCalificacin = new JLabel("Calificaci\u00F3n");
		frmRegistroDeCalificacin.getContentPane().add(lblCalificacin, "8, 8");
		
		textFieldCalificacion = new JTextField();
		frmRegistroDeCalificacin.getContentPane().add(textFieldCalificacion, "12, 8, fill, default");
		textFieldCalificacion.setColumns(10);
		
		JLabel lblNroDeInscripcin = new JLabel("Nro. de inscripci\u00F3n");
		frmRegistroDeCalificacin.getContentPane().add(lblNroDeInscripcin, "8, 12");
		
		textFieldNroInscripcion = new JTextField();
		frmRegistroDeCalificacin.getContentPane().add(textFieldNroInscripcion, "12, 12, fill, default");
		textFieldNroInscripcion.setColumns(10);
		
		JButton btnRegistrarCalificacin = new JButton("Registrar calificaci\u00F3n");
		frmRegistroDeCalificacin.getContentPane().add(btnRegistrarCalificacin, "12, 16");
		
		JButton btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		frmRegistroDeCalificacin.getContentPane().add(btnCancelarYVolver, "12, 20");
	}

}
