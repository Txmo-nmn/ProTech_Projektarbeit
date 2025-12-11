package GUI;

import javax.swing.*;

public class SavedConfigsScreen extends JFrame{
    private JPanel panel1;
    private JButton buttonBack;
    private JTable objektAusgabe_table;
    private Controller controller;

    public SavedConfigsScreen(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        buttonBack.addActionListener(e -> {
            dispose();
            controller.showStartingpage();
        });

        showList();
    }

    private void showList(){
        // Liste aus Controller holen
        var pcs = controller.sortGgesPreis();

        // Spaltenüberschriften
        String[] columnNames = {
                "Gehäuse", "CPU", "GPU", "RAM",
                "Motherboard", "Kühler", "Speicher", "Netzteil", "Preis"
        };

        // Daten-The matrix
        Object[][] data = new Object[pcs.size()][columnNames.length];

        for (int i = 0; i < pcs.size(); i++) {
            PC pc = pcs.get(i);
            data[i][0] = pc.getGehaeuse();
            data[i][1] = pc.getCpu();
            data[i][2] = pc.getGpu();
            data[i][3] = pc.getRam();
            data[i][4] = pc.getMotherboard();
            data[i][5] = pc.getCpuCooler();
            data[i][6] = pc.getMemory();
            data[i][7] = pc.getPsu();
            data[i][8] = pc.getGesPreis();
        }

        // Model erstellen und der vorhandenen JTable zuweisen
        objektAusgabe_table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columnNames
        ));

        // Optional: Sortierfunktion aktivieren
        objektAusgabe_table.setAutoCreateRowSorter(true);

        objektAusgabe_table.setRowHeight(28);
        objektAusgabe_table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}
