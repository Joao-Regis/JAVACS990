/**
 * BankAccount
 */
public abstract class BankAccount 
{
    double balance;
    int numOfDepositsThisMonth;
    int numOfWithdrawalsThisMonth;
    double annualInterestRate;
    double monthlyServiceCharges;



    public BankAccount(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;

    }


    public void deposit(double depositAmount)
    {
        balance = balance + depositAmount;
        numOfDepositsThisMonth++;
    }

    public void withdraw(double withdrawAmount)
    {
        if(balance < withdrawAmount)
        {
            System.out.println("ERROR: Transaction declined!! " +
            "This transaction will cause overdraft or zero " +
            "balance");
            //System.out.printf("Your Balance is: %.2f\n", balance);
        }
        else
        {
        balance = balance - withdrawAmount;
        numOfWithdrawalsThisMonth++;
        }
    }


    public void calcInterest()
    {
        double monthlyInterestRate = (annualInterestRate/100.0)/12.0;
        double monthlyIntererst = balance * monthlyInterestRate;
        balance = balance + monthlyIntererst; 
    }



    public void monthlyProcess()
    {
        balance = balance - monthlyServiceCharges;
        calcInterest();
        numOfDepositsThisMonth = 0;
        numOfWithdrawalsThisMonth = 0;
        monthlyServiceCharges = 0;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumOfDepositsThisMonth() {
        return numOfDepositsThisMonth;
    }

    public void setNumOfDepositsThisMonth(int numOfDepositsThisMonth) {
        this.numOfDepositsThisMonth = numOfDepositsThisMonth;
    }

    public int getNumOfWithdrawalsThisMonth() {
        return numOfWithdrawalsThisMonth;
    }

    public void setNumOfWithdrawals(int numOfWithdrawalsThisMonth) {
        this.numOfWithdrawalsThisMonth = numOfWithdrawalsThisMonth;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getmonthlyServiceCharges() {
        return monthlyServiceCharges;
    }

    public void setmonthlyServiceCharges(double monthlyServiceCharges) {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }

    
    
}
