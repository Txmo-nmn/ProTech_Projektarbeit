package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        panel1.setBorder(
                BorderFactory.createMatteBorder(
                        25, 40, 40, 40,
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

        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(
                JScrollPane.class, objektAusgabe_table
        );

        scrollPane.getViewport().setBackground(new Color(46, 46, 46));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(46, 46, 46), 2));

        objektAusgabe_table.setBorder(normalBorder);
        objektAusgabe_table.setBackground(new Color(46, 46, 46));
        objektAusgabe_table.setForeground(Color.WHITE);
        objektAusgabe_table.setGridColor(Color.WHITE);
        objektAusgabe_table.setShowGrid(true);
        objektAusgabe_table.setFillsViewportHeight(true);
        objektAusgabe_table.setFocusable(false);
        scrollPane.setFocusable(false);
        scrollPane.getViewport().setFocusable(false);

        JTableHeader header = objektAusgabe_table.getTableHeader();
        header.setBackground(new Color(46, 46, 46));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                super.getTableCellRendererComponent(
                        table, value, false, false, row, column
                );

                setBackground(Color.WHITE);
                setForeground(new Color(46, 46, 46));
                setHorizontalAlignment(CENTER);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                return this;
            }
        });




        buttonBack.setBorder(normalBorder);
        buttonBack.setFocusPainted(false);
        buttonBack.setBorderPainted(true);
        buttonBack.setContentAreaFilled(false);
        buttonBack.setOpaque(false);
        buttonBack.setPreferredSize(squareSize);
        buttonBack.setMinimumSize(squareSize);
        buttonBack.setMaximumSize(squareSize);
        buttonBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack.setBorder(hoverBorder);
                buttonBack.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack.setBorder(normalBorder);
                buttonBack.setCursor(defaultCursor);
            }
        });
        buttonBack.addActionListener(e -> {
            dispose();
            controller.showStartingpage();
        });


        sortPreis_comboBox.setFocusable(false);
        sortPreis_comboBox.setBorder(normalBorder);
        sortPreis_comboBox.setBackground(new Color(46, 46, 46));
        sortPreis_comboBox.setForeground(Color.WHITE);
        sortPreis_comboBox.setUI(new BasicComboBoxUI() {

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


        preis_textField.setBackground(new Color(46, 46, 46));
        preis_textField.setForeground(Color.WHITE);
        preis_textField.setBorder(BorderFactory.createMatteBorder(
                0, 0, 2, 0,
                new Color(255, 255, 255)
        ));

        preis_textField.addActionListener(e->{
            //Fehlerbehandlung
            try {
                String preisEingabe = preis_textField.getText().trim(); //trim entfernt leerzeichen

                //wirft Fehler bei leerem Textfeld
                if (preisEingabe.isEmpty()) {
                    showList(controller.unsortList());
                    return;
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
                "Motherboard", "Kühler", "Speicher", "Netzteil","Vollständig","Preis"
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
            data[i][9] = pc.getVollstaendig();
            data[i][10] = pc.getGesPreis();
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
