package TestingFrame;

import javax.swing.*;

public class SimpleFrameTest {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Simple Frame Test");

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create Menus
        JMenu home = new JMenu("Home");
        JMenu about = new JMenu("About");
        JMenu services = new JMenu("Services");

        // Add items to "Home"
        JMenuItem dashboard = new JMenuItem("Dashboard");
        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem exit = new JMenuItem("Exit");
        home.add(dashboard);
        home.add(settings);
        home.addSeparator();
        home.add(exit);

        // Add items to "About"
        JMenuItem aboutApp = new JMenuItem("About App");
        JMenuItem aboutDev = new JMenuItem("About Developer");
        about.add(aboutApp);
        about.add(aboutDev);

        // Add items to "Services"
        JMenuItem service1 = new JMenuItem("Service 1");
        JMenuItem service2 = new JMenuItem("Service 2");
        services.add(service1);
        services.add(service2);

        // Add all menus to menu bar
        menuBar.add(home);
        menuBar.add(about);
        menuBar.add(services);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);

        // Add action to "Exit"
        exit.addActionListener(e -> System.exit(0));

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
