package e_wallet;

import java.util.*;

public class User {
	String name;
	String email;
	String password;
	private Wallet wallet;
	private static List<String> users = new ArrayList<>();

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public Wallet getWallet() {
		return wallet;
	}


	public static void getAllUsers() {
		for (String u : users) {
			System.out.println(u);
		}
	}

	public void registerUser() {
		if (name.length() < 3) {
			System.out.println("Username should be atleast 3 characters long.");
			return;
		}
		if (password.length() < 6) {
			System.out.println("password should be atleast 6 characters long");
			return;
		}
		users.add(name + "-" + email);
		System.out.println(name+" register successfully");
		this.wallet = new Wallet();
		System.out.println();
	}
	
	public static void main(String[] args) {
		User u1 = new User("alice", "alice@gmail.com", "12345678");
		u1.registerUser();
//		
		System.out.println(u1.getWallet().getBalance());
//		
		System.out.println();
//		
		User u2 = new User("bob", "bob@gmail.com", "1234567890");
		u2.registerUser();
//		
		u1.getWallet().transferTo(u2, 500);
		System.out.println(u2.getWallet().getBalance());
		System.out.println(u1.getWallet().getBalance());
		
	}

}
