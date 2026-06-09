import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {
    private List<Shape> shapes = new ArrayList<>();

    private String currentTool = "Brush";
    private Color currentColor = Color.BLACK;
    private int currentStroke = 5;

    private int lastX, lastY;
    private int startX, startY;
    private Shape previewShape = null;

    public PaintPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                lastX = startX;
                lastY = startY;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (previewShape != null) {
                    shapes.add(previewShape);
                    previewShape = null;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int currentX = e.getX();
                int currentY = e.getY();

                Color activeColor = currentTool.equals("Eraser") ? Color.WHITE : currentColor;

                switch (currentTool) {
                    case "Brush":
                    case "Eraser":
                        shapes.add(new LineShape(lastX, lastY, currentX, currentY, activeColor, currentStroke));
                        lastX = currentX;
                        lastY = currentY;
                        break;
                    case "Line":
                        previewShape = new LineShape(startX, startY, currentX, currentY, activeColor, currentStroke);
                        break;
                    case "Rect":
                        previewShape = new RectangleShape(startX, startY, currentX, currentY, activeColor, currentStroke);
                        break;
                    case "Oval":
                        previewShape = new OvalShape(startX, startY, currentX, currentY, activeColor, currentStroke);
                        break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape shape : shapes) {
            shape.draw(g2d);
        }

        if (previewShape != null) {
            previewShape.draw(g2d);
        }
    }

    public void setTool(String tool) { this.currentTool = tool; }
    public void setColor(Color color) { this.currentColor = color; }
    public void setStroke(int stroke) { this.currentStroke = stroke; }

    public void clearCanvas() {
        shapes.clear();
        previewShape = null;
        repaint();
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }
}