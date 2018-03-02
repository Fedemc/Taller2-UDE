package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sistema.excepciones.AsignaturaException;
import sistema.grafica.controladores.ContVentanaRegistroAsignatura;

import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaRegistroAsignatura {

	private JFrame frmRegistroDeAsignatura;
	private JTextField textFieldCodigoAsig;
	private JTextField textFieldNombreAsig;
	private JTextField textFieldDescripcionAsig;
	private JButton btnRegistrarAsignatura;
	private JButton btnCancelarYVolver;
	
	private ContVentanaRegistroAsignatura contVent;

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
		lblCodigo.setBounds(81, 71, 54, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblCodigo);
		
		textFieldCodigoAsig = new JTextField();
		textFieldCodigoAsig.setBounds(166, 68, 272, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldCodigoAsig);
		textFieldCodigoAsig.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 113, 54, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblNombre);
		
		textFieldNombreAsig = new JTextField();
		textFieldNombreAsig.setBounds(166, 110, 272, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldNombreAsig);
		textFieldNombreAsig.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(81, 156, 102, 14);
		frmRegistroDeAsignatura.getContentPane().add(lblDescripcin);
		
		textFieldDescripcionAsig = new JTextField();
		textFieldDescripcionAsig.setBounds(166, 153, 272, 20);
		frmRegistroDeAsignatura.getContentPane().add(textFieldDescripcionAsig);
		textFieldDescripcionAsig.setColumns(10);
		
		btnRegistrarAsignatura = new JButton("Registrar");
		btnRegistrarAsignatura.setBounds(166, 206, 131, 23);
		btnRegistrarAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validarDatos()) {
					contVent.registrarAsignatura(textFieldCodigoAsig.getText(), textFieldNombreAsig.getText(), textFieldDescripcionAsig.getText());
					frmRegistroDeAsignatura.dispose();
				}else
					mostrarError("Debe completar todos los campos.");
			}
		});
		frmRegistroDeAsignatura.getContentPane().add(btnRegistrarAsignatura);
		
		btnCancelarYVolver = new JButton("Cancelar");
		btnCancelarYVolver.setBounds(307, 206, 131, 23);
		btnCancelarYVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRegistroDeAsignatura.dispose();
			}
		});
		frmRegistroDeAsignatura.getContentPane().add(btnCancelarYVolver);
		
		JLabel lblNewLabel = new JLabel("Registro de una nueva Asignatura");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(155, 11, 305, 20);
		frmRegistroDeAsignatura.getContentPane().add(lblNewLabel);
		
		frmRegistroDeAsignatura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contVent = new ContVentanaRegistroAsignatura(this);
	}
	
	public void setVisible(boolean valor)
	{
		frmRegistroDeAsignatura.setVisible(valor);
	}
	
	public boolean validarDatos () {
		boolean ok = false;
		
		if(textFieldCodigoAsig.getText().isEmpty()||textFieldNombreAsig.getText().isEmpty()||textFieldDescripcionAsig.getText().isEmpty()) {
			ok=false;
		}else
			ok=true;
		return ok;
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frmRegistroDeAsignatura, res, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
}
