import java.io.IOException;
import java.util.List;

public class MainActivity {
	
	public static void main(String[] args) {
    	List<Student> returnedList = DataReader.readCSV("src/main/resources/test.csv");
	
	// DEBUG -- print returned list of students
	for (Student s : returnedList) {
		System.out.println("\nDEBUG: \n" + s.toString());
	}

	
   	}
}
