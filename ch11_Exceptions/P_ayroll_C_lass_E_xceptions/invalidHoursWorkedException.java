public class invalidHoursWorkedException extends Exception
{
    public invalidHoursWorkedException()
    {   super("Error: Hours Cannot be negative or greater than 84");}

    public invalidHoursWorkedException(double i)
    {   super("Error: Hours Cannot be negative or greater than 84" + i);   }
}
