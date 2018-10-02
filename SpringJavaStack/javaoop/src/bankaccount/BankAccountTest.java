package bankaccount;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount acctOne = new BankAccount();
		
		//printout account number
		System.out.println("What's my account number? : "+acctOne.getAccountNumber());
		
		//check saving and checking balance
		System.out.println("What's my checking? : "+acctOne.getCheckingBalance());
		System.out.println("What's my saving? : "+acctOne.getSavingBalance());
		
		//check total amount (saving + checking)
		System.out.println("What my total accounts balance? : "+BankAccount.moneyTotal());
		
		//depositing money into saving & checking
		System.out.println("Depositing $200 into my CHECKING account...");
		acctOne.deposit("checking", 200);
		System.out.println("Depositing $150 into my SAVING account...");
		acctOne.deposit("saving", 150);
		
		
		//check balance (saving + checking + both)
		System.out.println("What's my new checking? : "+acctOne.getCheckingBalance());
		System.out.println("What's my new saving? : "+acctOne.getSavingBalance());
		System.out.println("What my new total accounts balance? : "+BankAccount.moneyTotal());

		
		//withdrawal money from saving & checking
		System.out.println("Withdrawing $40 from my CHECKING account...");
		acctOne.withdraw("checking", 40);
		System.out.println("Withdrawing $60 from my SAVING account...");
		acctOne.withdraw("saving", 60);
		
		//check balance (saving + checking + both)
		System.out.println("What's my new checking after withdrawl? : "+acctOne.getCheckingBalance());
		System.out.println("What's my saving after withdrawl? : "+acctOne.getSavingBalance());
		System.out.println("What my new total accounts balance? : "+BankAccount.moneyTotal());

	}
}
