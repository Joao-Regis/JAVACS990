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
		
		
		System.out.println("Enter the officer's name");
		offName = keyboard.nextLine();
		
		System.out.println("Enter officer's badge number");
		badge = keyboard.nextInt();
		
		keyboard.nextLine();
		
		System.out.println("Enter the car's make");
		make = keyboard.nextLine();
		
		System.out.println("Enter the car's model");
		model = keyboard.nextLine();
		
		System.out.println("Enter the car's color");
		color = keyboard.nextLine();
		
		System.out.println("Enter the car's liscense number");
		lic = keyboard.nextLine();
		
		System.out.println("Enter Minutes on car");
		minOnCar = keyboard.nextInt();
		
		System.out.println("Enter the number of " +
					"minutes purchased on the meter");
		minPurchased = keyboard.nextInt();
		
		
		
		ParkedCar automobile = new ParkedCar(make, model, color, lic, minOnCar);
		
		ParkingMeter theMeter = new ParkingMeter(minPurchased);
					
		PoliceOfficer copper = new PoliceOfficer(offName, badge, automobile, theMeter);
				
		//ParkingTicket fine = new ParkingTicket(copper, automobile, theMeter);
		
        copper.checkExpiration(automobile, theMeter);
        
        if (minOnCar > minPurchased)
            System.out.println(theTicket);
        else
            System.out.println("The car parking limits are valid");


		
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
		vehicleMake = copyOfCarObj.vehicleMake;
		vehicleModel = copyOfCarObj.vehicleModel;
		vehicleColor = copyOfCarObj.vehicleColor;
		vehicleLic = copyOfCarObj.vehicleLic;
		minOnCar = copyOfCarObj.minOnCar;
	}
    
    
    public void setVehMake(String aMake)
   {
      vehicleMake = aMake;
   }


   public void setVehModel(String aModel)
   {
      vehicleModel = aModel;
   }


   public void setVehColor(String aColor)
   {
      vehicleColor = aColor;
   }


   public void setVehLicNum(String aLicense)
   {
      vehicleLic = aLicense;
   }


   public void setVehMinOnCar(int aMinOnCar)
   {
      minOnCar= aMinOnCar;
   }


   public String getVehMake()
   {
      return vehicleMake;
   }
   
   public String getVehModel()
   {
      return vehicleModel;
   }

   
   public String getVehColor()
   {
      return vehicleColor;
   }


   public String getVehLicenseNumber()
   {
      return vehicleLic;
   }


   public int getVehMinOnCar()
   {
      return minOnCar;
   }


	public String toString()
	{
		String str = "Make: " + vehicleMake +
                "\nModel: " + vehicleModel +
                "\nColor: " + vehicleColor +
                "\nLicense Number: " + vehicleLic +
                "\nMinutes Parked: " + minOnCar;
   
		return str;
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
    
    public void setTimePurchased(int tPurchased)
    {
        timePurchased = tPurchased;
    }

    public int getTimePurchased()
    {
        return timePurchased;
    }
}


class ParkingTicket
{
    
    double fineFirstHour = 25.0;
	double finePerHourAfter1stHour = 10.0;
    
    PoliceOfficer ptsPolOff;
	ParkedCar ptsPrkdCr;
    ParkingMeter ptsPrkngMtr;
    


	ParkingTicket(ParkedCar objPC, ParkingMeter objPM)
	{
		//ptsPolOff = new PoliceOfficer(objPO);
		ptsPrkdCr = new ParkedCar(objPC);
		ptsPrkngMtr = new ParkingMeter(objPM);
	}
	
    
    
    public String toString()
    {
        // Create a DecimalFormat object for formatting.
        //DecimalFormat dollar = new DecimalFormat("#,##0.00");
        
        // Build a state string.
        String str = "Ticket data:\n" +
                    "\nCar Data:\n" + ptsPrkdCr +
                    "\nOfficer Data:\n" + ptsPolOff; //+
                    //"\nMinutes Illegally Parked: " + minutes; //+
                    //"\nFine: $" + dollar.format(fine);
        
        // Return the string.
        return str;
    }
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
	
	
	PoliceOfficer(PoliceOfficer poObjToCopy)
	{
		offName = poObjToCopy.offName;
		badge = poObjToCopy.badge;
		polOffsParkedCar = new ParkedCar(poObjToCopy.polOffsParkedCar);
		polOffsParkingMeter = new ParkingMeter(poObjToCopy.polOffsParkingMeter);
	}
	
	
	
	public boolean checkExpiration(ParkedCar aCar, ParkingMeter aMeter)
	{
		boolean expired = false;
		
		if(polOffsParkedCar.minOnCar > polOffsParkingMeter.timePurchased)
		{
            double overtime = polOffsParkedCar.minOnCar - polOffsParkingMeter.timePurchased;
            expired = true;
            ParkingTicket theTicket = new ParkingTicket(polOffsParkedCar, polOffsParkingMeter);
		}

		return expired;
    }
    
    public String toString()
	{
		String str = "Name: " + offName +
                    "\nBadgeNumber: " + badge;

        return str;
	}

}
