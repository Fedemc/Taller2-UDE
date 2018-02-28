package sistema.grafica.ventanas;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sistema.grafica.controladores.ContVentanaRespaldo;

public class VentanaRespaldo {

	private ContVentanaRespaldo contVentResp;
	
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRespaldo window = new VentanaRespaldo();
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
	public VentanaRespaldo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Respaldar Datos");
		frame.setSize(315, 237);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("62px"),
				ColumnSpec.decode("178px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("41px"),
				RowSpec.decode("45px"),
				RowSpec.decode("37px"),}));
		
		JButton btnRespaldar = new JButton("Respaldar");
		frame.getContentPane().add(btnRespaldar, "2, 4, fill, fill");
		
		btnRespaldar.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed (ActionEvent e)
				{
					contVentResp.Respaldar();
				}
			}
		);
		
		JButton btnVolver = new JButton("Volver");
		frame.getContentPane().add(btnVolver, "2, 6, fill, fill");
		
		btnVolver.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed (ActionEvent e)
				{
					frame.dispose();
				}
			}
		);
						
		Image iconG = new ImageIcon(this.getClass().getResource("/IconG.png")).getImage();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contVentResp=new ContVentanaRespaldo(this);
	}
	
	public void setVisible(boolean valor)
	{
		frame.setVisible(valor);
	}
	
	public void mostrarResultado(String res)
	{
		JOptionPane.showMessageDialog(frame, res, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
}
