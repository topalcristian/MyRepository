public class TimeDepositAccount extends SavingsAccount {


	private double interestRate;
	// particular number of months in which you promised to leave your money on the account 
	private int monthspromised;
	// penalty that will be deducted for early withdraw
	private double penaltyforwithdraw;
	
	public TimeDepositAccount(double rate, int months, double penalty) { 
		
		//rate from Savingsaccount
		super(rate);
		monthspromised = months;		
		penaltyforwithdraw = penalty;
	}
	
	public void addInterest()
	{ 	
		// deuduct month 
	    monthspromised--;
	    // get addInterest method from SavingsAccount
	    super.addInterest();
      
	} 

	public void withdraw(double amount){

		super.withdraw(amount);


			// if you have more or exactly one month left, you get charged 

		if(monthspromised > 0){
			//deduct the penaltyfee from the amount 
			
			super.withdraw(penaltyforwithdraw);
		}
	}

	public static void main(String [] args){

		TimeDepositAccount a = new TimeDepositAccount(0.2,5,10);
		a.withdraw(100);
		System.out.println(a.getBalance());	
	}
}