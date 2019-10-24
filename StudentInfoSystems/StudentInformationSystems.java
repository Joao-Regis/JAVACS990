import java.util.Scanner;

/**
 * StudentInformationSystem
 */
public class StudentInformationSystem {
    static int choice;
    
    String studentName;
    String studentAddress;
    String studentCity;
    String studentState;

    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        String studentName;
        String studentAddress;
        String studentCity;
        String studentState;



        do
        {
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

            choice = keyboard.nextInt();

        } while(choice !=0);


        switch(choice)
        {
            case 1:
            System.out.println("Enter student's name.");
            studentName = keyboard.nextLine();
            System.out.println("Enter student's address.");
            studentAddress = keyboard.nextLine();
            System.out.println("Enter student's city.");
            studentCity = keyboard.nextLine();
            System.out.println("Enter student's state.");
            studentState = keyboard.nextLine();

            Student choice = new Student(studentName, studentAddress, studentCity, studentState);

            break;

            case 2:
            displaySubMenu();
            break;
        }
    
        keyboard.close();
    }

    static void displayMenu()
    {
        while(choice !=0)
        {
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
        }


        switch(choice)
        {
            case 1:
            displayMenu();
            break;

            case 2:
            displaySubMenu();
            break;
        }

    }

    static void displaySubMenu()
    {
        System.out.println("\nGrades Menu");
        System.out.println("1. View Grades by Student");
        System.out.println("2. View Grades by Course");
        System.out.println("3. Edit Grades by Student");
        System.out.println("4. Edit Grades by Course");
        System.out.println("0. --- Exit to Menu ---");
        System.out.println("Please enter a valid choice(1-4, 0 to Exit)");

    }

}
