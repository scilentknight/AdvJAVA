package TestingTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame{
    private JTextField textfield1;
    private JTextField textfield2;
    private JTextField textfield3;
    private JPasswordField passwordField;

    public TextFieldFrame()
    {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());

        // construct textField with 10 columns
        textfield1 = new JTextField(10);
        add(textfield1);

        // construct textField with default text
        textfield2 = new JTextField("Enter text here");
        add(textfield2);

        // construct textField with default text and 21 columns
        textfield3 = new JTextField("Uneditable text field", 20);
        textfield3.setEditable(false);
        add(textfield3);

        // construct passwordField with default text
        passwordField = new JPasswordField("Hidden text");
        add(passwordField);

        // register event handler
        TextFieldHandler handler = new TextFieldHandler();
        textfield1.addActionListener(handler);
        textfield2.addActionListener(handler);
        textfield3.addActionListener(handler);
        passwordField.addActionListener(handler);

    }

    // private inner class for event handling
    private class TextFieldHandler implements ActionListener
    {
        // process text field events
        public void actionPerformed(ActionEvent event)
        {
            String string = ""; // declare string to display

            // user pressed Enter in JTextField textField1
            if (event.getSource() == textfield1) {
                string = String.format("textField1:%s",event.getActionCommand());
            }
            // user pressed Enter in JTextField textField2
            else if (event.getSource() == textfield2) {
                string = String.format("textField2:%s",event.getActionCommand());
            }
            // user pressed Enter in JTextField textField3
            else if (event.getSource() == textfield3) {
                string = String.format("textField3:%s",event.getActionCommand());
            }
            // user pressed Enter in JPasswordField passwordField
            else if (event.getSource() == passwordField) {
                string = String.format("passwordField:%s",event.getActionCommand());
            }

            // display JTextField content
            JOptionPane.showMessageDialog(null, string);

        }
    }

}
