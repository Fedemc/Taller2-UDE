package sistema.grafica.ventanas;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import sistema.grafica.controladores.ContVentanaEscolaridad;
import sistema.logica.valueObjects.VOInscripcion;
import sistema.logica.valueObjects.VOInscripcionDetallada;
import sistema.logica.valueObjects.VOInscripciones;
import java.util.ArrayList;


public class VentanaEscolaridad {

	private JFrame frmConsultaDeEscolaridad;
	private JTextField txtCI;
	private JTable tblDatos;
	
	ContVentanaEscolaridad contVentanaEsc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEscolaridad window = new VentanaEscolaridad();
					window.frmConsultaDeEscolaridad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEscolaridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeEscolaridad = new JFrame();
		frmConsultaDeEscolaridad.setTitle("Consulta de escolaridad");
		frmConsultaDeEscolaridad.setBounds(100, 100, 678, 511);
		frmConsultaDeEscolaridad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaDeEscolaridad.getContentPane().setLayout(null);
		
		JLabel lblIngreseCedula = new JLabel("Ingrese cedula");
		lblIngreseCedula.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblIngreseCedula.setBounds(31, 56, 103, 14);
		frmConsultaDeEscolaridad.getContentPane().add(lblIngreseCedula);
		
		txtCI = new JTextField();
		txtCI.setBounds(144, 53, 97, 20);
		frmConsultaDeEscolaridad.getContentPane().add(txtCI);
		txtCI.setColumns(10);
		
		ButtonGroup btnGrupoModoListado = new ButtonGroup();
		
		tblDatos = new JTable();
		tblDatos.setBounds(31, 121, 387, 324);
		frmConsultaDeEscolaridad.getContentPane().add(tblDatos);
		
		JButton btnParcial = new JButton("Listado PARCIAL");
		btnParcial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//validarDatos
				if(validarDatos())
				{
					listadoParcial();
				}
				else
				{
					JOptionPane.showMessageDialog(frmConsultaDeEscolaridad, "Debe ingresar un dato en el campo de la cedula","Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnParcial.setBounds(251, 52, 167, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnParcial);
		
		JButton btnCompleto = new JButton("Listado COMPLETO");
		btnCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validarDatos
				if(validarDatos())
				{
					listadoCompleto();
				}
				else
				{
					JOptionPane.showMessageDialog(frmConsultaDeEscolaridad, "Debe ingresar un dato en el campo de la cedula","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCompleto.setBounds(251, 87, 167, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnCompleto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaDeEscolaridad.dispose();
			}
		});
		btnCancelar.setBounds(466, 422, 132, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnCancelar);
		
		
		contVentanaEsc=new ContVentanaEscolaridad(this);
	}

	public void setVisible(boolean valor)
	{
		frmConsultaDeEscolaridad.setVisible(valor);
	}
	
	public boolean validarDatos()
	{
		return (!txtCI.getText().isEmpty());
	}
	
	public void listadoCompleto()
	{
		VOInscripciones voIns=new VOInscripciones();
		//Paso 2do parametro en true porque indica que el listado es completo
		voIns=contVentanaEsc.crearListadoEscolaridad(Long.parseLong(txtCI.getText()), true);
		
		ArrayList<VOInscripcion> arrayInscripciones=voIns.getVOInscripcionesArray();
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("NroInscripcion");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Año lectivo");
		modelo.addColumn("Calificación");	
		modelo.addColumn("Monto base");
		Object rowData[]= new Object[5];
		
		for(VOInscripcion voInsDec: arrayInscripciones)
		{
			rowData[0] = voInsDec.getNumero();
			rowData[1] = voInsDec.getNombreAsignatura();
			rowData[2] = voInsDec.getAnioLectivo();
			rowData[3] = voInsDec.getCalificacion();
			rowData[4] = ((VOInscripcionDetallada)voInsDec).getMontoBase();
			modelo.addRow(rowData);
		}
		
		tblDatos.setModel(modelo);
	}
	
	public void listadoParcial()
	{
		VOInscripciones voIns=new VOInscripciones();
		//Paso 2do parametro en false porque indica que el listado es parcial
		voIns=contVentanaEsc.crearListadoEscolaridad(Long.parseLong(txtCI.getText()), false);
		
		ArrayList<VOInscripcion> arrayInscripciones=voIns.getVOInscripcionesArray();
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("NroInscripcion");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Año lectivo");
		modelo.addColumn("Calificación");
		Object rowData[]= new Object[4];
		
		for(VOInscripcion voInsDec: arrayInscripciones)
		{
			rowData[0] = voInsDec.getNumero();
			rowData[1] = voInsDec.getNombreAsignatura();
			rowData[2] = voInsDec.getAnioLectivo();
			rowData[3] = voInsDec.getCalificacion();
			modelo.addRow(rowData);
		}
		
		tblDatos.setModel(modelo);
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frmConsultaDeEscolaridad, res, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
