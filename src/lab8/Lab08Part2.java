package lab8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @author atiQue
 * @since 11'Jul 2022 at 1:17 PM
 */

public class Lab08Part2 {
    public static void main(String[] args) {

        try {
            // Step 1. Name the file and create a File object
            var theAirQualityFile = new File("CO2_Inaput.csv");

            // Step 2. Read all lines in the file object
            var fixedLengthList = Files.readAllLines(theAirQualityFile.toPath());

            // Step 3. copy fixed list to ArrayList
            ArrayList<String> listOfSting = new ArrayList<String>(fixedLengthList);

            // Step 4. Create numeric variables to hold totals, increments, etc.
            double co2Sum = 0.0;
            double temperatureSum = 0.0;
            double humiditySum = 0.0;
            int elementCount = 0;

            for (String stringLine : listOfSting) {
                // to skip the wrong configured lines at the end of the csv file
                if (stringLine.equals(",,,,,")) {
                    break;
                }

                String[] splitString = stringLine.split(",");

                co2Sum = co2Sum + Double.parseDouble(splitString[2]);
                temperatureSum = temperatureSum + Double.parseDouble(splitString[3]);
                humiditySum = humiditySum + Double.parseDouble(splitString[4]);

                elementCount++;
            }

            System.out.println("CO2 average " + co2Sum / elementCount + ".");
            System.out.println("Temperature average " + temperatureSum / elementCount + ".");
            System.out.println("Humidity average " + humiditySum / elementCount + ".");

        } catch (IOException ex) {
            System.out.println("File reading exception");
        }
    }
}
