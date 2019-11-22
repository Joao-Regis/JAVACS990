import java.util.Scanner;

/**
 * SavingsAccountDemo
 */
public class SavingsAccountDemo 
{
    static Scanner keyboard = new Scanner (System.in);
    public static void main(String[] args) 
    {   
        SavingsAccount theSavingsAccount;

        //SavingsAccount saveAccount = new SavingsAccount();
        theSavingsAccount = enterBalAndIntRate();
        runBankingMenu(theSavingsAccount);

    }

    
    
    
    static public void runBankingMenu(SavingsAccount theSavingsAccount)
    {
        String menuSelection;

        
        do
        {
            System.out.println("Enter D to deposit");
            System.out.println("Enter W to Withdraw");
            System.out.println("Enter B for Balance");
            System.out.println("Enter M for Monthly Process");
            System.out.println("Enter E to Exit");
            menuSelection = keyboard.nextLine();
            runSelection(menuSelection, theSavingsAccount);
        }while (menuSelection !="E");

    }


    
    
    
    public static void processSelection()
    {

    }


    
    
    
    public static void runSelection(String slctn, SavingsAccount theSavingsAccount)
    {
        switch (slctn) 
        {
            case "d":
            case "D":
                validateDeposit(theSavingsAccount);
                //theSavingsAccount.deposit(depositAmount);
                /* System.out.print("Enter the amount you want to Deposit : $");
                double depositAmount = keyboard.nextDouble();
                while(depositAmount < 0)
                {
                    System.out.println("Error: Must enter positive value");
                    displayMenu();
                }
                theSavingsAccount.deposit(depositAmount); */
                //processDeposit(theSavingsAccount);
                break;
            
            case "w":
            case "W":
                validateWithdrawal(theSavingsAccount);
                
                //theSavingsAccount.withdraw(withdrawAmount);
                
                /* System.out.println("Enter the amount you want to withdraw : $");
                double withdrawalAmount = keyboard.nextDouble();
                while(withdrawalAmount < 0)
                {
                    System.out.println("Must enter positive value\n");
                    displayMenu();
                }
                theSavingsAccount.withdraw(withdrawalAmount); */
                //processWithdraw(theSavingsAccount);
                break;
            
            
            case "b":
            case "B":
                double balance = theSavingsAccount.getBalance();
                System.out.printf("Your Balance is: %.2f\n", balance);
                break;
            
            
            case "m":
            case "M":
                theSavingsAccount.monthlyProcess();
                break;
            
            case "e":
            case "E":
                System.out.printf("Balance : $%.2f\n", theSavingsAccount.getBalance());
                System.out.println("Thank you. Bye");
                System.exit(0);
                break;
            
            
            default:
                System.out.println("Invalid choice. Try again\n");
                
            }
    }





    public static void validateDeposit(SavingsAccount theSavingsAccount)
    {
        System.out.print("Enter the amount you want to Deposit :$");
        double depositAmount = keyboard.nextDouble();
        keyboard.nextLine();
        if (depositAmount > 0)
        {
            theSavingsAccount.deposit(depositAmount);
        }
        else
        {
            System.out.println("Error: Must enter positive value\n");
            //displayMenu();
        }
        
        //return depositAmount;
    }


    public static void validateWithdrawal(SavingsAccount theSavingsAccount)
    {
        if(theSavingsAccount.accntStatus)
        {
            System.out.print("Enter the amount you want to withdraw :$");
            double withdrawAmount = keyboard.nextDouble();
            keyboard.nextLine();
            if (withdrawAmount > 0)
            {
                theSavingsAccount.withdraw(withdrawAmount);
            }
            else
            {
                System.out.println("Error: Must enter positive value\n");
                //displayMenu();
            }
        }
        else
        {
            System.out.println("Error: Your account is INACTIVE");
        }
    }








    public static SavingsAccount enterBalAndIntRate()
    {
        double openingBalance;
        int interestRate;
        SavingsAccount aSavingsAccount;

        System.out.print("Enter beginning balance :$");
        openingBalance = keyboard.nextDouble();
        while(openingBalance < 0)
        {
            System.out.println("Invalid Entry. Must be or greater");
            System.out.print("Enter beginning balance :$");
            openingBalance = keyboard.nextDouble();
        }
        
        System.out.print("Enter interest rate(whole number) :%");
        interestRate = keyboard.nextInt();
        keyboard.nextLine();
        while(interestRate < 0)
        {
            System.out.println("Invalid Entry. Must be or greater");
            System.out.print("Enter interest rate(whole number) :%");
            interestRate = keyboard.nextInt();
            keyboard.nextLine();
        }

        aSavingsAccount = 
                    new SavingsAccount(openingBalance, interestRate);
        

        
        //runBankingMenu();

        return aSavingsAccount;
    }

}

