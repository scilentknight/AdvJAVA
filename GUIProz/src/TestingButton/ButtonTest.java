package TestingButton;
import TestingLabel.LabelFrame;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ButtonTest {
    public static void main(String[] args) {
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 180);
        frame.setVisible(true);

    }
}
