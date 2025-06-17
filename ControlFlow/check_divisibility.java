import java.util.Scanner;
public class check_divisibility{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        boolean flag=false;
        if(num%5==0){
            flag=true;
        }
        System.out.println("Is the number "+num+" divisible by 5? "+flag);
    }
}