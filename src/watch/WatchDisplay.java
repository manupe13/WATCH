package watch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel {
    private final Image background;
    private Point[] points;

    public WatchDisplay()  {
        this.background = loadBackground();
        this.points = new Point[0];
    }

    public void paint(Point[] points) {
        this.points = points;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, -1, null);
        g.setColor(Color.black);
        int width = 1;
        for (Point point : points) {
            g2(g).setStroke(new BasicStroke(width));
            g2(g).drawLine(ox(), oy(), ox() + point.x, oy() - point.y);
            width++;
        }
    }
    
    private Graphics2D g2(Graphics g) {
        return (Graphics2D) g;
    }
    
    private int ox() {
        return this.getWidth() / 2;
    }
    
    private int oy() {
        return this.getHeight() / 2;
    }

    private Image loadBackground() {        
        try {
            return ImageIO.read(new File("background.jpg"));
        } catch (IOException ex) {
            return null;
        }
    }

    
    
}
