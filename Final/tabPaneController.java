package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import java.util.Arrays;
import java.util.stream.IntStream;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class tabPaneController implements Initializable
{

    StudentRecordsFileManager sfile =
            new StudentRecordsFileManager("Students.dat");

    CourseRecordsFileManager cfile =
            new CourseRecordsFileManager("Courses.dat");

    EnrollmentRecordsFileManager efile =
            new EnrollmentRecordsFileManager("Enrollments.dat");



    //ObservableList<String> semesterEnrollmentList =
    //        FXCollections.observableArrayList("Spring", "Summer", "Fall", "Winter");

    @FXML
    private ChoiceBox<String> ChoiceBoxEnrollmentSemester;

    @FXML
    private ChoiceBox<Integer> choiceBoxEnrollmentYear;



    @FXML
    private Tab tabStudentSearchTab;

    @FXML
    private Button btnAddCreateStudent;

    @FXML
    private Button btnResetAddStudentFields;

    @FXML
    private TextField txtFldStudentFullName;

    @FXML
    private TextField txtFldStudentAddress;

    @FXML
    private TextField txtFldStudentCity;

    @FXML
    private TextField txtFieldStudentState;

    @FXML
    private GridPane lblStdntSrch;

    @FXML
    private Button btnStudentSearch;

    @FXML
    private TextField txtFldStudentSearch;

    @FXML
    private TextField txtFldStudentToSearchFor;

    @FXML
    private Button btnEditStudent;

    @FXML
    private TextField txtFldStudentFullNameSearchResult;

    @FXML
    private TextField txtFldStudentAddressSearchResult;

    @FXML
    private TextField txtFldStudentCitySearchResult;

    @FXML
    private TextField txtFieldStudentStateSearchResult;

    @FXML
    private TextField txtFldStudentIDSearchResult;

    @FXML
    private ChoiceBox<String> choiceBoxStudents;

    @FXML
    private ChoiceBox<String> choiceBoxCourse;

    @FXML
    private Button btnAddCreateCourse;

    @FXML
    private Button btnResetAddCourseFields;

    @FXML
    private TextField txtFldCourseName;

    @FXML
    private TextField txtFldCourseInstructor;

    @FXML
    private TextField txtFldCourseDept;

    @FXML
    private TextField txtFldCourseNumber;

    @FXML
    private Button btnEditCourse;

    @FXML
    private Button btnResetAddCourseFields1;

    @FXML
    private TextField txtFldCourseNameSearchResult;

    @FXML
    private TextField txtFldCourseInstructorSearchResult;

    @FXML
    private TextField txtFldCourseDeptSearchResult;

    @FXML
    private TextField txtFldCourseNumberSearchResult;

    @FXML
    private TextField txtFldCourseIDSearchResult;

    @FXML
    private GridPane lblCourseSrch1;

    @FXML
    private Button btnCourseSearch;

    @FXML
    private TextField txtFldStudentSearch1;

    @FXML
    private TextField txtFldCourseToSearchFor;

    @FXML
    private TextField txtFldCourseID;

    @FXML
    private Button btnAddCreateEnrollment;

    @FXML
    private Button btnResetEnrollmentFields;

    @FXML
    private TextField txtFldStudentToSearchForEnrollmentScreen;

    @FXML
    private Button btnStudentSearchEnrollmentScreen;

    @FXML
    private ChoiceBox<Integer> choiceBoxEnrollmentStudent;

    @FXML
    private ChoiceBox<Integer> choiceBoxEnrollmentCourse;

    @FXML
    private ChoiceBox<Integer> choiceBoxEnrollmentSearchByStudent;

    @FXML
    private TextArea textAreaEnrollmentSearchResult;




    /*public int qtyOfStudentRecords() throws IOException {
        long numOfStudentRecordsLong = 0;
        numOfStudentRecordsLong = sfile.getNumberOfRecords();
        int numOfStudentRecordsInt = (int)numOfStudentRecordsLong;
        return numOfStudentRecordsInt;
    }*/

    //NOT WORKING
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ChoiceBoxEnrollmentSemester.getItems().addAll("Spring", "Summer", "Fall", "Winter");
        choiceBoxEnrollmentYear.getItems().addAll(2019, 2020);

        choiceBoxStudents.getItems().add("1");
        choiceBoxCourse.getItems().add("1");

        choiceBoxEnrollmentStudent.getItems().add(1);
        choiceBoxEnrollmentCourse.getItems().add(1);

        choiceBoxEnrollmentSearchByStudent.getItems().add(1);

        /*long numOfStudentRecordsLong = 0;
        try {
            numOfStudentRecordsLong = sfile.getNumberOfRecords();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        int numOfStudentRecordsInt = (int)numOfStudentRecordsLong;
        if (numOfStudentRecordsInt == 0)
        {
            choiceBoxStudents.getItems().add("No Students In Record");
        }
        else
            if(numOfStudentRecordsInt > 0)
            {
                for (int i = 1; i< numOfStudentRecordsInt; i++ )
                {
                    String count = String.valueOf(i);
                    choiceBoxStudents.getItems().add(count);
                }
            }*/


        /*long numOfCourseRecordsLong = 0;
        try {
            numOfCourseRecordsLong = cfile.getNumberOfRecords();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        int numOfCourseRecordsInt = (int)numOfCourseRecordsLong;
        if (numOfCourseRecordsInt == 0)
        {
            choiceBoxCourse.getItems().add("No Courses In Record");
        }
        else
        if(numOfCourseRecordsInt > 0)
        {
            for (int i = 1; i< numOfCourseRecordsInt; i++ )
            {
                String count = String.valueOf(i);
                choiceBoxCourse.getItems().add(count);
            }
        }*/

    }

    public tabPaneController() throws FileNotFoundException
    {

    }


    public void handleBtnClick(MouseEvent mouseEvent) throws IOException {



        if(mouseEvent.getSource() == btnAddCreateStudent)
        {
            String stdName = txtFldStudentFullName.getText();
            String stdAddress = txtFldStudentAddress.getText();
            String stdCity = txtFldStudentCity.getText();
            String stdState = txtFieldStudentState.getText();

            Student student = new Student(stdName, stdAddress, stdCity, stdState, sfile);
            sfile.CreateStudentFile(student);

        }

        else
        if(mouseEvent.getSource() == btnStudentSearch)
        {
            Student student;
            String studentToSearchForString = choiceBoxStudents.getValue();
            //String studentToSearchForString = txtFldStudentToSearchFor.getText();
            int convertedStudentID = Integer.parseInt(studentToSearchForString);
            student = sfile.ReadstudentFile(convertedStudentID);

            txtFldStudentIDSearchResult.setText(Integer.toString(student.getStid()));
            txtFldStudentFullNameSearchResult.setText(student.getName());
            txtFldStudentAddressSearchResult.setText(student.getAddress());
            txtFldStudentCitySearchResult.setText(student.getCity());
            txtFieldStudentStateSearchResult.setText(student.getState());

        }
        else
        if(mouseEvent.getSource() == btnStudentSearchEnrollmentScreen)
        {
            Enrollment enrollment;
            int studentToSearchForInt = choiceBoxEnrollmentSearchByStudent.getValue();
            //String studentToSearchForString = txtFldStudentToSearchFor.getText();
            //int convertedStudentID = Integer.parseInt(studentToSearchForString);
            enrollment = efile.ReadEnrollmentFile(studentToSearchForInt);

            // Display the record.
            textAreaEnrollmentSearchResult.setText(
                    "Student ID: " + enrollment.geteSID() +
                    "CNum: " + enrollment.geteCNum() +
                    "Year: " + enrollment.getYear() +
                    "Semester: " + enrollment.getSemester() +
                    "Grade: " + enrollment.getGrade() +
                    "Enrollment ID: " + enrollment.getEnrollmentID());

            //"Student ID: " + enrollment.geteSID();
            System.out.println("CNum: " + enrollment.geteCNum());
            System.out.println("Year: " +
                    enrollment.getYear());
            System.out.println("Semester: " +
                    enrollment.getSemester());
            System.out.println("Grade: " +
                    enrollment.getGrade());
            System.out.println("Enrollment ID: " +
                    enrollment.getEnrollmentID());


            /*txtFldStudentIDSearchResult.setText(Integer.toString(student.getStid()));
            txtFldStudentFullNameSearchResult.setText(student.getName());
            txtFldStudentAddressSearchResult.setText(student.getAddress());
            txtFldStudentCitySearchResult.setText(student.getCity());
            txtFieldStudentStateSearchResult.setText(student.getState());*/

        }
        else
        if(mouseEvent.getSource() == btnAddCreateCourse)
        {
            String crsName = txtFldCourseName.getText();
            String crsInstructor = txtFldCourseInstructor.getText();
            String crsDept = txtFldCourseDept.getText();
            String crsID = txtFldCourseID.getText();

            Course course = new Course(crsID, crsName, crsInstructor, crsDept, cfile);
            cfile.CreateCourseFile(course);

        }
        else
        if(mouseEvent.getSource() == btnCourseSearch)
        {
            Course course;
            String courseToSearchForString = choiceBoxCourse.getValue();
            //String courseToSearchForString = txtFldCourseToSearchFor.getText();
            int convertedCourseID = Integer.parseInt(courseToSearchForString);
            course = cfile.ReadCourseFile(convertedCourseID);

            txtFldCourseIDSearchResult.setText(course.getCid());
            txtFldCourseNameSearchResult.setText(course.getCname());
            txtFldCourseInstructorSearchResult.setText(course.getInstr());
            txtFldCourseDeptSearchResult.setText(course.getDept());
            txtFldCourseNumberSearchResult.setText(Integer.toString(course.getCnum()));
        }
        else
        if(mouseEvent.getSource() == btnAddCreateEnrollment)
        {
            int enrStudentID = choiceBoxEnrollmentStudent.getValue();
            int enrCourseNum = choiceBoxEnrollmentCourse.getValue();
            int enrYr = choiceBoxEnrollmentYear.getValue();
            String enrSem = ChoiceBoxEnrollmentSemester.getValue();
            char enrGRd;


            Enrollment enrollment = new Enrollment(enrStudentID, enrCourseNum, enrYr, enrSem, efile);
            efile.CreateEnrollmentFile(enrollment);



        }
        else
        if(mouseEvent.getSource() == choiceBoxStudents)
        {
            long numOfStudentRecordsLong = sfile.getNumberOfRecords();
            int numOfStudentRecordsInt = (int)numOfStudentRecordsLong;

            choiceBoxStudents.getItems().clear();

            for (int i = 1; i <= numOfStudentRecordsInt; i++)
            {
                String count = String.valueOf(i);
                choiceBoxStudents.getItems().add(count);
            }

        }
        else
        if(mouseEvent.getSource() == choiceBoxEnrollmentSearchByStudent)
        {
            long numOfStudentRecordsLong = sfile.getNumberOfRecords();
            int numOfStudentRecordsInt = (int)numOfStudentRecordsLong;

            choiceBoxEnrollmentSearchByStudent.getItems().clear();

            for (int i = 1; i <= numOfStudentRecordsInt; i++)
            {
                choiceBoxEnrollmentSearchByStudent.getItems().add(i);
            }

        }
        else
        if(mouseEvent.getSource() == choiceBoxCourse)
        {
            long numOfCourseRecordsLong = sfile.getNumberOfRecords();
            int numOfCourseRecordsInt = (int)numOfCourseRecordsLong;

            choiceBoxCourse.getItems().clear();

            for (int i = 1; i <= numOfCourseRecordsInt; i++)
            {
                String count = String.valueOf(i);
                choiceBoxCourse.getItems().add(count);
            }

        }
        else
        if(mouseEvent.getSource() == choiceBoxEnrollmentStudent)
        {
            long numOfStudentRecordsLong = sfile.getNumberOfRecords();
            int numOfStudentRecordsInt = (int)numOfStudentRecordsLong;

            choiceBoxEnrollmentStudent.getItems().clear();

            for (int i = 1; i <= numOfStudentRecordsInt; i++)
            {
                choiceBoxEnrollmentStudent.getItems().add(i);
            }

        }
        else
        if(mouseEvent.getSource() == choiceBoxEnrollmentCourse)
        {
            long numOfCourseRecordsLong = cfile.getNumberOfRecords();
            int numOfCourseRecordsInt = (int)numOfCourseRecordsLong;

            choiceBoxEnrollmentCourse.getItems().clear();

            for (int i = 1; i <= numOfCourseRecordsInt; i++)
            {
                choiceBoxEnrollmentCourse.getItems().add(i);
            }


        }



    }




    /**
     * StudentInformationSystem
     * */
    //static class StudentInformationSystem

    public static Scanner keyboard = new Scanner(System.in);

    //Student student;
    //Course course;
    //Enrollment enrollment;
    //int choice;



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




    /*
    This program allows the user to MODIFY records in the
    STUDENTS.DAT file.
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



    /*
    This program allows the user to MODIFY records in the
    COURSES.DAT file.
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



    /*
    This program allows the user to MODIFY records in the
    ENROLLMENTS.DAT file.
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
