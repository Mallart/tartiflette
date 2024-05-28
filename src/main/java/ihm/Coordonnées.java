package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Coordonnées extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_3;
	private JPanel panel_6;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JPanel panel_8;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JPanel panel_7;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_12;
	private JLabel lblNewLabel_8;
	private JRadioButton rdbtnNon;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coordonnées frame = new Coordonnées();
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
	public Coordonnées() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setToolTipText("caazdzd");
		panel.setForeground(Color.RED);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setAlignmentX(0.0f);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		panel_1.add(textField);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, textField}));
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_1 = new JLabel("Prénom : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, textField_2}));
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_2 = new JLabel("Adresse 1 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_3 = new JLabel("Adresse 2 : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_4 = new JLabel("Code postal : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_5 = new JLabel("Ville : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_6.add(textField_4);
		
		panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_7 = new JLabel("Téléphone : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_8.add(textField_7);
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_6 = new JLabel("Mail : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_7.add(textField_6);
		
		panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_10 = new JPanel();
		panel_9.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("Valider");
		panel_10.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Annuler");
		panel_10.add(btnNewButton_1);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_9.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_12 = new JPanel();
		panel_11.add(panel_12);
		
		lblNewLabel_8 = new JLabel("S'abonner a la newsletter : ");
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		panel_12.add(lblNewLabel_8);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Oui");
		panel_12.add(rdbtnNewRadioButton_1);
		
		rdbtnNon = new JRadioButton("Non");
		panel_11.add(rdbtnNon);
	}

}
