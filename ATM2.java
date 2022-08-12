package ATM_Machine;

import java.util.Scanner;

class Customer{
    private String acc_no;
    private String pin;
    private double balance;
    private int attempt;

    public Customer(String acc_no, String pin, double balance, int attempt) {
        super();
        this.acc_no = acc_no;
        this.pin = pin;
        this.balance = balance;
        this.attempt = attempt;
    }
    public int getAttempt(){
        return attempt;
    }
    public void setAttempt(int attempt){
        this.attempt = attempt;
    }
    public String getAccountNo(){
        return acc_no;
    }
    public void setAccountNo(String acc_no){
        this.acc_no = acc_no;
    }
    public String getPin(){
        return pin;
    }
    public void setPin(String pin){
        this.pin = pin;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
class StandardAtm{
    private Customer cust1;

    Boolean accessed = false;

    //constructor
    public StandardAtm(Customer customer){
        this.cust1 = customer;
    }


    public void displayBalance(){
        if(accessed){
            System.out.println("Balance : " + cust1.getBalance()); //display balance
        }
    }

    public boolean accessAcc(String acc_no1, String pin1){
        if(cust1.getAccountNo().equals(acc_no1) && cust1.getPin().equals(pin1)){

            return true;
        }
        else{
            return false;
        }

    }
}
class WithDrawAtm extends StandardAtm{
    private Customer cust1;
    private double balance;
    public WithDrawAtm(Customer customer) {
        super(customer);
        this.cust1 = customer;
        this.balance = balance;
    }
    public double withdrawCash(int amount1){
        if(amount1 <= cust1.getBalance()){
            cust1.setBalance(cust1.getBalance() - amount1);
            return cust1.getBalance();
            //System.out.println("Withdrawn Completed. New Balance is : " + cust1.getBalance());
        }
        else{
            return 0;
            //System.out.println("Transaction Canceled due to insufficient balance.");
        }
    }
}
class DepositAtm extends StandardAtm{

    private Customer cust1;
    private double balance;
    //constructor
    public DepositAtm(Customer customer) {
        super(customer);
        this.cust1 = customer;
        this.balance = balance;

    }
    public void depositCash(int amount){
        if(amount >= 0 && amount <= 100 && cust1.getBalance() >= amount){
            if(cust1.getBalance() >= amount){
                cust1.setBalance(cust1.getBalance() + amount);
                System.out.println("Deposit Completed. New Balance: " + cust1.getBalance());
            }
        }else{
            System.out.println("Transaction Cancelled due to insufficient balance. Please retry.");
        }
    }
}
public class ATM2 {
    public static void main(String[] args) {
        Customer cust1 = new Customer("123456", "1224", 100, 0);

        StandardAtm SA = new StandardAtm(cust1);


        if (SA.accessAcc("123456", "1224") == true) {
            System.out.println("Welcome, Your Account Balance is : " + cust1.getBalance());

            /*
               for deposit money press 1.
               for withdrawal money press 2.
            */
            Scanner sc =new Scanner(System.in);
            System.out.println("Please select any one.\n" +
                                "1.Deposit Money.\n" +
                                "2.Withdrawal Money.\n");
            int press = sc.nextInt();
            if(press == 1) {
                System.out.print("Enter Deposit Amount : ");
                int amount = sc.nextInt();
                DepositAtm DA = new DepositAtm(cust1);
                DA.depositCash(amount);
            }
            else if(press == 2) {
                System.out.println("Enter withdrawal Amount : ");
                int amount1 = sc.nextInt();
                WithDrawAtm WA = new WithDrawAtm(cust1);
                System.out.println("Withdrawn completed. New Balance: " + WA.withdrawCash(amount1));
            }
            else{
                System.out.println("Wrong Input !");
            }
        } else {
            System.out.println("Invalid Account Number & PIN !");

        }

    }

}

