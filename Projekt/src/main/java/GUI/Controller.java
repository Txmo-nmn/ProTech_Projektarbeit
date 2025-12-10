package GUI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    // Referenz auf die GUI-Instanz, damit der Controller auf die Komponenten zugreifen kann
    private Konfigurator gui;

    private Map<String, PC> pcMap = new HashMap<>();    //erstellt Liste der PCs
    private int pcCounter = 0;

    // Konstruktor: bekommt die GUI übergeben und speichert sie in der Instanzvariable
    public Controller(Konfigurator gui) {
        this.gui = gui;
    }

    //alle Werte auslesen und speichern und Objekt erstellen
    public void speichern(){
        String gehaeuse = gui.gehaeuse_comboBox.getSelectedItem().toString();
        String cpu = gui.cpu_comboBox.getSelectedItem().toString();
        String gpu = gui.gpu_comboBox.getSelectedItem().toString();
        String ram = gui.ram_comboBox.getSelectedItem().toString();
        String motherboard = gui.motherboard_comboBox.getSelectedItem().toString();
        String cpuCooler = gui.cpuCooler_comboBox.getSelectedItem().toString();
        String memory = gui.memory_comboBox.getSelectedItem().toString();
        String psu = gui.psu_comboBox.getSelectedItem().toString();
        double gespreis = gui.getGesPreis();

        PC pc = new PC(gehaeuse, cpu, gpu, ram, motherboard, cpuCooler, memory, psu, gespreis);   //neues PC Objekt erstellen

        pcCounter++;
        String key = "pc" + pcCounter;
        pcMap.put(key, pc);

        //Ausgabe in Konsole (zum Test)
        System.out.println(key + ": " + pc);
    }

    //Sortierung nach größter gesPreis
    public void sortGgesPreis(){
        List<PC> sortiert = pcMap.values().stream()
                .sorted(Comparator.comparingDouble(PC::getGesPreis).reversed())
                .collect(Collectors.toList());

        //gibt die sortierte Liste aus (nur zum Test)
        for (PC pc : sortiert) {
            System.out.println(pc);
        }
    }

    //Sortierung nach kleinster gesPreis
    public void sortKgesPreis(){
        List<PC> sortiert = pcMap.values().stream()
                .sorted(Comparator.comparingDouble(PC::getGesPreis))
                .collect(Collectors.toList());

        //gibt die sortierte Liste aus (nur zum Test)
        for (PC pc : sortiert) {
            System.out.println(pc);
        }
    }

    //Testausgaben für PC-Listen
    public void test(){
        for (Map.Entry<String, PC> eintrag : pcMap.entrySet()) {
            System.out.println(eintrag.getKey() + " -> " + eintrag.getValue());
        }
        System.out.println("--------------------");
        sortKgesPreis();
    }
}
