package Generics_01;

import java.util.*;

//Abstract class
abstract class WarehouseItem {
	private String name;

	public WarehouseItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// Abstract method to be implemented by all items
	public abstract void showDetails();
}

class Electronics extends WarehouseItem {
	private String brand;

	public Electronics(String name, String brand) {
		super(name);
		this.brand = brand;
	}

	@Override
	public void showDetails() {
		System.out.println("Electronics: " + getName() + ", Brand: " + brand);
	}
}

class Groceries extends WarehouseItem {
	private String expiryDate;

	public Groceries(String name, String expiryDate) {
		super(name);
		this.expiryDate = expiryDate;
	}

	@Override
	public void showDetails() {
		System.out.println("Groceries: " + getName() + ", Expiry: " + expiryDate);
	}
}

class Furniture extends WarehouseItem {
	private String material;

	public Furniture(String name, String material) {
		super(name);
		this.material = material;
	}

	@Override
	public void showDetails() {
		System.out.println("Furniture: " + getName() + ", Material: " + material);
	}
}

//Generic Storage class
class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
	}

	public List<T> getItems() {
		return items;
	}

	public void displayItems() {
		for (T item : items) {
			item.showDetails();
		}
	}
}

//Utility class with wildcard method
class WarehouseUtil {
	public static void displayAllItems(List<? extends WarehouseItem> items) {
		for (WarehouseItem item : items) {
			item.showDetails();
		}
	}
}

public class SmartWarehouse {
	public static void main(String[] args) {
		Storage<Electronics> electronic = new Storage<>();
		electronic.addItem(new Electronics("Laptop", "Dell"));
		electronic.addItem(new Electronics("Smartphone", "Samsung"));

		Storage<Groceries> grocery = new Storage<>();
		grocery.addItem(new Groceries("Milk", "2025-08-01"));
		grocery.addItem(new Groceries("Bread", "2025-07-30"));

		Storage<Furniture> furniture = new Storage<>();
		furniture.addItem(new Furniture("Chair", "Wood"));
		furniture.addItem(new Furniture("Table", "Steel"));

		// Display each category separately
		System.out.println("== Electronics ==");
		electronic.displayItems();

		System.out.println("\n== Groceries ==");
		grocery.displayItems();

		System.out.println("\n== Furniture ==");
		furniture.displayItems();

		// Use wildcard method to display all items from different storages
		System.out.println("\n== Using Wildcard Method ==");
		WarehouseUtil.displayAllItems(electronic.getItems());
		WarehouseUtil.displayAllItems(grocery.getItems());
		WarehouseUtil.displayAllItems(furniture.getItems());
	}
}
