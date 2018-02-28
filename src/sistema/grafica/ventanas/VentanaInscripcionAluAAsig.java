package sistema.grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sistema.grafica.controladores.ContVentanaListadoAluApe;

import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import sistema.grafica.controladores.ContVentanaInscripcionAluAAsig;

public class VentanaInscripcionAluAAsig {

	private JFrame frmInscripcinDeAlumno;
	private JTextField textFieldCedulaAlumno;
	private JTextField textFieldCodigoAsignatura;
	private JTextField textFieldMontoBase;
	private ContVentanaInscripcionAluAAsig contInscripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcionAluAAsig window = new VentanaInscripcionAluAAsig();
					window.frmInscripcinDeAlumno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInscripcionAluAAsig() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscripcinDeAlumno = new JFrame();
		frmInscripcinDeAlumno.setTitle("Inscripci\u00F3n de alumno a asignatura");
		frmInscripcinDeAlumno.setBounds(100, 100, 534, 334);
		frmInscripcinDeAlumno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscripcinDeAlumno.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
		
		contInscripcion=new ContVentanaInscripcionAluAAsig(this);
		
		JLabel lblCedulaDelAlumno = new JLabel("Cedula del alumno");
		frmInscripcinDeAlumno.getContentPane().add(lblCedulaDelAlumno, "8, 4");
		
		textFieldCedulaAlumno = new JTextField();
		frmInscripcinDeAlumno.getContentPane().add(textFieldCedulaAlumno, "12, 4, fill, default");
		textFieldCedulaAlumno.setColumns(10);
		
		JLabel lblCdigoDeAsignatura = new JLabel("C\u00F3digo de asignatura");
		frmInscripcinDeAlumno.getContentPane().add(lblCdigoDeAsignatura, "8, 8");
		
		textFieldCodigoAsignatura = new JTextField();
		frmInscripcinDeAlumno.getContentPane().add(textFieldCodigoAsignatura, "12, 8, fill, default");
		textFieldCodigoAsignatura.setColumns(10);
		
		JLabel lblMontoBaseDe = new JLabel("Monto base de inscripci\u00F3n");
		frmInscripcinDeAlumno.getContentPane().add(lblMontoBaseDe, "8, 12");
		
		textFieldMontoBase = new JTextField();
		frmInscripcinDeAlumno.getContentPane().add(textFieldMontoBase, "12, 12, fill, default");
		textFieldMontoBase.setColumns(10);
		
		JButton btnInscribirAlumno = new JButton("Inscribir alumno");
		frmInscripcinDeAlumno.getContentPane().add(btnInscribirAlumno, "12, 16");
		
		btnInscribirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String cedula = textFieldCedulaAlumno.getText();
				String codAsig = textFieldCodigoAsignatura.getText();
				String monto = textFieldMontoBase.getText();
				
				if ((cedula.isEmpty()) || (codAsig.isEmpty()) || (monto.isEmpty())) {
					JOptionPane.showMessageDialog(frmInscripcinDeAlumno, "No se pueden dejar campos vacíos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int montoBase = intAString(monto);
					long cedAlu = longAString(cedula);
					contInscripcion.inscribirAlumnoAsig(cedAlu, codAsig, montoBase);
				}
			}
		});
		
		JButton btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		frmInscripcinDeAlumno.getContentPane().add(btnCancelarYVolver, "12, 20");
		
		btnCancelarYVolver.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				frmInscripcinDeAlumno.dispose();
			}
		});
		
		frmInscripcinDeAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setVisible(boolean valor)
	{
		frmInscripcinDeAlumno.setVisible(valor);
	}
	
	public int intAString(String s) {
		int montoBase = 0;
		try {
			Integer.parseInt(s);
		    montoBase = Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
		     JOptionPane.showMessageDialog(frmInscripcinDeAlumno, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return montoBase;
	}
	
	public long longAString(String s) {
		long cedula = 0;
		try {
			Long.parseLong(s);
			cedula = Long.parseLong(s);
		}
		catch (NumberFormatException e) {
		     JOptionPane.showMessageDialog(frmInscripcinDeAlumno, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return cedula;
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frmInscripcinDeAlumno, res, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarResultado(String res)
	{
		JOptionPane.showMessageDialog(frmInscripcinDeAlumno, res, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
}
