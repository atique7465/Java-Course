package lab9;

import org.firmata4j.I2CDevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Timer;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 9:00 PM
 */

public class MainPart {

    static final byte I2CO = 0x3c;// OLED Display

    public static void main(String[] args) throws IOException, InterruptedException {
        var myUSBPort = "COM3";

        var device = new FirmataDevice(myUSBPort);
        device.start();
        device.ensureInitializationIsDone();

        // Set up the display(type, size ...)
        I2CDevice i2cObject = device.getI2CDevice((byte) I2CO);
        SSD1306 myOledDisplay = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        myOledDisplay.init();

        var task = new CountTask(myOledDisplay);

        new Timer().schedule(task, 0, 1000);
    }

}
