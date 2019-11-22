/**
 * SavingsAccount
 */
public class SavingsAccount extends BankAccount
{
    boolean accntStatus;



    public SavingsAccount(double balance, 
                            int annualInterestRate) 
    {
        super(balance, annualInterestRate);
        if(balance > 25.0)
        {
            this.accntStatus = true;
        }
        else
        {
            this.accntStatus = false;
        }
        
    }


    public void withdraw(double withdrawalAmount)
    {
        if(accntStatus)
        {
            
            super.withdraw(withdrawalAmount);
            if(getBalance() < 25)
            {
                setAccntStatus(false);
                System.out.println("Your balance is less than minimum balance." +
                                    " Your account is now INACTIVE ");
            }

            if(getNumOfWithdrawalsThisMonth() > 4)
            {
                setBalance(getBalance() - 1);
                System.out.println("You have exceeded monthly limit of withdrawals." +
					                " Fee of $1 charged\n");
            }
            
            /* super.withdraw(withdrawalAmount);
            if(getBalance() <25.0)
            {
                accntStatus = false;
            } */
            else
            {
                //System.out.println("your balance is " + getBalance());
            }

            
        }
        else
        {
            System.out.println("Error: Your account is INACTIVE");
        }

    }



    public void deposit(double amount)
    {
        super.deposit(amount);
        if(getBalance() > 25)
        {
            setAccntStatus(true);
        }
    }



    public void monthlyProcess()
    {
        double monServCharges;

        super.monthlyProcess();
		System.out.printf("Your Balance after Monthly process is: %.2f\n", getBalance());
        if (getBalance() < 25) 
        {
			setAccntStatus(false);
        }
        /* if(getNumOfWithdrawalsThisMonth() > 4)
        {
            monServCharges = getmonthlyServiceCharges();
            setmonthlyServiceCharges(monServCharges + (getNumOfWithdrawalsThisMonth() - 4));
            super.monthlyProcess();
            //System.out.println("Your Balance after Monthly process is: " + getBalance());
            setmonthlyServiceCharges(monServCharges);
            System.out.println("Your Balance after Monthly process is: " + getBalance());
        }
        else
        {
            super.monthlyProcess();
            System.out.println("Your Balance after Monthly process is: " + getBalance());
        } */
    }


    public boolean isAccntStatus() {
        return accntStatus;
    }

    public void setAccntStatus(boolean accntStatus) {
        this.accntStatus = accntStatus;
    }

    

    
    
}
