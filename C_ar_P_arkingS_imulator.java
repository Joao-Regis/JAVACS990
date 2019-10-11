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
		double minOnCar;
		double minPurchased;
		double fineFirstHour = 25.0;
		double finePerHourAfter1stHour = 10.0;
		
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
					
		PoliceOfficer copper = new PoliceOfficer(offName, badge);
				
		
		boolean violationCheck;
		violationCheck = copper.searching(automobile, theMeter);
		
		
		//ParkingTicket fine = new ParkingTicket(automobile, theMeter);
		
		if (violationCheck = true)
		{	ParkingTicket fine = new ParkingTicket(automobile, theMeter);
			fine.calcFine(); 
			System.out.println("ticket to to string");}
		else
		{	System.out.println("The car parking minutes are valid"); }
		
		//if(copper.checkExpiration(automobile, theMeter)
		
		keyboard.close();
	}
	
	

}




//**************************************************//
//**************************************************//
class ParkedCar
{
	String vehicleMake;
	String vehicleModel;
	String vehicleColor;
	String vehicleLic;
	double minOnCar;
	
	
	ParkedCar(String aMake, String aModel, String aColor, 
			String  aLic, double aTimeAmount)
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
	
	
	public String getVehicleMake()
	{
		return vehicleMake;
	}
	
	public String getVehicleModel() 
	{
		return vehicleModel;
	}
	
	public String getVehicleColor() 
	{
		return vehicleColor;
	}
	
	public String getVehicleLic()
	{
		return vehicleLic;
	}
	
	
	
	/*
	 * public void setVehicleMake() {
	 * 
	 * }
	 * 
	 * 
	 * public void setVehicleModel() {
	 * 
	 * }
	 * 
	 * public void setVehicleColor() {
	 * 
	 * }
	 * 
	 * public void setVehicleLic() {
	 * 
	 * }
	 */
	
	
	public String toString()
	{
		String str = "Make: " + vehicleMake +
                "\nModel: " + vehicleModel +
                "\nColor: " + vehicleColor +
                "\nLiscense Number: " + vehicleLic; //[sic]
   
		return str;
	}
}

//**************************************************//
//**************************************************//






//**************************************************//
//**************************************************//
class ParkingMeter
{
	double timePurchased;
	
	ParkingMeter(double timePaidFor)
	{
		timePurchased = timePaidFor;
	}
	
	ParkingMeter(ParkingMeter pmObjToBeCopied)
	{
		timePurchased = pmObjToBeCopied.timePurchased;
	}
}
//**************************************************//
//**************************************************//



//**************************************************//
//**************************************************//
class PoliceOfficer
{
	String offName;
	int badge;

	
	PoliceOfficer(String anOffName, int aBadgeNum)
	{
		offName = anOffName;
		badge = aBadgeNum;
	}
	
	
	PoliceOfficer(PoliceOfficer poObjToCopy)
	{
		offName = poObjToCopy.offName;
		badge = poObjToCopy.badge;
	}
	
	
	public boolean searching(ParkedCar pc, ParkingMeter pm)
	{
		boolean viol = false;
		
		if(pc.minOnCar > pm.timePurchased)
		{	viol = false;}
		
		else if(pc.minOnCar < pm.timePurchased)
		{	//ParkingTicket fine = new ParkingTicket(pc, pm);
			viol = true;}
		
		return viol;
	}
	
	
	
	
	public String toString()
	{
		String str = "Officer Name: " + offName +
                "\nBadge Number: " + badge;
   
		return str;
	}
	
	
	
}
//**************************************************//
//**************************************************//







//**************************************************//
//**************************************************//
class ParkingTicket
{
	String ptOffName;
	int ptOffBadge;
	PoliceOfficer ptsPolOff;
	ParkedCar ptsPrkdCr;
	ParkingMeter ptsPrkngMtr;
	
	double fineFirstHour = 25.0;
	double finePerHourAfter1stHour = 10.0;
	double fineAmount;
	
	
	ParkingTicket(ParkedCar objPC, ParkingMeter objPM)
	{
		ptsPrkdCr = new ParkedCar(objPC);
		ptsPrkngMtr = new ParkingMeter(objPM);
	}
	
	
	ParkingTicket(ParkingTicket pt)
	{
		
	}
	
	public void calcFine()
	{
		double overtime = ptsPrkdCr.minOnCar - ptsPrkngMtr.timePurchased;
		if(overtime < 60.0)
		{
			fineAmount = fineFirstHour;
		}
		if(overtime > 60.0) 
		{
			double hours = overtime / 60.0;
			int intHours = (int)hours; //truncates to result in just hours
			
			if((hours - intHours) > 0)
			{	intHours = intHours + 1; }
			
			fineAmount = fineFirstHour + (intHours * finePerHourAfter1stHour );
		}
		
	}
	
//	ParkingTicket(String copperName, int copperBadge, ParkedCar objPC, ParkingMeter objPM)
//	{
//		ptOffName = copperName;
//		ptOffBadge = copperBadge;
//		ptsPrkdCr = new ParkedCar(objPC);
//		ptsPrkngMtr = new ParkingMeter(objPM);
//		
//		System.out.println("Car parking time has expired.");
//		System.out.println("Ticket data: ");
//		System.out.println(ptsPrkdCr);
//	}
	
	
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
//**************************************************//
//**************************************************//











