package TestingFont;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FontJPanel extends JPanel {
    // displaying Strings in different fonts and colors
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // call superclass's paintComponents
        g.setFont(new Font("Nirmala UI", Font.BOLD,12));
        g.drawString("मेरो देश नेपाल", 150, 30);

        g.setFont(new Font("Monospaced", Font.ITALIC, 24));
        g.drawString("Monospaced 24 point italic.", 20, 80);

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("SansSerif 14 point plain", 20, 100);

        g.setColor(Color.RED);
        g.drawString("Point bold and italic.",20,120);
    }
}
