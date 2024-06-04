package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.Coordonnées;

public class Facture extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static Coordonnées coordonnées;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Facture frame = new Facture(coordonnées);
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
	public Facture(Coordonnées coordonnées) {
		Facture.coordonnées = coordonnées;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 511);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		// crée l'instances
		Calendar dateFrance = Calendar.getInstance(Locale.FRANCE);
		// obtenir l'heure en date
		Date date = dateFrance.getTime();
		// format de date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
		// date en string
		String dateString = dateFormat.format(date);

		String nom = coordonnées.getNom();
		String prenom = coordonnées.getPrenom();
		//TODO changer pour les éléménts suivant----------->
		String adresse = new String("tripomme");
		String numero = new String("0674958127");
		String mèl = new String("Jacob.bob@gmail.com");

		String prodnom = new String("fromage");
		Object[][] data = { { prodnom, 10.0, 2, 24.0 }, { "Produit B", 15.5, 3, 55.65 }, { "Produit C", 7.2, 1, 8.64 },
				{ "Produit D", 20.0, 5, 120.0 } };

		JPanel panel_5 = new JPanel();
		this.contentPane.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_6.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Merci de votre visite !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Commande du ");
		panel_2.add(lblNewLabel_1);

		JLabel dateLabel = new JLabel("New label");
		dateLabel.setText(dateString);
		panel_2.add(dateLabel);

		JLabel lblNewLabel_2 = new JLabel(" heure d'été d'Europe centrale");
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		list.setBackground(new Color(240, 240, 240));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { " ", nom + " " + prenom, adresse, numero, mèl };

			@Override
			public int getSize() {
				return this.values.length;
			}

			@Override
			public Object getElementAt(int index) {
				return this.values[index];
			}
		});
		list.setToolTipText("");
		panel_4.add(list);

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		this.table = new JTable();
		this.table.setModel(
				new DefaultTableModel(data, new String[] { "Produits", "Prix unitaire", "Quantités", "Prix TTC" }));
		scrollPane.setViewportView(this.table);

		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		JLabel lblNewLabel_4 = new JLabel("FRAIS DE TRANSPORT : ");
		panel_10.add(lblNewLabel_4);

		String livraisonPrix = new String("138");
		JLabel prixlivraison = new JLabel("New label");
		panel_10.add(prixlivraison);
		prixlivraison.setText(livraisonPrix);

		JLabel lblNewLabel_7_1 = new JLabel(" €, livraison par ");
		panel_10.add(lblNewLabel_7_1);

		String livreur = new String("chronopost");
		JLabel typedelivraison = new JLabel("New label");
		panel_10.add(typedelivraison);
		typedelivraison.setText(livreur);

		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

		JLabel lblNewLabel_5 = new JLabel("TOTAL TTC COMMANDE : ");
		panel_11.add(lblNewLabel_5);

		JLabel prixttccommande = new JLabel("New label");
		panel_11.add(prixttccommande);
		String prixcommande = new String("10");
		prixttccommande.setText(prixcommande);

		JLabel lblNewLabel_7 = new JLabel(" €, paiment par ");
		panel_11.add(lblNewLabel_7);

		String typedepaiment = new String("cheque");
		JLabel typeDePaiment = new JLabel("New label");
		panel_11.add(typeDePaiment);
		typeDePaiment.setText(typedepaiment);

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

		JLabel lblNewLabel_6 = new JLabel("PRIX TOTAL TTC :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_9.add(lblNewLabel_6);

		String prixTotal = new String("148");
		JLabel prixtotal = new JLabel("New label");
		prixtotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_9.add(prixtotal);
		prixtotal.setText(prixTotal);

		JLabel lblNewLabel_7_2 = new JLabel(" €");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_9.add(lblNewLabel_7_2);

		JPanel panel_7 = new JPanel();
		this.contentPane.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("Votre facture");
		lblNewLabel_3.setSize(new Dimension(10, 10));
		lblNewLabel_3.setSize(50, 50);
		lblNewLabel_3.setVisible(true);
		lblNewLabel_3.setIconTextGap(1);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\floco\\Downloads\\665ddd07.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_7.add(lblNewLabel_3, BorderLayout.CENTER);

	}

}
