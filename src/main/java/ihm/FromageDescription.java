package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modele.Article;
import modele.Fromage;
import modele.Panier;

public class FromageDescription extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(Fromage fromage, Panier panier) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FromageDescription frame = new FromageDescription(fromage, panier);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String getImagePath(Fromage fromage) {
		return System.getProperty("user.dir") + "\\src\\main\\resources\\images\\fromages\\hauteur200\\"
				+ fromage.getNomImage() + ".jpg";
	}

	/**
	 * Create the frame.
	 */
	public FromageDescription(Fromage fromage, Panier panier) {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 684, 406);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		ImageIcon fromageIcon = new ImageIcon(FromageDescription.getImagePath(fromage));
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JLabel nomFromage = new JLabel(fromage.getDésignation());
		nomFromage.setFont(new Font("Stencil", Font.PLAIN, 24));

		JLabel fromageImage = new JLabel(fromageIcon);

		nomFromage.setAlignmentX(CENTER_ALIGNMENT);
		fromageImage.setAlignmentX(CENTER_ALIGNMENT);

		leftPanel.add(nomFromage);
		leftPanel.add(fromageImage);

		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		this.contentPane.add(rightPanel, BorderLayout.CENTER);

		JLabel desc = new JLabel("Description");
		rightPanel.add(desc);

		JTextArea description = new JTextArea();
		description.setEditable(false);
		description.setWrapStyleWord(true);
		description.setLineWrap(true);

		description.setForeground(new Color(0, 0, 0));
		description.setText(fromage.getDescription());
		rightPanel.add(description);

		JPanel bottomPanel = new JPanel();
		this.contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		JPanel selectPrice = new JPanel();
		bottomPanel.add(selectPrice, BorderLayout.NORTH);

		JSpinner spn_quantity = new JSpinner();
		spn_quantity.setModel(new SpinnerNumberModel(0, 0, null, 1));

		JComboBox cmb_selectPrice = new JComboBox();
		cmb_selectPrice.setModel(new DefaultComboBoxModel<String>() {
			{
				for (Article article : fromage.getArticles()) {
					addElement("Prix TTC: " + article.getPrixTTC());
				}
			}
		});
		cmb_selectPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMaxQuantity(spn_quantity, fromage, cmb_selectPrice.getSelectedIndex());
			}
		});
		selectPrice.add(cmb_selectPrice);
		selectPrice.add(spn_quantity);

		JPanel addCancel = new JPanel();
		bottomPanel.add(addCancel, BorderLayout.SOUTH);

		JButton btn_addBasket = new JButton("Ajouter au panier");
		btn_addBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterArticlePanier(panier, fromage.getArticles().get(cmb_selectPrice.getSelectedIndex()),
						(int) spn_quantity.getValue());
				dispose();
			}
		});
		addCancel.add(btn_addBasket);

		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		addCancel.add(btn_cancel);
		updateMaxQuantity(spn_quantity, fromage, cmb_selectPrice.getSelectedIndex());
	}

	private void ajouterArticlePanier(Panier panier, Article article, int quantity) {
		panier.ajouterArticlePanier(article, quantity);
	}

	private void updateMaxQuantity(JSpinner spn_quantity, Fromage fromage, int articleIndex) {
		// Rafraîchit le nombre maxiumum de fromages sélectionnables pour cet article
		spn_quantity.setModel(
				new SpinnerNumberModel(0, 0, fromage.getArticles().get(articleIndex).getQuantitéEnStock() - 1, 1));
	}

}
