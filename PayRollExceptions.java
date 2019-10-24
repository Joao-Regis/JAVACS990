import java.util.Scanner;

/**
 * PayRollExceptions
 */
public class PayRollExceptions {

    public static void main(String[] args) 
    {
        String name;
        String idNum;
        double payRate;
        double hoursWorked;

        Scanner keyboard = new Scanner(System.in);
    
        System.out.print("Enter the employee's name: ");
        name = keyboard.nextLine();

        System.out.print("Enter employee number, (ex. 999-M): ");        
        idNum = keyboard.nextLine();
    
        System.out.print("Enter the employee's hourly rate: ");
        payRate = keyboard.nextDouble();

        System.out.print("Enter the number of hours the employee has worked: ");
        hoursWorked = keyboard.nextDouble();
        
        try
        {
            payrollClass empPR = new payrollClass(name, idNum, payRate, hoursWorked);
            System.out.println(empPR);
        }
        catch (emptyStringException ese)
        {
            System.out.println(ese.getMessage());
        }
        catch (invalidIDException iie)
        {
            System.out.println(iie.getMessage());
        }
        catch(invalidPayRateException ipre)
        {
            System.out.println(ipre.getMessage());
        }
        catch(invalidHoursWorkedException ihwe)
        {
            System.out.println(ihwe.getMessage());
        }



        keyboard.close();
    }
    
}


// class payrollClass
// {
//    String name;         
//    int idNum;         
//    double payRate;      
//    double hoursWorked;   


    



//    public payrollClass(String nameParam, int idParam) throws emptyStringException, invalidID
//    {
//       setName(nameParam);
//       setIdNum(idParam);
//    }



//    public void setName(String nameParam) throws emptyStringException
//     {    
//        if(nameParam == null || nameParam.length() == 0)
//        {
//             throw new emptyStringException();
//        }
//        else
//        {
//             name = nameParam;
//        }
//     }
   
//    public void setIdNum(int idParam) 
//    {    idNum = idParam;   }
   
//    public void setPayRate(double payRateParam)
//    {    payRate = payRateParam;    }

//    public void setHoursWorked(double hoursWorkedParam)
//    {    hoursWorked = hoursWorkedParam;    }




//    public String getName()
//    {      return name;  }

//    public int getIdNumber()
//    {      return idNum;  }

//    public double getPayRate()
//    {    return payRate; }

//    public double getHoursWorked()
//    {    return hoursWorked; }

//    public double getGrossPay()
//    {    return hoursWorked * payRate;   }

    





// }


// ////////////////////////////////////// //
// ///////////// Exceptions ///////////// //
// ////////////////////////////////////// //


// class emptyStringException extends Exception
// {
//     public emptyStringException()
//     {   
//         super("Error"); 
//     }

//     public emptyStringException(String a)
//     {   
//         super("Error" + a); 
//     } 
// }


// class invalidIDException extends Exception
// {
//     public invalidIDException()
//     {   super("Error");}

//     public invalidIDException(int i)
//     {   super("Error" + i);   }
// }


// class invalidHoursWorkedException extends Exception
// {
//     public invalidHoursWorkedException()
//     {   super("Error");}

//     public invalidHoursWorkedException(double i)
//     {   super("Error" + i);   }
// }


// class invalidPayRateException extends Exception
// {
//     public invalidPayRateException()
//     {   super("Error");}

//     public invalidPayRateException(double i)
//     {   super("Error" + i);   }
// }
