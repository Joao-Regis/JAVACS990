import java.util.Scanner;

/**
 * ExceptionProject
 */
public class ExceptionProject {

    public static void main(String[] args) {
        
        String name;
        String empNum;
        String hireDate;
        int shift;
        double payRate;

        Scanner keyboard = new Scanner(System.in);
    
        System.out.print("Enter the employee name: ");
        name = keyboard.nextLine();

        System.out.print("Enter employee number, (ex. 999-M): ");        
        empNum = keyboard.nextLine();
    
        System.out.print("Enter the employee hire date: ");
        hireDate = keyboard.nextLine();

        System.out.print("Employee shift, (1 = day or 2 = night): ");
        shift = keyboard.nextInt();

        System.out.print("Enter the employee hourly pay rate: ");
        payRate = keyboard.nextDouble();
        
        try
        {
            ProductionWorker worker = new ProductionWorker(name, empNum, hireDate, shift, payRate);
            System.out.println(worker);
        }
        catch (invalidEmpNumException iene)
        {
            System.out.println(iene.getMessage());
        }
        catch(invalidPayRateException ipre)
        {
            System.out.println(ipre.getMessage());
        }
        catch(invalidShiftException ise)
        {
            System.out.println(ise.getMessage());
        }



        keyboard.close();


    }
}
