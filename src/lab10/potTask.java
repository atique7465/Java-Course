package lab10;

import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 9:06 PM
 */

public class potTask extends TimerTask {
    private final SSD1306 display;
    private final Pin potentiometerInputPin;
    private final Pin stopPin;

    // Constructor for lab10.potTask
    public potTask(SSD1306 display, Pin potentiometerInputPin, Pin stopButton) {
        this.display = display;
        this.potentiometerInputPin = potentiometerInputPin;
        this.stopPin = stopButton;
    }

    @Override
    public void run() {

        if (stopPin.getValue() == 0) {
            System.exit(0);
        }

        String potValue = String.valueOf(potentiometerInputPin.getValue());
        System.out.println("Pot is " + potValue);

        display.getCanvas().clear();
        display.getCanvas().drawString(0, 0, potValue);

        double factor = 128.0 / 2000.0;
        int length = (int) (Integer.parseInt(potValue) * factor);
        if (!potValue.equals("0")) {
            display.getCanvas().drawHorizontalLine(0, 20, length, MonochromeCanvas.Color.BRIGHT);
        }

        display.display();
        display.getCanvas().clear();

        display.getCanvas().drawString(0, 0, "");
        display.getCanvas().drawHorizontalLine(0, 20, length, MonochromeCanvas.Color.DARK);
        display.display();
    }

}
