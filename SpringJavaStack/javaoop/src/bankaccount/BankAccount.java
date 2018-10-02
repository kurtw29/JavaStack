package bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int numberOfAccounts;
	private static int moneyTotal;
	
	private String randomAccount() {
		String acct = new String();
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			acct += r.nextInt(10);
		}
		return acct;
	};
	
	public BankAccount() {
		accountNumber = randomAccount();
		numberOfAccounts++;
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}

	public void deposit(String acctType, double amount) {
		if(acctType == "checking") {
			this.checkingBalance = this.getCheckingBalance() + amount;
		}else if(acctType == "saving") {
			this.savingBalance = this.getSavingBalance() + amount;
		}
		moneyTotal += amount;
	}
	
	public void withdraw(String acctType, double amount) {
		if(acctType == "checking") {
			if(amount <= this.getCheckingBalance()) {
				this.checkingBalance = this.getCheckingBalance() - amount;
			}else {
				System.out.println("Insufficient fund for withdrawl");
			}
		}else if(acctType == "saving") {
			if(amount <= this.getSavingBalance()) {
				this.savingBalance = this.getSavingBalance() - amount;
			}else {
				System.out.println("Insufficient fund for withdrawl");
			}
		}
		moneyTotal -= amount;
	}
	
	public static int moneyTotal() {
		return moneyTotal;
	}
	
}
