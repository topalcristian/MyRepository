public class Bankaccount   
   {

      // initiliaze variable for balance 
   protected double balance;

   
   public Bankaccount(double balance){
      // assigning balance to bankaccount   
      this.balance = balance;       
   }

   public Bankaccount(){
      // initialAmount - starting point 
      this(1000);
   
   }

   public void deposit(double amount) {
      balance = balance + amount;
   }

   public void withdraw(double amount){
      balance = balance - amount;
   }

   
   // get and return height
   public double getBalance(){
     
      return balance;
   }

}