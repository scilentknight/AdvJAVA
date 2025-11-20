package TestingPolygons;

import javax.swing.JFrame;

public class PolygonsTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PolygonsJPanel polygonsJPanel = new PolygonsJPanel();
        frame.add(polygonsJPanel);
        frame.setSize(400,300);
        frame.setVisible(true);
    }
}
