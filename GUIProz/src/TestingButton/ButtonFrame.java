package TestingButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonFrame extends JFrame {
    private JButton btn1;
    private JButton btn2;

    public ButtonFrame() {
        super("Testing JButton");
        setLayout(new FlowLayout()); // set frame layout

        // First button with text
        btn1 = new JButton("Plain Button");
        btn1.setToolTipText("This is btn1");
        add(btn1);

        // Second button with icon
        Icon bug = new ImageIcon(getClass().getResource("bug.png"));
        btn2 = new JButton("Fancy Button", bug);
        btn2.setToolTipText("This is btn2");
        add(btn2);

        // Event handler or Register
        BtnHandler handler = new BtnHandler();
        btn1.addActionListener(handler);
        btn2.addActionListener(handler);

    }

    private class BtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String string = "";

            if (event.getSource() == btn1) {
                string = String.format("You clicked: %s", event.getActionCommand());
            } else if (event.getSource() == btn2) {
                string = String.format("You clicked: %s", event.getActionCommand());
            }

            JOptionPane.showMessageDialog(ButtonFrame.this, string);
            // JOptionPane.showMessageDialog(null, string);
        }
    }

}
