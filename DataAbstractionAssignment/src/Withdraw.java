import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }


    public String toString(){
        //Requires: nothing
        //Modifies: nothing
        //Effects: returns string of the withdraw with amount date and account
        return "Withdraw of: $"+amount+" Date: "+date+" from account: "+account;
    }
}
