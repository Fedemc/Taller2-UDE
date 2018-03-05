package sistema.grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sistema.grafica.controladores.ContVentanaListadoAluApe;
import sistema.grafica.controladores.ContVentanaListadoAsig;
import sistema.logica.valueObjects.*;

import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class VentanaListadoAluApe {

	private JFrame frame;
	private JLabel lblIngreseApellido;
	private JTextField textField;
	private JButton btnListarAlumnosCon;
	private JButton btnCancelarYVolver;
	private ContVentanaListadoAluApe contVentListAluApe;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoAluApe window = new VentanaListadoAluApe();
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
	public VentanaListadoAluApe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contVentListAluApe=new ContVentanaListadoAluApe(this);
		frame.getContentPane().setLayout(null);
		
		lblIngreseApellido = new JLabel("Ingrese apellido");
		lblIngreseApellido.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblIngreseApellido.setBounds(30, 68, 109, 14);
		frame.getContentPane().add(lblIngreseApellido);
		
		textField = new JTextField();
		textField.setBounds(149, 65, 188, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnListarAlumnosCon = new JButton("Buscar");
		btnListarAlumnosCon.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnListarAlumnosCon.setBounds(347, 64, 113, 23);
		frame.getContentPane().add(btnListarAlumnosCon);
		
		JTable table = new JTable();
		JScrollPane jsp = new JScrollPane(table);
		jsp.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jsp.setBounds(30, 105, 429, 265);
		frame.getContentPane().add(jsp);
		
		btnListarAlumnosCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ape = textField.getText();
				if (!(ape.isEmpty())) {
					//Creo modelo de tabla y objeto 
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Cédula");
					model.addColumn("Nombre");
					model.addColumn("Apellido");
					model.addColumn("Tipo de Alumno");
					Object rowData[] = new Object[4];
					
					//Me traigo listado de asignaturas desde el controlador.
					ArrayList<VOAlumno> listadoAlu = contVentListAluApe.cargarDatos(ape);
					
					//Cargo los datos en la tabla.
					for(int i = 0; i < listadoAlu.size(); i++) {
						rowData[0] = listadoAlu.get(i).getCedula();
						rowData[1] = listadoAlu.get(i).getNombre();
						rowData[2] = listadoAlu.get(i).getApellido();
						rowData[3] = listadoAlu.get(i).getTipo();
						model.addRow(rowData);
					}
					table.setModel(model);
				}
				else
					JOptionPane.showMessageDialog(frame, "No se puede dejar el campo apellido vacío", "Campo vacío", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnCancelarYVolver = new JButton("Cancelar");
		btnCancelarYVolver.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelarYVolver.setBounds(347, 381, 113, 23);
		frame.getContentPane().add(btnCancelarYVolver);
		
		JLabel lblNewLabel = new JLabel("Listado de Alumnos por Apellido");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(116, 11, 290, 30);
		frame.getContentPane().add(lblNewLabel);
		
		btnCancelarYVolver.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				frame.dispose();
			}
		});
		
		
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frame, res, "Resultado", JOptionPane.ERROR_MESSAGE);
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
}
