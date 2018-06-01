import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingBoyTest {
    public static int TEN = 10;
    public static int FIVE = 5;
    public static String CAR_PLATE_NUMBER = "AA1234";

    @Test
    public void given_twoParkingLots_when_firstLotHasMoreSpace_Should_decidedToParkInLotWithMoreSpace() {
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(TEN);
        ParkingLot lot2 = new ParkingLot();
        lot2.setMaxNoOfLot(FIVE);

        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot,lot2));
        ParkingLot bestLog = pBoy.findBestPackingLot();

        Assert.assertEquals(lot,bestLog);
    }

    @Test
    public void given_twoParkingLots_when_bothHasSameSize_Should_parkInFirstOne(){
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(TEN);
        ParkingLot lot2 = new ParkingLot();
        lot2.setMaxNoOfLot(TEN);

        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot,lot2));
        ParkingLot bestLog = pBoy.findBestPackingLot();

        Assert.assertEquals(lot,bestLog);
    }

    @Test
    public void managerTesting(){
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(TEN);
        Car car1 = new Car("CarA" , "");
        lot.park(car1);
        ParkingLot lot2 = new ParkingLot();
        Car car2 = new Car("CarB" , "");
        lot2.setMaxNoOfLot(TEN);
        lot2.park(car2);

        ParkingLot lot3 = new ParkingLot();
        lot3.setMaxNoOfLot(TEN);
        Car car3 = new Car("CarC" , "");
        lot3.park(car3);
        ParkingLot lot4 = new ParkingLot();
        lot4.setMaxNoOfLot(FIVE);
        Car car4 = new Car("CarD" , "");
        lot4.park(car4);

        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot3,lot4));

        ParkingManager manager = new ParkingManager(Arrays.asList(lot,lot2));
        ParkingDirector director = new ParkingDirector(Arrays.asList(manager) ,Arrays.asList(pBoy));
        director.showReport(Arrays.asList(manager), Arrays.asList(pBoy));
    }

    @Test
    public void same_car_parking(){
        Car car = new Car(CAR_PLATE_NUMBER,"");
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(TEN);
        ParkingBoy pBoy = new ParkingBoy(Arrays.asList(lot));
        lot.park(car);
        lot.park(car);
        Assert.assertEquals(lot.getRemainSpace(),9);
    }
    @Test
    public void unPark_same_car(){
        Car car = new Car(CAR_PLATE_NUMBER,"");
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(TEN);
        lot.unPark(car);
        Assert.assertEquals(lot.getRemainSpace(),10);
    }
}
