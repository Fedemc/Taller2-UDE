package sistema.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import sistema.grafica.controladores.ContVentanaMontoRecaudado;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMontoRecaudado {

	private JFrame frame;
	
	private ContVentanaMontoRecaudado contVentMontoRec;
	private JTextField textCI;
	private JTextField textAnio;
	private JLabel lblCedulaDelAlumno;
	private JLabel lblAoLectivo;
	private JButton btnConsultarMonto;
	private JTextArea txtArea; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMontoRecaudado window = new VentanaMontoRecaudado();
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
	public VentanaMontoRecaudado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(131dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(0dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(6dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(27dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(77dlu;default):grow"),}));
		
		lblCedulaDelAlumno = new JLabel("Cedula del alumno:");
		frame.getContentPane().add(lblCedulaDelAlumno, "6, 4");
		
		textCI = new JTextField();
		frame.getContentPane().add(textCI, "6, 6, fill, default");
		textCI.setColumns(10);
		
		lblAoLectivo = new JLabel("A\u00F1o lectivo:");
		frame.getContentPane().add(lblAoLectivo, "6, 8");
		
		textAnio = new JTextField();
		frame.getContentPane().add(textAnio, "6, 10, fill, default");
		textAnio.setColumns(10);
		
		btnConsultarMonto = new JButton("Consultar monto");
		btnConsultarMonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarCampos();
			}
		});
		
		frame.getContentPane().add(btnConsultarMonto, "6, 12, center, fill");
		
		JLabel lblElMontoTotal = new JLabel("El monto total recaudado por concepto de inscripciones es: ");
		frame.getContentPane().add(lblElMontoTotal, "6, 14");
		
		contVentMontoRec=new ContVentanaMontoRecaudado(this);
		
		txtArea = new JTextArea();
		frame.getContentPane().add(txtArea, "6, 16, fill, fill");
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
	
	public void buscarTextoMontoRecaudado(long ci, int anio)
	{
		float res=contVentMontoRec.ObtenerMontoRecaudado(ci, anio);
		
		if(res!=0)
		{
			txtArea.setText(String.valueOf(res));
		}
		else
		{
			txtArea.setText("");
		}
	}
	
	public void mostrarError(String res)
	{
		JOptionPane.showMessageDialog(frame, res, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
	
	private void validarCampos()
	{
		if(!textCI.getText().isEmpty())
		{
			if(!textAnio.getText().isEmpty())
			{
				buscarTextoMontoRecaudado(Long.parseLong(textCI.getText()), Integer.parseInt(textAnio.getText()));
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Ingrese un año lectivo", "ERROR!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Ingrese una cedula de alumno", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
	}

}
