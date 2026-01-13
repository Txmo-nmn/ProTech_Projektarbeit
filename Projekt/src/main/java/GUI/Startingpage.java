package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        Dimension squareSize = new Dimension(70, 60);


        panel1.setLayout(new GridLayout(1, 2, 16, 0));
        panel1.setBorder(
                BorderFactory.createMatteBorder(
                        0, 0, 0, 24,
                        new Color(46, 46, 46)
                )
        );



        Color borderNormal = Color.WHITE;
        Color borderHover  = new Color(120, 120, 120); // z. B. helles Grau

        Border normalBorder = BorderFactory.createLineBorder(borderNormal, 4);
        Border hoverBorder  = BorderFactory.createLineBorder(borderHover, 4);

        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        button_AddConfig.setBorder(normalBorder);

        button_AddConfig.setFocusPainted(false);
        button_AddConfig.setBorderPainted(true);
        button_AddConfig.setContentAreaFilled(false);
        button_AddConfig.setOpaque(false);
        button_AddConfig.setPreferredSize(squareSize);
        button_AddConfig.setMinimumSize(squareSize);
        button_AddConfig.setMaximumSize(squareSize);

        button_AddConfig.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button_AddConfig.setBorder(hoverBorder);
                button_AddConfig.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button_AddConfig.setBorder(normalBorder);
                button_AddConfig.setCursor(defaultCursor);
            }
        });

        button_SavedConfigs.setBorder(normalBorder);

        button_SavedConfigs.setPreferredSize(squareSize);
        button_SavedConfigs.setMinimumSize(squareSize);
        button_SavedConfigs.setMaximumSize(squareSize);
        button_SavedConfigs.setFocusPainted(false);
        button_SavedConfigs.setBorderPainted(true);
        button_SavedConfigs.setContentAreaFilled(false);
        button_SavedConfigs.setOpaque(false);


        button_SavedConfigs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button_SavedConfigs.setBorder(hoverBorder);
                button_SavedConfigs.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button_SavedConfigs.setBorder(normalBorder);
                button_SavedConfigs.setCursor(defaultCursor);
            }
        });



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
