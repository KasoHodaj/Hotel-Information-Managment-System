package Components;

import Utils.ThemeManager;

import javax.swing.*;
import java.awt.*;

/**
 * The `Settings` class represents a settings panel where users can update their name and password (INCOMPLETE).
 */
public class Settings extends JPanel {
    public Settings(){
        //START Settings()

        // Panel Settings
        setBackground(ThemeManager.getBackground());
        setLayout(null); // Absolute positioning for manual layout control

        /** Header **/
        JLabel headerLabel = new JLabel("Settings");
        headerLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        headerLabel.setForeground(ThemeManager.getForeground()); // Set text color using ThemeManager
        headerLabel.setBounds(20, 20, 200, 30); // Positioning the header
        add(headerLabel);

        /** Change Name Section **/
        /** TODO: Add validation to ensure names have a minimum length and only valid characters. (28/11/2024)**/
        JLabel nameLabel = new JLabel("Change Name:");
        nameLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        nameLabel.setForeground(ThemeManager.getForeground());
        nameLabel.setBounds(20, 70, 200, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Roboto", Font.PLAIN, 16));
        nameField.setBounds(180, 70, 200, 30);
        add(nameField);

        JButton saveNameButton = new JButton("Save");
        saveNameButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        saveNameButton.setBackground(ThemeManager.getButtonBackground());
        saveNameButton.setForeground(ThemeManager.getButtonForeground());
        saveNameButton.setBounds(400, 70, 100, 30);

        // Action listener to handle saving the name
        saveNameButton.addActionListener(e -> saveName(nameField.getText()));
        add(saveNameButton);


        /** Change Password  Section**/
        /** TODO: Implement strong password validation (e.g., minimum length, special characters, etc.). (28/11/2024)**/
        /** TODO: Add password visibility toggle (show/hide password functionality), same for every LoginScreen, RegisterScreen and ForgotPasswordScreen. (28/11/2024)**/
        JLabel passwordLabel = new JLabel("Change Password:");
        passwordLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        passwordLabel.setForeground(ThemeManager.getForeground());
        passwordLabel.setBounds(20, 120, 200, 30);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Roboto", Font.PLAIN, 16));
        passwordField.setBounds(180, 120, 200, 30);
        add(passwordField);

        JButton savePasswordButton = new JButton("Save");
        savePasswordButton.setFont(new Font("Roboto", Font.PLAIN, 16));
        savePasswordButton.setBackground(ThemeManager.getButtonBackground());
        savePasswordButton.setForeground(ThemeManager.getButtonForeground());
        savePasswordButton.setBounds(400, 120, 100, 30);

        // Action listener to handle saving the password
        savePasswordButton.addActionListener(e -> savePassword(new String(passwordField.getPassword())));
        add(savePasswordButton);


        /** TODO: Update the screen dynamically when the settings are changed, e.g., change colors or other UI elements based on new preferences. (28/11/2024)**/
        //END Settings()
    }

    //--------------//--------------//--------------//--------------//--------------v
    /** TODO: Add a method to reset all settings to default values. **/
    private void saveName(String name) {
        /**
         * Displays a message dialog to indicate success or an error if the name is empty.
         *
         * @param name The name entered by the user.
         */
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Name updated to: " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //--------------//--------------//--------------//--------------//--------------


    private void savePassword(String password) {
        /**
         * Displays a message dialog to indicate success or an error if the password is empty.
         *
         * @param password The password entered by the user.
         */
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //--------------//--------------//--------------//--------------//--------------


}
