package TestingMouseEventHandlingWithMouseAdapter;

import javax.swing.JFrame;

public class MouseHandlerTest {
    public static void main(String[] args) {
        MouseHandlerFrame frame = new MouseHandlerFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
