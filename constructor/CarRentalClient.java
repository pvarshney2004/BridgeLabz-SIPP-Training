package constructor;

public class CarRentalClient {
	public static void main(String[] args) {
        CarRental rent1 = new CarRental("Bob", "SUV", 4);
        CarRental rent2 = new CarRental(rent1); // Copy constructor
        CarRental rent3 = new CarRental();        // Default constructor

        rent1.displayRentalDetails();
        rent2.displayRentalDetails();
        rent3.displayRentalDetails();
    }
}
