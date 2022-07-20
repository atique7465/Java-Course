import org.firmata4j.ssd1306.SSD1306;

import java.util.TimerTask;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 9:06 PM
 */

public class CountTask extends TimerTask {

    private int countValue = 10;
    private int repeatCount = 3;
    private final SSD1306 theOledObject;

    // Constructor for CountTask
    public CountTask(SSD1306 aDisplayObject) {
        this.theOledObject = aDisplayObject;
    }

    @Override
    public void run() {
        // Fill the OLED memory with something to draw.
        theOledObject.getCanvas().clear(); // clear contents first.
        theOledObject.getCanvas().setTextsize(1);

        // Display Hello!
        theOledObject.getCanvas().drawString(0, 0, "Hello!");
        theOledObject.display();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theOledObject.getCanvas().clear();

        // Display Name
        theOledObject.getCanvas().drawString(0, 0, "I am Raj");
        theOledObject.display();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theOledObject.getCanvas().clear();

        // Display Counting Down
        theOledObject.getCanvas().drawString(0, 0, "Counting down from 10 to 0");
        theOledObject.display();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theOledObject.getCanvas().clear();

        // set text size double as default is 1
        theOledObject.getCanvas().setTextsize(2);

        // Display Count Down 10 - 0
        for (int i = countValue; i >= 0; i--) {
            theOledObject.getCanvas().drawString(0, 0, String.valueOf(i));
            theOledObject.display();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            theOledObject.getCanvas().clear();
        }

        repeatCount--;
        if (repeatCount == 0) {
            System.exit(0);
        }
    }

}
