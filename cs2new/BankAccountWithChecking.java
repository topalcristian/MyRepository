import java.lang.IllegalArgumentException;

public class BankAccountWithChecking {

    private double balance;

    public BankAccountWithChecking(double amount) throws IllegalArgumentException {
        balance = amount;
        // if balance is negative -> exception
        if (balance < 0) {
            throw new IllegalArgumentException("Your balance is negative!");
        }
    }

    public void deposit(double amount) throws IllegalArgumentException {
        balance += amount;
        // if deposit is negative -> exception
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot deposit a negative amount!");
        }
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        // if you withdraw a greater amount of money than you have on you bankaccount -> exception
        if (amount > balance) {
            throw new IllegalArgumentException("You withdraw more money than you have on your bank account!");
        }
        balance = balance - amount;
    }

    public static void main(String[] args) {

        try {
            // balance exception
            BankAccountWithChecking account1 = new BankAccountWithChecking(-200);
            account1.deposit(20);
            account1.withdraw(20);
        } catch (IllegalArgumentException h) {
            System.out.println(h);
        }
        try {
            // deposit exception
            BankAccountWithChecking account1 = new BankAccountWithChecking(200);
            account1.deposit(-20);
            account1.withdraw(20);
        } catch (IllegalArgumentException h) {
            System.out.println(h);
        }
        try {
            // withdraw exception
            BankAccountWithChecking account1 = new BankAccountWithChecking(200);
            account1.deposit(20);
            account1.withdraw(2000);
        } catch (IllegalArgumentException h) {
            System.out.println(h);
        }
    }
}


