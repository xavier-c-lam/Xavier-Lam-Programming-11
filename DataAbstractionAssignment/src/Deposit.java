import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //Requires: nothing
        //Modifies: nothing
        //Effects: returns string of the deposit with amount date and account
        return "Deposit of: $"+amount+" Date: "+date+" into account: "+account;
    }
}
