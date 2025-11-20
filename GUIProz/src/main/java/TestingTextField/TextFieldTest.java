package TestingTextField;
import TestingLabel.LabelFrame;

import javax.swing.JFrame;

public class TextFieldTest {
    public static void main(String[] args) {
        TextFieldFrame textFieldFrame = new TextFieldFrame();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(260, 180);
        textFieldFrame.setVisible(true);
    }
}
