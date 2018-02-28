package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import sistema.grafica.controladores.ContVentAlumnoDet;
import sistema.grafica.ventanas.*;
import sistema.logica.valueObjects.VOAlumnoDetallado;

public class VentanaListadoAlumnoDetallado {

	private JFrame frame;
	private JTextField txtCI;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoAlumnoDetallado window = new VentanaListadoAlumnoDetallado();
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
	public VentanaListadoAlumnoDetallado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ContVentAlumnoDet miCont = new ContVentAlumnoDet(this);
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
		
		txtCI = new JTextField();
		txtCI.setBounds(144, 56, 112, 20);

		frame.getContentPane().add(txtCI);
		txtCI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Listado detallado del Alumno");
		lblNewLabel_1.setBounds(202, 11, 293, 20);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JButton btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.setBounds(280, 55, 157, 23);
		
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aca llamo al metodo q valida el campo
				validarCamposYGenerarListado();
			}
		});
		frame.getContentPane().add(btnMostrarDatos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(454, 55, 157, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);		
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
	
	private void validarCamposYGenerarListado()
	{
		if(!txtCI.getText().isEmpty())
		{
			listar();
			
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Ingrese una cedula de alumno", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void listar()
	{
		
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frame, res, "Resultado", JOptionPane.ERROR_MESSAGE);
	}
	
}
