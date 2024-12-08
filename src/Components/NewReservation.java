package Components;

import Models.Reservation;
import Services.ReservationService;
import Storage.ReservationStorage;
import Utils.ThemeManager;

import javax.swing.*;
import java.awt.*;
/**
 * The `NewReservation` class allows users to create a new reservation, calculate costs, and confirm payment details.
 * It features sections for guest details, reservation details, additional services, and payment methods.
 */
public class NewReservation extends JPanel {

    // Fields for Guest Details, Reservation Details, Additional Services
    private JTextField[] guestFields; // Array of text fields for inputting guest details such as name, contact information, etc.
    private JTextField[] reservationFields; // Array of text fields for inputting reservation details such as check-in date, check-out date, and room type.
    private JCheckBox[] serviceCheckboxes; // Array of checkboxes for selecting additional services like breakfast, extra cleaning, or early check-in.
    private JButton saveReservationButton; // Button to save the entered reservation data to the system.


    /**
     * Constructor to initialize the `NewReservation` panel.
     */
    public NewReservation() {
        //START NewReservation()

        /** TODO: For Date Fields add date pickers. (25/11/2024)**/
        /** TODO: Add additional validations for special characters in fields like names and email. (25/11/2024)**/
        /** TODO: Add tooltips or placeholders for fields to improve usability. (29/11/2024)**/
        /** TODO: Add functionality to calculate discounts based on reservation duration or number of guests. (29/11/2024)**/
        /** TODO: Add validation for payment details (e.g., check valid card number format). (29/11/2024)**/
        /** TODO: Create a methods to shorten the code in NewReservation class (e.g. labels fields, checkboxes, payments and reservation sections). (29/11/2024)**/

        // Panel Settings
        setBackground(ThemeManager.getBackground());
        setLayout(null); // Use absolute positioning

        /** Title: Create a Reservation **/
        JLabel titleLabel = new JLabel("Create a Reservation");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 28));
        titleLabel.setForeground(ThemeManager.getForeground());
        titleLabel.setBounds(20, 20, 400, 40); // Increased width and height for readability
        add(titleLabel);

        // Initialize Arrays
        guestFields = new JTextField[3];
        reservationFields = new JTextField[4];
        serviceCheckboxes = new JCheckBox[3];

        /** Guest Details Section **/
        JLabel guestDetailsLabel = new JLabel("Guest Details");
        guestDetailsLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        guestDetailsLabel.setForeground(Color.WHITE);
        guestDetailsLabel.setBounds(20, 70, 400, 30); // Aligned with the title
        add(guestDetailsLabel);

        // Guest Details Fields
        String[] guestFieldLabels = {"Guest Full Name:", "Email Address:", "Phone Number:"};


        int marginX = 40; // Left margin for labels
        int fieldX = 200; // X-coordinate for text fields
        int fieldWidth = 300; // Text field width
        int labelWidth = 150; // Label width
        int height = 30; // Uniform field and label height
        int gap = 20; // Space between rows

        int guestFieldY = 110; // Starting Y position for guest details

        for (int i = 0; i < guestFieldLabels.length; i++) {
            JLabel lblGuestField = new JLabel(guestFieldLabels[i]);
            lblGuestField.setForeground(Color.WHITE);
            lblGuestField.setFont(new Font("Roboto", Font.PLAIN, 16));
            lblGuestField.setBounds(marginX, guestFieldY, labelWidth, height);
            lblGuestField.requestFocus();
            add(lblGuestField);

            JTextField txtGuestField = new JTextField();
            txtGuestField.setBounds(fieldX, guestFieldY, fieldWidth, height);
            guestFields[i] = txtGuestField;
            add(txtGuestField);

            guestFieldY += height + gap; // Increment Y position for next row
        }

        /** Reservation Details Section **/
        JLabel lblReservationDetails = new JLabel("Reservation Details");
        lblReservationDetails.setFont(new Font("Roboto", Font.BOLD, 20));
        lblReservationDetails.setForeground(Color.WHITE);
        lblReservationDetails.setBounds(20, guestFieldY + gap, 400, 30);
        add(lblReservationDetails);

        // Labels for Reservation Details
        String[] reservationFieldLabels = {"Room Number:","Date of Arrival:","Date of Departure:","Number of Guests:"};


        int reservationFieldY = guestFieldY + gap + 40; // Start below the section title

        for (int i = 0; i < reservationFieldLabels.length; i++) {
            // Loop through the reservationFieldLabels array to dynamically create labels and text fields
            // for each reservation detail, and position them within the form.

            // Create and configure a label for the current reservation field
            JLabel lblReservationField = new JLabel(reservationFieldLabels[i]);
            lblReservationField.setForeground(Color.WHITE);
            // Define Labels for Reservation DetailsblReservationField.setFont(new Font("Roboto", Font.PLAIN, 16));
            lblReservationField.setBounds(marginX, reservationFieldY, labelWidth, height);
            add(lblReservationField);

            // Create and configure a text field for user input corresponding to the current label
            JTextField txtReservationField = new JTextField();
            txtReservationField.setBounds(fieldX, reservationFieldY, fieldWidth, height);
            reservationFields[i] = txtReservationField;
            add(txtReservationField);

            // Increment the Y position for the next row of labels and text fields
            reservationFieldY += height + gap; // Increment Y position for next row
        }

        /** Additional Services Section **/
        JLabel additionalServicesLabel = new JLabel("Additional Services");
        additionalServicesLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        additionalServicesLabel.setForeground(Color.white);
        additionalServicesLabel.setBounds(20, reservationFieldY + gap, 400, 30); // Section title
        add(additionalServicesLabel);

        // Service Options with Labels and Checkboxes
        String[] serviceOptions = {"Extra Cleaning:", "Breakfast Included:", "Early Check-in:"};

        int serviceY = reservationFieldY + gap + 40; // Starting Y position for service options
        int checkboxWidth = 30; // Width for checkboxes
        int rowHeight = 30; // height for each row

        for (int i = 0; i < serviceOptions.length; i++) {
            // Loop through the serviceOptions array to dynamically create labels and checkboxes
            // for each additional service, positioning them within the form layout.


            // Create and configure a label for the current service option
            JLabel serviceLabel = new JLabel(serviceOptions[i]);
            serviceLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
            serviceLabel.setForeground(Color.white);
            serviceLabel.setBounds(40, serviceY, labelWidth, rowHeight); // Label on the left
            add(serviceLabel);

            // Create and configure a checkbox for the current service option
            JCheckBox checkbox = new JCheckBox();
            checkbox.setBounds(260, serviceY, 20, 20); // Checkbox to the right of the label
            checkbox.setBackground(ThemeManager.getBackground()); // Match background color
            serviceCheckboxes[i] = checkbox;
            add(checkbox);

            // Increment Y position for the next row of label and checkbox
            serviceY += rowHeight + 10; // Move to the next row
        }

        JButton confirmDetails = new JButton("Validate & Save");
        confirmDetails.setBounds(330,serviceY , labelWidth + 20, height);
        confirmDetails.setBackground(ThemeManager.getButtonBackground());
        confirmDetails.setForeground(ThemeManager.getButtonForeground());
        confirmDetails.setFont(new Font("Roboto",Font.PLAIN,18));
        add(confirmDetails);


        // Add an ActionListener to the confirmDetails button to handle input validation and enable the reservation confirmation process.
        confirmDetails.addActionListener(e -> {
            try {
                // Perform validation of user inputs
                if (!validateInputs()) {
                    return; // Stop processing if validation fails
                }

                // If validation is successful, show a success message to the user
                JOptionPane.showMessageDialog(this, "All inputs are valid! You can now save the reservation.", "Validation Success", JOptionPane.INFORMATION_MESSAGE);

                // Enable the "Confirm Reservation" button to allow saving the reservation
                saveReservationButton.setEnabled(true);
            } catch (Exception exception) {
                // Handle errors by displaying an error message
                JOptionPane.showMessageDialog(this, "Validation Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });



        int labelX = 610, labelY = 110;
        int textFieldX = 800, textFieldY = 110;

        /** Cost Calculation Button and Field **/
        JButton calculateButton = new JButton("Calculate Cost:");
        calculateButton.setFont(new Font("Roboto", Font.PLAIN, 18));
        calculateButton.setBounds(labelX, labelY , labelWidth + 10, height);
        calculateButton.setBackground(ThemeManager.getButtonBackground());
        calculateButton.setForeground(ThemeManager.getButtonForeground());
        add(calculateButton);

        // Text Field for cost input
        JTextField calculateCostField = new JTextField();
        calculateCostField.setBounds(textFieldX, textFieldY, fieldWidth, height);
        add(calculateCostField);

        //------------------
        calculateButton.addActionListener(e ->{
            /** ActionListener for the calculateButton to compute the reservation cost based on user inputs. */

            try {
                // Gather input from form fields
                String guestName = guestFields[0].getText().trim();
                String email = guestFields[1].getText().trim();
                String phone = guestFields[2].getText().trim();
                String roomNumber = reservationFields[0].getText().trim();
                String arrivalDate = reservationFields[1].getText().trim();
                String departureDate = reservationFields[2].getText().trim();
                int numberOfGuests = Integer.parseInt(reservationFields[3].getText().trim());

                boolean extraCleaning = serviceCheckboxes[0].isSelected();
                boolean breakfastIncluded = serviceCheckboxes[1].isSelected();
                boolean earlyCheckIn = serviceCheckboxes[2].isSelected();

                /**
                 * ActionListener for the calculateButton to compute the reservation cost based on user inputs.
                 *
                 * @param guestName           Full name of the guest.
                 * @param email               Guest's email address.
                 * @param phone               Guest's phone number.
                 * @param roomNumber          Room number for the reservation.
                 * @param arrivalDate         Check-in date in the format "dd/MM/yyyy".
                 * @param departureDate       Check-out date in the format "dd/MM/yyyy".
                 * @param numberOfGuests      Total number of guests.
                 * @param extraCleaning       Whether extra cleaning service is requested.
                 * @param breakfastIncluded   Whether breakfast is included in the reservation.
                 * @param earlyCheckIn        Whether early check-in is requested.
                 * @param reservation         The reservation object created using the input data.
                 * @param cost                The calculated cost of the reservation.
                 */

                // Create a Reservation object with the gathered details
                Reservation reservation = new Reservation(
                        guestName, email, phone, roomNumber, arrivalDate, departureDate,
                        numberOfGuests, extraCleaning, breakfastIncluded, earlyCheckIn
                );

                // Calculate the cost of the reservation using ReservationService
                ReservationService service = new ReservationService();
                double cost = service.calculateCost(reservation); // Compute total cost

                // Display the calculated cost in the calculateCostField text field
                calculateCostField.setText(String.format("%.2f", cost));

            } catch (NumberFormatException ex) {
                // Handle invalid number inputs
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Handle any other unexpected errors during calculation
                JOptionPane.showMessageDialog(this, "Error calculating cost: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //------------------


        /** Payment Method Section **/
        // Dimensions and starting positions
        int radioLabelX = 650, radioLabelY = 180;
        int radioButtonX = 800, radioButtonY = 180, radioButtonWidth = 200, radioButtonHeight = 30;
        int confirmPaymentButtonX = 800, confirmPaymentButtonY = 240, buttonWidth = 200, buttonHeight = 30;

        // Label for "Payment Method"
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        paymentMethodLabel.setForeground(ThemeManager.getForeground());
        paymentMethodLabel.setBounds(radioLabelX,radioButtonY,labelWidth,height);
        add(paymentMethodLabel);

        // Radio Buttons for payment options
        JRadioButton cashRadioButton = new JRadioButton("Cash");
        cashRadioButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        cashRadioButton.setForeground(ThemeManager.getForeground());
        cashRadioButton.setFocusPainted(false);
        cashRadioButton.setBackground(ThemeManager.getBackground()); // Match panel background
        cashRadioButton.setBounds(radioButtonX, radioButtonY, 100, radioButtonHeight);
        add(cashRadioButton);

        JRadioButton cardRadioButton = new JRadioButton("Visa or Mastercard");
        cardRadioButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        cardRadioButton.setForeground(ThemeManager.getForeground());
        cardRadioButton.setFocusPainted(false);
        cardRadioButton.setBackground(ThemeManager.getBackground()); // Match panel background
        cardRadioButton.setBounds(radioButtonX + 100, radioButtonY , 200, radioButtonHeight);
        add(cardRadioButton);

        // Group the radio buttons to ensure only one can be selected
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashRadioButton);
        paymentGroup.add(cardRadioButton);

        // **Step 3: Card Details Section**
        // Dimensions and starting positions for card details
        int cardDetailsX = 800, cardDetailsY = 280;
        String[] cardDetailsLabels = {"CardHolder Name:", "Card Number:", "Expiration Date:","CVV"};
        JLabel[] cardLabels = new JLabel[cardDetailsLabels.length];
        JTextField[] cardFields = new JTextField[cardDetailsLabels.length];

        // Create Card Details Fields dynamically using a loop to generate labels and text fields
        for(int i=0; i<cardDetailsLabels.length; i++){

            // Create and configure a label for each card detail
            cardLabels[i] = new JLabel(cardDetailsLabels[i]);
            cardLabels[i].setFont(new Font("Roboto",Font.PLAIN,15));
            cardLabels[i].setForeground(ThemeManager.getForeground());
            cardLabels[i].setBounds(cardDetailsX - 150, cardDetailsY + (i * 50), 150, height); // Align labels with fields
            add(cardLabels[i]);

            // Create and configure a text field for each card detail
            cardFields[i] = new JTextField();
            cardFields[i].setBounds(cardDetailsX, cardDetailsY + (i * 50), fieldWidth, height);
            add(cardFields[i]);
        }

        // Button for calculating cost
        JButton payButton = new JButton("Confirm Payment:");
        payButton.setFont(new Font("Roboto", Font.PLAIN, 18));
        payButton.setBounds(cardDetailsX, cardDetailsY + (4 * 50), fieldWidth, height);
        payButton.setBackground(ThemeManager.getButtonBackground());
        payButton.setForeground(ThemeManager.getButtonForeground());
        add(payButton);

        // Show/Hide Card Details Dynamically Based on Payment Selection
        cardRadioButton.addActionListener(e ->{
            for(int i=0; i<cardLabels.length; i++){
                cardLabels[i].setVisible(true); // Show card details
                cardFields[i].setVisible(true);
                payButton.setVisible(true);
            }
        });

        cashRadioButton.addActionListener(e ->{
            for(int i=0; i<cardLabels.length; i++){
                cardLabels[i].setVisible(false); // Hide card details
                cardFields[i].setVisible(false);
                payButton.setVisible(false);
            }
        });

        // Initially Hide Card Details
        for (int i = 0; i < cardLabels.length; i++) {
            cardLabels[i].setVisible(false);
            cardFields[i].setVisible(false);
            payButton.setVisible(false);
        }



        // Additional Services Section
        JLabel ReservationNumberLabel = new JLabel("Reservation Number");
        ReservationNumberLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        ReservationNumberLabel.setForeground(ThemeManager.getForeground());
        ReservationNumberLabel.setBounds(600, reservationFieldY + gap, 400, 30); // Section title
        add(ReservationNumberLabel);

        // Button to generate guest unique code
        JButton generateButton = new JButton("Generate:");
        generateButton.setFont(new Font("Roboto", Font.PLAIN, 18));
        generateButton.setBounds(600, reservationFieldY + gap + 50, labelWidth, height);
        generateButton.setBackground(ThemeManager.getButtonBackground());
        generateButton.setForeground(ThemeManager.getButtonForeground());
        add(generateButton);



        // Text Field for guest code
        JTextField reservationField = new JTextField();
        reservationField.setFont(new Font("Roboto", Font.PLAIN,16));
        reservationField.setBounds(textFieldX, reservationFieldY + gap + 50, fieldWidth, height);
        add(reservationField);

        generateButton.setEnabled(true);
        generateButton.addActionListener(e ->{
            int uniqueId = 10000000 + (int) (Math.random() * 90000000); // Guaranteed 8 digits
            reservationField.setText("GR" + uniqueId);
            generateButton.setEnabled(false);

        });

        // FINAL - CONFIRM RESERVATION BUTTON
        saveReservationButton = new JButton("Confirm Reservation");
        saveReservationButton.setBounds(800,serviceY , fieldWidth, height);
        saveReservationButton.setBackground(ThemeManager.getButtonBackground());
        saveReservationButton.setForeground(ThemeManager.getButtonForeground());
        saveReservationButton.setFont(new Font("Roboto",Font.PLAIN,18));
        add(saveReservationButton);


        // Disable the saveReservationButton initially to ensure it can only be clicked after validation
        saveReservationButton.setEnabled(false);
        saveReservationButton.addActionListener(e ->{
            try{
                /**
                 * ActionListener for the Save Reservation button:
                 * - Gathers all input data from form fields.
                 * - Creates a Reservation object with the collected data.
                 * - Saves the reservation to a storage system as a TXT file.
                 * - Optionally resets fields after saving the reservation.
                 */

                // In this ActionListener I will Gather all input data and send them to
                // Reservation class which will then be send to storage and create a TXT FILE

                // Validate Inputs
                if (!validateInputs()) {
                    return; // Stop if validation fails
                }

                String guestName = guestFields[0].getText(); //  guestFields[0]: Guest Full Name
                String email = guestFields[1].getText(); // guestFields[1]: Email Address
                String phone = guestFields[2].getText(); // guestFields[2]: Phone Number
                String roomNumber = reservationFields[0].getText(); // Get text from the "Room Number" field
                String arrivalDate = reservationFields[1].getText(); // Get text from the "Arrival Date" field
                String departureDate = reservationFields[2].getText(); // Get text from the "Departure Date" field
                int numberOfGuests = Integer.parseInt(reservationFields[3].getText()); // Parse guest count String -> Int
                boolean extraCleaning = serviceCheckboxes[0].isSelected();  // Check if "Extra Cleaning" is selected
                boolean breakfastIncluded = serviceCheckboxes[1].isSelected(); // Check if "Breakfast Included" is selected
                boolean earlyCheckIn = serviceCheckboxes[2].isSelected(); // Check if "Early Check-in" is selected

                /**
                 * Gathers input data from form fields for creating a reservation.
                 *
                 * @param guestName          Guest's full name retrieved from the first guestFields entry.
                 * @param email              Guest's email address retrieved from the second guestFields entry.
                 * @param phone              Guest's phone number retrieved from the third guestFields entry.
                 * @param roomNumber         Room number retrieved from the first reservationFields entry.
                 * @param arrivalDate        Arrival date retrieved from the second reservationFields entry.
                 * @param departureDate      Departure date retrieved from the third reservationFields entry.
                 * @param numberOfGuests     Number of guests parsed as an integer from the fourth reservationFields entry.
                 * @param extraCleaning      Boolean indicating if the "Extra Cleaning" option is selected.
                 * @param breakfastIncluded  Boolean indicating if the "Breakfast Included" option is selected.
                 * @param earlyCheckIn       Boolean indicating if the "Early Check-in" option is selected.
                 */


                // Create a Reservation object with the collected data
                Reservation reservation = new Reservation(
                        guestName, email, phone, roomNumber, arrivalDate, departureDate,
                        numberOfGuests, extraCleaning, breakfastIncluded, earlyCheckIn
                );


                // Save the Reservation object to a storage system
                ReservationStorage storage = new ReservationStorage(); // Initialize storage system
                storage.saveReservation(reservation); // calls the saveReservation method on the storage instance


                // Reset input fields to prepare for the next reservation
                resetFields();

                // Notify the user that the reservation has been saved successfully
                JOptionPane.showMessageDialog(this, "Reservation Confirmed and Saved Successfully!");
            }catch(Exception exception){
                // Handle errors and display an error message to the user
                JOptionPane.showMessageDialog(this,"Error Saving Reservation: " + exception.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
            }
        });


        //END NewReservation()
    }

    //-----------//-----------//-----------//-----------//-----------//-----------//-----------//-----------

    // Helper Method: Validate Inputs
    private boolean validateInputs() {
        /**
         * Creates labeled input fields for sections like Guest Details and Reservation Details.
         *
         * @param labels Array of labels for the input fields.
         * @param fields Array to store the created input fields.
         * @param startY Starting Y-coordinate for the input fields.
         */

        // Check Guest Fields
        for (JTextField field : guestFields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required guest fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Validate Email (guestFields[1] is assumed to be Email Address)
        String email = guestFields[1].getText().trim();
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Check Reservation Fields
        for (JTextField field : reservationFields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required reservation fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Validate Number of Guests
        try {
            int guests = Integer.parseInt(reservationFields[3].getText().trim());
            if (guests <= 0) {
                JOptionPane.showMessageDialog(this, "Number of Guests must be greater than 0.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of Guests must be a valid number.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Enable the save button if validation passes
        saveReservationButton.setEnabled(true);
        return true; // All validations passed
    }


    //-----------//-----------//-----------//-----------//-----------//-----------//-----------//-----------


    // Email Validation Method
    private boolean isValidEmail(String email) {
        /**
         * Validates an email address to ensure it matches the expected format.
         *
         * @param email The email address to validate.
         * @return true if the email address matches the specified regex format, false otherwise.
         */
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(emailRegex); // Return true if the email matches the regex, false otherwise
    }


    //-----------//-----------//-----------//-----------//-----------//-----------//-----------//-----------

    private void resetFields(){
        /**
         * Resets all input fields in the form to their default state.
         * - Clears all text fields.
         * - Unchecks all checkboxes.
         * - Sets focus to the first field in guestFields.
         *
         * @param guestFields       Array of text fields for guest details, all set to blank.
         * @param reservationFields Array of text fields for reservation details, all set to blank.
         * @param serviceCheckboxes Array of checkboxes for additional services, all unchecked.
         */
        for(JTextField field: guestFields){
            field.setText(""); // Set each field to an empty string
        }
        for(JTextField field: reservationFields){
            field.setText(""); // Set each field to an empty string
        }
        for(JCheckBox checkbox: serviceCheckboxes){
            checkbox.setSelected(false);  // Deselect the checkbox
        }

    }

    //-----------//-----------//-----------//-----------//-----------//-----------//-----------//-----------

}