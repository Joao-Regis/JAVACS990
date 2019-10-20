import java.text.DecimalFormat;

/**
 * ProductionWorker
 */
public class ProductionWorker extends Employee
{

    public  int DAY_SHIFT = 1;
    public  int NIGHT_SHIFT = 2;

    private int shift;
    private double payRate;

    
    public ProductionWorker(String n, String num, String date,
                            int sh, double rate)
        throws invalidEmpNumException, invalidShiftException, invalidPayRateException
    {
        super(n, num, date);
        setShift(sh);
        setPayRate(rate);
    }


    
    public ProductionWorker()
    {
        super();
        shift = DAY_SHIFT;
        payRate = 0.0;
    }
    


    public void setShift(int s) throws invalidShiftException
    {
        if (s != DAY_SHIFT && s != NIGHT_SHIFT)
            throw new invalidShiftException();
        else
            shift = s;
    }


    
    public void setPayRate(double p) throws invalidPayRateException
    {
        if (p < 0)
            throw new invalidPayRateException();
        else
            payRate = p;
    }


    
    public int getShift()
    {      return shift; }

    
    public double getPayRate()
    {      return payRate;   }
    
    
    public String toString()
    {
        DecimalFormat dollarFigure = new DecimalFormat("#,##0.0");
        
        String str = super.toString();
        
        str += "\nShift: ";
        if (shift == DAY_SHIFT)
            str += "1";
        else if (shift == NIGHT_SHIFT)
            str += "2";
        else
            str += "INVALID SHIFT NUMBER";
        
        str += ("\nHourly Pay Rate: $" +
                dollarFigure.format(payRate));
                
        return str;
    }


   
}
