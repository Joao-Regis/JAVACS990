/**
 * Enrollment
 */
public class Enrollment 
{
    int eSID;     // 01 int = 04 bytes
    int eCNum;     // 01 int = 04 bytes
    
    int year;           // 01 int = 04 bytes
    String semester;    // 06 chars = 12 bytes
    char grade;         // 01 char = 02 bytes -- Total 52 bytes

    public Enrollment(int eSID, int eCNum, int year, String semester, char grade) 
    {
        this.eSID = eSID;
        this.eCNum = eCNum;
        this.year = year;
        this.semester = semester;
        this.grade = grade;
    }




    public int getYear() 
    {
        return year;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

    public String getSemester() 
    {
        return semester;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public char getGrade() 
    {
        return grade;
    }

    public void setGrade(char grade) 
    {
        this.grade = grade;
    }

    
    public int geteSID() 
    {
        return eSID;
    }

    public void seteSID(int eSID) 
    {
        this.eSID = eSID;
    }

    public int geteCNum() 
    {
        return eCNum;
    }

    public void seteCNum(int eCNum) 
    {
        this.eCNum = eCNum;
    }

    

	@Override
    public String toString() {
        return "Enrollment [grade=" + grade + ", semester=" + 
                            semester + ", year=" + year + "]";
    }  


}
