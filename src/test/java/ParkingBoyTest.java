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
}
