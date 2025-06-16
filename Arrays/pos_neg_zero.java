import java.util.Scanner;

public class pos_neg_zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            int num = numbers[i];
            System.out.print("Number " + num + " is ");
            if (num > 0) {
                System.out.print("positive and ");
                if (num % 2 == 0) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else if (num < 0) {
                System.out.println("negative.");
            } else {
                System.out.println("zero.");
            }
        }
        
        int first = numbers[0];
        int last = numbers[4];

        if (first == last) {
            System.out.println("The first and last numbers are equal.");
        } else if (first > last) {
            System.out.println("The first number is greater than the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }
    }
}
