import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParkingLotTest {

    @Test
    public void given_parkingLotHasNoSpace_should_notParkCar() {
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(0);

        ParkingBoy pBoy = new ParkingBoy(lot);
        Car car = new Car("AA1234","");

        lot.park(car);

        Assert.assertEquals(0,lot.getCars().size());
    }

}
