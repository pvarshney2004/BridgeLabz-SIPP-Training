package e_wallet;

public class Transaction {
	private String receiver;
	double amount;
	public Transaction(String receiver, double amount) {
		this.receiver = receiver;
		this.amount = amount;
	}
}
