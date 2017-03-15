package com.example.nhs.libraryscanner;

/**
 * Created by robotics on 2/8/17.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    //Student attributes index
    private static final int STUDENT_ID = 2;
    private static final int STUDENT_FNAME = 0;
    private static final int STUDENT_LNAME = 1;
    private static final int STUDENT_STATUS = 3;

    public static List readCSV(String fileName) {
        BufferedReader fileReader = null;
        //Create a new list of student to be filled by CSV file data
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill data
                    boolean statusConverted;
                    int status = Integer.parseInt(tokens[STUDENT_STATUS]);
                    if (status == 0) {
                        statusConverted = false; // Checked OUT
                    } else {
                        statusConverted = true; // Checked IN
                    }
                    Student student = new Student(tokens[STUDENT_FNAME], tokens[STUDENT_LNAME], tokens[STUDENT_ID], statusConverted);
                    students.add(student);
                }
            }

            //Print the new student list
            for (Student student : students) {
                System.out.println(student.toString());

            }
        } catch (Exception e) {

            System.out.println("Error in CsvFileReader !!!");

            e.printStackTrace();

        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }

        }
        return students;
    }
}

