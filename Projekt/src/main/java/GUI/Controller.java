package GUI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    // Referenz auf die GUI-Instanz, damit der Controller auf die Komponenten zugreifen kann
    private Startingpage startingpage;
    private Konfigurator konfigurator;
    private SavedConfigsScreen savedConfigsScreen;

    Map<String, PC> pcMap = new HashMap<>();    //erstellt Liste der PCs
    private int pcCounter = 0;

    // Konstruktor: bekommt die GUI übergeben und speichert sie in der Instanzvariable
    public Controller() {
        initObjekte();
        showStartingpage();
    }

    // Konstruktor für Tests
    public Controller(boolean startGUI) {
        initObjekte();
        if (startGUI) {
            showStartingpage();
        }
    }

    public static void main(String[] args) {
        new Controller();
    }

    // --- GUI an Controller binden ---
    public void showStartingpage() {
        startingpage = new Startingpage(this);
        startingpage.setVisible(true);
    }

    public void openKonfigurator() {
        konfigurator = new Konfigurator(this);
        konfigurator.setVisible(true);
    }

    public void openSavedConfigsScreen(){
        savedConfigsScreen = new SavedConfigsScreen(this);
        savedConfigsScreen.setVisible(true);
    }

    //alle Werte auslesen und speichern und Objekt erstellen
    public void speichern(Konfigurator gui){
        pcCounter++;
        int nummer = pcCounter;
        String name = gui.name_textField.getText();
        if(name.isEmpty()){
            name = "Konfiguration" + nummer;
        }
        String gehaeuse = gui.gehaeuse_comboBox.getSelectedItem().toString();
        String cpu = gui.cpu_comboBox.getSelectedItem().toString();
        String gpu = gui.gpu_comboBox.getSelectedItem().toString();
        String ram = gui.ram_comboBox.getSelectedItem().toString();
        String motherboard = gui.motherboard_comboBox.getSelectedItem().toString();
        String cpuCooler = gui.cpuCooler_comboBox.getSelectedItem().toString();
        String memory = gui.memory_comboBox.getSelectedItem().toString();
        String psu = gui.psu_comboBox.getSelectedItem().toString();
        double gesPreis = gui.getGesPreis();
        boolean vollstaendig = gui.getVollstaendig();

        PC pc = new PC(name, gehaeuse, cpu, gpu, ram, motherboard, cpuCooler, memory, psu, gesPreis,vollstaendig, nummer);   //neues PC Objekt erstellen

        String key = "pc" + pcCounter;
        pcMap.put(key, pc);

        //Ausgabe in Konsole (zum Test)
        System.out.println(key + ": " + pc);
    }

    //Sortierung nach größter gesPreis
    public List<PC> sortGgesPreis(){
        return pcMap.values().stream()
                .sorted(Comparator.comparingDouble(PC::getGesPreis).reversed())
                .collect(Collectors.toList());
    }

    //Sortierung nach kleinster gesPreis
    public List<PC> sortKgesPreis(){
        return pcMap.values().stream()
                .sorted(Comparator.comparingDouble(PC::getGesPreis))
                .collect(Collectors.toList());
    }

    //gib einfach alle PC objekte als Liste zurück
    public List<PC> unsortList(){
        return pcMap.values().stream()
                .sorted(Comparator.comparingDouble(PC::getNummer).reversed())
                .collect(Collectors.toList());
    }

    //gib nur die Objekte aus die unter/gleich des max Preises sind
    public List<PC> presiList(double preis){
        return pcMap.values().stream()
                .filter(pc -> pc.getGesPreis() <= preis) // nur PCs unter/gleich Preis
                .collect(Collectors.toList());
    }

    //3 Objecte erstellen
    public void initObjekte(){
        PC pc1 = new PC("Konfiguration 1","Gehäuse 1", "CPU 1", "GPU 1", "RAM 1",
                "Motherboard 1", "CPU Cooler 1", "SSD 1", "PSU 1", 400,true,1);
        PC pc2 = new PC("Konfiguration 2","Gehäuse 2", "CPU 2", "GPU 2", "RAM 2",
                "Motherboard 2", "CPU Cooler 2", "SSD 2", "PSU 2", 640,true,2);
        PC pc3 = new PC("Konfiguration 3","Gehäuse 3", "CPU 3", "GPU 3", "RAM 3",
                "Motherboard 3", "CPU Cooler 3", "SSD 3", "PSU 3", 800,true,3);

        // automatische Nummerierung
        pcCounter++;
        pcMap.put("pc" + pcCounter, pc1);
        pcCounter++;
        pcMap.put("pc" + pcCounter, pc2);
        pcCounter++;
        pcMap.put("pc" + pcCounter, pc3);
    }

    //getter
    public Map<String, PC> getPcMap() {
        return pcMap;
    }
}
