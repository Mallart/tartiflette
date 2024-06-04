package ihm;

import modele.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JTextArea;

public class FromageDescription extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(SaisieFromage fromage, Panier panier) {
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
	
	public static String getImagePath(Fromage fromage)
	{
		return System.getProperty("user.dir") + "\\src\\main\\resources\\images\\fromages\\hauteur200\\"+ fromage.getNomImage() + ".jpg";
	}

	/**
	 * Create the frame.
	 */
	public FromageDescription(SaisieFromage fromage) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 684, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		ImageIcon fromageIcon = new ImageIcon(this.getImagePath(fromage.builderFromage()));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JLabel nomFromage = new JLabel(fromage.builderFromage().getDésignation());
		nomFromage.setFont(new Font("Stencil", Font.PLAIN, 24));
		
		JLabel fromageImage = new JLabel(fromageIcon);
		
		nomFromage.setAlignmentX(CENTER_ALIGNMENT);
		fromageImage.setAlignmentX(CENTER_ALIGNMENT);
		
		leftPanel.add(nomFromage);
		leftPanel.add(fromageImage);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		contentPane.add(rightPanel, BorderLayout.CENTER);
		
		JLabel desc = new JLabel("Description");
		rightPanel.add(desc);
		
		JTextArea description = new JTextArea();
		description.setEditable(false);
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		
		description.setForeground(new Color(0,0,0));
		description.setText(fromage.builderFromage().getDescription());
		rightPanel.add(description);
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		bottomPanel.add(splitPane, BorderLayout.NORTH);
		
		JSplitPane splitPane_1 = new JSplitPane();
		bottomPanel.add(splitPane_1, BorderLayout.SOUTH);
	}

}
