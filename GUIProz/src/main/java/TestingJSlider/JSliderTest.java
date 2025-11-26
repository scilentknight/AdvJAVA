package TestingJSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSliderTest extends JFrame {
    private JSlider diameterJSlider;
    private JSliderFrame myPanel;

    public JSliderTest() {
        super("Slider Demo");
        myPanel = new JSliderFrame();
        myPanel.setBackground(Color.YELLOW);
        // Correct JSlider: min 0, max 200, initial value 10
        diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
        diameterJSlider.setMajorTickSpacing(10);
        diameterJSlider.setPaintTicks(true);
        // Event Handler
        diameterJSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                myPanel.setDiameter(diameterJSlider.getValue());
            }
        });
        add(diameterJSlider, BorderLayout.SOUTH);
        add(myPanel, BorderLayout.CENTER);
    }

}
