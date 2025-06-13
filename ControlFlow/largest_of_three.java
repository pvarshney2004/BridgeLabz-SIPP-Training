import java.util.Scanner;

public class largest_of_three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();
        if(first>second && first>third){
            System.out.println("First number is the largest");
        }
        else if(second>third && second>first){
            System.out.println("Second number is the largest");
        }
        else{
            System.out.print("Third number is the largest");
        }
    }
}
