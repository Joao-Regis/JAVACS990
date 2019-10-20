/**
 * invalidPayRateException
 */
public class invalidPayRateException extends Exception
{
    public invalidPayRateException()
    {   super("Error: InvalidPayRate");}

    public invalidPayRateException(double i)
    {   super("Error: InvalidPayRate" + i);}
    
}
