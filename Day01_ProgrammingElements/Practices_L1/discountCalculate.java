public class discountCalculate {
    public static void main(String[] args) {
        int fee = 125000;
        int discount_offer = 10;
        int discounted_amount = fee*discount_offer/100;
        int discounted_price = fee-discounted_amount;
        System.out.println("The discount amount is INR:" + discounted_amount + " and final discounted fee is INR: "+ discounted_price);
    }
}
