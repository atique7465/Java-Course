package lab12.part22;

import jm.JMC;

/**
 * @author atiQue
 * @since 05'Aug 2022 at 9:26 PM
 */

public class Lab12 {
    public static void main(String[] args) {

        RandomMelody rm = new RandomMelody("Raj");//Pass your name
        rm.generateRandomNotes(2);

        //include 24 pitches of a song you would like to play
        int[] pitchArray = {
                JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5,
                JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5, JMC.A5, JMC.G5, JMC.G5,
                JMC.A5, JMC.G5, JMC.G5, JMC.A5};

        double[] intervalArray = {JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN,
                JMC.QN, JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN,
                JMC.TN, JMC.TN, JMC.QN, JMC.TN, JMC.TN, JMC.QN};

        rm.addASong(JMC.PIANO, pitchArray, intervalArray);
        rm.play();
    }
}
