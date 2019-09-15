//import java.util.Scanner;

public class CarDemo {

	public static void main(String[] args) 
	{
		
		Car car1 = new Car(2000, "Corolla");
		
		System.out.println("We will now call the accelerate function 5 times");
		for(int i = 1; i <=5; i++) {
			car1.accelerate();
			System.out.println("The current speed is: " + car1.getSpeed());
		}
		
		System.out.println("");
		
		System.out.println("We will now call the brake function 5 times");
		for(int i = 1; i <=5; i++) {
			car1.brake();
			System.out.println("The current speed is: " + car1.getSpeed());
		}
		
		System.out.println("");
		System.out.println("The program will end now.");
		
	}

	

}



class Car
{
		private int yearModel;
		private String make;
		private int speed;
	
	public Car(int yrModel, String makeMake) 
	{
		yearModel = yrModel;
		make = makeMake;
		speed = 0;
	}
	
	public int getYearModel() 
	{
		return yearModel;
	}
	
	
	public String getMake() 
	{
		return make;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void accelerate()
	{
		speed += 5;
	}
	
	public void brake()
	{
		speed -= 5;
	}

	
}
