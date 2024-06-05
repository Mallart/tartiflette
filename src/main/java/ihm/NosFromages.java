package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import modele.*;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class NosFromages extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomDuFromage;
	private Fromages listFromages;
	private Panier panier;
	
	private void showCheese(int cheeseIndex)
	{
		new FromageDescription(this.listFromages.getFromages().get(cheeseIndex), panier).setVisible(true);
	}
	
	private void showBasket(Panier panier)
	{
		new PanierWindow(panier).setVisible(true);
	}
	
	
	public static void main(Fromages fromages) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NosFromages frame = new NosFromages(fromages);
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
		this.panier = new Panier();
		this.listFromages = listFromages;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		System.out.println("------------------------------------------------");
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		System.out.println("------------------------------------------------");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		System.out.println("------------------------------------------------");
		JButton Panier = new JButton("Votre Panier");
		Panier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBasket(panier);
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		System.out.println("------------------------------------------------");
		JLabel titre = new JLabel("NOS FROMAGES");
		titre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(titre, BorderLayout.WEST);
		panel.add(Panier, BorderLayout.EAST);
		System.out.println("------------------------------------------------");
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		System.out.println("------------------------------------------------");
		txtNomDuFromage = new JTextField();
		txtNomDuFromage.setText("Nom du fromage");
		txtNomDuFromage.setToolTipText("NomFromgage");
		panel_1.add(txtNomDuFromage, BorderLayout.CENTER);
		txtNomDuFromage.setColumns(10);
		
		String typeDeLaitArray[] = {"Tous","Vache","Chèvre","Brebis"};
		JComboBox<String> selectionDeLait = new JComboBox<String>(typeDeLaitArray);
		selectionDeLait.setPreferredSize(new Dimension(100, 22));
		selectionDeLait.setName("");
		selectionDeLait.setToolTipText("Type de lait");
		panel_1.add(selectionDeLait, BorderLayout.EAST);
		

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		

		JList <String> fromageJlist = new JList<String>();

		scrollPane.setViewportView(fromageJlist);
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		printListToVP(listFromages, fromageJlist, DLM,selectionDeLait);
		refreshList(DLM, selectionDeLait);
	}
	
	private void refreshList(DefaultListModel<String> DLM, JComboBox<String> typeDeLait)
	{
		DLM.removeAllElements();
		for(Fromage f : listFromages.getFromages()) {
			if(f.getTypeFromage().getTypeDeLait() == typeDeLait.getSelectedItem()) {
				DLM.addElement(f.getDésignation());
			}else if(typeDeLait.getSelectedItem() ==  "Tous") {
				DLM.addElement(f.getDésignation());
			}
		}
	}

	private void printListToVP(Fromages listFromages, JList <String> fromageJlist, DefaultListModel<String> DLM,JComboBox<String> typeDeLait) {
		
		typeDeLait.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshList(DLM, typeDeLait);
			}
		});
		fromageJlist.setModel(DLM);
		fromageJlist.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				showCheese(fromageJlist.getSelectedIndex());
			}
		});
	}
}
