package Components;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    public Dashboard() {
        // Panel Settings
        setBackground(Color.decode("#044040"));
        setLayout(null); // Use absolute positioning

        // Title: Overview
        JLabel overviewLabel = new JLabel("Overview");
        overviewLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        overviewLabel.setForeground(Color.WHITE);
        overviewLabel.setBounds(20, 20, 150, 30);
        add(overviewLabel);

        // Desired width and height for the icons
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
            System.err.println("Error: One or more icons could not be loaded.");
            e.printStackTrace();
        }

        // Give data to the cards!
        String[] values = {"25", "13", "5", "62"};
        String[] titles = {"Total Bookings", "Completed Bookings", "Canceled Bookings", "Total Guests"};
        String description = "110% more than last month"; // Same description for convinience

        int positionX = 20; // Card 1 starting position
        for(int i = 0; i < values.length; i++){
            JPanel card = createCard(values[i], titles[i], description, icons[i], positionX, 80);
            add(card);
            positionX += 280;
        }


        // Add a simple booking trends chart
        JLabel trendsLabel = new JLabel("Booking Trends");
        trendsLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        trendsLabel.setForeground(Color.WHITE);
        trendsLabel.setBounds(20, 300, 200, 30);
        add(trendsLabel);


        try {
            // Scale the image to match the setBounds dimensions (500x375)
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Assets/chart.png"))
                    .getImage().getScaledInstance(700, 450, Image.SCALE_SMOOTH)); // Match the JLabel size

            // Add the chart as a JLabel
            JLabel chartImage = new JLabel(icon);
            chartImage.setBounds(200, 300, 700, 450); // Position and size match
            add(chartImage);
        } catch (NullPointerException e) {
            System.err.println("Error: Chart Image not found");
            e.printStackTrace();
        }

    }




    // CONSTRUCTOR FOR CARDS
    private JPanel createCard(String value, String title, String description, ImageIcon indicatorIcon, int x, int y){
        JPanel card = new JPanel();
        card.setLayout(null); // Manual positioning inside the card
        card.setBackground(Color.decode("#FEFBFB")); // White background for the card
        card.setBounds(x, y, 260, 160); // Position and size of the card
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Optional border

        // Value Label
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Roboto", Font.BOLD, 36)); // Large bold font for value
        valueLabel.setForeground(Color.BLACK);
        valueLabel.setBounds(20, 20, 100, 40); // Position it inside the card
        card.add(valueLabel);

        // Title Label
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Roboto", Font.PLAIN, 18)); // Medium font for the title
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setBounds(20, 60, 200, 20); // Position it below the value
        card.add(titleLabel);

        // Description Label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 14)); // Small font for the description
        descriptionLabel.setForeground(Color.GRAY);
        descriptionLabel.setBounds(20, 100, 280, 20); // Position it further down
        card.add(descriptionLabel);

        // Icon Label
        JLabel indicatorLabel = new JLabel(indicatorIcon);
        indicatorLabel.setBounds(200, 20, 50, 50); // Position in the top-right corner
        card.add(indicatorLabel);

        return card;
    }
}
