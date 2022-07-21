import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:02 AM
 */

public class Exercise09Class {
    public static void main(String[] args) {
        try {
            File text = new File("logfile.txt"); //Create File object by logfile.txt file location
            Scanner input = new Scanner(text); //create Scanner object using that text file object to read the lines

            ParkingLot parkingCars = new ParkingLot(); //Create an ParkingLot object
            int countLines = 0; //initiate a line counter
            while (input.hasNextLine()) { //start the while loop with a condition that the file has another line

                String line = input.nextLine(); //read the line

                //as " Nissan    Black    BDKK-863 2020  2 24  9  0  0" this line has parking lot entry time between 29 and 48 position of the line
                //we separated the values using subString() function with appropriate positions [year, month, day, hour, minute, second]
                //called strToDate() function to get the entry time as Date object
                Date dd = strToDate(line.substring(29, 33).trim(), line.substring(35, 37).trim(), line.substring(37, 39).trim(),
                        line.substring(40, 42).trim(), line.substring(43, 45).trim(), line.substring(46, 48).trim());

                //as " Nissan    Black    BDKK-863 2020  2 24  9  0  0" this line has car info between 1 and 28 position of the line
                //we separated the values using subString() function with appropriate positions [Manufacturer Name, Car Color, Car Number Plate]
                //called addCar() function of parkingCars object with the car info and entry time
                parkingCars.addCar(dd, line.substring(1, 10).trim(), line.substring(10, 19).trim(), line.substring(20, 28).trim());

                countLines++; //increment the line counter by 1
            }

            System.out.println(countLines); //print the line count
            System.out.println(parkingCars.cars.get(2).dateIn); //print the parking entry time of car 3 in console
            System.out.println(parkingCars.cars.get(3).make); //print the Manufacturer Name of car 4 in console
            System.out.println(parkingCars.cars.get(0).plate); //print the Number Plate info of car 1 in console
            System.out.println(parkingCars.cars.get(1).color); //print the color of car 2 in console

        } catch (Exception e) { //This try may throw IOException for file read and ParseException from strToDate function. Both extends Exception. So we caught Exception in catch block to cover both oof them.
            System.out.println("Something is wrong in reading the text file, Or in converting the string to date!"); //just print exception description in console.
        }
    }

    /**
     * @param year   entry year
     * @param month  entry month
     * @param day    entry day
     * @param hour   entry hour
     * @param minute entry minute
     * @param second entry second
     * @return the Date object from the input params
     * @throws ParseException
     */
    public static Date strToDate(String year, String month, String day, String hour, String minute, String second) throws ParseException {

        String dateStr = "" + day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second; //Create the formatted dateStr by concatenating the params

        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //create an object of SimpleDateFormat with dateStr pattern/format

        return frmt.parse(dateStr); //parse the Date from dateStr
    }
}


/*
ParkingLot -> List< Car > carList -> get() -> dateIn
                                                                           Cars -> dateIn
                                                                           Cars -> make
                                                                           Cars -> plate
                                                                           Cars -> color
 */