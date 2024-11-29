package Services;

import Models.Reservation;

public class ReservationService {


    /**
     * (INCOMPLETE!)
     * Calculates the total cost of a reservation based on the base rate,
     * number of nights, and any additional services selected by the guest.
     *
     * @param reservation The Reservation object containing guest preferences and details.
     * @return The total cost of the reservation.
     */

    public double calculateCost(Reservation reservation) {
        double baseRate = 100.0; // Base rate per night (standard room charge)
        // TODO: Replace with date calculations based on arrival and departure dates. (KASO, 24-11-2024)
        int nights = 2; // Placeholder for number of nights.
        double cost = baseRate * nights; // Calculate initial cost based on the base rate and number of nights

        if (reservation.isExtraCleaning()) cost += 20.0;   // Add extra cleaning cost if selected
        if (reservation.isBreakfastIncluded()) cost += 15.0 * reservation.getNumberOfGuests(); // Add breakfast cost per guest per night if included
        if (reservation.isEarlyCheckIn()) cost += 30.0; // Add early check-in cost if selected

        return cost; // Return the final calculated cost
    }
}