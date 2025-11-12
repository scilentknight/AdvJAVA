package GraphicsDrawingColors;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        Color color = g.getColor();
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        // set new drawing color using integers
        Color color1 = new Color(255, 0, 0);
        g.setColor(color1);
        g.fillRect(15, 25, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 40);

        // set new drawing color using float
        Color color2 = new Color(0.50f, 0.75f, 0.0f);
        g.setColor(color2);
        g.fillRect(15, 50, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 65);

        // set new drawing color using static Color object
//        Color color3 = Color.BLUE;
        // or
        g.setColor(Color.BLUE);
        g.fillRect(15, 100, 100, 20);
        g.drawString("Current RGB: " + g.getColor(), 130, 90);

        // Display individual RGB values
        g.drawString(
                "RGB Values: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue(),
                130, 115
        );
    }
}
