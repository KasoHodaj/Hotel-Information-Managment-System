package Components;

import Utils.ThemeManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;   // ArrayList implements List, but doesnt import Lists so we need to add the library
/**
 * The `Reservations` class represents a panel displaying reservation details and provides search functionality.
 * It includes a table with predefined contacts and their details, such as "Name", "Age", "Gender", "Nationality", "Reservation Num", "Room Number", "Date To/From", "Phone", "Email".
 */
public class Reservations extends JPanel {

    private DefaultTableModel tableModel; // Holds table data (rows & columns)
    private JTable reservationTable;      // Displays the table visually
    private List<Object[]> reservationData; // Stores the data (each row is an Object array)
    private JTextField searchField;       // For entering search queries


    /**
     * Constructor to initialize the `Reservations` panel.
     */
    public Reservations(){
        //START Reservations()

        /** TODO: Improve ux/ui design **/
        /** TODO: Add sorting functionality for reservation data (e.g., by name or reservation number). (26/11/2024)**/
        /** TODO: Implement advanced search filters (e.g., by room type, date range). (26/11/2024)**/


        // Panel Settings
        setBackground(ThemeManager.getBackground());
        setLayout(null); // Use absolute positioning

        /** Header Label **/
        JLabel headerLabel = new JLabel("Reservations");
        headerLabel.setFont(new Font("Roboto", Font.BOLD, 28));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(20, 20, 400, 40);
        add(headerLabel);

        /** Search Bar **/
        JLabel searchLabel = new JLabel("Reservation Number:");
        searchLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setBounds(20, 80, 200, 30);
        add(searchLabel);

        searchField = new JTextField(); // Input field for entering search queries
        searchField.setFont(new Font("Roboto", Font.PLAIN, 14));
        searchField.setBounds(200, 80, 200, 30);
        add(searchField);

        JButton searchButton = new JButton("Search"); // Button to trigger search
        searchButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        searchButton.setBackground(Color.decode("#4CAF50"));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBounds(420, 80, 100, 30);
        add(searchButton);

        /** Table Setup **/
        String[] columnArr = {"Name", "Age", "Gender", "Nationality", "Reservation Num", "Room Number", "Date To/From", "Phone", "Email"};

        tableModel = new DefaultTableModel(columnArr, 0); // A DefaultTableModel is a class in Swing that holds the data for a table
        reservationTable = new JTable(tableModel); // A JTable is a Swing component that displays the data stored in a TableModel in a table format, with rows and columns.
    //    1. tableModel holds the data for the table.
    //        Initially, the table has only column headers (columnArr) and no data rows.
    //    2. reservationTable is the visual table you see on the screen.
    //        It gets its column names and data from the tableModel.
    //        When you add data (rows) to tableModel, the table will automatically update to show it.
        reservationTable.setFont(new Font("Roboto", Font.PLAIN, 14));
        reservationTable.setRowHeight(30);
        reservationTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 16));


        JScrollPane scrollPanel = new JScrollPane(reservationTable); // Swing component that ws users to scroll horizontally and vertically.
        scrollPanel.setBounds(20,150,1000,400);
        add(scrollPanel);


        /** Populate Table with Fake Data **/
        populateTable(); // Private method in which I will ADD Data and INPUT them to the table

        // Attach search functionality to the button
        searchButton.addActionListener(e->{
            performSearch();
        });

        //END Reservations()
    }

    //----------//----------//----------//----------//----------//----------//----------//----------
    private void populateTable() {
        // START populateTable()
        /** TODO: Load real reservation data from a database or API in the future. (26/11/2024)**/


        /**
         * Populates the table with predefined reservation data.
         * Each row represents a reservation with details ("Name", "Age", "Gender", "Nationality", "Reservation Num", "Room Number", "Date To/From", "Phone", "Email").
         */

        // This ArrayList holds the data for the table. Each entry in the list represents a single row in the table,
        // and each row is an array type: Object (Object[])!!!

        reservationData = new ArrayList<>();
        reservationData.add(new Object[]{"Kaso Hodaj", 39, "Male", "Albanian", "GRC911D6-4ADF-6FG", 101, "28/12/24 - 05/01/25", "+30 6969696969", "kasohodaj@example.com"});
        reservationData.add(new Object[]{"Jake Peralta", 35, "Male", "American", "GRC911D6-REF9-GS8", 102, "20/01/25 - 25/01/25", "+718 555-0199", "j.peralta@nypd.com"});
        reservationData.add(new Object[]{"Amy Santiago", 33, "Female", "Puerto Rican", "GRC911D6-99D3-ABC", 102, "20/01/25 - 25/01/25", "+718 555-0188", "a.santiago@nypd.com"});
        reservationData.add(new Object[]{"Raymond Holt", 60, "Male", "American", "GRC911D6-NYPD-B9C", 103, "05/02/25 - 10/02/25", "+718 555-0177", "r.holt@nypd.com"});
        reservationData.add(new Object[]{"Terry Jeffords", 42, "Male", "American", "GRC911D6-YGRT-GRO", 104, "14/02/25 - 20/02/25", "+718 555-0166", "t.jeffords@nypd.com"});
        reservationData.add(new Object[]{"Monica Geller", 34, "Female", "American", "FRIENDS-123-MON", 201, "10/02/25 - 15/02/25", "+1 555-9876", "monica.geller@friends.com"});
        reservationData.add(new Object[]{"Chandler Bing", 35, "Male", "American", "FRIENDS-456-CHAN", 202, "10/02/25 - 15/02/25", "+1 555-5432", "chandler.bing@friends.com"});
        reservationData.add(new Object[]{"Rachel Green", 33, "Female", "American", "FRIENDS-789-RACH", 203, "11/02/25 - 16/02/25", "+1 555-6789", "rachel.green@friends.com"});
        reservationData.add(new Object[]{"Ross Geller", 36, "Male", "American", "FRIENDS-321-ROSS", 204, "10/02/25 - 12/02/25", "+1 555-1234", "ross.geller@friends.com"});
        reservationData.add(new Object[]{"Phoebe Buffay", 32, "Female", "American", "FRIENDS-654-PHOE", 205, "12/02/25 - 14/02/25", "+1 555-2468", "phoebe.buffay@friends.com"});
        reservationData.add(new Object[]{"Joey Tribbiani", 34, "Male", "Italian-American", "FRIENDS-987-JOE", 206, "13/02/25 - 17/02/25", "+1 555-1357", "joey.tribbiani@friends.com"});
        reservationData.add(new Object[]{"Sheldon Cooper", 30, "Male", "American", "BBT-123-SHEL", 301, "05/03/25 - 10/03/25", "+1 555-0123", "sheldon.cooper@bbt.com"});
        reservationData.add(new Object[]{"Leonard Hofstadter", 32, "Male", "American", "BBT-456-LEON", 302, "05/03/25 - 10/03/25", "+1 555-4567", "leonard.hofstadter@bbt.com"});
        reservationData.add(new Object[]{"Penny Hofstadter", 30, "Female", "American", "BBT-789-PENN", 303, "06/03/25 - 08/03/25", "+1 555-6789", "penny.hofstadter@bbt.com"});
        reservationData.add(new Object[]{"Howard Wolowitz", 31, "Male", "American", "BBT-321-HOWA", 304, "07/03/25 - 09/03/25", "+1 555-9876", "howard.wolowitz@bbt.com"});
        reservationData.add(new Object[]{"Raj Koothrappali", 31, "Male", "Indian", "BBT-654-RAJ", 305, "05/03/25 - 10/03/25", "+91 555-2468", "raj.koothrappali@bbt.com"});
        reservationData.add(new Object[]{"Michael Scott", 40, "Male", "American", "OFFICE-123-MIKE", 401, "20/04/25 - 25/04/25", "+1 555-1010", "michael.scott@dundermifflin.com"});
        reservationData.add(new Object[]{"Pam Beesly", 28, "Female", "American", "OFFICE-456-PAM", 402, "21/04/25 - 23/04/25", "+1 555-2020", "pam.beesly@dundermifflin.com"});
        reservationData.add(new Object[]{"Jim Halpert", 29, "Male", "American", "OFFICE-789-JIM", 403, "21/04/25 - 23/04/25", "+1 555-3030", "jim.halpert@dundermifflin.com"});
        reservationData.add(new Object[]{"Dwight Schrute", 34, "Male", "American", "OFFICE-321-DWIG", 404, "20/04/25 - 22/04/25", "+1 555-4040", "dwight.schrute@dundermifflin.com"});
        reservationData.add(new Object[]{"Andy Bernard", 33, "Male", "American", "OFFICE-654-ANDY", 405, "22/04/25 - 24/04/25", "+1 555-5050", "andy.bernard@dundermifflin.com"});


        // Add data to the table model
        for(Object[] row: reservationData){
            tableModel.addRow(row); // First the array type object was added to the ArrayList, then the ArrayList was added to the table as a row
        }
        //END populateTable()
    }

    //----------//----------//----------//----------//----------//----------//----------//----------//----------


    public void performSearch(){
        // START performSearch()
        /**
         * Searches the table for a reservation based on the entered reservation number.
         * Updates the table to display only matching results or shows a message if no match is found.
         */
        String query = searchField.getText().trim().toLowerCase(); // Convert query to lowercase for case-insensitive search
        tableModel.setRowCount(0); // setRowCount clears the table by removing ALL rows

        // Now the table is EMPTY!

        boolean flag = false; // Flag to track if a match is found. If we find the Reservation Num then flag = true;
        for(Object[] row: reservationData){
            // Loop Search for the same Reservation Number
            String reservationNum = row[4].toString().toLowerCase(); // Get reservation number and convert to lowercase: row[4] = reservation number

            if(reservationNum.contains(query)){
                // contains(query) will match even if query is only part of reservationNum
                //The problem is if we have similar numbers in the table and they only differ in the last parts, in this case equals is better option
                tableModel.addRow(row);
                flag = true;
            }
        }
        if(!flag) // If no match is found, show a message dialog
            JOptionPane.showMessageDialog(this,"No results found for \"" + query + "\"", "Search Results", JOptionPane.WARNING_MESSAGE);
        //END performSearch()
    }

    //-------------//-------------//-------------//-------------//-------------//-------------//-------------
}

