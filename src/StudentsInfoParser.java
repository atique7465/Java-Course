import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author atiQue
 * @since 11'Jul 2022 at 11:41 PM
 */

public class StudentsInfoParser {
    public static void main(String[] args) {

        try {
            //creating File instance to reference StudentsInfo.txt
            File studentInfoFile = new File("StudentsInfo.txt");

            //creating Scanner instance to read from file
            Scanner scanner = new Scanner(studentInfoFile);

            //reading each line and process them until no line found
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split("; ");

                String name = "";
                String gpa = "";
                for (String element : splitLine) {
                    if (element.contains("Name")) {
                        name = element.substring(6);
                    } else if (element.contains("GPA")) {
                        gpa = element.substring(5);
                    }
                }

                System.out.println(name + "'s GPA is " + gpa + ".");
            }

        } catch (IOException e) {
            System.out.println("Error occurred while reading from file!");
        }
    }
}
