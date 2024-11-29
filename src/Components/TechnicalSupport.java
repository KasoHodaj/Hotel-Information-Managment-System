package Components;

import Utils.ThemeManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * The `TechnicalSupport` class represents a panel displaying emergency contact information.
 * It includes a table with predefined contacts and their details, such as "Name", "Department", "Phone Number", "Home Address", "Email", "Working Times".
 */

public class TechnicalSupport extends JPanel {
    private DefaultTableModel tableModel; // Table model to manage data
    private JTable contactsTable; // Table to display contact information

    /**
     * Constructor to initialize the `TechnicalSupport` panel.
     */
    public TechnicalSupport() {
        //START TechnicalSupport()


        // Panel settings
        setBackground(ThemeManager.getBackground()); // Dark teal background
        setLayout(null); // Absolute positioning for custom layout

        // Header Label
        JLabel headerLabel = new JLabel("Emergency Contact Numbers");
        headerLabel.setFont(new Font("Roboto", Font.BOLD, 28));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(20, 20, 400, 40); // Position of the label
        add(headerLabel);

        /** Table Setup **/
        // Table column headers
        String[] contacts = {"Name", "Department", "Phone Number", "Home Address", "Email", "Working Times"};

        // Initialize table model with column headers and no rows
        tableModel = new DefaultTableModel(contacts, 0); // 0 rows initially
        contactsTable = new JTable(tableModel); // Create table with the model

        // Set table properties for better readability
        contactsTable.setFont(new Font("Roboto", Font.PLAIN, 15)); // Table font
        contactsTable.setRowHeight(30); // Set row height for better readability
        contactsTable.setForeground(Color.BLACK); // Black text for rows
        contactsTable.setBackground(Color.WHITE); // White background for table rows

        /** Table Header Customization **/
        contactsTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 16)); // Header font
        contactsTable.getTableHeader().setBackground(Color.decode("#3C807F")); // Dark teal header
        contactsTable.getTableHeader().setForeground(Color.WHITE); // White header text

        /** Scrollable Table **/
        JScrollPane scrollPanel = new JScrollPane(contactsTable); // Make the table scrollable
        scrollPanel.setBounds(20, 150, 850, 325); // Position and size of the scrollable table
        add(scrollPanel);

        /** Populate the table with predefined data **/
        populateTable();

        //END TechnicalSupport()
    }

    public void populateTable() {
        tableModel.addRow(new Object[]{"Talia Grey", "Hotel Manager", "+30 696 1111111", "123 Elm Street, Athens", "talia.grey@example.com", "9:00 AM - 5:00 PM"});
        tableModel.addRow(new Object[]{"Joren Kael", "Front Desk Manager", "+30 696 2222222", "456 Oak Avenue, Athens", "joren.kael@example.com", "8:00 AM - 4:00 PM"});
        tableModel.addRow(new Object[]{"Lyria Crest", "IT Support", "+30 696 3333333", "789 Pine Road, Athens", "lyria.crest@example.com", "10:00 AM - 6:00 PM"});
        tableModel.addRow(new Object[]{"Caden Vale", "Housekeeping Supervisor", "+30 696 4444444", "321 Birch Street, Athens", "caden.vale@example.com", "7:00 AM - 3:00 PM"});
        tableModel.addRow(new Object[]{"Alaric Thorne", "Maintenance Head", "+30 696 5555555", "654 Willow Drive, Athens", "alaric.thorne@example.com", "6:00 AM - 2:00 PM"});
        tableModel.addRow(new Object[]{"Erin Dorne", "Security", "+30 696 6666666", "987 Maple Lane, Athens", "erin.dorne@example.com", "10:00 PM - 6:00 AM"});
        tableModel.addRow(new Object[]{"Elysia Moon", "General Manager", "+30 696 7777777", "123 Aspen Boulevard, Athens", "elysia.moon@example.com", "9:00 AM - 5:00 PM"});
        tableModel.addRow(new Object[]{"Kaelen Dray", "Event Coordinator", "+30 696 8888888", "456 Cedar Street, Athens", "kaelen.dray@example.com", "10:00 AM - 6:00 PM"});
        tableModel.addRow(new Object[]{"Ronan Blake", "Guest Relations", "+30 696 9999999", "789 Poplar Way, Athens", "ronan.blake@example.com", "11:00 AM - 7:00 PM"});
        tableModel.addRow(new Object[]{"Selene Frost", "Concierge", "+30 696 0000000", "321 Sycamore Street, Athens", "selene.frost@example.com", "12:00 PM - 8:00 PM"});
    }
}
