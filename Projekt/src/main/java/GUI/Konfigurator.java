package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton speichern_button;
    private JLabel konfigurationen_label;
    private JPanel main_Panel;
    public JTextField name_textField;
    private JButton zurückButton;

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

    private Controller controller;

    public Konfigurator(Controller controller) {
        this.controller = controller;
        setTitle("PC Konfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel aus der .form verwenden
        setContentPane(main_Panel);

        // Layout berechnen
        pack();

        // --- Vollbild-Einstellungen ---
        setExtendedState(JFrame.MAXIMIZED_BOTH);    // maximiert auf gesamten Bildschirm
        // -------------------------------

        reset();

        // updatet PreisLabels
        gehaeuse_comboBox.addActionListener(e -> gehaeusePreisChange());
        cpu_comboBox.addActionListener(e -> cpuPreisChange());
        gpu_comboBox.addActionListener(e -> gpuPreisChange());
        ram_comboBox.addActionListener(e -> ramPreisChange());
        motherboard_comboBox.addActionListener(e -> motherboardPreisChange());
        cpuCooler_comboBox.addActionListener(e -> cpuCoolerPreisChange());
        memory_comboBox.addActionListener(e -> memoryPreisChange());
        psu_comboBox.addActionListener(e -> psuPreisChange());




        main_Panel.setBorder(
                BorderFactory.createMatteBorder(
                        0, 24, 0, 24,
                        new Color(46, 46, 46)
                )
        );

        Color borderNormal = Color.WHITE;
        Color borderHover  = new Color(120, 120, 120); // z. B. helles Grau

        Border normalBorder = BorderFactory.createLineBorder(borderNormal, 2);
        Border hoverBorder  = BorderFactory.createLineBorder(borderHover, 2);

        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        Dimension squareSize = new Dimension(90, 30);


        gehaeuse_comboBox.setFocusable(false);
        gehaeuse_comboBox.setBorder(normalBorder);
        gehaeuse_comboBox.setBackground(new Color(46, 46, 46));
        gehaeuse_comboBox.setForeground(Color.WHITE);
        gehaeuse_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        cpu_comboBox.setFocusable(false);
        cpu_comboBox.setBorder(normalBorder);
        cpu_comboBox.setBackground(new Color(46, 46, 46));
        cpu_comboBox.setForeground(Color.WHITE);
        cpu_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        gpu_comboBox.setFocusable(false);
        gpu_comboBox.setBorder(normalBorder);
        gpu_comboBox.setBackground(new Color(46, 46, 46));
        gpu_comboBox.setForeground(Color.WHITE);
        gpu_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        ram_comboBox.setFocusable(false);
        ram_comboBox.setBorder(normalBorder);
        ram_comboBox.setBackground(new Color(46, 46, 46));
        ram_comboBox.setForeground(Color.WHITE);
        ram_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        motherboard_comboBox.setFocusable(false);
        motherboard_comboBox.setBorder(normalBorder);
        motherboard_comboBox.setBackground(new Color(46, 46, 46));
        motherboard_comboBox.setForeground(Color.WHITE);
        motherboard_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        cpuCooler_comboBox.setFocusable(false);
        cpuCooler_comboBox.setBorder(normalBorder);
        cpuCooler_comboBox.setBackground(new Color(46, 46, 46));
        cpuCooler_comboBox.setForeground(Color.WHITE);
        cpuCooler_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        memory_comboBox.setFocusable(false);
        memory_comboBox.setBorder(normalBorder);
        memory_comboBox.setBackground(new Color(46, 46, 46));
        memory_comboBox.setForeground(Color.WHITE);
        memory_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        psu_comboBox.setFocusable(false);
        psu_comboBox.setBorder(normalBorder);
        psu_comboBox.setBackground(new Color(46, 46, 46));
        psu_comboBox.setForeground(Color.WHITE);
        psu_comboBox.setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton arrowButton = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON
                        );

                        int w = getWidth();
                        int h = getHeight();

                        // Pfeil zeichnen (weiß)
                        int size = 8;
                        int x = w / 2;
                        int y = h / 2;

                        Polygon arrow = new Polygon();
                        arrow.addPoint(x - size / 2, y - size / 4);
                        arrow.addPoint(x + size / 2, y - size / 4);
                        arrow.addPoint(x, y + size / 2);

                        g2.setColor(Color.WHITE);
                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                // Button-Styling
                arrowButton.setBackground(new Color(46, 46, 46));
                arrowButton.setOpaque(true);
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setFocusPainted(false);
                arrowButton.setContentAreaFilled(true);
                arrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                return arrowButton;
            }

            @Override
            public void paintCurrentValueBackground(
                    Graphics g, Rectangle bounds, boolean hasFocus) {

                g.setColor(new Color(46, 46, 46));
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        });


        zurückButton.setBorder(normalBorder);
        zurückButton.setFocusPainted(false);
        zurückButton.setBorderPainted(true);
        zurückButton.setContentAreaFilled(false);
        zurückButton.setOpaque(false);
        zurückButton.setPreferredSize(squareSize);
        zurückButton.setMinimumSize(squareSize);
        zurückButton.setMaximumSize(squareSize);
        zurückButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                zurückButton.setBorder(hoverBorder);
                zurückButton.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                zurückButton.setBorder(normalBorder);
                zurückButton.setCursor(defaultCursor);
            }
        });
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controller.showStartingpage();
            }
        });


        speichern_button.setBorder(normalBorder);
        speichern_button.setFocusPainted(false);
        speichern_button.setBorderPainted(true);
        speichern_button.setContentAreaFilled(false);
        speichern_button.setOpaque(false);
        speichern_button.setPreferredSize(squareSize);
        speichern_button.setMinimumSize(squareSize);
        speichern_button.setMaximumSize(squareSize);
        speichern_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                speichern_button.setBorder(hoverBorder);
                speichern_button.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                speichern_button.setBorder(normalBorder);
                speichern_button.setCursor(defaultCursor);
            }
        });
        speichern_button.addActionListener(e -> {controller.speichern(this);
            dispose();
            controller.showStartingpage();
        });


        name_textField.setBackground(new Color(46, 46, 46));
        name_textField.setForeground(Color.WHITE);
        name_textField.setBorder(BorderFactory.createMatteBorder(
                0, 0, 2, 0,
                new Color(255, 255, 255)
        ));
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

    //getter
    public double getGesPreis(){
        return gesPreis;
    }
}
