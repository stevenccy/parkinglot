import org.junit.Assert;
import org.junit.Test;

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

}
