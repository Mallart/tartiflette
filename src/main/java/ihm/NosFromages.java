package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import modele.*;

public class NosFromages extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomDuFromage;
	private static Fromages listFromages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NosFromages frame = new NosFromages(listFromages);
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
	public NosFromages(Fromages listFromages) {
		this.listFromages = listFromages;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane listeFromages = new JScrollPane();
		contentPane.add(listeFromages);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton Panier = new JButton("Votre Panier");
		Panier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titre = new JLabel("NOS FROMAGES");
		titre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(titre, BorderLayout.WEST);
		panel.add(Panier, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtNomDuFromage = new JTextField();
		txtNomDuFromage.setText("Nom du fromage");
		txtNomDuFromage.setToolTipText("NomFromgage");
		panel_1.add(txtNomDuFromage, BorderLayout.CENTER);
		txtNomDuFromage.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(100, 22));
		comboBox.setName("");
		comboBox.setToolTipText("Type de lait");
		panel_1.add(comboBox, BorderLayout.EAST);
	}

}
