/**
 * Student
 */
public class Student 
{
    public static int studentCount = 0;
    int stid;// = studentCount; // 01 int = 04 bytes
    String name;    // 20 chars = 40 bytes
    String address; // 20 chars = 40 bytes
    String city;    // 20 chars = 40 bytes
    String state;   // 02 chars = 04 bytes -- Total 128 bytes

    public Student( String n, String a, String c, String s) 
    {
        //increase studentCount by one. unique key value
        //so that next student has unique stid.
        studentCount++;
        
        this.name = n;
        this.address = a;
        this.city = c;
        this.state = s;
        this.stid = studentCount;

        
    }

    

    public Student(int i, String n, String a, String c, String s) 
    {
        this.stid = i;
        this.name = n;
        this.address = a;
        this.city = c;
        this.state = s;        
    }


    public int getStudentCount()
    {
        return studentCount;
    }

    public int getStid() 
    {
        return stid;
    }

    public void setStid(int stid) 
    {
        this.stid = stid; // changed from student.stid
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    @Override
    public String toString() 
    {
        return "Student [address=" + address + ", city=" + city + 
                        ", name=" + name + ", state=" + state + "]";
    }

    
    
}
