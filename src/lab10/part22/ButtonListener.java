package lab10.part22;

import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

/**
 * @author atiQue
 * @since 22'Jul 2022 at 9:20 PM
 */

public class ButtonListener implements IODeviceEventListener {

    private final Pin ledPin;
    private final Pin potentiometerInputPin;
    private final Pin buttonPin;
    private final SSD1306 oledDisplay;

    public ButtonListener(Pin ledPin, Pin potentiometerInputPin, Pin buttonPin, SSD1306 oledDisplay) {
        this.ledPin = ledPin;
        this.potentiometerInputPin = potentiometerInputPin;
        this.buttonPin = buttonPin;
        this.oledDisplay = oledDisplay;
    }

    @Override
    public void onPinChange(IOEvent ioEvent) {
        if (ioEvent.getPin().getIndex() == buttonPin.getIndex()) {
            try {
                if (ledPin.getValue() == 0) {
                    ledPin.setValue(1);

                    long potentiometerValue = potentiometerInputPin.getValue();
                    oledDisplay.getCanvas().clear();
                    oledDisplay.getCanvas().drawString(0, 0, "Pot: " + potentiometerValue);
                    oledDisplay.display();

                    System.out.println("LED is on & Potentiometer value (" + potentiometerValue + ") is on the board's OLED");
                } else {
                    ledPin.setValue(0);

                    oledDisplay.getCanvas().clear();
                    oledDisplay.getCanvas().drawString(0, 0, "");
                    oledDisplay.display();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStart(IOEvent ioEvent) {
    }

    @Override
    public void onStop(IOEvent ioEvent) {
    }

    @Override
    public void onMessageReceive(IOEvent ioEvent, String s) {
    }
}
