public class calculateProfit {
    public static void main(String[] args) {
        int cost_price = 129;
        int selling_price = 191;
        int profit_price = selling_price - cost_price;
        double profit_percent = (profit_price * 100.0) / cost_price;
        System.err.println("The Cost Price is INR " + cost_price + " and Selling Price is INR " + selling_price);
        System.out.println("The Profit is INR " + profit_price + " and Profit Percent is " + profit_percent + "%");
    }
}
