package Workshop;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Item {
    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ")";
    }
}

class Order {
    private LocalDate date;
    private List<Item> items;

    public Order(LocalDate date, List<Item> items) {
        this.date = date;
        this.items = items;
    }
    public LocalDate getDate() { return date; }
    public List<Item> getItems() { return items; }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }
    public String getName() { return name; }
    public List<Order> getOrders() { return orders; }
}

class Store {
    private String name;
    private Map<String, Customer> customers;

    public Store(String name, Map<String, Customer> customers) {
        this.name = name;
        this.customers = customers;
    }
    public String getName() { return name; }
    public Map<String, Customer> getCustomers() { return customers; }
}

public class SalesDashboard {
    public static void main(String[] args) {
        // Sample Data
        Item tv = new Item("Smart TV", "Electronics", 1200);
        Item phone = new Item("Phone", "Electronics", 800);
        Item blender = new Item("Blender", "Home Appliances", 150);
        Item yogaMat = new Item("Yoga Mat", "Fitness", 50);
        Item toaster = new Item("Toaster", "Home Appliances", 40);

        Order order1 = new Order(LocalDate.now().minusDays(10), Arrays.asList(tv, yogaMat));
        Order order2 = new Order(LocalDate.now().minusDays(20), Arrays.asList(phone, blender));
        Order order3 = new Order(LocalDate.now().minusDays(40), Arrays.asList(toaster, yogaMat));

        Customer cust1 = new Customer("Alice", Arrays.asList(order1, order2, order3));
        Customer cust2 = new Customer("Bob", Arrays.asList(order1, order2));
        Customer cust3 = new Customer("Charlie", Arrays.asList(order3));

        Store store1 = new Store("Store A", Map.of(
                "Alice", cust1,
                "Bob", cust2
        ));
        Store store2 = new Store("Store B", Map.of(
                "Charlie", cust3
        ));

        Map<String, List<Store>> cityToStoresMap = Map.of(
                "New York", Arrays.asList(store1),
                "Los Angeles", Arrays.asList(store2)
        );

        // -------------------- STREAM PIPELINE -------------------------
        LocalDate cutoffDate = LocalDate.now().minusDays(60);

        List<Item> topAffordablePicks = cityToStoresMap.values().stream()
                .flatMap(List::stream)                                    // All stores in all cities
                .flatMap(store -> store.getCustomers().values().stream()) // All customers
                .filter(customer -> customer.getOrders().stream()
                        .filter(order -> order.getDate().isAfter(cutoffDate))
                        .count() >= 3)                                    // Customers with >= 3 orders
                .flatMap(c -> c.getOrders().stream()
                        .flatMap(order -> order.getItems().stream()))     // Flatten all items
                .distinct()                                               // Remove duplicates
                .sorted(Comparator.comparingDouble(Item::getPrice).reversed()) // Sort desc by price
                .peek(item -> System.out.println("Processing: " + item))  // Log
                .skip(2)                                                  // Skip top 2 expensive
                .limit(10)                                                // Next 10 affordable
                .collect(Collectors.toList());

        System.out.println("\nTop Affordable Picks:");
        topAffordablePicks.forEach(System.out::println);

        // 9. Group items by category
        Map<String, List<Item>> groupedByCategory =
                topAffordablePicks.stream()
                        .collect(Collectors.groupingBy(Item::getCategory));

        System.out.println("\nGrouped by Category: " + groupedByCategory);

        // 10. Count items in Electronics
        long electronicsCount = groupedByCategory.getOrDefault("Electronics", Collections.emptyList()).size();
        System.out.println("Electronics Count: " + electronicsCount);

        // 11. anyMatch -> price > 500
        boolean hasExpensive = topAffordablePicks.stream().anyMatch(i -> i.getPrice() > 500);
        System.out.println("Any item > $500? " + hasExpensive);

        // 12. allMatch -> all > $10
        boolean allAboveTen = topAffordablePicks.stream().allMatch(i -> i.getPrice() > 10);
        System.out.println("All items > $10? " + allAboveTen);

        // 13. noneMatch -> no empty/null names
        boolean noEmptyNames = topAffordablePicks.stream()
                .noneMatch(i -> i.getName() == null || i.getName().isEmpty());
        System.out.println("No empty item names? " + noEmptyNames);

        // 14. findFirst Home Appliances
        topAffordablePicks.stream()
                .filter(i -> i.getCategory().equals("Home Appliances"))
                .findFirst()
                .ifPresent(i -> System.out.println("First Home Appliance: " + i));

        // 15. findAny Fitness
        topAffordablePicks.stream()
                .filter(i -> i.getCategory().equals("Fitness"))
                .findAny()
                .ifPresent(i -> System.out.println("Any Fitness Item: " + i));

        // 16. reduce -> total value
        double totalValue = topAffordablePicks.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("Total Value of Selected Items: $" + totalValue);
    }
}

