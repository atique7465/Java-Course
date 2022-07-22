package exercise9;

import java.util.Date;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:18 AM
 */

//exercise9.Car Class with five properties: dateIn, make, color, plate
public class Car {
    public Date dateIn;
    public String make;
    public String color;
    public String plate;

    //Constructor of exercise9.Car class. Have five arguments: Date dateIn, String make, String color, String plate
    public Car(Date dateIn, String make, String color, String plate) {
        this.dateIn = dateIn;
        this.make = make;
        this.color = color;
        this.plate = plate;
    }
}
