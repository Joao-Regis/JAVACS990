import java.util.Scanner;

public class ConversionProgram {

	
	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		int distanceMeters;
		int choice;
		
		System.out.println("Enter your distance in meters:");
		distanceMeters = keyboard.nextInt();
		
		do
		{
			menu();
			//System.out.println("Select an option: 1 through 4.");
			choice = keyboard.nextInt();
		
			while (choice < 1 || choice > 4)
			{
				System.out.println("Invalid choice, Reenter a valid choice");
				menu();
				choice = keyboard.nextInt();
			}
		
			
			switch(choice)
			{
				case 1: showKilometers(distanceMeters);
						break;
				case 2: showInches(distanceMeters);
						break;
				case 3: showFeet(distanceMeters);
						break;
				case 4: System.out.println("Thank you, the program will now end");
						System.exit(0);
						break;
			}
		
		}while (choice !=4);

		System.out.println("\n");
		
		keyboard.close();
	}
	
	
	
	public static void menu()
	{
		System.out.println("1. Convert to kilometers");
		System.out.println("2. Convert to inches");
		System.out.println("3. Convert to feet");
		System.out.println("4. Quit the program");
	}
	
	
	public static void showKilometers(int meters)
	{
		double kilometers = meters * 0.001;
		System.out.printf(meters + " meters is %.1f " +
							"kilometers.", kilometers);
		System.out.println("\n");
	}
	
	
	public static void showInches(int meters)
	{
		double inches = meters * 39.37;
		System.out.printf(meters + " meters is %.1f " +
							"inches.", inches);
		System.out.println("\n");
	}
	
	
	public static void showFeet(int meters)
	{
		double feet = meters * 3.281;
		System.out.printf(meters + " meters is %.1f " +
							"feet.", feet);
		System.out.println("\n");
	}
	
	
}
