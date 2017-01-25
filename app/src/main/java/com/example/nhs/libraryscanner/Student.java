package com.example.nhs.libraryscanner;

/**
 * Created by robotics on 1/25/17.
 */

import java.io.IOException;
import java.net.URL;



import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;



public class Student {

    private String firstName;
    private String lastName;
    private String studentID;
    private boolean checkedIn;

    // Constructor but also used for testing purposes
    public Student(String fn, String ln, String id, boolean status) {
        firstName = fn;
        lastName = ln;
        studentID = id;
        checkedIn = status;
    }

    // This method will fill a Student object with data from the QR code
    public void getDataFromQR()
    {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public boolean isCheckedIn() {
        boolean status = false;

        

        // Don't forget to set local object's checkedIn variable
        this.checkedIn = status;
        return this.checkedIn;
    }


}
