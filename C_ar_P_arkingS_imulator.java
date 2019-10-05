import java.util.Scanner;
public class ParkingCarSimulator 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in); 
		
		String offName;
		int badge;
		String make;
		String model;
		String color;
		String lic;
		int minOnCar;
		int minPurchased;
		double fineFirstHour = 25.0;
		double finePerHourAfter1stHour = 10.0;
		
		System.out.println("Enter the officer's name");
		offName = keyboard.nextLine();
		
		System.out.println("Enter the officer's badge number");
		badge = keyboard.nextInt();
		
		System.out.println("Enter the car's make");
		make = keyboard.nextLine();
		
		System.out.println("Enter the car's model");
		model = keyboard.nextLine();
		
		System.out.println("Enter the car's color");
		color = keyboard.nextLine();
		
		System.out.println("Enter the car's license number");
		lic = keyboard.nextLine();
		
		System.out.println("Enter minutes on car");
		minOnCar = keyboard.nextInt();
		
		System.out.println("Enter the number of" +
					"minutes purchased on the meter");
		minPurchased = keyboard.nextInt();
		
		
		minPurchased = keyboard.nextInt();
		
		keyboard.close();
	}

}
