/**
 * Course
 */
public class Course 
{
    static int cid;
    
    String cname;
    String instr;
    String dept;
    int cnum;

    public Course(String cna, String i, String d, int cnu) {
        this.cname = cna;
        this.instr = i;
        this.dept = d;
        this.cnum = cnu;
    }

    public static int getCid() {
        return cid;
    }

    public static void setCid(int cid) {
        Course.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getInstr() {
        return instr;
    }

    public void setInstr(String instr) {
        this.instr = instr;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() 
    {
        return "Course [cname=" + cname + ", cnum=" + cnum + ", dept=" + dept + ", instr=" + instr + "]";
    }

    
}
