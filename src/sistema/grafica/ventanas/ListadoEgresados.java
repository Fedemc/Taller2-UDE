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
		frmListadoDeEgresados.setBounds(100, 100, 949, 556);
		frmListadoDeEgresados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDeEgresados.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblListadoDeEgresados = new JLabel("Listado de egresados");
		frmListadoDeEgresados.getContentPane().add(lblListadoDeEgresados, "4, 4, left, default");
		
		JButton btnListarEgresados = new JButton("Listar egresados");
		frmListadoDeEgresados.getContentPane().add(btnListarEgresados, "6, 4");
		
		JRadioButton rdbtnModoParcial = new JRadioButton("Modo parcial");
		frmListadoDeEgresados.getContentPane().add(rdbtnModoParcial, "4, 6");
		
		JRadioButton rdbtnModoCompleto = new JRadioButton("Modo completo");
		frmListadoDeEgresados.getContentPane().add(rdbtnModoCompleto, "4, 7");
		
		ButtonGroup btnGroupModoListado = new ButtonGroup();
		btnGroupModoListado.add(rdbtnModoCompleto);
		btnGroupModoListado.add(rdbtnModoParcial);
		ButtonModel model = rdbtnModoCompleto.getModel();
		btnGroupModoListado.setSelected(model, true);
		
		table = new JTable();
		frmListadoDeEgresados.getContentPane().add(table, "4, 9, 6, 6, fill, fill");
		
		JButton btnNewButton = new JButton("Cancelar y volver a la ventana principal");
		frmListadoDeEgresados.getContentPane().add(btnNewButton, "6, 17, default, top");
	}

}
