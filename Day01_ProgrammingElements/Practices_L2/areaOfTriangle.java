import java.util.*;

public class areaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base of a triangle: ");
        int base = sc.nextInt();
        System.out.println("Enter height of a triangle: ");
        int height = sc.nextInt();
        double area = 0.5 * base * height;
        System.out.println("Area of a triangle is: "+area +" cm sq");
    }
}
