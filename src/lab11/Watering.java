package lab11;

import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author atiQue
 * @since 25'Jul 2022 at 11:50 PM
 */

public class Watering {

    private static final long MOISTURE_THRESHOLD = 758;
    private static String logs = "";

    public static void process() throws IOException, InterruptedException {

        logs += getCurrentDateTime() + "  " + "Starting the Watering Process.\n";

        String myPort = "COM3";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        myGroveBoard.start();
        myGroveBoard.ensureInitializationIsDone();
        System.out.println("Arduino Board Started for Watering Process.");

        // Moisture Sensor
        var moistureSensorPin = myGroveBoard.getPin(Pins.A2);

        // Mosfet
        var mosfetPin = myGroveBoard.getPin(Pins.D7);

        int wateringSeconds = 0;
        long currentMoisture = moistureSensorPin.getValue();
        logs += getCurrentDateTime() + "  " + "The moisture level is " + currentMoisture + " .\n";

        while (currentMoisture < MOISTURE_THRESHOLD) {
            if (wateringSeconds == 0) {
                logs += getCurrentDateTime() + "  " + "The moisture level is low, watering for 2 seconds.\n";
            } else {
                logs += getCurrentDateTime() + "  " + "The moisture level is still low, watering for 2 seconds.\n";
            }

            mosfetPin.setValue(1);
            Thread.sleep(2000);
            mosfetPin.setValue(0);
            wateringSeconds = wateringSeconds + 2;

            Thread.sleep(20000);
            currentMoisture = moistureSensorPin.getValue();
        }

        logs += getCurrentDateTime() + "  " + "The moisture level is now sufficient, after " + wateringSeconds + " seconds of watering.\n";

        myGroveBoard.stop();
        System.out.println("Arduino Board Stopped. End of Watering Process.");
    }

    public static String processLog() {
        return logs;
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
