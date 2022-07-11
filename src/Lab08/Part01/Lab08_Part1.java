package Lab08.Part01;
/* The Lab08.Part01 package includes an App class (Lab08_Part1) which main method uses the SubStringFinder class from
   the StringAnalyzer package. You should develop the StringAnalyzer package and place it in the source (src) folder
   of the Lab08-Part1 project.
*/

import StringAnalyzer.SubStringFinder;

public class Lab08_Part1 {
    /* The below main method finds elements contain a desire string (e.g. "site") from a string vector, and prints
       the total number of detected elements, the indices of the detected elements, and the values of the
       detected elements in the console.
    */
    public static void main(String[] args) {
        /* A sample string vector is declared below as: */
        String[] stringVec = {"creations", "magazine", "identity", "effectively",
                "website", "judgements", "thesaurus", "opposite"};
        /* We are looking for the elements contain "site" from the above vector. */
        String subString = "site";
        /* creating an object from the SubStringFinder class of StringAnalyzer package. */
        SubStringFinder VEC = new SubStringFinder(stringVec, subString);
        /* printing the outputs in the console. */
        System.out.println("The provided sample string vector has " + VEC.subStringElements.size() +
                " elements contain \"" + subString + "\".");
        System.out.println("The indices if those elements in the provided sample vector are:");
        for (int i = 0; i < VEC.subStringElements.size(); i++) {
            System.out.println(VEC.subStringIndex.get(i));
        }
        System.out.println("The detected elements are:");
        for (int i = 0; i < VEC.subStringElements.size(); i++) {
            System.out.println(VEC.subStringElements.get(i));
        }
        /* Hint:
           From lines 24 and 26 you can see that the outputs of the subStringIndex and subStringElements methods
           are vectors. If you are creating a vector with an unknown size at the time of declaration, one way is to
           use the Vector class from the java.util package. To develop the SubStringFinder class here, use the
           java.util.Vector class methods (e.g. Vector.get and Vector.elementAt might be useful).

           To include an additional package to your project, you can right-click on the src folder of your project and
           add a new package. note that if you want a class in that package to be accessible in other packages, the
           level of access for the class and its entities should be public when declared. The access level modifiers
           will be discussed later in more detail, but check what happens if you remove public or change it to protected.

           The method contains from the String class might be useful.

           If the SubStringFinder class of the StringAnalyzer package develops correctly, the following output should
           be printed in the console.
         */
    }
}
