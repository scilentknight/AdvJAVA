package TestingMouseEventHandling;

import javax.swing.JFrame;

public class MouseTrackerTest {
    public static void main(String[] args) {
        MouseTrackerFrame mft = new MouseTrackerFrame();
        mft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mft.setSize(400, 300);
        mft.setVisible(true);
    }
}
