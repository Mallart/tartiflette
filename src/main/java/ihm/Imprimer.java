package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Imprimer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Imprimer frame = new Imprimer();
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
	public Imprimer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 470);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		this.contentPane.add(panel, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("   Général    ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("   Mise en page   ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("   Apparence   ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		this.contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 309, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 23, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JButton btnNewButton_3 = new JButton("Imprimer");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Annuler");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 0;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.contentPane.add(panel_2, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(panel_4, "cell 0 0,grow");

		JLabel lblNewLabel_2 = new JLabel("Nom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_2, "cell 0 0,alignx center");

		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox, "cell 1 0,growx");

		JButton btnNewButton_5 = new JButton("Propriétés");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnNewButton_5, "cell 3 0,alignx center");

		JLabel lblNewLabel_3 = new JLabel("Statut :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_3, "cell 0 1,alignx center");

		JLabel lblNewLabel_6 = new JLabel("Acceptation des tâches");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_6, "cell 1 1,alignx center");

		JLabel lblNewLabel_4 = new JLabel("Type : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_4, "cell 0 2,alignx center");

		JLabel lblNewLabel_5 = new JLabel("Infos :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_5, "cell 0 3,alignx center");

		JCheckBox chckbxNewCheckBox = new JCheckBox("Impimer dans un fichier");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(chckbxNewCheckBox, "cell 3 3,growx");

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "cell 0 1,grow");
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_6 = new JPanel();
		panel_6.setName("");
		panel_6.setToolTipText("");
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_6);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_6.add(rdbtnNewRadioButton_1, "cell 0 0,alignx center");

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_6.add(rdbtnNewRadioButton, "cell 0 1,alignx center");

		this.textField = new JTextField();
		this.textField.setText("1");
		panel_6.add(this.textField, "cell 1 1");
		this.textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("A");
		panel_6.add(lblNewLabel_1, "cell 2 1,alignx trailing");

		this.textField_1 = new JTextField();
		this.textField_1.setText("1");
		panel_6.add(this.textField_1, "cell 3 1,growx");
		this.textField_1.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setMaximumSize(new Dimension(10, 10));
		panel_3.add(panel_7);

		JPanel panel_5 = new JPanel();
		panel_5.setSize(new Dimension(5500, 0));
		panel_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_5);

		JLabel lblNewLabel_7 = new JLabel("Nombres de copies :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(lblNewLabel_7, "cell 0 0,alignx center,aligny center");

		JSpinner spinner = new JSpinner();
		panel_5.add(spinner, "cell 1 0,growx");

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Collationner");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(chckbxNewCheckBox_1, "cell 0 1,alignx center");
	}

}
