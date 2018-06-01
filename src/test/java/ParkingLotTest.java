import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLotTest {

    @Test
    public void given_parkingLotHasNoSpace_should_notParkCar() {
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(0);

        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot));
        Car car = new Car("AA1234","");

        lot.park(car);

        Assert.assertEquals(0,lot.getCars().size());
    }

    @Test
    public void given_parkingLotHas5Space_should_parkCar(){
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(5);

        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot));
        Car car = new Car("AA1234","");

        lot.park(car);

        Assert.assertEquals(1,lot.getCars().size());
    }

}
