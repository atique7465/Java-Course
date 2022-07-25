package lab10.part21;

import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;

/**
 * @author atiQue
 * @since 22'Jul 2022 at 9:00 PM
 */

public class Part21 {
    public static void main(String[] args) throws IOException, InterruptedException {

        String myPort = "COM3";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        myGroveBoard.start();
        myGroveBoard.ensureInitializationIsDone();
        System.out.println("Board started.");

        // pin 4 for LED
        var ledObject = myGroveBoard.getPin(Pins.D4);
        ledObject.setMode(Pin.Mode.OUTPUT);
        ledObject.setValue(0); //turn off the LED

        // pin 6 to get input from button
        var buttonObject = myGroveBoard.getPin(Pins.A6);
        buttonObject.setMode(Pin.Mode.INPUT);

        myGroveBoard.addEventListener(new ButtonListener(ledObject, buttonObject));
    }


}
