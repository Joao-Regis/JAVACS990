import java.io.*;

/**
 * EnrollmentRecordsFileManager
 * This class manages a random access file which contains
*  Enrollment records.
 */
public class EnrollmentRecordsFileManager 
{
    public final int RECORD_SIZE = 26;
    private RandomAccessFile enrollmentFile; 

    /**
     The constructor opens a random access file
    for both reading and writing.
    @param filename The name of the file.
    @exception FileNotFoundException When the file
                is not found.
    */

    public EnrollmentRecordsFileManager(String filename)
                        throws FileNotFoundException
    {
        // Open the file for reading and writing.
        enrollmentFile = new RandomAccessFile(filename, "rw");
    }

    /**
     The writeEnrollment method writes the contents
    of a Enrollment objects to the file at the
    current file pointer position.
    @param enrollment The Enrollment objects to write.
    @exception IOException When a file error occurs.
    */

    public void writeEnrollment(Enrollment enrollment)
                                throws IOException
    {
        // Write the eSID to the file.
        enrollmentFile.writeInt(enrollment.geteSID());


        // Write the eCnum to the file.
        enrollmentFile.writeInt(enrollment.geteCNum());

    
        // Get the enrollment's YEAR.
        enrollmentFile.writeInt(enrollment.getYear());

    
        // Get the enrollment's SEMESTER.
        String str = enrollment.getSemester();

        // Write the Semester.
        if (str.length() > 6)
        {
            // If there are more than 6 characters in the
            // string, then write only the first 6.
            for (int i = 0; i < 6; i++)
            enrollmentFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the semester to the file.
            enrollmentFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 6 characters.
            for (int i = 0; i < (6 - str.length()); i++)
            enrollmentFile.writeChar(' ');
        }


        // Get the enrollment's GRADE.
        enrollmentFile.writeChar(enrollment.getGrade());

        
        System.out.println("The data was written to the " +
                            "Enrollments.dat file.");
    }






    /**
        The readEnrollment method reads and returns
        the record at the current file pointer position.
        @return A reference to a Enrollment objects.
        @exception IOException When a file error occurs.
    */

    public Enrollment readEnrollment() throws IOException
    {
        
        // Read the STID from the file.
        int eSTID = enrollmentFile.readInt();
        
        // Read the CNUM from the file.
        int eCNUM = enrollmentFile.readInt();
        
        // Read the YEAR from the file.
        int eYEAR = enrollmentFile.readInt();


        char[] charArray = new char[6];
        
        // Read the Semester, character by character,
        // from the file into the char array.
        for (int i = 0; i < 6; i++)
            charArray[i] = enrollmentFile.readChar();
            
        // Store the char array in a String.
        String eSEM = new String(charArray);
        
        // Trim any trailing spaces from the string.
        eSEM.trim();


        // Read the YEAR from the file.
        char eGRADE = enrollmentFile.readChar();

    
        // Create a Enrollment objects and initialize
        // it with these values.
        Enrollment enrollment =
                new Enrollment(eSTID, eCNUM, eYEAR, eSEM, eGRADE);
        
        // Return the object.
        return enrollment;
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
        enrollmentFile.seek(getByteNum(recordNum));
    }

    /**
        The getNumberOfRecords method returns the number
        of records stored in the file.
        @return The number of records in the file.
        @exception IOException When a file error occurs.
    */

    public long getNumberOfRecords() throws IOException
    {
        return enrollmentFile.length() / RECORD_SIZE;
    }

    /**
        The close method closes the file.
        @exception IOException When a file error occurs.
    */

    public void close() throws IOException
    {
        enrollmentFile.close();
    }
}

