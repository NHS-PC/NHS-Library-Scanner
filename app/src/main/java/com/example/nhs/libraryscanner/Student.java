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
    // Assume that there will be an argument...probably will be String of decoded QR
    public void getDataFromQR()
    {
        // Code to write
        // Take first line of QR arg and set that to firstName and lastName (separted by spaces on first line)
        // Take second line, set to studentID
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
        return this.checkedIn;
    }

   public String toString() {
	return "Name: " + this.getFirstName() + " " + this.getLastName() + "\nID: " + this.getStudentID() + 
			"\nChecked IN/OUT Status: " + this.isCheckedIn();
   }

}
