package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import sistema.grafica.controladores.ContVentanaRegistroAlumno;

public class VentanaRegistroAlumno {

	private JFrame frame;
	private JTextField txtCI;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtDom;
	private JTextField txtTel;
	private JTextField txtMail;
	private JTextField txtDescuento;
	private JTextField txtDescripcion;
	private JRadioButton rdbtnNoBecado;
	private JRadioButton rdbtnBecado;
	
	private ContVentanaRegistroAlumno contVent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroAlumno window = new VentanaRegistroAlumno();
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
	public VentanaRegistroAlumno() {
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
		
		txtCI = new JTextField();
		frame.getContentPane().add(txtCI, "10, 6, fill, center");
		txtCI.setColumns(10);
		
		JLabel lblNom = new JLabel("Nombre");
		frame.getContentPane().add(lblNom, "6, 8");
		
		txtNom = new JTextField();
		frame.getContentPane().add(txtNom, "10, 8, fill, default");
		txtNom.setColumns(10);
		
		JLabel lblApe = new JLabel("Apellido");
		frame.getContentPane().add(lblApe, "6, 10");
		
		txtApe = new JTextField();
		frame.getContentPane().add(txtApe, "10, 10, fill, default");
		txtApe.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		frame.getContentPane().add(lblDomicilio, "6, 12");
		
		txtDom = new JTextField();
		frame.getContentPane().add(txtDom, "10, 12, fill, default");
		txtDom.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		frame.getContentPane().add(lblTelefono, "6, 14");
		
		txtTel = new JTextField();
		frame.getContentPane().add(txtTel, "10, 14, fill, default");
		txtTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail, "6, 16");
		
		txtMail = new JTextField();
		frame.getContentPane().add(txtMail, "10, 16, fill, default");
		txtMail.setColumns(10);
		
		JLabel lblSiEsBecado = new JLabel("Si es becado, indiquelo debajo");
		frame.getContentPane().add(lblSiEsBecado, "10, 20");
		
		JLabel lblPorcentajeDeDescuento = new JLabel("Descuento");
		frame.getContentPane().add(lblPorcentajeDeDescuento, "6, 28");
		
		txtDescuento = new JTextField();
		frame.getContentPane().add(txtDescuento, "10, 28, fill, default");
		txtDescuento.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		frame.getContentPane().add(lblDescripcin, "6, 30");
		
		txtDescripcion = new JTextField();
		frame.getContentPane().add(txtDescripcion, "10, 30, fill, default");
		txtDescripcion.setColumns(10);
		
		rdbtnNoBecado = new JRadioButton("No becado");
		frame.getContentPane().add(rdbtnNoBecado, "6, 24");
		
		rdbtnBecado = new JRadioButton("Becado");
		frame.getContentPane().add(rdbtnBecado, "10, 24");
		
		ButtonGroup btnGrupoBecado = new ButtonGroup();
		btnGrupoBecado.add(rdbtnBecado);
		btnGrupoBecado.add(rdbtnNoBecado);
		ButtonModel model = rdbtnNoBecado.getModel();
		btnGrupoBecado.setSelected(model, true);
		
		JButton btnRegistrarAlumno = new JButton("Registrar Alumno");
		btnRegistrarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamar al validar y registrar
				validarDatosYRegistrarAlumno(rdbtnBecado.isSelected());
			}
		});
		frame.getContentPane().add(btnRegistrarAlumno, "10, 34");
		
		JButton btnVolverALa = new JButton("Cancelar y volver a la ventana principal");
		btnVolverALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnVolverALa, "10, 38");
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contVent=new ContVentanaRegistroAlumno(this);
		
		
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
	
	private void validarDatosYRegistrarAlumno(boolean esBecado)
	{
		//Verificar campos vacios, si todo OK llamar al ContVent.regAlu();, ver si es becado!
		//Verificar el valor del rdbtn
		boolean validaciones=!txtCI.getText().isEmpty() && !txtNom.getText().isEmpty() && !txtApe.getText().isEmpty() && !txtDom.getText().isEmpty() && !txtTel.getText().isEmpty() && !txtMail.getText().isEmpty();
		
		//Validaciones para becado, agrego al chequeo
		if(esBecado)
		{
			validaciones= validaciones && !txtDescuento.getText().isEmpty() && !txtDescripcion.getText().isEmpty();
		}
		
		
		if(validaciones)
		{
			//llamo al metodo del controlador pasandole los datos
			//Dos metodos, depende si es becado o no
			if(esBecado)
			{
				//cont crear becado
				contVent.crearBecado(Long.parseLong(txtCI.getText()), txtNom.getText(), txtApe.getText(), txtDom.getText(), Integer.parseInt(txtTel.getText()), txtMail.getText(), Integer.parseInt(txtDescuento.getText()), txtDescripcion.getText());
			}
			else
			{
				//cont crear alumno
				contVent.crearAlumno(Long.parseLong(txtCI.getText()), txtNom.getText(), txtApe.getText(), txtDom.getText(), Integer.parseInt(txtTel.getText()), txtMail.getText());
			}
		}
		else
		{
			mostrarError("Debe completar todos los campos.");
		}
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frame, res, "Resultado", JOptionPane.ERROR_MESSAGE);
	}

}
