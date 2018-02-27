package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
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
import sistema.grafica.ventanas.*;
import sistema.logica.valueObjects.VOAlumnoDetallado;
public class ListadoAlumnoDetallado {

	private JFrame frame;
	private JTextField ci;
	private JTable tabla;

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
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 59, 112, 14);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel);
		
		ci = new JTextField();
		ci.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
			
		});
		ci.setBounds(144, 56, 112, 20);
		frame.getContentPane().add(ci);
		ci.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Listado detallado del Alumno");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(202, 11, 293, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Mostrar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long  ced = Integer.parseInt(ci.getText());
				ControladorVentAlumnoDet miCont = new ControladorVentAlumnoDet(null);
				VOAlumnoDetallado alu;
				try {
					alu = miCont.datosAlumno(ced);
					DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

					Object [] fila=new Object[tabla.getColumnCount()];
					fila[0]=alu.getCedula();
			        fila[1]=alu.getNombre();
			        fila[2]=alu.getApellido();
			        fila[3]=alu.getDomicilio();
			        fila[4]=alu.getTelefono();
			        fila[5]=alu.getDirCorreo();
			        fila[6]=alu.getCuotaMensual();
			        fila[7]="Comun";

			        modelo.addRow(fila);
			        tabla.setModel(modelo);
			        
				} catch (RemoteException | AlumnoException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(280, 55, 157, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		btnNewButton_1.setBounds(454, 55, 157, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Cedula", "Nombre", "Apellido", "Domicilio", "Telefono", "Email", "Monto Cuota", "Tipo", "Descuento", "Descripcion"
			}
		));
		tabla.setBackground(new Color(0, 153, 204));
		tabla.setToolTipText("");
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setForeground(SystemColor.inactiveCaption);
		tabla.setColumnSelectionAllowed(true);
		tabla.setCellSelectionEnabled(true);
		tabla.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), null, null, null));
		
		tabla.setBounds(22, 301, 683, -200);
		frame.getContentPane().add(tabla);
		
	}
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
}
