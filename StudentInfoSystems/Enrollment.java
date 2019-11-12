/**
 * Enrollment
 */
public class Enrollment 
{
    public static int enrollmentCount = 0;
    int enrollmentID;   // 01 int = 04 bytes

    int eSID;           // 01 int = 04 bytes
    int eCNum;          // 01 int = 04 bytes
    int year;           // 01 int = 04 bytes
    String semester;    // 06 chars = 12 bytes
    char grade = '*';   // 01 char = 02 bytes -- Total 30 bytes

    public Enrollment(int eSID, int eCNum, int yr, String sem, char grd) 
    {
        //increase courseCount by one. unique key value
        //so that next course has unique cnum.
        enrollmentCount++;

        this.eSID = eSID;
        this.eCNum = eCNum;
        this.year = yr;
        this.semester = sem;
        this.grade = grd;
        this.enrollmentID = enrollmentCount;
    }


    public Enrollment(int eSID, int eCNum, int yr, String sem, char grd, int eID) 
    {
        this.eSID = eSID;
        this.eCNum = eCNum;
        this.year = yr;
        this.semester = sem;
        this.grade = grd;
        this.enrollmentID = eID;
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
        return "Enrollment [eCNum=" + eCNum + ", eSID=" + eSID 
            + ", grade=" + grade + ", semester=" + semester
            + ", year=" + year + "]";
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

}
