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
        ImageIcon paypalIcon = new ImageIcon("C:\\Users\\Diego\\eclipse-workspace\\programmation_SAE_S2-01_GE_3\\src\\main\\resources\\images\\Images paiements\\PP.png");
        Image paypalImg = paypalIcon.getImage();
        Image resizedPaypalImage = getScaledImage(paypalImg, 40);
        paypalIcon = new ImageIcon(resizedPaypalImage);
        paypalLabel.setIcon(paypalIcon);

        paypalPanel.add(paypalRadioButton);
        paypalPanel.add(paypalLabel);
        paymentPanel.add(paypalPanel);

        // Credit card radio button with image
        JPanel creditCardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        creditCardRadioButton = new JRadioButton("Carte de crédit");
        JLabel creditCardLabel = new JLabel();

        // Load and resize the credit card image
        ImageIcon creditCardIcon = new ImageIcon("C:\\Users\\Diego\\eclipse-workspace\\programmation_SAE_S2-01_GE_3\\src\\main\\resources\\images\\Images paiements\\CB.png");
        Image creditCardImg = creditCardIcon.getImage();
        Image resizedCreditCardImage = getScaledImage(creditCardImg, 30);
        creditCardIcon = new ImageIcon(resizedCreditCardImage);
        creditCardLabel.setIcon(creditCardIcon);

        creditCardPanel.add(creditCardRadioButton);
        creditCardPanel.add(creditCardLabel);
        paymentPanel.add(creditCardPanel);

        // Cheque radio button with image
        JPanel chequePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chequeRadioButton = new JRadioButton("Paiement par chèque");
        JLabel chequeLabel = new JLabel();

        // Load and resize the cheque image
        ImageIcon chequeIcon = new ImageIcon("C:\\Users\\Diego\\eclipse-workspace\\programmation_SAE_S2-01_GE_3\\src\\main\\resources\\images\\Images paiements\\CQ.png");
        Image chequeImg = chequeIcon.getImage();
        Image resizedChequeImage = getScaledImage(chequeImg, 40);
        chequeIcon = new ImageIcon(resizedChequeImage);
        chequeLabel.setIcon(chequeIcon);

        chequePanel.add(chequeRadioButton);
        chequePanel.add(chequeLabel);
        paymentPanel.add(chequePanel);

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

    private Image getScaledImage(Image srcImg, int height) {
        int width = (int) (height * ((double) srcImg.getWidth(null) / srcImg.getHeight(null)));
        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
