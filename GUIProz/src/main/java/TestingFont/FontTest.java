package TestingFont;

import javax.swing.*;

public class FontTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Using Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FontJPanel fp = new FontJPanel();
        frame.add(fp);
        frame.setSize(450,200);
        frame.setVisible(true);
    }
}
