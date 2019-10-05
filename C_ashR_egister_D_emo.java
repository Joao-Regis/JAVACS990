import java.util.Scanner;

public class CashRegisterDemo 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner (System.in);
		
		String itemDescription;
		double itemPrice;
		int quantityAvail;
		int quantityDesired;
		
		final double SALESTAX = 0.06;
		
		double tax;
		double subTotal;
        
		System.out.println("We need information about the"
        		+ " retail item.");
        System.out.print("What is the name of the item?");
        itemDescription = keyboard.nextLine();
        
        System.out.print(" How many units are available?");
        quantityAvail = keyboard.nextInt();
        while(quantityAvail < 0)
        {
        	System.out.println(" Invalid Entry. Please try again.");
        	quantityAvail = keyboard.nextInt();
        }
        
        System.out.print(" How much does the item cost per unit?");
        itemPrice = keyboard.nextDouble();
        while(itemPrice <= 0)
        {
        	System.out.println(" Invalid Entry. Please try again.");
        	itemPrice = keyboard.nextDouble();
        }
        
        System.out.print(" How many items are you going to purchase?");
        quantityDesired = keyboard.nextInt();
        while(quantityDesired <= 0)
        {
        	System.out.println(" Invalid Entry. Please try again.");
        	quantityDesired = keyboard.nextInt();
        }
        
        
        RetailItem shopping = new RetailItem(itemDescription, quantityAvail, itemPrice);
        
        CashRegister checkout = new CashRegister(shopping, quantityDesired);
        
        subTotal = checkout.getSubtotal();
        
        System.out.println("Subtotal: " + subTotal);
        
        tax = subTotal * SALESTAX;
        
        System.out.printf("Tax: %.1f\n", tax);
        System.out.println("Total: " + (subTotal + tax));        
        
        keyboard.close();
	}	
	
	
	
}

class CashRegister{
	
	
	int amountDesired;
	RetailItem shoppingFor;
	
    CashRegister(RetailItem objRetailItem, int qty)
    {
    	shoppingFor = objRetailItem;
    	amountDesired = qty;
    }

    public double getSubtotal()
    {
        return amountDesired * shoppingFor.price;
    }
    
    
    
    
}

class RetailItem {
    String description = "";
    int unitsOnHand;
    double price;

    RetailItem(String aDescr, int aNumOfUnits, double aPrice) 
    {
        description = aDescr;
        unitsOnHand = aNumOfUnits;
        price = aPrice;
    }

    
    public void setDescription(String aDescr)
    {
        description = aDescr;
    }
        
    public void setUnitsOnHand(int aNumOfUnits)
    {
        unitsOnHand = aNumOfUnits;
    }

        public void setPrice(double aPrice)
    {
        price = aPrice;
    }

    
    public String getDescription()
    {
        return description;
    }

    public int getUnitsOnHand()
    {
        return unitsOnHand;
    }

    public double getPrice()
    {
        return price;
    }

}



