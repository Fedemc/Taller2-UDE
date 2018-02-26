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
		frmConsultaDeEscolaridad.setBounds(100, 100, 910, 543);
		frmConsultaDeEscolaridad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaDeEscolaridad.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("default:grow"),}));
		
		JLabel lblIngreseCedula = new JLabel("Ingrese cedula");
		frmConsultaDeEscolaridad.getContentPane().add(lblIngreseCedula, "4, 4");
		
		textField = new JTextField();
		frmConsultaDeEscolaridad.getContentPane().add(textField, "8, 4, fill, default");
		textField.setColumns(10);
		
		JRadioButton rdbtnListadoParcial = new JRadioButton("Listado en modo parcial");
		frmConsultaDeEscolaridad.getContentPane().add(rdbtnListadoParcial, "4, 6");
		
		JRadioButton rdbtnListadoCompleto = new JRadioButton("Listado en modo completo");
		frmConsultaDeEscolaridad.getContentPane().add(rdbtnListadoCompleto, "4, 8");
		
		ButtonGroup btnGrupoModoListado = new ButtonGroup();
		btnGrupoModoListado.add(rdbtnListadoParcial);
		btnGrupoModoListado.add(rdbtnListadoCompleto);
		
		table = new JTable();
		frmConsultaDeEscolaridad.getContentPane().add(table, "4, 10, 9, 1, fill, fill");
		ButtonModel model = rdbtnListadoParcial.getModel();
		btnGrupoModoListado.setSelected(model, true);
	}

}
