import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PocketPaint extends JFrame {
    private PaintPanel paintPanel;

    public PocketPaint() {

        setTitle("Pocket Paint");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        paintPanel = new PaintPanel();
        add(paintPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        controlPanel.setBackground(new Color(240, 240, 240));

        String[] tools = {"Brush", "Line", "Rect", "Oval", "Eraser"};
        JComboBox<String> toolBox = new JComboBox<>(tools);
        toolBox.addActionListener(e -> paintPanel.setTool((String) toolBox.getSelectedItem())); // ActionListener [cite: 36]
        controlPanel.add(new JLabel("Tool:"));
        controlPanel.add(toolBox);

        JSlider strokeSlider = new JSlider(1, 30, 5);
        strokeSlider.addChangeListener(e -> paintPanel.setStroke(strokeSlider.getValue()));
        controlPanel.add(new JLabel("Size:"));
        controlPanel.add(strokeSlider);

        JButton colorBtn = new JButton(" Pick Color ");
        colorBtn.setBackground(Color.BLACK);
        colorBtn.setForeground(Color.WHITE);
        colorBtn.addActionListener(e -> {
            Color selected = JColorChooser.showDialog(this, "Select Paint Color", Color.BLACK); // Окно выбора цвета [cite: 22]
            if (selected != null) {
                paintPanel.setColor(selected);
                colorBtn.setBackground(selected);

                double luminance = (0.299 * selected.getRed() + 0.587 * selected.getGreen() + 0.114 * selected.getBlue()) / 255;
                colorBtn.setForeground(luminance > 0.5 ? Color.BLACK : Color.WHITE);
            }
        });
        controlPanel.add(colorBtn);

        JButton undoBtn = new JButton("Undo");
        undoBtn.addActionListener(e -> paintPanel.undo());
        controlPanel.add(undoBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> paintPanel.clearCanvas());
        controlPanel.add(clearBtn);

        add(controlPanel, BorderLayout.NORTH);

        paintPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK), "undoAction"
        );
        paintPanel.getActionMap().put("undoAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.undo();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PocketPaint().setVisible(true);
        });
    }
}