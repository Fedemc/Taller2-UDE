package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRegistroAsignatura {

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
					VentanaRegistroAsignatura window = new VentanaRegistroAsignatura();
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
	public VentanaRegistroAsignatura() {
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
		frmRegistroDeAsignatura.getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(81, 34, 54, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblCodigo);
		
		textFieldCodigoAsig = new JTextField();
		textFieldCodigoAsig.setBounds(166, 31, 300, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldCodigoAsig);
		textFieldCodigoAsig.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 85, 54, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblNombre);
		
		textFieldNombreAsig = new JTextField();
		textFieldNombreAsig.setBounds(166, 82, 300, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldNombreAsig);
		textFieldNombreAsig.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(81, 136, 54, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblDescripcin);
		
		textFieldDescripcionAsig = new JTextField();
		textFieldDescripcionAsig.setBounds(166, 133, 300, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldDescripcionAsig);
		textFieldDescripcionAsig.setColumns(10);
		
		btnRegistrarAsignatura = new JButton("Registrar asignatura");
		btnRegistrarAsignatura.setBounds(166, 184, 300, 23);
		frmRegistroDeAsignatura.getContentPane().add(btnRegistrarAsignatura);
		
		btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		btnCancelarYVolver.setBounds(166, 238, 300, 23);
		frmRegistroDeAsignatura.getContentPane().add(btnCancelarYVolver);
		
		frmRegistroDeAsignatura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setVisible(boolean valor)
	{
		frmRegistroDeAsignatura.setVisible(valor);
	}

}
