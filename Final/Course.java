package sample;

import java.io.IOException;

/**
 * Course
 */
public class Course 
{
    public static int courseCount = 0;
    String cid;     // 20 chars = 40 bytes
    String cname;   // 20 chars = 40 bytes
    String instr;   // 20 chars = 40 bytes
    String dept;    // 20 chars = 40 bytes
    int cnum;       // 01 int = 04 bytes -- Total 164 bytes

    public Course(String cID,String cna, String i, String d, CourseRecordsFileManager cfilemngr) throws IOException {

        //increase courseCount by one. unique key value
        //so that next course has unique cnum.
        courseCount++;

        this.cid = cID;
        this.cname = cna;
        this.instr = i;
        this.dept = d;
        this.cnum = ((int) cfilemngr.getNumberOfRecords()) + 1;
    }


    public Course(String cID, String cna, String i, String d, int cno)
    {
        this.cnum = cno;
        this.cid = cID;
        this.cname = cna;
        this.instr = i;
        this.dept = d;
    }



    public int getCourseCount()
    {
        return courseCount;
    }


    public String getCid() 
    {
        return cid;
    }

    public void setCid(String cid) 
    {
        this.cid = cid;
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
    public String toString() {
        return "Course [cid=" + cid + ", cname=" + cname + ", cnum=" 
                + cnum + ", dept=" + dept + ", instr=" + instr + "]";
    }





}
