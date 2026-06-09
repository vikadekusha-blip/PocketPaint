import java.awt.*;

class LineShape extends Shape {
    private int x1, y1, x2, y2;

    public LineShape(int x1, int y1, int x2, int y2, Color color, int strokeWidth) {
        super(color, strokeWidth);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(x1, y1, x2, y2);
    }
}

class RectangleShape extends Shape {
    private int x, y, width, height;

    public RectangleShape(int x1, int y1, int x2, int y2, Color color, int strokeWidth) {
        super(color, strokeWidth);
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawRect(x, y, width, height);
    }
}

class OvalShape extends Shape {
    private int x, y, width, height;

    public OvalShape(int x1, int y1, int x2, int y2, Color color, int strokeWidth) {
        super(color, strokeWidth);
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawOval(x, y, width, height);
    }
}