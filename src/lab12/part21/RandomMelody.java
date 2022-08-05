package lab12.part21;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import java.util.Random;

/**
 * @author atiQue
 * @since 05'Aug 2022 at 9:14 PM
 */

public class RandomMelody {

    private Score score;
    private Part part;
    private Phrase phrase;

    public RandomMelody(String scoreTitle) {
        Score score = new Score(scoreTitle);
        Part part = new Part("Snare", 0, 9);
        Phrase phrase = new Phrase(0.0);
        score.add(part);
        part.add(phrase);
        this.score = score;
        this.part = part;
        this.phrase = phrase;
    }

    public Score getScore() {
        return score;
    }

    public void generateRandomNotes(Integer maxInterval) {

        Random random = new Random();

        for (int i = 1; i <= 24; i++) {
            phrase.add(new Note(JMC.D2, random.nextDouble(maxInterval)));
        }
    }
}