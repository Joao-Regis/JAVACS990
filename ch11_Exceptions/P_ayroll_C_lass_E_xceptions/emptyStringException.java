public class emptyStringException extends Exception
{
    public emptyStringException()
    {   
        super("Invalid name"); 
    }

    public emptyStringException(String a)
    {   
        super("Invalid name: " + a); 
    } 
}
