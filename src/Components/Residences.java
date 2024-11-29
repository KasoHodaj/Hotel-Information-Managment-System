package Components;

import Utils.ThemeManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * The `Residences` class represents a panel displaying information about rooms and their prices.
 */
public class Residences extends JPanel {
    private DefaultTableModel tableModel; // Model to hold room data
    private JTable roomsTable;           // Table to display room details


    /**
     * Constructor to initialize the `Residences` panel.
     */
    public Residences() {
        //START Residences()
        /** TODO: Add a button or dropdown for filtering rooms by availability. (26/11/2024)**/
        /** TODO: Implement sorting functionality for the table columns (e.g., by price or room type). (26/11/2024)**/


        // Panel settings
        setBackground(ThemeManager.getBackground()); // Set background color using ThemeManager
        setLayout(null); // Absolute positioning for manual layout control

        /** Header Label **/
        JLabel headerLabel = new JLabel("Residences and Prices");
        headerLabel.setFont(new Font("Roboto", Font.BOLD, 28));
        headerLabel.setForeground(ThemeManager.getForeground());
        headerLabel.setBounds(20, 20, 400, 40);
        add(headerLabel);

        /** Table Setup **/
        String[] columnHeaders = {"Room Number","Room Type","Price per Night", "Availability"}; //table columns


        tableModel = new DefaultTableModel(columnHeaders, 0); // This is a table model with column headers
        roomsTable = new JTable(tableModel); // Create a table using the model
        roomsTable.setFont(new Font("Roboto", Font.PLAIN, 15));
        roomsTable.setRowHeight(30); // Set row height for better readability
        roomsTable.setBackground(Color.decode("#E6F5F3"));
        roomsTable.setForeground(Color.BLACK);

        /** Customize Table Header **/
        roomsTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 16)); // Header font style and size
        roomsTable.getTableHeader().setBackground(Color.decode("#3C807F"));
        roomsTable.getTableHeader().setForeground(Color.WHITE);

        /** Scroll Panel **/
        JScrollPane scrollPanel = new JScrollPane(roomsTable); // Scroll functionality for the table
        scrollPanel.setBounds(20, 150, 850, 400); // Position and size of the scrollable table
        add(scrollPanel);

        /** Populate Table with Fake Data **/
        populateTable();


        //END Residences()
    }

    private void populateTable() {
        // NOTE: No ArrayList is used as the data is static.
        // HERE I WONT NEED TO USE AN ARRAY LIST FOR TWO (2) MAIN REASONS:
        // The data will NOT be reused elsewhere in the program such as SEARCHING OR FILTERING!!!
        // Adds rows directly to the table without intermediate steps, making it easier and achieving the SAME GOAL!!!

        /** TODO: Load real data from a database or API in the future. (26/11/2024)**/
        tableModel.addRow(new Object[]{"101", "Single Room", "$100", "Available"});
        tableModel.addRow(new Object[]{"102", "Double Room", "$150", "Occupied"});
        tableModel.addRow(new Object[]{"103", "Suite", "$300", "Available"});
        tableModel.addRow(new Object[]{"104", "Family Room", "$200", "Available"});
        tableModel.addRow(new Object[]{"105", "Executive Suite", "$400", "Occupied"});
        tableModel.addRow(new Object[]{"106", "Deluxe Room", "$250", "Available"});
        tableModel.addRow(new Object[]{"107", "Presidential Suite", "$800", "Available"});
        tableModel.addRow(new Object[]{"108", "Studio Apartment", "$120", "Occupied"});
        tableModel.addRow(new Object[]{"109", "Junior Suite", "$350", "Available"});
        tableModel.addRow(new Object[]{"110", "Penthouse", "$1000", "Occupied"});
        tableModel.addRow(new Object[]{"111", "Cabin", "$75", "Available"});
        tableModel.addRow(new Object[]{"112", "Luxury Villa", "$1500", "Available"});
        tableModel.addRow(new Object[]{"113", "Loft", "$180", "Occupied"});
        tableModel.addRow(new Object[]{"114", "Cottage", "$220", "Available"});
    }





}
