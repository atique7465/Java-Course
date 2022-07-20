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
            File text = new File("logfile.txt");
            Scanner input = new Scanner(text);
            ParkingLot parkingCars = new ParkingLot();
            int countLines = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Date dd = strToDate(line.substring(29, 33).trim(), line.substring(35, 37).trim(), line.substring(37, 39).trim(),
                        line.substring(40, 42).trim(), line.substring(43, 45).trim(), line.substring(46, 48).trim());
                parkingCars.addCar(dd, line.substring(1, 10).trim(), line.substring(10, 19).trim(), line.substring(20, 28).trim());
                countLines++;
            }
            System.out.println(countLines);
            System.out.println(parkingCars.cars.get(2).dateIn);
            System.out.println(parkingCars.cars.get(3).make);
            System.out.println(parkingCars.cars.get(0).plate);
            System.out.println(parkingCars.cars.get(1).color);
        } catch (Exception e) {
            System.out.println("Something is wrong in reading the text file, Or in converting the string to date!");
        }
    }

    public static Date strToDate(String year, String month, String day, String hour, String minute, String second) throws ParseException {
        String dateStr = "" + day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second;
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return frmt.parse(dateStr);
    }
}
