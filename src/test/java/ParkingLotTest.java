import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class ParkingLotTest {

    public static String CAR_PLATE_NUMBER = "AA1234";
    public static String CAR_PLATE_NUMBER_1 = "AB1234";


    @Test
    public void given_parkingLotHasNoSpace_should_notParkCar() {
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(0);

        Car car = new Car(CAR_PLATE_NUMBER,"");

        lot.park(car);

        Assert.assertEquals(0,lot.getCars().size());
    }

    @Test
    public void given_parkingLotHasFiveSpace_should_parkCar(){
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(5);

        Car car = new Car(CAR_PLATE_NUMBER,"");

        lot.park(car);

        Assert.assertEquals(1,lot.getCars().size());
    }

    @Test
    public void given_parkingLotAlreadyHasSameCar_should_notParkCar(){
        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(5);

        Car car = new Car(CAR_PLATE_NUMBER,"");

        lot.park(car);

        lot.park(car);

        Assert.assertEquals(1,lot.getCars().size());
    }

    @Test
    public void given_differentCarPlate_should_returnMatchNotFound(){
        Car car1 = new Car(CAR_PLATE_NUMBER,"");
        Car car2 = new Car(CAR_PLATE_NUMBER_1,"");

        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(5);
        lot.park(car1);

        Assert.assertEquals(false,lot.hasSameCar(car2));
    }

    @Test
    public void given_sameCarPlate_should_returnMatchFound(){
        Car car1 = new Car(CAR_PLATE_NUMBER,"");
        Car car2 = new Car(CAR_PLATE_NUMBER,"");

        ParkingLot lot = new ParkingLot();
        lot.setMaxNoOfLot(5);
        lot.park(car1);

        Assert.assertEquals(true,lot.hasSameCar(car2));
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
