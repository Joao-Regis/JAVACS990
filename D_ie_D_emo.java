import java.util.Random;

public class DieDemo {

	public static void main(String[] args) 
	{
		int compWins = 0;
		int userWins = 0;
		String winner = "";
		
		Die dieComp = new Die(6);
		Die dieUser = new Die(6);
		
		for(int i = 1; i <=10; i++) 
		{
			dieComp.roll();
			int compRoll = dieComp.getValue();
			dieUser.roll();
			int userRoll = dieUser.getValue();
			
			System.out.println("Roll #" + i + ":");
			System.out.println("The computer rolled a " + 
					compRoll + " and the user rolled a " + 
					userRoll);
			
			if (compRoll > userRoll)
			{
				compWins++;
				System.out.println("The computer won this round!");
			}
			else if (compRoll < userRoll)
			{
				userWins++;
				System.out.println("The user won this round!");
			}
			else if (compRoll == userRoll) 
			{
				System.out.println("Tie!");
			}
			System.out.println("\n");
		
		}
		
		if(compWins > userWins)
		{
			winner = "computer";
			System.out.println("The computer won a grand total of "+ 
					compWins + " times");
			System.out.println("The user won a grand total of "+ 
					userWins + " times");
		}
		else if(userWins > compWins) 
		{
			winner = "user";
			System.out.println("The computer won a grand total of "+ 
					compWins + " times");
			System.out.println("The user won a grand total of "+ 
					userWins + " times");
		}
		else if(compWins == userWins)
		{
			winner = "tie";
			System.out.println("There uwaser a tise, there is no grand winner!!! :(");
		}
		
		/*
		System.out.println("The computer won a grand total of "+ 
							compWins + " times");
		System.out.println("The user won a grand total of "+ userWins + 
							" times");
		
		System.out.println("The " + winner  + " is the grand winner!!!");
		*/
		
	}

}

class Die 
{
	private int sides;
	private int value;
	
	public Die(int numSides) 
	{
		sides = numSides;
		roll();
	}
	
	public void roll()
	{
		//Create a Random object
		Random rand = new Random();
		
		//Get a random value for the die.
		value = rand.nextInt(sides) + 1;
	}
	
	public int getSides()
	{
		return sides;
	}
	
	public int getValue()
	{
		return value;
	}
	
}
