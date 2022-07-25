package lab10.part22;

import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

/**
 * @author atiQue
 * @since 22'Jul 2022 at 9:00 PM
 */

public class Part22 {
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

        // pin 14 to get input from potentiometer
        var potentiometerInputPin = myGroveBoard.getPin(Pins.A0);

        // pin 6 to get input from button
        var buttonObject = myGroveBoard.getPin(Pins.A6);
        buttonObject.setMode(Pin.Mode.INPUT);

        // Set up the OLED display(type, size ...)
        I2CDevice i2cObject = myGroveBoard.getI2CDevice(Pins.I2CO);
        SSD1306 myOledDisplay = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        myOledDisplay.init();
        myOledDisplay.getCanvas().setTextsize(2);

        myGroveBoard.addEventListener(new ButtonListener(ledObject, potentiometerInputPin, buttonObject, myOledDisplay));
    }


}
