package Components;

import Utils.ThemeManager;

import javax.swing.*;
import java.awt.*;
/**
 * The `Dashboard` class represents a summary panel that displays key metrics such as bookings, guests, and trends.
 * It features information cards and a booking trends chart (Image: Design by me in canva).
 */

public class Dashboard extends JPanel {
    /**
     * Constructor to initialize the `Dashboard` panel.
     */
    public Dashboard() {
        //START Dashboard()

        // TODO: Replace static chart(image) with dynamic chart rendering or real-time graph integration. (25/11/2024) **/

        // Panel Settings
        setBackground(ThemeManager.getBackground());
        setLayout(null); // Use absolute positioning for layout control

        /** Title: Overview **/
        JLabel overviewLabel = new JLabel("Overview");
        overviewLabel.setFont(new Font("Roboto", Font.BOLD, 28));
        overviewLabel.setForeground(ThemeManager.getForeground());
        overviewLabel.setBounds(20, 20, 150, 30);
        add(overviewLabel);

        /** Metric Cards Section **/
        int iconWidth = 40;
        int iconHeight = 40;

        // Array to hold icons
        ImageIcon[] icons = new ImageIcon[4];

        try {
            // Load and scale icons
            icons[0] = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/all.png"))
                    .getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
            icons[1] = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/checked.png"))
                    .getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
            icons[2] = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/cancel.png"))
                    .getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
            icons[3] = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/guests.png"))
                    .getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
        } catch (NullPointerException e) {
            // Handle errors by displaying an error message
            System.err.println("Error: One or more icons could not be loaded.");
            e.printStackTrace();
        }

        // Give data to the cards!
        String[] values = {"25", "13", "5", "62"};
        String[] titles = {"Total Bookings", "Completed Bookings", "Canceled Bookings", "Total Guests"};
        String description = "110% more than last month"; // Same description for convinience

        // Generate metric cards dynamically
        int positionX = 20; // Card 1 starting position
        for(int i = 0; i < values.length; i++){
            JPanel card = createCard(values[i], titles[i], description, icons[i], positionX, 80);
            add(card);
            positionX += 280; // Increment position for the next card
        }


        /** Booking Trends Chart **/
        JLabel trendsLabel = new JLabel("Booking Trends");
        trendsLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        trendsLabel.setForeground(ThemeManager.getForeground());
        trendsLabel.setBounds(20, 300, 200, 30);
        add(trendsLabel);


        try {
            // Load and scale the chart image
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/chart.png"))
                    .getImage().getScaledInstance(700, 450, Image.SCALE_SMOOTH)); // Match the JLabel size

            // Add the chart as a JLabel
            JLabel chartImage = new JLabel(icon);
            chartImage.setBounds(200, 300, 700, 450); // Position and size
            add(chartImage);
        } catch (NullPointerException e) {
            // Handle errors by displaying an error message
            System.err.println("Error: Chart Image not found");
            e.printStackTrace();
        }

        //END Dashboard()
    }

    //-------------//-------------//-------------//-------------//-------------//-------------//-------------


    // CONSTRUCTOR FOR CARDS
    private JPanel createCard(String value, String title, String description, ImageIcon indicatorIcon, int x, int y){
        /**
         * Creates a JPanel styled as a card with a value, title, description, and an optional icon.
         *
         * @param value        The primary value to be displayed prominently on the card (e.g., stats, numbers).
         * @param title        The title or heading for the card, giving context to the value.
         * @param description  A short description providing additional details about the card's purpose.
         * @param indicatorIcon An optional ImageIcon displayed on the card, typically used as an indicator or decoration.
         * @param x            The x-coordinate of the card's position on the parent container.
         * @param y            The y-coordinate of the card's position on the parent container.
         * @return             A styled JPanel representing the card.
         */

        // Initialize the card panel with manual positioning (null layout)
        JPanel card = new JPanel();
        card.setLayout(null); // Manual positioning inside the card
        card.setBackground(ThemeManager.getBackground()); // White background for the card

        // Set the position and size of the card
        card.setBounds(x, y, 260, 160); // Position and size of the card
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Optional border

        // Add the value label
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Roboto", Font.BOLD, 36)); // Large bold font for value
        valueLabel.setForeground(ThemeManager.getForeground());
        valueLabel.setBounds(20, 20, 100, 40); // Position it inside the card
        card.add(valueLabel);

        // Title label
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Roboto", Font.PLAIN, 18)); // Medium font for the title
        titleLabel.setForeground(ThemeManager.getForeground());
        titleLabel.setBounds(20, 60, 200, 20); // Position it below the value
        card.add(titleLabel);

        // Description Label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 14)); // Small font for the description
        descriptionLabel.setForeground(ThemeManager.getForeground());
        descriptionLabel.setBounds(20, 100, 280, 20); // Position it further down
        card.add(descriptionLabel);

        // Icon Label
        JLabel indicatorLabel = new JLabel(indicatorIcon);
        indicatorLabel.setBounds(200, 20, 50, 50); // Position in the top-right corner
        card.add(indicatorLabel);

        // Return the fully styled card
        return card;
    }

    //-------------//-------------//-------------//-------------//-------------//-------------//-------------
}
