package exercise9;

import exercise9.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:16 AM
 */

//exercise9.ParkingLot class with a property cars which is a List of car
public class ParkingLot {

    public List<Car> cars = new ArrayList<>(); //List of car


    /**
     * @param dateIn parking entry time of a car
     * @param make   car manufacturer name
     * @param color  car color
     * @param plate  car number plate info
     *               <p>
     *               Instantiate a exercise9.Car object by calling the exercise9.Car class constructor with the arguments, and add to the cars list
     */
    public void addCar(Date dateIn, String make, String color, String plate) {
        cars.add(new Car(dateIn, make, color, plate));
    }
}
