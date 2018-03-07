package sistema.grafica.ventanas;

import sistema.grafica.controladores.ContVentanaModificarAlumno;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaModificarAlumno {

	private JFrame frmModificacinDatosDe;
	private JTextField textFieldCedulaAlumno;
	private JTextField textFieldDireccionAlumno;
	private JTextField textFieldTelefonoAlumno;
	private JTextField textFieldEmailAlumno;
	private ContVentanaModificarAlumno contVentModAlu;

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
		frmModificacinDatosDe.setBounds(100, 100, 521, 297);
		frmModificacinDatosDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contVentModAlu = new ContVentanaModificarAlumno(this);
		frmModificacinDatosDe.getContentPane().setLayout(null);
		
		JLabel lblCedulaDelAlumno = new JLabel("Cedula");
		lblCedulaDelAlumno.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCedulaDelAlumno.setBounds(49, 102, 66, 14);
		frmModificacinDatosDe.getContentPane().add(lblCedulaDelAlumno);
		
		textFieldCedulaAlumno = new JTextField();
		textFieldCedulaAlumno.setBounds(137, 99, 88, 20);
		frmModificacinDatosDe.getContentPane().add(textFieldCedulaAlumno);
		textFieldCedulaAlumno.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDireccin.setBounds(49, 138, 78, 14);
		frmModificacinDatosDe.getContentPane().add(lblDireccin);
		
		textFieldDireccionAlumno = new JTextField();
		textFieldDireccionAlumno.setBounds(137, 135, 294, 20);
		frmModificacinDatosDe.getContentPane().add(textFieldDireccionAlumno);
		textFieldDireccionAlumno.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTelfono.setBounds(261, 102, 72, 14);
		frmModificacinDatosDe.getContentPane().add(lblTelfono);
		
		textFieldTelefonoAlumno = new JTextField();
		textFieldTelefonoAlumno.setBounds(343, 99, 88, 20);
		frmModificacinDatosDe.getContentPane().add(textFieldTelefonoAlumno);
		textFieldTelefonoAlumno.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Email");
		lblCorreoElectrnico.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCorreoElectrnico.setBounds(49, 169, 66, 14);
		frmModificacinDatosDe.getContentPane().add(lblCorreoElectrnico);
		
		textFieldEmailAlumno = new JTextField();
		textFieldEmailAlumno.setBounds(137, 166, 294, 20);
		frmModificacinDatosDe.getContentPane().add(textFieldEmailAlumno);
		textFieldEmailAlumno.setColumns(10);
		
		JButton btnModificarDatos = new JButton("Modificar datos");
		btnModificarDatos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnModificarDatos.setBounds(137, 208, 142, 23);
		frmModificacinDatosDe.getContentPane().add(btnModificarDatos);
		
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String cedula = textFieldCedulaAlumno.getText();
				String domicilio = textFieldDireccionAlumno.getText();
				String telefono = textFieldTelefonoAlumno.getText();
				String email = textFieldEmailAlumno.getText();
				
				if ((!(cedula.isEmpty())) && (!(telefono.isEmpty())) && (!(domicilio.isEmpty())) && (!(email.isEmpty()))) {
					long ced = longAString(cedula);
					int tel = intAString(telefono);
					contVentModAlu.modificarDatosAlumno(ced, domicilio, tel, email);
				}
				else {
					mostrarError("No se pueden dejar campos vacíos");
				}
			}
		});
		
		JButton btnCancelarYVolver = new JButton("Volver");
		btnCancelarYVolver.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelarYVolver.setBounds(289, 208, 142, 23);
		frmModificacinDatosDe.getContentPane().add(btnCancelarYVolver);
		
		JLabel lblNewLabel = new JLabel("Modificaci\u00F3n de Datos del Alumno");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(116, 24, 294, 33);
		frmModificacinDatosDe.getContentPane().add(lblNewLabel);
		
		btnCancelarYVolver.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				frmModificacinDatosDe.dispose();
			}
		});
		
		frmModificacinDatosDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setVisible(boolean valor)
	{
		frmModificacinDatosDe.setVisible(valor);
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frmModificacinDatosDe, res, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public long longAString(String s) {
		long cedula = 0;
		try {
			Long.parseLong(s);
			cedula = Long.parseLong(s);
		}
		catch (NumberFormatException e) {
		     JOptionPane.showMessageDialog(frmModificacinDatosDe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return cedula;
	}
	
	public int intAString(String s) {
		int entero = 0;
		try {
			Integer.parseInt(s);
		    entero = Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
		     JOptionPane.showMessageDialog(frmModificacinDatosDe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return entero;
	}
	
	public void mostrarResultado(String res)
	{
		JOptionPane.showMessageDialog(frmModificacinDatosDe, res, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void limpiarCampos() {
		textFieldCedulaAlumno.setText("");
		textFieldDireccionAlumno.setText("");
		textFieldTelefonoAlumno.setText("");
		textFieldEmailAlumno.setText("");
	}
}
