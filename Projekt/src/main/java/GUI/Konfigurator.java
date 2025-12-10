package GUI;

import javax.swing.*;

public class Konfigurator extends JFrame {
    private JLabel title_label;
    private JLabel gehaeuse_label;
    private JLabel cpu_label;
    private JLabel gpu_label;
    private JLabel motherboard_label;
    private JLabel ram_label;
    private JLabel psu_label;
    private JLabel memory_label;
    private JLabel cpuCooler_label;
    private JLabel gesamtpreis_label;

    // Componentauswahl:
    public JComboBox gehaeuse_comboBox;
    public JComboBox cpu_comboBox;
    public JComboBox gpu_comboBox;
    public JComboBox ram_comboBox;
    public JComboBox motherboard_comboBox;
    public JComboBox cpuCooler_comboBox;
    public JComboBox memory_comboBox;
    public JComboBox psu_comboBox;

    // Componentpreise:
    private JLabel gehaeusePreis_label;
    private JLabel cpuPreis_label;
    private JLabel gpuPreis_label;
    private JLabel ramPreis_label;
    private JLabel motherboardPreis_label;
    private JLabel cpuCoolerPreis_label;
    private JLabel memoryPreis_label;
    private JLabel psuPreis_label;
    private JLabel preisSumme_label;
    private JTextArea konfigurationen_textArea;
    private JButton speichern_button;
    private JLabel konfigurationen_label;
    private JPanel main_Panel;

    // Preisberechnung
    private double gehaeusePreis;
    private double cpuPreis;
    private double gpuPreis;
    private double ramPreis;
    private double motherboardPreis;
    private double cpuCoolerPreis;
    private double memoryPreis;
    private double psuPreis;
    private double gesPreis;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Konfigurator::new);
    }

    public Konfigurator() {
        setTitle("PC Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel aus der .form verwenden
        setContentPane(main_Panel);

        // Layout berechnen
        pack();

        // --- Vollbild-Einstellungen ---
        setExtendedState(JFrame.MAXIMIZED_BOTH); // maximiert auf gesamten Bildschirm
        setVisible(true);
        // -------------------------------

        reset();

        Controller controller = new Controller(this);

        // updatet PreisLabels
        gehaeuse_comboBox.addActionListener(e -> gehaeusePreisChange());
        cpu_comboBox.addActionListener(e -> cpuPreisChange());
        gpu_comboBox.addActionListener(e -> gpuPreisChange());
        ram_comboBox.addActionListener(e -> ramPreisChange());
        motherboard_comboBox.addActionListener(e -> motherboardPreisChange());
        cpuCooler_comboBox.addActionListener(e -> cpuCoolerPreisChange());
        memory_comboBox.addActionListener(e -> memoryPreisChange());
        psu_comboBox.addActionListener(e -> psuPreisChange());

        speichern_button.addActionListener(e -> controller.speichern());
    }

    // setzt am Anfang alles auf Standard
    private void reset() {
        gehaeusePreis_label.setText("-");
        cpuPreis_label.setText("-");
        gpuPreis_label.setText("-");
        ramPreis_label.setText("-");
        motherboardPreis_label.setText("-");
        cpuCoolerPreis_label.setText("-");
        memoryPreis_label.setText("-");
        psuPreis_label.setText("-");
        preisSumme_label.setText("0€");
    }

    // ab hier alles wie gehabt …
    private void gehaeusePreisChange() {
        String gehaeuse = gehaeuse_comboBox.getSelectedItem().toString();
        switch (gehaeuse) {
            case "Gehäuse 1":
                gehaeusePreis_label.setText("50€");
                gehaeusePreis = 50;
                break;
            case "Gehäuse 2":
                gehaeusePreis_label.setText("80€");
                gehaeusePreis = 80;
                break;
            case "Gehäuse 3":
                gehaeusePreis_label.setText("100€");
                gehaeusePreis = 100;
                break;
            default:
                gehaeusePreis_label.setText("-");
                gehaeusePreis = 0;
        }
        gesamtpreisRechner();
    }

    private void cpuPreisChange() {
        String cpu = cpu_comboBox.getSelectedItem().toString();
        switch (cpu) {
            case "CPU 1":
                cpuPreis_label.setText("50€");
                cpuPreis = 50;
                break;
            case "CPU 2":
                cpuPreis_label.setText("80€");
                cpuPreis = 80;
                break;
            case "CPU 3":
                cpuPreis_label.setText("100€");
                cpuPreis = 100;
                break;
            default:
                cpuPreis_label.setText("-");
                cpuPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void gpuPreisChange() {
        String gpu = gpu_comboBox.getSelectedItem().toString();
        switch (gpu) {
            case "GPU 1":
                gpuPreis_label.setText("50€");
                gpuPreis = 50;
                break;
            case "GPU 2":
                gpuPreis_label.setText("80€");
                gpuPreis = 80;
                break;
            case "GPU 3":
                gpuPreis_label.setText("100€");
                gpuPreis = 100;
                break;
            default:
                gpuPreis_label.setText("-");
                gpuPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void ramPreisChange() {
        String ram = ram_comboBox.getSelectedItem().toString();
        switch (ram) {
            case "RAM 1":
                ramPreis_label.setText("50€");
                ramPreis = 50;
                break;
            case "RAM 2":
                ramPreis_label.setText("80€");
                ramPreis = 80;
                break;
            case "RAM 3":
                ramPreis_label.setText("100€");
                ramPreis = 100;
                break;
            default:
                ramPreis_label.setText("-");
                ramPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void motherboardPreisChange() {
        String motherboard = motherboard_comboBox.getSelectedItem().toString();
        switch (motherboard) {
            case "Motherboard 1":
                motherboardPreis_label.setText("50€");
                motherboardPreis = 50;
                break;
            case "Motherboard 2":
                motherboardPreis_label.setText("80€");
                motherboardPreis = 80;
                break;
            case "Motherboard 3":
                motherboardPreis_label.setText("100€");
                motherboardPreis = 100;
                break;
            default:
                motherboardPreis_label.setText("-");
                motherboardPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void cpuCoolerPreisChange() {
        String cpuCooler = cpuCooler_comboBox.getSelectedItem().toString();
        switch (cpuCooler) {
            case "CPU Cooler 1":
                cpuCoolerPreis_label.setText("50€");
                cpuCoolerPreis = 50;
                break;
            case "CPU Cooler 2":
                cpuCoolerPreis_label.setText("80€");
                cpuCoolerPreis = 80;
                break;
            case "CPU Cooler 3":
                cpuCoolerPreis_label.setText("100€");
                cpuCoolerPreis = 100;
                break;
            default:
                cpuCoolerPreis_label.setText("-");
                cpuCoolerPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void memoryPreisChange() {
        String memory = memory_comboBox.getSelectedItem().toString();
        switch (memory) {
            case "SSD 1":
                memoryPreis_label.setText("50€");
                memoryPreis = 50;
                break;
            case "SSD 2":
                memoryPreis_label.setText("80€");
                memoryPreis = 80;
                break;
            case "SSD 3":
                memoryPreis_label.setText("80€");
                memoryPreis = 80;
                break;
            case "HDD 1":
                memoryPreis_label.setText("100€");
                memoryPreis = 100;
                break;
            case "HHD 2":
                memoryPreis_label.setText("100€");
                memoryPreis = 100;
                break;
            case "NVME 1":
                memoryPreis_label.setText("100€");
                memoryPreis = 100;
                break;
            case "NVME 2":
                memoryPreis_label.setText("100€");
                memoryPreis = 100;
                break;
            default:
                memoryPreis_label.setText("-");
                memoryPreis = 0;
        }
        gesamtpreisRechner();
    }

    private void psuPreisChange() {
        String psu = psu_comboBox.getSelectedItem().toString();
        switch (psu) {
            case "PSU 1":
                psuPreis_label.setText("50€");
                psuPreis = 50;
                break;
            case "PSU 2":
                psuPreis_label.setText("80€");
                psuPreis = 80;
                break;
            case "PSU 3":
                psuPreis_label.setText("100€");
                psuPreis = 100;
                break;
            default:
                psuPreis_label.setText("-");
                psuPreis = 0;
        }
        gesamtpreisRechner();
    }

    // berechnet und setzt den Gesamtpreis
    private void gesamtpreisRechner() {
        gesPreis = gehaeusePreis + cpuPreis + gpuPreis + ramPreis + motherboardPreis +
                cpuCoolerPreis + memoryPreis + psuPreis;
        preisSumme_label.setText(gesPreis + "€");
    }
}
