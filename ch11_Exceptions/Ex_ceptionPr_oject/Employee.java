/**
 * Employee
 */
public class Employee 
{
    private String name;           
    private String employeeNumber; 
    private String hireDate; 
    

    public Employee(String n, String num, String date) 
                    throws invalidEmpNumException
    {
        name = n;
        setEmployeeNumber(num);
        hireDate = date;
    }


        
    public Employee()
    {
        name = "";
        employeeNumber = "";
        hireDate = "";
    }
    

    public void setName(String n)
    {   name = n;    }



public void setEmployeeNumber(String e) throws invalidEmpNumException
    {
        if(e.length() < 5 || e.charAt(0) < '0' || e.charAt(0) > '9' ||
          e.charAt(1) < '0' || e.charAt(1) > '9' || 
          e.charAt(2) < '0' || e.charAt(2) > '9' ||
          e.charAt(3) != '-' ||
          e.charAt(4) < 'A' || e.charAt(4) > 'M')
          {
              throw new invalidEmpNumException();
          }
        else
        {
            employeeNumber = e;
        }
    }


    public void setHireDate(String h)
    {   hireDate = h;   }



    public String getName()
    {   return name;    }



    public String getEmployeeNumber()
    {   return employeeNumber;  }


    
    public String getHireDate()
    {   return hireDate;    }


    
    public String toString()
    {
        String str ="\nEmployee Details" +
                    "\nEmployees name: " + name + 
                    "\nEmployee Number: ";
        
        if (employeeNumber == "")
            str += "INVALID EMPLOYEE NUMBER";
        else
            str += employeeNumber;
            
        str += ("\nHire Date: " + hireDate);
        return str;
    }
    
}
