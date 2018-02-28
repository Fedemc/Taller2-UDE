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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaEscolaridad {

	private JFrame frmConsultaDeEscolaridad;
	private JTextField textField;
	private JTable table;

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
		lblIngreseCedula.setBounds(31, 56, 132, 14);
		frmConsultaDeEscolaridad.getContentPane().add(lblIngreseCedula);
		
		textField = new JTextField();
		textField.setBounds(144, 53, 97, 20);
		frmConsultaDeEscolaridad.getContentPane().add(textField);
		textField.setColumns(10);
		
		ButtonGroup btnGrupoModoListado = new ButtonGroup();
		
		table = new JTable();
		table.setBounds(31, 121, 387, 324);
		frmConsultaDeEscolaridad.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Listado PARCIAL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(251, 52, 167, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnNewButton);
		
		JButton btnListadoCompleto = new JButton("Listado COMPLETO");
		btnListadoCompleto.setBounds(251, 87, 167, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnListadoCompleto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaDeEscolaridad.dispose();
			}
		});
		btnCancelar.setBounds(466, 422, 132, 23);
		frmConsultaDeEscolaridad.getContentPane().add(btnCancelar);
		
	}

	public void setVisible(boolean valor)
	{
		frmConsultaDeEscolaridad.setVisible(valor);
	}
}
