package sample;

import java.io.*;

/**
 This class manages a random access file which contains
Student records.
*/
public class StudentRecordsFileManager
{
    public final int RECORD_SIZE = 128;
    private RandomAccessFile studentFile; 


    /**
     The constructor opens a random access file
    for both reading and writing.
    @param filename The name of the file.
    @exception FileNotFoundException When the file
                is not found.
    */

    public StudentRecordsFileManager(String filename)
                        throws FileNotFoundException
    {
        // Open the file for reading and writing.
        studentFile = new RandomAccessFile(filename, "rw");
    }



    public void CreateStudentFile(Student aStudent) throws IOException
    {
        // move file pointer to eof to append new student.
        moveFilePointer(getNumberOfRecords());

        writeStudent(aStudent);
    }


    /**
     The writeStudent method writes the contents
    of a Student object to the file at the
    current file pointer position.
    @param student The Student object to write.
    @exception IOException When a file error occurs.
    */

    public void writeStudent(Student student)
                                throws IOException
    {
    
        // Write the STID to the file.
        studentFile.writeInt(student.getStid());

    
    
        // Get the student's NAME.
        String str = student.getName();

        // Write the name.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            studentFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the name to the file.
            studentFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            studentFile.writeChar(' ');
        }


        // Get the student's ADDRESS.
        str = student.getAddress();

        // Write the address.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            studentFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the address to the file.
            studentFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            studentFile.writeChar(' ');
        }




        // Get the student's CITY.
        str = student.getCity();

        // Write the city.
        if (str.length() > 20)
        {
            // If there are more than 20 characters in the
            // string, then write only the first 20.
            for (int i = 0; i < 20; i++)
            studentFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the city to the file.
            studentFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 20 characters.
            for (int i = 0; i < (20 - str.length()); i++)
            studentFile.writeChar(' ');
        }




        // Get the student's STATE.
        str = student.getState();

        // Write the state.
        if (str.length() > 2)
        {
            // If there are more than 2 characters in the
            // string, then write only the first 2.
            for (int i = 0; i < 2; i++)
            studentFile.writeChar(str.charAt(i));
        }
        else
        {
            // Write the state to the file.
            studentFile.writeChars(str);
            // Write enough spaces to pad it out
            // to 2 characters.
            for (int i = 0; i < (2 - str.length()); i++)
            studentFile.writeChar(' ');
        }


        System.out.println("The data was written to the " +
                            "Students.dat file.");
    }



    public Student ReadstudentFile(int studentNumID) throws IOException
    {
        int recordNumber = studentNumID;     // Record number
        Student student;   // An object from the file

        // Report the number of records in the file.
        System.out.println("The Students.dat file has " +
                getNumberOfRecords() + " records.");

        // Move the file pointer to that record.
        moveFilePointer(recordNumber - 1);

        // Read the record at that location.
        student = readStudent();

        // Display the record.
        System.out.println("\nName: " +
                student.getName());
        System.out.println("Address: " +
                student.getAddress());
        System.out.println("City: " +
                student.getCity());
        System.out.println("State: " +
                student.getState());
        System.out.println("stid: " + student.getStid());

        return student;

    }






    /**
        The readStudent method reads and returns
        the record at the current file pointer position.
        @return A reference to a Student object.
        @exception IOException When a file error occurs.
    */

    public Student readStudent() throws IOException
    {
        // Read the stid from the file.
        int studentID = studentFile.readInt();
        

        char[] charArray = new char[20];
        
        // Read the NAME, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = studentFile.readChar();
            
        // Store the char array in a String.
        String studentName = new String(charArray);
        
        // Trim any trailing spaces from the string.
        studentName.trim();




        charArray = new char[20];
        
        // Read the ADDRESS, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = studentFile.readChar();
            
        // Store the char array in a String.
        String studentAddress = new String(charArray);
        
        // Trim any trailing spaces from the string.
        studentAddress.trim();



        charArray = new char[20];
        
        // Read the CITY, character by character,
        // from the file into the char array.
        for (int i = 0; i < 20; i++)
            charArray[i] = studentFile.readChar();
            
        // Store the char array in a String.
        String studentCity = new String(charArray);
        
        // Trim any trailing spaces from the string.
        studentCity.trim();



        charArray = new char[2];
        
        // Read the STATE, character by character,
        // from the file into the char array.
        for (int i = 0; i < 2; i++)
            charArray[i] = studentFile.readChar();
            
        // Store the char array in a String.
        String studentState = new String(charArray);
        
        // Trim any trailing spaces from the string.
        studentState.trim();
        
        
        
        // Create a Student object and initialize
        // it with these values.
        Student student =
                new Student(studentID, studentName, studentAddress, studentCity, studentState);
        
        // Return the object.
        return student;
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
        studentFile.seek(getByteNum(recordNum));
    }

    /**
        The getNumberOfRecords method returns the number
        of records stored in the file.
        @return The number of records in the file.
        @exception IOException When a file error occurs.
    */

    public long getNumberOfRecords() throws IOException
    {
        return studentFile.length() / RECORD_SIZE;
    }

    /**
        The close method closes the file.
        @exception IOException When a file error occurs.
    */

    public void close() throws IOException
    {
        studentFile.close();
    }
}
