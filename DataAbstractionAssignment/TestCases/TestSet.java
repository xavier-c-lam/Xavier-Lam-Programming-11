import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class TestSet {
    Customer testCustomer;
    Deposit testDep;
    Withdraw testWith;


    @Before
    public void setup(){
        testCustomer = new Customer("test",0,10.0,10.0);



    }
    @Test
    public void testDeposit() {
        //test if deposit adds to balance
        testCustomer.deposit(10.0, new Date(), Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(), 20.0);
        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        assertEquals(testCustomer.getSavingBalance(), 20.0);

    }
    @Test
    public void testDepositNegative(){
        //test for negative numbers, should not change balance
        testCustomer.deposit(-10.0, new Date() ,Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(),10.0);
        testCustomer.deposit(-10.0, new Date(),Customer.SAVING );
        assertEquals(testCustomer.getSavingBalance(), 10.0);

    }

    @Test
    public void testWithdraw(){
        //test if withdraw will take money out
        testCustomer.withdraw(10.0, new Date() ,Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(),0.0);
        testCustomer.withdraw(10.0, new Date(),Customer.SAVING);
        assertEquals(testCustomer.getSavingBalance(), 0.0);

    }

    @Test
    public void testWithdrawNegative() {
        //test for negative number, should not change balance
        testCustomer.withdraw(-10.0, new Date(), Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(), 10.0);
        testCustomer.withdraw(-10.0, new Date(), Customer.SAVING);
        assertEquals(testCustomer.getSavingBalance(), 10.0);

    }
    @Test
    public void testWithdrawOverdraft() {
        //tests that overdraft fee is charged when going under 0/taking more than you have in your balance
        testCustomer.withdraw(20.0, new Date(), Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(), -110.0);
        testCustomer.withdraw(20.0, new Date(), Customer.CHECKING);
        assertEquals(testCustomer.getCheckBalance(), -230.0);

        testCustomer.withdraw(20.0, new Date(), Customer.SAVING);
        assertEquals(testCustomer.getSavingBalance(), -110.0);
    }

    @Test
    public void testDepositToString() {
        //tests for expected
        testDep = new Deposit(1,new Date(),Customer.CHECKING);
        String expected = "Deposit of: $1.0 Date: "+ new Date().toString() + " into account: Checking"; // put the expected value here
        assertEquals(expected, testDep.toString());
    }

    @Test
    public void testWithdrawToString() {
        //tests for expected string
        testWith = new Withdraw(1,new Date(),Customer.SAVING);
        String expected = "Withdraw of: $1.0 Date: "+ new Date().toString() + " from account: Saving"; // put the expected value here
        assertEquals(expected, testWith.toString());
    }



    //Deposit.toString()
    //must match expected string

    //Withdraw.toString()
    //must match expected string


    //Customer.deposit()
    //CANNOT BE NEGATIVE


    //Customer.withdraw()
    //CANNOT BE NEGATIVE
    //CHARGE OVERDRAFT FEE WHEN BELOW ZERO


    //Deposit to string:
    //Deposit: cannot be negative

    //Withdraw to string:
    //Withdraw: cannot be negative




}

