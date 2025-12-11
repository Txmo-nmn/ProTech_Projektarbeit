package GUI;

import javax.swing.*;

public class SavedConfigsScreen extends JFrame{
    private JPanel panel1;
    private JList configList;
    private JButton buttonBack;

    public SavedConfigsScreen() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        buttonBack.addActionListener(e -> {
            dispose();
            Startingpage start = new Startingpage();
            start.setExtendedState(JFrame.MAXIMIZED_BOTH);
            start.setVisible(true);
        });
    }
}
