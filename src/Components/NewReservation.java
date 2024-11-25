package Components;

import javax.swing.*;
import java.awt.*;

public class NewReservation extends JPanel {
    public NewReservation() {
        // Panel Settings
        setBackground(Color.decode("#044040"));
        setLayout(null); // Use absolute positioning

        // Title: Create a Reservation
        JLabel titleLabel = new JLabel("Create a Reservation");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(20, 20, 400, 40); // Increased width and height for readability
        add(titleLabel);

        // Guest Details Section
        JLabel guestDetailsLabel = new JLabel("Guest Details");
        guestDetailsLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        guestDetailsLabel.setForeground(Color.WHITE);
        guestDetailsLabel.setBounds(20, 70, 400, 30); // Aligned with the title
        add(guestDetailsLabel);

        // Define Guest Details Fields
        String[] guestFieldLabels = {"Guest Full Name:", "Email Address:", "Phone Number:"};
        JTextField[] guestFields = new JTextField[guestFieldLabels.length];

        int marginX = 40; // Left margin for labels
        int fieldX = 200; // X-coordinate for text fields
        int fieldWidth = 300; // Text field width
        int labelWidth = 150; // Label width
        int fieldHeight = 30; // Uniform field and label height
        int gap = 20; // Space between rows

        int guestFieldY = 110; // Starting Y position for guest details

        for (int i = 0; i < guestFieldLabels.length; i++) {
            JLabel lblGuestField = new JLabel(guestFieldLabels[i]);
            lblGuestField.setForeground(Color.WHITE);
            lblGuestField.setFont(new Font("Roboto", Font.PLAIN, 16));
            lblGuestField.setBounds(marginX, guestFieldY, labelWidth, fieldHeight);
            add(lblGuestField);

            JTextField txtGuestField = new JTextField();
            txtGuestField.setBounds(fieldX, guestFieldY, fieldWidth, fieldHeight);
            guestFields[i] = txtGuestField;
            add(txtGuestField);

            guestFieldY += fieldHeight + gap; // Increment Y position for next row
        }

        // Reservation Details Section
        JLabel lblReservationDetails = new JLabel("Reservation Details");
        lblReservationDetails.setFont(new Font("Roboto", Font.BOLD, 20));
        lblReservationDetails.setForeground(Color.WHITE);
        lblReservationDetails.setBounds(20, guestFieldY + gap, 400, 30);
        add(lblReservationDetails);

        String[] reservationFieldLabels = {
                "Room Number:",
                "Date of Arrival:",
                "Date of Departure:",
                "Number of Guests:"
        };
        JTextField[] reservationFields = new JTextField[reservationFieldLabels.length];

        int reservationFieldY = guestFieldY + gap + 40; // Start below the section title

        for (int i = 0; i < reservationFieldLabels.length; i++) {
            JLabel lblReservationField = new JLabel(reservationFieldLabels[i]);
            lblReservationField.setForeground(Color.WHITE);
            lblReservationField.setFont(new Font("Roboto", Font.PLAIN, 16));
            lblReservationField.setBounds(marginX, reservationFieldY, labelWidth, fieldHeight);
            add(lblReservationField);

            JTextField txtReservationField = new JTextField();
            txtReservationField.setBounds(fieldX, reservationFieldY, fieldWidth, fieldHeight);
            reservationFields[i] = txtReservationField;
            add(txtReservationField);

            reservationFieldY += fieldHeight + gap; // Increment Y position for next row
        }

        // Additional Services Section
        JLabel additionalServicesLabel = new JLabel("Additional Services:");
        additionalServicesLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        additionalServicesLabel.setForeground(Color.white);
        additionalServicesLabel.setBounds(20, reservationFieldY + gap, 400, 30); // Section title
        add(additionalServicesLabel);

// Service Options with Labels and Checkboxes
        String[] serviceOptions = {"Extra Cleaning:", "Breakfast Included:", "Early Check-in:"};
        JCheckBox[] serviceCheckboxes = new JCheckBox[serviceOptions.length];

        int serviceY = reservationFieldY + gap + 40; // Starting Y position for service options
        int checkboxWidth = 30; // Width for checkboxes
        int rowHeight = 30; // Height for each row

        for (int i = 0; i < serviceOptions.length; i++) {
            // Create and position the label
            JLabel serviceLabel = new JLabel(serviceOptions[i]);
            serviceLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
            serviceLabel.setForeground(Color.white);
            serviceLabel.setBounds(40, serviceY, labelWidth, rowHeight); // Label on the left
            add(serviceLabel);

            // Create and position the checkbox
            JCheckBox checkbox = new JCheckBox();
            checkbox.setBounds(260, serviceY, checkboxWidth, rowHeight); // Checkbox to the right of the label
            checkbox.setBackground(Color.decode("#044040")); // Match background color
            serviceCheckboxes[i] = checkbox;
            add(checkbox);

            serviceY += rowHeight + 10; // Move to the next row
        }

        // **Step 6: Calculate Cost and Payment Method**
        // Components Data Arrays
        String[] labelTexts = {"Calculate Cost:", "Payment Method:"};
        String[] buttonLabels = {"Calculate", "Confirm Payment", "Confirm Reservation", "Reset"};
        String[] paymentOptions = {"Cash", "Visa or Mastercard"};


        // Components Data Arrays
        JLabel[] labels = new JLabel[labelTexts.length];
        JTextField[] textFields = new JTextField[1]; // Only one text field for "Calculate Cost"
        JRadioButton[] paymentRadioButtons = new JRadioButton[paymentOptions.length];
        JButton[] buttons = new JButton[buttonLabels.length];
        ButtonGroup paymentGroup = new ButtonGroup();



    }
}