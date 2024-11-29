package Utils;

import java.awt.*;

public class ThemeManager {
    public static boolean isDarkMode = false; // Boolean flag to track the current theme mode: dark or light. // Default to light mode.

    // Define light mode colors
    public static final Color LIGHT_BACKGROUND = Color.decode("#044040"); // Light theme background color, color is ~green.
    public static final Color LIGHT_FOREGROUND = Color.white; // Light theme text color.
    public static final Color LIGHT_BUTTON_BACKGROUND = Color.decode("#4CAF50"); // Button background for light mode, color is light green.
    public static final Color LIGHT_BUTTON_FOREGROUND = Color.white;  // Button text color for light mode


    // Define dark mode colors
    public static final Color DARK_BACKGROUND = Color.decode("#121212"); // Dark theme background color
    public static final Color DARK_FOREGROUND = Color.WHITE; // Dark theme text color
    public static final Color DARK_BUTTON_BACKGROUND = Color.decode("#1E88E5"); // Button background for dark mode
    public static final Color DARK_BUTTON_FOREGROUND = Color.WHITE; // Button text color for dark mode


    /**
     * Dynamically retrieves the appropriate background color based on the current theme.
     *
     * @return The background color for the current theme.
     *
     *
     * From Here on I will use a conditional (ternary) operator to choose between Dark or Light background
     */
    public static Color getBackground() {
        return isDarkMode ? DARK_BACKGROUND : LIGHT_BACKGROUND;
    }

    public static Color getForeground() {
        return isDarkMode ? DARK_FOREGROUND : LIGHT_FOREGROUND;
    }

    public static Color getButtonBackground() {
        return isDarkMode ? DARK_BUTTON_BACKGROUND : LIGHT_BUTTON_BACKGROUND;
    }

    public static Color getButtonForeground() {
        return isDarkMode ? DARK_BUTTON_FOREGROUND : LIGHT_BUTTON_FOREGROUND;
    }
}

