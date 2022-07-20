import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 8:35 PM
 */

public class Lab09Part21Oled {

    public static void main(String[] args) throws IOException, InterruptedException {
        String myUsb = "COM3";

        IODevice theArduinoObject = new FirmataDevice(myUsb);
        theArduinoObject.start();
        theArduinoObject.ensureInitializationIsDone();

        I2CDevice i2cObject = theArduinoObject.getI2CDevice((byte) 0x3C);
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);

        theOledObject.init();

        theOledObject.getCanvas().drawString(0, 0, "Hello");
        theOledObject.display();
        Thread.sleep(2000);
        theOledObject.getCanvas().clear();

        theOledObject.getCanvas().drawString(64, 0, "First Name");
        theOledObject.display();
        Thread.sleep(2000);
        theOledObject.getCanvas().clear();

        theOledObject.getCanvas().drawString(64, 0, "Last Name");
        theOledObject.display();
        Thread.sleep(2000);
        theOledObject.getCanvas().clear();

        theOledObject.getCanvas().drawString(64, 0, "12345");
        theOledObject.display();
        Thread.sleep(2000);

        theArduinoObject.stop();
    }

}
