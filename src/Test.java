import lab9.Something;

import java.util.Timer;

public class Test {
    public static void main(String[] args) {

        var task = new Something();

        new Timer().schedule(task, 5000, 1000);
    }
}
