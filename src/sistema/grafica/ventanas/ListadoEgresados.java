package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListadoEgresados {

	private JFrame frmListadoDeEgresados;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoEgresados window = new ListadoEgresados();
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
	public ListadoEgresados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDeEgresados = new JFrame();
		frmListadoDeEgresados.setTitle("Listado de egresados");
		frmListadoDeEgresados.setBounds(100, 100, 815, 432);
		frmListadoDeEgresados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDeEgresados.getContentPane().setLayout(null);
		
		JLabel lblListadoDeEgresados = new JLabel("Listado de egresados");
		lblListadoDeEgresados.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblListadoDeEgresados.setBounds(31, 35, 155, 14);
		frmListadoDeEgresados.getContentPane().add(lblListadoDeEgresados);
		
		table = new JTable();
		table.setBounds(30, 104, 565, 278);
		frmListadoDeEgresados.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Listado PARCIAL");
		btnNewButton.setBounds(196, 31, 144, 23);
		frmListadoDeEgresados.getContentPane().add(btnNewButton);
		
		JButton btnListadoCompleto = new JButton("Listado COMPLETO");
		btnListadoCompleto.setBounds(196, 65, 144, 23);
		frmListadoDeEgresados.getContentPane().add(btnListadoCompleto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListadoDeEgresados.dispose();
			}
		});
		btnSalir.setBounds(605, 359, 144, 23);
		frmListadoDeEgresados.getContentPane().add(btnSalir);
	}
	public void setVisible(boolean valor)
	{
		frmListadoDeEgresados.setVisible(valor);
	}

}
