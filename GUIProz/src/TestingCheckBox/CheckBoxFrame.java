package TestingCheckBox;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxFrame extends JFrame {
    private JTextField textField;
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;

    public CheckBoxFrame() {
        super("JCheckBox Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        // Create the checkboxes
        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italicJCheckBox);

        // Register listeners for JCheckBoxes
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    } // end constructor

    // Inner class to handle item events
    private class CheckBoxHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            Font font;

            if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            else if (italicJCheckBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            else
                font = new Font("Serif", Font.PLAIN, 14);

            textField.setFont(font);
        }
    }
}
