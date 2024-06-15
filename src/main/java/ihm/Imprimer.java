package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Imprimer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 700, 309);
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
		btnNewButton_4.addActionListener(e -> {
			this.dispose();
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 0;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);

		JPanel panel_2 = new JPanel();
		this.contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		panel_7.add(comboBox);

		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel_13.add(horizontalGlue);

		JButton btnNewButton_1 = new JButton("Propriete");
		panel_13.add(btnNewButton_1);

		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Statut : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel("Acceptation des tâches ");
		panel_11.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_11_2 = new JPanel();
		panel_4.add(panel_11_2);
		panel_11_2.setLayout(new GridLayout(0, 1, 0, 0));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Imprimer dans un fichier");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_11_2.add(chckbxNewCheckBox);

		JPanel panel_11_1 = new JPanel();
		panel_4.add(panel_11_1);
		panel_11_1.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("Type : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11_1.add(lblNewLabel_4);

		JPanel panel_11_4 = new JPanel();
		panel_4.add(panel_11_4);

		JPanel panel_11_3 = new JPanel();
		panel_4.add(panel_11_3);
		panel_11_3.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("Infos :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11_3.add(lblNewLabel_5);

		JPanel panel_11_5 = new JPanel();
		panel_4.add(panel_11_5);

		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);

		JPanel panel_3 = new JPanel();
		panel_12.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setName("");
		panel_6.setToolTipText("");
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tout");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(rdbtnNewRadioButton_1);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.SOUTH);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pages");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(rdbtnNewRadioButton);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		panel_8.add(spinner_1);

		JLabel lblNewLabel_1 = new JLabel("A");
		panel_8.add(lblNewLabel_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		panel_8.add(spinner_2);

		JPanel panel_10 = new JPanel();
		panel_10.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_10.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_10.setMaximumSize(new Dimension(10, 10));
		panel_6.add(panel_10, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setSize(new Dimension(5500, 0));
		panel_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_7 = new JLabel("Nombres de copies :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(lblNewLabel_7);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		panel_5.add(spinner);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Collationner");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(chckbxNewCheckBox_1);

		JLabel label_3 = new JLabel("");
		panel_5.add(label_3);

		Component horizontalStrut = Box.createHorizontalStrut(32);
		panel_3.add(horizontalStrut, BorderLayout.CENTER);
	}

}
