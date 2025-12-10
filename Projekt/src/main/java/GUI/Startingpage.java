package GUI;

import javax.swing.*;

public class Startingpage extends JFrame {

    private JPanel panel1;
    private JPanel Startingpage;        // NEU: Feld für das Binding aus der .form
    private JButton button_AddConfig;
    private JButton button_SavedConfigs;

    public Startingpage() {
        // Root-Panel aus der .form als Inhalt setzen
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);    // zentriert das Fenster

        // Button "Add Config" öffnet den Konfigurator
        button_AddConfig.addActionListener(e -> {
            Konfigurator konfigurator = new Konfigurator();
            konfigurator.setLocationRelativeTo(this);
            konfigurator.setVisible(true);
            dispose();                  // Startingpage schließen
        });

        // button_SavedConfigs kannst du später noch befüllen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Startingpage().setVisible(true);   // Startingpage als erstes Fenster
        });
    }
}
