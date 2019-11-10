import java.io.*;
import java.util.Scanner;


/**
 * StudentInformationSystem
 */
public class StudentInformationSystem
{
    public static Scanner keyboard = new Scanner(System.in);
    
    public final int RECORD_SIZE = 128;
    //public RandomAccessFile studentFile;

       

    public static void main(String[] args) throws IOException 
    {
        StudentRecordsFileManager file = 
            new StudentRecordsFileManager("Students.dat");

        Student student;
        //String studentName;
        //String studentAddress;
        //String studentCity;
        //String studentState;
        int choice;


        do
        {
            choice = displayMenu();
            keyboard.nextLine();
            switch(choice)
            {   case 1:
                    System.out.println("Create new student");
                    student = collectStudentInfo();
                    System.out.println(student);
                    file.writeStudent(student);
                    //CreateStudentFile(student);

                    break;

                case 4:
                    displaySubMenu();
                    break;
                
                case 7:
                    System.out.println("Display student");
                    ReadstudentFile();
                    break;
                
                case 10:

                    break;
            }


        } while(choice != 0);


        
    
        keyboard.close();
    }



    public static int displayMenu()
    {
        int selection;
        
        System.out.println("\nWelcome to University Enrollment");
        System.out.println("1. Create Student");
        System.out.println("2. Create Course");
        System.out.println("3. Create Enrollment");
        System.out.println("4. Edit Student");
        System.out.println("5. Edit Course");
        System.out.println("6. Edit Enrollment");
        System.out.println("7. Display Student(s)");
        System.out.println("8. Display Course(s)");
        System.out.println("9. Display Enrollment(s)");
        System.out.println("10. Grades Sub Menu");
        System.out.println("0. --- Quit ---");
        System.out.println("Please enter a valid choice(1-10, 0 to Quit)");

        selection = keyboard.nextInt();
        while (selection < 0 || selection > 10)
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Please enter a valid choice(1-10, 0 to Quit)");
            selection = keyboard.nextInt();
        }
        return selection;
    }

    public static void displaySubMenu()
    {
        System.out.println("\nGrades Menu");
        System.out.println("1. View Grades by Student");
        System.out.println("2. View Grades by Course");
        System.out.println("3. Edit Grades by Student");
        System.out.println("4. Edit Grades by Course");
        System.out.println("0. --- Exit to Menu ---");
        System.out.println("Please enter a valid choice(1-4, 0 to Exit)");

    }

    public static Student collectStudentInfo()
    {
        String studentName;
        String studentAddress;
        String studentCity;
        String studentState;
        //Student aStudent;

        System.out.println("\nEnter student's name.");
        studentName = keyboard.nextLine();
        while(studentName == null || studentName.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter student's name.");
            studentName = keyboard.nextLine();
        }

        System.out.println("\nEnter student's address.");
        studentAddress = keyboard.nextLine();
        while(studentAddress == null || studentAddress.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter student's address.");
            studentAddress = keyboard.nextLine();
        }

        System.out.println("\nEnter student's city.");
        studentCity = keyboard.nextLine();
        while(studentCity == null || studentCity.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter student's city.");
            studentCity = keyboard.nextLine();
        }
        
        System.out.println("\nEnter student's state.");
        studentState = keyboard.nextLine();
        while(studentState == null || studentState.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter student's state.");
            studentState = keyboard.nextLine();
        }

        Student aStudent = new Student(studentName, studentAddress, studentCity, studentState);
        return aStudent;
    }









    /**
     * This program uses the studentFile class to create a file 
     * containing data from 5 Student objects.
     * 
     * @throws IOException
     */

    public static void CreateStudentFile(Student aStudent) throws IOException
    {
    
        //String studentName;    // 20 chars = 40 bytes
        //String studentAddress; // 20 chars = 40 bytes
        //String studentCity;    // 20 chars = 40 bytes
        //String studentState;   // 02 chars = 04 bytes -- Total 128 bytes
        
        /* final int NUM_studentS = 5; // Number of students
        String name;      // student name
        int stid;         // stid on hand
    
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
    
        // Create an array to hold Student objects.
        Student[] students = new Student[NUM_studentS];
    
        // Get data for the Student objects.
        System.out.println("Enter data for " + NUM_studentS +
                            " inventory students."); */
        
        //Scanner keyboard = new Scanner(System.in);
        
        //System.out.println("Enter student's name.");
        //studentName = keyboard.nextLine();

        //System.out.println("Enter student's address.");
        //studentAddress = keyboard.nextLine();
        
        //System.out.println("Enter student's city.");
        //studentCity = keyboard.nextLine();
        
        //System.out.println("Enter student's state.");
        //studentState = keyboard.nextLine();
        
        // Consume the remaining newline.
        //keyboard.nextLine();

        // Create an Student object in the array.
        //Student student = new Student(studentName, studentAddress, studentCity, studentState);
        
       // Create an studentFile object.
        StudentRecordsFileManager file = 
            new StudentRecordsFileManager("Students.dat");
    
        //StudentRecordsFileManager file;

        //file.writeStudent(aStudent);
        
    
        // Close the file.
        //file.close();
    
        System.out.println("The data was written to the " +
                            "Students.dat file.");

        //keyboard.close();
        
    }
    
    /* public static void writeStudent(Student aStudent)
    {
        file.writeStudent(aStudent);
        System.out.println("The data was written to the " +
                            "Students.dat file.");
    } */


    /**
     * This program displays specified records from the Students.dat file.
     * 
     * @throws IOException
     */

    public static void ReadstudentFile() throws IOException
    {
    
        int recordNumber;     // Record number
        String again;         // To get a Y or an N
        Student student;   // An object from the file
        
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        StudentRecordsFileManager
        file = new StudentRecordsFileManager("Students.dat");
        
        // Report the number of records in the file.
        System.out.println("The Students.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        // Get a record number from the user and
        // display the record.
        do
        {
            // Get the record number.
            System.out.print("Enter the number of the record " +
                            "you wish to see: ");
            recordNumber = keyboard.nextInt();
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record.
            file.moveFilePointer(recordNumber);
            
            // Read the record at that location.
            student = file.readStudent();
            
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
            
            // Ask the user whether to get another record.
            System.out.print("\nDo you want to see another " +
                            "record? (Y/N): ");
            again = keyboard.nextLine();
        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Close the file.
        file.close();

        keyboard.close();
    }





    /*
    This program allows the user to modify records in the
    Students.dat file.
    */

    public void ModifyRecord() throws IOException
    {
        int recordNumber;   // Record number
        int stid;          // stid on hand
        String again;       // Want to change another one?
        String sure;        // Is the user sure?
        String studentName; // student name
        Student student; // To reference an student
        
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        StudentRecordsFileManager
        file = new StudentRecordsFileManager("Students.dat");
        
        // Report the number of records in the file.
        System.out.println("The Students.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        
        // Get a record number from the user and
        // allow the user to modify it.
        do
        {
            // Get the record number.
            System.out.print("Enter the number of the record " +
                            "you wish to modify: ");
            recordNumber = keyboard.nextInt();
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record number.
            file.moveFilePointer(recordNumber);
            
            // Read the record at that location.
            student = file.readStudent();
            
            // Display the existing contents.
            System.out.println("Existing data:");
            System.out.println("\nname: " +
                                student.getName());
            System.out.println("stid: " + student.getStid());
            
            // Get the new data.
            System.out.print("\nEnter the new name: ");
            studentName = keyboard.nextLine();
            System.out.print("Enter the number of stid: ");
            stid = keyboard.nextInt();
            keyboard.nextLine(); // Consume the remaining newline.
            
            // Store the new data in the object.
            student.setName(studentName);
            student.setStid(stid);
            
            // Make sure the user wants to save this data.
            System.out.print("Are you sure you want to save " +
                            "this data? (Y/N) ");
            sure = keyboard.nextLine();
            if (sure.charAt(0) == 'Y' || sure.charAt(0) == 'y')
            {
                // Move back to the record's starting position.
                file.moveFilePointer(recordNumber);
                // Save the new data.
                file.writeStudent(student);
            }
            
            // Ask the user whether to change another record.
            System.out.print("\nDo you want to modify another " +
                            "record? (Y/N): ");
            again = keyboard.nextLine();
        
        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Close the file.
        file.close();

        keyboard.close();
    }

}
