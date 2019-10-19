public class invalidPayRateException extends Exception
{
    public invalidPayRateException()
    {   super("Error: Hourly Rate Cannot be negative or greater than 25");}

    public invalidPayRateException(double i)
    {   super("Error: Hourly Rate Cannot be negative or greater than 25" + i);   }
}
