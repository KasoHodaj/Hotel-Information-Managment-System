package MainApp;

import Components.Dashboard;
import Components.NavigationBar;
import Components.NewReservation;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JPanel contentPanel; // The dynamic content panel

    public Window() {
        // Frame Settings
        setTitle("Pantheon Residence: Management & Administrative App");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#044040"));
        add(mainPanel);

        // Add NavigationBar
        NavigationBar navBar = new NavigationBar(this);
        mainPanel.add(navBar, BorderLayout.WEST);


        // Dynamic Content Area
        contentPanel = new JPanel(new CardLayout()); // Use CardLayout for switching panels
        contentPanel.setBackground(Color.white);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add Initial Page (Dashboard) to contentPanel
        contentPanel.add(new Dashboard(), "Home");

        setVisible(true);
    }

    public void switchPanel(String panelName) {
        // Clear contentPanel and add the selected panel
        CardLayout layout = (CardLayout) contentPanel.getLayout();

        // Dynamically add panels based on the menu selection
        switch (panelName) {
            case "Home":
                contentPanel.add(new Dashboard(), "Home");
                break;
            case "New Reservation":
                contentPanel.add(new NewReservation(), "New Reservation"); // Replace with your actual panel
                break;
            case "Reservations":
                contentPanel.add(new JPanel(), "Reservations"); // Replace with your actual panel
                break;
            case "Availability":
                contentPanel.add(new JPanel(), "Availability"); // Replace with your actual panel
                break;
            case "Technical Support":
                contentPanel.add(new JPanel(), "Technical Support"); // Replace with your actual panel
                break;
            default:
                contentPanel.add(new JLabel("Page Not Found"), "Error");
        }

        // Show the selected panel
        layout.show(contentPanel, panelName);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        new Window();
    }
}
