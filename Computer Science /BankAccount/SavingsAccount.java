 public class SavingsAccount extends Bankaccount {

	private double interestRate;
	

	public SavingsAccount(double rate) { 
		
		interestRate = rate;
	}
	
	public void addInterest()
	{ 	

	double interest = getBalance()*interestRate / 100;
      
    deposit(interest);
      
	} 
}