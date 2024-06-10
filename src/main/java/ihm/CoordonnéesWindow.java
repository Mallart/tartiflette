package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import modele.Coordonnées;

public class CoordonnéesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomField, prenomField, adresse1Field, adresse2Field, codePostalField, villeField, telephoneField,
			mailField;
	private JRadioButton paypalRadioButton, creditCardRadioButton, chequeRadioButton, ouiRadioButton, nonRadioButton;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				CoordonnéesWindow frame = new CoordonnéesWindow();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CoordonnéesWindow() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel(new BorderLayout());
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);

		this.initComponents();
	}

	private void initComponents() {
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel titleLabel = new JLabel("Vos coordonnées");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Set the font size and style
		titlePanel.add(titleLabel);
		this.contentPane.add(titlePanel, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.contentPane.add(mainPanel, BorderLayout.CENTER);

		this.addLabelAndField(mainPanel, "Nom : ", this.nomField = new JTextField(20), 0);
		this.addLabelAndField(mainPanel, "Prénom : ", this.prenomField = new JTextField(20), 1);
		this.addLabelAndField(mainPanel, "Adresse 1 : ", this.adresse1Field = new JTextField(20), 2);
		this.addLabelAndField(mainPanel, "Adresse 2 : ", this.adresse2Field = new JTextField(20), 3);
		this.addLabelAndField(mainPanel, "Code postal : ", this.codePostalField = new JTextField(10), 4);
		this.addLabelAndField(mainPanel, "Ville : ", this.villeField = new JTextField(20), 5);
		this.addLabelAndField(mainPanel, "Téléphone : ", this.telephoneField = new JTextField(15), 6);
		this.addLabelAndField(mainPanel, "Mail : ", this.mailField = new JTextField(20), 7);

		JPanel paymentPanel = new JPanel(new GridBagLayout());
		paymentPanel.setBorder(BorderFactory.createTitledBorder("Moyen de paiement"));
		GridBagConstraints payeTaille = new GridBagConstraints();
		payeTaille.insets = new Insets(5, 5, 5, 5);
		payeTaille.gridwidth = 2;
		payeTaille.gridx = 0;
		payeTaille.gridy = 8;
		mainPanel.add(paymentPanel, payeTaille);

		this.paypalRadioButton = new JRadioButton("PayPal");
		JLabel paypalLabel = this.createImageLabel("src\\main\\resources\\images\\Images paiements\\PP.png", 40);
		this.addRadioButtonWithImage(paymentPanel, this.paypalRadioButton, paypalLabel, 0);

		this.creditCardRadioButton = new JRadioButton("Carte de crédit");
		JLabel creditCardLabel = this.createImageLabel("src\\main\\resources\\images\\Images paiements\\CB.png", 30);
		this.addRadioButtonWithImage(paymentPanel, this.creditCardRadioButton, creditCardLabel, 1);

		this.chequeRadioButton = new JRadioButton("Paiement par chèque");
		JLabel chequeLabel = this.createImageLabel("src\\main\\resources\\images\\Images paiements\\CQ.png", 40);
		this.addRadioButtonWithImage(paymentPanel, this.chequeRadioButton, chequeLabel, 2);

		JPanel newsletterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		newsletterPanel.setBorder(BorderFactory.createTitledBorder("Abonnement à notre Newsletter"));
		this.ouiRadioButton = new JRadioButton("Oui");
		this.nonRadioButton = new JRadioButton("Non");
		ButtonGroup newsletterGroup = new ButtonGroup();
		newsletterGroup.add(this.ouiRadioButton);
		newsletterGroup.add(this.nonRadioButton);
		newsletterPanel.add(this.ouiRadioButton);
		newsletterPanel.add(this.nonRadioButton);
		GridBagConstraints NewsTaille = new GridBagConstraints();
		NewsTaille = new GridBagConstraints();
		NewsTaille.insets = new Insets(5, 5, 5, 5);
		NewsTaille.gridx = 0;
		NewsTaille.gridy = 9;
		NewsTaille.gridwidth = GridBagConstraints.REMAINDER;
		NewsTaille.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(newsletterPanel, NewsTaille);

		JPanel buttonPanel = new JPanel();
		JButton validerButton = new JButton("Valider");
		JButton annulerButton = new JButton("Annuler");
		buttonPanel.add(validerButton);
		buttonPanel.add(annulerButton);
		GridBagConstraints FinTaille = new GridBagConstraints();
		FinTaille = new GridBagConstraints();
		FinTaille.insets = new Insets(5, 5, 5, 5);
		FinTaille.gridx = 0;
		FinTaille.gridy = 10;
		FinTaille.gridwidth = 2;
		mainPanel.add(buttonPanel, FinTaille);

		validerButton.addActionListener(e -> {
			String modePaiement = "";
			boolean abbNewsletter = false;
			if (this.paypalRadioButton.isSelected()) {
				modePaiement = "PayPal";
			} else if (this.creditCardRadioButton.isSelected()) {
				modePaiement = "Carte de crédit";
			} else if (this.chequeRadioButton.isSelected()) {
				modePaiement = "Paiement par chèque";
			}

			if (this.ouiRadioButton.isSelected()) {
				abbNewsletter = true;
			}

			Coordonnées coordonnées = new Coordonnées(this.nomField.getText(), this.prenomField.getText(),
					this.adresse1Field.getText(), this.adresse2Field.getText(), this.codePostalField.getText(),
					this.villeField.getText(), this.telephoneField.getText(), this.mailField.getText(), modePaiement,
					abbNewsletter);

			new Facture(this.nomField.getText(), this.prenomField.getText(), this.adresse1Field.getText(),
					this.adresse2Field.getText(), this.telephoneField.getText(), this.mailField.getText())
					.setVisible(true);

		});

		annulerButton.addActionListener(e -> {
			this.hide();
		});
	}

	private void addLabelAndField(JPanel panel, String labelText, JTextField textField, int yPosition) {
		GridBagConstraints PanTaille = new GridBagConstraints();
		PanTaille.insets = new Insets(5, 5, 5, 5);
		PanTaille.gridx = 0;
		PanTaille.gridy = yPosition;
		PanTaille.gridwidth = 1;
		PanTaille.fill = GridBagConstraints.HORIZONTAL;
		panel.add(new JLabel(labelText), PanTaille);
		PanTaille.gridx = 1;
		panel.add(textField, PanTaille);
	}

	private JLabel createImageLabel(String imagePath, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image img = icon.getImage();
		Image scaledImg = this.getScaledImage(img, height);
		return new JLabel(new ImageIcon(scaledImg));
	}

	private void addRadioButtonWithImage(JPanel panel, JRadioButton radioButton, JLabel label, int yPosition) {
		GridBagConstraints PanTaille = new GridBagConstraints();
		PanTaille.insets = new Insets(5, 5, 5, 5);
		PanTaille.gridx = 0;
		PanTaille.gridy = yPosition;
		PanTaille.anchor = GridBagConstraints.WEST;
		panel.add(radioButton, PanTaille);
		PanTaille.gridx = 1;
		panel.add(label, PanTaille);

		radioButton.addActionListener(e -> {
			if (radioButton.isSelected()) {
				this.paypalRadioButton.setSelected(radioButton == this.paypalRadioButton);
				this.creditCardRadioButton.setSelected(radioButton == this.creditCardRadioButton);
				this.chequeRadioButton.setSelected(radioButton == this.chequeRadioButton);
			}
		});
	}

	private Image getScaledImage(Image srcImg, int height) {
		int width = (int) (height * ((double) srcImg.getWidth(null) / srcImg.getHeight(null)));
		return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
}
