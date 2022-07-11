package StringAnalyzer;

import java.util.Vector;

public class SubStringFinder {
    public Vector<String> subStringElements = new Vector<>();
    public Vector<Integer> subStringIndex = new Vector<>();

    public SubStringFinder(String[] stringVec, String subString) {

        for (int i = 0; i < stringVec.length; i++) {
            if (stringVec[i].contains(subString)) {
                subStringElements.add(stringVec[i]);
                subStringIndex.add(i);
            }
        }
    }

}
