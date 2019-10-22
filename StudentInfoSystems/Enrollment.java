/**
 * Enrollment
 */
public class Enrollment 
{
    // aggregate stid;
    //aggregate cnum;
    
    int year;
    String semester;
    char grade;

    public Enrollment(int year, String semester, char grade) 
    {
        this.year = year;
        this.semester = semester;
        this.grade = grade;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment [grade=" + grade + ", semester=" + semester + ", year=" + year + "]";
    }

	  


}
