import java.io.*;
import java.util.Scanner;

/**
 * SalesAnalysisDemo
 */
public class SalesAnalysisDemo 
{

    public static void main(String[] args) 
                        throws FileNotFoundException 
    {
     
        double totalSales = 0;
        String salesLine;
        double avg;
        int weekCount = 0;
        double salesForWeek = 0;
        double highSales;
        int highSalesWeek;
        double lowSales;
        int lowSalesWeek;
        double dailySale;

        File salesDataFile = new File("SalesData.txt");
        Scanner inputFile = new Scanner(salesDataFile);

        while(inputFile.hasNext())
        {
            salesLine = inputFile.nextLine();
            weekCount++;

            String[] salesLineTokenized = salesLine.split(";");  
            for(String s: salesLineTokenized)
            {
                dailySale = Double.parseDouble(s);
                salesForWeek =  salesForWeek + dailySale;
            }

            System.out.println(salesLineTokenized);

            System.out.println("Weekly sales from week " +
                weekCount + " is $" + salesForWeek);

            System.out.println("Average for week " + 
                weekCount + "is $" + salesForWeek/7.0);
        }

        
    }
}
