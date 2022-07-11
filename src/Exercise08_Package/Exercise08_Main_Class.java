package Exercise08_Package;

import java.io.FileReader;

import com.opencsv.CSVReader;

/**
 * @author atiQue
 * @since 11'Jul 2022 at 1:17 PM
 */

public class Exercise08_Main_Class {
    public static void main(String[] args) {
        // try-catch is used in case reading the file fails.
        try {
            // read the file.
            FileReader readMyFileObject = new FileReader("Exercise08_Input.csv");
            CSVReader csvReaderObject = new CSVReader(readMyFileObject, ',');

            double sum = 0.0;
            int elementCount = 0;
            // read one line at a time in the CSV
            String[] oneLineRecord;
            while ((oneLineRecord = csvReaderObject.readNext()) != null) {

                if (!oneLineRecord[7].equals("")) {
                    sum = sum + Double.parseDouble(oneLineRecord[7]);
                    elementCount++;
                }
            }

            System.out.println("Total number of column 8 elements is " + elementCount + ".");
            System.out.println("The average of column 8 is " + sum / elementCount + ".");

            csvReaderObject.close();
            readMyFileObject.close();

        } catch (Exception ex) {
            System.out.println("Exception reading the file!");
        }
    }
}
