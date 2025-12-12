package GUI;

import javax.swing.*;
import java.awt.*;

public class Startingpage extends JFrame {

    private JPanel panel1;
    private JPanel Startingpage;
    private JButton button_AddConfig;
    private JButton button_SavedConfigs;
    private Controller controller;

    public Startingpage(Controller controller) {
        this.controller = controller;
        // Root-Panel aus der .form als Inhalt setzen
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- NEU: Immer im Fullscreen starten ---
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiert Fenster
        setVisible(true);
        // ----------------------------------------
        button_AddConfig.setFocusPainted(false);
        button_AddConfig.setBorderPainted(false);
        button_AddConfig.setContentAreaFilled(false);
        button_AddConfig.setOpaque(false);

        button_SavedConfigs.setFocusPainted(false);
        button_SavedConfigs.setBorderPainted(false);
        button_SavedConfigs.setContentAreaFilled(false);
        button_SavedConfigs.setOpaque(false);

        // Button "Add Config" öffnet den Konfigurator
        button_AddConfig.addActionListener(e -> {controller.openKonfigurator();
            dispose();  // Startingpage schließen
        });

        button_SavedConfigs.addActionListener(e -> {
            dispose();
            controller.openSavedConfigsScreen();
        });
    }
}
