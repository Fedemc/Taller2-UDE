package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;

import sistema.excepciones.AlumnoException;
import sistema.grafica.controladores.ControladorVentAlumnoDet;
import sistema.grafica.ventanas.*;
import sistema.logica.valueObjects.VOAlumnoDetallado;

public class ListadoAlumnoDetallado {

	private JFrame frame;
	private JTextField ci;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoAlumnoDetallado window = new ListadoAlumnoDetallado();
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
	public ListadoAlumnoDetallado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 760, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese Cedula");
		lblNewLabel.setBounds(22, 59, 112, 14);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel);
		
		ci = new JTextField();
		ci.setBounds(144, 56, 112, 20);

		frame.getContentPane().add(ci);
		ci.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Listado detallado del Alumno");
		lblNewLabel_1.setBounds(202, 11, 293, 20);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Mostrar Datos");
		btnNewButton.setBounds(280, 55, 157, 23);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long  ced = Integer.parseInt(ci.getText());
				ControladorVentAlumnoDet miCont = new ControladorVentAlumnoDet(null);
				
				
				JTable table = new JTable();
				JScrollPane jsp = new JScrollPane(table);
				frame.getContentPane().add(jsp, "4, 4, fill, fill");
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Cedula");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("Domiclio");
				modelo.addColumn("Telefono");
				modelo.addColumn("Email");
				modelo.addColumn("Cuota Mensual");
				modelo.addColumn("Tipo Alumno");
				Object fila [] =new Object[8];
				
				try {
					VOAlumnoDetallado alu=miCont.datosAlumno(ced);
					
					fila[0]=alu.getCedula();
			        fila[1]=alu.getNombre();
			        fila[2]=alu.getApellido();
			        fila[3]=alu.getDomicilio();
			        fila[4]=alu.getTelefono();
			        fila[5]=alu.getDirCorreo();
			        fila[6]=alu.getCuotaMensual();
			        fila[7]="Comun";

			        modelo.addRow(fila);
			        table.setModel(modelo);
			        
				} catch (RemoteException | AlumnoException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(454, 55, 157, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
	}
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
}
