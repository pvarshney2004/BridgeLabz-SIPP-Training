import java.util.*;

public class qoutient_remainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.println("The Quotient is " +num1/num2+ " and Reminder is "+ num1%num2 +" of two number "+ num1+" and "+num2);
    }
}
