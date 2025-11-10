package GraphicsDrawingColors;

import javax.swing.JFrame;

public class ColorsTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        ColorsPanel cp = new ColorsPanel();
        frame.add(cp);
        frame.setVisible(true);
    }
}
