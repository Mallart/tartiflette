package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import modele.Article;
import modele.Fromage;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class PanierWindow extends JFrame {

	private JPanel contentPane;
	private JTable products;
	private JTextField price_exVAT;
	private JTextField price_transportFees;
	private JTextField price_total;
	
	private String[] columnsName = { "Icône", "Nom", "Poids", "Prix à l'unité"};
	private DefaultTableModel productsTableModel;
	
	private List<String> transporters = new ArrayList<String>(){{
		add("FedEx");
		add("Colissimo");
		add("La Poste");
		add("Papi");
	}};

	/**
	 * Launch the application.
	 */
	public static void main(List<Article> articles) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanierWindow frame = new PanierWindow(articles);
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
	public PanierWindow(List<Article> articles) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_1.setLeftComponent(splitPane_2);
		
		JLabel imm_vPanier = new JLabel("Votre panier:");
		splitPane_2.setLeftComponent(imm_vPanier);
		
		JButton btn_recalc_Basket = new JButton("Recalculer le panier");
		splitPane_2.setRightComponent(btn_recalc_Basket);
		
		products = new JTable();
		productsTableModel = new DefaultTableModel(columnsName, 0);
		
		splitPane_1.setRightComponent(products);
		
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
		
		JComboBox cmb_transporter = new JComboBox();
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
		
		price_exVAT = new JTextField();
		price_exVAT.setText("XX,XX €");
		price_exVAT.setEditable(false);
		panel_prices.add(price_exVAT);
		price_exVAT.setColumns(10);
		
		price_transportFees = new JTextField();
		price_transportFees.setText("XX,XX €");
		price_transportFees.setEditable(false);
		panel_prices.add(price_transportFees);
		price_transportFees.setColumns(10);
		
		price_total = new JTextField();
		price_total.setText("XX,XX €");
		price_total.setEditable(false);
		panel_prices.add(price_total);
		price_total.setColumns(10);
		
		JPanel panel_actions = new JPanel();
		panel_afterTable.setRightComponent(panel_actions);
		panel_actions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_validateBasket = new JButton("Valider le panier");
		panel_actions.add(btn_validateBasket);
		
		JButton btn_emptyBasket = new JButton("Vider le panier");
		panel_actions.add(btn_emptyBasket);
		
		JButton btn_continueShopping = new JButton("Continuer les achats");
		cmb_transporter.setModel(new DefaultComboBoxModel<String>() {{for(String transporter : transporters) addElement(transporter);}});		
		cmb_transporter.setSelectedIndex(0);
		
		panel_actions.add(btn_continueShopping);
		FillTable(articles, (DefaultTableModel)products.getModel());
	}
	
	private void FillTable(List<Article> articles, DefaultTableModel dtm)
	{
		while(dtm.getColumnCount() > 0)
			dtm.removeRow(0);
		for(Article article : articles)
		{
			String poids = "jsp frr kg";
			dtm.addRow(new Object[] { article.getFromage().getNomImage(), article.getFromage().getDésignation(), poids, article.getPrixTTC() });
		}
	}

}
