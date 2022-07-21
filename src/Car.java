import java.util.Date;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:18 AM
 */

//Car Class with five properties: dateIn, make, color, plate
public class Car {
    public Date dateIn;
    public String make;
    public String color;
    public String plate;

    //Constructor of Car class. Have five arguments: Date dateIn, String make, String color, String plate
    public Car(Date dateIn, String make, String color, String plate) {
        this.dateIn = dateIn;
        this.make = make;
        this.color = color;
        this.plate = plate;
    }
}
