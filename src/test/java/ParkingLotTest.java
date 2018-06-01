import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void  twoCarpark_should_parkLagerPark(){
        ParkingLot largerlog = new ParkingLot();
        ParkingLot smallerlog = new ParkingLot();
        largerlog.setMaxNoOfLot(3);
        smallerlog.setMaxNoOfLot(1);
        List<ParkingLot> Lots = new ArrayList<ParkingLot>();
        Lots.add(largerlog);
        Lots.add(smallerlog);
        ParkingBoy boy = new ParkingBoy(Lots);
        Assert.assertEquals(boy.findBestPackingLot().getRemainSpace(),largerlog.getRemainSpace());
    }

    @Test
    public void  twoCarpark_should_parkLagerParkByPersentage(){
        ParkingLot largerlog = new ParkingLot();
        ParkingLot smallerlog = new ParkingLot();
        Car car = new Car("AA1234","");
        Car car2 = new Car("AA1234","");
        largerlog.setMaxNoOfLot(3);
        smallerlog.setMaxNoOfLot(2);
        largerlog.park(car);
        smallerlog.park(car2);
        List<ParkingLot> Lots = new ArrayList<ParkingLot>();
        Lots.add(largerlog);
        Lots.add(smallerlog);
        ParkingBoy boy = new ParkingBoy(Lots);
        Assert.assertEquals(largerlog,boy.findBestParkingLotWithPersentage());
    }


}
