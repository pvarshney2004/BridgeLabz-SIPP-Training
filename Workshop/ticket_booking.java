package Workshop;
import java.util.*;

public class ticket_booking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our ticket booking platform:");
		int totalSeats = 10;
		System.out.println("Enter the number of vacant seats you want: ");
		int n = sc.nextInt();
		int m = n;
		while (n > 0) {
			System.out.println("Type of seat you want: ");
			String menu = sc.next();
			menu = menu.toLowerCase();
			switch (menu) {
			case "ac": {
				System.out.println("AC ticket booked");
				n--;
				System.out.println("Your " + (m - n) + " seats succesfully booked");
				break;
			}
			case "sleeper": {
				System.out.println("Sleeper ticket booked");
				n--;
				System.out.println("Your " + (m - n) + " succesfully booked");
				break;
			}
			case "general": {
				System.out.println("General ticket booked");
				n--;
				System.out.println("Your " + (m - n) + " succesfully booked");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
		if (n == 0) {
			System.out.println("Your all seats are successfully booked.");
			System.out.println("We have " + (totalSeats - m)
					+ " seats left. If you want to book more seats, you can. \nThank You");

		}
	}
}
