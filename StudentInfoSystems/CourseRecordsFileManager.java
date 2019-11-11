import java.io.*;



/**
 This class manages a random access file which contains
Course records.
*/
public class CourseRecordsFileManager
{
    public final int RECORD_SIZE = 164;
    private RandomAccessFile courseFile; 

    /**
     The constructor opens a random access file
    for both reading and writing.
    @param filename The name of the file.
    @exception FileNotFoundException When the file
                is not found.
    */

    public CourseRecordsFileManager(String filename)
                        throws FileNotFoundException
    {
        // Open the file for reading and writing.
        courseFile = new RandomAccessFile(filename, "rw");
    }

    /**
     The writeCourse method writes the contents
    of a Course object to the file at the
    current file pointer position.
    @param course The Course object to write.
    @exception IOException When a file error occurs.
    */

    public void writeCourse(Course course)
                                throws IOException
    {
    
        
        // Get the course's CID.
        String str = course.getCid();

        // Write the CID.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 2.
            for (int i = 0; i < 20; i++)
            courseFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the state to the file.
            courseFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 2 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            courseFile.writeChar(' ');
        }


        
    
        // Get the course's NAME.
        str = course.getCname();

        // Write the name.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            courseFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the name to the file.
            courseFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            courseFile.writeChar(' ');
        }


        
        
        // Get the course's INSTRUCTOR.
        str = course.getInstr();

        // Write the address.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            courseFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the address to the file.
            courseFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            courseFile.writeChar(' ');
        }




        // Get the course's DEPT.
        str = course.getDept();

        // Write the city.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            courseFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the city to the file.
            courseFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            courseFile.writeChar(' ');
        }




        



        // Write the cnum to the file.
        courseFile.writeInt(course.getCnum());



        System.out.println("The data was written to the " +
                            "Courses.dat file.");
    }






    /**
        The readCourse method reads and returns
        the record at the current file pointer position.
        @return A reference to a Course object.
        @exception IOException When a file error occurs.
    */

    public Course readCourse() throws IOException
    {
        
        

        char[] charArray = new char[20];
        
        // Read the NAME, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = courseFile.readChar();
            
        // Store the char array in a String.
        String courseCID = new String(charArray);
        
        // Trim any trailing spaces from the string.
        courseCID.trim();




        charArray = new char[20];
        
        // Read the ADDRESS, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = courseFile.readChar();
            
        // Store the char array in a String.
        String courseName = new String(charArray);
        
        // Trim any trailing spaces from the string.
        courseName.trim();



        charArray = new char[20];
        
        // Read the CITY, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = courseFile.readChar();
            
        // Store the char array in a String.
        String courseInstr = new String(charArray);
        
        // Trim any trailing spaces from the string.
        courseInstr.trim();



        charArray = new char[20];
        
        // Read the STATE, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = courseFile.readChar();
            
        // Store the char array in a String.
        String courseDept = new String(charArray);
        
        // Trim any trailing spaces from the string.
        courseDept.trim();
        
        
        
        // Read the cnum from the file.
        int courseNum = courseFile.readInt();
        
        
    
        // Create a Course object and initialize
        // it with these values.
        Course course =
                new Course(courseCID, courseName, courseInstr, courseDept, courseNum);
        
        // Return the object.
        return course;
    }

    
    /**
        The getByteNum method returns a record's
        starting byte number.
        @param recordNum The record number of the
                        desired record.
    */

    private long getByteNum(long recordNum)
    {
        return RECORD_SIZE * recordNum;
    }


    /**
        The moveFilePointer method moves the file
        pointer to a specified record.
        @param recordNum The number of the record to move to.
        @exception IOException When a file error occurs.
    */

    public void moveFilePointer(long recordNum)
                            throws IOException
    {
        courseFile.seek(getByteNum(recordNum));
    }

    /**
        The getNumberOfRecords method returns the number
        of records stored in the file.
        @return The number of records in the file.
        @exception IOException When a file error occurs.
    */

    public long getNumberOfRecords() throws IOException
    {
        return courseFile.length() / RECORD_SIZE;
    }

    /**
        The close method closes the file.
        @exception IOException When a file error occurs.
    */

    public void close() throws IOException
    {
        courseFile.close();
    }
}
