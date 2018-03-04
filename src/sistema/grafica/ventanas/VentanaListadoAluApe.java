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
		frame.setBounds(100, 100, 680, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("200dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("max(168dlu;default):grow"),
				RowSpec.decode("max(31dlu;default)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		contVentListAluApe=new ContVentanaListadoAluApe(this);
		
		lblIngreseApellido = new JLabel("Ingrese apellido");
		frame.getContentPane().add(lblIngreseApellido, "4, 4, center, default");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "4, 6, fill, top");
		textField.setColumns(10);
		
		btnListarAlumnosCon = new JButton("Listar alumnos con el apellido ingresado");
		frame.getContentPane().add(btnListarAlumnosCon, "4, 8");
		
		JTable table = new JTable();
		JScrollPane jsp = new JScrollPane(table);
		frame.getContentPane().add(jsp, "8, 10, fill, fill");
		
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
		
		btnCancelarYVolver = new JButton("Cancelar y volver a la ventana principal");
		btnCancelarYVolver.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(btnCancelarYVolver, "4, 10, default, bottom");
		
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
