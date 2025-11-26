package TestingJSlider;

import javax.swing.*;
import java.awt.*;

public class JSliderFrame extends JPanel {
    private int diameter = 10;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        // Draw circle
        g.fillOval(10, 10, diameter, diameter);
    }

    // Set diameter from slider
    public void setDiameter(int newDiameter) {
        diameter = (newDiameter >= 0 ? newDiameter : 10);
        repaint();
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}
