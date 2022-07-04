import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class lab07P2 {
    public static void main(String[] args)
            throws IOException, ParseException {
        String myPort = "COM3"; // modify for your own computer & setup.
        IODevice myGroveBoard = new FirmataDevice(myPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();
        } catch (Exception ex) {
            System.out.println("couldn't connect to board.");
        } finally {

            //get the alarm time
            Date alarmDate = getAlarmDate();

            // check every second & wait till alarm date-time have passed
            while (alarmDate.after(new Date())) {
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Thread sleep error while checking alarm date-time." + ex);
                }
            }

            // alarm have passed. need to start Arduino buzzer
            // pin 5 as buzzer
            var myBuzzer = myGroveBoard.getPin(5);
            myBuzzer.setMode(Pin.Mode.PWM);

            // pin 6 to get input to stop the buzzer
            var stopBuzzerButton = myGroveBoard.getPin(6);
            stopBuzzerButton.setMode(Pin.Mode.INPUT);

            int counter;
            // beeping for 30 times
            for (counter = 1; counter <= 30; counter++) {

                // check whether the stop buzzer button pressed for < .5 second, if pressed stop beeping immediately.
                if (stopBuzzerButton.getValue() == 1) {
                    break;
                }

                myBuzzer.setValue(20); // set the buzzer beep on for 100 milliseconds
                System.out.println("You have not waken up yet !");
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                    System.out.println("Thread sleep error while buzzer beep is on." + ex);
                }

                // check whether the stop buzzer button pressed for < .5 second, if pressed stop beeping immediately.
                if (stopBuzzerButton.getValue() == 1) {
                    break;
                }

                myBuzzer.setValue(-1); // set the buzzer beep off for 100 milliseconds
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                    System.out.println("Thread sleep error while buzzer beep is off." + ex);
                }
            }

            if (counter < 30) {
                System.out.println("You waked up at " + new Date());
            } else {
                System.out.println("You did not wake up on time by " + new Date());
            }

            // stop the board
            myGroveBoard.stop(); // finish with the board.
            System.out.println("Board stopped.");
        }
    }

    public static Date getAlarmDate() throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("This program uses Arduino board to act as an alarm clock.");
        System.out.println("Below, you can enter your desire date and time to set an alaram.");
        String dateStr;
        Date DT;
        while (true) {
            System.out.print("Enter four digits the year (e.g. 2022): ");
            int year = input.nextInt();
            System.out.print("Enter two digits the month (e.g. 06): ");
            int mm = input.nextInt();
            System.out.print("Enter two digits the day (e.g. 28): ");
            int dd = input.nextInt();
            System.out.print("Enter two digits the hour (e.g. 07): ");
            int HH = input.nextInt();
            System.out.print("Enter two digits the minutes (e.g. 12): ");
            int MM = input.nextInt();
            System.out.print("Enter two digits the second (e.g. 52): ");
            int SS = input.nextInt();
            if (!(year < 2022 || mm > 59 || mm < 0 || dd < 0 || dd > 31 || HH < 0 || HH > 24 || MM < 0 || MM > 59 || SS < 0 || SS > 59)) {
                dateStr = "" + dd + "/" + mm + "/" + year + " " + HH + ":" + MM + ":" + SS;
                SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                DT = frmt.parse(dateStr);
                Date NOW = new Date();
                if (NOW.before(DT)) {
                    System.out.println("The entered alarm time is " + DT);
                    break;
                }
            }
            System.out.println("The entered date is not correct. Please reenter your desire date");
        }
        return DT;
    }

}
