package GUI;

public class PC {
    private String gehaeuse;
    private String cpu;
    private String gpu;
    private String ram;
    private String motherboard;
    private String cpuCooler;
    private String memory;
    private String psu;

    //Constructor
    public PC(String gehaeuse, String cpu, String gpu, String ram, String motherboard, String cpuCooler, String memory, String psu) {
        this.gehaeuse = gehaeuse;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.motherboard = motherboard;
        this.cpuCooler = cpuCooler;
        this.memory = memory;
        this.psu = psu;
    }

    public static void main(String[] args) {

    }

    //gibt objekt auf Konsole aus (zum Test)
    @Override
    public String toString() {
        return "PC{" +
                "Gehäuse='" + gehaeuse + '\'' +
                ", CPU='" + cpu + '\'' +
                ", GPU='" + gpu + '\'' +
                ", RAM='" + ram + '\'' +
                ", Motherboard='" + motherboard + '\'' +
                ", CPU Cooler='" + cpuCooler + '\'' +
                ", Memory='" + memory + '\'' +
                ", PSU='" + psu + '\'' +
                '}';
    }
}

