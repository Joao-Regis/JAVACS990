/**
 * Student
 */
public class Student 
{
    static int stid;
    
    String name;
    String address;
    String city;
    String state;

    public Student(String n, String a, String c, String s) {
        this.name = n;
        this.address = a;
        this.city = c;
        this.state = s;
    }


    public static int getStid() {
        return stid;
    }

    public static void setStid(int stid) {
        Student.stid = stid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", city=" + city + ", name=" + name + ", state=" + state + "]";
    }

    
    
}
