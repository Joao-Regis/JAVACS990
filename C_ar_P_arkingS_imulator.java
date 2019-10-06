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
		
		keyboard.nextLine();
		
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
		
		
		
		ParkedCar automobile = new ParkedCar(make, model, color, lic, minOnCar);
		
		ParkingMeter theMeter = new ParkingMeter(minPurchased);
					
		PoliceOfficer copper = new PoliceOfficer(offName, badge, automobile, theMeter);
				
		ParkingTicket fine = new ParkingTicket(copper, automobile, theMeter);
		
		copper.checkExpiration(automobile, theMeter);
		
		keyboard.close();
	}
	
	

}


class ParkedCar
{
	String vehicleMake;
	String vehicleModel;
	String vehicleColor;
	String vehicleLic;
	int minOnCar;
	
	
	ParkedCar(String aMake, String aModel, String aColor, 
			String  aLic, int aTimeAmount)
	{
		vehicleMake = aMake;
		vehicleModel = aModel;
		vehicleColor = aColor;
		vehicleLic = aLic;
	}
	
	ParkedCar(ParkedCar copyOfCarObj)
	{
		
	}
}


class ParkingMeter
{
	int timePurchased;
	ParkingMeter(int timePaidFor)
	{
		timePurchased = timePaidFor;
	}
	
	ParkingMeter(ParkingMeter pmObjToBeCopied)
	{
		timePurchased = pmObjToBeCopied.timePurchased;
	}
}


class ParkingTicket
{
	ParkingTicket(PoliceOfficer objPO, ParkedCar objPC, ParkingMeter objPM)
	{
		
		
	}
	
	
	/*
	public ParkedCar getCarInfo()
	{
		return ???;
	}
	
	public double getFine()
	{
		return ???;
	}
	
	public PoliceOfficer getOfficerInfo()
	{
		return ???;
	}
	*/
}


class PoliceOfficer
{
	String offName;
	int badge;
	ParkedCar polOffsParkedCar;
	ParkingMeter polOffsParkingMeter;
	
	PoliceOfficer(String anOffName, int aBadgeNum, ParkedCar inspParkedCar, ParkingMeter inspParkingMeter)
	{
		offName = anOffName;
		badge = aBadgeNum;
		polOffsParkedCar = new ParkedCar(inspParkedCar);
		polOffsParkingMeter = new ParkingMeter(inspParkingMeter);
	}
	
	
	public boolean checkExpiration(ParkedCar aCar, ParkingMeter aMeter)
	{
		return ???;
	}
}














