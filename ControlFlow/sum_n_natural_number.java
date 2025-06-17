import java.util.*;
public class sum_n_natural_number{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number: ");
        int num = sc.nextInt();
        if(num>0){
            int ans = num*(num+1)/2;
            System.out.println("The sum of "+num+" natural numbers is "+ans);
        }
        else{
            System.out.println("The entered number is not a natural number.");
        }
    }
}