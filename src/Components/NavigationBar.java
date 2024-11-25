package Components;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import MainApp.Window;

public class NavigationBar extends JPanel {

    public NavigationBar(Window mainWindow) {

        // Panel Settings
        setBackground(Color.decode("#FEFBFB"));
        setLayout(null); // Use absolute positioning
        setPreferredSize(new Dimension(250, 800));

        // Add Logo
        LogoComponent logo = new LogoComponent(); // Custom logo component
        logo.setBounds(20, 20, 200, 200);
        add(logo);

        // Menu Buttons with Icons
        Map<String, String> menuItems = new LinkedHashMap<>();
        menuItems.put("Home", "/Assets/home.png");
        menuItems.put("New Reservation", "/Assets/add-post.png");
        menuItems.put("Reservations", "/Assets/clipboard.png");
        menuItems.put("Availability", "/Assets/booking.png");
        menuItems.put("Technical Support", "/Assets/customer-support.png");

        int positionY = 240; // Starting position for buttons

        for (Map.Entry<String, String> entry : menuItems.entrySet()) {
            String menuItem = entry.getKey();
            String iconPath = entry.getValue();


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
            button.setBackground(Color.decode("#FEFBFB")); // Dark green background
            button.setForeground(Color.black); // White text
            button.setFocusPainted(false);
            button.setIconTextGap(10);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.addActionListener(e -> mainWindow.switchPanel(menuItem));
            add(button);
            positionY += 45; // Increment position for next button
        }

        //Profile Image
        ImageIcon userIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/profile.png"))
                .getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)
        );
        JLabel userLabel = new JLabel(userIcon);
        userLabel.setBounds(20,positionY + 110,50,50);
        add(userLabel);

        JLabel userName = new JLabel("Kaso Hodaj");
        userName.setBounds(100,positionY + 115, 100,20);
        userName.setFont(new Font("Roboto", Font.PLAIN, 18));
        userName.setForeground(Color.black);
        add(userName);

        JLabel userRole = new JLabel("Project Owner");
        userRole.setBounds(100,positionY + 135,100,20);
        userRole.setFont(new Font("Roboto", Font.PLAIN,16));
        userRole.setForeground(Color.decode("#707070"));
        add(userRole);

        /** Theme Switcher **/
        // Light Theme
        JRadioButton lightMode = new JRadioButton("Light");
        lightMode.setBounds(20,positionY + 190, 70,20);
        lightMode.setFont(new Font("Roboto", Font.PLAIN,16));
        lightMode.setForeground(Color.black);
        lightMode.setBackground(Color.white);
        add(lightMode);

        JRadioButton darkMode = new JRadioButton("Dark");
        darkMode.setBounds(100,positionY + 190,70,20);
        darkMode.setFont(new Font("Roboto", Font.PLAIN,16));
        darkMode.setForeground(Color.black);
        darkMode.setBackground(Color.white);
        add(darkMode);

        ButtonGroup themeSwitchers = new ButtonGroup();
        themeSwitchers.add(lightMode);
        themeSwitchers.add(darkMode);


        // Settings Button
        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(5, 680, 100, 30);
        settingsButton.setForeground(Color.black);
        settingsButton.setBackground(Color.white);
        settingsButton.setBorderPainted(false);
        settingsButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(settingsButton);

        // Log Out Button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(85, 680, 100, 30); // Adjust offsetX manually
        logoutButton.setForeground(Color.black);
        logoutButton.setBackground(Color.white);
        logoutButton.setBorderPainted(false);
        logoutButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(logoutButton);

        logoutButton.addActionListener(e -> {
            // DISPLAY A CONFIRMATION MESSAGE
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to log out?",
                    "Log Out",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                //YES -> LOGGING OUT
                System.out.println("Logging out...");
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                if(parentFrame != null){ // SwingUtilities.getWindowAncestor(this) to access the parent frame and dispose() it when logging out.
                    parentFrame.dispose();
                }
                new LoginApp.LoginScreen().setVisible(true); // DISPLAY LOGIN FRAME

            }


        });

    }




}
