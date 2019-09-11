import java.util.Scanner;

public class InternetServiceProvider {

	public static void main(String[] args) {
		String subPackage;
		double hoursUsed;
		double hoursAdjusted = 0;
		double totalCharge;
		double packageA = 9.95;
		double packageB = 13.95;
		double packageC = 19.95;
		double packageAincluded = 10.00;
		double packageBincluded = 20.00;
		double packageAhourly = 2.00;
		double packageBhourly = 1.00;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the letter of the package purchased:");
		subPackage = keyboard.nextLine();
		
		System.out.println("Enter the number of hours that were used:");
		hoursUsed = keyboard.nextDouble();
		
		switch(subPackage)
		{
			case "a":
			case "A":
				if (hoursUsed > packageAincluded)
				{
					hoursAdjusted = hoursUsed - packageAincluded;
					totalCharge = packageA + (hoursAdjusted * packageAhourly);
				}
				else
				{
					totalCharge = packageA;
				}
				System.out.println("Your total charges are $" + totalCharge);
				break;
			
			case "b":
			case "B":
				if (hoursUsed > packageBincluded)
				{
					hoursAdjusted = hoursUsed - packageBincluded;
					totalCharge = packageA + (hoursAdjusted * packageAhourly);
				}
				else
				{
					totalCharge = packageB;
				}
				System.out.println("Your total charges are $" + totalCharge);
				break;
				
			case "c":
			case "C":
				totalCharge = packageC;
				System.out.println("Your total charges are $" + totalCharge);
				break;
			
			default:
				System.out.println("That package input was not an option.");
				break;
		}
		
		
		
	}

}
