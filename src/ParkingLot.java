import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author atiQue
 * @since 21'Jul 2022 at 12:16 AM
 */

public class ParkingLot {

    public List<Cars> cars = new ArrayList<>();

    public void addCar(Date dateIn, String make, String color, String plate) {
        cars.add(new Cars(dateIn, make, color, plate));
    }
}
