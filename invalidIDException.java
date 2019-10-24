public class invalidIDException extends Exception
{
    public invalidIDException()
    {   super("Error: Numericals in ID must be between 0-9 and letters must be between A-M ");}

    public invalidIDException(String i)
    {   super("Error: Numericals in ID must be between 0-9 and letters must be between A-M: " + i);}
}
