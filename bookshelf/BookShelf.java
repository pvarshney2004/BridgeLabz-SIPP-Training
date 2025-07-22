package bookshelf;
import java.util.*;
class pair{
	String a;
	String b;
	public pair(String a, String b) {
		this.a = a;
		this.b = b;
	}
	public String toString() {
		return this.a + "->" + this.b;
	}
}

public class BookShelf {
	HashMap<String,HashSet<String>> authorMap; // for author
	HashMap<String,HashSet<String>> genreMap; // for genre
	List<pair> borrowedBooks = new ArrayList<>();
    
	BookShelf(){
		authorMap = new HashMap<>();
		genreMap = new HashMap<>();
	}
	
	public void addBookbyGenre(String genre, String book) {
		if(genreMap.containsKey(genre)==false) {
			genreMap.put(genre, new HashSet<>());
		}
		genreMap.get(genre).add(book);
	}
	
	public void addBookbyAuthor(String author, String book) {
		if(authorMap.containsKey(author)==false) {
			authorMap.put(author, new HashSet<>());
		}
		authorMap.get(author).add(book);
	}
	
	public void getAllBooksbyAuthor(String author) {
		System.out.println(authorMap.getOrDefault(author, new HashSet<>()));
	}
	
	public void getAllBooksbyGenre(String genre) {
		System.out.println(genreMap.getOrDefault(genre, new HashSet<>()));
	}
	
	public void deleteBookinGenreCatalog(String genre, String book) {
		if(genreMap.containsKey(genre)) {
			genreMap.get(genre).remove(book);
		}
		else {
			System.out.println("This book of this genre is not available");
		}
	}
	
	public void deleteBookinAuthorCatalog(String author, String book) {
		if(genreMap.containsKey(author)) {
			genreMap.get(author).remove(book);
		}
		else {
			System.out.println("This book of this author is not available");
		}
	}
	
	public void borrowBookbyGenre(String genre, String book) {
		if(genreMap.containsKey(genre)==false) {
			System.out.println("This genre type is not present");
			return;
		}
		else {
			genreMap.get(genre).remove(book);
			borrowedBooks.add(new pair(genre,book));
			System.out.println("Book borrowed");
		}
	}
	
	public static void main(String[] args) {
		BookShelf shelf = new BookShelf();
        shelf.addBookbyGenre("Science Fiction", "Dune");
        shelf.addBookbyGenre("Science Fiction", "Neuromancer");
        shelf.addBookbyAuthor("Isaac Asimov", "Foundation");
        shelf.addBookbyAuthor("Frank Herbert", "Dune");

        System.out.println("Books in Genre 'Science Fiction':");
        shelf.getAllBooksbyGenre("Science Fiction");

        System.out.println("Books by 'Frank Herbert':");
        shelf.getAllBooksbyAuthor("Frank Herbert");
        
        shelf.borrowBookbyGenre("Science Fiction", "Dune");
        System.out.println(shelf.borrowedBooks);
		
	}
	
	
	
}
