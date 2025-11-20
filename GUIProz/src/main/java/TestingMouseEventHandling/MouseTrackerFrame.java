package TestingMouseEventHandling;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseTrackerFrame extends JFrame {
    private JPanel mousePanel;
    private JLabel statusBar;

    public MouseTrackerFrame()
    {
        super("Demonstrating Mouse Events");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Mouse outside JPanel");
        add(statusBar, BorderLayout.SOUTH);

        // create and register listner for mouse and mouse motion events
        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    } // constructor ends

    private class MouseHandler implements MouseListener, MouseMotionListener {
        //MouseListner event handlers
        // handle event when mouse released immediately after press
        public void mouseClicked(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d,%d]", event.getX(), event.getY()));
        } // end method mouse clicked

        // handle event when mouse pressed
        public void mousePressed(MouseEvent event) {
            statusBar.setText(String.format("Pressed at [%d,%d]", event.getX(), event.getY()));
        }

        public void mouseReleased(MouseEvent event) {
            statusBar.setText(String.format("Mouse released at [%d,%d]", event.getX(), event.getY()));
        }

        public void mouseEntered(MouseEvent event) {
            statusBar.setText(String.format("Mouse Entered at [%d,%d]", event.getX(), event.getY()));
            mousePanel.setBackground(Color.GREEN);
        }

        public void mouseExited(MouseEvent event) {
            statusBar.setText("Mouse outside JPanel");
            mousePanel.setBackground(Color.WHITE);
        }

        public void mouseDragged(MouseEvent event) {
            statusBar.setText(String.format("Mouse Dragged at [%d,%d]", event.getX(), event.getY()));
            mousePanel.setBackground(Color.BLUE);
        }

        public void mouseMoved(MouseEvent event) {
            statusBar.setText(String.format("Moved at [%d,%d]", event.getX(), event.getY()));
        }
    }
}
