package lab9;

import java.util.TimerTask;

/**
 * @author atiQue
 * @since 18'Jul 2022 at 9:30 PM
 */

public class Something extends TimerTask {

    public static int i = 10;

    @Override
    public void run() {
        System.out.println("Hi atique...." + i--);
        if(i<0){
            System.exit(0);
        }
    }
}
