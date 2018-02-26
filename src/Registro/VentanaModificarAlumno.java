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

public class VentanaModificarAlumno {

	private JFrame frmModificacinDatosDe;
	private JTextField textFieldCedulaAlumno;
	private JTextField textFieldDireccionAlumno;
	private JTextField textFieldTelefonoAlumno;
	private JTextField textFieldEmailAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarAlumno window = new VentanaModificarAlumno();
					window.frmModificacinDatosDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaModificarAlumno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificacinDatosDe = new JFrame();
		frmModificacinDatosDe.setTitle("Modificaci\u00F3n de datos de un alumno");
		frmModificacinDatosDe.setBounds(100, 100, 575, 397);
		frmModificacinDatosDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificacinDatosDe.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("200dlu"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCedulaDelAlumno = new JLabel("Cedula del alumno");
		frmModificacinDatosDe.getContentPane().add(lblCedulaDelAlumno, "8, 4");
		
		textFieldCedulaAlumno = new JTextField();
		frmModificacinDatosDe.getContentPane().add(textFieldCedulaAlumno, "12, 4, fill, default");
		textFieldCedulaAlumno.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		frmModificacinDatosDe.getContentPane().add(lblDireccin, "8, 8");
		
		textFieldDireccionAlumno = new JTextField();
		frmModificacinDatosDe.getContentPane().add(textFieldDireccionAlumno, "12, 8, fill, default");
		textFieldDireccionAlumno.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		frmModificacinDatosDe.getContentPane().add(lblTelfono, "8, 12");
		
		textFieldTelefonoAlumno = new JTextField();
		frmModificacinDatosDe.getContentPane().add(textFieldTelefonoAlumno, "12, 12, fill, default");
		textFieldTelefonoAlumno.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		frmModificacinDatosDe.getContentPane().add(lblCorreoElectrnico, "8, 16");
		
		textFieldEmailAlumno = new JTextField();
		frmModificacinDatosDe.getContentPane().add(textFieldEmailAlumno, "12, 16, fill, default");
		textFieldEmailAlumno.setColumns(10);
		
		JButton btnModificarDatos = new JButton("Modificar datos");
		frmModificacinDatosDe.getContentPane().add(btnModificarDatos, "12, 20");
		
		JButton btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		frmModificacinDatosDe.getContentPane().add(btnCancelarYVolver, "12, 24");
	}

}
