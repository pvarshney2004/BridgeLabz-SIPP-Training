package constructor;

public class Book {
	String title;
	String author;
	int price;
	public Book() {
		title = "default title";
		author = "default author";
		price = 100;
	}
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
}
