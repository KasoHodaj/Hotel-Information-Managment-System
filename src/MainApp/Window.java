package MainApp;

import Components.*;
import Utils.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JPanel contentPanel; // The dynamic content panel


    public Window() {
        //START Window()

        /** FRAME **/
        // Here, we set the frame's properties like title, size, location, etc.
        // We use methods provided by the JFrame class.
        setTitle("Pantheon Residence: Management & Administrative App");
        setSize(1400, 800);
        setLocationRelativeTo(null);  // This centers the window on the screen, so I can use absolute positioning
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This closes the application 'X'.

        // Main Panel with BorderLayout
        // Next I will create a main panel with a layout manager (BorderLayout). This layout manager will arrange our components within the window.
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(ThemeManager.getBackground()); // Use ThemeManager for background (LIGHT/DARK MODE).
        add(mainPanel);

        // Add NavigationBar
        // Here, we create a NavigationBar COMPONENT and pass a reference of this Window object to it
        NavigationBar navBar = new NavigationBar(this); // Pass the Window reference
        mainPanel.add(navBar, BorderLayout.WEST);

        // Dynamic Content Area
        // This creates the content panel where we will display different screens based on user selection.
        // Here I will use a CardLayout layout manager, which is suitable for switching between views, and keeps the code organized.
        contentPanel = new JPanel(new CardLayout()); // Use CardLayout for switching panels
        contentPanel.setBackground(ThemeManager.getBackground()); // Use ThemeManager for background (LIGHT/DARK MODE).
        mainPanel.add(contentPanel, BorderLayout.CENTER); // Add the content panel to the center of the BorderLayout: Right of the taskbar, occupying the rest of the screen.


        // Initially, I add the Dashboard screen to the content panel which will be the DEFAULT screen, and assign it the name "Home".
        contentPanel.add(new Dashboard(), "Home");

        setVisible(true);

        //END Window()
    }

    //----------
    public void switchPanel(String panelName) { // This method allows us to switch between different screens in the application.

        // Clear contentPanel and add the selected panel
        CardLayout layout = (CardLayout) contentPanel.getLayout();

        // Dynamically add panels based on the menu selection
        switch (panelName) {// Here, we use a switch statement to decide which panel to add based on the provided panel name.
            case "Home":
                contentPanel.add(new Dashboard(), "Home");
                break;
            case "New Reservation":
                contentPanel.add(new NewReservation(), "New Reservation");
                break;
            case "Reservations":
                contentPanel.add(new Reservations(), "Reservations");
                break;
            case "Residences":
                contentPanel.add(new Residences(), "Residences");
                break;
            case "Technical Support":
                contentPanel.add(new TechnicalSupport(), "Technical Support");
                break;
            case "Settings":
                contentPanel.add(new Settings(), "Settings");
                break;
            default: // If an unrecognized panel name is provided, display an error message, which will probably not happen since I didn't add an unLinked Navigation Panel
                contentPanel.add(new JLabel("Page Not Found"), "Error");
        }


        // After adding the panel, I use the CardLayout's `show` method to display the selected panel
        // and call `revalidate` and `repaint` methods to ensure the UI updates properly.
        layout.show(contentPanel, panelName);
        contentPanel.revalidate(); // The revalidate() method is used to inform the layout manager that a component’s layout or size needs to be recalculated.
        contentPanel.repaint(); // The repaint() method in Java Swing is used to request a visual update or redraw of a GUI component.
    }


    //----------


    public static void main(String[] args) {
        // Initialize the application
        new Window();

        System.out.println("ThemeManager.isDarkMode: " + ThemeManager.isDarkMode);
        System.out.println("Background: " + ThemeManager.getBackground());
        System.out.println("Foreground: " + ThemeManager.getForeground());
    }

    //----------


    /**
     * Applies the current theme to the application's UI. This includes updating
     * background and foreground colors for all components within the top-level container.
     */
    public void applyTheme() {
        // Set the background color for the top-level container based on the theme.
        getContentPane().setBackground(ThemeManager.getBackground());

        // Apply theme settings recursively to all child components.
        updateNestedComponents(getContentPane());

        // Trigger a UI refresh to ensure changes are visually applied across all components.
        SwingUtilities.updateComponentTreeUI(this);
    }

    //----------


    /**
     * Recursively updates theme-related properties (e.g., background and foreground colors)
     * for all components within the specified container. Designed to handle complex component trees.
     */
    private void updateNestedComponents(Container container) {
        // Iterate through all child components of the provided container.
        for (Component component : container.getComponents()) {
            // Handle JPanel: update both background and foreground colors.
            if (component instanceof JPanel) {
                component.setBackground(ThemeManager.getBackground());
                component.setForeground(ThemeManager.getForeground());
            }
            // Handle JButton: use specific button-related colors from the theme.
            else if (component instanceof JButton) {
                component.setBackground(ThemeManager.getButtonBackground());
                component.setForeground(ThemeManager.getButtonForeground());
            }
            // Handle JLabel: update only the foreground for text visibility.
            else if (component instanceof JLabel) {
                component.setForeground(ThemeManager.getForeground());
            }
            // Handle JRadioButton: apply background and foreground for consistency.
            else if (component instanceof JRadioButton) {
                component.setBackground(ThemeManager.getBackground());
                component.setForeground(ThemeManager.getForeground());
            }
            // If the component is a container, process its children recursively.
            if (component instanceof Container) {
                updateNestedComponents((Container) component);
            }
        }
    }


    //----------

}


