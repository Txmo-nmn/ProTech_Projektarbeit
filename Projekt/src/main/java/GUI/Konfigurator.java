package GUI;

import javax.swing.*;

public class Konfigurator {
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

    //Componentauswahl:
    private JComboBox gehaeuse_comboBox;
    private JComboBox cpu_comboBox;
    private JComboBox gpu_comboBox;
    private JComboBox ram_comboBox;
    private JComboBox motherboard_comboBox;
    private JComboBox cpuCooler_comboBox;
    private JComboBox memory_comboBox;
    private JComboBox psu_comboBox;

    //Componentpreise:
    private JLabel gehaeusePreis_label;
    private JLabel cpuPreislabel;
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
}


