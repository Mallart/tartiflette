package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Coordonnées extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomField, prenomField, adresse1Field, adresse2Field, codePostalField, villeField, telephoneField, mailField;
    private JRadioButton paypalRadioButton, creditCardRadioButton, chequeRadioButton, ouiRadioButton, nonRadioButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Coordonnées frame = new Coordonnées();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Coordonnées() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        initComponents();
    }

    private void initComponents() {
        contentPane.setLayout(new BorderLayout());

        // Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        // Layout for main panel
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Creating labels and text fields
        JLabel nomLabel = new JLabel("Nom : ");
        nomField = new JTextField(20);

        JLabel prenomLabel = new JLabel("Prénom : ");
        prenomField = new JTextField(20);

        JLabel adresse1Label = new JLabel("Adresse 1 : ");
        adresse1Field = new JTextField(20);

        JLabel adresse2Label = new JLabel("Adresse 2 : ");
        adresse2Field = new JTextField(20);

        JLabel codePostalLabel = new JLabel("Code postal : ");
        codePostalField = new JTextField(10);

        JLabel villeLabel = new JLabel("Ville : ");
        villeField = new JTextField(20);

        JLabel telephoneLabel = new JLabel("Téléphone : ");
        telephoneField = new JTextField(15);

        JLabel mailLabel = new JLabel("Mail : ");
        mailField = new JTextField(20);

        // Payment options
        JPanel paymentPanel = new JPanel(new GridLayout(3, 1));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Moyen de paiement"));

        // PayPal radio button with image
        JPanel paypalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paypalRadioButton = new JRadioButton("PayPal");
        JLabel paypalLabel = new JLabel();

        // Load and resize the PayPal image
        ImageIcon icon = new ImageIcon("C:\\Users\\Diego\\Downloads\\Paypal_2014_logo.png");
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Adjust the size as needed
        icon = new ImageIcon(resizedImage);
        paypalLabel.setIcon(icon);

        paypalPanel.add(paypalRadioButton);
        paypalPanel.add(paypalLabel);
        paymentPanel.add(paypalPanel);

        creditCardRadioButton = new JRadioButton("Carte de crédit");
        chequeRadioButton = new JRadioButton("Paiement par chèque");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(paypalRadioButton);
        paymentGroup.add(creditCardRadioButton);
        paymentGroup.add(chequeRadioButton);
        paymentPanel.add(creditCardRadioButton);
        paymentPanel.add(chequeRadioButton);

        // Newsletter subscription
        JPanel newsletterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newsletterPanel.setBorder(BorderFactory.createTitledBorder("Abonnement à notre Newsletter"));
        ouiRadioButton = new JRadioButton("Oui");
        nonRadioButton = new JRadioButton("Non");
        ButtonGroup newsletterGroup = new ButtonGroup();
        newsletterGroup.add(ouiRadioButton);
        newsletterGroup.add(nonRadioButton);
        newsletterPanel.add(ouiRadioButton);
        newsletterPanel.add(nonRadioButton);

        // Buttons
        JButton validerButton = new JButton("Valider");
        JButton annulerButton = new JButton("Annuler");

        // Layout settings
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nomLabel)
                    .addComponent(prenomLabel)
                    .addComponent(adresse1Label)
                    .addComponent(adresse2Label)
                    .addComponent(codePostalLabel)
                    .addComponent(villeLabel)
                    .addComponent(telephoneLabel)
                    .addComponent(mailLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nomField)
                    .addComponent(prenomField)
                    .addComponent(adresse1Field)
                    .addComponent(adresse2Field)
                    .addComponent(codePostalField)
                    .addComponent(villeField)
                    .addComponent(telephoneField)
                    .addComponent(mailField)))
            .addComponent(paymentPanel)
            .addComponent(newsletterPanel)
            .addGroup(layout.createSequentialGroup()
                .addComponent(validerButton)
                .addComponent(annulerButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nomLabel)
                .addComponent(nomField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(prenomLabel)
                .addComponent(prenomField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(adresse1Label)
                .addComponent(adresse1Field))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(adresse2Label)
                .addComponent(adresse2Field))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(codePostalLabel)
                .addComponent(codePostalField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(villeLabel)
                .addComponent(villeField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telephoneLabel)
                .addComponent(telephoneField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mailLabel)
                .addComponent(mailField))
            .addComponent(paymentPanel)
            .addComponent(newsletterPanel)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(validerButton)
                .addComponent(annulerButton))
        );
    }
}
