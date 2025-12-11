package GUI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {
    private Controller controller;
    private PC pc1, pc2, pc3;

    @BeforeEach
    public void setupPcHasMap() {
        controller = new Controller(false);

        pc1 = new PC("Gehäuse 1", "CPU 1", "GPU 1", "RAM 1",
                "Motherboard 1", "CPU Cooler 1", "SSD 1", "PSU 1", 1000);
        pc2 = new PC("Gehäuse 2", "CPU 2", "GPU 2", "RAM 2",
                "Motherboard 2", "CPU Cooler 2", "SSD 2", "PSU 2", 2000);
        pc3 = new PC("Gehäuse 3", "CPU 3", "GPU 3", "RAM 3",
                "Motherboard 3", "CPU Cooler 3", "SSD 3", "PSU 3", 1500);

        controller.getPcMap().clear();
        controller.getPcMap().put("pc1", pc1);
        controller.getPcMap().put("pc2", pc2);
        controller.getPcMap().put("pc3", pc3);
    }

    @Test
    void sortGgesPreis() {
        List<PC> sortiert = controller.sortGgesPreis();

        //Prüfen ob korrekt sortiert wurde
        assertEquals(pc2, sortiert.get(0));
        assertEquals(pc3, sortiert.get(1));
        assertEquals(pc1, sortiert.get(2));
    }

    @Test
    void sortKgesPreis() {
        List<PC> sortiert = controller.sortKgesPreis();

        //Prüfen ob korrekt sortiert wurde
        assertEquals(pc1, sortiert.get(0));
        assertEquals(pc3, sortiert.get(1));
        assertEquals(pc2, sortiert.get(2));
    }
}