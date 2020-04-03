import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        name = "";
        accountNumber = 0;
        checkBalance = 0.0;
        savingBalance = 0.0;
        savingRate = 0.0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        //create default constructor
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        savingRate = 0.0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();

    }

    public double deposit(double amt, Date date, String account){
        //Requires: double amt > 0, Date date, String account
        //Modifies: this, deposits
        //Effects: adds to a deposit to ArrayList with specified account and current date
        if(account.equals(Customer.CHECKING) && amt > 0.0){
            checkBalance += amt;
        }
        else if(account.equals(Customer.SAVING) && amt > 0.0){
            savingBalance += amt;
        }
        deposits.add(new Deposit(amt, date, account));

        return 0;
    }
    public double withdraw(double amt, Date date, String account){
        //Requires: double amt > 0, Date date, String account
        //Modifies: this, withdraws
        //Effects: adds to a withdraw to ArrayList with specified account and current date
        if(account.equals(Customer.CHECKING) && amt > 0 && amt <= checkBalance){
            checkBalance -= amt;

        }
        else if(account.equals(Customer.SAVING) && amt > 0 && amt <= savingBalance){
            savingBalance -= amt;
        }
        else if(checkOverdraft(amt, account)){
            if(account.equals(Customer.CHECKING) && amt > 0) {
                checkBalance -= (amt - OVERDRAFT);
                System.out.println("Overdraft. $100 fee charged.");
            }
            else if(account.equals(Customer.SAVING) && amt > 0) {
                savingBalance -= (amt - OVERDRAFT);
                System.out.println("Overdraft. $100 fee charged.");
            }

        }

        withdraws.add(new Withdraw(amt, date, account));

        return 0;
    }

    private boolean checkOverdraft(double amt, String account){
        if(account == CHECKING){
            if(amt>checkBalance){
                return true;
            }
        }
        else if(account == SAVING){
            if(amt>savingBalance){
                return true;
            }
        }
            return false;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }
}
