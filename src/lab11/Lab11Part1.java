package lab11;

import java.io.IOException;

/**
 * @author atiQue
 * @since 25'Jul 2022 at 11:49 PM
 */

public class Lab11Part1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Watering.process();
        System.out.println(Watering.processLog());
    }
}
