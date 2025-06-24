package constructor;

public class BookClient {
	public static void main(String[] args) {
		//default 
		Book b = new Book();
		System.out.println(b.author);
		System.out.println(b.title);
		System.out.println(b.price);
		
		Book b1 = new Book("title","author",1000);
		System.out.println(b1.author);
		System.out.println(b1.title);
		System.out.println(b1.price);
	}
}
