import java.util.Date;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:18 AM
 */

public class Cars {

    public Date dateIn;
    public String make;
    public String color;
    public String plate;

    public Cars(Date dateIn, String make, String color, String plate) {
        this.dateIn = dateIn;
        this.make = make;
        this.color = color;
        this.plate = plate;
    }
}
