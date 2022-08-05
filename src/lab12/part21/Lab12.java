package lab12.part21;

import jm.util.Play;

/**
 * @author atiQue
 * @since 05'Aug 2022 at 9:26 PM
 */

public class Lab12 {
    public static void main(String[] args) {

        RandomMelody randomMelody = new RandomMelody("my music score");
        randomMelody.generateRandomNotes(2);

        Play.midi(randomMelody.getScore());
    }
}
