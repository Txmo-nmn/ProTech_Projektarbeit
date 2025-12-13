package GUI;

public class PC {
    private String name;
    private String gehaeuse;
    private String cpu;
    private String gpu;
    private String ram;
    private String motherboard;
    private String cpuCooler;
    private String memory;
    private String psu;
    private double gesPreis;
    private int nummer;

    //Constructor
    public PC(String name, String gehaeuse, String cpu, String gpu, String ram, String motherboard, String cpuCooler, String memory, String psu, double gesPreis, int nummer) {
        this.name = name;
        this.gehaeuse = gehaeuse;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.motherboard = motherboard;
        this.cpuCooler = cpuCooler;
        this.memory = memory;
        this.psu = psu;
        this.gesPreis = gesPreis;
        this.nummer = nummer;
    }

    //getter
    public String getName(){return name;}
    public String getGehaeuse() {
        return gehaeuse;
    }
    public String getCpu() {
        return cpu;
    }
    public String getGpu() {
        return gpu;
    }
    public String getRam() {
        return ram;
    }
    public String getMotherboard() {
        return motherboard;
    }
    public String getCpuCooler() {
        return cpuCooler;
    }
    public String getMemory() {
        return memory;
    }
    public String getPsu() {
        return psu;
    }
    public double getGesPreis() {
        return gesPreis;
    }
    public int getNummer(){
        return nummer;
    }
}

