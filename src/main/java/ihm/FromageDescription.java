package ihm;

import modele.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class FromageDescription extends JFrame {

	private JPanel contentPane;
	private Fromage fromage;

	/**
	 * Launch the application.
	 */
	public static void main(Fromage fromage) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromageDescription frame = new FromageDescription(fromage);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FromageDescription(Fromage fromage) {
		this.fromage = fromage;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		ImageIcon fromageIcon = new ImageIcon(this.fromage.getNomImage());
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel nomFromages = new JLabel((String) null);
		nomFromages.setFont(new Font("Stencil", Font.PLAIN, 24));
		panel.add(nomFromages);
		
		JLabel label = new JLabel((Icon) null);
		panel.add(label);
	}

}
