package Registro;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
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
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Registro de alumno");
		frame.setBounds(100, 100, 677, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del alumno en los campos");
		frame.getContentPane().add(lblIngreseLosDatos, "10, 2");
		
		JLabel lblCedula = new JLabel("Cedula");
		frame.getContentPane().add(lblCedula, "6, 6");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "10, 6, fill, center");
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		frame.getContentPane().add(lblNombre, "6, 8");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "10, 8, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		frame.getContentPane().add(lblApellido, "6, 10");
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3, "10, 10, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		frame.getContentPane().add(lblDomicilio, "6, 12");
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4, "10, 12, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		frame.getContentPane().add(lblTelefono, "6, 14");
		
		textField_5 = new JTextField();
		frame.getContentPane().add(textField_5, "10, 14, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail, "6, 16");
		
		textField_6 = new JTextField();
		frame.getContentPane().add(textField_6, "10, 16, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblSiEsBecado = new JLabel("Si es becado, indiquelo debajo");
		frame.getContentPane().add(lblSiEsBecado, "10, 20");
		
		JLabel lblPorcentajeDeDescuento = new JLabel("Descuento");
		frame.getContentPane().add(lblPorcentajeDeDescuento, "6, 28");
		
		textField_7 = new JTextField();
		frame.getContentPane().add(textField_7, "10, 28, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		frame.getContentPane().add(lblDescripcin, "6, 30");
		
		textField_8 = new JTextField();
		frame.getContentPane().add(textField_8, "10, 30, fill, default");
		textField_8.setColumns(10);
		
		JRadioButton rdbtnNoBecado = new JRadioButton("No becado");
		frame.getContentPane().add(rdbtnNoBecado, "6, 24");
		
		JRadioButton rdbtnBecado = new JRadioButton("Becado");
		frame.getContentPane().add(rdbtnBecado, "10, 24");
		
		ButtonGroup btnGrupoBecado = new ButtonGroup();
		btnGrupoBecado.add(rdbtnBecado);
		btnGrupoBecado.add(rdbtnNoBecado);
		ButtonModel model = rdbtnNoBecado.getModel();
		btnGrupoBecado.setSelected(model, true);
		
		JButton btnRegistrarAlumno = new JButton("Registrar Alumno");
		frame.getContentPane().add(btnRegistrarAlumno, "10, 34");
		
		
		
		JButton btnVolverALa = new JButton("Cancelar y volver a la ventana principal");
		frame.getContentPane().add(btnVolverALa, "10, 38");
	}

}
