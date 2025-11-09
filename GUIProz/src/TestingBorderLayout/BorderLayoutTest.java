package TestingBorderLayout;
import javax.swing.JFrame;

public class BorderLayoutTest {
    public static void main(String[] args) {
        BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
        borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayoutFrame.setSize(400, 400);
        borderLayoutFrame.setVisible(true);
    }
}
