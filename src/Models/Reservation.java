package Models;

/**
 * The Reservation class models a hotel reservation, Summarizing details about the guest,
 * their stay, and additional preferences such as cleaning, breakfast, and check-in options.
 */

public class Reservation {

    /**  Guest details **/
    private String guestName;
    private String email;
    private String phone;

    /** Reservation details **/
    private String roomNumber;
    private String arrivalDate;
    private String departureDate;
    private int numberOfGuests;

    /** Additional options **/
    private boolean extraCleaning;
    private boolean breakfastIncluded;
    private boolean earlyCheckIn;

    /**
     * Constructor to initialize a Reservation object with all necessary details.
     *
     * @param guestName        Full name of the guest.
     * @param email            Guest's email address.
     * @param phone            Guest's phone number.
     * @param roomNumber       Room number for the reservation.
     * @param arrivalDate      Check-in date in "dd/MM/yy" format.
     * @param departureDate    Check-out date in "dd/MM/yy" format.
     * @param numberOfGuests   Total number of guests.
     * @param extraCleaning    Whether extra cleaning is requested.
     * @param breakfastIncluded Whether breakfast is included.
     * @param earlyCheckIn     Whether early check-in is requested.
     */
    public Reservation(String guestName, String email, String phone, String roomNumber,
                       String arrivalDate, String departureDate, int numberOfGuests, boolean extraCleaning, boolean breakfastIncluded, boolean earlyCheckIn) {
        this.guestName = guestName;
        this.email = email;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfGuests = numberOfGuests;
        this.extraCleaning = extraCleaning;
        this.breakfastIncluded = breakfastIncluded;
        this.earlyCheckIn = earlyCheckIn;
    }

    /** Getters and Setters **/
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isExtraCleaning() {
        return extraCleaning;
    }

    public void setExtraCleaning(boolean extraCleaning) {
        this.extraCleaning = extraCleaning;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isEarlyCheckIn() {
        return earlyCheckIn;
    }

    public void setEarlyCheckIn(boolean earlyCheckIn) {
        this.earlyCheckIn = earlyCheckIn;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "guestName='" + guestName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", extraCleaning=" + extraCleaning +
                ", breakfastIncluded=" + breakfastIncluded +
                ", earlyCheckIn=" + earlyCheckIn +
                '}';
    }
}


