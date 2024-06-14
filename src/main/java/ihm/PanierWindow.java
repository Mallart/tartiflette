package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.Article;
import modele.Panier;

public class PanierWindow extends JFrame {

	private JPanel contentPane;
	private JTable products;
	private JTextField price_exVAT;
	private JTextField price_transportFees;
	private JTextField price_total;
	private Panier panier;

	private static final String[] columnsName = { "Icône", "Nom", "Poids", "Prix à l'unité", "Quantité" };
	private Map<String, Float> transporters;

	/**
	 * Launch the application.
	 */
	public static void main(Panier _panier) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PanierWindow frame = new PanierWindow(_panier);
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
	@SuppressWarnings("serial")
	public PanierWindow(Panier _panier) {
		this.transporters = new HashMap<String, Float>() {
			{
				put("FedEx", 47.f);
				put("Colissimo", 11.f);
				put("La Poste", 10.5f);
				put("Papi", 0.10f);
			}
		};
		this.panier = _panier;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Float prixLivraison = 0.f;

		setContentPane(this.contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.contentPane.add(splitPane);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_1.setLeftComponent(splitPane_2);

		JLabel imm_vPanier = new JLabel("Votre panier:");
		splitPane_2.setLeftComponent(imm_vPanier);

		JButton btn_recalc_Basket = new JButton("Recalculer le panier");
		splitPane_2.setRightComponent(btn_recalc_Basket);

		this.products = new JTable();
		this.products.setRowSelectionAllowed(false);

		splitPane_1.setRightComponent(this.products);

		JSplitPane panel_afterTable = new JSplitPane();
		panel_afterTable.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(panel_afterTable);

		JSplitPane panel_transport_prices = new JSplitPane();
		panel_afterTable.setLeftComponent(panel_transport_prices);

		JPanel panel_transport = new JPanel();
		panel_transport_prices.setLeftComponent(panel_transport);
		panel_transport.setLayout(new BorderLayout(0, 0));

		JLabel imm_transportFeesOffered = new JLabel("Frais de port offerts à partir de 120€");
		panel_transport.add(imm_transportFeesOffered, BorderLayout.NORTH);

		JLabel img_transporterLogo = new JLabel("transporter.jpg");
		panel_transport.add(img_transporterLogo, BorderLayout.WEST);

		JComboBox<String> cmb_transporter = new JComboBox<String>();
		
		
		cmb_transporter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Actualise la valeur des frais de transport
				float transport = PanierWindow.this.transporters.get(cmb_transporter.getSelectedItem());
				RefreshPrices(panier, transport, PanierWindow.this.price_exVAT, PanierWindow.this.price_transportFees,
						PanierWindow.this.price_total);
			}
		});
		panel_transport.add(cmb_transporter, BorderLayout.EAST);

		JPanel panel_totals_prices = new JPanel();
		panel_transport_prices.setRightComponent(panel_totals_prices);

		JSplitPane labels_separation_prices = new JSplitPane();
		panel_totals_prices.add(labels_separation_prices);

		JPanel panel_labels = new JPanel();
		labels_separation_prices.setLeftComponent(panel_labels);
		panel_labels.setLayout(new BoxLayout(panel_labels, BoxLayout.Y_AXIS));

		JLabel imm_exVATPrices = new JLabel("Sous - Total");
		panel_labels.add(imm_exVATPrices);

		JLabel imm_transportFees = new JLabel("Expédition");
		panel_labels.add(imm_transportFees);

		JLabel imm_total = new JLabel("Total");
		panel_labels.add(imm_total);

		JPanel panel_prices = new JPanel();
		labels_separation_prices.setRightComponent(panel_prices);
		panel_prices.setLayout(new BoxLayout(panel_prices, BoxLayout.Y_AXIS));

		this.price_exVAT = new JTextField();
		this.price_exVAT.setText(((Float) panier.prixTotalPanier()).toString());
		this.price_exVAT.setEditable(false);
		panel_prices.add(this.price_exVAT);
		this.price_exVAT.setColumns(10);

		this.price_transportFees = new JTextField();
		this.price_transportFees
				.setText((panier.prixTotalPanier() >= 120.f ? (Float) 0.f : (Float) prixLivraison).toString());
		this.price_transportFees.setEditable(false);
		panel_prices.add(this.price_transportFees);
		this.price_transportFees.setColumns(10);

		this.price_total = new JTextField();
		this.price_total.setText(((Float) (panier.totalPanier(prixLivraison))).toString());
		this.price_total.setEditable(false);
		panel_prices.add(this.price_total);
		this.price_total.setColumns(10);

		JPanel panel_actions = new JPanel();
		panel_afterTable.setRightComponent(panel_actions);
		panel_actions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btn_validateBasket = new JButton("Valider le panier");
		btn_validateBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CoordonnéesWindow(panier,panier.prixTotalPanier() >= 120 ? 0.f :PanierWindow.this.transporters.get(cmb_transporter.getSelectedItem())).setVisible(true);
			}
		});
		panel_actions.add(btn_validateBasket);

		JButton btn_emptyBasket = new JButton("Vider le panier");
		btn_emptyBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmptyBasket(panier);
				RefreshPrices(panier, prixLivraison, PanierWindow.this.price_exVAT,
						PanierWindow.this.price_transportFees, PanierWindow.this.price_total);
			}
		});
		panel_actions.add(btn_emptyBasket);

		JButton btn_continueShopping = new JButton("Continuer les achats");
		btn_continueShopping.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cmb_transporter.setModel(new DefaultComboBoxModel<String>() {
			{
				for (String transporter : PanierWindow.this.transporters.keySet()) {
					addElement(transporter);
				}
			}
		});
		cmb_transporter.setSelectedIndex(0);

		panel_actions.add(btn_continueShopping);
		RefreshPrices(panier, prixLivraison, this.price_exVAT, this.price_transportFees, this.price_total);
		FillTable(panier);
	}

	private void EmptyBasket(Panier panier) {
		// Reremplir les stocks avant de vider le panier pour éviter les fuites de
		// fromage
		for (Article article : panier.getPanierSansDoublon()) {
			article.setQuantitéEnStock(article.getQuantitéEnStock() + panier.nombreOccurencesArticle(article));
		}
		panier.viderPanier();
		this.FillTable(panier);
	}

	private void RefreshPrices(Panier panier, float tfees, JTextField price, JTextField transportfees,
			JTextField total) {
		price.setText(String.valueOf(panier.prixTotalPanier()));
		transportfees
				.setText(panier.prixTotalPanier() >= Panier.PRIX_OFFRE_LIVRAISON || panier.getTaillePanier() == 0 ? "0"
						: String.valueOf(tfees));
		total.setText(String.valueOf(panier.totalPanier(tfees)));
	}

	@SuppressWarnings("serial")
	private void FillTable(Panier panier) {
		DefaultTableModel dtm = new DefaultTableModel(columnsName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == columnsName.length - 1) {
					return true;
				}
				return false;
			}
		};
		// Indications sur les colonnes du panier
		dtm.addRow(new String[] { "Icône", "Nom fromage", "Type de facturation", "Prix", "Quantité" });
		for (Article article : panier.getPanierSansDoublon()) {
			dtm.addRow(new String[] { article.getFromage().getNomImage(), article.getFromage().getDésignation(),
					article.getClé().isEmpty() ? "Prix à l'unité" : article.getClé(),
					((Float) article.getPrixTTC()).toString(),
					((Integer) panier.nombreOccurencesArticle(article)).toString() });
		}
		this.products.setModel(dtm);
	}

}
