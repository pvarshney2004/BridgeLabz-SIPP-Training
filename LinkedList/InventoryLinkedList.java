package LinkedList;

class ItemNode {
	String itemName;
	int itemId;
	int quantity;
	double price;
	ItemNode next;

	public ItemNode(String itemName, int itemId, int quantity, double price) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}

public class InventoryLinkedList {
	private ItemNode head;

	// Adding item at beginning
	public void addAtBeginning(String name, int id, int qty, double price) {
		ItemNode newNode = new ItemNode(name, id, qty, price);
		newNode.next = head;
		head = newNode;
	}

	// Adding item at end
	public void addAtEnd(String name, int id, int qty, double price) {
		ItemNode newNode = new ItemNode(name, id, qty, price);
		if (head == null) {
			head = newNode;
			return;
		}
		ItemNode temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = newNode;
	}

	// Add at a specific position
	public void addAtPosition(String name, int id, int qty, double price, int position) {
		if (position == 0) {
			addAtBeginning(name, id, qty, price);
			return;
		}
		ItemNode newNode = new ItemNode(name, id, qty, price);
		ItemNode temp = head;
		for (int i = 0; i < position - 1 && temp != null; i++)
			temp = temp.next;
		if (temp == null) {
			System.out.println("Position out of bounds.");
			return;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	// Remove item by ID of an item
	public void removeById(int id) {
		if (head == null)
			return;
		if (head.itemId == id) {
			head = head.next;
			return;
		}
		ItemNode temp = head;
		while (temp.next != null && temp.next.itemId != id)
			temp = temp.next;
		if (temp.next != null)
			temp.next = temp.next.next;
		else
			System.out.println("Item with ID " + id + " not found.");
	}

	// Search by ID
	public void searchById(int id) {
		ItemNode temp = head;
		while (temp != null) {
			if (temp.itemId == id) {
				displayItem(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Item not found.");
	}

	private void displayItem(ItemNode node) {
		System.out.println("ID: " + node.itemId + ", Name: " + node.itemName + ", Qty: " + node.quantity + ", Price: "
				+ node.price);
	}

	// Display entire inventory
	public void displayInventory() {
		ItemNode temp = head;
		while (temp != null) {
			displayItem(temp);
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd("Laptop", 101, 5, 50000);
        inventory.addAtEnd("Mouse", 102, 10, 500);
        inventory.addAtBeginning("Keyboard", 103, 7, 800);
        inventory.addAtPosition("Monitor", 104, 3, 12000, 2);

        System.out.println("Inventory:");
        inventory.displayInventory();
        
        System.out.println();
        System.out.println("Search by ID 102:");
        inventory.searchById(102);
        
        System.out.println();
        inventory.removeById(102);
        inventory.displayInventory();

	}
	
}
