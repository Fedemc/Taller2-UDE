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

public class RegistroAsignatura {

	private JFrame frmRegistroDeAsignatura;
	private JTextField textFieldCodigoAsig;
	private JTextField textFieldNombreAsig;
	private JTextField textFieldDescripcionAsig;
	private JButton btnRegistrarAsignatura;
	private JButton btnCancelarYVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAsignatura window = new RegistroAsignatura();
					window.frmRegistroDeAsignatura.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroAsignatura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeAsignatura = new JFrame();
		frmRegistroDeAsignatura.setTitle("Registro de Asignatura");
		frmRegistroDeAsignatura.setBounds(100, 100, 610, 337);
		frmRegistroDeAsignatura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeAsignatura.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
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
		
		JLabel lblCodigo = new JLabel("Codigo");
		frmRegistroDeAsignatura.getContentPane().add(lblCodigo, "8, 4");
		
		textFieldCodigoAsig = new JTextField();
		frmRegistroDeAsignatura.getContentPane().add(textFieldCodigoAsig, "12, 4, fill, default");
		textFieldCodigoAsig.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		frmRegistroDeAsignatura.getContentPane().add(lblNombre, "8, 8");
		
		textFieldNombreAsig = new JTextField();
		frmRegistroDeAsignatura.getContentPane().add(textFieldNombreAsig, "12, 8, fill, center");
		textFieldNombreAsig.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		frmRegistroDeAsignatura.getContentPane().add(lblDescripcin, "8, 12");
		
		textFieldDescripcionAsig = new JTextField();
		frmRegistroDeAsignatura.getContentPane().add(textFieldDescripcionAsig, "12, 12, fill, default");
		textFieldDescripcionAsig.setColumns(10);
		
		btnRegistrarAsignatura = new JButton("Registrar asignatura");
		frmRegistroDeAsignatura.getContentPane().add(btnRegistrarAsignatura, "12, 16");
		
		btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		frmRegistroDeAsignatura.getContentPane().add(btnCancelarYVolver, "12, 20");
	}

}
