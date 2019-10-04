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
        
		System.out.println("We need information about the"
        		+ "retail item.");
        System.out.println("What is the name of the item?");
        itemDescription = keyboard.nextLine();
        
        System.out.println("How many units are available?");
        quantityAvail = keyboard.nextInt();
        
        System.out.println("How much does the item cost per unit?");
        itemPrice = keyboard.nextDouble();
        
        System.out.println("How many items are you going to purchase?");
        quantityDesired = keyboard.nextInt();

        RetailItem shopping = new RetailItem(itemDescription, quantityAvail, itemPrice);
        
        CashRegister checkout = new CashRegister(shopping, quantityDesired);
        
        System.out.println("Subtotal:" + "???");
        System.out.println("Tax:" + "???");
        System.out.println("Total:" + "???");
        
        
        
        keyboard.close();
	}	
	
	
	
}

class CashRegister{
	
	final double SALESTAX = 0.06;
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



