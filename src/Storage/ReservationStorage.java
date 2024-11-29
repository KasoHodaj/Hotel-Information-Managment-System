package Storage;
import Models.Reservation;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationStorage {

    /**
            The ReservationStorage class will:
            1. Save Reservations to a file so the data is not lost when you close the program.
            2. Load Reservations from the file when you start the program again, so the saved data is accessible.
            For now, the file (reservations.txt) will act as a simple database.

     **/



    private static final String FILE_NAME = "C:/Users/kasoc/IdeaProjects/Hotel_Managment_System/src/Data/reservations.txt";
    // File name to store reservations.
    // This file will be created in the Data folder of the Hotel_Management_System project.
    // CSV FORMAT: "kaso","kasohodaj@yahoo.gr","6978521182","101","10/01/25","12/01/25",10,Extra Cleaning Not Included,Breakfast Included,Early Check-In Included



    // NEXT I WILL ADD THE METHOD TO SAVE MY RESERVATION TO TXT
    public void saveReservation(Reservation reservation){

        // In here I will use a BufferedWriter to write files with the data I get from Reservation class
        // Also I need to append the new Data so I don't overwrite the previous ones by using FileWriter = true
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))){

            // TODO: Also include reservation costs, method of payment and the unique Reservation Number. (KASO, 24-11-2024)

            // Next I will write the file in CSV
            writer.write("\"" + reservation.getGuestName() + "\", " +
                    "\"" + reservation.getEmail() + "\", " +
                    "\"" + reservation.getPhone() + "\", " +
                    "\"" + reservation.getRoomNumber() + "\", " +
                    "\"" + reservation.getArrivalDate() + "\", " +
                    "\"" + reservation.getDepartureDate() + "\", " +
                    reservation.getNumberOfGuests() + ", " +
                    (reservation.isExtraCleaning() ? "Extra Cleaning Included " : "Extra Cleaning Not Included ") + "," +
                    (reservation.isEarlyCheckIn() ? "Breakfast Included " : "Breakfast Not Included ") + "," +
                    (reservation.isBreakfastIncluded() ? "Early Check-In Included " : "Early Check-In Not Included "));


            writer.newLine();
        }catch(IOException e){
            e.printStackTrace(); // Basically print the error if the file writting fails
            JOptionPane.showMessageDialog(null, "Failed to save reservation. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    // TODO: Next I will create a method to load/read data from the files. (KASO, 25-11-2024)
}
