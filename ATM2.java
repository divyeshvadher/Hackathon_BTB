package ATM_Machine;

import java.util.Scanner;

class Customer{
    private String acc_no;
    private String pin;
    private double balance;

    public Customer(String acc_no, String pin, double balance) {
        super();
        this.acc_no = acc_no;
        this.pin = pin;
        this.balance = balance;
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
    public void withdrawCash(int amount1){
        if(amount1 <= cust1.getBalance()){
            cust1.setBalance(cust1.getBalance() - amount1);

            System.out.println("Withdrawn Completed. New Balance is : " + cust1.getBalance());
        }
        else{

            System.out.println("Transaction Canceled due to insufficient balance.");
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
        if(amount > 0 && amount <= 1000){

                cust1.setBalance(cust1.getBalance() + amount);
                System.out.println("Deposit Completed. New Balance: " + cust1.getBalance());

        }else{
            System.out.println("Transaction Cancelled due to insufficient balance. Please retry.");
        }
    }
}
public class ATM2 {
    public static void main(String[] args) {
        Customer cust1 = new Customer("123456", "1224", 100);

        StandardAtm SA = new StandardAtm(cust1);

        boolean isDisabled = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number : ");
        String acc_no1 = sc.next();
        System.out.print("Enter PIN Number : ");
        String pin1 = sc.next();
        if (SA.accessAcc(acc_no1, pin1) == true) {
            System.out.println("Welcome, Your Account Balance is : " + cust1.getBalance());

            /*
               for deposit money press 1.
               for withdrawal money press 2.
            */

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
                WA.withdrawCash(amount1);
            }
            else{
                System.out.println("Wrong Input !");
            }
        } else {
            System.out.println("Invalid Account Number & PIN !");
            for (int count = 0; count < 2; count++) {
                System.out.print("Enter account number : ");
                acc_no1 = sc.next();
                System.out.print("Enter PIN number : ");
                pin1 = sc.next();
                if (SA.accessAcc(acc_no1, pin1) == true) {
                    System.out.println("Welcome, Your Account Balance is : " + cust1.getBalance());

            /*
               for deposit money press 1.
               for withdrawal money press 2.
            */
                    // Scanner sca =new Scanner(System.in);
                    System.out.println("Please select any one.\n" +
                            "1.Deposit Money.\n" +
                            "2.Withdrawal Money.\n");
                    int press = sc.nextInt();
                    if (press == 1) {
                        System.out.print("Enter Deposit Amount : ");
                        int amount = sc.nextInt();
                        DepositAtm DA = new DepositAtm(cust1);
                        DA.depositCash(amount);
                    } else if (press == 2) {
                        System.out.println("Enter withdrawal Amount : ");
                        int amount1 = sc.nextInt();
                        WithDrawAtm WA = new WithDrawAtm(cust1);
                        WA.withdrawCash(amount1);
                    } else {
                        System.out.println("Wrong Input !");
                    }
                    break;
                }else{
                    System.out.println("Invalid Account Number & PIN !");
                    isDisabled = true;
                }

            }
            if(isDisabled){
                System.out.println("Your account is disabled !");
            }



        }

    }

}

