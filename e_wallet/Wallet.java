package e_wallet;

import java.util.*;

public class Wallet implements Transferrable {
	private double balance;
	private List<Transaction> transactions = new ArrayList<>();

	public Wallet() {
		double bonus = 500;
		this.balance = bonus;
		System.out.println("Your wallet initializes with a bonus amount of 500rs.");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		if (amount < 0) {
			System.out.println("Amount cannot be negative");
			return;
		}
		this.balance = amount;
	}

	void addTransaction(Transaction t) {
		transactions.add(t);
	}

	@Override
	public void transferTo(User receiver, double amount) {
		// TODO Auto-generated method stub
		if (amount > getBalance()) {
			System.out.println("amount cannot be tranfered");
			return;
		}
		setBalance(getBalance() - amount);
		double x = receiver.getWallet().getBalance();
		receiver.getWallet().setBalance(amount+x);
		addTransaction(new Transaction(receiver.getName(), amount));
		System.out.println("transfered " + amount + " to " + receiver.getName());
	}
}
