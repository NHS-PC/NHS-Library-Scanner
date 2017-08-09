import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // CSV file header
    private static final String FILE_HEADER = "firstName,lastName,id,status";

    // Student attributes index
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

            /*//Print the new student list
            for (Student student : students) {
                System.out.println("DEBUG: " + student.toString() + "\n");

            }*/
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
    public static void writeCSV(String fileName, List<Student> students) {
    	FileWriter fw = null;

		try {
	    	fw = new FileWriter(fileName);
	    
	    	fw.append(FILE_HEADER.toString());
	    	fw.append(NEW_LINE_SEPARATOR);
   	    
	    	for (Student s : students) {
	    		fw.append(s.getFirstName());
			fw.append(COMMA_DELIMITER);
			fw.append(s.getLastName());
			fw.append(COMMA_DELIMITER);
			fw.append(s.getStudentID());
			fw.append(COMMA_DELIMITER);
		
			// Convert boolean status --> integer
			int status;
			if (s.isCheckedIn() == false) {
		  	  status = 0; // Checked OUT
			} else {
		  	  status = 1; // Checked IN
			}
			fw.append(String.valueOf(status));
			fw.append(NEW_LINE_SEPARATOR);
	    	}
		} catch (Exception e) {
			System.out.println("Error in File writing...");
			e.printStackTrace();
		} finally {
	     	try {
		    	fw.flush();
   		    	fw.close();
			} catch (IOException e) {
		    	System.out.println("Error flushing...");
		    	e.printStackTrace();
			}
		}
	}
	/*public static void uploadData(String fileName) {
		File fileMetadata = new File();
        fileMetadata.setName("test.csv");
        java.io.File filePath = new java.io.File("src/main/resources/test.csv");
        FileContent mediaContent = new FileContent("file/csv", filePath);
        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
	}*/
}

