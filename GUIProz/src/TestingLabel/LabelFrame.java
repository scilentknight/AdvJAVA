package TestingLabel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    // LabelFrame constructor adds JLabels to JFrame
    public LabelFrame()
    {
        super("Testing JLabel");
        setLayout(new FlowLayout()); // set frame layout

        // JLabel constructor with a string argument
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        add(label1);

        // JLabel constructor with string, icon and alignment arguments
        Icon bug = new ImageIcon(getClass().getResource("bug.png"));
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        add(label2);

        // JLabel 3 code
        label3 = new JLabel();
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add(label3);
    }
}
