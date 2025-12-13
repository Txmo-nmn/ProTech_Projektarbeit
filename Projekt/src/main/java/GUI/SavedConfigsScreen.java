package GUI;

import javax.swing.*;
import java.util.List;

public class SavedConfigsScreen extends JFrame{
    private JPanel panel1;
    private JButton buttonBack;
    private JTable objektAusgabe_table;
    public JComboBox sortPreis_comboBox;
    private JTextField preis_textField;
    private JLabel filterName_Label;
    private Controller controller;

    public SavedConfigsScreen(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        showList(controller.unsortList());

        sortPreis_comboBox.addActionListener(e -> changeListByPreis());
        buttonBack.addActionListener(e -> {
            dispose();
            controller.showStartingpage();
        });

        preis_textField.addActionListener(e->{
            //Fehlerbehandlung
            try {
                String preisEingabe = preis_textField.getText().trim(); //trim entfernt leerzeichen

                //wirft Fehler bei leerem Textfeld
                if (preisEingabe.isEmpty()) {
                    throw new NumberFormatException("Leer");
                }
                //dadurch kann man auch Kommas eingeben
                preisEingabe = preisEingabe.replace(',', '.');
                double preis = Double.parseDouble(preisEingabe);

                //gültige Eingabe -> Liste anzeigen
                showList(controller.presiList(preis));
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Bitte eine gültige Zahl eingeben!\nBeispiel: 999.99",
                    "Ungültige Eingabe",
                    JOptionPane.ERROR_MESSAGE
                );

                //Feld leeren
                preis_textField.setText("");
            }
        });
    }

    private void showList(List<PC> pcs){
        // Spaltenüberschriften
        String[] columnNames = {
                "Name","Gehäuse", "CPU", "GPU", "RAM",
                "Motherboard", "Kühler", "Speicher", "Netzteil", "Preis"
        };

        // Daten-The matrix
        Object[][] data = new Object[pcs.size()][columnNames.length];

        for (int i = 0; i < pcs.size(); i++) {
            PC pc = pcs.get(i);
            data[i][0] = pc.getName();
            data[i][1] = pc.getGehaeuse();
            data[i][2] = pc.getCpu();
            data[i][3] = pc.getGpu();
            data[i][4] = pc.getRam();
            data[i][5] = pc.getMotherboard();
            data[i][6] = pc.getCpuCooler();
            data[i][7] = pc.getMemory();
            data[i][8] = pc.getPsu();
            data[i][9] = pc.getGesPreis();
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

    //schaut was der Benutzer bei der Preissortierung ausgewählt hat
    public void changeListByPreis(){
        String sort = sortPreis_comboBox.getSelectedItem().toString();
        switch (sort) {
            case "-":
                showList(controller.unsortList());
                break;
            case "Preis sinkend":
                showList(controller.sortGgesPreis());
                break;
            case "Preis aufsteigend":
                showList(controller.sortKgesPreis());
                break;
            default:
                showList(controller.unsortList());
        }
    }
}
