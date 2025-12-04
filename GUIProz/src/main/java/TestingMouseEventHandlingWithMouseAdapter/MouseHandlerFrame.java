package TestingMouseEventHandlingWithMouseAdapter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MouseHandlerFrame extends JFrame {
    private JPanel mousePanel;
    private JLabel statusBar;

    public MouseHandlerFrame() {
        super("Mouse Adapter Example");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Mouse outside JPanel");
        add(statusBar, BorderLayout.SOUTH);

        // Mouse events using MouseAdapter
        mousePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                statusBar.setText(String.format("Clicked at [%d,%d]", event.getX(), event.getY()));
            }

            @Override
            public void mousePressed(MouseEvent event) {
                statusBar.setText(String.format("Pressed at [%d,%d]", event.getX(), event.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                statusBar.setText(String.format("Released at [%d,%d]", event.getX(), event.getY()));
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                statusBar.setText(String.format("Entered at [%d,%d]", event.getX(), event.getY()));
                mousePanel.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent event) {
                statusBar.setText("Mouse Exited from JPanel");
                mousePanel.setBackground(Color.WHITE);
            }
        });

        // Mouse motion events using MouseMotionAdapter (currently disabled)
        /*
        mousePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                statusBar.setText(String.format("Dragged at [%d,%d]", event.getX(), event.getY()));
                mousePanel.setBackground(Color.BLUE);
            }

            @Override
            public void mouseMoved(MouseEvent event) {
                statusBar.setText(String.format("Moved at [%d,%d]", event.getX(), event.getY()));
            }
        });
        */
    }
}
