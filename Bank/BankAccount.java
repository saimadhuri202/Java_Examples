package Bank;

public class BankAccount{
    private double balance;
    
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public void getBalance(){
        System.out.println("Balance is " + balance);
    }
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        acc1.deposit(10000);
        acc1.withdraw(500);
        acc1.getBalance();
    }
}