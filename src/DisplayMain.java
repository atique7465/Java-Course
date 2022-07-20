import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Timer;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 9:53 PM
 */

public class DisplayMain {

    // Pin definition(assuming Nano or UNO)
    static final byte I2CO = 0x3C;// OLED Display
    static final int A0 = 14;// Potentiometer
    static final int A2 = 16;// Sound
    static final int A6 = 6;// Button
    static final int D4 = 4;// LED

    public static void main(String[] args) throws IOException, InterruptedException {
        var device = new FirmataDevice("COM3");
        device.start();
        device.ensureInitializationIsDone();

        // pin 14 to get input from potentiometer
        var potentiometerInputPin = device.getPin(A0);
        potentiometerInputPin.setMode(Pin.Mode.INPUT);

        // pin 6 to get input to stop the task
        var stopButton = device.getPin(6);
        stopButton.setMode(Pin.Mode.INPUT);

        // Set up the OLED display(type, size ...)
        I2CDevice i2cObject = device.getI2CDevice((byte) I2CO);
        SSD1306 myOledDisplay = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        myOledDisplay.init();

        var task = new potTask(myOledDisplay, potentiometerInputPin, stopButton);
        new Timer().schedule(task, 0, 1000);
    }
}
