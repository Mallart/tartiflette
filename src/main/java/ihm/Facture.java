package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class Facture extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture frame = new Facture();
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
	public Facture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Merci de votre visite !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Commande du ");
		panel_2.add(lblNewLabel_1);
		
		//crée l'instances
		Calendar dateFrance = Calendar.getInstance(Locale.FRANCE);
		//obtenir l'heure en date
		Date date = dateFrance.getTime();
		//format de date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
		//date en string
		String dateString = dateFormat.format(date);
		
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
		
		String nom = new String("jacob");
		String prenom = new String("bob");
		String adresse = new String("tripomme");
		String numero = new String("0674958127");
		String mèl = new String("Jacob.bob@gmail.com");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setBackground(new Color(240, 240, 240));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {" ",nom + " " + prenom, adresse, numero, mèl};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		panel_4.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		String prodnom = new String("fromage");
		Object[][] data = {
	            {prodnom, 10.0, 2, 24.0},
	            {"Produit B", 15.5, 3, 55.65},
	            {"Produit C", 7.2, 1, 8.64},
	            {"Produit D", 20.0, 5, 120.0}
	        };
		
		table = new JTable();
		table.setModel(new DefaultTableModel(data,
			new String[] {
				"Produits", "Prix unitaire", "Quantités", "Prix TTC"
			}
		));
		scrollPane.setViewportView(table);
	}

}