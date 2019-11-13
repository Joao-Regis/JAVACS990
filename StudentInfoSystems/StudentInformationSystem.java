import java.io.*;
import java.util.Scanner;


/**
 * StudentInformationSystem
 */
public class StudentInformationSystem
{
    public static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) throws IOException 
    {
        StudentRecordsFileManager sfile = 
            new StudentRecordsFileManager("Students.dat");
        
        CourseRecordsFileManager cfile = 
            new CourseRecordsFileManager("Courses.dat");
        
        EnrollmentRecordsFileManager efile = 
            new EnrollmentRecordsFileManager("Enrollments.dat");

        Student student;
        Course course;
        Enrollment enrollment;

        int choice;
        //int subChoice;
    

        do
        {
            choice = displayMenu();
            keyboard.nextLine();
            switch(choice)
            {   case 1:
                    System.out.println("Create new student");
                    student = collectStudentInfo();
                    System.out.println(student);
                    sfile.getNumberOfRecords();
                    //file.writeStudent(student);
                    CreateStudentFile(student, sfile);

                    break;
                
                case 2:
                    System.out.println("Create new course");
                    course = collectCourseInfo();
                    System.out.println(course);
                    cfile.getNumberOfRecords();
                    //file.writeStudent(student);
                    CreateCourseFile(course, cfile);

                    break;
                
                case 3:
                    System.out.println("Create new enrollment");
                    enrollment = collectEnrollmentInfo(sfile, cfile);
                    System.out.println(enrollment);
                    efile.getNumberOfRecords();
                    //file.writeStudent(student);
                    CreateEnrollmentFile(enrollment, efile);

                    break;
                
                
                
                case 4:
                    System.out.println("Edit student");
                    ModifyRecord(sfile);
                    break;
                
                case 5:
                    System.out.println("Edit course");
                    ModifyRecord(cfile);
                    break;


                case 6:
                    System.out.println("Edit enrollment");
                    ModifyRecord(efile);
                    break;
                
                case 7:
                    System.out.println("Display student");
                    ReadstudentFile(sfile);
                    break;
                
                case 8:
                    System.out.println("Display course");
                    ReadCourseFile(cfile);
                    break;


                case 9:
                    System.out.println("Display enrollment");
                    ReadEnrollmentFile(efile);
                    break;
                
                case 0:
                    sfile.close();
                    cfile.close();
                    System.out.println("Goodbye.");
                    System.exit(0);
                    break;


                case 10:
                    int subChoice;
                    do
                    {
                        subChoice = displaySubMenu();
                        switch (subChoice)
                        {
                            case 1:
                                int stdntIDview = studentIdSelectionView();
                                viewGradesByStudent(efile, stdntIDview);
                                break;
                            case 2:
                                //int crsNum = courseNumSelection();
                                viewGradesByCourse(efile);
                                break;
                            case 3:
                                int stdntIDedit = studentIdSelectionEdit();
                                ModifyEnrollmentGradeByStudent(efile, stdntIDedit);
                                break;
                            case 4:
                                int courseNum = courseNumSelection();
                                ModifyEnrollmentGradeByStudent(efile, courseNum);
                                break;
                            case 0:
                                break;
                        }        
                    } while(subChoice != 0);

                
            }


        } while(choice != 0);


        
    
        //keyboard.close();
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
            //keyboard.nextLine();
        }
        //keyboard.nextLine();
        return selection;
    }

    public static int displaySubMenu()
    {
        int subSelection;

        System.out.println("\nGrades Menu");
        System.out.println("1. View Grades by Student");
        System.out.println("2. View Grades by Course");
        System.out.println("3. Edit Grades by Student");
        System.out.println("4. Edit Grades by Course");
        System.out.println("0. --- Exit to Menu ---");
        System.out.println("Please enter a valid choice(1-4, 0 to Exit)");

        subSelection = keyboard.nextInt();
        while (subSelection < 0 || subSelection > 4)
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Please enter a valid choice(1-4, 0 to Quit)");
            subSelection = keyboard.nextInt();
            //keyboard.nextLine();
        }
        //keyboard.nextLine();
        return subSelection;

    }

    public static Student collectStudentInfo()
    {
        String studentName;
        String studentAddress;
        String studentCity;
        String studentState;
        
        Student aStudent;

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

        aStudent = new Student(studentName, studentAddress, studentCity, studentState);
        return aStudent;
    }



    public static Course collectCourseInfo()
    {
        String courseID;
        String courseName;
        String courseInstr;
        String courseDept;
        
        Course aCourse;

        System.out.println("\nEnter course's ID.");
        courseID = keyboard.nextLine();
        while(courseID == null || courseID.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter course's ID.");
            courseID = keyboard.nextLine();
        }

        System.out.println("\nEnter course's name.");
        courseName = keyboard.nextLine();
        while(courseName == null || courseName.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter course's name.");
            courseName = keyboard.nextLine();
        }

        System.out.println("\nEnter course's instructor.");
        courseInstr = keyboard.nextLine();
        while(courseInstr == null || courseInstr.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter course's instructor.");
            courseInstr = keyboard.nextLine();
        }
        
        System.out.println("\nEnter course's dept.");
        courseDept = keyboard.nextLine();
        while(courseDept == null || courseDept.trim().isEmpty())
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Enter course's dept.");
            courseDept = keyboard.nextLine();
        }

        aCourse = new Course(courseID, courseName, courseInstr, courseDept);
        return aCourse;
    }



public static int validateStudent(StudentRecordsFileManager stdFile, int stdntNoSelected) throws IOException
{
    StudentRecordsFileManager sFile = stdFile;
    int eSID = stdntNoSelected;
    long snum = sFile.getNumberOfRecords();
    int numOfStudentRecords = (int)snum;

    while(eSID < 0 || eSID > numOfStudentRecords)
            {
                System.out.println("\nCurrent num of students " +  
                                    numOfStudentRecords);
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new  Student ID.");
                eSID = keyboard.nextInt();
            }

    return eSID;
}



    public static Enrollment collectEnrollmentInfo(StudentRecordsFileManager stdFile, CourseRecordsFileManager crsFile)
            throws IOException
    {
        int eSID;
        int eCNUM;
        int eYear;
        String eSemester;
        char eGrade;
        
        StudentRecordsFileManager sFile = stdFile;
        CourseRecordsFileManager cFile = crsFile;
        Enrollment aEnrollment;

        long snum = sFile.getNumberOfRecords();
        int numOfStudentRecords = (int)snum;

        long cnum = cFile.getNumberOfRecords();
        int numOfCourseRecords = (int)cnum;


        

        System.out.println("\nCurrent num of students " +  
                                numOfStudentRecords);
        System.out.println("Enter student ID.");
        
            eSID = keyboard.nextInt();
            while(eSID < 0 || eSID > numOfStudentRecords)
            {
                System.out.println("\nCurrent num of students " +  
                                    numOfStudentRecords);
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new  Student ID.");
                eSID = keyboard.nextInt();
            }

            System.out.println("\nCurrent num of courses " +  
                                numOfCourseRecords);
            System.out.println("Enter course Num.");
            eCNUM = keyboard.nextInt();
            while(eCNUM < 0 || eCNUM > numOfCourseRecords)
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("\nCurrent num of courses " +  
                                        numOfCourseRecords);
                System.out.println("Enter new course Num.");
                eCNUM = keyboard.nextInt();
            }

            System.out.println("\nOnly 2015 - 2020 allowed"); 
            System.out.println("Enter year.");
            eYear = keyboard.nextInt();
            keyboard.nextLine();
            //int yrLength = String.valueOf(eYear).length();
            while(eYear < 2015 || eYear > 2020)
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("\nOnly 2015 - 2020 allowed");
                System.out.println("Enter new year.");
                eYear = keyboard.nextInt();
                keyboard.nextLine();
            }
            
            
            /* while(yrLength < 0 || yrLength > 4 || eYear < 0)
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new year.");
                eYear = keyboard.nextInt();
            } */
            

            System.out.println("\nSemester options: Winter, Spring, Summer, Fall");
            System.out.println("Enter semester.");
            
            eSemester = keyboard.nextLine();
            /* while(eSemester.trim().isEmpty() ||
                    (!eSemester.equals("Winter")) || (!eSemester.equals("winter")) || 
                    (!eSemester.equals("Spring")) || (!eSemester.equals("spring")) || 
                    (!eSemester.equals("Summer")) || (!eSemester.equals("summer")) || 
                    (!eSemester.equals("Fall")) || (!eSemester.equals("fall"))  )
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter Winter, Spring, Summer or Fall");
                eSemester = keyboard.nextLine();
            } */


            System.out.println("\nGrade options: A, B, C, D or F");
            System.out.println("Enter new grade.");
            eGrade = keyboard.next().charAt(0);
            /* while(eGrade != 'A' || eGrade != 'a' ||
                    eGrade != 'B' || eGrade != 'b' ||
                    eGrade != 'C' || eGrade != 'c' ||
                    eGrade != 'D' || eGrade != 'd' ||
                    eGrade != 'F' || eGrade != 'f' )
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new grade.");
                eGrade = keyboard.next().charAt(0);
            } */

        aEnrollment = new Enrollment(eSID, eCNUM, eYear, eSemester, eGrade);
        return aEnrollment;
    }










    public static int courseNumSelection()
    {   
        int cNumSelected;

        System.out.print("Enter the course Number of the student's grades" +
                            "you wish to edit: ");
        cNumSelected = keyboard.nextInt();
        return cNumSelected;
    }

    public static int courseYearSelection()
    {   
        int cYearSelected;

        System.out.print("Enter the course year of the student's grades" +
                            "you wish to see: ");
        cYearSelected = keyboard.nextInt();
        return cYearSelected;
    }



    public static void viewGradesByCourse(EnrollmentRecordsFileManager aFile) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        //int cNum = crsNum;
        Enrollment enrollment;

        int cNumSelected;
        int cYearSelected;
        String cSemSelected;

        System.out.print("Enter the course Number of the grades " +
                            "you wish to view: ");
        cNumSelected = keyboard.nextInt();

        for(int i = 0; i < file.getNumberOfRecords(); i++)
        {
            // Move the file pointer to that record.
            file.moveFilePointer(i);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            if(enrollment.geteCNum() == cNumSelected)
            {   
                System.out.print("Enter the Year of courseNum " + cNumSelected +
                            " you wish to see: ");
                cYearSelected = keyboard.nextInt();
                keyboard.nextLine();
                
                if(enrollment.getYear() == cYearSelected)
                {
                    System.out.print("Enter the Semester of courseNum " + cNumSelected +
                            " in the year " + cYearSelected + " you wish to see: ");
                    cSemSelected = keyboard.nextLine();
                    
                    if((enrollment.getSemester().trim()).equals(cSemSelected))
                    {
                        // Display the record.
                        System.out.println("Student ID: " + enrollment.geteSID());
                        System.out.println("CNum: " + enrollment.geteCNum());
                        System.out.println("Year: " + enrollment.getYear());
                        System.out.println("Semester: " + enrollment.getSemester());
                        System.out.println("Grade: " + enrollment.getGrade());
                        System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
                    }
                }   
            }
        }
    }





    public static int studentIdSelectionView()
    {   
        int sidSelected;

        System.out.print("Enter the id# of the student's grades" +
                            "you wish to see: ");
        sidSelected = keyboard.nextInt();
        return sidSelected;
    }


    public static int studentIdSelectionEdit()
    {   
        int sidSelected;

        System.out.print("Enter the id# of the student's grades" +
                            "you wish to edit: ");
        sidSelected = keyboard.nextInt();
        return sidSelected;
    }


    public static void viewGradesByStudent(EnrollmentRecordsFileManager aFile, int stdntID) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        int stid = stdntID;
        Enrollment enrollment;

        for(int i = 0; i < file.getNumberOfRecords(); i++)
        {
            // Move the file pointer to that record.
            file.moveFilePointer(i);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            if(enrollment.geteSID() == stid )
            {
                // Display the record.
                System.out.println("Student ID: " + enrollment.geteSID());
                System.out.println("CNum: " + enrollment.geteCNum());
                System.out.println("Year: " + enrollment.getYear());
                System.out.println("Semester: " + enrollment.getSemester());
                System.out.println("Grade: " + enrollment.getGrade());
                System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
            }
        }
    }




    


    /* public static void viewGradesByStudent(StudentRecordsFileManager aFile, int stid) {
        StudentRecordsFileManager file = aFile;
        try {
            for (int i = 0; i < file.getNumberOfRecords(); i++) {

            }
        } catch (IOException e) {
            // auto generated catch block
            e.printStackTrace();
        }
    } */






    /**
     * This program uses the studentFile class to create a file 
     * containing data from 5 Student objects.
     * 
     * @throws IOException
     */

    public static void CreateStudentFile(Student aStudent, StudentRecordsFileManager aFile) throws IOException
    {
        StudentRecordsFileManager file = aFile;

        // move file pointer to eof to append new student.
        file.moveFilePointer(file.getNumberOfRecords());

        file.writeStudent(aStudent);
    
        System.out.println("The data was written to the " +
                            "Students.dat file.");
        
    }
    
    
 

    /**
     * This program displays specified records from the Students.dat file.
     * 
     * @throws IOException
     */

    public static void ReadstudentFile(StudentRecordsFileManager aFile) throws IOException
    {
    
        StudentRecordsFileManager file = aFile;
        
        int recordNumber;     // Record number
        String again;         // To get a Y or an N
        Student student;   // An object from the file
        
        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* StudentRecordsFileManager
        file = new StudentRecordsFileManager("Students.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Students.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        // Get a record number from the user and
        // display the record.
        do
        {
            // Get the record number.
            System.out.print("Enter the id# of the student" +
                            "you wish to see: ");
            recordNumber = keyboard.nextInt();
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record.
            file.moveFilePointer(recordNumber - 1);
            
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
            
            // Consume the remaining newline.
            //keyboard.nextLine();

        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Consume the remaining newline.
        //keyboard.nextLine();

        // Close the file.
        //file.close();

        //displayMenu();

        //keyboard.close();
    }





    /*
    This program allows the user to modify records in the
    Students.dat file.
    */

    public static void ModifyRecord(StudentRecordsFileManager aFile) throws IOException
    {
        StudentRecordsFileManager file = aFile;
        
        int recordNumber;   // Record number
        //int stid;          // stid on hand
        String again;       // Want to change another one?
        String sure;        // Is the user sure?
        //String studentName; // student name
        Student student; // To reference an student

        String studentName;
        String studentAddress;
        String studentCity;
        String studentState;
        

        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* StudentRecordsFileManager
        file = new StudentRecordsFileManager("Students.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Students.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        
        // Get a record number from the user and
        // allow the user to modify it.
        do
        {
            // Get the record number.
            System.out.print("Enter the ID# of the student's " +
                            "record you wish to modify: ");
            recordNumber = (keyboard.nextInt()) - 1;
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record number.
            file.moveFilePointer(recordNumber);
            
            // Read the record at that location.
            student = file.readStudent();
            
            // Display the existing contents.
            System.out.println("Existing data:");
            // Display the record.
            System.out.println("stid: " + student.getStid());
            System.out.println("\nName: " +
                                student.getName());
            System.out.println("Address: " +
                                student.getAddress());
            System.out.println("City: " +
                                student.getCity());
            System.out.println("State: " +
                                student.getState());
            
            
            
            // Get the new data.


            System.out.println("\nEnter student's newname.");
            studentName = keyboard.nextLine();
            while(studentName == null || studentName.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter student's new name.");
                studentName = keyboard.nextLine();
            }

            System.out.println("\nEnter student's new address.");
            studentAddress = keyboard.nextLine();
            while(studentAddress == null || studentAddress.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter student's new address.");
                studentAddress = keyboard.nextLine();
            }

            System.out.println("\nEnter student's new city.");
            studentCity = keyboard.nextLine();
            while(studentCity == null || studentCity.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter student's new city.");
                studentCity = keyboard.nextLine();
            }
            
            System.out.println("\nEnter student's new state.");
            studentState = keyboard.nextLine();
            while(studentState == null || studentState.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter student's new state.");
                studentState = keyboard.nextLine();
            }



            //System.out.print("\nEnter the new name: ");
            //studentName = keyboard.nextLine();
            //System.out.print("Enter the number of stid: ");
            //stid = keyboard.nextInt();
            //keyboard.nextLine(); // Consume the remaining newline.
            
            // Store the new data in the object.
            student.setName(studentName);
            student.setAddress(studentAddress);
            student.setCity(studentCity);
            student.setState(studentState);
            //student.setStid(stid);
            
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
        //file.close();

        //keyboard.close();

        //displayMenu();

    }


















    /**
     * This program uses the courseFile class to create a file 
     * containing data from 5 course objects.
     * 
     * @throws IOException
     */

    public static void CreateCourseFile(Course aCourse, CourseRecordsFileManager aFile) throws IOException
    {
        CourseRecordsFileManager file = aFile;
        
        file.moveFilePointer(file.getNumberOfRecords());

        file.writeCourse(aCourse);

        System.out.println("The data was written to the " +
                            "Courses.dat file.");
    }
    




    /* public static void writeCourse(Student aCourse)
    {
        file.writeCourse(aCourse);
        System.out.println("The data was written to the " +
                            "Students.dat file.");
    } */


    /**
     * This program displays specified records from the Courses.dat file.
     * 
     * @throws IOException
     */

    public static void ReadCourseFile(CourseRecordsFileManager aFile) throws IOException
    {
    
        CourseRecordsFileManager file = aFile;
        
        int recordNumber;     // Record number
        String again;         // To get a Y or an N
        Course course;   // An object from the file
        
        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* CourseRecordsFileManager
        file = new CourseRecordsFileManager("Courses.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Courses.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        // Get a record number from the user and
        // display the record.
        do
        {
            // Get the record number.
            System.out.print("Enter the cnum of the course" +
                            "you wish to see: ");
            recordNumber = keyboard.nextInt();
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record.
            file.moveFilePointer(recordNumber - 1);
            
            // Read the record at that location.
            course = file.readCourse();
            
            // Display the record.
            System.out.println("CID: " +
                                course.getCid());
            System.out.println("CName: " +
                                course.getCname());
            System.out.println("Instructor: " +
                                course.getInstr());
            System.out.println("Department: " +
                                course.getDept());
            System.out.println("CNum: " + course.getCnum());
            
            // Ask the user whether to get another record.
            System.out.print("\nDo you want to see another " +
                            "record? (Y/N): ");
            again = keyboard.nextLine();
            
            // Consume the remaining newline.
            //keyboard.nextLine();

        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Consume the remaining newline.
        //keyboard.nextLine();

        // Close the file.
        //file.close();

        //displayMenu();

        //keyboard.close();
    }





    /*
    This program allows the user to modify records in the
    Courses.dat file.
    */

    public static void ModifyRecord(CourseRecordsFileManager aFile) throws IOException
    {
        CourseRecordsFileManager file = aFile;
        
        int recordNumber;   // Record number
        //int stid;          // stid on hand
        String again;       // Want to change another one?
        String sure;        // Is the user sure?
        //String courseCID; // student name
        Course course; // To reference an course

        String courseCID;
        String courseName;
        String courseInstr;
        String courseDept;
        

        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* CourseRecordsFileManager
        file = new CourseRecordsFileManager("Students.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Courses.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        
        // Get a record number from the user and
        // allow the user to modify it.
        do
        {
            // Get the record number.
            System.out.print("Enter the CNum of the course's " +
                            "record you wish to modify: ");
            recordNumber = (keyboard.nextInt()) - 1;
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record number.
            file.moveFilePointer(recordNumber);
            
            // Read the record at that location.
            course = file.readCourse();
            
            // Display the existing contents.
            System.out.println("Existing data:");
            // Display the record.
            System.out.println("Cnum: " + course.getCnum());
            System.out.println("\nCname: " +
                                course.getCname());
            System.out.println("Instructor: " +
                                course.getInstr());
            System.out.println("Dept: " +
                                course.getDept());
            System.out.println("CID: " +
                                course.getCid());
            
            
            
            // Get the new data.


            System.out.println("\nEnter course's new CID.");
            courseCID = keyboard.nextLine();
            while(courseCID == null || courseCID.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter course's new CID.");
                courseCID = keyboard.nextLine();
            }

            System.out.println("\nEnter courses's new name.");
            courseName = keyboard.nextLine();
            while(courseName == null || courseName.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter courses's new name.");
                courseName = keyboard.nextLine();
            }

            System.out.println("\nEnter course's new Instructor.");
            courseInstr = keyboard.nextLine();
            while(courseInstr == null || courseInstr.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter course's new Instructor.");
                courseInstr = keyboard.nextLine();
            }
            
            System.out.println("\nEnter courses's new dept.");
            courseDept = keyboard.nextLine();
            while(courseDept == null || courseDept.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter course's new dept.");
                courseDept = keyboard.nextLine();
            }



            //System.out.print("\nEnter the new name: ");
            //courseCID = keyboard.nextLine();
            //System.out.print("Enter the number of stid: ");
            //stid = keyboard.nextInt();
            //keyboard.nextLine(); // Consume the remaining newline.
            
            // Store the new data in the object.
            course.setCid(courseCID);
            course.setCname(courseName);
            course.setInstr(courseInstr);
            course.setDept(courseDept);
            //student.setStid(stid);
            
            // Make sure the user wants to save this data.
            System.out.print("Are you sure you want to save " +
                            "this data? (Y/N) ");
            sure = keyboard.nextLine();
            if (sure.charAt(0) == 'Y' || sure.charAt(0) == 'y')
            {
                // Move back to the record's starting position.
                file.moveFilePointer(recordNumber);
                // Save the new data.
                file.writeCourse(course);
            }
            
            // Ask the user whether to change another record.
            System.out.print("\nDo you want to modify another " +
                            "record? (Y/N): ");
            again = keyboard.nextLine();
        
        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Close the file.
        //file.close();

        //keyboard.close();

        //displayMenu();

    }
















    /**
     * This program uses the enrollmentFile class to create a file 
     * containing data from 5 Enrollment objectss.
     * 
     * @throws IOException
     */

    public static void CreateEnrollmentFile(Enrollment aEnrollment, EnrollmentRecordsFileManager aFile) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        
        // move file pointer to eof to append new enrollment.
        file.moveFilePointer(file.getNumberOfRecords());

        file.writeEnrollment(aEnrollment);
        
        System.out.println("The data was written to the " +
                            "Enrollments.dat file.");
    }
    


    /* public static void writeEnrollment(Student aEnrollment)
    {
        file.writeEnrollment(aEnrollment);
        System.out.println("The data was written to the " +
                            "Students.dat file.");
    } */


    /**
     * This program displays specified records from the Enrollments.dat file.
     * 
     * @throws IOException
     */

    public static void ReadEnrollmentFile(EnrollmentRecordsFileManager aFile) throws IOException
    {
    
        EnrollmentRecordsFileManager file = aFile;
        
        int recordNumber;     // Record number
        String again;         // To get a Y or an N
        Enrollment enrollment;   // An object from the file
        
        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* EnrollmentRecordsFileManager
        file = new EnrollmentRecordsFileManager("Enrollments.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Enrollments.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        // Get a record number from the user and
        // display the record.
        do
        {
            // Get the record number.
            System.out.print("Enter a student id to view " +
                            "enrollment record: ");
            recordNumber = keyboard.nextInt();
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record.
            file.moveFilePointer(recordNumber - 1);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            // Display the record.
            System.out.println("Student ID: " +
                                enrollment.geteSID());
            System.out.println("CNum: " + enrollment.geteCNum());
            System.out.println("Year: " +
                                enrollment.getYear());
            System.out.println("Semester: " +
                                enrollment.getSemester());
            System.out.println("Grade: " +
                                enrollment.getGrade());
            System.out.println("Enrollment ID: " +
                                enrollment.getEnrollmentID());
            
            
            // Ask the user whether to get another record.
            System.out.print("\nDo you want to see another " +
                            "enrollment record? (Y/N): ");
            again = keyboard.nextLine();
            
            // Consume the remaining newline.
            //keyboard.nextLine();

        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
        
        // Consume the remaining newline.
        //keyboard.nextLine();

        // Close the file.
        //file.close();

        //displayMenu();

        //keyboard.close();
    }





    /*
    This program allows the user to modify records in the
    Enrollments.dat file.
    */

    public static void ModifyRecord(EnrollmentRecordsFileManager aFile) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        
        int recordNumber;   // Record number
        //int stid;          // stid on hand
        String again;       // Want to change another one?
        String sure;        // Is the user sure?
        //String eSID; // student name
        Enrollment enrollment; // To reference an enrollment

        int eSID;
        int eCNUM;
        int eYear;
        String eSemester;
        char eGrade;

        // Create a Scanner object for keyboard input.
        //Scanner keyboard = new Scanner(System.in);
        
        // Open the file.
        /* EnrollmentRecordsFileManager
        file = new EnrollmentRecordsFileManager("Students.dat"); */
        
        // Report the number of records in the file.
        System.out.println("The Enrollments.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        
        // Get a record number from the user and
        // allow the user to modify it.
        do
        {
            // Get the record number.
            System.out.print("Enter the student ID whose " +
                        "enrollment record you wish to modify: ");
            recordNumber = (keyboard.nextInt()) - 1;
            
            // Consume the remaining newline.
            keyboard.nextLine();
            
            // Move the file pointer to that record number.
            file.moveFilePointer(recordNumber);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            // Display the existing contents.
            System.out.println("Existing data:");
            // Display the record.
            System.out.println("\nSID: " + enrollment.geteSID());
            System.out.println("Cnum: " + enrollment.geteCNum());
            System.out.println("Year: " + enrollment.getYear());
            System.out.println("Semester: " + enrollment.getSemester());
            System.out.println("Grade: " + enrollment.getGrade());
            System.out.println("EnrollmentID: " + enrollment.getEnrollmentID());
            
            
            
            // Get the new data.


            System.out.println("\nEnter new student ID.");
            eSID = keyboard.nextInt();
            /* while(eSID == null || eSID.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new  Student ID.");
                eSID = keyboard.nextInt();
            } */

            System.out.println("\nEnter new course Num.");
            eCNUM = keyboard.nextInt();
            /* while(eCNUM == null || eCNUM.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new course Num.");
                eCNUM = keyboard.nextInt();
            } */

            System.out.println("\nEnter new year.");
            eYear = keyboard.nextInt();
            keyboard.nextLine();
            /* while(eYear == null || eYear.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new year.");
                eYear = keyboard.nextInt();
            } */
            
            System.out.println("\nEnter new semester.");
            eSemester = keyboard.nextLine();
            /* while(eSemester == null || eSemester.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new semester.");
                eSemester = keyboard.nextLine();
            } */



            System.out.println("\nEnter new grade.");
            eGrade = keyboard.next().charAt(0);
            keyboard.nextLine();
            /* while(eGrade == null || eGrade.trim().isEmpty())
            {
                System.out.println("Invalid entry. Try again.");
                System.out.println("Enter new grade.");
                eGrade = keyboard.nextChar();
            } */
            

            // Store the new data in the object.
            enrollment.seteSID(eSID);
            enrollment.seteCNum(eCNUM);
            enrollment.setYear(eYear);
            enrollment.setSemester(eSemester);
            enrollment.setGrade(eGrade);
            
            
            // Make sure the user wants to save this data.
            System.out.print("Are you sure you want to save " +
                            "this data? (Y/N) ");
            sure = keyboard.nextLine();
            if (sure.charAt(0) == 'Y' || sure.charAt(0) == 'y')
            {
                // Move back to the record's starting position.
                file.moveFilePointer(recordNumber);
                // Save the new data.
                file.writeEnrollment(enrollment);
            }
            
            // Ask the user whether to change another record.
            System.out.print("\nDo you want to modify another " +
                            "record? (Y/N): ");
            again = keyboard.nextLine();
        
        } while (again.charAt(0) == 'Y' || again.charAt(0) == 'y');
    }











    public static void ModifyEnrollmentGradeByStudent(EnrollmentRecordsFileManager aFile, int stdntID) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        int stid = stdntID;
        
        //int recordNumber;   // Record number
        //String again;       // Want to change another one?
        String sure;        // Is the user sure?
        Enrollment enrollment; // To reference an enrollment

        char eGrade;
        
        // Report the number of records in the file.
        System.out.println("The Enrollments.dat file has " +
                    file.getNumberOfRecords() + " records.");
        


        for(int i = 0; i < file.getNumberOfRecords(); i++)
        {
            // Move the file pointer to that record.
            file.moveFilePointer(i);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            if(enrollment.geteSID() == stid)
            {
                // Display the record.
                System.out.println("Existing data:");
                System.out.println("Student ID: " + enrollment.geteSID());
                System.out.println("CNum: " + enrollment.geteCNum());
                System.out.println("Year: " + enrollment.getYear());
                System.out.println("Semester: " + enrollment.getSemester());
                System.out.println("Grade: " + enrollment.getGrade());
                System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
            
                
                // Get the new data.
                System.out.println("\nEnter new grade.");
                eGrade = keyboard.next().charAt(0);
                keyboard.nextLine();
                /* while(eGrade == null || eGrade.trim().isEmpty())
                {
                    System.out.println("Invalid entry. Try again.");
                    System.out.println("Enter new grade.");
                    eGrade = keyboard.nextChar();
                } */


                enrollment.setGrade(eGrade);
                
                
                // Make sure the user wants to save this data.
                System.out.print("Are you sure you want to save " +
                                "this data? (Y/N) ");
                sure = keyboard.nextLine();
                if (sure.charAt(0) == 'Y' || sure.charAt(0) == 'y')
                {
                    // Move back to the record's starting position.
                    file.moveFilePointer(i);
                    // Save the new data.
                    file.writeEnrollment(enrollment);

                    // Display the record.
                    System.out.println("Grade Updated to:");
                    System.out.println("Student ID: " + enrollment.geteSID());
                    System.out.println("CNum: " + enrollment.geteCNum());
                    System.out.println("Year: " + enrollment.getYear());
                    System.out.println("Semester: " + enrollment.getSemester());
                    System.out.println("Grade: " + enrollment.getGrade());
                    System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
                }
            }
        }
        

    }






    public static void ModifyEnrollmentGradeByCourse(EnrollmentRecordsFileManager aFile, int courseNum) throws IOException
    {
        EnrollmentRecordsFileManager file = aFile;
        int crsNum = courseNum ;
        
        //int recordNumber;   // Record number
        //String again;       // Want to change another one?
        String sure;        // Is the user sure?
        Enrollment enrollment; // To reference an enrollment

        char eGrade;
        
        // Report the number of records in the file.
        System.out.println("The Enrollments.dat file has " +
                    file.getNumberOfRecords() + " records.");
        
        
        // Get a record number from the user and
        // allow the user to modify it.
        
        // Get the record number.
        /* System.out.print("Enter the student ID whose " +
                    "enrollment grade record you wish to modify: "); */


        for(int i = 0; i < file.getNumberOfRecords(); i++)
        {
            // Move the file pointer to that record.
            file.moveFilePointer(i);
            
            // Read the record at that location.
            enrollment = file.readEnrollment();
            
            if(enrollment.geteCNum() == crsNum)
            {
                // Display the record.
                System.out.println("Existing data:");
                System.out.println("Student ID: " + enrollment.geteSID());
                System.out.println("CNum: " + enrollment.geteCNum());
                System.out.println("Year: " + enrollment.getYear());
                System.out.println("Semester: " + enrollment.getSemester());
                System.out.println("Grade: " + enrollment.getGrade());
                System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
            
                
                
                // Get the new data.
                System.out.println("\nEnter new grade.");
                eGrade = keyboard.next().charAt(0);
                keyboard.nextLine();
                /* while(eGrade == null || eGrade.trim().isEmpty())
                {
                    System.out.println("Invalid entry. Try again.");
                    System.out.println("Enter new grade.");
                    eGrade = keyboard.nextChar();
                } */


                enrollment.setGrade(eGrade);
                
                
                // Make sure the user wants to save this data.
                System.out.print("Are you sure you want to save " +
                                "this data? (Y/N) ");
                sure = keyboard.nextLine();
                if (sure.charAt(0) == 'Y' || sure.charAt(0) == 'y')
                {
                    // Move back to the record's starting position.
                    file.moveFilePointer(i);
                    // Save the new data.
                    file.writeEnrollment(enrollment);

                    // Display the record.
                    System.out.println("Grade Updated to:");
                    System.out.println("Student ID: " + enrollment.geteSID());
                    System.out.println("CNum: " + enrollment.geteCNum());
                    System.out.println("Year: " + enrollment.getYear());
                    System.out.println("Semester: " + enrollment.getSemester());
                    System.out.println("Grade: " + enrollment.getGrade());
                    System.out.println("Enrollment ID: " + enrollment.getEnrollmentID());
                }
            }
        }
        

    }






}
