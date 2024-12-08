package Components;

import Utils.ThemeManager;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import MainApp.Window;
import javax.swing.border.MatteBorder;
/**
 * The `NavigationBar` class represents the sidebar navigation menu for the application.
 * It includes menu buttons, profile information, a theme switcher, and a logout button.
 */
public class NavigationBar extends JPanel {
    /**
     * Constructor to initialize the `NavigationBar`.
     */


    public NavigationBar(Window mainWindow) {
        //START NavigationBar()

        // Panel Settings
        setBackground(ThemeManager.getBackground());
        setLayout(null); // Use absolute positioning
        setPreferredSize(new Dimension(250, 800)); // Fixed width for navigation
        setBorder(new MatteBorder(0, 0, 0, 1, ThemeManager.getForeground()));

        /** Add Logo **/
        LogoComponent logo = new LogoComponent(); // Custom logo component
        logo.setBounds(20, 20, 200, 200); // Position logo at the top
        add(logo);

        /** Menu Buttons **/
        // Map of menu item names and their corresponding icon paths
        Map<String, String> menuItems = new LinkedHashMap<>();
        menuItems.put("Home", "/Assets/home.png");
        menuItems.put("New Reservation", "/Assets/add-post.png");
        menuItems.put("Reservations", "/Assets/clipboard.png");
        menuItems.put("Residences", "/Assets/booking.png");
        menuItems.put("Technical Support", "/Assets/customer-support.png");
        menuItems.put("Settings", "/Assets/settings.png");

        int positionY = 230; // Starting position for buttons

        for (Map.Entry<String, String> entry : menuItems.entrySet()) {
            String menuItem = entry.getKey(); // Menu item label
            String iconPath = entry.getValue(); // Path to icon file

            ImageIcon icon = null; // Create an icon for the button
            try {
                icon = new ImageIcon(new ImageIcon(getClass().getResource(iconPath)) // Load and scale icons dynamically
                        .getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)); // Scale Icon Size
            } catch (NullPointerException e) {
                System.err.println("Error: Icon not found for " + menuItem + " at path " + iconPath);
                continue; // Skip this button if the icon is not found
            }

            JButton button = new JButton(menuItem, icon);
            button.setBounds(20, positionY, 200, 30);
            button.setFont(new Font("Roboto", Font.PLAIN, 16));
            button.setBackground(ThemeManager.getButtonBackground()); // Background matches theme
            button.setForeground(ThemeManager.getButtonForeground()); // Text color matches theme
            button.setFocusPainted(false);
            button.setIconTextGap(10); // Spacing between text and icon
            button.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.addActionListener(e -> mainWindow.switchPanel(menuItem)); // Switch panel on click
            add(button);
            positionY += 45; // Increment position for next button
        }

        /** Profile Section **/
        ImageIcon userIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/profile.png"))
                .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)
        );
        JLabel userLabel = new JLabel(userIcon);
        userLabel.setBounds(20, positionY + 110, 50, 50);
        add(userLabel);

        JLabel userName = new JLabel("Kaso Hodaj");
        userName.setBounds(100, positionY + 115, 100, 20);
        userName.setFont(new Font("Roboto", Font.PLAIN, 18));
        userName.setForeground(ThemeManager.getForeground());
        add(userName);

        JLabel userRole = new JLabel("Project Owner");
        userRole.setBounds(100, positionY + 135, 120, 20);
        userRole.setFont(new Font("Roboto", Font.ITALIC, 16));
        userRole.setForeground(ThemeManager.getForeground());
        add(userRole);

        /** Theme Switcher **/
        JRadioButton lightMode = new JRadioButton("Light");
        lightMode.setBounds(20, positionY + 190, 70, 20);
        lightMode.setFont(new Font("Roboto", Font.PLAIN, 16));
        lightMode.setForeground(ThemeManager.getForeground());
        lightMode.setBackground(ThemeManager.getBackground());
        add(lightMode);

        /** Theme Switcher **/
        JRadioButton darkMode = new JRadioButton("Dark");
        darkMode.setBounds(100, positionY + 190, 70, 20);
        darkMode.setFont(new Font("Roboto", Font.PLAIN, 16));
        darkMode.setForeground(ThemeManager.getForeground());
        darkMode.setBackground(ThemeManager.getBackground());
        add(darkMode);

        ButtonGroup themeSwitchers = new ButtonGroup();
        themeSwitchers.add(lightMode);
        themeSwitchers.add(darkMode);

        // Set current theme selection
        if (ThemeManager.isDarkMode) {
            darkMode.setSelected(true);
        } else {
            lightMode.setSelected(true);
        }

        // Add action listeners for theme switching
        lightMode.addActionListener(e -> switchTheme(false, mainWindow));
        darkMode.addActionListener(e -> switchTheme(true, mainWindow));



        /** Log Out Button **/
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(20, 720, 100, 30);
        logoutButton.setForeground(ThemeManager.getButtonForeground());
        logoutButton.setBackground(ThemeManager.getButtonBackground());
        logoutButton.setBorderPainted(false);
        logoutButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(logoutButton);

        logoutButton.addActionListener(e -> {
            /**
             * ActionListener for the Logout button to handle the logout process.
             * - Confirms the user's intent to log out through a dialog.
             * - Closes the current application window if confirmed.
             * - Redirects the user to the login screen.
             *
             * @param e The ActionEvent triggered when the logout button is clicked.
             */

            // Display a confirmation dialog to the user before logging out
            int confirm = JOptionPane.showConfirmDialog(
                    null, // Parent component for the dialog
                    "Are you sure you want to log out?", // Confirmation message
                    "Log Out", // Title of the dialog
                    JOptionPane.YES_NO_OPTION); // Options for the dialog (Yes/No)

            // If the user confirms (clicks "Yes"), proceed with logout
            if (confirm == JOptionPane.YES_OPTION) {
                System.out.println("Logging out...");
                // Get the parent frame of the current component
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

                // Close the main application window if it exists
                if (parentFrame != null) {
                    parentFrame.dispose();
                }

                // Open the login screen for the user to log in again
                new LoginApp.LoginScreen().setVisible(true);
            }
        });
        //END NavigationBar()
    }

    private void switchTheme(boolean darkMode, Window mainWindow) {
        /**
         * Switches the theme between light and dark modes.
         */
        ThemeManager.isDarkMode = darkMode; // Update global theme state
        mainWindow.applyTheme(); // Apply theme to the entire window
    }


}