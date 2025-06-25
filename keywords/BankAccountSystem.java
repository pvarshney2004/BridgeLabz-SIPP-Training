package keywords;

public class BankAccountSystem {
	static String bankName = "BOB Bank";
	static int totalAccounts = 0;
	String accountHolderName;
	final int accountNumber;
	
	static void getTotalAccounts() {
		System.out.println("Total accounts: "+ totalAccounts);
	}
	public BankAccountSystem(String accountHolderName, int accountNumber) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		totalAccounts++;
	}
	
	public void displayAccountdetails() {
		System.out.println(accountHolderName + " " + accountNumber + " " + bankName);
	}
	
	public static void main(String[] args) {
		BankAccountSystem account1 = new BankAccountSystem("Prashant", 54735622);
		if(account1 instanceof BankAccountSystem) {
			account1.displayAccountdetails();
		}
		
		
		

	}
}
