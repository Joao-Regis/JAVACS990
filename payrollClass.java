public class payrollClass
{
   String name;         
   String idNum;         
   double payRate;      
   double hoursWorked;
   double grossPay;

   public payrollClass(String nameParam, String idParam, double prParam, double hwParam) 
                        throws emptyStringException, invalidIDException, 
                        invalidPayRateException, invalidHoursWorkedException
   {
      setName(nameParam);
      setIdNum(idParam);
      setPayRate(prParam);
      setHoursWorked(hwParam);
   }



   public void setName(String nameParam) throws emptyStringException
    {    
       if(nameParam == null || nameParam.length() == 0)
       {
            throw new emptyStringException();
       }
       else
       {
            name = nameParam;
       }
    }
   


//      public void setIdNum(String idParam) throws invalidIDException
//    {
//         if(idParam.charAt(0) < '0' || idParam.charAt(0) > '9')
//         {
//             System.out.println("char 0: off");
//         }

//         if(idParam.charAt(1) < 0 || idParam.charAt(1) > 9)
//         {
//             System.out.println("char 1: off");
//         }

//         if(idParam.charAt(2) < 0 || idParam.charAt(2) > 9)
//         {
//             System.out.println("char 2: off");
//         }

//         if(idParam.charAt(3) != '-')
//         {
//             System.out.println("char 3: off");
//         }


//         if(idParam.charAt(4) < 'A' || idParam.charAt(4) > 'M')
//         {
//             System.out.println("char 4: off");
//         }
       
      
//         else
//         {
//             idNum = idParam;
//         }
//    }


   public void setIdNum(String idParam) throws invalidIDException
   {
        if(idParam.length() < 5 || idParam.charAt(0) < '0' || idParam.charAt(0) > '9' ||
          idParam.charAt(1) < '0' || idParam.charAt(1) > '9' || 
          idParam.charAt(2) < '0' || idParam.charAt(2) > '9' ||
          idParam.charAt(3) != '-' ||
          idParam.charAt(4) < 'A' || idParam.charAt(4) > 'M')
          {
              throw new invalidIDException();
          }
        else
        {
            idNum = idParam;
        }
   }
   
   public void setPayRate(double prParam) throws invalidPayRateException
   {
       if(prParam < 0|| prParam > 25)
       {
            throw new invalidPayRateException();
       }
       else
       {
           payRate = prParam;
       }
   }

   
   
   public void setHoursWorked(double hwParam) throws invalidHoursWorkedException
   {
       if(hwParam < 0|| hwParam > 84)
       {
            throw new invalidHoursWorkedException();
       }
       else
       {
           hoursWorked = hwParam;
       }
   }




   public String getName()
   {      return name;  }

   public String getIdNum()
   {      return idNum;  }

   public double getPayRate()
   {    return payRate; }

   public double getHoursWorked()
   {    return hoursWorked; }

   public double getGrossPay()
   {    return hoursWorked * payRate;   }

    

   public String toString()
   {
       String str = "Employees name: " + name +
                    "\nID: " + idNum +
                    "\nHourly Rate: $" + payRate +
                    "\nHours: " + (int)hoursWorked + " hrs " +
                    "\nGross Pay: $" + getGrossPay();
        
        return str;
   }




}
