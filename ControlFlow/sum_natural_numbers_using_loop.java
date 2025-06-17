import java.util.Scanner;

public class sum_natural_numbers_using_loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum_using_loop=0;
        for(int i=1; i<=num; i++){
            sum_using_loop+=i;
        }
        int sum_using_formula = num*(num+1)/2;
        if(sum_using_formula==sum_using_loop){
            System.out.println("Both results using for loop and formula are same");
        }
        else{
            System.out.println("Both results using for loop and formula are not same");
        }
    }
}
