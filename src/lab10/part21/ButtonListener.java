package lab10.part21;

import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;

import java.io.IOException;

/**
 * @author atiQue
 * @since 22'Jul 2022 at 9:20 PM
 */

public class ButtonListener implements IODeviceEventListener {

    private final Pin ledPin;
    private final Pin buttonPin;

    public ButtonListener(Pin ledPin, Pin buttonPin) {
        this.ledPin = ledPin;
        this.buttonPin = buttonPin;
    }

    @Override
    public void onPinChange(IOEvent ioEvent) {
        if (ioEvent.getPin().getIndex() == buttonPin.getIndex()) {
            try {
                if (ledPin.getValue() == 0) {
                    ledPin.setValue(1);
                } else {
                    ledPin.setValue(0);
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
