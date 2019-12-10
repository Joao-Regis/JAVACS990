package sample;

import java.io.*;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;


import java.util.Scanner;

public class Main extends Application
{
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        /*StudentRecordsFileManager sfile =
                new StudentRecordsFileManager("Students.dat");

        CourseRecordsFileManager cfile =
                new CourseRecordsFileManager("Courses.dat");

        EnrollmentRecordsFileManager efile =
                new EnrollmentRecordsFileManager("Enrollments.dat");*/

        Student student;
        Course course;
        Enrollment enrollment;




        Parent root = FXMLLoader.load(getClass().getResource("tabPaneHome.fxml"));
        primaryStage.setTitle("SIS CS990");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



}
