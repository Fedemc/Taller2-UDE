package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sistema.grafica.controladores.ContVentanaListadoEgresado;
import sistema.logica.valueObjects.VOAlumno;
import sistema.logica.valueObjects.VOAlumnoDetallado;
import sistema.logica.valueObjects.VOEgresados;
import sistema.logica.valueObjects.VOInscripcion;
import sistema.logica.valueObjects.VOInscripcionDetallada;
import sistema.logica.valueObjects.VOInscripciones;

import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaListadoEgresados {

	private JFrame frmListadoDeEgresados;
	private JTable table;
	
	ContVentanaListadoEgresado contVentEgre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoEgresados window = new VentanaListadoEgresados();
					window.frmListadoDeEgresados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaListadoEgresados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDeEgresados = new JFrame();
		frmListadoDeEgresados.setTitle("Listado de egresados");
		frmListadoDeEgresados.setBounds(100, 100, 815, 488);
		frmListadoDeEgresados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDeEgresados.getContentPane().setLayout(null);
		
		JLabel lblListadoDeEgresados = new JLabel("Listado de egresados");
		lblListadoDeEgresados.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblListadoDeEgresados.setBounds(31, 74, 155, 14);
		frmListadoDeEgresados.getContentPane().add(lblListadoDeEgresados);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(30, 104, 734, 278);
		frmListadoDeEgresados.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Listado PARCIAL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listadoParcial();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.setBounds(196, 70, 164, 23);
		frmListadoDeEgresados.getContentPane().add(btnNewButton);
		
		JButton btnListadoCompleto = new JButton("Listado COMPLETO");
		btnListadoCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listadoCompleto();
			}
		});
		btnListadoCompleto.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnListadoCompleto.setBounds(370, 70, 164, 23);
		frmListadoDeEgresados.getContentPane().add(btnListadoCompleto);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListadoDeEgresados.dispose();
			}
		});
		btnSalir.setBounds(620, 415, 144, 23);
		frmListadoDeEgresados.getContentPane().add(btnSalir);
	}
	public void setVisible(boolean valor)
	{
		frmListadoDeEgresados.setVisible(valor);
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frmListadoDeEgresados, res, "Resultado", JOptionPane.ERROR_MESSAGE);
	}
	
	public void listadoParcial()
	{
		
		VOEgresados listadoAlu = contVentEgre.crearListadoEgresados(false);
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Cedula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		Object rowData[]= new Object[3];
		
		for(int i=0; i<listadoAlu.getVOEgresadosArray().size();i++)
		{
			rowData[0] = listadoAlu.getVOEgresadosArray().get(i).getCedula();
			rowData[1] = listadoAlu.getVOEgresadosArray().get(i).getNombre();
			rowData[2] = listadoAlu.getVOEgresadosArray().get(i).getApellido();
			modelo.addRow(rowData);
		}
		
		table.setModel(modelo);
	}
	
	public void listadoCompleto()
	{

	
		VOEgresados listadoAlu = contVentEgre.crearListadoEgresados(false);
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Cedula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Promedio Total");	
		modelo.addColumn("Promedio Aprobaciones");
		Object rowData[]= new Object[5];
		
		for(int i=0; i<listadoAlu.getVOEgresadosArray().size();i++)
		{
			rowData[0] = listadoAlu.getVOEgresadosArray().get(i).getCedula();
			rowData[1] = listadoAlu.getVOEgresadosArray().get(i).getNombre();
			rowData[2] = listadoAlu.getVOEgresadosArray().get(i).getApellido();
			rowData[1] = listadoAlu.getVOEgresadosArray().get(i).getPromedioTotal();
			rowData[2] = listadoAlu.getVOEgresadosArray().get(i).getPromedioAprob();
			modelo.addRow(rowData);
		}
		
		table.setModel(modelo);
	}

}
