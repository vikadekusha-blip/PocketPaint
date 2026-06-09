import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected int strokeWidth;

    public Shape(Color color, int strokeWidth) {
        this.color = color;
        this.strokeWidth = strokeWidth;
    }

    public abstract void draw(Graphics2D g2d);
}