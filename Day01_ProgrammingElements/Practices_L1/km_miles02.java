import java.util.*;
public class km_miles02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter distance in km: ");
        double km = sc.nextDouble();
        double dis_miles = km * (1/1.6);
        System.out.println("The total miles is: " + dis_miles + " mile for the given "+km);
    }
}
